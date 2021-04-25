package jdbcApi;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Authorship information 
 * @author Gervais Boadi Appiah, w1735205
 * Information: This is a java file which is used to create the connection between the application and the database 
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

    
}
