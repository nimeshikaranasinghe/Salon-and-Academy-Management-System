/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dewni;

/**
 *
 * @author irusha
 */
public class Attendance {
    
     private String stdid;
   private String firstName;
   private String Status;
   private String date;
   private String cid;
   
   
   public Attendance(String ID,String firstName,String CId,String Status,String date){
   
       this.stdid = ID;
       this.firstName = firstName;
       this.Status = Status;
       this.date = date;
       this.cid = CId;
   
   
   }
   
   public String getID(){

    return stdid;
    }
   
   public String getfirstName(){
   
       return firstName;
   }
   
   public String getCId(){
   
       return cid;
   }
   
   
   public String getStatus(){
   
       return Status;
   
   }
   
   public String getdate(){
   
       return date;
   
   }
}
