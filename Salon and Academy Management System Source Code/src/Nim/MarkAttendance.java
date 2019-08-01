/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nim;

import Sohan.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author it15-102560
 */
public class MarkAttendance extends javax.swing.JFrame {

    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
    SalaryCalculation sc = new SalaryCalculation();
    
    String today = "";
    String timeT = "";  
    boolean textClicked = false;
    
    
    public MarkAttendance() {
        initComponents();
        
        readyToMark();
        
        //=====get and set today date==================//
        Date tdate = new Date();            
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  //decide date format
        String dateD = fmt.format(tdate);       //create a string representation of a date with the defined format.
        lbl_today.setText(dateD);
        System.out.println("date = "+tdate);
                
    }
    
    public void readyToMark(){
 
        lbl_war.setVisible(true);
        lbl_war.setText("Place your ID infront of the Reader.!");               //change the text
        lbl_error.setVisible(false);
        lbl_1.setVisible(false);
        lbl_fullname.setVisible(false);
        lbl_2.setVisible(false);
        lbl_report.setVisible(false);
        lbl_3.setVisible(false);
        lbl_leave.setVisible(false);
        txt_empid.setText(null);
        txt_empid.setEditable(true);
        
    }
    
 
    //=====thread to show current time==================//
    Thread one = new Thread(){
        public void run(){
            try{
                while(true){
                    Date d = new Date();
                    String s = d.toString();
                    String ar[] = s.split(" ");
                    lbl_time.setText(ar[3]);
                  
                    one.sleep(1000);
                }
            } 

            catch (InterruptedException v){
                System.out.println("Error in simulator, Please try again");
                System.out.println(v);
            }  
        }
    };
 

    //=====thread to check whether the id is entered==================//
    Thread two = new Thread(){
        public void run(){
            try{
                while(true){
                    while(txt_empid.getText().isEmpty()){
                        if (textClicked == false) {
                            txt_empid.setEditable(true);  
                            two.sleep(2000);            

                        }

                        else{
                                lbl_war.setVisible(false);
                                lbl_error.setVisible(true);
                                lbl_error.setText("Cannot Insert Employee ID by hand.!");
                                txt_empid.setEditable(false);                       //cannot edit the emp id

                                two.sleep(4000);                   //back to normal for enter the id
                                readyToMark();
                                textClicked =false;
                        }

                    }

                    //what to do when id is entered
                    txt_empid.setEditable(false);                       //cannot edit the emp id
                    today = lbl_today.getText();                    //get the date when card is scanned
                    timeT = lbl_time.getText();                     //get the time when card is scanned                    

                    setDetails();
                    two.sleep(2000);                   //back to normal for enter the id
                    readyToMark();
                    
                } 
            }                
            catch (InterruptedException v){
                System.out.println(v);
            }               
        }
    };
    
    //=====send attendance details to database==================//
    public void setDetails(){
        
        String fname = "";
        String lname = "";
               
        try{
            int empid = Integer.parseInt(txt_empid.getText());      //get the employee id
            String mor = "09:00:00";       //morning time
            Date morTime = new SimpleDateFormat("HH:mm:ss").parse(mor);
            String eve = "21:00:00";       //reject reporting time
            Date reportRejTime = new SimpleDateFormat("HH:mm:ss").parse(eve);
            String ot = "23:00:00";       //maximum ot time
            Date maxOTtime = new SimpleDateFormat("HH:mm:ss").parse(ot);
            String otStart = "17:00:00";       //ot starts from
            Date startOTtime = new SimpleDateFormat("HH:mm:ss").parse(otStart);
            Date markedTime = new SimpleDateFormat("HH:mm:ss").parse(timeT);
            
            //---search for that specific employee
            String query1 ="SELECT empId, empFName, empLName FROM Employee WHERE empId = "+empid+"";
            pst = dbc.con.prepareStatement(query1);
            rs = this.pst.executeQuery();

            if (rs.next()) {
                
                empid = rs.getInt(1);
                lname = rs.getString(2);
                fname = rs.getString(3);
                
                //set employee name
                lbl_1.setVisible(true);
                lbl_fullname.setVisible(true);
                lbl_fullname.setText(lname + " " + fname);            
            
            
        //=============================================================================================//

                //--check whether the employee has already reported---//
                String sql1 ="SELECT * FROM EmpAttendance WHERE empId = "+ empid +" AND today='"+ today +"'";
                pst=dbc.con.prepareStatement(sql1);
                rs=pst.executeQuery();
            
                if(rs.next()){
                    //--if employee is reported check whether the employee has already left---//
                    String sql2 ="SELECT * FROM EmpAttendance WHERE empId = "+empid+" AND today='"+today+"' AND endX LIKE '00:00:00'";
                    pst=dbc.con.prepareStatement(sql2);
                    rs=pst.executeQuery();
            
                    if(rs.next()){
                        //--set the leave time--//
                        lbl_war.setText("Attendance Marked");               //change the text
                        lbl_3.setVisible(true);
                        lbl_leave.setVisible(true);
                        lbl_leave.setText(timeT);
                        System.out.println("giyaaa");
                        
                        if (markedTime.after(maxOTtime)) {
                            timeT = "23:00:00";
                        }

                        //--insert leave time to database---//
                        String sql3="UPDATE EmpAttendance SET endX='"+timeT+"' WHERE empId="+empid+" AND today='"+today+"'";
                        pst=dbc.con.prepareStatement(sql3);
                        pst.executeUpdate();

                            //--check and insert for OT time
                        if (markedTime.after(startOTtime)) {
                            //OT is only added if the time is greater than one hour
                            sc.checkShortLeaves(empid, today);
                        }
                        
                        two.sleep(3000);
                        readyToMark();
                        
                    }
                    else{
                        lbl_war.setVisible(false);
                        lbl_error.setVisible(true);
                        lbl_error.setText("Error.!!");

                        two.sleep(3000);
                        readyToMark();
                    }
                }
                else{
                    //--set the report time--//
                    lbl_war.setText("Attendance Marked");               //change the text
                    lbl_2.setVisible(true);
                    lbl_report.setVisible(true);
                    lbl_report.setText(timeT);
                    System.out.println("awaaaaa");
                                        
                    if (markedTime.before(morTime)) {
                        timeT = "09:00:00";
                    }
                            //check for short leaves
                    else if(markedTime.after(morTime)){
                        sc.checkShortLeaves(timeT, empid);
                    }
                    
                    //--insert report time to database---//
                    String sql2="INSERT INTO EmpAttendance(empId, today, startX, endX) values("+ empid+ ", '"+ today +"', '"+ timeT +"', '')";
                    pst=dbc.con.prepareStatement(sql2);
                    pst.execute();
                       
                    if(markedTime.after(reportRejTime)){
                        String de = "DELETE from EmpAttendance where empId=" + empid + " AND startX = '"+ timeT +"'";
                        pst = dbc.con.prepareStatement(de);
                        pst.execute();
                    }
                    
                    two.sleep(3000);
                    readyToMark();
                }
         
            }
            //--error for invalid employee ids
            else{                       
                lbl_war.setVisible(false);
                lbl_error.setVisible(true);
                lbl_error.setText("Invalid Employee ID.!!");
                
                two.sleep(3000);
                readyToMark();
            }
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(this, err);
            readyToMark();
        }
        catch (InterruptedException v){
            System.out.println(v);
            readyToMark();
        }
        catch (NumberFormatException v){
            System.out.println(v);
            readyToMark();
        }
        catch (ParseException e) {
            System.out.println(e);
            readyToMark();
        }
         
    }
    
    
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        top_panel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_fullname = new javax.swing.JLabel();
        lbl_1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_2 = new javax.swing.JLabel();
        lbl_today = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        txt_empid = new javax.swing.JTextField();
        lbl_war = new javax.swing.JLabel();
        lbl_report = new javax.swing.JLabel();
        lbl_leave = new javax.swing.JLabel();
        lbl_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setOpaque(false);
        main_panel.setLayout(null);

        top_panel.setBackground(new java.awt.Color(52, 53, 57));
        top_panel.setMinimumSize(getPreferredSize());
        top_panel.setLayout(null);

        jButton2.setBackground(new java.awt.Color(52, 53, 57));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nim/Images/ic_close_white_16dp_1x.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        top_panel.add(jButton2);
        jButton2.setBounds(550, 10, 40, 30);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MARKING ATTENDANCE");
        top_panel.add(jLabel2);
        jLabel2.setBounds(180, 10, 220, 25);

        btn_back.setBackground(new java.awt.Color(57, 60, 64));
        btn_back.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back.setForeground(new java.awt.Color(204, 204, 204));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_keyboard_arrow_left_white_24dp_1x.png"))); // NOI18N
        btn_back.setBorderPainted(false);
        btn_back.setContentAreaFilled(false);
        btn_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back.setIconTextGap(10);
        btn_back.setOpaque(true);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        top_panel.add(btn_back);
        btn_back.setBounds(0, 0, 60, 50);

        main_panel.add(top_panel);
        top_panel.setBounds(0, 0, 600, 50);

        jPanel8.setBackground(new java.awt.Color(52, 53, 57));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        main_panel.add(jPanel8);
        jPanel8.setBounds(0, 460, 600, 30);

        jPanel2.setBackground(new java.awt.Color(12, 173, 183));
        jPanel2.setLayout(null);

        lbl_fullname.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lbl_fullname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fullname.setText("gain from previous form");
        jPanel2.add(lbl_fullname);
        lbl_fullname.setBounds(290, 120, 240, 30);

        lbl_1.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lbl_1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_1.setText("Employee Name : ");
        jPanel2.add(lbl_1);
        lbl_1.setBounds(130, 120, 150, 30);

        jLabel20.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(33, 33, 33));
        jLabel20.setText("Employee ID       : ");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(130, 70, 130, 30);

        lbl_time.setFont(new java.awt.Font("Leelawadee UI", 0, 30)); // NOI18N
        lbl_time.setForeground(new java.awt.Color(237, 237, 237));
        lbl_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_time.setText("time");
        jPanel2.add(lbl_time);
        lbl_time.setBounds(220, 210, 150, 40);

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(33, 33, 33));
        jLabel27.setText("Date                  :");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(130, 170, 110, 20);

        lbl_2.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lbl_2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_2.setText("Reporting time     :");
        lbl_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_2MouseClicked(evt);
            }
        });
        jPanel2.add(lbl_2);
        lbl_2.setBounds(130, 310, 150, 30);

        lbl_today.setFont(new java.awt.Font("Nirmala UI", 0, 20)); // NOI18N
        lbl_today.setForeground(new java.awt.Color(33, 33, 33));
        lbl_today.setText("today");
        jPanel2.add(lbl_today);
        lbl_today.setBounds(290, 160, 150, 40);

        lbl_3.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lbl_3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_3.setText("Leaving Time        :");
        lbl_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_3MouseClicked(evt);
            }
        });
        jPanel2.add(lbl_3);
        lbl_3.setBounds(130, 340, 150, 30);

        txt_empid.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txt_empid.setFocusCycleRoot(true);
        txt_empid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_empidMouseClicked(evt);
            }
        });
        txt_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_empidActionPerformed(evt);
            }
        });
        txt_empid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_empidKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_empidKeyTyped(evt);
            }
        });
        jPanel2.add(txt_empid);
        txt_empid.setBounds(290, 70, 130, 30);

        lbl_war.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        lbl_war.setForeground(new java.awt.Color(255, 255, 255));
        lbl_war.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_war.setText("Place your ID infront of the Reader.!");
        jPanel2.add(lbl_war);
        lbl_war.setBounds(130, 10, 300, 25);

        lbl_report.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lbl_report.setForeground(new java.awt.Color(255, 255, 255));
        lbl_report.setText("Reporting time      :");
        lbl_report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_reportMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_report);
        lbl_report.setBounds(300, 310, 240, 30);

        lbl_leave.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lbl_leave.setForeground(new java.awt.Color(255, 255, 255));
        lbl_leave.setText("Leaving Time        :");
        lbl_leave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_leaveMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_leave);
        lbl_leave.setBounds(300, 340, 240, 30);

        lbl_error.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(255, 51, 51));
        lbl_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error.setText("Error...!!!!");
        lbl_error.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_errorMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_error);
        lbl_error.setBounds(80, 270, 430, 32);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 50, 600, 410);

        getContentPane().add(main_panel);
        main_panel.setBounds(0, 0, 600, 490);

        setSize(new java.awt.Dimension(600, 490));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        //=====show current time==================//
        one.start();            // start the thread
        
        two.start();            // start the thread
        
        txt_empid.requestFocus();           //set cursor to text box when it is opened
               
    }//GEN-LAST:event_formWindowOpened

    private void lbl_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_2MouseClicked

        System.out.println("clicked");

    }//GEN-LAST:event_lbl_2MouseClicked

    private void lbl_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_3MouseClicked

    private void txt_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empidActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited

        jButton2.setBackground(new java.awt.Color(52,53,57));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered

        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton2MouseEntered

    private void lbl_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_reportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_reportMouseClicked

    private void lbl_leaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_leaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_leaveMouseClicked

    private void lbl_errorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_errorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_errorMouseClicked

    private void txt_empidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_empidMouseClicked
        textClicked = true;//****************************uncomment this
        
    }//GEN-LAST:event_txt_empidMouseClicked

    private void txt_empidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_empidKeyTyped
        
    }//GEN-LAST:event_txt_empidKeyTyped

    private void txt_empidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_empidKeyPressed
        //textClicked = true;//****************************uncomment this
    }//GEN-LAST:event_txt_empidKeyPressed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed

        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkAttendance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_fullname;
    private javax.swing.JLabel lbl_leave;
    private javax.swing.JLabel lbl_report;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_today;
    private javax.swing.JLabel lbl_war;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel top_panel;
    private javax.swing.JTextField txt_empid;
    // End of variables declaration//GEN-END:variables
}
