package jdbcApi;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.logging.Logger;

/*
 * @author gervais
 */
public class DatabaseConnectionDB {

    /*
     * @param args the command line arguments
     */
    Connection con = null;

    public static Connection ConnectionDB() {
        try {
            //Attempting to establish a connection to database
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:LATAAccountDB.db");
            System.out.println("Connection has been successful");
            return con;
        } catch (Exception e) {
            //If the attempt is not successful then the following message appears
            System.out.println("Connection has failed" + e);
            return null;
        }
    }

    /*    
    public static void main(String[] args) {
        new Connect();
    }
}

class Connect {

    private String urlSQLite;
    private Driver driverSQLite;
    private Connection conSQLite;

    public Connect() {
        //Used to locate the database
        urlSQLite = "jdbc:sqlite:LATALoginAccountDB.db";

        try {
            driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("Driver for SQLite downloaded.");
        } catch (Exception e) {
            System.out.println("Problem with download driver for SQLite: " + e.getMessage());
        }

        try {
            conSQLite = DriverManager.getConnection(urlSQLite);
            System.out.println("Connection to SQLite is done.");
        } catch (Exception e) {
            //If connection has failed the following message will occur
            System.out.println("Problem with connection to SQLite: " + e.getMessage());
        }

        try {
            if (!conSQLite.isClosed()) {
                conSQLite.close();
                System.out.println("Connection to SQLite closed.");
            }
        } catch (Exception e) {
            System.out.println("Problem with close connection of SQLite");
        }

    }
     */
}
