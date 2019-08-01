/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dewni;

import java.awt.Image;
import javax.swing.Icon;

/**
 *
 * @author irusha
 */
class Students {

   private String stdid;
   private String firstName;
   private String lastName;
   private String gender;
   private String dob;
    private int phoneNo;
    private String email;
    private String nic;
    private String address;
    private String admissionDate;
    private String course;
    private String courseID;

   
    public Students(String ID,String FirstName,String LastName,String Gender,String Dob,int Phone,String Email,String Nic,String Address,String Admission,String Course,String CourseID){

    
    this.stdid = ID;
    this.firstName   = FirstName;
    this.lastName = LastName;
    this.gender = Gender;
    this.dob = Dob;
    this.phoneNo = Phone;
    this.email = Email;
    this.nic = Nic;
    this.address = Address;
    this.admissionDate = Admission;
    this.course = Course;
    this.courseID = CourseID;
    
    }

    
    
    public String getID(){

    return stdid;
    }
    
     public String getFirstName(){

    return firstName;
    }
     
      public String getLastName(){

    return lastName;
    }
      
       public String getGender(){

    return gender;
    }
       
        public String getDob(){

    return dob;
    }
        
         public int getPhone(){

    return phoneNo;
    }
         
          public String getEmail(){

    return email;
    }
          
           public String getNic(){

    return nic;
    }
           
            public String getAddress(){

    return address;
    }
            
             public String getAdmission(){

    return admissionDate;
    }
             
              public String getCourse(){

    return course;
    }
              
               public String getCourseID(){

    return courseID;
    }
               
                
               
   


}
