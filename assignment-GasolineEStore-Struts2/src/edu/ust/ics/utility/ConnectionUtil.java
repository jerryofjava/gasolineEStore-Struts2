package edu.ust.ics.utility;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class ConnectionUtil {

	public static Connection getDBConnection() {
		Connection connection = null;
		try
		{	
			connection = ((DataSource)InitialContext.doLookup("java:/comp/env/jdbc/dupo-3csc-ics114-db")).getConnection();
		}
		catch(NamingException ne)
		{
			ne.printStackTrace();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	
		return connection;
	}
}
