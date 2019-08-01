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
public class Grading {
    
     private String stdid;
   private String firstName;
   private String course;
   private String type;
   private String grade;
   private String date;


    public Grading(String ID,String FirstName,String Course,String Type,String Grade,String Date)
    {
        this.stdid = ID;
    this.firstName   = FirstName;
    this.course = Course;
    this.type = Type;
    this.grade = Grade;
    this.date = Date;
    } 
    public String getID(){

    return stdid;
    }
    
     public String getFirstName(){

    return firstName;
    }
     
      public String getCourse(){

    return course;
    }
      
       public String getType(){

    return type;
    }
       
       public String getGrade(){

        return grade;
    }
       
        public String getDate(){

    return date;
    }
}  

