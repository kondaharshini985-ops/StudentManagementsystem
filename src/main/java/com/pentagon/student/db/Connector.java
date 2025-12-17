package com.pentagon.student.db;



import java.sql.*;
import java.sql.Connection;

public class Connector {
	private static final  String url ="jdbc:mysql://localhost:3306/student";
	private static final   String username ="root";
	private static final   String password ="root";
	
	public static Connection  getConnnection() {
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =DriverManager.getConnection(url,username,password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}

}
