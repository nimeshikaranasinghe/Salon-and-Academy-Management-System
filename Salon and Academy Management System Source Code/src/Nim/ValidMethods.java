
package Nim;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class ValidMethods {
    
    public ValidMethods()
    {
        
    }
    
    public boolean textOnlyValidation1(String val)
    {
    //--- names without spaces "Devni"-----------//
        boolean valid = true;
        
        if(val.matches("[a-zA-Z]+"))
            valid = true;
        else
            valid = false;
                
        return valid;
    }
    
    public boolean textOnlyValidation2(String val)
    {
    //------------names with spaces "De Silva"----/// 
        boolean valid = true;
        
        if(val.matches("^[[a-zA-Z]+\\s?]+$"))
            valid = true;
        else
            valid = false;
                
        return valid;
    }
    
    public boolean addressValidation(String val)
    {
        boolean valid = true;
        
        if(val.matches("^[a-zA-Z]*(0-9|.|s)*[a-zA-Z]*$"))
            valid = true;
        else
            valid = false;
                
        return valid;
    }
    
    public boolean phoneValidation(String val)
    {
        boolean valid = true;
        
        if(val.matches("^[\\+?((?:[0-9]?){1,}[0-9])?|0\\d{9}]+$"))
            valid = true;
        else
            valid = false;
                
        return valid;
    }
    
    public boolean emailValidation(String val)
    {
        boolean valid = true;
        
        if(val.matches("^[[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]]*$"))
            valid = true;
        else
            valid = false;
                
        return valid;
    }
    
    public boolean dateValidation(Date selectedDate)
    {
    //------------check whether the selected date is greater than today-----------------//
        boolean valid = true;
        
        Date today = Calendar.getInstance().getTime();         //get current date  
        
        if(today.after(selectedDate))  //if today is after the selected date return true
            valid = true;
        else
            valid = false;
                
        return valid;
    }
    
    public boolean usernameValidation(String val)
    {
        boolean valid = true;
        
        if(val.matches("[[A-Za-z]+[0-9|_]*]{7,12}"))
            valid = true;
        else
            valid = false;
              
        return valid;
    }
    
}
