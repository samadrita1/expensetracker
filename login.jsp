<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="#ffe6e6">
	<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*"%>
	<%
String username=request.getParameter("username"); 
session.putValue("username",username); 
String password=request.getParameter("password"); 
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://au-cdbr-sl-syd-01.cleardb.net/ibmx_c85c278f31187d4?user=bbbf184d63edd2&password=5cdfb713","bbbf184d63edd2","5cdfb713"); 
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("select * from logininfo where username='"+username+"'"); 
if(rs.next()) 
{ 
if(rs.getString(2).equals(password)) 
{ 
out.println("Welcome "+username+"!");
} 
else 
{ 
out.println("Invalid password/username. Try again!"); 
} 
} 
else 
%>
<a href="index.html">Home</a>
</body>
</html>