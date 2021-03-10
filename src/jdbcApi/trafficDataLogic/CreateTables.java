package jdbcApi.trafficDataLogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    public static void main(String[] args) {
        Connection conn = ConnectTrafficDB.getConnection();
        Statement statement = null;
        String sqlQuery;
        
        // Query for all tables as in the Logical ERD
        sqlQuery = "DROP TABLE IF EXISTS Region;\n" +
                    "DROP TABLE IF EXISTS LocalAuthority;\n" +
                    "DROP TABLE IF EXISTS Road;\n" +
                    "DROP TABLE IF EXISTS CountPoint;\n" +
                    "DROP TABLE IF EXISTS CountEntry;\n" +
                    "CREATE TABLE Region\n" +
                    "(\n" +
                    "	region_id int(1),\n" +
                    "	region_name varchar(30) not null,\n" +
                    "	constraint r_rid_pk primary key (region_id)\n" +
                    ");\n" +
                    "CREATE TABLE LocalAuthority\n" +
                    "(\n" +
                    "	local_authority_id int(3),\n" +
                    "	local_authority_name varchar(30) not null,\n" +
                    "	region_id int(1),\n" +
                    "	constraint la_laid_pk primary key (local_authority_id),\n" +
                    "	constraint la_rid_fk foreign key (region_id) references Region(region_id)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE Road\n" +
                    "(\n" +
                    "	road_id INTEGER PRIMARY KEY,\n" +
                    "	road_name varchar(30) not null,\n" +
                    "	road_type varchar(30) not null,\n" +
                    "	local_authority_id int(3),\n" +
                    "	constraint r_laid_fk foreign key (local_authority_id) references LocalAuthority(local_authority_id)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE CountPoint\n" +
                    "(\n" +
                    "	count_point_id int(6),\n" +
                    "	latitude decimal(10,8) not null,\n" +
                    "	longitude decimal(9,8) not null,\n" +
                    "	easting int(6)  not null,\n" +
                    "	northing int(6)  not null,\n" +
                    "	start_junction_road_name varchar(30),\n" +
                    "	end_junction_road_name varchar(30),\n" +
                    "	link_length_km decimal(2,1),\n" +
                    "	link_length_miles decimal(2,1),\n" +
                    "	road_id int(2),\n" +
                    "	constraint cp_cpid_pk primary key (count_point_id),\n" +
                    "	constraint cp_rid_fk foreign key (road_id) references Road(road_id)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE CountEntry\n" +
                    "(\n" +
                    "count_entry_id INTEGER PRIMARY KEY,\n" +
                    "entry_year int(4) not null,\n" +
                    "count_date DATE not null,\n" +
                    "entry_hour int(2) not null,\n" +
                    "direction_of_travel varchar(1) not null,\n" +
                    "pedal_cycles int(5) not null,\n" +
                    "two_wheeled_motor_vehicles int(5) not null,\n" +
                    "cars_and_taxis int(5) not null,\n" +
                    "buses_and_coaches int(5) not null,\n" +
                    "lgvs int(5) not null,\n" +
                    "hgvs_2_rigid_axle int(5) not null,\n" +
                    "hgvs_3_rigid_axle int(5) not null,\n" +
                    "hgvs_4_or_more_rigid_axle int(5) not null,\n" +
                    "hgvs_3_or_4_articulated_axle int(5) not null,\n" +
                    "hgvs_5_articulated_axle int(5) not null,\n" +
                    "hgvs_6_articulated_axle int(5) not null,\n" +
                    "all_hgvs int(5) not null,\n" +
                    "all_motor_vehicles int(5) not null,\n" +
                    "count_point_id int(6),\n" +
                    "constraint ce_cpid_fk foreign key (count_point_id) references CountPoint(count_point_id)\n" +
                    ");";
        
        try {
            // Execute the SQL query
            statement = conn.createStatement();
            statement.executeUpdate(sqlQuery);
            conn.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            // Close execution and connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

}
