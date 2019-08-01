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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author it15-102560
 */
public class UpdateAppointment extends javax.swing.JFrame {


    
    
    DefaultTableModel model;
    
    
    
    
    public UpdateAppointment() {
        initComponents();
    }

    
    int appId;
    String time ="";
    String status ="";
    String date ="";
    
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
    
    
    
    /*------------------ballaa-------------------------*/
    
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
        cmb_AppType = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_apps = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        spin_time = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        cal_AppDate = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        lbl_appId = new javax.swing.JLabel();
        lbl_fname1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cmb_status = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        viewapp = new javax.swing.JButton();
        addapp = new javax.swing.JButton();
        btn_back5 = new javax.swing.JButton();
        btn_back6 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        cmb_AppType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Appointments", "Appointments In Queue", "Completed Appointments", "Canceled Appointments" }));
        cmb_AppType.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmb_AppTypeActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_AppType);
        cmb_AppType.setBounds(170, 20, 170, 25);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 33, 33));
        jLabel21.setText("Appointment type");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(30, 20, 120, 20);

        tbl_apps.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_apps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "App ID", "Emp ID", "Customer", "Phone", "Date", "Time", "Amount", "Status"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tbl_apps.setOpaque(false);
        tbl_apps.setRowHeight(30);
        tbl_apps.setSelectionBackground(new java.awt.Color(12, 173, 183));
        tbl_apps.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_apps.getTableHeader().setReorderingAllowed(false);
        tbl_apps.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tbl_appsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_apps);
        tbl_apps.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_apps.getColumnModel().getColumnCount() > 0)
        {
            tbl_apps.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_apps.getColumnModel().getColumn(1).setPreferredWidth(30);
            tbl_apps.getColumnModel().getColumn(5).setPreferredWidth(30);
            tbl_apps.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 1060, 250);

        btn_update.setBackground(new java.awt.Color(12, 173, 183));
        btn_update.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update);
        btn_update.setBounds(890, 460, 170, 40);

        txt_search.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_search.setOpaque(false);
        txt_search.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_search);
        txt_search.setBounds(750, 20, 210, 30);

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
        btn_search.setBounds(970, 20, 80, 30);

        spin_time.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        spin_time.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1474034672143L), null, null, java.util.Calendar.MINUTE));
        jPanel2.add(spin_time);
        spin_time.setBounds(340, 430, 140, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(33, 33, 33));
        jLabel27.setText("Appointment Date");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(180, 390, 140, 20);

        cal_AppDate.setDateFormatString("yyyy-M-d ");
        cal_AppDate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cal_AppDate.setMaxSelectableDate(new java.util.Date(253370748674000L));
        cal_AppDate.setMinSelectableDate(new java.util.Date(-62135785714000L));
        jPanel2.add(cal_AppDate);
        cal_AppDate.setBounds(340, 390, 140, 25);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(33, 33, 33));
        jLabel23.setText("Appointment Time");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel23);
        jLabel23.setBounds(180, 440, 140, 20);

        lbl_appId.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_appId.setForeground(new java.awt.Color(33, 33, 33));
        lbl_appId.setText("ID");
        jPanel2.add(lbl_appId);
        lbl_appId.setBounds(560, 330, 100, 30);

        lbl_fname1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl_fname1.setForeground(new java.awt.Color(33, 33, 33));
        lbl_fname1.setText("Appointment ID");
        jPanel2.add(lbl_fname1);
        lbl_fname1.setBounds(410, 330, 130, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(33, 33, 33));
        jLabel22.setText("Status");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(550, 390, 70, 30);

        cmb_status.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cmb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "in queue", "completed", "cancelled" }));
        jPanel2.add(cmb_status);
        cmb_status.setBounds(630, 390, 170, 30);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 1080, 510);

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));
        jPanel4.setLayout(null);

        viewapp.setBackground(new java.awt.Color(67, 70, 75));
        viewapp.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        viewapp.setForeground(new java.awt.Color(204, 204, 204));
        viewapp.setText("View Appointments");
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

        addapp.setBackground(new java.awt.Color(67, 70, 75));
        addapp.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        addapp.setForeground(new java.awt.Color(204, 204, 204));
        addapp.setText("Add Appointment");
        addapp.setBorderPainted(false);
        addapp.setContentAreaFilled(false);
        addapp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp.setIconTextGap(10);
        addapp.setOpaque(true);
        addapp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addappActionPerformed(evt);
            }
        });
        jPanel4.add(addapp);
        addapp.setBounds(20, 25, 180, 70);

        btn_back5.setBackground(new java.awt.Color(67, 70, 75));
        btn_back5.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back5.setForeground(new java.awt.Color(255, 255, 255));
        btn_back5.setText("Update Appointments");
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

        btn_back6.setBackground(new java.awt.Color(67, 70, 75));
        btn_back6.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back6.setForeground(new java.awt.Color(204, 204, 204));
        btn_back6.setText("Cancel Appointments");
        btn_back6.setBorderPainted(false);
        btn_back6.setContentAreaFilled(false);
        btn_back6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back6.setIconTextGap(10);
        btn_back6.setOpaque(true);
        btn_back6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_back6ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_back6);
        btn_back6.setBounds(650, 25, 180, 70);

        jPanel12.setBackground(new java.awt.Color(12, 173, 183));
        jPanel12.setPreferredSize(new java.awt.Dimension(190, 3));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel12);
        jPanel12.setBounds(440, 90, 190, 10);

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

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
        cal_AppDate.setMinSelectableDate(cdate);
        
        
        model = (DefaultTableModel)tbl_apps.getModel();
        model.setRowCount(0);
        
        
        
        try
        {
         
         String  st = "SELECT a.app_id, a.empId,c.fname, a.phone, a.app_date, a.app_time, a.price, a.status\n" +
                      "FROM Appointment a, Customer c\n" +
                      "WHERE a.phone = c.phone";

         
                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();
              
        
                    while(rs.next())
                    {
                        
                       
                        
                        int app_id = rs.getInt(1);
                        int empId = rs.getInt(2);
                        String fname = rs.getString(3);
                        int phone = rs.getInt(4);
                        String app_date = rs.getString(5);
                        String app_time = rs.getString(6);
                        Double price = rs.getDouble(7);
                        String status = rs.getString(8);
                        
                        

                        model.addRow(new Object[]{app_id,empId,fname,phone,app_date,app_time,price,status});

                        
                        
                    }                       
        
        
        
        
        }
        catch(SQLException e2)
        {
             JOptionPane.showMessageDialog(null,e2);
        }
        
        
     
        
        
        
    }//GEN-LAST:event_formWindowOpened

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
      
           
     
        DateFormat fmt;       
        fmt = new SimpleDateFormat("yyyy-MM-dd");
        date = fmt.format(cal_AppDate.getDate());        
        
        
       SimpleDateFormat formater = new SimpleDateFormat("hh:mm");
       time = formater.format(spin_time.getValue());
        
       appId = Integer.parseInt(lbl_appId.getText());
        
        Object selectedItem1 = cmb_status.getSelectedItem();
        status = selectedItem1.toString();
        
        
        System.out.println(status);
        System.out.println(appId);
        
    
    if(validateInput())
     {            
        
        int ans = JOptionPane.showConfirmDialog(rootPane,"Do you really want to update the appointment "+appId+"?");
        
        if(ans == 0)
        {           
            try
            {

                String st = "UPDATE appointment\n" +
                            "SET status = '"+status+"' , app_time = '"+time+"' , app_date = '"+date+"'\n" +
                            "WHERE app_id = "+appId+"";

                pst  = dbc.con.prepareStatement(st);
                pst.execute();

            }
            catch(SQLException e2)
            {
                 JOptionPane.showMessageDialog(null,e2);
            }
            
            updateTable();
            
        }
     }
        
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void cmb_AppTypeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmb_AppTypeActionPerformed
    {//GEN-HEADEREND:event_cmb_AppTypeActionPerformed
   
        
        updateTable();
        
    }//GEN-LAST:event_cmb_AppTypeActionPerformed

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

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_searchActionPerformed
    {//GEN-HEADEREND:event_btn_searchActionPerformed

         String search = "";

        search = txt_search.getText();


 

        model = (DefaultTableModel)tbl_apps.getModel();
        model.setRowCount(0);
        
        
        
        try
        {
         
         String  st = "SELECT a.app_id, a.empId, c.fname, a.phone, a.app_date, a.app_time, a.price, a.status\n" +
                      "FROM Appointment a, Customer c \n" +
                      "WHERE a.phone = c.phone and c.phone = "+search+" or a.app_id = "+search+" and a.phone = c.phone";

         
                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();
              
        
                    while(rs.next())
                    {
                        
                       
                        
                        int app_id = rs.getInt(1);
                        int empId = rs.getInt(2);
                        String fname = rs.getString(3);
                        int phone = rs.getInt(4);
                        String app_date = rs.getString(5);
                        String app_time = rs.getString(6);
                        Double price = rs.getDouble(7);
                        String status = rs.getString(8);
                        
                        

                        model.addRow(new Object[]{app_id,empId,fname,phone,app_date,app_time,price,status});

                        
                        
                    }                       
        
        
        
        
        }
        catch(SQLException e2)
        {
             JOptionPane.showMessageDialog(null,e2);
        }

    }//GEN-LAST:event_btn_searchActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel23MouseClicked
    {//GEN-HEADEREND:event_jLabel23MouseClicked

        System.out.println("clicked");

    }//GEN-LAST:event_jLabel23MouseClicked

    private void tbl_appsMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tbl_appsMouseClicked
    {//GEN-HEADEREND:event_tbl_appsMouseClicked
    
        Date Ddate=null;
                
        model = (DefaultTableModel)tbl_apps.getModel();
        int row = tbl_apps.convertRowIndexToModel(tbl_apps.getSelectedRow());
        
        appId = Integer.parseInt(model.getValueAt(row, 0).toString());
        lbl_appId.setText(model.getValueAt(row, 0).toString());
        
        time = model.getValueAt(row, 5).toString();
        
        System.out.println("time = "+time);
        
          spin_time.setEditor(new JSpinner.DateEditor(spin_time, "hh:mm"));
       
        try {

            SimpleDateFormat sdfSource = new SimpleDateFormat("hh:mm");

            Date date = sdfSource.parse(time);

             spin_time.setValue(date);
            


        } catch (ParseException pe)
        {
            System.out.println("Parse Exception : " + pe);
        }
       
       
       
            
       
       
       
       
       

        System.out.println("time after = "+time);
        
        
       // spin_time.setValue(time);
        
        
        String date = model.getValueAt(row, 4).toString();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            
            
            Ddate = dateformat.parse(date);
            
            
        } catch (ParseException ex)
        {
            Logger.getLogger(UpdateAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        cal_AppDate.setDate(Ddate);
        
        
        
        String status = (model.getValueAt(row, 7).toString());       
        cmb_status.setSelectedItem(status);
        
        
        
    }//GEN-LAST:event_tbl_appsMouseClicked

    private void viewappActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewappActionPerformed
    {//GEN-HEADEREND:event_viewappActionPerformed
        Appointments a = new Appointments();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewappActionPerformed

    private void addappActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addappActionPerformed
    {//GEN-HEADEREND:event_addappActionPerformed
       
        
        AddAppointment a = new AddAppointment();
        a.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_addappActionPerformed

    private void btn_back5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_back5ActionPerformed
    {//GEN-HEADEREND:event_btn_back5ActionPerformed
        
         UpdateAppointment a = new UpdateAppointment();
        a.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btn_back5ActionPerformed

    private void btn_back6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_back6ActionPerformed
    {//GEN-HEADEREND:event_btn_back6ActionPerformed

        Appointments b = new Appointments();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_back6ActionPerformed

    
    
    
    public void updateTable()
    {
        
        
        
       String type = "";
       
       String op = "=";
       
       int index =  cmb_AppType.getSelectedIndex();
        
       switch(index)
       {
            
           
            case 0:  op = "!=";
                     type = "'test'";
                     break;
                     
            case 1:  op = "=";
                     type = "'in queue'";
                     break;
                     
            case 2:  op = "=";
                     type = "'completed'";
                     break;
                     
            case 3:  op = "=";
                     type = "'cancelled'";
                     break;
       
        }
       
       
       
        model = (DefaultTableModel)tbl_apps.getModel();
        model.setRowCount(0);
        
        
        
        try
        {
         
         String  st = "SELECT a.app_id, a.empId,c.fname, a.phone, a.app_date, a.app_time, a.price, a.status\n" +
                      "FROM Appointment a, Customer c\n" +
                      "WHERE a.phone = c.phone and status "+op+" "+type+"";

         
                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();
              
        
                    while(rs.next())
                    {
                        
                       
                        int app_id = rs.getInt(1);
                        int empId = rs.getInt(2);
                        String fname = rs.getString(3);
                        int phone = rs.getInt(4);
                        String app_date = rs.getString(5);
                        String app_time = rs.getString(6);
                        Double price = rs.getDouble(7);
                        String status = rs.getString(8);
                        
  
                        model.addRow(new Object[]{app_id,empId,fname,phone,app_date,app_time,price,status});

                        
                        
                    }                       
        
        
        }
        catch(SQLException e2)
        {
             JOptionPane.showMessageDialog(null,e2);
        }
       
    }
   
    
    
    private boolean validateInput()
    {

        
        
        if(!dateValidation())
        {      
            return false;
        }
        
        
       
        else
            return true;
        
    }
    
    
    
    
    //======================== DATE VALIDATE =========================//
    
    
    //======================== DATE VALIDATE =========================//
    
    public boolean dateValidation()
    {
    
        
        Date today = Calendar.getInstance().getTime();         //get current date  

        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
       
        int boo = sdf.format(today).compareTo(sdf.format(cal_AppDate.getDate()));
       
        if(boo == 0 )        
        {    
            
            
            
            
                Date now = Calendar.getInstance().getTime();         //get current date  

                SimpleDateFormat spd = new SimpleDateFormat("hh");

                int timess = spd.format(today).compareTo(spd.format(spin_time.getValue()));



                if(timess <= 0 )        
                {    

                    return true;
                }               
                else
                {
                    JOptionPane.showMessageDialog(null,"invalid time");
                    return false;
                }     
            
            
        }               
        else
        {
            JOptionPane.showMessageDialog(null,"invalid Date");
            return false;
        }     
        
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
            java.util.logging.Logger.getLogger(UpdateAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new UpdateAppointment().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addapp;
    private javax.swing.JLabel amount3;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_back5;
    private javax.swing.JButton btn_back6;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private com.toedter.calendar.JDateChooser cal_AppDate;
    private javax.swing.JComboBox<String> cmb_AppType;
    private javax.swing.JComboBox<String> cmb_status;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_appId;
    private javax.swing.JLabel lbl_fname1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel msg_datetime;
    private javax.swing.JLabel msg_description;
    private javax.swing.JLabel msg_title;
    private javax.swing.JLabel msg_venue;
    private javax.swing.JSpinner spin_time;
    private javax.swing.JTable tbl_apps;
    private javax.swing.JPanel top_panel;
    private javax.swing.JTextField txt_search;
    private javax.swing.JButton viewapp;
    // End of variables declaration//GEN-END:variables
}
