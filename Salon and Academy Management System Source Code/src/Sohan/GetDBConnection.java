
package Sohan;

import Nim.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class GetDBConnection {
    
    
    static final String myhost = "jdbc:mysql://localhost:3306/salon?useSSL=false"; //add   ?useSSL=false   //?zeroDateTimeBehavior=convertToNull
    static final String myusername = "root";
    static final String mypassword = "nimz@12345";      
   
    
//    static final String myhost = "jdbc:mysql://localhost:3306/SalonS?useSSL=false"; //add   ?useSSL=false   //?zeroDateTimeBehavior=convertToNull
//    static final String myusername = "root";
//    static final String mypassword = "sally";      
//    
    public static Connection con;
    
    public GetDBConnection() {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(myhost, myusername , mypassword);
            
            //JOptionPane.showMessageDialog(null, "Connected to Database.");
            
        }        
        catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            
        }                    
        
    }
       
}
