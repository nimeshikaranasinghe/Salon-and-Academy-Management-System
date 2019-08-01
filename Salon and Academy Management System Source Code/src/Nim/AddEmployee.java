
package Nim;

import Sohan.*;
import Nim.ValidMethods.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class AddEmployee extends javax.swing.JFrame {

    ResultSet rs;
    PreparedStatement ps;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
    ValidMethods vm = new ValidMethods();  //class object for validate text feilds 
    
    boolean checkBoxValue = true;
    int areaCount = 0;                      //to keep track of selected area count
    String areas[] = new String[10];        //array to store selected areas
    List valid = Arrays.asList(areas);      //used to check an array element is empty
    
    public AddEmployee() {
        
        initComponents();
        
        lbl_areas.setEnabled(false);
        combo_areas.setEnabled(false);
        pnl_Sareas.setEnabled(true);
        aError.setVisible(false);       //cannot add more than 10 areas error
        
        Date cdate = new Date();
        birth.setDate(cdate); 
        birth.setMaxSelectableDate(cdate);

        fillAreas();        
        idAutoGenerate();
        setErrorsInvisible();
        ResetAreaSuff();
        
    }
    
    
    //======set errors feilds invisible=================================//
    public void setErrorsInvisible()
    {
        lbl_e1.setVisible(false);
        lbl_e2.setVisible(false);
        lbl_e3.setVisible(false);
        lbl_e4.setVisible(false);
        lbl_e5.setVisible(false);
        lbl_e7.setVisible(false);
        lbl_e8.setVisible(false);
        lbl_e9.setVisible(false);
        lbl_e10.setVisible(false);
        lbl_e11.setVisible(false);        
    }
    
    //======make selected areas invisible======================//
    public void setSareasInvisible()
    {
        pnl_a1.setVisible(false);
        pnl_a2.setVisible(false);
        pnl_a3.setVisible(false);
        pnl_a4.setVisible(false);
        pnl_a5.setVisible(false);
        pnl_a6.setVisible(false);
        pnl_a7.setVisible(false);
        pnl_a8.setVisible(false);
        pnl_a9.setVisible(false);
        pnl_a10.setVisible(false);
        
    }
    
    //======Reset areas related feilds and make invisible them==========================/
    public void ResetAreaSuff()
    {
        lbl_areas.setEnabled(false);
        combo_areas.setEnabled(false);
        combo_areas.setSelectedIndex(0);
        pnl_Sareas.setEnabled(false);
        setSareasInvisible(); 
        areaCount = 0;
        aError.setVisible(false);
    }
    
    //======auto generate id=================================================//
    private void idAutoGenerate()
    {
        String queryid = "SELECT MAX(empId) FROM Employee";
        String nextempid;

        try {
            ps = dbc.con.prepareStatement(queryid);
            rs = this.ps.executeQuery();

            while (rs.next()) {
                nextempid = rs.getString(1);
                lbl_empid.setText(Integer.toString(Integer.parseInt(nextempid)+4));
            }

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }       
        
    }

    //======fill combo box areas===============================//
    private void fillAreas() {
        String query = "SELECT * FROM treatment";

        String area;
        int count;

        try {
            ps = dbc.con.prepareStatement(query);
            rs = this.ps.executeQuery();

            while (rs.next()) {
                area = rs.getString(2);
                combo_areas.addItem(area);        
            }

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }
    }
    
    //======set lables to selected area============================///
    private void setLables() {
        
        String a1 = combo_areas.getSelectedItem().toString();
        
        if(areaCount <= 10)
        {
            if(!valid.contains(a1))                 //check whether the combo selected item 
            {
                aError.setVisible(false);
                if (!pnl_a1.isVisible()) {
                    pnl_a1.setVisible(true);
                    area1.setText(a1);
                }

                else if (!pnl_a2.isVisible()) {
                    pnl_a2.setVisible(true);
                    area2.setText(a1);           
                }
                else if (!pnl_a3.isVisible()) {
                    pnl_a3.setVisible(true);
                    area3.setText(a1);           
                }
                else if (!pnl_a4.isVisible()) {
                    pnl_a4.setVisible(true);
                    area4.setText(a1);           
                }
                else if (!pnl_a5.isVisible()) {
                    pnl_a5.setVisible(true);
                    area5.setText(a1);           
                }
                else if (!pnl_a6.isVisible()) {
                    pnl_a6.setVisible(true);
                    area6.setText(a1);           
                }
                else if (!pnl_a7.isVisible()) {
                    pnl_a7.setVisible(true);
                    area7.setText(a1);           
                }
                else if (!pnl_a8.isVisible()) {
                    pnl_a8.setVisible(true);
                    area8.setText(a1);           
                }
                else if (!pnl_a9.isVisible()) {
                    pnl_a9.setVisible(true);
                    area9.setText(a1);           
                }
                else{
                    pnl_a10.setVisible(true);
                    area10.setText(a1);           
                }
                
                areas[areaCount] = a1;
                areaCount++;
            }
            else
            {
                aError.setVisible(true);
                aError.setText("Area has already added");
            }
        }
        else{
            aError.setVisible(true);
            aError.setText("Only 10 areas are allowed at a time");
        }
         
     }
    
   
    //======check boxes validation==============================//
    private void checkBoxesFunction(){
        
        if(chk_lec.isSelected() || chk_beau.isSelected())
        {
            chk_rep.setSelected(false);
            chk_acc.setSelected(false);
            lbl_areas.setEnabled(true);
            combo_areas.setEnabled(true);
            pnl_Sareas.setEnabled(true);
            
        }
        else
            ResetAreaSuff();
        
    }
    
    //======check for existing username=======================================//
    private boolean validateUsername(String newUser)
    {            
        String userX = "SELECT username FROM Employee WHERE username = '"+newUser+"'";
        boolean valid = false;
        try {
            ps = dbc.con.prepareStatement(userX);
            rs = this.ps.executeQuery();

            if (rs.next()) 
                valid = true;
                      
            else
                valid = false;

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }
        return valid;
    }
    
    
    
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        main_panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        side_bar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        lbl_empid = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_fname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        birth = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        txt_pwd = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        lbl_areas = new javax.swing.JLabel();
        txt_lname = new javax.swing.JTextField();
        btn_addEmployee = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        chk_beau = new javax.swing.JCheckBox();
        chk_lec = new javax.swing.JCheckBox();
        chk_rep = new javax.swing.JCheckBox();
        combo_areas = new javax.swing.JComboBox<>();
        chk_acc = new javax.swing.JCheckBox();
        lbl_e1 = new javax.swing.JLabel();
        lbl_e2 = new javax.swing.JLabel();
        lbl_e3 = new javax.swing.JLabel();
        lbl_e4 = new javax.swing.JLabel();
        lbl_e9 = new javax.swing.JLabel();
        lbl_e10 = new javax.swing.JLabel();
        lbl_e11 = new javax.swing.JLabel();
        lbl_e7 = new javax.swing.JLabel();
        lbl_e5 = new javax.swing.JLabel();
        lbl_e8 = new javax.swing.JLabel();
        combo_gender = new javax.swing.JComboBox<>();
        pnl_Sareas = new javax.swing.JPanel();
        pnl_a2 = new javax.swing.JPanel();
        area2 = new javax.swing.JLabel();
        lbl_ax2 = new javax.swing.JLabel();
        pnl_a3 = new javax.swing.JPanel();
        area3 = new javax.swing.JLabel();
        lbl_ax3 = new javax.swing.JLabel();
        pnl_a1 = new javax.swing.JPanel();
        area1 = new javax.swing.JLabel();
        lbl_ax1 = new javax.swing.JLabel();
        pnl_a4 = new javax.swing.JPanel();
        area4 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        pnl_a5 = new javax.swing.JPanel();
        area5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnl_a6 = new javax.swing.JPanel();
        area6 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        pnl_a8 = new javax.swing.JPanel();
        area8 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        pnl_a7 = new javax.swing.JPanel();
        area7 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pnl_a10 = new javax.swing.JPanel();
        area10 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        pnl_a9 = new javax.swing.JPanel();
        area9 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        aError = new javax.swing.JLabel();
        pnl_mand_phone = new javax.swing.JPanel();
        pnl_mand_phone1 = new javax.swing.JPanel();
        pnl_mand_phone2 = new javax.swing.JPanel();
        pnl_mand_phone3 = new javax.swing.JPanel();
        pnl_mand_phone4 = new javax.swing.JPanel();
        pnl_mand_phone5 = new javax.swing.JPanel();
        pnl_mand_phone6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        top_panel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setOpaque(false);
        main_panel.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Check Attendance");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel10);
        jLabel10.setBounds(370, 73, 122, 17);

        jPanel11.setBackground(new java.awt.Color(12, 173, 183));
        jPanel11.setPreferredSize(new java.awt.Dimension(170, 7));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel11);
        jPanel11.setBounds(0, 96, 200, 7);

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Add Employee");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel11);
        jLabel11.setBounds(53, 73, 92, 17);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Serach Employee");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel13);
        jLabel13.setBounds(687, 73, 133, 17);

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

        side_bar.setBackground(new java.awt.Color(12, 173, 183));

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        main_panel.add(side_bar);
        side_bar.setBounds(860, 50, 220, 610);

        jPanel8.setBackground(new java.awt.Color(52, 53, 57));
        jPanel8.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 255, 51));
        jLabel26.setText("Mandatory Field");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel8.add(jLabel26);
        jLabel26.setBounds(60, 0, 90, 20);

        jPanel3.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel3);
        jPanel3.setBounds(40, 8, 8, 8);

        main_panel.add(jPanel8);
        jPanel8.setBounds(0, 660, 1080, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(33, 33, 33));
        jLabel14.setText("Last name");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(50, 120, 110, 20);

        txt_email.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_email.setNextFocusableComponent(combo_gender);
        txt_email.setOpaque(false);
        txt_email.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_email);
        txt_email.setBounds(170, 240, 168, 25);

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(33, 33, 33));
        jLabel15.setText("Email ");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(50, 240, 110, 20);

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(33, 33, 33));
        jLabel17.setText("Gender");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(50, 280, 110, 20);

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(33, 33, 33));
        jLabel18.setText("Date of Birth");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(50, 320, 110, 20);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 33, 33));
        jLabel21.setText("Phone Number");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(50, 200, 110, 20);

        txt_phone.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_phone.setNextFocusableComponent(txt_email);
        txt_phone.setOpaque(false);
        txt_phone.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_phone);
        txt_phone.setBounds(170, 200, 168, 25);

        jLabel20.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(33, 33, 33));
        jLabel20.setText("Address");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(50, 160, 110, 20);

        txt_address.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_address.setNextFocusableComponent(txt_phone);
        txt_address.setOpaque(false);
        txt_address.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_address);
        txt_address.setBounds(170, 160, 168, 25);

        lbl_empid.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_empid.setForeground(new java.awt.Color(33, 33, 33));
        lbl_empid.setText("auto generate");
        jPanel2.add(lbl_empid);
        lbl_empid.setBounds(170, 40, 110, 20);

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(33, 33, 33));
        jLabel27.setText("First Name");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(50, 80, 110, 20);

        txt_fname.setFocusCycleRoot(true);
        txt_fname.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_fname.setNextFocusableComponent(txt_lname);
        txt_fname.setOpaque(false);
        txt_fname.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_fname);
        txt_fname.setBounds(170, 80, 168, 25);

        jLabel28.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(33, 33, 33));
        jLabel28.setText("Employee ID");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(50, 40, 110, 20);

        birth.setDateFormatString("yyyy-MM-dd ");
        birth.setFont(new java.awt.Font("Nirmala UI", 0, 11)); // NOI18N
        birth.setNextFocusableComponent(txt_username);
        jPanel2.add(birth);
        birth.setBounds(170, 320, 170, 20);

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(33, 33, 33));
        jLabel22.setText("Username");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(490, 280, 110, 20);

        txt_pwd.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_pwd.setOpaque(false);
        txt_pwd.setPreferredSize(new java.awt.Dimension(5, 20));
        txt_pwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_pwdMouseClicked(evt);
            }
        });
        jPanel2.add(txt_pwd);
        txt_pwd.setBounds(610, 320, 168, 25);

        jLabel23.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(33, 33, 33));
        jLabel23.setText("Password ");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(490, 320, 110, 20);

        txt_username.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_username.setNextFocusableComponent(txt_pwd);
        txt_username.setOpaque(false);
        txt_username.setPreferredSize(new java.awt.Dimension(5, 20));
        txt_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_usernameMouseClicked(evt);
            }
        });
        jPanel2.add(txt_username);
        txt_username.setBounds(610, 280, 168, 25);

        lbl_areas.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_areas.setForeground(new java.awt.Color(33, 33, 33));
        lbl_areas.setText("Specialized Areas");
        jPanel2.add(lbl_areas);
        lbl_areas.setBounds(490, 50, 110, 20);

        txt_lname.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_lname.setNextFocusableComponent(txt_address);
        txt_lname.setOpaque(false);
        txt_lname.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_lname);
        txt_lname.setBounds(170, 120, 168, 25);

        btn_addEmployee.setBackground(new java.awt.Color(12, 173, 183));
        btn_addEmployee.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn_addEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btn_addEmployee.setText("Add Employee");
        btn_addEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addEmployeeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_addEmployee);
        btn_addEmployee.setBounds(570, 390, 210, 40);

        jLabel25.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(33, 33, 33));
        jLabel25.setText("Post");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(50, 360, 110, 20);

        chk_beau.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        chk_beau.setText("Beautician");
        chk_beau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_beauActionPerformed(evt);
            }
        });
        jPanel2.add(chk_beau);
        chk_beau.setBounds(270, 360, 81, 23);

        chk_lec.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        chk_lec.setText("Lecturer");
        chk_lec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_lecActionPerformed(evt);
            }
        });
        jPanel2.add(chk_lec);
        chk_lec.setBounds(170, 360, 69, 25);

        chk_rep.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        chk_rep.setText("Receptionist");
        chk_rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_repActionPerformed(evt);
            }
        });
        jPanel2.add(chk_rep);
        chk_rep.setBounds(170, 400, 91, 23);

        combo_areas.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        combo_areas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-" }));
        combo_areas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_areasActionPerformed(evt);
            }
        });
        jPanel2.add(combo_areas);
        combo_areas.setBounds(610, 50, 170, 22);

        chk_acc.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        chk_acc.setText("Accountant");
        chk_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_accActionPerformed(evt);
            }
        });
        jPanel2.add(chk_acc);
        chk_acc.setBounds(270, 400, 87, 23);

        lbl_e1.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e1.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e1.setText("Can contain only letters");
        jPanel2.add(lbl_e1);
        lbl_e1.setBounds(170, 100, 150, 20);

        lbl_e2.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e2.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e2.setText("Can contain only letters and spaces");
        jPanel2.add(lbl_e2);
        lbl_e2.setBounds(170, 140, 170, 20);

        lbl_e3.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e3.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e3.setText("Provide valid address");
        jPanel2.add(lbl_e3);
        lbl_e3.setBounds(170, 180, 150, 20);

        lbl_e4.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e4.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e4.setText("Input valid phone number");
        jPanel2.add(lbl_e4);
        lbl_e4.setBounds(170, 220, 150, 20);

        lbl_e9.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e9.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e9.setText("Select at least one area");
        jPanel2.add(lbl_e9);
        lbl_e9.setBounds(610, 70, 150, 20);

        lbl_e10.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e10.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e10.setText("Should contain at least 6 characters");
        lbl_e10.setEnabled(false);
        jPanel2.add(lbl_e10);
        lbl_e10.setBounds(610, 300, 200, 20);

        lbl_e11.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e11.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e11.setText("Should contain at least 6 characters");
        lbl_e11.setEnabled(false);
        jPanel2.add(lbl_e11);
        lbl_e11.setBounds(610, 340, 220, 20);

        lbl_e7.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e7.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e7.setText("Provide valid Birthday");
        jPanel2.add(lbl_e7);
        lbl_e7.setBounds(170, 335, 150, 20);

        lbl_e5.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e5.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e5.setText("Eg: user@domain.com");
        jPanel2.add(lbl_e5);
        lbl_e5.setBounds(170, 260, 150, 20);

        lbl_e8.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e8.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e8.setText("Select at least one feild");
        jPanel2.add(lbl_e8);
        lbl_e8.setBounds(170, 420, 150, 20);

        combo_gender.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        combo_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Male", "Female", "Not Specified" }));
        combo_gender.setNextFocusableComponent(birth);
        jPanel2.add(combo_gender);
        combo_gender.setBounds(170, 280, 170, 22);

        pnl_Sareas.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Sareas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selected Specialized Areas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nirmala UI", 0, 12), new java.awt.Color(102, 102, 255))); // NOI18N
        pnl_Sareas.setEnabled(false);
        pnl_Sareas.setLayout(null);

        pnl_a2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a2.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a2.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a2.setLayout(null);

        area2.setBackground(new java.awt.Color(204, 204, 204));
        area2.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area2.setText("Nail Coloring");
        area2.setOpaque(true);
        pnl_a2.add(area2);
        area2.setBounds(2, 2, 110, 19);

        lbl_ax2.setBackground(new java.awt.Color(204, 204, 204));
        lbl_ax2.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        lbl_ax2.setForeground(new java.awt.Color(111, 148, 255));
        lbl_ax2.setText("X");
        lbl_ax2.setOpaque(true);
        lbl_ax2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ax2MouseClicked(evt);
            }
        });
        pnl_a2.add(lbl_ax2);
        lbl_ax2.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a2);
        pnl_a2.setBounds(135, 18, 124, 23);

        pnl_a3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a3.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a3.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a3.setLayout(null);

        area3.setBackground(new java.awt.Color(204, 204, 204));
        area3.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area3.setText("Nail Coloring");
        area3.setOpaque(true);
        pnl_a3.add(area3);
        area3.setBounds(2, 2, 110, 19);

        lbl_ax3.setBackground(new java.awt.Color(204, 204, 204));
        lbl_ax3.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        lbl_ax3.setForeground(new java.awt.Color(111, 148, 255));
        lbl_ax3.setText("X");
        lbl_ax3.setOpaque(true);
        lbl_ax3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ax3MouseClicked(evt);
            }
        });
        pnl_a3.add(lbl_ax3);
        lbl_ax3.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a3);
        pnl_a3.setBounds(9, 42, 124, 23);

        pnl_a1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a1.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a1.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a1.setLayout(null);

        area1.setBackground(new java.awt.Color(204, 204, 204));
        area1.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area1.setText("Nail Coloring");
        area1.setOpaque(true);
        pnl_a1.add(area1);
        area1.setBounds(2, 2, 110, 19);

        lbl_ax1.setBackground(new java.awt.Color(204, 204, 204));
        lbl_ax1.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        lbl_ax1.setForeground(new java.awt.Color(111, 148, 255));
        lbl_ax1.setText("X");
        lbl_ax1.setOpaque(true);
        lbl_ax1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ax1MouseClicked(evt);
            }
        });
        pnl_a1.add(lbl_ax1);
        lbl_ax1.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a1);
        pnl_a1.setBounds(9, 18, 124, 23);

        pnl_a4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a4.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a4.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a4.setLayout(null);

        area4.setBackground(new java.awt.Color(204, 204, 204));
        area4.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area4.setText("Nail Coloring");
        area4.setOpaque(true);
        pnl_a4.add(area4);
        area4.setBounds(2, 2, 110, 19);

        jLabel31.setBackground(new java.awt.Color(204, 204, 204));
        jLabel31.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(111, 148, 255));
        jLabel31.setText("X");
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        pnl_a4.add(jLabel31);
        jLabel31.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a4);
        pnl_a4.setBounds(135, 42, 124, 23);

        pnl_a5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a5.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a5.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a5.setLayout(null);

        area5.setBackground(new java.awt.Color(204, 204, 204));
        area5.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area5.setText("Nail Coloring");
        area5.setOpaque(true);
        pnl_a5.add(area5);
        area5.setBounds(2, 2, 110, 19);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(111, 148, 255));
        jLabel4.setText("X");
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        pnl_a5.add(jLabel4);
        jLabel4.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a5);
        pnl_a5.setBounds(9, 66, 124, 23);

        pnl_a6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a6.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a6.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a6.setLayout(null);

        area6.setBackground(new java.awt.Color(204, 204, 204));
        area6.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area6.setText("Nail Coloring");
        area6.setOpaque(true);
        pnl_a6.add(area6);
        area6.setBounds(2, 2, 110, 19);

        jLabel33.setBackground(new java.awt.Color(204, 204, 204));
        jLabel33.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(111, 148, 255));
        jLabel33.setText("X");
        jLabel33.setOpaque(true);
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        pnl_a6.add(jLabel33);
        jLabel33.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a6);
        pnl_a6.setBounds(135, 66, 124, 23);

        pnl_a8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a8.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a8.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a8.setLayout(null);

        area8.setBackground(new java.awt.Color(204, 204, 204));
        area8.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area8.setText("Nail Coloring");
        area8.setOpaque(true);
        pnl_a8.add(area8);
        area8.setBounds(2, 2, 110, 19);

        jLabel35.setBackground(new java.awt.Color(204, 204, 204));
        jLabel35.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(111, 148, 255));
        jLabel35.setText("X");
        jLabel35.setOpaque(true);
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });
        pnl_a8.add(jLabel35);
        jLabel35.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a8);
        pnl_a8.setBounds(135, 90, 124, 23);

        pnl_a7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a7.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a7.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a7.setLayout(null);

        area7.setBackground(new java.awt.Color(204, 204, 204));
        area7.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area7.setText("Nail Coloring");
        area7.setOpaque(true);
        pnl_a7.add(area7);
        area7.setBounds(2, 2, 110, 19);

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(111, 148, 255));
        jLabel37.setText("X");
        jLabel37.setOpaque(true);
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        pnl_a7.add(jLabel37);
        jLabel37.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a7);
        pnl_a7.setBounds(9, 90, 124, 23);

        pnl_a10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a10.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a10.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a10.setLayout(null);

        area10.setBackground(new java.awt.Color(204, 204, 204));
        area10.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area10.setText("Nail Coloring");
        area10.setOpaque(true);
        pnl_a10.add(area10);
        area10.setBounds(2, 2, 110, 19);

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(111, 148, 255));
        jLabel39.setText("X");
        jLabel39.setOpaque(true);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        pnl_a10.add(jLabel39);
        jLabel39.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a10);
        pnl_a10.setBounds(135, 114, 124, 23);

        pnl_a9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 148, 255), 50));
        pnl_a9.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a9.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a9.setLayout(null);

        area9.setBackground(new java.awt.Color(204, 204, 204));
        area9.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        area9.setText("Nail Coloring");
        area9.setOpaque(true);
        pnl_a9.add(area9);
        area9.setBounds(2, 2, 110, 19);

        jLabel41.setBackground(new java.awt.Color(204, 204, 204));
        jLabel41.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(111, 148, 255));
        jLabel41.setText("X");
        jLabel41.setOpaque(true);
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        pnl_a9.add(jLabel41);
        jLabel41.setBounds(112, 2, 10, 19);

        pnl_Sareas.add(pnl_a9);
        pnl_a9.setBounds(9, 114, 124, 23);

        jPanel2.add(pnl_Sareas);
        pnl_Sareas.setBounds(520, 90, 270, 150);

        aError.setFont(new java.awt.Font("Nirmala UI", 0, 11)); // NOI18N
        aError.setForeground(new java.awt.Color(255, 102, 102));
        aError.setText("Only 10 areas are allowed at a time");
        jPanel2.add(aError);
        aError.setBounds(530, 233, 220, 20);

        pnl_mand_phone.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_phoneLayout = new javax.swing.GroupLayout(pnl_mand_phone);
        pnl_mand_phone.setLayout(pnl_mand_phoneLayout);
        pnl_mand_phoneLayout.setHorizontalGroup(
            pnl_mand_phoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_phoneLayout.setVerticalGroup(
            pnl_mand_phoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_phone);
        pnl_mand_phone.setBounds(35, 127, 8, 8);

        pnl_mand_phone1.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_phone1Layout = new javax.swing.GroupLayout(pnl_mand_phone1);
        pnl_mand_phone1.setLayout(pnl_mand_phone1Layout);
        pnl_mand_phone1Layout.setHorizontalGroup(
            pnl_mand_phone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_phone1Layout.setVerticalGroup(
            pnl_mand_phone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_phone1);
        pnl_mand_phone1.setBounds(35, 167, 8, 8);

        pnl_mand_phone2.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_phone2Layout = new javax.swing.GroupLayout(pnl_mand_phone2);
        pnl_mand_phone2.setLayout(pnl_mand_phone2Layout);
        pnl_mand_phone2Layout.setHorizontalGroup(
            pnl_mand_phone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_phone2Layout.setVerticalGroup(
            pnl_mand_phone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_phone2);
        pnl_mand_phone2.setBounds(35, 207, 8, 8);

        pnl_mand_phone3.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_phone3Layout = new javax.swing.GroupLayout(pnl_mand_phone3);
        pnl_mand_phone3.setLayout(pnl_mand_phone3Layout);
        pnl_mand_phone3Layout.setHorizontalGroup(
            pnl_mand_phone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_phone3Layout.setVerticalGroup(
            pnl_mand_phone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_phone3);
        pnl_mand_phone3.setBounds(35, 327, 8, 8);

        pnl_mand_phone4.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_phone4Layout = new javax.swing.GroupLayout(pnl_mand_phone4);
        pnl_mand_phone4.setLayout(pnl_mand_phone4Layout);
        pnl_mand_phone4Layout.setHorizontalGroup(
            pnl_mand_phone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_phone4Layout.setVerticalGroup(
            pnl_mand_phone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_phone4);
        pnl_mand_phone4.setBounds(35, 367, 8, 8);

        pnl_mand_phone5.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_phone5Layout = new javax.swing.GroupLayout(pnl_mand_phone5);
        pnl_mand_phone5.setLayout(pnl_mand_phone5Layout);
        pnl_mand_phone5Layout.setHorizontalGroup(
            pnl_mand_phone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_phone5Layout.setVerticalGroup(
            pnl_mand_phone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_phone5);
        pnl_mand_phone5.setBounds(475, 287, 8, 8);

        pnl_mand_phone6.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_phone6Layout = new javax.swing.GroupLayout(pnl_mand_phone6);
        pnl_mand_phone6.setLayout(pnl_mand_phone6Layout);
        pnl_mand_phone6Layout.setHorizontalGroup(
            pnl_mand_phone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_phone6Layout.setVerticalGroup(
            pnl_mand_phone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_phone6);
        pnl_mand_phone6.setBounds(475, 327, 8, 8);

        jButton1.setText("Employee Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(320, 470, 200, 30);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 510);

        top_panel2.setBackground(new java.awt.Color(52, 53, 57));
        top_panel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome");
        top_panel2.add(jLabel5);
        jLabel5.setBounds(90, 10, 71, 25);

        jButton4.setBackground(new java.awt.Color(12, 173, 183));
        jButton4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOGOUT");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        top_panel2.add(jButton4);
        jButton4.setBounds(975, 9, 90, 32);

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
        top_panel2.add(btn_back);
        btn_back.setBounds(0, 0, 60, 50);

        main_panel.add(top_panel2);
        top_panel2.setBounds(0, 0, 1080, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1080, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
    }//GEN-LAST:event_formWindowOpened

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.dispose();
        new AddEmployee().setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        new CheckAttendance().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel10MouseClicked
                 
    
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        SearchEmployee se = new SearchEmployee();
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        pnl_a9.setVisible(false);
        areaCount--;
        areas[8]=null;
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        pnl_a10.setVisible(false);
        areaCount--;
        areas[9]=null;
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        pnl_a7.setVisible(false);
        areaCount--;
        areas[5]=null;
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        pnl_a8.setVisible(false);
        areaCount--;
        areas[7]=null;
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        pnl_a6.setVisible(false);
        areaCount--;
        areas[6]=null;
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        pnl_a5.setVisible(false);
        areaCount--;
        areas[4]=null;
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        pnl_a4.setVisible(false);
        areaCount--;
        areas[3]=null;
    }//GEN-LAST:event_jLabel31MouseClicked

    private void lbl_ax1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ax1MouseClicked
        pnl_a1.setVisible(false);
        areaCount--;
        areas[0]=null;
    }//GEN-LAST:event_lbl_ax1MouseClicked

    private void lbl_ax3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ax3MouseClicked
        pnl_a3.setVisible(false);
        areaCount--;
        areas[2]=null;
    }//GEN-LAST:event_lbl_ax3MouseClicked

    private void lbl_ax2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ax2MouseClicked
        pnl_a2.setVisible(false);
        areaCount--;
        areas[1]=null;
    }//GEN-LAST:event_lbl_ax2MouseClicked

    private void chk_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_accActionPerformed

        chk_lec.setSelected(false);
        chk_beau.setSelected(false);
        chk_rep.setSelected(false);

        ResetAreaSuff();

    }//GEN-LAST:event_chk_accActionPerformed

    private void combo_areasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_areasActionPerformed
        if(combo_areas.getSelectedIndex()!=0){
            setLables();
        }

    }//GEN-LAST:event_combo_areasActionPerformed

    private void chk_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_repActionPerformed

        chk_lec.setSelected(false);
        chk_beau.setSelected(false);
        chk_acc.setSelected(false);

        ResetAreaSuff();
    }//GEN-LAST:event_chk_repActionPerformed

    private void chk_lecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_lecActionPerformed

        checkBoxesFunction();
    }//GEN-LAST:event_chk_lecActionPerformed

    private void chk_beauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_beauActionPerformed

        checkBoxesFunction();
    }//GEN-LAST:event_chk_beauActionPerformed

    private void btn_addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addEmployeeActionPerformed

        int count=0;
        int areacode=0;

        //=============Form Validation=============================================//

        int eid = Integer.parseInt(lbl_empid.getText());

        //---first name validation
        if(!txt_fname.getText().isEmpty() && !vm.textOnlyValidation1(txt_fname.getText())){
            lbl_e1.setVisible(true);
        }
        String eFname = txt_fname.getText();

        //---last name validation
        if(!vm.textOnlyValidation2(txt_lname.getText())){
            lbl_e2.setVisible(true);
            count++;
        }
        String eLname = txt_lname.getText();

        //---address validation
        if(!vm.addressValidation(txt_address.getText()) || txt_address.getText().isEmpty()){
            lbl_e3.setVisible(true);
            count++;
        }
        String eAddress = txt_address.getText();

        //---phone num validation
        String ePhone = "";
        if(vm.phoneValidation(txt_phone.getText())){
            ePhone = txt_phone.getText();
        }
        else{
            lbl_e4.setVisible(true);
            count++;
        }

        //---email validation
        String eEmail = "";
        if(vm.emailValidation(txt_email.getText())){
            eEmail = txt_email.getText();
        }
        else{
            lbl_e5.setVisible(true);
            count++;
        }

        //---get gender
        String eGender = "Not Specified";
        if(combo_gender.getSelectedIndex() !=0 )
        eGender = combo_gender.getSelectedItem().toString();

        //---birth day validation and assign
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  //decide date format
        String date="";
        String s = ((JTextField)birth.getDateEditor().getUiComponent()).getText(); //to get date as a string

        if(s.isEmpty() || !vm.dateValidation(birth.getDate())){
            lbl_e7.setVisible(true);
            count++;
        }
        else{
            date = fmt.format(birth.getDate());       //create a string representation of a date with the defined format.
        }

        //---post validation
        if((!chk_lec.isSelected() && !chk_beau.isSelected()) && !chk_rep.isSelected() && !chk_acc.isSelected()){
            lbl_e8.setVisible(true);
            count++;
        }

        //---area validation
        if ((chk_lec.isSelected() || chk_beau.isSelected()) && areaCount==0){
            lbl_e9.setVisible(true);
            count++;
        }

        //---username validation
        if(!vm.usernameValidation(txt_username.getText())){
            lbl_e10.setVisible(true);
            lbl_e10.setEnabled(true);
            lbl_e10.setText("Can contain only letters, numbers, _");
            lbl_e10.requestFocusInWindow();
            count++;
        }
        if(validateUsername(txt_username.getText())){
            lbl_e10.setVisible(true);
            lbl_e10.setEnabled(true);
            lbl_e10.setText("Username already exist");
            lbl_e10.requestFocusInWindow();
            count++;
        }
        String username = txt_username.getText();

        //---password validation
        if(txt_pwd.getText().isEmpty() || txt_pwd.getText().length()<6 ){
            lbl_e11.setVisible(true);
            lbl_e11.setEnabled(true);
            count++;
        }
        String pwd = txt_pwd.getText();

        //---get posts
        boolean lec = chk_lec.isSelected();
        boolean beau = chk_beau.isSelected();
        boolean rep = false;
        boolean acc = false;

        //==================Adding records to database==================================//

        if(count == 0)
        {
            //-----adding to Employee table-----------------//
            if((lec==true || beau==true)){
                new Employee(eid, eFname, eLname, eAddress, ePhone, eEmail, eGender, date, lec, beau, username, pwd);
            }

            if(chk_rep.isSelected()){
                rep = chk_rep.isSelected();
                new Employee(eid, eFname, eLname, eAddress, ePhone, eEmail, eGender, date, rep, username, pwd);
            }

            if(chk_acc.isSelected()){
                acc = chk_acc.isSelected();
                new Employee(eid, eFname, eLname, eAddress, ePhone, eEmail, eGender, date, acc, 12, username, pwd);
            }

            //----adding to EmpSpecIn table-------------//
            if(pnl_Sareas.isVisible())
            {
                String area = "";
                while(areaCount > 0){
                    //----get selected area value one at a time-------//
                    for (int i=0; i<areas.length; i++) {
                        if (areas[i] != null) {
                            area = areas[i];
                            areas[i] = null;
                            break;
                        }
                    }
                    //-----add record to database------------//
                    String que = "SELECT tId FROM treatment WHERE tName = '"+area+"'";
                    try {
                        ps = dbc.con.prepareStatement(que);
                        rs = this.ps.executeQuery();

                        while (rs.next()) {
                            areacode = Integer.parseInt(rs.getString(1));
                            new Employee().addToEmpSpecs(eid, areacode);        //callig
                        }
                    }
                    catch (SQLException err){
                        JOptionPane.showMessageDialog(this, err);
                    }
                    areaCount--;
                }
            }

            JOptionPane.showMessageDialog(this, "You Have Successfully added the record", "Successful!", JOptionPane.NO_OPTION);

            //=========reset feilds after adding records=========================///
            idAutoGenerate();

            txt_fname.setText("");
            txt_lname.setText("");
            txt_address.setText("");
            txt_phone.setText("");
            txt_email.setText("");
            combo_gender.setSelectedIndex(0);
            //set birth
            chk_lec.setSelected(false);
            chk_beau.setSelected(false);
            chk_rep.setSelected(false);
            chk_acc.setSelected(false);
            combo_areas.setSelectedIndex(0);
            txt_username.setText("");
            txt_pwd.setText("");

            setErrorsInvisible();
            ResetAreaSuff();
        }

    }//GEN-LAST:event_btn_addEmployeeActionPerformed

    private void txt_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usernameMouseClicked
        lbl_e10.setVisible(true);
    }//GEN-LAST:event_txt_usernameMouseClicked

    private void txt_pwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_pwdMouseClicked
        lbl_e11.setVisible(true);
    }//GEN-LAST:event_txt_pwdMouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered

        jButton4.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited

        jButton4.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Login l = new Login();
        l.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed

        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ReportView1 s =new ReportView1("C:\\Users\\ASUSI7\\Desktop\\ireports\\report2.jasper");
        s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    
     
    
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
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aError;
    private javax.swing.JLabel area1;
    private javax.swing.JLabel area10;
    private javax.swing.JLabel area2;
    private javax.swing.JLabel area3;
    private javax.swing.JLabel area4;
    private javax.swing.JLabel area5;
    private javax.swing.JLabel area6;
    private javax.swing.JLabel area7;
    private javax.swing.JLabel area8;
    private javax.swing.JLabel area9;
    private com.toedter.calendar.JDateChooser birth;
    private javax.swing.JButton btn_addEmployee;
    private javax.swing.JButton btn_back;
    private javax.swing.JCheckBox chk_acc;
    private javax.swing.JCheckBox chk_beau;
    private javax.swing.JCheckBox chk_lec;
    private javax.swing.JCheckBox chk_rep;
    private javax.swing.JComboBox<String> combo_areas;
    private javax.swing.JComboBox<String> combo_gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_areas;
    private javax.swing.JLabel lbl_ax1;
    private javax.swing.JLabel lbl_ax2;
    private javax.swing.JLabel lbl_ax3;
    private javax.swing.JLabel lbl_e1;
    private javax.swing.JLabel lbl_e10;
    private javax.swing.JLabel lbl_e11;
    private javax.swing.JLabel lbl_e2;
    private javax.swing.JLabel lbl_e3;
    private javax.swing.JLabel lbl_e4;
    private javax.swing.JLabel lbl_e5;
    private javax.swing.JLabel lbl_e7;
    private javax.swing.JLabel lbl_e8;
    private javax.swing.JLabel lbl_e9;
    private javax.swing.JLabel lbl_empid;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel pnl_Sareas;
    private javax.swing.JPanel pnl_a1;
    private javax.swing.JPanel pnl_a10;
    private javax.swing.JPanel pnl_a2;
    private javax.swing.JPanel pnl_a3;
    private javax.swing.JPanel pnl_a4;
    private javax.swing.JPanel pnl_a5;
    private javax.swing.JPanel pnl_a6;
    private javax.swing.JPanel pnl_a7;
    private javax.swing.JPanel pnl_a8;
    private javax.swing.JPanel pnl_a9;
    private javax.swing.JPanel pnl_mand_phone;
    private javax.swing.JPanel pnl_mand_phone1;
    private javax.swing.JPanel pnl_mand_phone2;
    private javax.swing.JPanel pnl_mand_phone3;
    private javax.swing.JPanel pnl_mand_phone4;
    private javax.swing.JPanel pnl_mand_phone5;
    private javax.swing.JPanel pnl_mand_phone6;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel2;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_pwd;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

   
}
