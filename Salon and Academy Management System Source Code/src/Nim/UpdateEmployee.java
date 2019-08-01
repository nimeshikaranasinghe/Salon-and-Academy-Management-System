
package Nim;

import Sohan.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class UpdateEmployee extends javax.swing.JFrame {

    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
    ValidMethods vm = new ValidMethods();  //class object for validate text feilds 
    
    SearchEmployee se = new SearchEmployee();
    int empID;
    String fname;
    String lname;
    String phone;
    boolean own = false;
    boolean man = false;
    boolean rep = false;
    boolean acc = false;
    boolean lec = false;
    boolean beau = false;
    
    int sareaCount = 0;                      //to keep track of selected area count in user interface
    int dbAreas = 0;        //variable to count number of areas gain from data base
    String areas[] = new String[20];        //array to store selected areas
    List valid = Arrays.asList(areas);      //used to check an array element is empty
    
    boolean[] postsBoo = new boolean[6];       //array to store boolean post values
    String[] postsStr = {"Owner", "Manager", "Receptionist", "Lecturer", "Beautician", "Accountant"};       //array to store string post values
       
    
    public UpdateEmployee() {
        initComponents();
    }

    //to get parent search form
    public UpdateEmployee(SearchEmployee pse, int pEmpId) {
        initComponents();
        
        this.se = pse;
        this.empID = pEmpId;
        
        fillAreas();                 //fill combo box
        setErrorsInvisible();
        ResetAreaSuff();
                
        lbl_post1.setVisible(false);
        lbl_post2.setVisible(false);
        lbl_and.setVisible(false);
        pnl_postChecks.setVisible(false);
        
     /*   //chk_lec.setSelected(true);
        lbl_areas.setEnabled(false);
        combo_areas.setEnabled(false);
        pnl_Sareas.setEnabled(false);
        aError.setVisible(false);       //cannot add more than 10 areas error
      */
        
        try{
            //---getdetails about selected employee
            String equery = "SELECT * from Employee where empId=" + this.empID + "";
            pst = dbc.con.prepareStatement(equery);
            rs = this.pst.executeQuery();
            
            if (rs.next()) {
                this.empID = rs.getInt(1);
                this.fname = rs.getString(2);
                this.lname = rs.getString(3);
                this.phone = rs.getString(5);
                
                this.postsBoo[0] = this.own = rs.getBoolean(9);
                this.postsBoo[1] = this.man = rs.getBoolean(10);
                this.postsBoo[2] = this.rep = rs.getBoolean(11);
                this.postsBoo[3] = this.lec = rs.getBoolean(12);
                this.postsBoo[4] = this.beau= rs.getBoolean(13);
                this.postsBoo[5] = this.acc = rs.getBoolean(14);
            }
              
            //getdetails about speclized areas
            if(this.lec == true || this.beau == true){
                pnl_postChecks.setVisible(true);
                pnl_specAreas.setVisible(true);
                lbl_areas.setEnabled(true);
                combo_areas.setEnabled(true);
                pnl_Sareas.setEnabled(true);

                equery = "SELECT t.tId, t.tName from EmpSpecIn e, treatment t WHERE t.tId=e.areaCode AND empId=" + this.empID + "";
                pst = dbc.con.prepareStatement(equery);
                rs = this.pst.executeQuery();

                while (rs.next()) {
                    this.areas[dbAreas] = rs.getString(2);
                    dbAreas++;
                }                
            }
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err);
        } 
        
        //-------set the feilds with employee details
        lbl_id.setText(Integer.toString(this.empID));
        txt_fname.setText(this.fname);
        txt_lname.setText(this.lname);
        txt_phone.setText(this.phone);

        //set post values
        for (int i = 0; i < postsBoo.length; i++) {
            if (this.postsBoo[i] == true) {
                if (!lbl_post1.isVisible()) {
                    lbl_post1.setVisible(true);
                    lbl_post1.setText(this.postsStr[i]);
                }
                else{
                    lbl_and.setVisible(true);
                    lbl_post2.setVisible(true);
                    lbl_post2.setText(this.postsStr[i]);
                }                
            }            
        }
                //set check box values as chekced
        if (this.lec == true) {
            chk_lec.setSelected(true);
        }
        if (this.beau == true) {
            chk_beau.setSelected(true);
        }
        
        
    }
    
    //======fill combo box areas===============================//
    private void fillAreas() {
        String query = "SELECT * FROM treatment";
        String area;
        
        try {
            pst = dbc.con.prepareStatement(query);
            rs = this.pst.executeQuery();

            while (rs.next()) {
                area = rs.getString(2);
                combo_areas.addItem(area);        
            }
        } 
        catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err);
        }
    }
 
    //======set errors feilds invisible=================================//
    public void setErrorsInvisible()
    {
        lbl_e1.setVisible(false);
        lbl_e2.setVisible(false);
        lbl_e4.setVisible(false);
        lbl_e9.setVisible(false);        
    }
            
    //======Reset areas related feilds and make invisible them==========================/
    public void ResetAreaSuff()
    {
        pnl_specAreas.setVisible(false);
        lbl_areas.setEnabled(false);
        combo_areas.setEnabled(false);
        combo_areas.setSelectedIndex(0);
        pnl_Sareas.setEnabled(false);
        setSareasInvisible(); 
        sareaCount = 0;
        aError.setVisible(false);       //cannot add more than 10 areas error
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
    
    //======set lables to selected area============================///
    private void setLables() {
        
        String a1 = combo_areas.getSelectedItem().toString();
        
        if(sareaCount <= 10)
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
                areas[dbAreas+sareaCount] = a1;
                sareaCount++;
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
    
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        side_bar = new javax.swing.JPanel();
        notf1 = new javax.swing.JPanel();
        notf1_name = new javax.swing.JLabel();
        amount2 = new javax.swing.JLabel();
        amount1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        txt_fname = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        lbl_e1 = new javax.swing.JLabel();
        txt_lname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lbl_e2 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        lbl_e4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbl_and = new javax.swing.JLabel();
        lbl_post2 = new javax.swing.JLabel();
        lbl_post1 = new javax.swing.JLabel();
        pnl_postChecks = new javax.swing.JPanel();
        lbl_post = new javax.swing.JLabel();
        chk_lec = new javax.swing.JCheckBox();
        chk_beau = new javax.swing.JCheckBox();
        pnl_mand_phone2 = new javax.swing.JPanel();
        pnl_specAreas = new javax.swing.JPanel();
        lbl_areas = new javax.swing.JLabel();
        combo_areas = new javax.swing.JComboBox<>();
        lbl_e9 = new javax.swing.JLabel();
        aError = new javax.swing.JLabel();
        pnl_Sareas = new javax.swing.JPanel();
        pnl_a1 = new javax.swing.JPanel();
        area1 = new javax.swing.JLabel();
        lbl_ax1 = new javax.swing.JLabel();
        pnl_a2 = new javax.swing.JPanel();
        area2 = new javax.swing.JLabel();
        lbl_ax2 = new javax.swing.JLabel();
        pnl_a3 = new javax.swing.JPanel();
        area3 = new javax.swing.JLabel();
        lbl_ax3 = new javax.swing.JLabel();
        pnl_a4 = new javax.swing.JPanel();
        area4 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        pnl_a5 = new javax.swing.JPanel();
        area5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnl_a6 = new javax.swing.JPanel();
        area6 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        pnl_a7 = new javax.swing.JPanel();
        area7 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pnl_a8 = new javax.swing.JPanel();
        area8 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        pnl_a9 = new javax.swing.JPanel();
        area9 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        pnl_a10 = new javax.swing.JPanel();
        area10 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        pnl_mand_phone = new javax.swing.JPanel();
        pnl_mand_phone1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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

        side_bar.setBackground(new java.awt.Color(12, 173, 183));

        notf1.setBackground(new java.awt.Color(31, 156, 162));

        notf1_name.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        notf1_name.setForeground(new java.awt.Color(255, 255, 255));
        notf1_name.setText("Eric Reffortson");

        amount2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        amount2.setForeground(new java.awt.Color(255, 255, 255));
        amount2.setText("Fri May 3rd");

        amount1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        amount1.setForeground(new java.awt.Color(255, 255, 255));
        amount1.setText("0770053513");

        javax.swing.GroupLayout notf1Layout = new javax.swing.GroupLayout(notf1);
        notf1.setLayout(notf1Layout);
        notf1Layout.setHorizontalGroup(
            notf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notf1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(notf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amount2)
                    .addComponent(amount1)
                    .addComponent(notf1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        notf1Layout.setVerticalGroup(
            notf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notf1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notf1_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(notf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_barLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(notf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(491, Short.MAX_VALUE))
        );

        main_panel.add(side_bar);
        side_bar.setBounds(860, 50, 220, 610);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(33, 33, 33));
        jLabel27.setText("Employee ID");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(40, 80, 100, 20);

        btn_update.setBackground(new java.awt.Color(12, 173, 183));
        btn_update.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update);
        btn_update.setBounds(540, 410, 250, 40);

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(31, 156, 162));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Update Employee");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(320, 10, 210, 40);

        lbl_id.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(33, 33, 33));
        lbl_id.setText("gain from pre");
        jPanel2.add(lbl_id);
        lbl_id.setBounds(160, 80, 110, 20);

        txt_fname.setFocusCycleRoot(true);
        txt_fname.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_fname.setNextFocusableComponent(txt_lname);
        txt_fname.setOpaque(false);
        txt_fname.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_fname);
        txt_fname.setBounds(160, 130, 190, 25);

        jLabel31.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(33, 33, 33));
        jLabel31.setText("First Name");
        jPanel2.add(jLabel31);
        jLabel31.setBounds(40, 130, 110, 20);

        lbl_e1.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e1.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e1.setText("Can contain only letters");
        jPanel2.add(lbl_e1);
        lbl_e1.setBounds(160, 150, 150, 20);

        txt_lname.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_lname.setNextFocusableComponent(txt_phone);
        txt_lname.setOpaque(false);
        txt_lname.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_lname);
        txt_lname.setBounds(160, 180, 190, 25);

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(33, 33, 33));
        jLabel14.setText("Last name");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(40, 180, 110, 20);

        lbl_e2.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e2.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e2.setText("Can contain only letters and spaces");
        jPanel2.add(lbl_e2);
        lbl_e2.setBounds(160, 200, 170, 20);

        txt_phone.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_phone.setOpaque(false);
        txt_phone.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_phone);
        txt_phone.setBounds(160, 230, 190, 25);

        lbl_e4.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e4.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e4.setText("Input valid phone number");
        jPanel2.add(lbl_e4);
        lbl_e4.setBounds(160, 250, 150, 20);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 33, 33));
        jLabel21.setText("Phone Number");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(40, 230, 110, 20);

        jLabel28.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(33, 33, 33));
        jLabel28.setText("Current Post");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(40, 280, 100, 20);

        lbl_and.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_and.setForeground(new java.awt.Color(33, 33, 33));
        lbl_and.setText("&");
        jPanel2.add(lbl_and);
        lbl_and.setBounds(235, 280, 12, 20);

        lbl_post2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_post2.setForeground(new java.awt.Color(33, 33, 33));
        lbl_post2.setText("post 1");
        jPanel2.add(lbl_post2);
        lbl_post2.setBounds(265, 280, 85, 20);

        lbl_post1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_post1.setForeground(new java.awt.Color(33, 33, 33));
        lbl_post1.setText("post 1");
        jPanel2.add(lbl_post1);
        lbl_post1.setBounds(160, 280, 85, 20);

        pnl_postChecks.setBackground(new java.awt.Color(255, 255, 255));
        pnl_postChecks.setLayout(null);

        lbl_post.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_post.setForeground(new java.awt.Color(33, 33, 33));
        lbl_post.setText("Post");
        pnl_postChecks.add(lbl_post);
        lbl_post.setBounds(40, 8, 110, 20);

        chk_lec.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        chk_lec.setText("Lecturer");
        chk_lec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_lecActionPerformed(evt);
            }
        });
        pnl_postChecks.add(chk_lec);
        chk_lec.setBounds(160, 8, 69, 25);

        chk_beau.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        chk_beau.setText("Beautician");
        chk_beau.setNextFocusableComponent(combo_areas);
        chk_beau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_beauActionPerformed(evt);
            }
        });
        pnl_postChecks.add(chk_beau);
        chk_beau.setBounds(270, 8, 81, 23);

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

        pnl_postChecks.add(pnl_mand_phone2);
        pnl_mand_phone2.setBounds(25, 15, 8, 8);

        jPanel2.add(pnl_postChecks);
        pnl_postChecks.setBounds(0, 320, 360, 40);

        pnl_specAreas.setBackground(new java.awt.Color(255, 255, 255));

        lbl_areas.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_areas.setForeground(new java.awt.Color(33, 33, 33));
        lbl_areas.setText("Specialized Areas");

        combo_areas.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        combo_areas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-" }));
        combo_areas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_areasActionPerformed(evt);
            }
        });

        lbl_e9.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        lbl_e9.setForeground(new java.awt.Color(255, 0, 19));
        lbl_e9.setText("Select at least one area");

        aError.setFont(new java.awt.Font("Nirmala UI", 0, 11)); // NOI18N
        aError.setForeground(new java.awt.Color(255, 102, 102));
        aError.setText("Only 10 areas are allowed at a time");

        pnl_Sareas.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Sareas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selected Specialized Areas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nirmala UI", 0, 12), new java.awt.Color(102, 102, 255))); // NOI18N
        pnl_Sareas.setEnabled(false);
        pnl_Sareas.setLayout(null);

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

        jLabel32.setBackground(new java.awt.Color(204, 204, 204));
        jLabel32.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(111, 148, 255));
        jLabel32.setText("X");
        jLabel32.setOpaque(true);
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        pnl_a4.add(jLabel32);
        jLabel32.setBounds(112, 2, 10, 19);

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

        javax.swing.GroupLayout pnl_specAreasLayout = new javax.swing.GroupLayout(pnl_specAreas);
        pnl_specAreas.setLayout(pnl_specAreasLayout);
        pnl_specAreasLayout.setHorizontalGroup(
            pnl_specAreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_specAreasLayout.createSequentialGroup()
                .addGroup(pnl_specAreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_specAreasLayout.createSequentialGroup()
                        .addComponent(lbl_areas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(pnl_specAreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_e9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_areas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_specAreasLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnl_specAreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_Sareas, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_specAreasLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(aError, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        pnl_specAreasLayout.setVerticalGroup(
            pnl_specAreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_specAreasLayout.createSequentialGroup()
                .addGroup(pnl_specAreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_areas)
                    .addGroup(pnl_specAreasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbl_e9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combo_areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_specAreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Sareas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_specAreasLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(aError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 37, Short.MAX_VALUE))
        );

        jPanel2.add(pnl_specAreas);
        pnl_specAreas.setBounds(500, 80, 340, 240);

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
        pnl_mand_phone.setBounds(25, 187, 8, 8);

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
        pnl_mand_phone1.setBounds(25, 237, 8, 8);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 510);

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

        jPanel11.setBackground(new java.awt.Color(12, 173, 183));
        jPanel11.setPreferredSize(new java.awt.Dimension(170, 7));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel11);
        jPanel11.setBounds(650, 96, 210, 7);

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

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

        top_panel.setBackground(new java.awt.Color(52, 53, 57));
        top_panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome");
        top_panel.add(jLabel2);
        jLabel2.setBounds(90, 10, 71, 25);

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("LOGOUT");
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
        jButton2.setBounds(975, 9, 90, 32);

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
        top_panel.setBounds(0, 0, 1080, 50);

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
        
        notf1.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        this.se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.dispose();
        this.se.dispose();
        new AddEmployee().setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.dispose();
        this.se.dispose();
        new AddEmployee().setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        pnl_a10.setVisible(false);
        sareaCount--;
        areas[dbAreas+9]=null;
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        pnl_a9.setVisible(false);
        sareaCount--;
        areas[dbAreas+8]=null;
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        pnl_a8.setVisible(false);
        sareaCount--;
        areas[dbAreas+7]=null;
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        pnl_a7.setVisible(false);
        sareaCount--;
        areas[dbAreas+5]=null;
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        pnl_a6.setVisible(false);
        sareaCount--;
        areas[dbAreas+6]=null;
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        pnl_a5.setVisible(false);
        sareaCount--;
        areas[dbAreas+4]=null;
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        pnl_a4.setVisible(false);
        sareaCount--;
        areas[dbAreas+3]=null;
    }//GEN-LAST:event_jLabel32MouseClicked

    private void lbl_ax3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ax3MouseClicked
        pnl_a3.setVisible(false);
        sareaCount--;
        areas[dbAreas+2]=null;
    }//GEN-LAST:event_lbl_ax3MouseClicked

    private void lbl_ax2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ax2MouseClicked
        pnl_a2.setVisible(false);
        sareaCount--;
        areas[dbAreas+1]=null;
    }//GEN-LAST:event_lbl_ax2MouseClicked

    private void lbl_ax1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ax1MouseClicked
        pnl_a1.setVisible(false);
        sareaCount--;
        areas[dbAreas+0]=null;
    }//GEN-LAST:event_lbl_ax1MouseClicked

    private void combo_areasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_areasActionPerformed
        if(combo_areas.getSelectedIndex()!=0){
            setLables();
        }
    }//GEN-LAST:event_combo_areasActionPerformed

    private void chk_beauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_beauActionPerformed

        //checkBoxesFunction();
    }//GEN-LAST:event_chk_beauActionPerformed

    private void chk_lecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_lecActionPerformed

        //checkBoxesFunction();
    }//GEN-LAST:event_chk_lecActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Do you Really want to Update ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            int count=0;
            int areacode=0;

            //=============Form Validation=============================================//

            //---first name validation
            if(!txt_fname.getText().isEmpty() && !vm.textOnlyValidation1(txt_fname.getText())){
                lbl_e1.setVisible(true);
            }
            this.fname = txt_fname.getText();

            //---last name validation
            if(!vm.textOnlyValidation2(txt_lname.getText())){
                lbl_e2.setVisible(true);
                count++;
            }
            this.lname = txt_lname.getText();

            //---phone num validation
            if(vm.phoneValidation(txt_phone.getText())){
                this.phone = txt_phone.getText();
            }
            else{
                lbl_e4.setVisible(true);
                count++;
            }

            //get posts
            if (pnl_postChecks.isVisible()) {
                this.lec = chk_lec.isSelected();
                this.beau = chk_beau.isSelected();
            }

            //==================Adding records to database==================================//

            if(count == 0){
                //--------adding a lecturer or beautician
                if (pnl_postChecks.isVisible()) {
                    EmpLecBeau elb = new EmpLecBeau(this.empID);
                    elb.updateDetails(this.fname, this.lname, this.phone, this.lec, this.beau);

                    //----adding to EmpSpecIn table-------------//
                    String area = "";
                    while(sareaCount > 0){
                        //----get selected area value one at a time-------//
                        for (int i=this.dbAreas; i<areas.length; i++) {
                            if (areas[i] != null) {
                                area = areas[i];
                                areas[i] = null;
                                break;
                            }
                        }
                        //-----add record to database------------//
                        String que = "SELECT tId FROM treatment WHERE tName = '"+area+"'";
                        try {
                            pst = dbc.con.prepareStatement(que);
                            rs = this.pst.executeQuery();

                            while (rs.next()) {
                                areacode = Integer.parseInt(rs.getString(1));
                                new Employee().addToEmpSpecs(this.empID, areacode);
                            }
                        }
                        catch (SQLException err){
                            JOptionPane.showMessageDialog(this, err);
                        }
                        sareaCount--;
                    }
                }
                else{
                    EmpRepAccMan eram = new EmpRepAccMan(this.empID);
                    eram.updateDetails(this.fname, this.lname, this.phone);

                }
                JOptionPane.showMessageDialog(this, "You Have Successfully Updated the record", "Successful!", JOptionPane.NO_OPTION);
                se.model.setRowCount(0);           //clear the table
                se.updateTable();
                this.dispose();
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered

        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Login l = new Login();
        l.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateEmployee().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aError;
    private javax.swing.JLabel amount1;
    private javax.swing.JLabel amount2;
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
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_update;
    private javax.swing.JCheckBox chk_beau;
    private javax.swing.JCheckBox chk_lec;
    private javax.swing.JComboBox<String> combo_areas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_and;
    private javax.swing.JLabel lbl_areas;
    private javax.swing.JLabel lbl_ax1;
    private javax.swing.JLabel lbl_ax2;
    private javax.swing.JLabel lbl_ax3;
    private javax.swing.JLabel lbl_e1;
    private javax.swing.JLabel lbl_e2;
    private javax.swing.JLabel lbl_e4;
    private javax.swing.JLabel lbl_e9;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_post;
    private javax.swing.JLabel lbl_post1;
    private javax.swing.JLabel lbl_post2;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel notf1;
    private javax.swing.JLabel notf1_name;
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
    private javax.swing.JPanel pnl_postChecks;
    private javax.swing.JPanel pnl_specAreas;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
