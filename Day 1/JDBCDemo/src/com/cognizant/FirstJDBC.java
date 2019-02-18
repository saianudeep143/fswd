package com.cognizant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to JDBC");
		//step 1: Loading & registering the driver
		Class.forName("com.mysql.jdbc.Driver");  // bcoz driver is in com.mysql.jdbc, It is equal for creating class
		
		//step 2: Creating & Establishing connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		//step 3: Create & Execute the query
		Statement stmt = conn.createStatement();
		
		 stmt.execute("INSERT INTO trainee_detail(trainee_name,branch,college_name) VALUES ("sai","EEE","ramco");");// it returns tables in result set so we have to store it.
		// rs points to header in the table, so in while rs.rext is given to point first data in table
		//step 4: Processing result
		 ResultSet rs= stmt.executeQuery("select * from trainee_detail");
		while(rs.next()) {
			System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"\n");
		}
		rs.close();
		stmt.close();
		conn.close();
	}
		
}
