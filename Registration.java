package Register;

import java.util.Date;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Registration extends HttpServlet {
	public int Mem_id,Mem_grpID,Mem_status;
	public String Mem_name,Mem_pass,Mem_email,Mem_mobile,Mem_Dob; 
	public void doPost(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException 
	{
		 response.setContentType("text/html");
	     PrintWriter out=response.getWriter();
		 Mem_id=Integer.parseInt(request.getParameter("Mid"));
		 Mem_grpID=Integer.parseInt(request.getParameter("Groupid"));
		 Mem_status=0;
		 Mem_name =request.getParameter("Mname");
		 Mem_pass=request.getParameter("Mpass");
		 Mem_email=request.getParameter("Mmail");
		 Mem_mobile=request.getParameter("Mmobile");
		 Mem_Dob=request.getParameter("Mdob");
		 Date date = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Mem_Dob=dateFormat.format(date);
		 try
		 {
		  	        Class.forName("com.mysql.jdbc.Driver");
		  	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ExpTracker","root","");
		  	        out.print("con ok");
		            PreparedStatement pst=con.prepareStatement("insert into values(?,?,?,?,?,?,?,?)");
				  	pst.setInt(1,Mem_id);
					pst.setString(2,Mem_name);
					pst.setString(3, Mem_Dob );
					pst.setString(4, Mem_email);
					pst.setString(5, Mem_pass);
					pst.setString(6, Mem_mobile);
					pst.setInt(7,Mem_grpID);
					pst.setInt(8,Mem_status);
					int k=pst.executeUpdate();
					if(k==1) 
					{
						    RequestDispatcher rs = request.getRequestDispatcher("RegistrationSuccess.html");
				            rs.forward(request, response);
					}
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

}
