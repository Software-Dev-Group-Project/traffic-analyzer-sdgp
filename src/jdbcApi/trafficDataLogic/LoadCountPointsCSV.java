package jdbcApi.trafficDataLogic;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class LoadCountPointsCSV {

    public static void main(String[] args) {
        
        Connection conn = ConnectTrafficDB.getConnection();
        Statement stmt= null;
        
        try {
            FileInputStream fstream = new FileInputStream("./traffic_csv_data/count_points.csv");
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
            
            // Iterate through all records splitting values
            for (itr = allRecords.iterator(); itr.hasNext();) {
                String row = itr.next().toString();
                String[] splitValues = row.split(",");
                // Take only unique values
                if (!uniqueRecords.contains(splitValues[0])) {
                    uniqueRecords.add(splitValues[0]);
                    int count_point_id = Integer.parseInt(splitValues[0]);
                    double latitude = Double.parseDouble(splitValues[1]);
                    double longitude = Double.parseDouble(splitValues[2]);
                    int easting = Integer.parseInt(splitValues[3]);
                    int northing = Integer.parseInt(splitValues[4]);
                    // Prevent error due to empty strings
                    String start_junction_road_name;
                    if (splitValues[5].isEmpty()) {
                        start_junction_road_name = "x";
                    } else {
                        start_junction_road_name = splitValues[5];
                    }
                    String end_junction_road_name;
                    if (splitValues[6].isEmpty()) {
                        end_junction_road_name = "x";
                    } else {
                        end_junction_road_name = splitValues[6];
                    }
                    double link_length_km;
                    if (splitValues[7].isEmpty()) {
                        link_length_km = 0.0;
                    } else {
                        link_length_km = Double.parseDouble(splitValues[7]);
                    }
                    double link_length_miles;
                    if (splitValues[8].isEmpty()) {
                        link_length_miles = 0.0;
                    } else {
                        link_length_miles = Double.parseDouble(splitValues[7]);
                    }
                    int road_id = Integer.parseInt(splitValues[9]);
                    // Build SQL query String
                    String sqlQuery = "\nINSERT INTO CountPoint (count_point_id, latitude, longitude, easting, northing, start_junction_road_name, end_junction_road_name, link_length_km, link_length_miles, road_id) \nVALUES"
                            + " ('" + count_point_id + "','" + latitude + "','" + longitude + "','" + easting + "','" + northing + "','" + start_junction_road_name + "','" + end_junction_road_name + "','" + link_length_km + "','" + link_length_miles + "','" + road_id + "')";
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