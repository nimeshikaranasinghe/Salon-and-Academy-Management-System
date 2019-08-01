/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sohan;

import Dewni.*;
import Ishani.*;
import Janani.Home;
import Nim.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;
import static Sohan.Login.curUserFname;
import sally.AcdIncome;
import sally.SalIncome;
import sally.paySH;
import sally.salaryexp;
import sanjee.Feedback;
import sanjee.PatchTest;
import sanjee.manageSalonPackagess1;
import sanjee.treatments;
import thilini.Home_inventory;


/**
 *
 * @author it15-102560
 */
public class HomePage extends javax.swing.JFrame {


    
        
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
  
    
    
    public HomePage() {
        
        
        initComponents();
        showDate();
        showTime();
        
    }

    
    void showDate()
    {
        Date d  = new Date();
        SimpleDateFormat s =  new SimpleDateFormat("EEEE, MMMM dd");
        
        lbl_date.setText(s.format(d));
    }
    
    
    void showTime()
    {
        new Timer(0, new ActionListener()
        {
 
               @Override
               public void actionPerformed(ActionEvent e) 
               {
                   
                   
                       Date d  = new Date();
                       SimpleDateFormat s =  new SimpleDateFormat("hh:mm a");

                       lbl_time.setText(s.format(d));
                   
                   
               }
            
        }).start();
    }
    
    
    
   
    
    
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        top_panel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        lbl_curUserFname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_heading = new javax.swing.JLabel();
        side_bar = new javax.swing.JPanel();
        pnl_home = new javax.swing.JPanel();
        lbl_date = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        btn_messages_h = new javax.swing.JButton();
        pnl_appointment = new javax.swing.JPanel();
        addapp = new javax.swing.JButton();
        cancelApp = new javax.swing.JButton();
        viewApps = new javax.swing.JButton();
        bviewApp = new javax.swing.JButton();
        curentApp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cancelApp1 = new javax.swing.JButton();
        cancelApp2 = new javax.swing.JButton();
        pnl_customers = new javax.swing.JPanel();
        addNewCus = new javax.swing.JButton();
        Birthdays = new javax.swing.JButton();
        updateCus = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        searchCus = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnl_services = new javax.swing.JPanel();
        addapp3 = new javax.swing.JButton();
        cancelApp9 = new javax.swing.JButton();
        viewApps3 = new javax.swing.JButton();
        bviewApp5 = new javax.swing.JButton();
        curentApp3 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cancelApp11 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        pnl_employees = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        addapp1 = new javax.swing.JButton();
        viewApps1 = new javax.swing.JButton();
        cancelApp3 = new javax.swing.JButton();
        cancelApp4 = new javax.swing.JButton();
        cancelApp5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        curentApp1 = new javax.swing.JButton();
        bviewApp1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        bviewApp3 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        bviewApp4 = new javax.swing.JButton();
        pnl_academic = new javax.swing.JPanel();
        viewApps4 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        pnl_students = new javax.swing.JPanel();
        addapp5 = new javax.swing.JButton();
        cancelApp10 = new javax.swing.JButton();
        viewApps5 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cancelApp13 = new javax.swing.JButton();
        pnl_financial = new javax.swing.JPanel();
        addapp2 = new javax.swing.JButton();
        cancelApp6 = new javax.swing.JButton();
        viewApps2 = new javax.swing.JButton();
        bviewApp2 = new javax.swing.JButton();
        curentApp2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cancelApp8 = new javax.swing.JButton();
        pnl_inventory = new javax.swing.JPanel();
        addapp6 = new javax.swing.JButton();
        cancelApp14 = new javax.swing.JButton();
        viewApps7 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cancelApp15 = new javax.swing.JButton();
        cancelApp16 = new javax.swing.JButton();
        pnl_messages = new javax.swing.JPanel();
        addapp4 = new javax.swing.JButton();
        cancelApp12 = new javax.swing.JButton();
        viewApps6 = new javax.swing.JButton();
        curentApp4 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btn_app = new javax.swing.JButton();
        btn_inventory = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btn_messages = new javax.swing.JButton();
        btn_student = new javax.swing.JButton();
        btn_academic = new javax.swing.JButton();
        btn_financial = new javax.swing.JButton();
        btn_customers = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_services = new javax.swing.JButton();
        btn_employees = new javax.swing.JButton();

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

        top_panel.setBackground(new java.awt.Color(52, 53, 57));
        top_panel.setMinimumSize(getPreferredSize());
        top_panel.setLayout(null);

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

        lbl_curUserFname.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        lbl_curUserFname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_curUserFname.setText("User");
        top_panel.add(lbl_curUserFname);
        lbl_curUserFname.setBounds(100, 10, 160, 25);

        jLabel4.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Admin Dashboard");
        top_panel.add(jLabel4);
        jLabel4.setBounds(590, 10, 160, 25);

        jLabel5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome,");
        top_panel.add(jLabel5);
        jLabel5.setBounds(20, 10, 80, 25);

        main_panel.add(top_panel);
        top_panel.setBounds(0, 0, 1080, 50);

        jPanel4.setBackground(new java.awt.Color(59, 62, 67));

        lbl_heading.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 24)); // NOI18N
        lbl_heading.setForeground(new java.awt.Color(153, 153, 153));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setText("Appointments");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(lbl_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lbl_heading)
                .addContainerGap())
        );

        main_panel.add(jPanel4);
        jPanel4.setBounds(260, 50, 820, 60);

        side_bar.setBackground(new java.awt.Color(67, 70, 75));
        side_bar.setLayout(new java.awt.CardLayout());

        pnl_home.setBackground(new java.awt.Color(67, 70, 75));
        pnl_home.setLayout(null);

        lbl_date.setFont(new java.awt.Font("Leelawadee UI", 0, 48)); // NOI18N
        lbl_date.setForeground(new java.awt.Color(153, 153, 153));
        lbl_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_date.setText("28.08.2016");
        pnl_home.add(lbl_date);
        lbl_date.setBounds(10, 250, 800, 64);

        lbl_time.setBackground(new java.awt.Color(204, 204, 204));
        lbl_time.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 85)); // NOI18N
        lbl_time.setForeground(new java.awt.Color(204, 204, 204));
        lbl_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_time.setText("04:02 AM");
        pnl_home.add(lbl_time);
        lbl_time.setBounds(140, 160, 530, 100);

        btn_messages_h.setBackground(new java.awt.Color(67, 70, 75));
        btn_messages_h.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_messages_h.setForeground(new java.awt.Color(204, 204, 204));
        btn_messages_h.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_mail_white_24dp_2x.png"))); // NOI18N
        btn_messages_h.setBorderPainted(false);
        btn_messages_h.setContentAreaFilled(false);
        btn_messages_h.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_messages_h.setIconTextGap(10);
        btn_messages_h.setOpaque(true);
        btn_messages_h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_messages_hActionPerformed(evt);
            }
        });
        pnl_home.add(btn_messages_h);
        btn_messages_h.setBounds(740, 480, 60, 50);

        side_bar.add(pnl_home, "card2");

        pnl_appointment.setBackground(new java.awt.Color(67, 70, 75));
        pnl_appointment.setPreferredSize(new java.awt.Dimension(820, 557));
        pnl_appointment.setLayout(null);

        addapp.setBackground(new java.awt.Color(12, 173, 183));
        addapp.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        addapp.setForeground(new java.awt.Color(255, 255, 255));
        addapp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_add_white_36dp_1x.png"))); // NOI18N
        addapp.setText("Add Appointments");
        addapp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addapp.setBorderPainted(false);
        addapp.setContentAreaFilled(false);
        addapp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp.setIconTextGap(20);
        addapp.setOpaque(true);
        addapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addappActionPerformed(evt);
            }
        });
        pnl_appointment.add(addapp);
        addapp.setBounds(130, 70, 240, 50);

        cancelApp.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_remove_white_36dp_1x.png"))); // NOI18N
        cancelApp.setText("Cancel Appointments");
        cancelApp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp.setBorderPainted(false);
        cancelApp.setContentAreaFilled(false);
        cancelApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp.setIconTextGap(20);
        cancelApp.setOpaque(true);
        cancelApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAppActionPerformed(evt);
            }
        });
        pnl_appointment.add(cancelApp);
        cancelApp.setBounds(130, 140, 240, 50);

        viewApps.setBackground(new java.awt.Color(12, 173, 183));
        viewApps.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        viewApps.setForeground(new java.awt.Color(255, 255, 255));
        viewApps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        viewApps.setText("View Appointments");
        viewApps.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        viewApps.setBorderPainted(false);
        viewApps.setContentAreaFilled(false);
        viewApps.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewApps.setIconTextGap(20);
        viewApps.setOpaque(true);
        viewApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAppsActionPerformed(evt);
            }
        });
        pnl_appointment.add(viewApps);
        viewApps.setBounds(460, 70, 240, 50);

        bviewApp.setBackground(new java.awt.Color(12, 173, 183));
        bviewApp.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bviewApp.setForeground(new java.awt.Color(255, 255, 255));
        bviewApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        bviewApp.setText("View Appointments");
        bviewApp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bviewApp.setBorderPainted(false);
        bviewApp.setContentAreaFilled(false);
        bviewApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bviewApp.setIconTextGap(20);
        bviewApp.setOpaque(true);
        bviewApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewAppActionPerformed(evt);
            }
        });
        pnl_appointment.add(bviewApp);
        bviewApp.setBounds(460, 400, 240, 50);

        curentApp.setBackground(new java.awt.Color(12, 173, 183));
        curentApp.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        curentApp.setForeground(new java.awt.Color(255, 255, 255));
        curentApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        curentApp.setText("Current Appointment");
        curentApp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        curentApp.setBorderPainted(false);
        curentApp.setContentAreaFilled(false);
        curentApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        curentApp.setIconTextGap(20);
        curentApp.setOpaque(true);
        curentApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentAppActionPerformed(evt);
            }
        });
        pnl_appointment.add(curentApp);
        curentApp.setBounds(130, 400, 240, 50);

        jPanel1.setBackground(new java.awt.Color(52, 53, 57));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Receptionist");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(330, 0, 170, 40);

        pnl_appointment.add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 40);

        jPanel2.setBackground(new java.awt.Color(52, 53, 57));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Beautician");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(330, 0, 170, 40);

        pnl_appointment.add(jPanel2);
        jPanel2.setBounds(0, 320, 820, 40);

        cancelApp1.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp1.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp1.setText("Sales Report");
        cancelApp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp1.setBorderPainted(false);
        cancelApp1.setContentAreaFilled(false);
        cancelApp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp1.setIconTextGap(20);
        cancelApp1.setOpaque(true);
        cancelApp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp1ActionPerformed(evt);
            }
        });
        pnl_appointment.add(cancelApp1);
        cancelApp1.setBounds(130, 210, 240, 50);

        cancelApp2.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp2.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_remove_white_36dp_1x.png"))); // NOI18N
        cancelApp2.setText("Update Appointments");
        cancelApp2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp2.setBorderPainted(false);
        cancelApp2.setContentAreaFilled(false);
        cancelApp2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp2.setIconTextGap(20);
        cancelApp2.setOpaque(true);
        cancelApp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp2ActionPerformed(evt);
            }
        });
        pnl_appointment.add(cancelApp2);
        cancelApp2.setBounds(460, 140, 240, 50);

        side_bar.add(pnl_appointment, "card2");

        pnl_customers.setBackground(new java.awt.Color(67, 70, 75));
        pnl_customers.setMinimumSize(new java.awt.Dimension(820, 557));
        pnl_customers.setLayout(null);

        addNewCus.setBackground(new java.awt.Color(12, 173, 183));
        addNewCus.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        addNewCus.setForeground(new java.awt.Color(255, 255, 255));
        addNewCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_add_white_36dp_1x.png"))); // NOI18N
        addNewCus.setText("Add Loyalty Customer");
        addNewCus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addNewCus.setBorderPainted(false);
        addNewCus.setContentAreaFilled(false);
        addNewCus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewCus.setIconTextGap(20);
        addNewCus.setOpaque(true);
        addNewCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCusActionPerformed(evt);
            }
        });
        pnl_customers.add(addNewCus);
        addNewCus.setBounds(130, 90, 240, 50);

        Birthdays.setBackground(new java.awt.Color(12, 173, 183));
        Birthdays.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        Birthdays.setForeground(new java.awt.Color(255, 255, 255));
        Birthdays.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_remove_white_36dp_1x.png"))); // NOI18N
        Birthdays.setText("Customer Birthdays");
        Birthdays.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        Birthdays.setBorderPainted(false);
        Birthdays.setContentAreaFilled(false);
        Birthdays.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Birthdays.setIconTextGap(20);
        Birthdays.setOpaque(true);
        Birthdays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthdaysActionPerformed(evt);
            }
        });
        pnl_customers.add(Birthdays);
        Birthdays.setBounds(130, 180, 240, 50);

        updateCus.setBackground(new java.awt.Color(12, 173, 183));
        updateCus.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        updateCus.setForeground(new java.awt.Color(255, 255, 255));
        updateCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_cached_white_36dp_1x.png"))); // NOI18N
        updateCus.setText("Update Customer");
        updateCus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        updateCus.setBorderPainted(false);
        updateCus.setContentAreaFilled(false);
        updateCus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateCus.setIconTextGap(20);
        updateCus.setOpaque(true);
        updateCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCusActionPerformed(evt);
            }
        });
        pnl_customers.add(updateCus);
        updateCus.setBounds(450, 90, 240, 50);

        jButton27.setBackground(new java.awt.Color(12, 173, 183));
        jButton27.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        jButton27.setText("View Appointments");
        jButton27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton27.setBorderPainted(false);
        jButton27.setContentAreaFilled(false);
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.setIconTextGap(20);
        jButton27.setOpaque(true);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        pnl_customers.add(jButton27);
        jButton27.setBounds(460, 340, 240, 50);

        searchCus.setBackground(new java.awt.Color(12, 173, 183));
        searchCus.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        searchCus.setForeground(new java.awt.Color(255, 255, 255));
        searchCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_search_white_36dp_1x.png"))); // NOI18N
        searchCus.setText("Search Customers");
        searchCus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        searchCus.setBorderPainted(false);
        searchCus.setContentAreaFilled(false);
        searchCus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchCus.setIconTextGap(20);
        searchCus.setOpaque(true);
        searchCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCusActionPerformed(evt);
            }
        });
        pnl_customers.add(searchCus);
        searchCus.setBounds(450, 180, 240, 50);

        jPanel3.setBackground(new java.awt.Color(52, 53, 57));
        jPanel3.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Receptionist");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(330, 0, 170, 40);

        pnl_customers.add(jPanel3);
        jPanel3.setBounds(0, 0, 820, 40);

        side_bar.add(pnl_customers, "card2");

        pnl_services.setBackground(new java.awt.Color(67, 70, 75));
        pnl_services.setMinimumSize(new java.awt.Dimension(820, 557));
        pnl_services.setPreferredSize(new java.awt.Dimension(820, 557));
        pnl_services.setLayout(null);

        addapp3.setBackground(new java.awt.Color(12, 173, 183));
        addapp3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        addapp3.setForeground(new java.awt.Color(255, 255, 255));
        addapp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_add_white_36dp_1x.png"))); // NOI18N
        addapp3.setText("Add Treatment");
        addapp3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addapp3.setBorderPainted(false);
        addapp3.setContentAreaFilled(false);
        addapp3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp3.setIconTextGap(20);
        addapp3.setOpaque(true);
        addapp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addapp3ActionPerformed(evt);
            }
        });
        pnl_services.add(addapp3);
        addapp3.setBounds(130, 70, 240, 50);

        cancelApp9.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp9.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_remove_white_36dp_1x.png"))); // NOI18N
        cancelApp9.setText("Delete Treatment");
        cancelApp9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp9.setBorderPainted(false);
        cancelApp9.setContentAreaFilled(false);
        cancelApp9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp9.setIconTextGap(20);
        cancelApp9.setOpaque(true);
        cancelApp9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp9ActionPerformed(evt);
            }
        });
        pnl_services.add(cancelApp9);
        cancelApp9.setBounds(130, 140, 240, 50);

        viewApps3.setBackground(new java.awt.Color(12, 173, 183));
        viewApps3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        viewApps3.setForeground(new java.awt.Color(255, 255, 255));
        viewApps3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        viewApps3.setText("Manage Salon Packages");
        viewApps3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        viewApps3.setBorderPainted(false);
        viewApps3.setContentAreaFilled(false);
        viewApps3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewApps3.setIconTextGap(20);
        viewApps3.setOpaque(true);
        viewApps3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewApps3ActionPerformed(evt);
            }
        });
        pnl_services.add(viewApps3);
        viewApps3.setBounds(460, 70, 260, 50);

        bviewApp5.setBackground(new java.awt.Color(12, 173, 183));
        bviewApp5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bviewApp5.setForeground(new java.awt.Color(255, 255, 255));
        bviewApp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        bviewApp5.setText("Feedback");
        bviewApp5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bviewApp5.setBorderPainted(false);
        bviewApp5.setContentAreaFilled(false);
        bviewApp5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bviewApp5.setIconTextGap(20);
        bviewApp5.setOpaque(true);
        bviewApp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewApp5ActionPerformed(evt);
            }
        });
        pnl_services.add(bviewApp5);
        bviewApp5.setBounds(290, 480, 240, 50);

        curentApp3.setBackground(new java.awt.Color(12, 173, 183));
        curentApp3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        curentApp3.setForeground(new java.awt.Color(255, 255, 255));
        curentApp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_grain_white_24dp_1x.png"))); // NOI18N
        curentApp3.setText("Handling Patch Test");
        curentApp3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        curentApp3.setBorderPainted(false);
        curentApp3.setContentAreaFilled(false);
        curentApp3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        curentApp3.setIconTextGap(20);
        curentApp3.setOpaque(true);
        curentApp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentApp3ActionPerformed(evt);
            }
        });
        pnl_services.add(curentApp3);
        curentApp3.setBounds(270, 290, 270, 50);

        jPanel13.setBackground(new java.awt.Color(52, 53, 57));
        jPanel13.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Manager");
        jPanel13.add(jLabel15);
        jLabel15.setBounds(330, 0, 170, 40);

        pnl_services.add(jPanel13);
        jPanel13.setBounds(0, 0, 820, 40);

        jPanel14.setBackground(new java.awt.Color(52, 53, 57));
        jPanel14.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Beautician");
        jPanel14.add(jLabel16);
        jLabel16.setBounds(330, 0, 170, 40);

        pnl_services.add(jPanel14);
        jPanel14.setBounds(0, 220, 820, 40);

        cancelApp11.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp11.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp11.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_cached_white_36dp_1x.png"))); // NOI18N
        cancelApp11.setText("Update Treatment");
        cancelApp11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp11.setBorderPainted(false);
        cancelApp11.setContentAreaFilled(false);
        cancelApp11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp11.setIconTextGap(20);
        cancelApp11.setOpaque(true);
        cancelApp11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp11ActionPerformed(evt);
            }
        });
        pnl_services.add(cancelApp11);
        cancelApp11.setBounds(460, 140, 260, 50);

        jPanel17.setBackground(new java.awt.Color(52, 53, 57));
        jPanel17.setLayout(null);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Customer");
        jPanel17.add(jLabel18);
        jLabel18.setBounds(330, 0, 170, 40);

        pnl_services.add(jPanel17);
        jPanel17.setBounds(0, 400, 820, 40);

        side_bar.add(pnl_services, "card2");

        pnl_employees.setBackground(new java.awt.Color(67, 70, 75));
        pnl_employees.setPreferredSize(new java.awt.Dimension(820, 557));
        pnl_employees.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(52, 53, 57));
        jPanel5.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Manager");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(330, 0, 170, 40);

        pnl_employees.add(jPanel5);
        jPanel5.setBounds(0, 0, 820, 40);

        addapp1.setBackground(new java.awt.Color(12, 173, 183));
        addapp1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        addapp1.setForeground(new java.awt.Color(255, 255, 255));
        addapp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_add_white_36dp_1x.png"))); // NOI18N
        addapp1.setText("Add Employee");
        addapp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addapp1.setBorderPainted(false);
        addapp1.setContentAreaFilled(false);
        addapp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp1.setIconTextGap(20);
        addapp1.setOpaque(true);
        addapp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addapp1ActionPerformed(evt);
            }
        });
        pnl_employees.add(addapp1);
        addapp1.setBounds(130, 60, 240, 50);

        viewApps1.setBackground(new java.awt.Color(12, 173, 183));
        viewApps1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        viewApps1.setForeground(new java.awt.Color(255, 255, 255));
        viewApps1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_search_white_36dp_1x.png"))); // NOI18N
        viewApps1.setText("Search Employee");
        viewApps1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        viewApps1.setBorderPainted(false);
        viewApps1.setContentAreaFilled(false);
        viewApps1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewApps1.setIconTextGap(20);
        viewApps1.setOpaque(true);
        viewApps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewApps1ActionPerformed(evt);
            }
        });
        pnl_employees.add(viewApps1);
        viewApps1.setBounds(460, 60, 240, 50);

        cancelApp3.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp3.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_remove_white_36dp_1x.png"))); // NOI18N
        cancelApp3.setText("Delete Employee");
        cancelApp3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp3.setBorderPainted(false);
        cancelApp3.setContentAreaFilled(false);
        cancelApp3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp3.setIconTextGap(20);
        cancelApp3.setOpaque(true);
        cancelApp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp3ActionPerformed(evt);
            }
        });
        pnl_employees.add(cancelApp3);
        cancelApp3.setBounds(460, 130, 240, 50);

        cancelApp4.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp4.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_cached_white_36dp_1x.png"))); // NOI18N
        cancelApp4.setText("Update Employee");
        cancelApp4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp4.setBorderPainted(false);
        cancelApp4.setContentAreaFilled(false);
        cancelApp4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp4.setIconTextGap(20);
        cancelApp4.setOpaque(true);
        cancelApp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp4ActionPerformed(evt);
            }
        });
        pnl_employees.add(cancelApp4);
        cancelApp4.setBounds(130, 130, 240, 50);

        cancelApp5.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp5.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_search_white_36dp_1x.png"))); // NOI18N
        cancelApp5.setText("Check Attendance");
        cancelApp5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp5.setBorderPainted(false);
        cancelApp5.setContentAreaFilled(false);
        cancelApp5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp5.setIconTextGap(20);
        cancelApp5.setOpaque(true);
        cancelApp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp5ActionPerformed(evt);
            }
        });
        pnl_employees.add(cancelApp5);
        cancelApp5.setBounds(130, 200, 240, 50);

        jPanel6.setBackground(new java.awt.Color(52, 53, 57));
        jPanel6.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Owner");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(330, 0, 170, 40);

        pnl_employees.add(jPanel6);
        jPanel6.setBounds(0, 270, 820, 40);

        curentApp1.setBackground(new java.awt.Color(12, 173, 183));
        curentApp1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        curentApp1.setForeground(new java.awt.Color(255, 255, 255));
        curentApp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_cached_white_36dp_1x.png"))); // NOI18N
        curentApp1.setText("Update Salary Rate For Course");
        curentApp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        curentApp1.setBorderPainted(false);
        curentApp1.setContentAreaFilled(false);
        curentApp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        curentApp1.setIconTextGap(20);
        curentApp1.setOpaque(true);
        curentApp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentApp1ActionPerformed(evt);
            }
        });
        pnl_employees.add(curentApp1);
        curentApp1.setBounds(100, 330, 300, 50);

        bviewApp1.setBackground(new java.awt.Color(12, 173, 183));
        bviewApp1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bviewApp1.setForeground(new java.awt.Color(255, 255, 255));
        bviewApp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_cached_white_36dp_1x.png"))); // NOI18N
        bviewApp1.setText("Update Employee Basic");
        bviewApp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bviewApp1.setBorderPainted(false);
        bviewApp1.setContentAreaFilled(false);
        bviewApp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bviewApp1.setIconTextGap(20);
        bviewApp1.setOpaque(true);
        bviewApp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewApp1ActionPerformed(evt);
            }
        });
        pnl_employees.add(bviewApp1);
        bviewApp1.setBounds(430, 330, 300, 50);

        jPanel11.setBackground(new java.awt.Color(52, 53, 57));
        jPanel11.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Employee");
        jPanel11.add(jLabel13);
        jLabel13.setBounds(120, 0, 170, 40);

        pnl_employees.add(jPanel11);
        jPanel11.setBounds(0, 400, 408, 40);

        bviewApp3.setBackground(new java.awt.Color(12, 173, 183));
        bviewApp3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bviewApp3.setForeground(new java.awt.Color(255, 255, 255));
        bviewApp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_content_paste_white_24dp_1x.png"))); // NOI18N
        bviewApp3.setText("Mark Attendance");
        bviewApp3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bviewApp3.setBorderPainted(false);
        bviewApp3.setContentAreaFilled(false);
        bviewApp3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bviewApp3.setIconTextGap(20);
        bviewApp3.setOpaque(true);
        bviewApp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewApp3ActionPerformed(evt);
            }
        });
        pnl_employees.add(bviewApp3);
        bviewApp3.setBounds(100, 460, 300, 50);

        jPanel12.setBackground(new java.awt.Color(52, 53, 57));
        jPanel12.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Accountant");
        jPanel12.add(jLabel14);
        jLabel14.setBounds(120, 0, 170, 40);

        pnl_employees.add(jPanel12);
        jPanel12.setBounds(412, 400, 408, 40);

        bviewApp4.setBackground(new java.awt.Color(12, 173, 183));
        bviewApp4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bviewApp4.setForeground(new java.awt.Color(255, 255, 255));
        bviewApp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_monetization_on_white_24dp_1x.png"))); // NOI18N
        bviewApp4.setText("Calculate Salary");
        bviewApp4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bviewApp4.setBorderPainted(false);
        bviewApp4.setContentAreaFilled(false);
        bviewApp4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bviewApp4.setIconTextGap(20);
        bviewApp4.setOpaque(true);
        bviewApp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewApp4ActionPerformed(evt);
            }
        });
        pnl_employees.add(bviewApp4);
        bviewApp4.setBounds(450, 460, 300, 50);

        side_bar.add(pnl_employees, "card2");

        pnl_academic.setBackground(new java.awt.Color(67, 70, 75));
        pnl_academic.setLayout(null);

        viewApps4.setBackground(new java.awt.Color(12, 173, 183));
        viewApps4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        viewApps4.setForeground(new java.awt.Color(255, 255, 255));
        viewApps4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        viewApps4.setText("Course Management Home page");
        viewApps4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        viewApps4.setBorderPainted(false);
        viewApps4.setContentAreaFilled(false);
        viewApps4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewApps4.setIconTextGap(20);
        viewApps4.setOpaque(true);
        viewApps4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewApps4ActionPerformed(evt);
            }
        });
        pnl_academic.add(viewApps4);
        viewApps4.setBounds(260, 120, 310, 50);

        jPanel16.setBackground(new java.awt.Color(52, 53, 57));
        jPanel16.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Manager");
        jPanel16.add(jLabel17);
        jLabel17.setBounds(330, 0, 170, 40);

        pnl_academic.add(jPanel16);
        jPanel16.setBounds(0, 0, 820, 40);

        side_bar.add(pnl_academic, "card2");

        pnl_students.setBackground(new java.awt.Color(67, 70, 75));
        pnl_students.setLayout(null);

        addapp5.setBackground(new java.awt.Color(12, 173, 183));
        addapp5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        addapp5.setForeground(new java.awt.Color(255, 255, 255));
        addapp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_add_white_36dp_1x.png"))); // NOI18N
        addapp5.setText("Student Registration");
        addapp5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addapp5.setBorderPainted(false);
        addapp5.setContentAreaFilled(false);
        addapp5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp5.setIconTextGap(20);
        addapp5.setOpaque(true);
        addapp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addapp5ActionPerformed(evt);
            }
        });
        pnl_students.add(addapp5);
        addapp5.setBounds(130, 70, 240, 50);

        cancelApp10.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp10.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp10.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_attach_money_white_24dp_1x.png"))); // NOI18N
        cancelApp10.setText("Student Payments");
        cancelApp10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp10.setBorderPainted(false);
        cancelApp10.setContentAreaFilled(false);
        cancelApp10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp10.setIconTextGap(20);
        cancelApp10.setOpaque(true);
        cancelApp10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp10ActionPerformed(evt);
            }
        });
        pnl_students.add(cancelApp10);
        cancelApp10.setBounds(130, 140, 240, 50);

        viewApps5.setBackground(new java.awt.Color(12, 173, 183));
        viewApps5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        viewApps5.setForeground(new java.awt.Color(255, 255, 255));
        viewApps5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        viewApps5.setText("Student Attendance");
        viewApps5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        viewApps5.setBorderPainted(false);
        viewApps5.setContentAreaFilled(false);
        viewApps5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewApps5.setIconTextGap(20);
        viewApps5.setOpaque(true);
        viewApps5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewApps5ActionPerformed(evt);
            }
        });
        pnl_students.add(viewApps5);
        viewApps5.setBounds(460, 70, 240, 50);

        jPanel18.setBackground(new java.awt.Color(52, 53, 57));
        jPanel18.setLayout(null);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Manager");
        jPanel18.add(jLabel19);
        jLabel19.setBounds(330, 0, 170, 40);

        pnl_students.add(jPanel18);
        jPanel18.setBounds(0, 0, 820, 40);

        cancelApp13.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp13.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp13.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_content_paste_white_24dp_1x.png"))); // NOI18N
        cancelApp13.setText("Student Grading");
        cancelApp13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp13.setBorderPainted(false);
        cancelApp13.setContentAreaFilled(false);
        cancelApp13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp13.setIconTextGap(20);
        cancelApp13.setOpaque(true);
        cancelApp13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp13ActionPerformed(evt);
            }
        });
        pnl_students.add(cancelApp13);
        cancelApp13.setBounds(460, 140, 240, 50);

        side_bar.add(pnl_students, "card2");

        pnl_financial.setBackground(new java.awt.Color(67, 70, 75));
        pnl_financial.setLayout(null);

        addapp2.setBackground(new java.awt.Color(12, 173, 183));
        addapp2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        addapp2.setForeground(new java.awt.Color(255, 255, 255));
        addapp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_attach_money_white_24dp_1x.png"))); // NOI18N
        addapp2.setText("Calculate Academy Income");
        addapp2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addapp2.setBorderPainted(false);
        addapp2.setContentAreaFilled(false);
        addapp2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp2.setIconTextGap(20);
        addapp2.setOpaque(true);
        addapp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addapp2ActionPerformed(evt);
            }
        });
        pnl_financial.add(addapp2);
        addapp2.setBounds(130, 70, 270, 50);

        cancelApp6.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp6.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_attach_money_white_24dp_1x.png"))); // NOI18N
        cancelApp6.setText("     Calculate Sallon Income");
        cancelApp6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp6.setBorderPainted(false);
        cancelApp6.setContentAreaFilled(false);
        cancelApp6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp6.setIconTextGap(20);
        cancelApp6.setOpaque(true);
        cancelApp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp6ActionPerformed(evt);
            }
        });
        pnl_financial.add(cancelApp6);
        cancelApp6.setBounds(130, 170, 270, 50);

        viewApps2.setBackground(new java.awt.Color(12, 173, 183));
        viewApps2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        viewApps2.setForeground(new java.awt.Color(255, 255, 255));
        viewApps2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_attach_money_white_24dp_1x.png"))); // NOI18N
        viewApps2.setText("   Calculate Salary Expense");
        viewApps2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        viewApps2.setBorderPainted(false);
        viewApps2.setContentAreaFilled(false);
        viewApps2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewApps2.setIconTextGap(20);
        viewApps2.setOpaque(true);
        viewApps2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewApps2ActionPerformed(evt);
            }
        });
        pnl_financial.add(viewApps2);
        viewApps2.setBounds(460, 70, 240, 50);

        bviewApp2.setBackground(new java.awt.Color(12, 173, 183));
        bviewApp2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        bviewApp2.setForeground(new java.awt.Color(255, 255, 255));
        bviewApp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        bviewApp2.setText("GeneratePay Sheet");
        bviewApp2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bviewApp2.setBorderPainted(false);
        bviewApp2.setContentAreaFilled(false);
        bviewApp2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bviewApp2.setIconTextGap(20);
        bviewApp2.setOpaque(true);
        bviewApp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewApp2ActionPerformed(evt);
            }
        });
        pnl_financial.add(bviewApp2);
        bviewApp2.setBounds(320, 250, 240, 50);

        curentApp2.setBackground(new java.awt.Color(12, 173, 183));
        curentApp2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        curentApp2.setForeground(new java.awt.Color(255, 255, 255));
        curentApp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_content_paste_white_24dp_1x.png"))); // NOI18N
        curentApp2.setText("            View Profit");
        curentApp2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        curentApp2.setBorderPainted(false);
        curentApp2.setContentAreaFilled(false);
        curentApp2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        curentApp2.setIconTextGap(20);
        curentApp2.setOpaque(true);
        curentApp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentApp2ActionPerformed(evt);
            }
        });
        pnl_financial.add(curentApp2);
        curentApp2.setBounds(130, 400, 240, 50);

        jPanel9.setBackground(new java.awt.Color(52, 53, 57));
        jPanel9.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Accountant");
        jPanel9.add(jLabel11);
        jLabel11.setBounds(330, 0, 170, 40);

        pnl_financial.add(jPanel9);
        jPanel9.setBounds(0, 0, 820, 40);

        jPanel10.setBackground(new java.awt.Color(52, 53, 57));
        jPanel10.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Manager");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(330, 0, 170, 40);

        pnl_financial.add(jPanel10);
        jPanel10.setBounds(0, 320, 820, 40);

        cancelApp8.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp8.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_attach_money_white_24dp_1x.png"))); // NOI18N
        cancelApp8.setText("Calculate Inventory Expense");
        cancelApp8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp8.setBorderPainted(false);
        cancelApp8.setContentAreaFilled(false);
        cancelApp8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp8.setIconTextGap(20);
        cancelApp8.setOpaque(true);
        cancelApp8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp8ActionPerformed(evt);
            }
        });
        pnl_financial.add(cancelApp8);
        cancelApp8.setBounds(460, 170, 240, 50);

        side_bar.add(pnl_financial, "card2");

        pnl_inventory.setBackground(new java.awt.Color(67, 70, 75));
        pnl_inventory.setLayout(null);

        addapp6.setBackground(new java.awt.Color(12, 173, 183));
        addapp6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        addapp6.setForeground(new java.awt.Color(255, 255, 255));
        addapp6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_mail_white_24dp_2x.png"))); // NOI18N
        addapp6.setText("Good Received Note");
        addapp6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addapp6.setBorderPainted(false);
        addapp6.setContentAreaFilled(false);
        addapp6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp6.setIconTextGap(20);
        addapp6.setOpaque(true);
        addapp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addapp6ActionPerformed(evt);
            }
        });
        pnl_inventory.add(addapp6);
        addapp6.setBounds(130, 70, 240, 50);

        cancelApp14.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp14.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp14.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_grain_white_24dp_1x.png"))); // NOI18N
        cancelApp14.setText("Product");
        cancelApp14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp14.setBorderPainted(false);
        cancelApp14.setContentAreaFilled(false);
        cancelApp14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp14.setIconTextGap(20);
        cancelApp14.setOpaque(true);
        cancelApp14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp14ActionPerformed(evt);
            }
        });
        pnl_inventory.add(cancelApp14);
        cancelApp14.setBounds(130, 140, 240, 50);

        viewApps7.setBackground(new java.awt.Color(12, 173, 183));
        viewApps7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        viewApps7.setForeground(new java.awt.Color(255, 255, 255));
        viewApps7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_person_pin_white_24dp_1x.png"))); // NOI18N
        viewApps7.setText("Supplier");
        viewApps7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        viewApps7.setBorderPainted(false);
        viewApps7.setContentAreaFilled(false);
        viewApps7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewApps7.setIconTextGap(20);
        viewApps7.setOpaque(true);
        viewApps7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewApps7ActionPerformed(evt);
            }
        });
        pnl_inventory.add(viewApps7);
        viewApps7.setBounds(460, 70, 240, 50);

        jPanel21.setBackground(new java.awt.Color(52, 53, 57));
        jPanel21.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Manager");
        jPanel21.add(jLabel8);
        jLabel8.setBounds(330, 0, 170, 40);

        pnl_inventory.add(jPanel21);
        jPanel21.setBounds(0, 0, 820, 40);

        cancelApp15.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp15.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_content_paste_white_24dp_1x.png"))); // NOI18N
        cancelApp15.setText("Order");
        cancelApp15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp15.setBorderPainted(false);
        cancelApp15.setContentAreaFilled(false);
        cancelApp15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp15.setIconTextGap(20);
        cancelApp15.setOpaque(true);
        cancelApp15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp15ActionPerformed(evt);
            }
        });
        pnl_inventory.add(cancelApp15);
        cancelApp15.setBounds(130, 210, 240, 50);

        cancelApp16.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp16.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_quilt_white_24dp_1x.png"))); // NOI18N
        cancelApp16.setText("Stock");
        cancelApp16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp16.setBorderPainted(false);
        cancelApp16.setContentAreaFilled(false);
        cancelApp16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp16.setIconTextGap(20);
        cancelApp16.setOpaque(true);
        cancelApp16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp16ActionPerformed(evt);
            }
        });
        pnl_inventory.add(cancelApp16);
        cancelApp16.setBounds(460, 140, 240, 50);

        side_bar.add(pnl_inventory, "card2");

        pnl_messages.setBackground(new java.awt.Color(67, 70, 75));
        pnl_messages.setLayout(null);

        addapp4.setBackground(new java.awt.Color(12, 173, 183));
        addapp4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        addapp4.setForeground(new java.awt.Color(255, 255, 255));
        addapp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_cached_white_36dp_1x.png"))); // NOI18N
        addapp4.setText("Manage Bridal Services");
        addapp4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        addapp4.setBorderPainted(false);
        addapp4.setContentAreaFilled(false);
        addapp4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp4.setIconTextGap(20);
        addapp4.setOpaque(true);
        addapp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addapp4ActionPerformed(evt);
            }
        });
        pnl_messages.add(addapp4);
        addapp4.setBounds(130, 70, 240, 50);

        cancelApp12.setBackground(new java.awt.Color(12, 173, 183));
        cancelApp12.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        cancelApp12.setForeground(new java.awt.Color(255, 255, 255));
        cancelApp12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_cached_white_36dp_1x.png"))); // NOI18N
        cancelApp12.setText("Manage Bridal Packages");
        cancelApp12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        cancelApp12.setBorderPainted(false);
        cancelApp12.setContentAreaFilled(false);
        cancelApp12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelApp12.setIconTextGap(20);
        cancelApp12.setOpaque(true);
        cancelApp12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApp12ActionPerformed(evt);
            }
        });
        pnl_messages.add(cancelApp12);
        cancelApp12.setBounds(130, 140, 240, 50);

        viewApps6.setBackground(new java.awt.Color(12, 173, 183));
        viewApps6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        viewApps6.setForeground(new java.awt.Color(255, 255, 255));
        viewApps6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_list_white_36dp_1x.png"))); // NOI18N
        viewApps6.setText("Analyze Bridal Services");
        viewApps6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        viewApps6.setBorderPainted(false);
        viewApps6.setContentAreaFilled(false);
        viewApps6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewApps6.setIconTextGap(20);
        viewApps6.setOpaque(true);
        viewApps6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewApps6ActionPerformed(evt);
            }
        });
        pnl_messages.add(viewApps6);
        viewApps6.setBounds(460, 70, 240, 50);

        curentApp4.setBackground(new java.awt.Color(12, 173, 183));
        curentApp4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        curentApp4.setForeground(new java.awt.Color(255, 255, 255));
        curentApp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_quilt_white_24dp_1x.png"))); // NOI18N
        curentApp4.setText("Bridal Packages");
        curentApp4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        curentApp4.setBorderPainted(false);
        curentApp4.setContentAreaFilled(false);
        curentApp4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        curentApp4.setIconTextGap(20);
        curentApp4.setOpaque(true);
        curentApp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentApp4ActionPerformed(evt);
            }
        });
        pnl_messages.add(curentApp4);
        curentApp4.setBounds(310, 360, 240, 50);

        jPanel19.setBackground(new java.awt.Color(52, 53, 57));
        jPanel19.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Manager");
        jPanel19.add(jLabel20);
        jLabel20.setBounds(330, 0, 170, 40);

        pnl_messages.add(jPanel19);
        jPanel19.setBounds(0, 0, 820, 40);

        jPanel20.setBackground(new java.awt.Color(52, 53, 57));
        jPanel20.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Customer");
        jPanel20.add(jLabel21);
        jLabel21.setBounds(330, 0, 170, 40);

        pnl_messages.add(jPanel20);
        jPanel20.setBounds(0, 280, 820, 40);

        side_bar.add(pnl_messages, "card2");

        main_panel.add(side_bar);
        side_bar.setBounds(260, 110, 820, 550);

        jPanel8.setBackground(new java.awt.Color(52, 53, 57));

        jPanel15.setBackground(new java.awt.Color(12, 173, 183));
        jPanel15.setLayout(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        main_panel.add(jPanel8);
        jPanel8.setBounds(-10, 660, 1090, 30);

        jPanel7.setBackground(new java.awt.Color(57, 60, 64));
        jPanel7.setLayout(null);

        btn_app.setBackground(new java.awt.Color(57, 60, 64));
        btn_app.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_app.setForeground(new java.awt.Color(204, 204, 204));
        btn_app.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_insert_invitation_white_24dp_1x.png"))); // NOI18N
        btn_app.setText("      Appointments   ");
        btn_app.setBorderPainted(false);
        btn_app.setContentAreaFilled(false);
        btn_app.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_app.setIconTextGap(10);
        btn_app.setOpaque(true);
        btn_app.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_appActionPerformed(evt);
            }
        });
        jPanel7.add(btn_app);
        btn_app.setBounds(0, 100, 260, 50);

        btn_inventory.setBackground(new java.awt.Color(57, 60, 64));
        btn_inventory.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_inventory.setForeground(new java.awt.Color(204, 204, 204));
        btn_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_grain_white_24dp_1x.png"))); // NOI18N
        btn_inventory.setText("        Inventory         ");
        btn_inventory.setBorderPainted(false);
        btn_inventory.setContentAreaFilled(false);
        btn_inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_inventory.setIconTextGap(10);
        btn_inventory.setOpaque(true);
        btn_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inventoryActionPerformed(evt);
            }
        });
        jPanel7.add(btn_inventory);
        btn_inventory.setBounds(0, 450, 260, 50);

        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("COMPANY");
        jPanel7.add(jLabel9);
        jLabel9.setBounds(20, 70, 77, 30);

        btn_messages.setBackground(new java.awt.Color(57, 60, 64));
        btn_messages.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_messages.setForeground(new java.awt.Color(204, 204, 204));
        btn_messages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_mail_white_24dp_1x.png"))); // NOI18N
        btn_messages.setText("   Bridal Services        ");
        btn_messages.setBorderPainted(false);
        btn_messages.setContentAreaFilled(false);
        btn_messages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_messages.setIconTextGap(10);
        btn_messages.setOpaque(true);
        btn_messages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_messagesActionPerformed(evt);
            }
        });
        jPanel7.add(btn_messages);
        btn_messages.setBounds(0, 500, 260, 50);

        btn_student.setBackground(new java.awt.Color(57, 60, 64));
        btn_student.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_student.setForeground(new java.awt.Color(204, 204, 204));
        btn_student.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_school_white_24dp_1x.png"))); // NOI18N
        btn_student.setText("         Students          ");
        btn_student.setActionCommand("        Students          ");
        btn_student.setBorderPainted(false);
        btn_student.setContentAreaFilled(false);
        btn_student.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_student.setIconTextGap(10);
        btn_student.setOpaque(true);
        btn_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_studentActionPerformed(evt);
            }
        });
        jPanel7.add(btn_student);
        btn_student.setBounds(0, 350, 260, 50);

        btn_academic.setBackground(new java.awt.Color(57, 60, 64));
        btn_academic.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_academic.setForeground(new java.awt.Color(204, 204, 204));
        btn_academic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_import_contacts_white_24dp_1x.png"))); // NOI18N
        btn_academic.setText("        Academic         ");
        btn_academic.setBorderPainted(false);
        btn_academic.setContentAreaFilled(false);
        btn_academic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_academic.setIconTextGap(10);
        btn_academic.setOpaque(true);
        btn_academic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_academicActionPerformed(evt);
            }
        });
        jPanel7.add(btn_academic);
        btn_academic.setBounds(0, 300, 260, 50);

        btn_financial.setBackground(new java.awt.Color(57, 60, 64));
        btn_financial.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_financial.setForeground(new java.awt.Color(204, 204, 204));
        btn_financial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_monetization_on_white_24dp_1x.png"))); // NOI18N
        btn_financial.setText("         Financial         ");
        btn_financial.setBorderPainted(false);
        btn_financial.setContentAreaFilled(false);
        btn_financial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_financial.setIconTextGap(10);
        btn_financial.setOpaque(true);
        btn_financial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_financialActionPerformed(evt);
            }
        });
        jPanel7.add(btn_financial);
        btn_financial.setBounds(0, 400, 260, 50);

        btn_customers.setBackground(new java.awt.Color(57, 60, 64));
        btn_customers.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_customers.setForeground(new java.awt.Color(204, 204, 204));
        btn_customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_people_white_24dp_1x.png"))); // NOI18N
        btn_customers.setText("       Customers        ");
        btn_customers.setBorderPainted(false);
        btn_customers.setContentAreaFilled(false);
        btn_customers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_customers.setIconTextGap(10);
        btn_customers.setOpaque(true);
        btn_customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customersActionPerformed(evt);
            }
        });
        jPanel7.add(btn_customers);
        btn_customers.setBounds(0, 150, 260, 50);

        btn_home.setBackground(new java.awt.Color(12, 173, 183));
        btn_home.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_home.setForeground(new java.awt.Color(204, 204, 204));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_home_white_24dp_1x.png"))); // NOI18N
        btn_home.setText("           HOME           ");
        btn_home.setBorderPainted(false);
        btn_home.setContentAreaFilled(false);
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.setIconTextGap(10);
        btn_home.setOpaque(true);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jPanel7.add(btn_home);
        btn_home.setBounds(0, 0, 260, 60);

        btn_services.setBackground(new java.awt.Color(57, 60, 64));
        btn_services.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_services.setForeground(new java.awt.Color(204, 204, 204));
        btn_services.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_view_quilt_white_24dp_1x.png"))); // NOI18N
        btn_services.setText("     Salon services    ");
        btn_services.setBorderPainted(false);
        btn_services.setContentAreaFilled(false);
        btn_services.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_services.setIconTextGap(10);
        btn_services.setOpaque(true);
        btn_services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_servicesActionPerformed(evt);
            }
        });
        jPanel7.add(btn_services);
        btn_services.setBounds(0, 200, 260, 50);

        btn_employees.setBackground(new java.awt.Color(57, 60, 64));
        btn_employees.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_employees.setForeground(new java.awt.Color(204, 204, 204));
        btn_employees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_person_pin_white_24dp_1x.png"))); // NOI18N
        btn_employees.setText("       Employees        ");
        btn_employees.setBorderPainted(false);
        btn_employees.setContentAreaFilled(false);
        btn_employees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_employees.setIconTextGap(10);
        btn_employees.setOpaque(true);
        btn_employees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_employeesActionPerformed(evt);
            }
        });
        jPanel7.add(btn_employees);
        btn_employees.setBounds(0, 250, 260, 50);

        main_panel.add(jPanel7);
        jPanel7.setBounds(0, 50, 260, 610);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
  
        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
       
        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton2MouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        lbl_curUserFname.setText(curUserFname);
        
        
        lbl_heading.setText("");
        
        setColours();
        
        btn_home.setBackground(new java.awt.Color(12,173,183));
        btn_home.setForeground(new java.awt.Color(255,255,255));    
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_home);
        side_bar.repaint();
        side_bar.revalidate();
        

    }//GEN-LAST:event_formWindowOpened

    private void btn_appActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_appActionPerformed
      
        lbl_heading.setText("Appointments");
        
        setColours();
        
        btn_app.setBackground(new java.awt.Color(12,173,183));
        btn_app.setForeground(new java.awt.Color(255,255,255));          
        
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_appointment);
        side_bar.repaint();
        side_bar.revalidate();
        
        
        
    }//GEN-LAST:event_btn_appActionPerformed

    private void btn_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inventoryActionPerformed
       
        lbl_heading.setText("Inventory");
        
        setColours();
        
        btn_inventory.setBackground(new java.awt.Color(12,173,183));
        btn_inventory.setForeground(new java.awt.Color(255,255,255));               
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_inventory);
        side_bar.repaint();
        side_bar.revalidate();
        
    }//GEN-LAST:event_btn_inventoryActionPerformed

    private void btn_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_studentActionPerformed
    
        
        lbl_heading.setText("Students");
        
        setColours();
        
        btn_student.setBackground(new java.awt.Color(12,173,183));
        btn_student.setForeground(new java.awt.Color(255,255,255));         
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_students);
        side_bar.repaint();
        side_bar.revalidate();
        
    }//GEN-LAST:event_btn_studentActionPerformed

    private void btn_academicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_academicActionPerformed

        lbl_heading.setText("Academic");
        
        setColours();
        
        btn_academic.setBackground(new java.awt.Color(12,173,183));
        btn_academic.setForeground(new java.awt.Color(255,255,255));         
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_academic);
        side_bar.repaint();
        side_bar.revalidate();       
        
        
    }//GEN-LAST:event_btn_academicActionPerformed

    private void btn_financialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_financialActionPerformed

        lbl_heading.setText("Financial");
        
        setColours();
        
        btn_financial.setBackground(new java.awt.Color(12,173,183));
        btn_financial.setForeground(new java.awt.Color(255,255,255)); 


        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_financial);
        side_bar.repaint();
        side_bar.revalidate();        
        
        
    }//GEN-LAST:event_btn_financialActionPerformed

    private void btn_customersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customersActionPerformed

        lbl_heading.setText("Customers");
        
        setColours();
        
        btn_customers.setBackground(new java.awt.Color(12,173,183));
        btn_customers.setForeground(new java.awt.Color(255,255,255)); 
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_customers);
        side_bar.repaint();
        side_bar.revalidate();  
        
        
        
        
    }//GEN-LAST:event_btn_customersActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed

        lbl_heading.setText("");
        
        setColours();
        
        btn_home.setBackground(new java.awt.Color(12,173,183));
        btn_home.setForeground(new java.awt.Color(255,255,255));         
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_home);
        side_bar.repaint();
        side_bar.revalidate();        
        
        
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_servicesActionPerformed

        lbl_heading.setText("Salon Services");
        setColours();
        
        btn_services.setBackground(new java.awt.Color(12,173,183));
        btn_services.setForeground(new java.awt.Color(255,255,255)); 
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_services);
        side_bar.repaint();
        side_bar.revalidate();        
        
        
    }//GEN-LAST:event_btn_servicesActionPerformed

    private void btn_employeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_employeesActionPerformed

        lbl_heading.setText("Employees");
        setColours();
        
        btn_employees.setBackground(new java.awt.Color(12,173,183));
        btn_employees.setForeground(new java.awt.Color(255,255,255)); 
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_employees);
        side_bar.repaint();
        side_bar.revalidate();        
                
        
        
    }//GEN-LAST:event_btn_employeesActionPerformed

    private void btn_messagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_messagesActionPerformed
 
        lbl_heading.setText("Messages");
        
        setColours();
        
        btn_messages.setBackground(new java.awt.Color(12,173,183));
        btn_messages.setForeground(new java.awt.Color(255,255,255)); 
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_messages);
        side_bar.repaint();
        side_bar.revalidate();            
        
        
    }//GEN-LAST:event_btn_messagesActionPerformed

    private void addappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addappActionPerformed
        
        
        AddAppointment ad = new AddAppointment();
        ad.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_addappActionPerformed

    private void cancelAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAppActionPerformed
       
        Appointments as = new Appointments();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelAppActionPerformed

    private void viewAppsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAppsActionPerformed
     
        
        Appointments as = new Appointments();
        as.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_viewAppsActionPerformed

    private void btn_messages_hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_messages_hActionPerformed
       
        
        lbl_heading.setText("Messages");
        
        setColours();
        
        btn_messages.setBackground(new java.awt.Color(12,173,183));
        btn_messages.setForeground(new java.awt.Color(255,255,255)); 
        
        side_bar.removeAll();
        side_bar.repaint();
        side_bar.revalidate();
        
        side_bar.add(pnl_messages);
        side_bar.repaint();
        side_bar.revalidate();            
        
        
    }//GEN-LAST:event_btn_messages_hActionPerformed

    private void addNewCusActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addNewCusActionPerformed
    {//GEN-HEADEREND:event_addNewCusActionPerformed
        
        
        AddLoyaltyCustomer adl = new AddLoyaltyCustomer();
        adl.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_addNewCusActionPerformed

    private void BirthdaysActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BirthdaysActionPerformed
    {//GEN-HEADEREND:event_BirthdaysActionPerformed
       Birthdays b = new Birthdays();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BirthdaysActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton27ActionPerformed
    {//GEN-HEADEREND:event_jButton27ActionPerformed
        
        
        
        
        
    }//GEN-LAST:event_jButton27ActionPerformed

    private void searchCusActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchCusActionPerformed
    {//GEN-HEADEREND:event_searchCusActionPerformed
        
        ViewCustomers adc = new ViewCustomers();
        adc.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_searchCusActionPerformed

    private void bviewAppActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bviewAppActionPerformed
    {//GEN-HEADEREND:event_bviewAppActionPerformed
        
        
        BeauAppointments ba = new BeauAppointments();
        ba.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_bviewAppActionPerformed

    private void curentAppActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_curentAppActionPerformed
    {//GEN-HEADEREND:event_curentAppActionPerformed
    
        
        CurrentAppointment ca = new CurrentAppointment();
        ca.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_curentAppActionPerformed

    private void updateCusActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_updateCusActionPerformed
    {//GEN-HEADEREND:event_updateCusActionPerformed
       
        
        AddLoyaltyCustomer adl = new AddLoyaltyCustomer();
        adl.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_updateCusActionPerformed

    private void cancelApp1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelApp1ActionPerformed
    {//GEN-HEADEREND:event_cancelApp1ActionPerformed

        Sales adl = new Sales();
        adl.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_cancelApp1ActionPerformed

    private void cancelApp2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelApp2ActionPerformed
    {//GEN-HEADEREND:event_cancelApp2ActionPerformed
        
    }//GEN-LAST:event_cancelApp2ActionPerformed

    private void addapp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addapp1ActionPerformed
        AddEmployee ae = new AddEmployee();
        ae.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addapp1ActionPerformed

    private void viewApps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewApps1ActionPerformed
        SearchEmployee se = new SearchEmployee();
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewApps1ActionPerformed

    private void cancelApp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp3ActionPerformed
        SearchEmployee se = new SearchEmployee();
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp3ActionPerformed

    private void cancelApp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp4ActionPerformed
        SearchEmployee se = new SearchEmployee();
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp4ActionPerformed

    private void cancelApp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp5ActionPerformed
        CheckAttendance ca = new CheckAttendance();
        ca.setVisible(true);
    }//GEN-LAST:event_cancelApp5ActionPerformed

    private void curentApp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curentApp1ActionPerformed
        UpdateCourseSalRate ucsr = new UpdateCourseSalRate();
        ucsr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_curentApp1ActionPerformed

    private void bviewApp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewApp1ActionPerformed
        new UpdatePostDetails().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bviewApp1ActionPerformed

    private void addapp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addapp2ActionPerformed
       AcdIncome acd = new AcdIncome();
       acd.setVisible(true);
    }//GEN-LAST:event_addapp2ActionPerformed

    private void cancelApp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp6ActionPerformed
        SalIncome income = new SalIncome();
        income.setVisible(true);
    }//GEN-LAST:event_cancelApp6ActionPerformed

    private void viewApps2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewApps2ActionPerformed
        salaryexp sal = new salaryexp();
        sal.setVisible(true);
    }//GEN-LAST:event_viewApps2ActionPerformed

    private void bviewApp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewApp2ActionPerformed
        // TODO add your handling code here:
        paySH sheet = new paySH();
        sheet.setVisible(true);
    }//GEN-LAST:event_bviewApp2ActionPerformed

    private void curentApp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curentApp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_curentApp2ActionPerformed

    private void cancelApp8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp8ActionPerformed
        // TODO add your handling code here:
        salaryexp sal = new salaryexp();
        sal.setVisible(true);
        
    }//GEN-LAST:event_cancelApp8ActionPerformed

    private void bviewApp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewApp3ActionPerformed
        new MarkAttendance().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bviewApp3ActionPerformed

    private void bviewApp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewApp4ActionPerformed
        new CalcSalaryPerMonth().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bviewApp4ActionPerformed

    private void addapp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addapp3ActionPerformed
        new treatments().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addapp3ActionPerformed

    private void cancelApp9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp9ActionPerformed
        new treatments().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp9ActionPerformed

    private void viewApps3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewApps3ActionPerformed
        new manageSalonPackagess1().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewApps3ActionPerformed

    private void bviewApp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewApp5ActionPerformed
        new Feedback().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bviewApp5ActionPerformed

    private void curentApp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curentApp3ActionPerformed
        new PatchTest().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_curentApp3ActionPerformed

    private void cancelApp11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp11ActionPerformed
        new treatments().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp11ActionPerformed

    private void viewApps4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewApps4ActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewApps4ActionPerformed

    private void addapp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addapp5ActionPerformed
        new Home_Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addapp5ActionPerformed

    private void cancelApp10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp10ActionPerformed
        new Payments_Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp10ActionPerformed

    private void viewApps5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewApps5ActionPerformed
        new Attendance_Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewApps5ActionPerformed

    private void cancelApp13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp13ActionPerformed
        new Grading_Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp13ActionPerformed

    private void addapp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addapp4ActionPerformed
        new ManagerBridalPanal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addapp4ActionPerformed

    private void cancelApp12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp12ActionPerformed
        new Managerdefaultpac().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp12ActionPerformed

    private void viewApps6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewApps6ActionPerformed
        new ManagerBSAnalysis().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewApps6ActionPerformed

    private void curentApp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curentApp4ActionPerformed
        new BridalPack().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_curentApp4ActionPerformed

    private void addapp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addapp6ActionPerformed
        new Home_inventory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addapp6ActionPerformed

    private void cancelApp14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp14ActionPerformed
        new Home_inventory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp14ActionPerformed

    private void viewApps7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewApps7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewApps7ActionPerformed

    private void cancelApp15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp15ActionPerformed
        new Home_inventory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp15ActionPerformed

    private void cancelApp16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApp16ActionPerformed
        new Home_inventory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelApp16ActionPerformed

    
    
    public void setColours()
    {
        
        /* text colour to gray */
        
        btn_home.setForeground(new java.awt.Color(204,204,204));
        btn_app.setForeground(new java.awt.Color(204,204,204));
        btn_customers.setForeground(new java.awt.Color(204,204,204));
        btn_services.setForeground(new java.awt.Color(204,204,204));
        btn_employees.setForeground(new java.awt.Color(204,204,204));
        btn_academic.setForeground(new java.awt.Color(204,204,204));
        btn_student.setForeground(new java.awt.Color(204,204,204));
        btn_financial.setForeground(new java.awt.Color(204,204,204));
        btn_inventory.setForeground(new java.awt.Color(204,204,204));
        btn_messages.setForeground(new java.awt.Color(204,204,204));
        
        
        /* background colour to gray */
        
        
        btn_home.setBackground(new java.awt.Color(57,60,64));
        btn_app.setBackground(new java.awt.Color(57,60,64));
        btn_customers.setBackground(new java.awt.Color(57,60,64));
        btn_services.setBackground(new java.awt.Color(57,60,64));
        btn_employees.setBackground(new java.awt.Color(57,60,64));
        btn_academic.setBackground(new java.awt.Color(57,60,64));
        btn_student.setBackground(new java.awt.Color(57,60,64));
        btn_financial.setBackground(new java.awt.Color(57,60,64));
        btn_inventory.setBackground(new java.awt.Color(57,60,64));
        btn_messages.setBackground(new java.awt.Color(57,60,64));
   
        
        
        
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new HomePage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Birthdays;
    private javax.swing.JButton addNewCus;
    private javax.swing.JButton addapp;
    private javax.swing.JButton addapp1;
    private javax.swing.JButton addapp2;
    private javax.swing.JButton addapp3;
    private javax.swing.JButton addapp4;
    private javax.swing.JButton addapp5;
    private javax.swing.JButton addapp6;
    private javax.swing.JButton btn_academic;
    private javax.swing.JButton btn_app;
    private javax.swing.JButton btn_customers;
    private javax.swing.JButton btn_employees;
    private javax.swing.JButton btn_financial;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_inventory;
    private javax.swing.JButton btn_messages;
    private javax.swing.JButton btn_messages_h;
    private javax.swing.JButton btn_services;
    private javax.swing.JButton btn_student;
    private javax.swing.JButton bviewApp;
    private javax.swing.JButton bviewApp1;
    private javax.swing.JButton bviewApp2;
    private javax.swing.JButton bviewApp3;
    private javax.swing.JButton bviewApp4;
    private javax.swing.JButton bviewApp5;
    private javax.swing.JButton cancelApp;
    private javax.swing.JButton cancelApp1;
    private javax.swing.JButton cancelApp10;
    private javax.swing.JButton cancelApp11;
    private javax.swing.JButton cancelApp12;
    private javax.swing.JButton cancelApp13;
    private javax.swing.JButton cancelApp14;
    private javax.swing.JButton cancelApp15;
    private javax.swing.JButton cancelApp16;
    private javax.swing.JButton cancelApp2;
    private javax.swing.JButton cancelApp3;
    private javax.swing.JButton cancelApp4;
    private javax.swing.JButton cancelApp5;
    private javax.swing.JButton cancelApp6;
    private javax.swing.JButton cancelApp8;
    private javax.swing.JButton cancelApp9;
    private javax.swing.JButton curentApp;
    private javax.swing.JButton curentApp1;
    private javax.swing.JButton curentApp2;
    private javax.swing.JButton curentApp3;
    private javax.swing.JButton curentApp4;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton27;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_curUserFname;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel pnl_academic;
    private javax.swing.JPanel pnl_appointment;
    private javax.swing.JPanel pnl_customers;
    private javax.swing.JPanel pnl_employees;
    private javax.swing.JPanel pnl_financial;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_inventory;
    private javax.swing.JPanel pnl_messages;
    private javax.swing.JPanel pnl_services;
    private javax.swing.JPanel pnl_students;
    private javax.swing.JButton searchCus;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    private javax.swing.JButton updateCus;
    private javax.swing.JButton viewApps;
    private javax.swing.JButton viewApps1;
    private javax.swing.JButton viewApps2;
    private javax.swing.JButton viewApps3;
    private javax.swing.JButton viewApps4;
    private javax.swing.JButton viewApps5;
    private javax.swing.JButton viewApps6;
    private javax.swing.JButton viewApps7;
    // End of variables declaration//GEN-END:variables
}
