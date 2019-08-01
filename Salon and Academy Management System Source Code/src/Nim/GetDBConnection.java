
package Nim;

import java.sql.*;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GetDBConnection {
    
    static final String myhost = "jdbc:mysql://localhost:3306/salon?useSSL=false"; //add   ?useSSL=false   //?zeroDateTimeBehavior=convertToNull
    static final String myusername = "root";
    static final String mypassword = "nimz@12345";      
   
//    static final String myhost = "jdbc:mysql://localhost:3306/Salons?useSSL=false"; //add   ?useSSL=false   //?zeroDateTimeBehavior=convertToNull
//    static final String myusername = "root";
//    static final String mypassword = "sally";      
//   
/*    static final String myhost = "jdbc:derby://localhost:1527/salon"; //add   ?useSSL=false   //?zeroDateTimeBehavior=convertToNull
    static final String myusername = "root";
    static final String mypassword = "nimz@12345";      
*/    
    public static Connection con;
    
    public GetDBConnection() {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.con = DriverManager.getConnection(myhost, myusername , mypassword);
            
            //JOptionPane.showMessageDialog(null, "Connected to Database.");
            
        }        
        catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            
        }                    
        
    }
       
}
