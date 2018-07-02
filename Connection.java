import java.sql.*;

/**
 *
 * @author Neel
 */
public class connection {
    static Connection cn = null;
    
    public static Connection getConnected(){
        try{
            String url="jdbc:mysql//localhost:3306/mydb";
            String uname="root";
            String pword="1024";
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url,uname,pword);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return cn;
    }
}