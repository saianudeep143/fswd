package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("").append(request.getContextPath());
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
			out.print(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
