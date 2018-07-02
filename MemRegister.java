import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemRegister extends HttpServlet 
{
   //Declarations of required attributes
	int Mem_id,Mem_grpID,Mem_status;
	String Mem_name,Mem_pass,Mem_email,Mem_mobile,Mem_Dob;
 

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   	
               getParmas(request);//function to get parameters from request and 
			   validateReg();

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	              doGet(request, response);	//to handle post request
	}
    
	public void getParmas(HttpServletRequest request)// method to get paramters and intilise the attributes
	{
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
		 
	}
	
	public void validateReg() //method to register 
	{   
		try
		{
		Connection con=getConnection();
		PreparedStatement pst1=getStatement();
		int k=pst1.executeUpdate();
		if(k==1)
		System.out.println("Registration Successful");
		}
		catch(Exception ex)
		{ 
			 System.out.println(ex);
		}
		
	}
	
	public  Connection getConnection()//method to make database connections
	{
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ExptrackerDB","root","");
			System.out.println("Connected.......");
			}
			catch(Exception op){op.printStackTrace();}
		return con;
	}
	
	public PreparedStatement getStatement()//method to prepare a statement
	{ 
		PreparedStatement pst1=con.prepareStatement("insert into members values(?,?,?,?,?,?,?,?)");
		pst1.setInt(1,Mem_id);
		pst1.setString(2,Mem_name);
		pst1.setString(3, Mem_Dob );
		pst1.setString(4, Mem_email);
		pst1.setString(5, Mem_pass);
		pst1.setString(6, Mem_mobile);
		pst1.setInt(7,Mem_grpID);
		pst1.setInt(8,Mem_status);
		return pst1;
	}
	
}
