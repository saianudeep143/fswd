package com.anudeep;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class DBServelet2
 */
@WebServlet("/DBServelet2")
public class DBServelet2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public DBServelet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		try {
			
Class.forName("com.mysql.jdbc.Driver");
			
			//step 2 establishing connection
		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			//step3 : Creating and executing the query
			
			Statement stm = conn.createStatement();
			
			
		ResultSet rs = 	stm.executeQuery("select* from anudeep");
		ResultSetMetaData rsmd = rs.getMetaData();
		
		

		out.println("*************Traniee Details************");
		int ind = 1;
		while(ind<=rsmd.getColumnCount())
		{
			out.print(rsmd.getColumnName(ind)+"  ");
			ind++;
			
		}
		out.println("\n");
		
		while(rs.next())
		{
			out.println(rs.getString(1)+"            "+rs.getString(2)+"         "+rs.getString(3));
			
		}
		out.println("\n");
	out.println("No.of columns"+rsmd.getColumnCount());
		
		rs.close();
		stm.close();
		conn.close();


			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}
		
		
		
	}

}
