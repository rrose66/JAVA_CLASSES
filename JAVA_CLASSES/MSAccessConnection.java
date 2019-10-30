package connections;

import java.sql.Connection;

public class MSAccessConnection {

	public static void main(String[] args) 
	{
		final String accessDBURLPrefix = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
	    final String accessDBURLSuffix = ";DriverID=22;READONLY=false}";

	    // Initialize the JdbcOdbc Bridge Driver
	        try {
	            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        } catch(ClassNotFoundException e) {
	            System.err.println("JdbcOdbc Bridge Driver not found!");
	        }

	    /** Creates a Connection to a Access Database */
//	    public static Connection getAccessDBConnection(String filename) throws SQLException {
//	        filename = filename.replace('', '/').trim();
//	        String databaseURL = accessDBURLPrefix + filename + accessDBURLSuffix;
//	        return DriverManager.getConnection(databaseURL, "", "");
//	    }  
	}

}
