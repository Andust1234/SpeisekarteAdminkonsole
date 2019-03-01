import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
//import java.util.Properties;

public class DB_Verbindung_herstellen {
	
	public DB_Verbindung_herstellen() {
		
	}

	public void Verbinden() {
		
		final String hostname = "localhost"; 
        final String port = "50000"; 
        final String dbname = "DB_Gerichte"; 
        final String user = "dba"; 
        final String password = "sql"; 
	
        Connection conn = null; 
		
 		try { 
 			System.out.println("* Treiber laden *"); 
      	    Class.forName("org.gjt.mm.mysql.Driver").newInstance(); 
        } 
        catch (Exception e) { 
            System.err.println("Unable to load driver."); 
            e.printStackTrace(); 
        } 
        try { 
		    System.out.println("* Verbindung aufbauen");  
		    String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname; 
		    conn = DriverManager.getConnection(url, user, password);  
		    System.out.println("* Datenbank-Verbindung beenden *"); 
		    conn.close(); 
        } 
        catch (SQLException sqle) { 
            System.out.println("SQLException: " + sqle.getMessage()); 
            System.out.println("SQLState: " + sqle.getSQLState()); 
            System.out.println("VendorError: " + sqle.getErrorCode()); 
            sqle.printStackTrace(); 
        }
	}
	
}

// conn.close() zum trennen der Verbindung
