package com.cognizant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		
		//step 1 loading ad registering the driver
		Scanner sc = new Scanner(System.in);
		
		Class.forName("com.mysql.jdbc.Driver");
		
		//step 2 establishing connection
		System.out.println("Enter schema name");
		String sch = sc.nextLine();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+sch, "root", "root");
		//step3 : Creating and executing the query
		
		Statement stm = conn.createStatement();
		//stm.execute("insert into anudeep values('deep','IT','SBU')");
		System.out.println("Enter table name");
		String inp = sc.nextLine();
	ResultSet rs = 	stm.executeQuery("select* from " + inp);
	ResultSetMetaData rsmd = rs.getMetaData();
	
	

	System.out.println("*************Traniee Details************");
	int ind = 1;
	while(ind<=rsmd.getColumnCount())
	{
		System.out.print(rsmd.getColumnName(ind)+"  ");
		ind++;
		
	}
	System.out.println("\n");
	
	while(rs.next())
	{
		System.out.println(rs.getString(1)+"            "+rs.getString(2)+"         "+rs.getString(3));
		
	}
	System.out.println("\n");
	System.out.println("No.of columns"+rsmd.getColumnCount());
	
	rs.close();
	stm.close();
	conn.close();

	}

}
