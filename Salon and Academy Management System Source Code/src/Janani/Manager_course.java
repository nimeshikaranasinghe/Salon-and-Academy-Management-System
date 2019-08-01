/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Janani;

import Sohan.HomePage;
import Sohan.Login;
import Soi.gui2;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author it15-102560
 */
public class Manager_course extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ppst = null;
    ResultSet rs = null;

    MethodImplementation mi = new MethodImplementation();

    public Manager_course() {
        initComponents();
        con = DBConnect.connect();
    }

    String name = "";
    String duration = "";
    String fee = "";
    String limit = "";

    public boolean duplicateCourse() {

        name = cname.getText();
        duration = cduration.getText();
        fee = cfee.getText();
        limit = cother.getText();

        String sql1 = "select title from course_details where title = '" + name + "'";
        String sql2 = "select duration from course_details where title = '" + name + "'";
        String sql3 = "select courseFee from course_details where title = '" + name + "'";
        String sql4 = "select StudentLimit from course_details where title = '" + name + "'";

        if ((name.equals(mi.ColumnFromDB(sql1))) && (duration.equals(mi.ColumnFromDB(sql2))) && (fee.equals(mi.ColumnFromDB(sql3))) && (limit.equals(mi.ColumnFromDB(sql4)))) {
            return true;
        } else {
            return false;
        }
    }

    public void Clear() {
        cname.setText(null);
        cduration.setText(null);
        cfee.setText(null);
        cother.setText(null);
        idBox.setText(null);
    }

    JLabel lab1 = new JLabel("User Name");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        side_bar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        idBox = new javax.swing.JLabel();
        cother = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cduration = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cfee = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        notf2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        view = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        search = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        top_panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
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

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Course Details");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Course Content");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(67, 70, 75));
        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hall Maintenance", "Lecture Hall", "Practical Hall" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(67, 70, 75));
        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Book a Hall", "Lecture Hall", "Practical Hall" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

        jPanel5.setBackground(new java.awt.Color(59, 62, 67));
        jPanel5.setLayout(null);

        jButton9.setBackground(new java.awt.Color(12, 173, 183));
        jButton9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("HOME");
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9);
        jButton9.setBounds(50, 30, 127, 33);

        main_panel.add(jPanel5);
        jPanel5.setBounds(860, 50, 220, 100);

        side_bar.setBackground(new java.awt.Color(12, 173, 183));

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        main_panel.add(side_bar);
        side_bar.setBounds(860, 150, 220, 510);

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

        idBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        idBox.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(idBox);
        idBox.setBounds(160, 280, 110, 30);

        cother.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cotherActionPerformed(evt);
            }
        });
        jPanel2.add(cother);
        cother.setBounds(160, 240, 130, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Duration");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 150, 120, 30);

        cname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(cname);
        cname.setBounds(160, 120, 130, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Course Name");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 110, 120, 30);

        cduration.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cduration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdurationActionPerformed(evt);
            }
        });
        jPanel2.add(cduration);
        cduration.setBounds(160, 160, 130, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Course Fee");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(40, 190, 120, 30);

        cfee.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfeeActionPerformed(evt);
            }
        });
        jPanel2.add(cfee);
        cfee.setBounds(160, 200, 130, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Limit");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 230, 110, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course ID ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 280, 100, 30);

        notf2.setBackground(new java.awt.Color(51, 0, 0));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Name", "Duration ", "Course Fee", "Student Limit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        view.setBackground(new java.awt.Color(0, 153, 153));
        view.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        view.setForeground(new java.awt.Color(255, 255, 255));
        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(0, 153, 153));
        add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 153, 153));
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(0, 153, 153));
        search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 153, 153));
        delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notf2Layout = new javax.swing.GroupLayout(notf2);
        notf2.setLayout(notf2Layout);
        notf2Layout.setHorizontalGroup(
            notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notf2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(notf2Layout.createSequentialGroup()
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        notf2Layout.setVerticalGroup(
            notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notf2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(notf2);
        notf2.setBounds(30, 100, 770, 320);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Janani/Images/man.jpg"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 510);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 510);

        top_panel.setBackground(new java.awt.Color(52, 53, 57));
        top_panel.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Welcome");
        top_panel.add(jLabel6);
        jLabel6.setBounds(90, 10, 71, 25);

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

        update.setEnabled(false);
        delete.setEnabled(false);
//        notf2.setBackground(new Color(51,0,0,85));
//        view.setBackground(new Color(51,0,0,150));
//        add.setBackground(new Color(51,0,0,150));
//        update.setBackground(new Color(51,0,0,150));
//        delete.setBackground(new Color(51,0,0,150));
//        search.setBackground(new Color(51,0,0,150));
       
    }//GEN-LAST:event_formWindowOpened

    private void cotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cotherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cotherActionPerformed

    private void cdurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cdurationActionPerformed

    private void cfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cfeeActionPerformed



    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Course_Details cd = new Course_Details();
        cd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Student_course sc = new Student_course();
        sc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked


    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String state = jComboBox1.getSelectedItem().toString();

        if (state.equals("Lecture Hall")) {
            LHall_maintenance h = new LHall_maintenance();
            h.setVisible(true);
            this.dispose();
        } else if (state.equals("Practical Hall")) {
            PHall_maintenance p = new PHall_maintenance();
            p.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String state = jComboBox2.getSelectedItem().toString();

        if (state.equals("Practical Hall")) {
            Practical_Halls p = new Practical_Halls();
            p.setVisible(true);
            this.dispose();
        } else if (state.equals("Lecture Hall")) {
            Lecture_Hall h = new Lecture_Hall();
            h.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
       
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
       
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        
    }//GEN-LAST:event_jLabel13MouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        String sql = "select title from course_details where title = '" + cname.getText() + "' ";
        int x = 1;
        if (mi.checkExistence(cname.getText(), sql) == true) {
            x = JOptionPane.showConfirmDialog(null, "Do you really want to delete?");
            if (x == 0) {

                String sql1 = "delete from course_details where courseId = '" + idBox.getText() + "' ";
                if (mi.ColumnToDB(sql1) == true) {
                    JOptionPane.showMessageDialog(null, "Successfully deleted!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Cannot delete! There still may be registered students!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no such course!");
        }

        Clear();
    }//GEN-LAST:event_deleteActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String courseName = cname.getText();
        if (!courseName.equals("")) {

            String sql2 = "select title as Title, duration as Duration, courseFee as 'Course Fee', StudentLimit as 'Student Limit' from course_details where title LIKE '%" + courseName + "%'";
            String sql = "select title from course_details where title = '" + cname.getText() + "'";
            if (mi.checkExistence(cname.getText(), sql) == true) {
                rs = mi.tableLoad(sql2);
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Course!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please provide the Course Name");
        }
        Clear();
    }//GEN-LAST:event_searchActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        if (mi.Validation(cname.getText(), cduration.getText(), cfee.getText(), cother.getText()) == true) {
            int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");
            boolean state = false;
            if (x == 0) {
                if (duplicateCourse() == false) {
                    state = true;
                } else {
                    JOptionPane.showMessageDialog(null, "This course already exists! please re-enter!");
                    state = false;
                }
                String sql1 = "update course_details set title = '" + cname.getText() + "',duration = '" + cduration.getText() + "',courseFee = '" + cfee.getText() + "', StudentLimit = '" + cother.getText() + "' where courseId = '" + idBox.getText() + "' ";
                if ((state == true) && (mi.ColumnToDB(sql1) == true)) {
                    JOptionPane.showMessageDialog(null, "Successfully updated!");
                    
        int count = 0;
        String sql3 = "select count(enrollmentId) from studentdetails where courseID = '"+idBox.getText()+"'";
        int count1 = Integer.parseInt(mi.ColumnFromDB(sql3));
        int remain = (Integer.parseInt(cother.getText()) - count1);
        String sql4 = "update studentlimit set CID = '"+idBox.getText()+"', Cname = '"+cname.getText()+"', noOfStudents = '"+count1+"', allowedLimit = '"+cother.getText()+"', remaining = '"+remain+"' where CID = '"+idBox.getText()+"'";
        if(mi.ColumnToDB(sql4)==true){
            JOptionPane.showMessageDialog(null, "student limit updated");
        }
        else{
            JOptionPane.showMessageDialog(null, "cannot update student limit");
        }
                }
            }
        }

        Clear();
    }//GEN-LAST:event_updateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        boolean state = false;
        if (mi.Validation(cname.getText(), cduration.getText(), cfee.getText(), cother.getText()) == true) {
            if (duplicateCourse() == false) {
                state = true;
            } else {
                JOptionPane.showMessageDialog(null, "This course already exists! please re-enter!");
                state = false;
            }
        }

        String sql1 = "insert into course_details (title,duration,courseFee,StudentLimit) values ('" + cname.getText() + "','" + cduration.getText() + "','" + cfee.getText() + "','" + cother.getText() + "')";
        if ((state == true) && (mi.ColumnToDB(sql1) == true)) {
            JOptionPane.showMessageDialog(null, "Data insertion is successful");
        
        int count = 0;
        String sql3 = "select courseId from course_details where title = '"+cname.getText()+"'";
        String cid = mi.ColumnFromDB(sql3);
        String sql4 = "insert into studentlimit (CID, Cname, noOfStudents, allowedLimit, remaining) values ('"+cid+"','"+cname.getText()+"','"+count+"','"+cother.getText()+"','"+cother.getText()+"')";
        if(mi.ColumnToDB(sql4)==true){
            JOptionPane.showMessageDialog(null, "student limit updated");
        }
        else{
            JOptionPane.showMessageDialog(null, "cannot update student limit");
        }
        
        String query = "INSERT INTO SalaryPerCourse VALUES ("+Integer.parseInt(cid)+", 5000.00);";
        mi.ColumnToDB(query);
        }
        Clear();
    }//GEN-LAST:event_addActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        String sql = "select title as Title, duration as Duration, courseFee as 'Course Fee', StudentLimit as 'Student Limit' from course_details";
        rs = mi.tableLoad(sql);
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_viewActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int r = jTable1.getSelectedRow();

        String name = jTable1.getValueAt(r, 0).toString();
        String duration = jTable1.getValueAt(r, 1).toString();
        String fee = jTable1.getValueAt(r, 2).toString();
        String slimit = jTable1.getValueAt(r, 3).toString();
        String id = null;

        try {
            String sql = "select courseId from course_details where title = '" + name + "' and duration = '" + duration + "' and courseFee = '" + fee + "' and StudentLimit = '" + slimit + "'";
            ppst = con.prepareStatement(sql);
            rs = ppst.executeQuery();
            String s = DbUtils.resultSetToNestedList(rs).toString();
            int len = s.length();
            int end = len - 2;
            id = s.substring(2, end);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "cannot get id from db");
        }

        cname.setText(name);
        cduration.setText(duration);
        cfee.setText(fee);
        cother.setText(slimit);
        idBox.setText(id);

        update.setEnabled(true);
        delete.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(gui2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Manager_course().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton btn_back;
    private javax.swing.JTextField cduration;
    private javax.swing.JTextField cfee;
    private javax.swing.JTextField cname;
    private javax.swing.JTextField cother;
    private javax.swing.JButton delete;
    private javax.swing.JLabel idBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel notf2;
    private javax.swing.JButton search;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    private javax.swing.JButton update;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
