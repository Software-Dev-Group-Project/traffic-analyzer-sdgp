package jdbcApi.trafficDataLogic;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class LoadRoadsCSV {

    public static void main(String[] args) {
        
        Connection conn = ConnectTrafficDB.getConnection();
        Statement stmt= null;
        
        try {
            FileInputStream fstream = new FileInputStream("./traffic_csv_data/roads.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String stringLine;
            ArrayList allRecords = new ArrayList();
            ArrayList uniqueRecords = new ArrayList();
            int count = 0;
            while ((stringLine = br.readLine()) != null) {
                allRecords.add(stringLine);
                count++;
            }
            System.out.println("No of records: " + (count - 1));
            
            allRecords.remove(0); // Remove first line containing column names
            Iterator itr;
            for (itr = allRecords.iterator(); itr.hasNext();) {
                String row = itr.next().toString();
                String[] splitValues = row.split(",");

                if (!uniqueRecords.contains(splitValues[0])) {
                    uniqueRecords.add(splitValues[0]);
                    String road_name = splitValues[0];
                    String road_type = splitValues[1];
                    int local_authority_id = Integer.parseInt(splitValues[2]);
                    String sqlQuery = "\nINSERT INTO Road (road_id, road_name, road_type, local_authority_id) \nVALUES"
                            + " ( NULL,'" + road_name + "','" + road_type + "','" + local_authority_id + "')";
                    // Confirm SQL query is correct
                    System.out.println("SQL query : "+ sqlQuery);
                    
                    conn.setAutoCommit(false);
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sqlQuery);
                    stmt.close();
                    conn.commit();

                } else {
                    System.out.println("duplicate record, with pk :" + splitValues[0]);
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}