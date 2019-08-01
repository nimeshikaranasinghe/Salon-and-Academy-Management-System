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
public class Payments {
    
    private String stdid;
   private String course;
   private double fee;
   private double payment;
   private String type;
    private String date;
    private double remain;
    
    
    public Payments(String ID, String Course, double courseFee, double CurrentPayment, String Type, String Date, double remainAmount){
    
        this.stdid = ID;
        this.course = Course;
        this.fee = courseFee;
        this.payment = CurrentPayment;
        this.type = Type;
        this.date = Date;
        this.remain = remainAmount;
    
    }
    
    public String getID(){

    return stdid;
    }
    
    public String getCourse(){

    return course;
    }
    
    public double getcourseFee(){

    return fee;
    }
    
    
    public double getCurrentPayment(){

    return payment;
    }
    
    public String getType(){

    return type;
    }
    
    public String getDate(){

    return date;
    }
    
    public double remainAmount(){

    return remain;
    }
    
    
    
}


