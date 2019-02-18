package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContextAttributeEvent;
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
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		session.setAttribute("username","TestUser");
		session.setAttribute("usertype","DMA");
		Enumeration<String> sessionAttributes= session.getAttributeNames();
		out.println("<link rel='stylesheet' href='bootstrap.min.css'>");
		out.println("<table class='table table-hover table-bordered'>");
		out.println("<tr><td>S.No</td><td>Attrib_Name</td><td>Attrib_Value</td></tr>");
		int i=1;
		while(sessionAttributes.hasMoreElements()) {
			String sessionAttributename=sessionAttributes.nextElement();
			out.println("<tr><td>"+i+"</td><td>"+sessionAttributename+"</td><td>"+session.getAttribute(sessionAttributename)+"</td></tr>");
			i++;
		}
		out.println("</table>");
		session.setMaxInactiveInterval(5);
		out.println("<table class='table table-hover table-bordered'>");
		out.println("<tr><td>Session_Name</td><td>_Value</td></tr>");
		out.println("<tr><td>Session_ID</td><td>"+session.getId()+"</td></tr>");
		out.println("<tr><td>Session_Creation_time</td><td>"+new Date(session.getCreationTime())+"</td></tr>");
		out.println("<tr><td>Maxinactive interval</td><td>"+session.getMaxInactiveInterval()+"</td></tr>");
		out.println("<tr><td>LastAccessedTime</td><td>"+new Date(session.getLastAccessedTime())+"</td></tr>");
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
