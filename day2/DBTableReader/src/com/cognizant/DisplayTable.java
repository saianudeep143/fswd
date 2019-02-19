package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DisplayTable
 */
@WebServlet("/DisplayTable")
public class DisplayTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		PrintWriter out = response.getWriter();
		
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			
			String name = request.getParameter("tname");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			
			Statement stmt = con.createStatement();
			
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+name);
			
		
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//ResultSet rs1 = rs;
			//ResultSet rs2 = rs;
			
			int columnCount = rsmd.getColumnCount();
			
			out.println("<div class = 'container-fluid table-data'>");
			
			out.println("<h2>"+name.toUpperCase() +"'s Table Data </h2><hr></hr>");
			
			out.print("<table class = 'table'><thead><tr>");
			
			
			for(int iter = 1; iter <= columnCount; iter++) {
				out.print("<th scope = 'col'>"+rsmd.getColumnName(iter)+"</th>");
			}
			
			out.print("</tr></thead><br><tbody>");
			
			rs.first();
			
			while(rs.next()) {
				out.print("<tr>");
				for(int iter = 1; iter <= columnCount; iter++) {
					out.print("<td>"+rs.getString(iter)+"</td>");
				}
				out.print("</tr>");
			}
			out.print("</tbody></table>");
			
		} catch(Exception e) {
			out.println(e.getMessage());
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