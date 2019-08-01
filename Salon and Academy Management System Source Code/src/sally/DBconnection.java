
package sally;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBconnection {
     static final String myhost = "jdbc:mysql://localhost:3306/SalonS?useSSL=false"; //add   ?useSSL=false   //?zeroDateTimeBehavior=convertToNull
    static final String myusername = "root";
    static final String mypassword = "sally";      
    
    Connection con;
    
    public DBconnection() {
        
         
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
