import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class RequestLoan extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
       
       int Acc_id =Integer.parseInt(request.getParameter("Acc_id"));
       int Loan_amt =Integer.parseInt(request.getParameter("Loan_amt")); 
		 
		 Connection con = null;
        try{
        
        Connection con=DBConnection.getConnection();
          
        PreparedStatement ps=con.prepareStatement
                  ("insert into expensetracker.loan(acc_id,loan_amt,loan_status) values(?,?,0);");

        ps.setInt(1, Acc_id);
        ps.setInt(2, Loan_amt);
		
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("Your request for loan has been sent for approval!");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Your request for loan has been sent for approval!');");
			out.println("location='Request.html';");
			out.println("</script>");
			
          }
		  else{
			  out.println("Something Went Wrong!");
			  out.println("<script type=\"text/javascript\">");
				out.println("alert('Something Went Wrong! Re-enter the Details');");
				out.println("location='Request.html';");
				out.println("</script>");
		  }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }