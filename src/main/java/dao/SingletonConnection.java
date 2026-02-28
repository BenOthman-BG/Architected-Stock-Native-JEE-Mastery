package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

	// static variable -> it means that is linked by the class not the object 
	private static Connection connection ;
	
	// static block -> means work once 
	static {
		try {
			
			// open the connection with db and save it in connection variable 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_PRODUIT" ,"root" , "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	// the method that we will use it after 
	public static  Connection getConnection () {
		return connection;
	}

}



