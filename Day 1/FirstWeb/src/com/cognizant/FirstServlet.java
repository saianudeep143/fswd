package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSetMetaData;
//import com.mysql.jdbc.ResultSetMetaData;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String str = "select * from " + request.getParameter("uname");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(str);
			response.setContentType("text/html");
			out.println("<link rel='stylesheet' href='bootstrap.min.css'>");
			out.print("<h3 class='text-center'>*************" + request.getParameter("uname")
					+ "****************</h3><br><table class='table table-hover table-bordered'>");
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();
			out.print("<tr>");
			for (int i = 1; i < numberOfColumns + 1; i++) {
				out.print("<th>" + rsMetaData.getColumnName(i) + "</th>");
			}
			out.print("</tr>");
			while (rs.next()) {
				out.print("<tr>");
				for (int i = 1; i <= numberOfColumns; i++) {
					out.print("<td>" + rs.getString(i) + "</td>");
				}
				out.print("</tr>");
			}
			out.print("</table>");
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			out.println(e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
