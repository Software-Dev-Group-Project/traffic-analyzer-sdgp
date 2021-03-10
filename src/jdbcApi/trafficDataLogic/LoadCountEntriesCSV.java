package jdbcApi.trafficDataLogic;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class LoadCountEntriesCSV {

    public static void main(String[] args) {
        
        Connection conn = ConnectTrafficDB.getConnection();
        Statement stmt= null;
        
        try {
            FileInputStream fstream = new FileInputStream("./traffic_csv_data/count_entries.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String stringLine;
            ArrayList allRecords = new ArrayList();
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
                
                String entry_year = splitValues[0];
                String count_date = splitValues[1];
                int entry_hour = Integer.parseInt(splitValues[2]);
                String direction_of_travel = splitValues[3];
                int pedal_cycles = Integer.parseInt(splitValues[4]);
                int two_wheeled_motor_vehicles = Integer.parseInt(splitValues[5]);
                int cars_and_taxis = Integer.parseInt(splitValues[6]);
                int buses_and_coaches = Integer.parseInt(splitValues[7]);
                int lgvs = Integer.parseInt(splitValues[8]);
                int hgvs_2_rigid_axle = Integer.parseInt(splitValues[9]);
                int hgvs_3_rigid_axle = Integer.parseInt(splitValues[10]);
                int hgvs_4_or_more_rigid_axle = Integer.parseInt(splitValues[11]);
                int hgvs_3_or_4_articulated_axle = Integer.parseInt(splitValues[12]);
                int hgvs_5_articulated_axle = Integer.parseInt(splitValues[13]);
                int hgvs_6_articulated_axle = Integer.parseInt(splitValues[14]);
                int all_hgvs = Integer.parseInt(splitValues[15]);
                int all_motor_vehicles = Integer.parseInt(splitValues[16]);
                int count_point_id = Integer.parseInt(splitValues[17]);
                
                // Build the SQL query
                String sqlQuery = "\nINSERT INTO CountEntry (count_entry_id, entry_year,count_date,entry_hour,direction_of_travel,pedal_cycles,two_wheeled_motor_vehicles,cars_and_taxis,buses_and_coaches,lgvs,hgvs_2_rigid_axle,hgvs_3_rigid_axle,hgvs_4_or_more_rigid_axle,hgvs_3_or_4_articulated_axle,hgvs_5_articulated_axle,hgvs_6_articulated_axle,all_hgvs,all_motor_vehicles,count_point_id) \nVALUES"
                        + " ( NULL,'" + entry_year + "','" + count_date + "','" + entry_hour + "','" + direction_of_travel + "','" + pedal_cycles + "','" + two_wheeled_motor_vehicles + "','" + cars_and_taxis + "','" + buses_and_coaches + "','" + lgvs + "','" + hgvs_2_rigid_axle + "','" + hgvs_3_rigid_axle + "','" + hgvs_4_or_more_rigid_axle + "','" + hgvs_3_or_4_articulated_axle + "','" + hgvs_5_articulated_axle + "','" + hgvs_6_articulated_axle + "','" + all_hgvs + "','" + all_motor_vehicles + "','" + count_point_id + "')";
                // Confirm SQL query is correct
                System.out.println("SQL query : "+ sqlQuery);

                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                stmt.executeUpdate(sqlQuery);
                stmt.close();
                conn.commit();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}