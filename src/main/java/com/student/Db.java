package com.student;

import java.sql.*;

public class Db {
	static String name="root";
	static String pass="aditya";
	static String url="jdbc:mysql://localhost:3306/sms";
	
	public static Connection con() 
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,name,pass);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
}
