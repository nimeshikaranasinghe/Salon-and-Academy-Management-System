/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dewni;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBconnect {
    
     static final String myhost = "jdbc:mysql://localhost:3306/SalonS?useSSL=false"; //add   ?useSSL=false   //?zeroDateTimeBehavior=convertToNull
    static final String myusername = "root";
    static final String mypassword = "sally";  
    
    public Connection con;
    
    public DBconnect() {
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(myhost, myusername , mypassword);
            
            System.out.println("cennect to db");
            
        }        
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            
        }                    
        
    }
       
}
