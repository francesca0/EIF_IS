package dcs;

import java.sql.*;

public class ConnectionManager {
	
	public ConnectionManager(){
		
	}
	
	private static boolean driverLoaded = false;
	private static final String  MY_DRIVER = "com.mysql.jdbc.Driver";
	private static final String  MY_URL = "jdbc:mysql://localhost:3306/isdb";
	private static final String  USERNAME = "root";
	private static final String  PASSWORD = "123456789";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		if(!driverLoaded){
			Class.forName(MY_DRIVER);
			driverLoaded = true; 
		}
		
		return DriverManager.getConnection(MY_URL, USERNAME, PASSWORD);
	}
	
}
