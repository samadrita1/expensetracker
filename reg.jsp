<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
button {
    background-color: #ffe6e6;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
</style>
</head>
<body>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%
String username=request.getParameter("username"); 
session.putValue("username",username); 
String password=request.getParameter("password"); 
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://au-cdbr-sl-syd-01.cleardb.net/ibmx_c85c278f31187d4?user=bbbf184d63edd2&password=5cdfb713",
"bbbf184d63edd2","5cdfb713"); 
Statement st= con.createStatement(); 
ResultSet rs;
int i=st.executeUpdate("insert into logininfo values ('"+username+"','"+password+"')"); 
%>
<center>Congratulations! You are now a registered User!
<button><a href ="login.html">Login</a></button><br/><br/>
<button><a href="index.html">Home</a></button>
</center>
</body>
</html>