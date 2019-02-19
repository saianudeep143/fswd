package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
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
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		session.setAttribute("username", "admin");
		session.setMaxInactiveInterval(5);
		
		out.println("<table border = '1'> <tr> <th> Session Detail </th> <th> Session value </th></tr>");
		out.println(" <tr> <td> Session ID: </td> <td> "+session.getId()+ "</td></tr>");
		out.println(" <tr> <td> Creation Time: </td> <td> "+new Date (session.getCreationTime())+ "</td></tr>");
		out.println(" <tr> <td> Last Accessed Time: </td> <td> "+ new Date (session.getLastAccessedTime())+ "</td></tr>");
		out.println(" <tr> <td> Maximum Intraval Time:: </td> <td> "+session.getMaxInactiveInterval()+ "</td></tr>");
		out.println(" <tr> <td> Username Attribute value: </td> <td> "+session.getAttribute("username")+ "</td></tr>");
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
