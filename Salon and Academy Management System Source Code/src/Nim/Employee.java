
package Nim;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Employee {
    
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
      
    int id;
    String fname;
    String lname;
    String address;
    String phone;
    String email;
    String gender;
    String birthday;
    
    boolean own;
    boolean man;
    boolean rep;
    boolean acc;
    boolean lec;
    boolean beau;    
    
    String username;
    String pwd;
    
    int areacode;
    int areaCoS[];
    String areas[] = new String[20];
        
    public Employee()
    {
        
    }
    
    public Employee(int id)
    {
        this.id = id;                               
    }
           
    //================== Adding lecturer or Beautician=================================//
    public Employee(int pid, String pfname, String plname, String padd, String pphone, String pemail, String pgender, String pBirth, boolean plec, boolean pbeau, String pusername, String ppwd)
    {
        this.id = pid;
        this.fname = pfname;
        this.lname = plname;
        this.address = padd;
        this.phone = pphone;
        this.email = pemail;
        this.gender = pgender;
        this.birthday = pBirth;
        
        this.lec = plec;
        this.beau = pbeau;
        
        this.username = pusername;
        this.pwd = ppwd;
        
        //---add to data base
        try {
            String sql = "INSERT INTO Employee VALUES ("+id+", '"+fname+"', '"+lname+"', '"+address+"', "+phone+", '"+email+"', '"+gender+"', '"+birthday+"', false, false, false, "+lec+", "+beau+", false, '"+username+"', '"+pwd+"')";
            pst = dbc.con.prepareStatement(sql);
            pst.execute();
           
        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    //---adding records to EmpSpecIn table-----------------------//
    public void addToEmpSpecs(int pEid, int pAcode)
    {
        this.id = pEid;
        this.areacode = pAcode;
        
        try {
            String sql2 = "INSERT INTO EmpSpecIn VALUES ("+id+", "+areacode+")";
            pst = dbc.con.prepareStatement(sql2);
            pst.execute();
                                
        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(null, err);
        }
        
    }
    
    
    //================== Adding Receptionist=================================//
    Employee(int pid, String pfname, String plname, String padd, String pphone, String pemail, String pgender, String pBirth, boolean prep, String pusername, String ppwd) 
    {
        this.id = pid;
        this.fname = pfname;
        this.lname = plname;
        this.address = padd;
        this.phone = pphone;
        this.email = pemail;
        this.gender = pgender;
        this.birthday = pBirth;
        
        this.rep = prep;
        
        this.username = pusername;
        this.pwd = ppwd;
        
        //---add to database
        try {
            String sql = "INSERT INTO Employee VALUES ("+id+", '"+fname+"', '"+lname+"', '"+address+"', "+phone+", '"+email+"', '"+gender+"', '"+birthday+"', false, false, "+rep+", false, false, false, '"+username+"', '"+pwd+"')";
            pst = dbc.con.prepareStatement(sql);
            pst.execute();
                               
        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    //================== Adding Accountant=================================//
    Employee(int pid, String pfname, String plname, String padd, String pphone, String pemail, String pgender, String pBirth, boolean pacc, int i, String pusername, String ppwd) 
    {
        this.id = pid;
        this.fname = pfname;
        this.lname = plname;
        this.address = padd;
        this.phone = pphone;
        this.email = pemail;
        this.gender = pgender;
        this.birthday = pBirth;
        
        this.acc = pacc;
        
        this.username = pusername;
        this.pwd = ppwd;
        
        //---add to data base
        try {
            String sql = "INSERT INTO Employee VALUES ("+id+", '"+fname+"', '"+lname+"', '"+address+"', "+phone+", '"+email+"', '"+gender+"', '"+birthday+"', false, false, false, false, false, "+acc+", '"+username+"', '"+pwd+"')";
            pst = dbc.con.prepareStatement(sql);
            pst.execute();
                               
        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(null, err);
        }        
        
    }
    
    //================== View Employee Full Details=============================//
    public void viewDetails() 
    {
        int index = 0;
        
        try {
        //---------get details from Employee table----------------//
            String sql = "SELECT * FROM Employee WHERE empId = "+id+"";
            pst = dbc.con.prepareStatement(sql);
            rs = this.pst.executeQuery();           
            
            if(rs.next())
            {
                this.fname = rs.getString(2);
                this.lname = rs.getString(3);
                this.address = rs.getString(4);
                this.phone = rs.getString(5);
                this.email = rs.getString(6);
                this.gender = rs.getString(7);
                this.birthday = rs.getDate(8).toString();
                
                this.own = rs.getBoolean(9);
                this.man = rs.getBoolean(10);
                this.rep = rs.getBoolean(11);
                this.lec = rs.getBoolean(12);
                this.beau = rs.getBoolean(13);
                this.acc = rs.getBoolean(14);       
                  
            }
        //--------------------get details from employee special areas---------------------------------//   
            String sql2 = "SELECT t.tName FROM EmpSpecIn es, treatment t WHERE t.tId=es.areaCode AND es.empId = "+id+"";
            pst = dbc.con.prepareStatement(sql2);
            rs = this.pst.executeQuery();           
            
            while(rs.next())
            {
                areas[index] = rs.getString(1);
                index++;                            
            }
        } 
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err);
        }    
        
        //------------pass details to Display in JFrame--------------------------------------//
        ViewEmpDetails ved = new ViewEmpDetails();  
        ved.setVisible(true);                       
        ved.setDetails(id, fname, lname, address, phone, email, gender, birthday, own, man, rep, lec, beau, acc);
                                                    
        if(beau==true || lec==true)
        {                                           
            ved.setSpecailAreas(areas);             
        }                                           
        
    }
      
    //=================Get Employee Details by Id=======================================//
    public void searchByID(int pid)
    {
        String query = "";
        SearchEmployee se = new SearchEmployee();
        
        try{
            query = "SELECT empId, empFName, empLName, empPhone, empEmail FROM Employee WHERE empId LIKE CONCAT('%', '" +pid+ "', '%')";
            pst = dbc.con.prepareStatement(query);
            rs = pst.executeQuery();
            
            while (rs.next()){                                                          
                this.id = rs.getInt(1);
                this.fname = rs.getString(2);
                this.lname = rs.getString(3);
                this.phone = rs.getString(4);
                this.email = rs.getString(5);
                
                se.addDetailsToTable(id, fname, lname, phone, email);                   
            }
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err);
        }
    }
    //=================Get Employee Details by name=======================================//
    public void searchByName(String pname)
    {
        String query = "";
        SearchEmployee se = new SearchEmployee();
        
        try{
            query = "SELECT empId, empFName, empLName, empPhone, empEmail FROM Employee WHERE empFName LIKE CONCAT('%', '" +pname+ "', '%') OR empLName LIKE CONCAT('%', '" +pname+ "', '%') ";
            pst = dbc.con.prepareStatement(query);
            rs = pst.executeQuery();
            
            while (rs.next()){   
                this.id = rs.getInt(1);
                this.fname = rs.getString(2);
                this.lname = rs.getString(3);
                this.phone = rs.getString(4);
                this.email = rs.getString(5);                               
                
                se.addDetailsToTable(id, fname, lname, phone, email);               
            }
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err);
        }
    }
        
        
     
}
    
