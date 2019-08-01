/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sohan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author it15-102560
 */
public class AddLoyaltyCustomer extends javax.swing.JFrame {

    /**
     * Creates new form gui
     */
    
    
    
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    
    GetDBConnection dbc = new GetDBConnection();
    
    

    
    

    private String loyalId = "";
    private String fname = "";
    private String lname = "";
    private String phone = "";
    private String gender = "";
    private String address = "";
    private String search = "";
    private String dob = "";
    
    
    
    private boolean newCustomer = true;
    
    
    
    
    
    
    
    public AddLoyaltyCustomer() {
        initComponents();
        
        idAutoGenerate();
    }

    /* ID AUTO GENERATE ---------------------------    */
    
    private void idAutoGenerate()
    {
        String queryid = "SELECT MAX(loyal_id) FROM Customer";
        String nextempid;
        try {
            pst = dbc.con.prepareStatement(queryid);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                nextempid = rs.getString(1);
                lbl_loyal_id.setText(Integer.toString(Integer.parseInt(nextempid)+1));
            }
        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }       
        
    }
    
    /*----------------------------------------*/
  
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        main_panel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        msg_venue = new javax.swing.JLabel();
        amount3 = new javax.swing.JLabel();
        msg_title = new javax.swing.JLabel();
        msg_description = new javax.swing.JLabel();
        msg_datetime = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_addcus = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        lbl_loyal_id = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_fname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cal_dob = new com.toedter.calendar.JDateChooser();
        txt_lname = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        cmb_gender = new javax.swing.JComboBox<>();
        lbl_already = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        val_searchphone = new javax.swing.JLabel();
        val_fname = new javax.swing.JLabel();
        val_lname = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        val_phone = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        viewapp = new javax.swing.JButton();
        btn_back5 = new javax.swing.JButton();
        viewapp1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setOpaque(false);
        main_panel.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(59, 62, 67));
        jPanel5.setLayout(null);

        msg_venue.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        msg_venue.setForeground(new java.awt.Color(204, 204, 204));
        msg_venue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg_venue.setText("Hall 2689");
        jPanel5.add(msg_venue);
        msg_venue.setBounds(20, 70, 190, 16);

        amount3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        amount3.setForeground(new java.awt.Color(51, 51, 51));
        amount3.setText("M");
        jPanel5.add(amount3);
        amount3.setBounds(5, 3, 11, 16);

        msg_title.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        msg_title.setForeground(new java.awt.Color(153, 153, 153));
        msg_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg_title.setText("Meeting");
        jPanel5.add(msg_title);
        msg_title.setBounds(20, 10, 190, 18);

        msg_description.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        msg_description.setForeground(new java.awt.Color(204, 204, 204));
        msg_description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg_description.setText("Staff meeting scheduled ");
        jPanel5.add(msg_description);
        msg_description.setBounds(20, 30, 190, 16);

        msg_datetime.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        msg_datetime.setForeground(new java.awt.Color(204, 204, 204));
        msg_datetime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg_datetime.setText("2.45 pm : 12.08.16");
        jPanel5.add(msg_datetime);
        msg_datetime.setBounds(20, 50, 190, 16);

        main_panel.add(jPanel5);
        jPanel5.setBounds(860, 50, 220, 100);

        jPanel8.setBackground(new java.awt.Color(52, 53, 57));
        jPanel8.setLayout(null);

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 255, 51));
        jLabel22.setText("Mandatory Field");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel8.add(jLabel22);
        jLabel22.setBounds(60, 0, 90, 20);

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
        jPanel8.setBounds(-10, 660, 1090, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        btn_addcus.setBackground(new java.awt.Color(12, 173, 183));
        btn_addcus.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn_addcus.setForeground(new java.awt.Color(255, 255, 255));
        btn_addcus.setText("Add Loyalty Customer");
        btn_addcus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addcus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_addcusActionPerformed(evt);
            }
        });
        jPanel2.add(btn_addcus);
        btn_addcus.setBounds(490, 430, 210, 40);

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(33, 33, 33));
        jLabel14.setText("Last name");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(250, 220, 110, 20);

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(33, 33, 33));
        jLabel17.setText("Gender");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(250, 260, 110, 20);

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(33, 33, 33));
        jLabel18.setText("Date of Birth");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(250, 300, 110, 20);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 33, 33));
        jLabel21.setText("Phone");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(250, 140, 110, 20);

        txt_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_phone.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_phone.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_phone.setOpaque(false);
        txt_phone.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_phone);
        txt_phone.setBounds(390, 140, 260, 25);

        lbl_loyal_id.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lbl_loyal_id.setForeground(new java.awt.Color(33, 33, 33));
        lbl_loyal_id.setText("auto generate");
        jPanel2.add(lbl_loyal_id);
        lbl_loyal_id.setBounds(390, 90, 120, 30);

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(33, 33, 33));
        jLabel27.setText("First Name");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(250, 180, 110, 20);

        txt_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_fname.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_fname.setOpaque(false);
        txt_fname.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_fname);
        txt_fname.setBounds(390, 180, 260, 25);

        jLabel28.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(33, 33, 33));
        jLabel28.setText("Phone");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(300, 20, 50, 20);

        cal_dob.setDateFormatString("yyyy-M-d ");
        cal_dob.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jPanel2.add(cal_dob);
        cal_dob.setBounds(390, 300, 170, 22);

        txt_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_lname.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_lname.setOpaque(false);
        txt_lname.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_lname);
        txt_lname.setBounds(390, 220, 260, 25);

        btn_search.setBackground(new java.awt.Color(12, 173, 183));
        btn_search.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Search");
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel2.add(btn_search);
        btn_search.setBounds(580, 20, 80, 30);

        txt_search.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_search.setOpaque(false);
        txt_search.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_search);
        txt_search.setBounds(360, 20, 210, 30);

        cmb_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "female", "male", "not specified" }));
        jPanel2.add(cmb_gender);
        cmb_gender.setBounds(390, 260, 170, 25);

        lbl_already.setFont(new java.awt.Font("Nirmala UI", 0, 15)); // NOI18N
        lbl_already.setForeground(new java.awt.Color(94, 185, 33));
        lbl_already.setText("Already a Loyalty Customer *");
        jPanel2.add(lbl_already);
        lbl_already.setBounds(660, 100, 210, 20);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 60, 1080, 10);

        val_searchphone.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        val_searchphone.setForeground(new java.awt.Color(237, 50, 50));
        val_searchphone.setText("Enter phone number!");
        jPanel2.add(val_searchphone);
        val_searchphone.setBounds(670, 20, 220, 30);

        val_fname.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        val_fname.setForeground(new java.awt.Color(237, 50, 50));
        val_fname.setText("Name can contain only letters.");
        jPanel2.add(val_fname);
        val_fname.setBounds(660, 180, 250, 20);

        val_lname.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        val_lname.setForeground(new java.awt.Color(237, 50, 50));
        val_lname.setText("Name can contain only letters.");
        jPanel2.add(val_lname);
        val_lname.setBounds(660, 220, 250, 20);

        jPanel6.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(230, 148, 8, 8);

        val_phone.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        val_phone.setForeground(new java.awt.Color(237, 50, 50));
        val_phone.setText("Field can't be empty.");
        jPanel2.add(val_phone);
        val_phone.setBounds(660, 140, 250, 20);

        btn_reset.setBackground(new java.awt.Color(12, 173, 183));
        btn_reset.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset fields");
        btn_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reset.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel2.add(btn_reset);
        btn_reset.setBounds(350, 430, 130, 40);

        jLabel31.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(33, 33, 33));
        jLabel31.setText("Loyalty ID");
        jPanel2.add(jLabel31);
        jLabel31.setBounds(250, 100, 110, 20);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 1080, 510);

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
        jButton2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
        btn_back.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_backActionPerformed(evt);
            }
        });
        top_panel.add(btn_back);
        btn_back.setBounds(0, 0, 60, 50);

        main_panel.add(top_panel);
        top_panel.setBounds(0, 0, 1080, 50);

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));
        jPanel4.setLayout(null);

        viewapp.setBackground(new java.awt.Color(67, 70, 75));
        viewapp.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        viewapp.setForeground(new java.awt.Color(204, 204, 204));
        viewapp.setText("View Customers");
        viewapp.setBorderPainted(false);
        viewapp.setContentAreaFilled(false);
        viewapp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewapp.setIconTextGap(10);
        viewapp.setOpaque(true);
        viewapp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                viewappActionPerformed(evt);
            }
        });
        jPanel4.add(viewapp);
        viewapp.setBounds(350, 25, 200, 70);

        btn_back5.setBackground(new java.awt.Color(67, 70, 75));
        btn_back5.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back5.setForeground(new java.awt.Color(204, 204, 204));
        btn_back5.setText("Customer Birthdays");
        btn_back5.setBorderPainted(false);
        btn_back5.setContentAreaFilled(false);
        btn_back5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back5.setIconTextGap(10);
        btn_back5.setOpaque(true);
        btn_back5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_back5ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_back5);
        btn_back5.setBounds(600, 25, 190, 70);

        viewapp1.setBackground(new java.awt.Color(67, 70, 75));
        viewapp1.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        viewapp1.setForeground(new java.awt.Color(255, 255, 255));
        viewapp1.setText("Add Loyalty Customer");
        viewapp1.setBorderPainted(false);
        viewapp1.setContentAreaFilled(false);
        viewapp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewapp1.setIconTextGap(10);
        viewapp1.setOpaque(true);
        viewapp1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                viewapp1ActionPerformed(evt);
            }
        });
        jPanel4.add(viewapp1);
        viewapp1.setBounds(90, 25, 200, 70);

        jPanel12.setBackground(new java.awt.Color(12, 173, 183));
        jPanel12.setPreferredSize(new java.awt.Dimension(190, 3));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel12);
        jPanel12.setBounds(90, 90, 180, 10);

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

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
        

        
        Date cdate = new Date();
        cal_dob.setMaxSelectableDate(cdate);
        
        
        
        val_searchphone.setVisible(false);
        val_phone.setVisible(false);
        val_fname.setVisible(false);
        val_lname.setVisible(false);
        lbl_already.setVisible(false);
        

        
    }//GEN-LAST:event_formWindowOpened

    private void btn_addcusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcusActionPerformed
       
        
        val_phone.setText("Field can't be empty.");
        
        val_phone.setVisible(false);
        val_searchphone.setVisible(false);
        val_fname.setVisible(false);
        val_lname.setVisible(false);
    
        DateFormat fmt;   
               
        fmt = new SimpleDateFormat("yyyy-MM-dd");
        dob = fmt.format(cal_dob.getDate()); 
        
        
        loyalId = lbl_loyal_id.getText();
        phone = txt_phone.getText();
        fname = txt_fname.getText();
        lname = txt_lname.getText();
        
        Object selectedItem = cmb_gender.getSelectedItem();
        gender = selectedItem.toString();
        

      

      
        
     /* SQL thing-----------------------*/ 
        
        
        
        
       if(validateInput())
       {        
         
           
        try
        {

            
            if(newCustomer)
            {
            
                
                String st = "insert into Customer (phone,fname,lname,gender,dob,loyal_id) values(?,?,?,?,?,?)";

                pst  = dbc.con.prepareStatement(st);

                pst.setString(1,phone);
                pst.setString(2,fname);
                pst.setString(3,lname);
                pst.setString(4,gender);
                pst.setString(5,dob);
                pst.setString(6,loyalId);

                pst.execute();              

                resetFields();

                JOptionPane.showMessageDialog(null,"New Loyalty Member added Successfuly.");
                
                
            }
            else
            {
                
                String st = "UPDATE customer\n" +
                            "SET fname=? , lname=?,gender=?,dob=?,loyal_id=?\n" +
                            "WHERE phone = ?";

                
                
                pst  = dbc.con.prepareStatement(st);

                pst.setString(1,fname);
                pst.setString(2,lname);
                pst.setString(3,gender);
                pst.setString(4,dob);
                pst.setString(5,loyalId);
                pst.setString(6,phone);

                pst.execute();              

                resetFields();

                JOptionPane.showMessageDialog(null,"Loyalty Member updated Successfuly.");
                
                
                
                
                
            }
            
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }

        idAutoGenerate();

    }                                          
        
        
        
        
        
        
    }//GEN-LAST:event_btn_addcusActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        
        resetFieldsSearch();
        
        
        idAutoGenerate();
        
        val_phone.setVisible(false);
        val_searchphone.setVisible(false);
        val_fname.setVisible(false);
        val_lname.setVisible(false);
        lbl_already.setVisible(false);

        
        
        

        val_searchphone.setText("Enter phone number!");
        
        search = txt_search.getText();
        
        
        
        if(search.equals(""))
        {
            val_searchphone.setVisible(true);
        }
        
        else
        {
        
            
            try
            {
                
                
                String  st = "SELECT phone, fname, lname, gender, dob, loyal_id FROM Customer WHERE phone LIKE "+search+"";

                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();

                int count = 0;
                
                    while (rs.next())
                    {   
                        
                        count++;

                        txt_phone.setText(Integer.toString(rs.getInt(1)));
                       
                        txt_fname.setText(rs.getString(2));

                        txt_lname.setText(rs.getString(3));

                        cmb_gender.setSelectedItem(rs.getString(4));

                        cal_dob.setDate(rs.getDate(5));
                   
                        lbl_loyal_id.setText(rs.getString(6));
                        
                     //   System.out.println(lbl_loyal_id.getText());
                        
                        try
                        {
                        
                        if(lbl_loyal_id.getText().equals(null))
                        {
                            System.out.println("null");
                            idAutoGenerate();
                        }

                        
                        }
                        catch(NullPointerException n)
                        {
                             System.out.println("null");
                             idAutoGenerate();
                        }
                       
                    }
                
                    
                    
                    if(count > 0)
                    {  
                        
                        newCustomer = false;
                        System.out.println("great");
                      
                        
                    }                    
                    else
                    {
                        
                        val_searchphone.setText("Customer doesn't exist!");
                        val_searchphone.setVisible(true);
                        
                        newCustomer = true;
                        
                    }
                
                    
                   /* 
                    st = "SELECT loyal_id FROM Customer WHERE phone LIKE "+search+"";

                    pst  = dbc.con.prepareStatement(st);

                    rs = pst.executeQuery();

                    
                    
                    
                    if(rs.next())
                    {
                        System.out.println("next");
                        
                        lbl_loyal_id.setText(rs.getString(1));
                    }
                    else
                    {
                        idAutoGenerate();
                    }
                    */
                    
                    
                    /*                                     */
                    
                    
                    
                    
                }

            
            catch(SQLException e2)
            {
                    JOptionPane.showMessageDialog(null,e2);
            }
        
        
        
        }
        
       
      //  txt_phone.setEnabled(false);
        
        
        
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        
        
        resetFields();
        
        
    }//GEN-LAST:event_btn_resetActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButton2MouseEntered
    {//GEN-HEADEREND:event_jButton2MouseEntered

        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButton2MouseExited
    {//GEN-HEADEREND:event_jButton2MouseExited

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed

        Login l = new Login();
        l.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_backActionPerformed
    {//GEN-HEADEREND:event_btn_backActionPerformed

        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_backActionPerformed

    private void viewappActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewappActionPerformed
    {//GEN-HEADEREND:event_viewappActionPerformed
        ViewCustomers a = new ViewCustomers();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewappActionPerformed

    private void btn_back5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_back5ActionPerformed
    {//GEN-HEADEREND:event_btn_back5ActionPerformed

        Birthdays a = new Birthdays();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_back5ActionPerformed

    private void viewapp1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewapp1ActionPerformed
    {//GEN-HEADEREND:event_viewapp1ActionPerformed
         AddLoyaltyCustomer a = new AddLoyaltyCustomer();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewapp1ActionPerformed

    
    
    
    
    
/* validation---------------------------------------------------------------------------*/
    
    
    private boolean validateInput()
    {
        if(phone.equals(""))
        {
            txt_phone.requestFocusInWindow();
            val_phone.setVisible(true);
            return false;
        }
        else if( phone.length() < 9)
        {
            txt_phone.requestFocusInWindow();
            val_phone.setText("Phone must contain 10 digits");
            val_phone.setVisible(true);          
            
            return false;
        }
        
        else if(!fname.matches("^[a-zA-Z\\s]*$"))
        {       
            txt_fname.requestFocusInWindow();
            val_fname.setVisible(true);
            return false;
        }
        else if(!lname.matches("^[a-zA-Z\\s]*$"))
        {       
            txt_lname.requestFocusInWindow();
            val_lname.setVisible(true);
            return false;
        }
        
        else if(!dateValidation())
        {      
            return false;
        }
              
        else
            return true;
    }
    
    
        //======================== DATE VALIDATE =========================//
    
    public boolean dateValidation()
    {
    //------------check whether the selected date is greater than today-----------------//
        
        
        Date today = Calendar.getInstance().getTime();         //get current date  
        
        if(today.before(cal_dob.getDate()))                 //if today is after the selected date return true
        {    
            JOptionPane.showMessageDialog(null,"invalid Date");
            return false;
        }
        
        else
        {
            return true;
        }      
    }
    
    
    
    public void resetFields()       // REset text fields in form
    {
        
        
        
        txt_search.setText("");
        txt_fname.setText("");
        txt_lname.setText("");
        txt_phone.setText("");
        cmb_gender.setSelectedItem(0);
       // cal_dob.setDate();


        newCustomer = true;
        
    }
    
    
    public void resetFieldsSearch()       // REset text fields in form
    {
        
        
        
       // txt_search.setText("");
        txt_fname.setText("");
        txt_lname.setText("");
        txt_phone.setText("");
        cmb_gender.setSelectedIndex(0);
       // cal_dob.setDate();



    }
    
       
/*-----------------------------------------------------------------------------------*/
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(AddLoyaltyCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLoyaltyCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLoyaltyCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLoyaltyCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddLoyaltyCustomer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount3;
    private javax.swing.JButton btn_addcus;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_back5;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_search;
    private com.toedter.calendar.JDateChooser cal_dob;
    private javax.swing.JComboBox<String> cmb_gender;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_already;
    private javax.swing.JLabel lbl_loyal_id;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel msg_datetime;
    private javax.swing.JLabel msg_description;
    private javax.swing.JLabel msg_title;
    private javax.swing.JLabel msg_venue;
    private javax.swing.JPanel top_panel;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_search;
    private javax.swing.JLabel val_fname;
    private javax.swing.JLabel val_lname;
    private javax.swing.JLabel val_phone;
    private javax.swing.JLabel val_searchphone;
    private javax.swing.JButton viewapp;
    private javax.swing.JButton viewapp1;
    // End of variables declaration//GEN-END:variables
}
