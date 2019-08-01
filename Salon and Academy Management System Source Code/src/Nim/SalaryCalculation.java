
package Nim;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class SalaryCalculation {
    
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
    
    int empid = 0;
    String timeCome = "";
    String timeLeft = "";
    String post = "";
    String today = "";
    int postID = 0;
    
    double totalSal = 0.0;
            
    boolean own = false;
    boolean man = false;
    boolean rep = false;
    boolean acc = false;
    boolean lec = false;
    boolean beau = false;
    boolean[] postsBoo = new boolean[6];       //array to store boolean post values
    String[] postsStr = {"Owner", "Manager", "Receptionist", "Lecturer", "Beautician", "Accountant"};       //array to store string post values
       
    
    
    public SalaryCalculation(){
        
    } 
    
    //======select post id==============================//
    public void getPostID(){
        try{
            //--query to get the post string value 
            String equery = "SELECT * from Employee where empId=" + this.empid + "";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
            if (rs.next()) {
                this.empid = rs.getInt(1);
                
                //get post values
                this.postsBoo[0] = this.own = rs.getBoolean(9);
                this.postsBoo[1] = this.man = rs.getBoolean(10);
                this.postsBoo[2] = this.rep = rs.getBoolean(11);
                this.postsBoo[3] = this.lec = rs.getBoolean(12);
                this.postsBoo[4] = this.beau= rs.getBoolean(13);
                this.postsBoo[5] = this.acc = rs.getBoolean(14);
            }
            
            for (int i = 0; i < postsBoo.length; i++) {
                if (this.postsBoo[3] == true && this.postsBoo[4]) {
                    this.post = "Beautician And Lecturer";
                }      
                else if(this.postsBoo[i] == true)
                    this.post = this.postsStr[i];                
            }
            System.out.println(post);
            
            //--query to get the post id
            equery = "SELECT postId, postName FROM PostSalDetails WHERE postName = '"+ this.post +"'";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
            if (rs.next()) {
                this.postID = rs.getInt(1);                
            }
            
        }
        catch (SQLException err){
            System.out.println(err);
        }
    }
    //======select post id==============================//
    public int getPostID(int pEmpid){
        
        this.empid = pEmpid;
        
        try{
            //--query to get the post string value 
            String equery = "SELECT * from Employee where empId=" + this.empid + "";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
            if (rs.next()) {
                this.empid = rs.getInt(1);
                
                //get post values
                this.postsBoo[0] = this.own = rs.getBoolean(9);
                this.postsBoo[1] = this.man = rs.getBoolean(10);
                this.postsBoo[2] = this.rep = rs.getBoolean(11);
                this.postsBoo[3] = this.lec = rs.getBoolean(12);
                this.postsBoo[4] = this.beau= rs.getBoolean(13);
                this.postsBoo[5] = this.acc = rs.getBoolean(14);
            }
            
            for (int i = 0; i < postsBoo.length; i++) {
                if (this.postsBoo[3] == true && this.postsBoo[4]) {
                    this.post = "Beautician And Lecturer";
                }      
                else if(this.postsBoo[i] == true)
                    this.post = this.postsStr[i];                
            }
            System.out.println(post);
            
            //--query to get the post id
            equery = "SELECT postId, postName FROM PostSalDetails WHERE postName = '"+ this.post +"'";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
            if (rs.next()) {
                this.postID = rs.getInt(1);                
            }
            
        }
        catch (SQLException err){
            System.out.println(err);
        }
        
        return this.postID;
        
    }
    
    
    //======select post name==============================//
    public String getPostName(int pEmpid){
        
        this.empid = pEmpid;
        
        try{
            //--query to get the post string value 
            String equery = "SELECT * from Employee where empId=" + this.empid + "";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
            if (rs.next()) {
                this.empid = rs.getInt(1);
                
                //get post values
                this.postsBoo[0] = this.own = rs.getBoolean(9);
                this.postsBoo[1] = this.man = rs.getBoolean(10);
                this.postsBoo[2] = this.rep = rs.getBoolean(11);
                this.postsBoo[3] = this.lec = rs.getBoolean(12);
                this.postsBoo[4] = this.beau= rs.getBoolean(13);
                this.postsBoo[5] = this.acc = rs.getBoolean(14);
            }
            
            for (int i = 0; i < postsBoo.length; i++) {
                if (this.postsBoo[3] == true && this.postsBoo[4]) {
                    this.post = "Beautician And Lecturer";
                }      
                else if(this.postsBoo[i] == true)
                    this.post = this.postsStr[i];                
            }
            System.out.println(post);
            
        }
        catch (SQLException err){
            System.out.println(err);
        }
        
        return this.post;
        
    }
  
    
    //====record short leaves=============================//
    public void checkShortLeaves(String pTime, int pEId){
        this.empid = pEId;
        this.timeCome = pTime;
        
        getPostID();
        
        try{   
            //--query to check whether an employee has already a record in EmpLeaveDetails table
            String equery = "SELECT * FROM EmpLeaveDetails WHERE empId = "+ this.empid +"";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
                    //--insert short leaves to database
            if (rs.next()) {            //if employee already has a record
                equery = "UPDATE EmpLeaveDetails SET takenShoLeavings = takenShoLeavings+1 WHERE empId = "+ this.empid +""; 
                pst=dbc.con.prepareStatement(equery);
                pst.executeUpdate();
            }
            else{                //if employee already has not a record   
                equery = "INSERT INTO EmpLeaveDetails VALUES ("+ this.empid +", "+ this.postID +", 1, 0)"; 
                pst=dbc.con.prepareStatement(equery);
                pst.execute();
            }
            

        }
        catch (SQLException err){
            System.out.println(err);
        }
        
    }
    
    
    //====record OT times=============================//
    public void checkShortLeaves(int pEId, String pDate){
        this.empid = pEId;
        this.today = pDate;
        
        int oTHours = 0;
        String timeDiff="";
        
        getPostID();
        
        try{   
            //--query to check whether an employee has already a record
            String equery = "SELECT TIMEDIFF(endX, '17:00:00') AS hdiff FROM EmpAttendance WHERE empId = "+ this.empid +" AND today = '"+ this.today +"'";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
            if (rs.next()) {
                timeDiff = rs.getTime(1).toString();                
            }
            
            //get only Hours value
            StringTokenizer token = new StringTokenizer(timeDiff, ":");
            if (token.hasMoreTokens()) {
                oTHours = Integer.parseInt(token.nextToken()); 
                System.out.println("OT HOURS = " + oTHours);
            }

            //--query to check whether an employee has already a record in EmpLeaveDetails table
            equery = "SELECT * FROM EmpLeaveDetails WHERE empId = "+ this.empid +"";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
                    //--insert OT Hours to database
            if (rs.next()) {                        //if employee already has a record
                equery = "UPDATE EmpLeaveDetails SET otHours = otHours+"+ oTHours +" WHERE empId = "+ this.empid +""; 
                pst=dbc.con.prepareStatement(equery);
                pst.executeUpdate();
            }
            else{                                   //if employee already has not a record   
                equery = "INSERT INTO EmpLeaveDetails VALUES ("+ this.empid +", "+ this.postID +", 0, "+ oTHours +")"; 
                pst=dbc.con.prepareStatement(equery);
                pst.execute();
            }
            

        }
        catch (SQLException err){
            System.out.println(err);
        }
        
    }
    
    //=====================CALCULATE SALARIES===================================//
    
    //==for Manager, Receptionist, Accountant
    public double setDetailsForManAcRe(int pEmpId, int pPostId, int leavings, int sLeaves, int ot){
        
        this.empid = pEmpId;
        this.postID = pPostId;        
        String query = "";
        
        double basic = 0.0;
        
        try{
            //get post details according to employee's post
            query = "SELECT * FROM PostSalDetails WHERE postId = "+ this.postID +"";
            pst = dbc.con.prepareStatement(query);
            rs = this.pst.executeQuery();

            if (rs.next()) {
                basic = rs.getDouble(3);
            }
            
            ///manager = basic - leavings + OT - short leaves
            double leaSal = ((basic*12)/365) * leavings;
            double slSal = (((basic*12)/365)/2) * sLeaves;
            double otSal = (basic/160) * 1.5 * ot;
            
            this.totalSal = basic - leaSal - slSal + otSal;
            
        }
        catch (SQLException err) {
            System.out.println(err);
        }
                
        if (totalSal < 0) {
            totalSal = 0;
        }
        return totalSal;        
    }
    
    
    //=====send salary to salary table
    public void sendSalary(int pEmpId, String pDate, double pSalary){
        
        this.empid = pEmpId;
        
        try{
            String equery = "INSERT INTO EmployeeSalary VALUES ("+ this.empid +", '"+ pDate +"', "+ pSalary +")"; 
            pst=dbc.con.prepareStatement(equery);
            pst.execute();
        }
        catch (SQLException err) {
            System.out.println(err);
        }
        
    }
    
    
    //==for Lecturer
    public double calcSalForLec(int pEmpId, int pPostId){
        
        this.empid = pEmpId;
        this.postID = pPostId;        
        String query = "";
        
        double basic = 0.0;
        double subRate = 0; 
        
        
        try{
            //get post details according to employee's post
            query = "SELECT * FROM PostSalDetails WHERE postId = "+ this.postID +"";
            pst = dbc.con.prepareStatement(query);
            rs = this.pst.executeQuery();

            if (rs.next()) {
                basic = rs.getDouble(3);
            }
            
            query = "SELECT  lis.courseId, spc.subRate FROM LecInSubs lis, SalaryPerCourse spc WHERE lis.courseId = spc.courseId AND lis.empId = "+ this.empid +"";
            pst = dbc.con.prepareStatement(query);
            rs = this.pst.executeQuery();
            
            while(rs.next()){
                subRate = subRate + rs.getDouble(2);
            }
            
            //Lecturer = basic + subjects*rate
            this.totalSal = basic + subRate;
            
        }
        catch (SQLException err) {
            System.out.println(err);
        }
                
        if (totalSal < 0) {
            totalSal = 0;
        }
        return totalSal;        
    }
    
    
    //==calc sal for Horata
    public double calcSalForHora(int pEmpId, int pPostId){
        
        this.empid = pEmpId;
        this.postID = pPostId;        
        String query = "";
        
        double basic = 0.0;
        
        try{
            //get post details according to employee's post
            query = "SELECT * FROM PostSalDetails WHERE postId = "+ this.postID +"";
            pst = dbc.con.prepareStatement(query);
            rs = this.pst.executeQuery();

            if (rs.next()) {
                basic = rs.getDouble(3);
            }
            
            
            //hora calc
            this.totalSal = basic;
            
        }
        catch (SQLException err) {
            System.out.println(err);
        }
                
        if (totalSal < 0) {
            totalSal = 0;
        }
        return totalSal;        
    }

    
    
    
}
