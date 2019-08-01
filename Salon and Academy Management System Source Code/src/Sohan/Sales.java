/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sohan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author it15-102560
 */
public class Sales extends javax.swing.JFrame {

    /**
     * Creates new form gui
     */
    public Sales() {
        initComponents();
    }


    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
    
    
    
    int completed=0;
    int inqueue=0;
    int cancelled=0;
    double revenue=0.0;
    double yesterday=0.0;
    
    int haircol=0;
    int manicure=0;
    int clean=0;
    
    int totCus=0;
    
    int total=0;
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        msg_venue = new javax.swing.JLabel();
        amount3 = new javax.swing.JLabel();
        msg_title = new javax.swing.JLabel();
        msg_description = new javax.swing.JLabel();
        msg_datetime = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbl_completed = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_inqueue = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_cancelled = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lbl_totCus = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lbl_revenue = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lbl_yesterday = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        lbl_haircol = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lbl_manicure = new javax.swing.JLabel();
        lbl_clean = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl_total = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        viewapp = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();

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

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel3.setBackground(new java.awt.Color(47, 52, 56));
        jPanel3.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(46, 164, 158));
        jPanel6.setLayout(null);

        lbl_completed.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_completed.setForeground(new java.awt.Color(255, 255, 255));
        lbl_completed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_completed.setText("17");
        jPanel6.add(lbl_completed);
        lbl_completed.setBounds(20, 40, 67, 48);

        jLabel22.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("served");
        jPanel6.add(jLabel22);
        jLabel22.setBounds(20, 90, 79, 25);

        jLabel23.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("in queue");
        jPanel6.add(jLabel23);
        jLabel23.setBounds(134, 92, 99, 25);

        lbl_inqueue.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_inqueue.setForeground(new java.awt.Color(255, 255, 255));
        lbl_inqueue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_inqueue.setText("8");
        jPanel6.add(lbl_inqueue);
        lbl_inqueue.setBounds(154, 37, 67, 48);

        jLabel25.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("cancelled");
        jPanel6.add(jLabel25);
        jLabel25.setBounds(280, 92, 88, 25);

        lbl_cancelled.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_cancelled.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancelled.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cancelled.setText("3");
        jPanel6.add(lbl_cancelled);
        lbl_cancelled.setBounds(280, 37, 67, 48);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(0, 50, 380, 140);

        jLabel21.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("APPOINTMENTS");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(130, 9, 140, 20);

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setText("TODAY");
        jPanel3.add(jLabel27);
        jLabel27.setBounds(170, 28, 50, 20);

        jPanel7.setBackground(new java.awt.Color(47, 52, 56));
        jPanel7.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(46, 164, 158));
        jPanel9.setLayout(null);

        lbl_totCus.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_totCus.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totCus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totCus.setText("7");
        jPanel9.add(lbl_totCus);
        lbl_totCus.setBounds(160, 20, 67, 48);

        jLabel35.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Total Appointments");
        jPanel9.add(jLabel35);
        jLabel35.setBounds(80, 90, 230, 25);

        jPanel7.add(jPanel9);
        jPanel9.setBounds(0, 50, 380, 140);

        jLabel34.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("TOTAL");
        jPanel7.add(jLabel34);
        jLabel34.setBounds(10, -1, 360, 50);

        jPanel12.setBackground(new java.awt.Color(47, 52, 56));
        jPanel12.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(46, 164, 158));
        jPanel13.setLayout(null);

        lbl_revenue.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_revenue.setForeground(new java.awt.Color(255, 255, 255));
        lbl_revenue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_revenue.setText("69050.00");
        jPanel13.add(lbl_revenue);
        lbl_revenue.setBounds(50, 30, 182, 48);

        jLabel37.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Rs.");
        jPanel13.add(jLabel37);
        jLabel37.setBounds(30, 50, 27, 20);

        jLabel43.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("From Appointments");
        jPanel13.add(jLabel43);
        jLabel43.setBounds(40, 130, 170, 20);

        jLabel50.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("*so far");
        jPanel13.add(jLabel50);
        jLabel50.setBounds(90, 90, 64, 20);

        jPanel12.add(jPanel13);
        jPanel13.setBounds(0, 80, 250, 180);

        jLabel42.setFont(new java.awt.Font("Leelawadee UI", 0, 20)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("REVENUE");
        jPanel12.add(jLabel42);
        jLabel42.setBounds(50, 0, 150, 40);

        jLabel44.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("TODAY");
        jPanel12.add(jLabel44);
        jLabel44.setBounds(70, 40, 110, 40);

        jPanel14.setBackground(new java.awt.Color(46, 164, 158));
        jPanel14.setLayout(null);

        lbl_yesterday.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_yesterday.setForeground(new java.awt.Color(255, 255, 255));
        lbl_yesterday.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_yesterday.setText("80,000.00");
        jPanel14.add(lbl_yesterday);
        lbl_yesterday.setBounds(50, 40, 180, 48);

        jLabel45.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Rs.");
        jPanel14.add(jLabel45);
        jLabel45.setBounds(20, 60, 27, 20);

        jPanel12.add(jPanel14);
        jPanel14.setBounds(0, 310, 250, 120);

        jLabel47.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(204, 204, 204));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("YESTERDAY");
        jPanel12.add(jLabel47);
        jLabel47.setBounds(70, 270, 110, 30);

        jPanel10.setBackground(new java.awt.Color(47, 52, 56));
        jPanel10.setLayout(null);

        jPanel15.setBackground(new java.awt.Color(46, 164, 158));
        jPanel15.setLayout(null);

        jLabel41.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Hair Colouring");
        jPanel15.add(jLabel41);
        jLabel41.setBounds(20, 30, 180, 30);

        lbl_haircol.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_haircol.setForeground(new java.awt.Color(255, 255, 255));
        lbl_haircol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_haircol.setText("2");
        jPanel15.add(lbl_haircol);
        lbl_haircol.setBounds(220, 20, 67, 48);

        jLabel51.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Manicure");
        jPanel15.add(jLabel51);
        jLabel51.setBounds(20, 90, 180, 30);

        lbl_manicure.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_manicure.setForeground(new java.awt.Color(255, 255, 255));
        lbl_manicure.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_manicure.setText("2");
        jPanel15.add(lbl_manicure);
        lbl_manicure.setBounds(220, 80, 67, 48);

        lbl_clean.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_clean.setForeground(new java.awt.Color(255, 255, 255));
        lbl_clean.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_clean.setText("2");
        jPanel15.add(lbl_clean);
        lbl_clean.setBounds(220, 140, 67, 48);

        jLabel54.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Clean Up");
        jPanel15.add(jLabel54);
        jLabel54.setBounds(20, 150, 180, 30);

        jPanel10.add(jPanel15);
        jPanel15.setBounds(0, 50, 320, 210);

        jLabel48.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(204, 204, 204));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("TREATMENTS");
        jPanel10.add(jLabel48);
        jLabel48.setBounds(90, 10, 130, 30);

        jLabel46.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("TOTAL");
        jPanel10.add(jLabel46);
        jLabel46.setBounds(100, 270, 110, 30);

        jPanel16.setBackground(new java.awt.Color(46, 164, 158));
        jPanel16.setLayout(null);

        lbl_total.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("9");
        jPanel16.add(lbl_total);
        lbl_total.setBounds(120, 10, 67, 48);

        jLabel26.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("All Selected Treatments");
        jPanel16.add(jLabel26);
        jLabel26.setBounds(40, 60, 230, 25);

        jPanel10.add(jPanel16);
        jPanel16.setBounds(0, 310, 320, 120);

        jButton1.setText("Customer Visits");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 1080, 510);

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

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));
        jPanel4.setLayout(null);

        viewapp.setBackground(new java.awt.Color(67, 70, 75));
        viewapp.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        viewapp.setForeground(new java.awt.Color(204, 204, 204));
        viewapp.setText("Report");
        viewapp.setBorderPainted(false);
        viewapp.setContentAreaFilled(false);
        viewapp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewapp.setIconTextGap(10);
        viewapp.setOpaque(true);
        viewapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewappActionPerformed(evt);
            }
        });
        jPanel4.add(viewapp);
        viewapp.setBounds(350, 25, 200, 70);

        jPanel17.setBackground(new java.awt.Color(12, 173, 183));
        jPanel17.setPreferredSize(new java.awt.Dimension(190, 3));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel17);
        jPanel17.setBounds(360, 90, 180, 10);

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

        
        
        
         try
        {
        
        //=================================================================//    
         
          String  st = "SELECT COUNT(app_id)\n" +
                       "FROM appointment\n" +
                        "WHERE status = 'completed' and app_date = CURDATE();";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    completed = rs.getInt(1);                
                }                       
                
                lbl_completed.setText(Integer.toString(completed));
                
                
        //=================================================================//    
         
            st = "SELECT COUNT(app_id)\n" +
                       "FROM appointment\n" +
                        "WHERE status = 'in queue' and app_date = CURDATE();";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    inqueue = rs.getInt(1);                
                }                       
                
                lbl_inqueue.setText(Integer.toString(inqueue));
                
                
        //=================================================================//    
         
            st = "SELECT COUNT(app_id)\n" +
                       "FROM appointment\n" +
                        "WHERE status = 'cancelled' and app_date = CURDATE();";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    cancelled = rs.getInt(1);                
                }                       
                
                lbl_cancelled.setText(Integer.toString(cancelled));
                
        //=================================================================//    
         
            st = "SELECT SUM(price)\n" +
                 "FROM appointment\n" +
                 "WHERE app_date = CURDATE();";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    revenue = rs.getDouble(1);                
                }                       
                
                lbl_revenue.setText(Double.toString(revenue)+"0");
                
                
        //=================================================================//    
         
            st = "SELECT SUM(price)\n" +
                 "FROM appointment\n" +
                 "WHERE app_date = SUBDATE(CURDATE(),1);";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    yesterday = rs.getDouble(1);                
                }                       
                
                lbl_yesterday.setText(Double.toString(yesterday)+"0");
                
                        
                
        //=================================================================//    
         
            st = "SELECT COUNT(tId)\n" +
                 "FROM apphastreat\n" +
                 "WHERE tId = 1003\n" +
                 "GROUP BY tId";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    haircol = rs.getInt(1);                
                }                       
                
                lbl_haircol.setText(Integer.toString(haircol));
                
                
        //=================================================================//    
         
            st = "SELECT COUNT(tId)\n" +
                 "FROM apphastreat\n" +
                 "WHERE tId = 1002\n" +
                 "GROUP BY tId";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    manicure = rs.getInt(1);                
                }                       
                
                lbl_manicure.setText(Integer.toString(manicure));
                
                
                
        //=================================================================//    
         
            st = "SELECT COUNT(tId)\n" +
                 "FROM apphastreat\n" +
                 "WHERE tId = 1001\n" +
                 "GROUP BY tId";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    clean = rs.getInt(1);                
                }                       
                
                lbl_clean.setText(Integer.toString(clean));
                
                
                
                
        //=================================================================//    
         
            st = "SELECT COUNT(tId)\n" +
                 "FROM apphastreat\n" +
                 "";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    total = rs.getInt(1);                
                }                       
                
                lbl_total.setText(Integer.toString(total));
                
                
                
        //=================================================================//    
         
            st = "SELECT COUNT(app_id)\n" +
                 "FROM appointment";
        
                pst  = dbc.con.prepareStatement(st);                
                rs = pst.executeQuery();
       
                while(rs.next())
                {                      
                    totCus = rs.getInt(1);                
                }                       
                
                lbl_totCus.setText(Integer.toString(totCus));
                
                
                
                
                
                
                
        }
        catch(SQLException e2)
        {
             JOptionPane.showMessageDialog(null,e2);
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_formWindowOpened

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ReportView11 x =new ReportView11("C:\\Users\\ASUSI7\\Desktop\\ireports\\sohan.jasper");
        x.setVisible(true);
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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount3;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_cancelled;
    private javax.swing.JLabel lbl_clean;
    private javax.swing.JLabel lbl_completed;
    private javax.swing.JLabel lbl_haircol;
    private javax.swing.JLabel lbl_inqueue;
    private javax.swing.JLabel lbl_manicure;
    private javax.swing.JLabel lbl_revenue;
    private javax.swing.JLabel lbl_totCus;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_yesterday;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel msg_datetime;
    private javax.swing.JLabel msg_description;
    private javax.swing.JLabel msg_title;
    private javax.swing.JLabel msg_venue;
    private javax.swing.JPanel top_panel;
    private javax.swing.JButton viewapp;
    // End of variables declaration//GEN-END:variables
}
