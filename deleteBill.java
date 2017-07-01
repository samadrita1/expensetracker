package icdp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteBill")
public class deleteBill extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		HttpSession session= request.getSession(false);
		if(session!=null){  
			String id = (String) session.getAttribute("userid");  
		      
		    out.print("You may proceed User "+id);  
		    }  
		    else{  
		        out.print("Please login first");  
		        request.getRequestDispatcher("login.java").include(request, response);  
		    }
		    try
		    {
		      Class.forName("com.jdbc.mysql.Driver");
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "drowssapwen");
		      String n=request.getParameter("Bill_id"); 
		      String query = "delete from bills where Bill_id= ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString(1, n);

		      preparedStmt.executeUpdate();
		      
		      int i = preparedStmt.executeUpdate();
		      if (i==0) out.print("Deleted");
		      else out.print("Cannot delete");
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }

		  }
	}

