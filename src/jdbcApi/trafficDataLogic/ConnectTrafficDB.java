
package jdbcApi.trafficDataLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConnectTrafficDB {

    public static Connection getConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:trafficData.db";
            Connection conn = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Connection Established"); // Confirm connection established
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}