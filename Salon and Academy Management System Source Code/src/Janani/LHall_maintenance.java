/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Janani;

import Sohan.HomePage;
import Sohan.Login;
import Soi.gui2;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author it15-102560
 */
public class LHall_maintenance extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ppst = null;

    MethodImplementation mi = new MethodImplementation();

    public LHall_maintenance() {
        initComponents();
        con = DBConnect.connect();
    }

    String name = "";
    String capa = "";
    String no = "";
    boolean statusOfAddHall = false;

    public boolean duplicateCourse() {
        boolean state = false;

        name = hallName.getText();
        capa = capacity.getText();

        String sql1 = "select hall_name from lhall_maintenance where hall_name = '" + name + "'";
        String sql2 = "select capacity from lhall_maintenance where hall_name = '" + name + "'";

        if ((name.equals(mi.ColumnFromDB(sql1))) && (capa.equals(mi.ColumnFromDB(sql2)))) {
            return true;
        } else {
            return false;
        }
    }

    public void Clear() {
        hallName.setText(null);
        capacity.setText(null);
        idBox.setText(null);
    }

    JLabel lab1 = new JLabel("User Name");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        side_bar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        h3 = new javax.swing.JLabel();
        hallName = new javax.swing.JTextField();
        h4 = new javax.swing.JLabel();
        capacity = new javax.swing.JTextField();
        h1 = new javax.swing.JLabel();
        idBox = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        notf2 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Course Details");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Course Content");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Manage Courses");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(25, 25, 25))
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

        h3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        h3.setForeground(new java.awt.Color(255, 255, 255));
        h3.setText("Hall Name");
        jPanel2.add(h3);
        h3.setBounds(70, 120, 120, 30);

        hallName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        hallName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallNameActionPerformed(evt);
            }
        });
        jPanel2.add(hallName);
        hallName.setBounds(210, 120, 100, 30);

        h4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        h4.setForeground(new java.awt.Color(255, 255, 255));
        h4.setText("Capacity");
        jPanel2.add(h4);
        h4.setBounds(70, 190, 80, 30);

        capacity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(capacity);
        capacity.setBounds(210, 190, 100, 30);

        h1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        h1.setForeground(new java.awt.Color(255, 255, 255));
        h1.setText("Hall Id");
        jPanel2.add(h1);
        h1.setBounds(70, 260, 80, 30);

        idBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        idBox.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(idBox);
        idBox.setBounds(210, 260, 100, 30);

        view.setBackground(new java.awt.Color(0, 153, 153));
        view.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        view.setForeground(new java.awt.Color(255, 255, 255));
        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        jPanel2.add(view);
        view.setBounds(70, 320, 100, 40);

        add.setBackground(new java.awt.Color(0, 153, 153));
        add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add);
        add.setBounds(210, 320, 100, 40);

        remove.setBackground(new java.awt.Color(0, 153, 153));
        remove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Delete");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel2.add(remove);
        remove.setBounds(510, 320, 107, 40);

        search.setBackground(new java.awt.Color(0, 153, 153));
        search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel2.add(search);
        search.setBounds(670, 320, 108, 40);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Hall Name", "Capacity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(340, 110, 430, 180);

        notf2.setBackground(new java.awt.Color(51, 0, 0));

        update.setBackground(new java.awt.Color(0, 153, 153));
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notf2Layout = new javax.swing.GroupLayout(notf2);
        notf2.setLayout(notf2Layout);
        notf2Layout.setHorizontalGroup(
            notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notf2Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        notf2Layout.setVerticalGroup(
            notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notf2Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(notf2);
        notf2.setBounds(60, 90, 730, 280);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Janani/Images/lhall.jpg"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 510);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 510);

        top_panel.setBackground(new java.awt.Color(52, 53, 57));
        top_panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lecture Hall Maintenance");
        top_panel.add(jLabel2);
        jLabel2.setBounds(90, 10, 340, 30);

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

        //notf1.setVisible(false);
        remove.setEnabled(false);
        update.setEnabled(false);
//        notf2.setBackground(new Color(51,0,0,100));
//         view.setBackground(new Color(51,0,0,150));
//          add.setBackground(new Color(51,0,0,150));
//           update.setBackground(new Color(51,0,0,150));
//            remove.setBackground(new Color(51,0,0,150));
//           search.setBackground(new Color(51,0,0,150));
    }//GEN-LAST:event_formWindowOpened

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Manager_course ul = new Manager_course();
        ul.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        Course_Details cd = new Course_Details();
        cd.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked

        Student_course sc = new Student_course();
        sc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

        String courseName = hallName.getText();
        if (!courseName.equals("")) {

            String sql2 = "select hall_name as 'Hall Name', capacity as 'Capacity' from lhall_maintenance where hall_name LIKE '%" + hallName.getText() + "%'";
            String sql = "select hall_name from lhall_maintenance where hall_name = '" + hallName.getText() + "' ";
            if (mi.checkExistence(hallName.getText(), sql) == true) {
                rs = mi.tableLoad(sql2);
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Hall Name!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please provide the Hall Name");
        }
        Clear();
    }//GEN-LAST:event_searchActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        boolean state = false;
        if (mi.ValidateHall_maintenance(hallName.getText(), capacity.getText()) == true) {

            if (duplicateCourse() == false) {
                String sql = "select hall_name from lhall_maintenance where hall_name = '" + hallName.getText() + "'";
                if (mi.checkExistence(hallName.getText(), sql) == false) {
                    state=true;
                } else {
                    state = false;
                    JOptionPane.showMessageDialog(null, "Duplicate hall name! please re-enter");
                }
            } else {
                JOptionPane.showMessageDialog(null, "This hall already exists! please re-enter!");
                state = false;
            }
        }
        String sql1 = "insert into lhall_maintenance (hall_name, capacity) values ('" + hallName.getText() + "', '" + capacity.getText() + "')";
        if ((state == true) && (mi.ColumnToDB(sql1) == true)) {
            JOptionPane.showMessageDialog(null, "Data insertion is successful");
            statusOfAddHall = true;
            String sql2 = "select hallId from lhall_maintenance where hall_name = '"+hallName.getText()+"' and capacity = '"+capacity.getText()+"'";
            Clear();
        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        if (mi.ValidateHall_maintenance(hallName.getText(), capacity.getText()) == true) {
            int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");
            boolean state = false;
            if (x == 0) {
                    String sql = "select hall_name from lhall_maintenance where hall_name = '" + hallName.getText() + "'";
                    if (mi.checkExistence(hallName.getText(), sql) == true) {
                        state=true;
                    } else {
                        state = false;
                        JOptionPane.showMessageDialog(null, "Invalid Hall name! please re-enter");
                    }
                String sql1 = "update lhall_maintenance set hall_name = '" + hallName.getText() + "' , capacity = '" + capacity.getText() + "' where hallId = '" + idBox.getText() + "'";
                if ((state == true) && (mi.ColumnToDB(sql1) == true)) {
                    JOptionPane.showMessageDialog(null, "Successfully updated!");
                }
            }
        }
        Clear();
    }//GEN-LAST:event_updateActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        String sql = "select hall_name as 'Hall Name', capacity as Capacity from lhall_maintenance";
        rs = mi.tableLoad(sql);
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_viewActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed

        String sql = "select hall_name from lhall_maintenance where hall_name = '" + hallName.getText() + "' and capacity = '" + capacity.getText() + "'";
        int x = 1;
        if (mi.checkExistence(hallName.getText(), sql) == true) {
            x = JOptionPane.showConfirmDialog(null, "Do you really want to delete?");
            if (x == 0) {
                String sql1 = "delete from lhall_maintenance where hallId = '" + idBox.getText() + "'";
                if ((mi.ColumnToDB(sql1)) == true) {
                    JOptionPane.showMessageDialog(null, "Successfully deleted!");
                } else {
                    JOptionPane.showMessageDialog(null, "cant delete");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid hall!");
        }

        Clear();
    }//GEN-LAST:event_removeActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int r = jTable1.getSelectedRow();

        String name = jTable1.getValueAt(r, 0).toString();
        String capa = jTable1.getValueAt(r, 1).toString();

        hallName.setText(name);
        capacity.setText(capa);
        String sql = "select hallId from lhall_maintenance where hall_name='" + name + "' and capacity = '" + capa + "'";
        idBox.setText(mi.ColumnFromDB(sql));

        remove.setEnabled(true);
        update.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void hallNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hallNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hallNameActionPerformed

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
            public void run() {
                new LHall_maintenance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton btn_back;
    private javax.swing.JTextField capacity;
    private javax.swing.JLabel h1;
    private javax.swing.JLabel h3;
    private javax.swing.JLabel h4;
    private javax.swing.JTextField hallName;
    private javax.swing.JLabel idBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel notf2;
    private javax.swing.JButton remove;
    private javax.swing.JButton search;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    private javax.swing.JButton update;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
