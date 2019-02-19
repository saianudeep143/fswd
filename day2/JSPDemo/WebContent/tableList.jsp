<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 


	// TODO Auto-generated method stub
	// response.getWriter().append("Served at: ").append(request.getContextPath());

	

try {
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	
	Statement stmt = con.createStatement();
	
	
	
	
	ResultSet rs = stmt.executeQuery("SHOW TABLES");
	
	out.println("<div class = 'container-fluid tables-section'>");
	
	out.println("<h2> Table's Available </h2><hr></hr>");
	
	while(rs.next()) {
		//out.println("<a href = 'TableData'><h4>"+rs.getString(1)+"</h4></a>");
		out.println("<a href = 'DisplayTable?tname="+rs.getString(1)+"'><h4>"+rs.getString(1)+"</h4></a>");
	}
	
	out.println("</div>");
	
	
	
} catch(Exception e) {
	out.println(e.getMessage());
}




%>
</body>
</html>