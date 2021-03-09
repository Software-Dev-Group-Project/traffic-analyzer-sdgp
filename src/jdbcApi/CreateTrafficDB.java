
package jdbcApi;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;


public class CreateTrafficDB {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Connect();
    }
}

class Connect {

    private String urlSQLite;
    private Driver driverSQLite;
    private Connection conSQLite;

    public Connect() {
        urlSQLite = "jdbc:sqlite:trafficData.db";

        try {
            driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("Driver registered.");
        } catch (Exception e) {
            System.out.println("Problem with downloading driver for SQLite: " + e.getMessage());
        }

        try {
            conSQLite = DriverManager.getConnection(urlSQLite); // create DB if does not exist
            System.out.println("Database created if not exists.");
        } catch (Exception e) {
            System.out.println("Problem with connection to SQLite: " + e.getMessage());
        }

        try {
            if (!conSQLite.isClosed()) {
                conSQLite.close();
                System.out.println("Connection to SQLite closed.");
            }
        } catch (Exception e) {
            System.out.println("Problem with closing connection of SQLite");
        }

    }
}