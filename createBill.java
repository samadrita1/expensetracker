package icdp;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
  
@WebServlet("/createBill")
public class createBill extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("Bill_id");  
String p=request.getParameter("Bill_grpID");  
String e=request.getParameter("Bill_amt");  
String c=request.getParameter("Bill_Purpose");  
String d=request.getParameter("Bill_Date");  
String a=request.getParameter("Bill_appPer");  
String s=request.getParameter("Bill_status");  


          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/database",
		"root","root");  
  
PreparedStatement pst=con.prepareStatement(  
"insert into bills values(?,?,?,?,?,?,?)");  
  
pst.setString(1,n);  
pst.setString(2,p);  
pst.setString(3,e);  
pst.setString(4,c);
pst.setString(5,d);
pst.setString(6,a);
pst.setString(7,s);
          
int i=pst.executeUpdate();  

PreparedStatement ps = con.prepareStatement("INSERT INTO pictures VALUES(?,?)");
File file = new File("C:/Users/Samadrita/Documents/Downloads/apache-tomcat-8.5.12-windows-x64/apache-tomcat-8.5.12/webapps/image/5.jpg");
FileInputStream fs = new FileInputStream(file);
ps.setInt(1,9);
ps.setBinaryStream(2,fs,fs.available());
int j = ps.executeUpdate();
if(j!=0){
	out.println("Image inserted successfully");
}
else{
	out.println("Problem in image insertion");
}	
 
if(i>0)  
out.print("Successfully Created!");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}