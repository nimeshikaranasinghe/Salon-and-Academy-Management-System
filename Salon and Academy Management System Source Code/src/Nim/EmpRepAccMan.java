
package Nim;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class EmpRepAccMan extends Employee{
    
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
   
    
    public EmpRepAccMan(int id){
        super(id);
    }
    
    
    public void updateDetails(String pfname, String plname, String pphone){
        
        super.fname = pfname;
        super.lname = plname;
        super.phone = pphone;
        
        
        try {
            String sql = "UPDATE Employee SET empFname='"+super.fname+"', empLName = '"+super.lname+"', empPhone = '"+super.phone+"' WHERE empId = "+super.id+"";
            pst = dbc.con.prepareStatement(sql);
            pst.execute();
                               
        } 
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err);
        }
    
    }
    
}
