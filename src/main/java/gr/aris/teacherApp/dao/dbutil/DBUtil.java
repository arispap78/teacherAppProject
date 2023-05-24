package gr.aris.teacherApp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection conn;
	
	/*
	 *  No instances will be available
	 */
	private DBUtil() {}
	
	public static Connection openConnection() throws SQLException  {
		String url = "jdbc:mysql://localhost:3306/teacherdb?useSSL=false";
		String username = "root";
		String password = "NPn02522";
		
		conn =  DriverManager.getConnection(url, username, password);
		
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}
