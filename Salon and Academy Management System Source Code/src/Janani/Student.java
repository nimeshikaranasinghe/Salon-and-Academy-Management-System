/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Janani;

import Sohan.HomePage;
import Sohan.Login;
import Soi.gui2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author it15-102560
 */
public class Student extends javax.swing.JFrame {

    /**
     * Creates new form gui
     */
    public Student() {
        initComponents();
    }
    String courseID = null;
    boolean state = false;

    MethodImplementation mi = new MethodImplementation();
    Manager_course m = new Manager_course();

    JLabel lab1 = new JLabel("User Name");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        side_bar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        dlt = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cid = new javax.swing.JTextField();
        cname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        top_panel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
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
        jLabel10.setText("Course Content");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Course Details");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
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
                .addGap(19, 19, 19)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

        jPanel5.setBackground(new java.awt.Color(59, 62, 67));
        jPanel5.setLayout(null);
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

        jButton10.setBackground(new java.awt.Color(24, 185, 175));
        jButton10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 102, 102));
        jButton10.setText("View");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(330, 330, 140, 40);
        jPanel2.add(id);
        id.setBounds(230, 80, 90, 30);

        jLabel2.setText("Student Name");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(90, 140, 90, 20);
        jPanel2.add(nameBox);
        nameBox.setBounds(230, 130, 90, 30);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "StudentID", "Name"
            }
        ));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(370, 60, 410, 210);

        dlt.setBackground(new java.awt.Color(24, 185, 175));
        dlt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        dlt.setForeground(new java.awt.Color(0, 102, 102));
        dlt.setText("Delete");
        dlt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltActionPerformed(evt);
            }
        });
        jPanel2.add(dlt);
        dlt.setBounds(570, 330, 140, 40);

        jButton12.setBackground(new java.awt.Color(24, 185, 175));
        jButton12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 102, 102));
        jButton12.setText("Add");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(100, 330, 140, 40);

        jLabel3.setText("Student Id");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(90, 80, 90, 30);

        jLabel4.setText("cname");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(90, 250, 90, 20);
        jPanel2.add(cid);
        cid.setBounds(230, 180, 90, 30);
        jPanel2.add(cname);
        cname.setBounds(230, 240, 90, 30);

        jLabel5.setText("cid");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(90, 190, 90, 20);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 510);

        top_panel.setBackground(new java.awt.Color(52, 53, 57));
        top_panel.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student");
        top_panel.add(jLabel8);
        jLabel8.setBounds(90, 10, 180, 25);

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

        dlt.setEnabled(false);

    }//GEN-LAST:event_formWindowOpened

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String sql = "select * from student";
        ResultSet rs = mi.tableLoad(sql);
        tab.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Student c = new Student();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Manager_course a = new Manager_course();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        Course_Details c = new Course_Details();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

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

    private void dltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltActionPerformed
        String sql = "delete from student where sid = '" + id.getText() + "'";
        if (mi.ColumnToDB(sql) == true) {
            JOptionPane.showMessageDialog(null, "deleted");
        }
    }//GEN-LAST:event_dltActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
 
        String numOfStudents = null;
        String allowedStudents = null;
        int count, allowedLim, remaining = 0;
       
        //String sql1 = "select courseId from course_details ";
        //courseID = mi.ColumnFromDB(sql1);
       
String sql1 = "select remaining from studentlimit where cid = '"+cid.getText()+"'";
        int originalRemain = Integer.parseInt(mi.ColumnFromDB(sql1));
        

        if (originalRemain <= 5) {
JOptionPane.showMessageDialog(null, "Warning! remaining seats for this course is " + originalRemain );
        if(originalRemain==0){
        JOptionPane.showMessageDialog(null,"Student limit for this course is full! cannot insert data!");
        }
        else{
        String sql = "insert into student (name,cid,cname) values ('" + nameBox.getText() + "','" + cid.getText() + "','" + cname.getText() + "')";
        if (mi.ColumnToDB(sql) == true) {
            //update only when a new student is added
             String sql2 = "select count(sid) from student where cid = '" + cid.getText() + "'";
        String sql3 = "select allowedLimit from studentlimit where CID = '" + cid.getText() + "'";
            numOfStudents = mi.ColumnFromDB(sql2);
        allowedStudents = mi.ColumnFromDB(sql3);
        count = Integer.parseInt(numOfStudents);
        allowedLim = Integer.parseInt(allowedStudents);
        remaining = allowedLim - count;
            String sql4 = "update studentlimit set noOfStudents = '" + count + "', remaining = '" + remaining + "' where CID = '" + cid.getText() + "'";
            if (mi.ColumnToDB(sql4) == true) {
                JOptionPane.showMessageDialog(null, " Student Limit updated!");
            } else {
                JOptionPane.showMessageDialog(null, "cannot update student limit");
            }
        }
        }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        int r = tab.getSelectedRow();

        String idm = tab.getValueAt(r, 0).toString();
        String name = tab.getValueAt(r, 1).toString();

        id.setText(idm);
        nameBox.setText(name);

        dlt.setEnabled(true);
    }//GEN-LAST:event_tabMouseClicked

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
            java.util.logging.Logger.getLogger(gui2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JTextField cid;
    private javax.swing.JTextField cname;
    private javax.swing.JButton dlt;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField nameBox;
    private javax.swing.JPanel side_bar;
    private javax.swing.JTable tab;
    private javax.swing.JPanel top_panel;
    // End of variables declaration//GEN-END:variables
}
