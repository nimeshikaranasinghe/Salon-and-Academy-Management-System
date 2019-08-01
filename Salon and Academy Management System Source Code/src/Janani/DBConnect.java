
package Janani;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class DBConnect {
    
    public static Connection connect (){
    
    Connection conn = null;
  
    try {
    
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/SalonS?useSSL=false","root","sally");
    }
    
    catch (Exception e){
    System.out.println("Database connection failed!");
    }
    
    return conn;
        
    }
    
}
