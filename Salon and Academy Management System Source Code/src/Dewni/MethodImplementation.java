 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dewni;

import Janani.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Janu
 */
public class MethodImplementation {

    Connection con = null;
    PreparedStatement ppst = null;
    ResultSet rs = null;
 DBconnect dbc = new DBconnect();
    public MethodImplementation() {
        con = dbc.con;
    }

    public ResultSet tableLoad(String sql) {

        try {
            ppst = con.prepareStatement(sql);
            rs = ppst.executeQuery();

        } catch (Exception e) {
            System.out.println("could not load table" + e);
        }

        return rs;
    }

    public boolean checkExistence(String input, String sql) {
        String dbColumn = "";

        try {
            ppst = con.prepareStatement(sql);
            rs = ppst.executeQuery();
            String s = DbUtils.resultSetToNestedList(rs).toString();
            int len = s.length();
            int end = len - 2;
            dbColumn = s.substring(2, end);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        if (input.equals(dbColumn)) {
            return true;
        } else {
            return false;
        }
    }

    public String ColumnFromDB(String sql) {
        String column = "";

        try {
            ppst = con.prepareStatement(sql);
            rs = ppst.executeQuery();
            String s = DbUtils.resultSetToNestedList(rs).toString();
            int len = s.length();
            int end = len - 2;
            column = s.substring(2, end);
        } catch (Exception e) {
            System.out.println("cannot get relevant column" + e);
        }

        return column;
    }

    public boolean ColumnToDB(String sql) {
        boolean state = false;
        try {
            ppst = con.prepareStatement(sql);
            ppst.execute();
            state = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }

    public boolean Validation(String name, String duration, String fee, String limit) {//Manager_course

        boolean state = false;
        int length = 0;
        char ch = ' ';

        if (!name.equals("")) {
            length = name.length();
            for (int i = 0; i < length; i++) {
                ch = name.charAt(i);
                if ((Character.isAlphabetic(ch)) | (Character.isSpaceChar(ch))) {
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid course name");
                    break;
                }
            }

            if (!duration.equals("")) {
                length = duration.length();
                for (int i = 0; i < length; i++) {
                    ch = duration.charAt(i);
                    if (Character.isDigit(ch)) {
                        state = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter the duration in months");
                        break;
                    }
                }

                if (!fee.equals("")) {
                    length = fee.length();
                    for (int i = 0; i < length; i++) {
                        ch = fee.charAt(i);
                        if (Character.isDigit(ch)) {
                            state = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter the fee in Rs");
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the course fee");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter the duration");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a course name");
        }

        return state;
    }

    public boolean ValidateHall_maintenance(String name, String capacity) {

        int length = 0;
        char ch = ' ';
        boolean state = false;
        if (!name.equals("")) {
            if (name.length() <= 5) {
                if (!capacity.equals("")) {
                    length = capacity.length();
                    for (int i = 0; i < length; i++) {
                        ch = capacity.charAt(i);
                        if (Character.isDigit(ch)) {
                            state = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter a valid capacity!");
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the hall capacity");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please provide a name with no more than 5 characters!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please enter a hall name");
        }
        return state;
    }

    public String monthToCompare(String date) {
        String monValue = null;
        String mon = date.substring(4, 7);

        if (mon.equals("Jan")) {
            monValue = "1";
        } else if (mon.equals("Feb")) {
            monValue = "2";
        } else if (mon.equals("Mar")) {
            monValue = "3";
        } else if (mon.equals("Apr")) {
            monValue = "4";
        } else if (mon.equals("May")) {
            monValue = "5";
        } else if (mon.equals("Jun")) {
            monValue = "6";
        } else if (mon.equals("Jul")) {
            monValue = "7";
        } else if (mon.equals("Aug")) {
            monValue = "8";
        } else if (mon.equals("Sep")) {
            monValue = "9";
        } else if (mon.equals("Oct")) {
            monValue = "10";
        } else if (mon.equals("Nov")) {
            monValue = "11";
        } else if (mon.equals("Dec")) {
            monValue = "12";
        }
        return monValue;
    }

    public String monthToDB(String date) {
        String monValue = null;
        String mon = date.substring(4, 7);

        if (mon.equals("Jan")) {
            monValue = "January";
        } else if (mon.equals("Feb")) {
            monValue = "February";
        } else if (mon.equals("Mar")) {
            monValue = "March";
        } else if (mon.equals("Apr")) {
            monValue = "April";
        } else if (mon.equals("May")) {
            monValue = "May";
        } else if (mon.equals("Jun")) {
            monValue = "June";
        } else if (mon.equals("Jul")) {
            monValue = "July";
        } else if (mon.equals("Aug")) {
            monValue = "August";
        } else if (mon.equals("Sep")) {
            monValue = "September";
        } else if (mon.equals("Oct")) {
            monValue = "October";
        } else if (mon.equals("Nov")) {
            monValue = "November";
        } else if (mon.equals("Dec")) {
            monValue = "December";
        }
        return monValue;
    }

    public boolean DateValidation(String date, String startTime, String currentTime) { //check if a passed date and time

        boolean state = false;

        //String x = dateChooser.getDate().toString();
        String Hyear = date.substring(24, 28); // get user input date
        String Hmonth = monthToCompare(date);
        String Hdate = date.substring(8, 10);
        String stHr = startTime.substring(0, 2);
        String stMin = startTime.substring(3, 5);

        int userYr, userMnth, userDate, userHour, userMin = 0;
        userYr = Integer.parseInt(Hyear); // conversion of user entered year to int
        userMnth = Integer.parseInt(Hmonth);
        userDate = Integer.parseInt(Hdate);
        userHour = Integer.parseInt(stHr);
        userMin = Integer.parseInt(stMin);

        String yyr = currentTime.substring(0, 4); // get currrent year from the string f
        String mmnth = currentTime.substring(5, 7);
        String ddt = currentTime.substring(8, 10); // get current date from the string f
        String hours = currentTime.substring(11, 13);
        String mins = currentTime.substring(14, 16);

        int yr, mnth, dt, shr, smin = 0;
        yr = Integer.parseInt(yyr); // convert current year from string to int
        mnth = Integer.parseInt(mmnth);
        dt = Integer.parseInt(ddt);
        shr = Integer.parseInt(hours);
        smin = Integer.parseInt(mins);

        if ((userYr == yr) || (userYr > yr)) { // if user entered year is the current year or future year, ok 
            if (((userYr == yr) && (userMnth >= mnth)) || ((userYr > yr) && (userMnth >= mnth)) || ((userYr > yr) && (userMnth < mnth))) {
                if (((userYr == yr) && (userMnth >= mnth) && (userDate >= dt)) || ((userYr == yr) && (userMnth > mnth) && (userDate < dt)) || ((userYr == yr) && (userMnth > mnth) && (userDate >= dt))
                        || ((userYr > yr) && (userMnth >= mnth) && (userDate >= dt)) || ((userYr > yr) && (userMnth >= mnth) && (userDate < dt))
                        || ((userYr > yr) && (userMnth < mnth) && (userDate >= dt)) || ((userYr > yr) && (userMnth < mnth) && (userDate < dt))) {
                    if (((userYr == yr) && (userMnth == mnth) && (userDate >= dt) && (userHour >= shr)) || ((userYr == yr) && (userMnth == mnth) && (userDate > dt) && (userHour < shr))
                            || ((userYr == yr) && (userMnth > mnth) && (userDate > dt) && (userHour >= shr)) || ((userYr == yr) && (userMnth > mnth) && (userDate < dt) && (userHour >= shr))
                            || ((userYr == yr) && (userMnth > mnth) && (userDate < dt) && (userHour < shr)) || ((userYr == yr) && (userMnth > mnth) && (userDate > dt) && (userHour < shr))
                            || ((userYr > yr) && (userMnth < mnth) && (userDate >= dt) && (userHour >= shr)) || ((userYr > yr) && (userMnth < mnth) && (userDate < dt) && (userHour >= shr))
                            || ((userYr > yr) && (userMnth >= mnth) && (userDate >= dt) && (userHour >= shr)) || ((userYr > yr) && (userMnth >= mnth) && (userDate < dt) && (userHour >= shr))
                            || ((userYr > yr) && (userMnth < mnth) && (userDate >= dt) && (userHour < shr)) || ((userYr > yr) && (userMnth >= mnth) && (userDate >= dt) && (userHour < shr))
                            || ((userYr > yr) && (userMnth >= mnth) && (userDate < dt) && (userHour < shr)) || ((userYr > yr) && (userMnth < mnth) && (userDate < dt) && (userHour < shr))) {
                        if (((userYr == yr) && (userMnth == mnth) && (userDate == dt) && (userHour == shr) && (userMin >= smin)) || ((userYr == yr) && (userMnth == mnth) && (userDate == dt) && (userHour >= shr) && (userMin >= smin))
                                || ((userYr == yr) && (userMnth == mnth) && (userDate == dt) && (userHour > shr) && (userMin < smin)) || ((userYr == yr) && (userMnth == mnth) && (userDate > dt) && (userHour >= shr) && (userMin >= smin))
                                || ((userYr == yr) && (userMnth == mnth) && (userDate > dt) && (userHour < shr) && (userMin >= smin)) || ((userYr == yr) && (userMnth == mnth) && (userDate > dt) && (userHour >= shr) && (userMin < smin))
                                || ((userYr == yr) && (userMnth == mnth) && (userDate > dt) && (userHour < shr) && (userMin < smin)) || ((userYr == yr) && (userMnth > mnth) && (userDate > dt) && (userHour >= shr) && (userMin >= smin))
                                || ((userYr == yr) && (userMnth > mnth) && (userDate > dt) && (userHour >= shr) && (userMin < smin)) || ((userYr == yr) && (userMnth > mnth) && (userDate > dt) && (userHour < shr) && (userMin >= smin))
                                || ((userYr == yr) && (userMnth > mnth) && (userDate < dt) && (userHour >= shr) && (userMin >= smin)) || ((userYr == yr) && (userMnth > mnth) && (userDate < dt) && (userHour >= shr) && (userMin < smin))
                                || ((userYr == yr) && (userMnth > mnth) && (userDate < dt) && (userHour < shr) && (userMin >= smin)) || ((userYr == yr) && (userMnth > mnth) && (userDate < dt) && (userHour < shr) && (userMin < smin))
                                || ((userYr == yr) && (userMnth > mnth) && (userDate > dt) && (userHour < shr) && (userMin < smin)) || ((userYr > yr) && (userMnth >= mnth) && (userDate >= dt) && (userHour >= shr) && (userMin >= smin))
                                || ((userYr > yr) && (userMnth >= mnth) && (userDate >= dt) && (userHour >= shr) && (userMin < smin)) || ((userYr > yr) && (userMnth >= mnth) && (userDate >= dt) && (userHour < shr) && (userMin >= smin))
                                || ((userYr > yr) && (userMnth >= mnth) && (userDate >= dt) && (userHour < shr) && (userMin < smin)) || ((userYr > yr) && (userMnth >= mnth) && (userDate < dt) && (userHour >= shr) && (userMin >= smin))
                                || ((userYr > yr) && (userMnth >= mnth) && (userDate < dt) && (userHour >= shr) && (userMin < smin)) || ((userYr > yr) && (userMnth >= mnth) && (userDate < dt) && (userHour < shr) && (userMin >= smin))
                                || ((userYr > yr) && (userMnth >= mnth) && (userDate < dt) && (userHour < shr) && (userMin < smin)) || ((userYr > yr) && (userMnth < mnth) && (userDate >= dt) && (userHour >= shr) && (userMin >= smin))
                                || ((userYr > yr) && (userMnth < mnth) && (userDate >= dt) && (userHour >= shr) && (userMin < smin)) || ((userYr > yr) && (userMnth < mnth) && (userDate >= dt) && (userHour < shr) && (userMin >= smin))
                                || ((userYr > yr) && (userMnth < mnth) && (userDate >= dt) && (userHour < shr) && (userMin < smin)) || ((userYr > yr) && (userMnth < mnth) && (userDate < dt) && (userHour >= shr) && (userMin >= smin))
                                || ((userYr > yr) && (userMnth < mnth) && (userDate < dt) && (userHour >= shr) && (userMin < smin)) || ((userYr > yr) && (userMnth < mnth) && (userDate < dt) && (userHour < shr) && (userMin >= smin))
                                || ((userYr > yr) && (userMnth < mnth) && (userDate < dt) && (userHour < shr) && (userMin < smin))) {
                            state = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid time!");
                            state = false;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid time!");
                        state = false;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid day!");
                    state = false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid month!");
                state = false;
            }
        } else {// if the user entered year is already passed
            JOptionPane.showMessageDialog(null, "Invalid year");
            state = false;
        }
        return state;
    }
    public boolean HallBookingNullFieldValidation(String Hname, String Hstart, String Hend, String date) {
        boolean status = false;
        if (!Hname.equals("Select")) {
            if (!date.equals("")) {  
                if (!Hstart.equals("Select")) {
                    if (!Hend.equals("Select")) {
                        status = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select an end time");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a start time");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please select a date!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a hall name");
        }
        return status;
    }
   
    public String year (String input){
    return (input.substring(24, 28));
    }
    public String date (String input){
    return (input.substring(8, 10));
    }

    
    

}
