/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sohan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author it15-102560
 */
public class CurrentAppointment extends javax.swing.JFrame {

    
    
    String fname="";
    int appId;
    int next_appId;
    String next_fname;
    
    String myName;
    
     
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    
    GetDBConnection dbc = new GetDBConnection();
    
    
    
    
    
    public CurrentAppointment() {
        initComponents();
        
        fillBeauticians();
        
        updateFields();
        
        
    }

    String empName="";
    int empId=0;
    
    
    private void updateFields()
    {
    
        int count = 0;
        
        Object selectedbeauty = cmb_beautician.getSelectedItem();
        empName = selectedbeauty.toString();


        empId = getEmpId(empName);    

         
        
        
        
        String queryid = "SELECT app_id,app_time\n" +
                         "FROM appointment\n" +
                         "WHERE status='in queue' and empId ="+empId+"\n" +
                         "Having MIN(app_time)";
                       
        try 
        {            
            
            
            
   //--------------------Current apointment--------------------------------------//
            
            
            
            
            pst = dbc.con.prepareStatement(queryid);
            
            rs = this.pst.executeQuery();
            
            while (rs.next()) 
            {
                
                appId = rs.getInt(1);
                
                System.out.println("app_id"+appId);
                
                lbl_appId.setText(Integer.toString(appId));
             
                count++;
                
            }
            
            
   //------------------------------------------------------------//
            
            
            
            queryid = "SELECT c.fname\n" +
                      "FROM Customer c, appointment a\n" +
                      "WHERE c.phone = a.phone and app_id = "+appId+" ";
            
            
            
            pst = dbc.con.prepareStatement(queryid);
            
            rs = this.pst.executeQuery();
            
            while (rs.next()) 
            {
                
                fname = rs.getString(1);
                
                
                lbl_fname.setText(fname);
             
            }
            
            
            //------------------------------------------------------------//
            
            DefaultListModel<String> model = new DefaultListModel<>();
            list_treat.setModel(model);

           String treat="";
              
            
            queryid = "SELECT tName\n" +
                      "FROM treatment t, apphastreat a\n" +
                      "WHERE a.app_id = "+appId+" and a.tId = t.tId";
            
            
            
            pst = dbc.con.prepareStatement(queryid);
            
            rs = this.pst.executeQuery();
            
            while (rs.next()) 
            {
                
                treat = rs.getString(1);

                model.addElement(treat);
                
            }
            
            
            
            //----------------------------------------------------------------------------//
            //------------------------Next Appointment------------------------------------//
            
            
            
            queryid = "SELECT app_id,app_time\n" +
                      "FROM appointment\n" +
                      "WHERE app_id = "+(appId+1)+"";
            
            
            
            pst = dbc.con.prepareStatement(queryid);
            
            rs = this.pst.executeQuery();
            
            while (rs.next()) 
            {
                
                next_appId = rs.getInt(1);
                
                
                lbl_next_appId.setText(Integer.toString(next_appId));
             
            }
            
            
            //------------------------------------------------------------//
            
            
            
                        
            
            queryid = "SELECT c.fname\n" +
                      "FROM Customer c, appointment a\n" +
                      "WHERE c.phone = a.phone and app_id = "+next_appId+" ";
            
            
            
            pst = dbc.con.prepareStatement(queryid);
            
            rs = this.pst.executeQuery();
            
            while (rs.next()) 
            {
                
                next_fname = rs.getString(1);
                
                
                lbl_next_fname.setText(next_fname);
             
            }
            
            
            //------------------------------------------------------------//
            
            
            
            
            
        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }       
        
        
        if(count == 0)
        {
            
            lbl_appId.setText("No Appointments");
            lbl_fname.setText("No Appointments");
            lbl_next_appId.setText("No Appointments");
            lbl_next_fname.setText("No Appointments");
            
            
        }
        
        
    }
    
    
    
    
    
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_appId = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_fname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_treat = new javax.swing.JList<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbl_next_appId = new javax.swing.JLabel();
        lbl_next_fname = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        cmb_beautician = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        viewapp = new javax.swing.JButton();
        btn_back5 = new javax.swing.JButton();
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

        jPanel8.setBackground(new java.awt.Color(47, 52, 56));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        main_panel.add(jPanel8);
        jPanel8.setBounds(-10, 660, 1090, 30);

        jPanel2.setBackground(new java.awt.Color(59, 62, 67));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(47, 52, 56));
        jPanel3.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("CURRENT APPOINTMENT");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(450, 30, 220, 30);

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("TODAY");
        jPanel3.add(jLabel27);
        jLabel27.setBounds(530, 60, 50, 20);

        jPanel6.setBackground(new java.awt.Color(12, 173, 183));
        jPanel6.setLayout(null);

        lbl_appId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 24)); // NOI18N
        lbl_appId.setForeground(new java.awt.Color(255, 255, 255));
        lbl_appId.setText("000");
        jPanel6.add(lbl_appId);
        lbl_appId.setBounds(160, 60, 280, 40);

        jLabel22.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Appointment ID");
        jPanel6.add(jLabel22);
        jLabel22.setBounds(20, 70, 111, 22);

        jLabel23.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Customer Name");
        jPanel6.add(jLabel23);
        jLabel23.setBounds(20, 120, 115, 22);

        lbl_fname.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 24)); // NOI18N
        lbl_fname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fname.setText("fname");
        jPanel6.add(lbl_fname);
        lbl_fname.setBounds(160, 110, 280, 40);

        jButton1.setBackground(new java.awt.Color(12, 173, 183));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Completed");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);
        jButton1.setBounds(870, 80, 173, 50);

        jLabel25.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Treatments");
        jPanel6.add(jLabel25);
        jLabel25.setBounds(530, 10, 110, 27);

        jLabel32.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Treatment name five");
        jPanel6.add(jLabel32);
        jLabel32.setBounds(431, 230, 301, 25);

        list_treat.setBackground(new java.awt.Color(12, 173, 183));
        list_treat.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        list_treat.setForeground(new java.awt.Color(255, 255, 255));
        list_treat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_treat.setSelectionBackground(new java.awt.Color(12, 173, 183));
        jScrollPane1.setViewportView(list_treat);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(450, 40, 340, 180);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(0, 100, 1080, 230);

        jLabel33.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setText("NEXT APPOINTMENT");
        jPanel3.add(jLabel33);
        jLabel33.setBounds(730, 340, 170, 30);

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("TODAY");
        jPanel3.add(jLabel34);
        jLabel34.setBounds(800, 370, 50, 20);

        jPanel1.setBackground(new java.awt.Color(12, 173, 183));

        jLabel37.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Customer Name");

        jLabel35.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Appointment ID");

        lbl_next_appId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 25)); // NOI18N
        lbl_next_appId.setForeground(new java.awt.Color(255, 255, 255));
        lbl_next_appId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_next_appId.setText("000");

        lbl_next_fname.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 20)); // NOI18N
        lbl_next_fname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_next_fname.setText("fname");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_next_fname, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(lbl_next_appId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lbl_next_appId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lbl_next_fname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(580, 400, 500, 100);

        jPanel13.setBackground(new java.awt.Color(12, 173, 183));
        jPanel13.setPreferredSize(new java.awt.Dimension(190, 3));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel13);
        jPanel13.setBounds(0, -7, 1080, 10);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1080, 510);

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

        cmb_beautician.setBackground(new java.awt.Color(51, 51, 51));
        cmb_beautician.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_beautician.setForeground(new java.awt.Color(255, 255, 255));
        cmb_beautician.setOpaque(false);
        cmb_beautician.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmb_beauticianActionPerformed(evt);
            }
        });
        top_panel.add(cmb_beautician);
        cmb_beautician.setBounds(420, 10, 260, 30);

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("refresh");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel1MouseEntered(evt);
            }
        });
        top_panel.add(jLabel1);
        jLabel1.setBounds(690, 10, 100, 30);

        main_panel.add(top_panel);
        top_panel.setBounds(0, 0, 1080, 50);

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));
        jPanel4.setLayout(null);

        viewapp.setBackground(new java.awt.Color(67, 70, 75));
        viewapp.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        viewapp.setForeground(new java.awt.Color(255, 255, 255));
        viewapp.setText("Current Appointment");
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
        viewapp.setBounds(230, 25, 180, 70);

        btn_back5.setBackground(new java.awt.Color(67, 70, 75));
        btn_back5.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back5.setForeground(new java.awt.Color(204, 204, 204));
        btn_back5.setText("View Appointments");
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
        btn_back5.setBounds(440, 25, 190, 70);

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
        jPanel12.setBounds(230, 90, 180, 10);

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

 
        
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      
            try
            {
        
                String st = "UPDATE appointment\n" +
                            "SET status = 'completed'\n" +
                            "WHERE app_Id ="+appId+" ";

                pst  = dbc.con.prepareStatement(st);

                pst.execute();
            }
            catch (SQLException err) 
            {
                JOptionPane.showMessageDialog(this, err);
            }       
        
            
            JOptionPane.showMessageDialog(null, "Successful");
            
            
            updateFields();
            
            

    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void cmb_beauticianActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmb_beauticianActionPerformed
    {//GEN-HEADEREND:event_cmb_beauticianActionPerformed
     
        
    }//GEN-LAST:event_cmb_beauticianActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel1MouseClicked
    {//GEN-HEADEREND:event_jLabel1MouseClicked
     
        updateFields();
        System.out.println("click");
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel1MouseEntered
    {//GEN-HEADEREND:event_jLabel1MouseEntered
   
          updateFields();
        
        
    }//GEN-LAST:event_jLabel1MouseEntered

    private void viewappActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewappActionPerformed
    {//GEN-HEADEREND:event_viewappActionPerformed
        CurrentAppointment a = new CurrentAppointment();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewappActionPerformed

    private void btn_back5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_back5ActionPerformed
    {//GEN-HEADEREND:event_btn_back5ActionPerformed

        BeauAppointments a = new BeauAppointments();
        a.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_back5ActionPerformed

    
    //==========================================================================//
    
     public void fillBeauticians()
    {
        
        
        
        String st = "select distinct e.empFName, e.empLNaFme \n" +
                    "from employee e, EmpSpecIn s\n" +
                    "where e.empId = s.empId";


        String fullname="";
        String fname="";
        String lname="";

        try 
        {           
            
                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();

            while(rs.next()) 
            {
                
                fname =  rs.getString(1);
                lname =  rs.getString(2);
                           
                fullname = fname +" "+ lname;
                
                cmb_beautician.addItem(fullname);    

            }

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }
        
    }
    
    
    
    //================ get EMPID of empName ===================//


    public int getEmpId(String empName)
    {
        
        int id = 0;
        
        String firstWord = empName.split(" ",2)[0];
       
        System.out.println("firstName = "+firstWord);
        
        String st = "select empId\n" +
                    "from employee\n" +
                    "where empFname = '"+firstWord+"' ";


        try 
        {           
            
                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();

            while(rs.next()) 
            {
                
                id =  rs.getInt(1);
   

            }

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }
        
        return id;
        
    }

    
    
    
    
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
            java.util.logging.Logger.getLogger(CurrentAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CurrentAppointment().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount3;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_back5;
    private javax.swing.JComboBox<String> cmb_beautician;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_appId;
    private javax.swing.JLabel lbl_fname;
    private javax.swing.JLabel lbl_next_appId;
    private javax.swing.JLabel lbl_next_fname;
    private javax.swing.JList<String> list_treat;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel msg_datetime;
    private javax.swing.JLabel msg_description;
    private javax.swing.JLabel msg_title;
    private javax.swing.JLabel msg_venue;
    private javax.swing.JPanel top_panel;
    private javax.swing.JButton viewapp;
    // End of variables declaration//GEN-END:variables
}
