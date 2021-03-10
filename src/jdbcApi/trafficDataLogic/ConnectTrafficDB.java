
package jdbcApi.trafficDataLogic;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectTrafficDB {

    public static Connection getConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:trafficData.db";
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
            return null;
        }
    }
}