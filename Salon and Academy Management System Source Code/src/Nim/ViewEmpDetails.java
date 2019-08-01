/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nim;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ViewEmpDetails extends javax.swing.JFrame {
    
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
   
    int id;
    String fname;
    String lname;
    String address;
    String phone;
    String email;
    String gender;
    String birthday;
    
    boolean own;
    boolean man;
    boolean rep;
    boolean acc;
    boolean lec;
    boolean beau;    
    
    String areas[] = new String[20];
      
    
    public ViewEmpDetails() {
        initComponents();
        
        //======== make post labels invisible==============//
        lbl_post1.setVisible(false);
        lbl_post2.setVisible(false);
        lbl_postAND.setVisible(false);
                
        //===== make areas stuff invisible at the beginning=============// 
        pnl_areas.setVisible(false);
        lbl_areaH.setVisible(false);
        
        lbl_area1.setVisible(false);
        lbl_area2.setVisible(false);
        lbl_area3.setVisible(false);
        lbl_area4.setVisible(false);
        lbl_area5.setVisible(false);
        lbl_area6.setVisible(false);
        lbl_area7.setVisible(false);
        lbl_area8.setVisible(false);
        lbl_area9.setVisible(false);
        lbl_area10.setVisible(false);
        lbl_area11.setVisible(false);
        lbl_area12.setVisible(false);
        lbl_area13.setVisible(false);
        lbl_area14.setVisible(false);
        lbl_area15.setVisible(false);              
        
    }
    
    public void setID(int pid){
        
        this.id = pid;        
           
    }
    
    
    //============= Set details to main feilds==============================//
    public void setDetails(int id, String fname, String lname, String address, String phone, String email, String gender, String birthday, boolean own, boolean man, boolean rep, boolean lec, boolean beau, boolean acc)
    {   
                                                              
    //------------------ Set Details to main label feilds---------------------------//  
        lbl_empName.setText(fname + " " + lname);
        lbl_id.setText(String.valueOf(id));
        lbl_fname.setText(fname);
        lbl_lname.setText(lname);
        /*lbl_add.setText(address);*/       
        lbl_add.append(address);
        lbl_add.setEditable(false);
        lbl_phone.setText(phone);
        lbl_email.setText(email);
        lbl_gen.setText(gender);
        lbl_birth.setText(birthday);                        
        
    //-------------get posts values-------------------//
        boolean postBoo[] = new boolean[6];
        postBoo[0] = own;
        postBoo[1] = man;
        postBoo[2] = rep;
        postBoo[3] = lec;
        postBoo[4] = beau;
        postBoo[5] = acc;                                   
        
        String postStr[] = {"Owner", "Manager", "Receptionist", "Lecturer", "Beautician", "Accountant"};
        
        String post1 = "";
        String post2 = "";                                  
        //---------------display post values--------------------------------//
        for (int i=0; i<postBoo.length; i++) {
            if(postBoo[i]==true){
                if(post1.equalsIgnoreCase("")){
                    post1 = postStr[i];
                    lbl_post1.setVisible(true);
                    lbl_post1.setText(post1);
                }
                else{
                    post2 = postStr[i];
                    lbl_postAND.setVisible(true);
                    lbl_post2.setVisible(true);
                    lbl_post2.setText(post2);               
                }
            }
        }
    }

    
    //===================set specail areas==================================//
    public void setSpecailAreas(String sAreas[]) 
    {
        lbl_areaH.setVisible(true);
        pnl_areas.setVisible(true);
        areas = sAreas;
        String area = "";                                                       
        
        for (int i=0; i<areas.length; i++) {
            if(areas[i] != null){         //check whether it is not empty and display them on lables  
                area = areas[i];                        //get special area from the areas array to a variable
                if (!lbl_area1.isVisible()) {       
                        lbl_area1.setVisible(true);
                        lbl_area1.setText(area);
                    }
                else if (!lbl_area2.isVisible()) {       
                        lbl_area2.setVisible(true);
                        lbl_area2.setText(area);
                    }
                else if (!lbl_area3.isVisible()) {       
                        lbl_area3.setVisible(true);
                        lbl_area3.setText(area);
                    }
                else if (!lbl_area4.isVisible()) {       
                        lbl_area4.setVisible(true);
                        lbl_area4.setText(area);
                    }
                else if (!lbl_area5.isVisible()) {       
                        lbl_area5.setVisible(true);
                        lbl_area5.setText(area);
                    }
                else if (!lbl_area6.isVisible()) {       
                        lbl_area6.setVisible(true);
                        lbl_area6.setText(area);
                    }
                else if (!lbl_area7.isVisible()) {       
                        lbl_area7.setVisible(true);
                        lbl_area7.setText(area);
                    }
                else if (!lbl_area8.isVisible()) {       
                        lbl_area8.setVisible(true);
                        lbl_area8.setText(area);
                    }
                else if (!lbl_area9.isVisible()) {       
                        lbl_area9.setVisible(true);
                        lbl_area9.setText(area);
                    }
                else if (!lbl_area10.isVisible()) {       
                        lbl_area10.setVisible(true);
                        lbl_area10.setText(area);
                    }
                else if (!lbl_area11.isVisible()) {       
                        lbl_area11.setVisible(true);
                        lbl_area11.setText(area);
                    }
                else if (!lbl_area12.isVisible()) {       
                        lbl_area12.setVisible(true);
                        lbl_area12.setText(area);
                    }
                else if (!lbl_area13.isVisible()) {       
                        lbl_area13.setVisible(true);
                        lbl_area13.setText(area);
                    }
                else if (!lbl_area14.isVisible()) {       
                        lbl_area14.setVisible(true);
                        lbl_area14.setText(area);
                    }
                else if (!lbl_area15.isVisible()) {       
                        lbl_area15.setVisible(true);
                        lbl_area15.setText(area);
                    }                                                           
            }
            else 
                break;            
        }                                                                                
    }
        
    
    //JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_areaH = new javax.swing.JLabel();
        lbl_empName = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_fname = new javax.swing.JLabel();
        lbl_lname = new javax.swing.JLabel();
        lbl_phone = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_gen = new javax.swing.JLabel();
        lbl_birth = new javax.swing.JLabel();
        lbl_postAND = new javax.swing.JLabel();
        lbl_post1 = new javax.swing.JLabel();
        lbl_post2 = new javax.swing.JLabel();
        pnl_areas = new javax.swing.JPanel();
        lbl_area1 = new javax.swing.JLabel();
        lbl_area2 = new javax.swing.JLabel();
        lbl_area3 = new javax.swing.JLabel();
        lbl_area5 = new javax.swing.JLabel();
        lbl_area4 = new javax.swing.JLabel();
        lbl_area6 = new javax.swing.JLabel();
        lbl_area7 = new javax.swing.JLabel();
        lbl_area8 = new javax.swing.JLabel();
        lbl_area9 = new javax.swing.JLabel();
        lbl_area10 = new javax.swing.JLabel();
        lbl_area11 = new javax.swing.JLabel();
        lbl_area12 = new javax.swing.JLabel();
        lbl_area15 = new javax.swing.JLabel();
        lbl_area14 = new javax.swing.JLabel();
        lbl_area13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_add = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        side_bar.setBackground(new java.awt.Color(12, 173, 183));
        side_bar.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(227, 212, 221));
        jLabel27.setText("First Name   :");
        side_bar.add(jLabel27);
        jLabel27.setBounds(26, 90, 110, 22);

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("OK");
        jButton2.setBorder(null);
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
        side_bar.add(jButton2);
        jButton2.setBounds(180, 580, 70, 30);

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(227, 212, 221));
        jLabel14.setText("Last name    : ");
        side_bar.add(jLabel14);
        jLabel14.setBounds(26, 130, 110, 22);

        jLabel20.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(227, 212, 221));
        jLabel20.setText("Address        :   ");
        side_bar.add(jLabel20);
        jLabel20.setBounds(26, 172, 110, 22);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(227, 212, 221));
        jLabel21.setText("Phone           :");
        side_bar.add(jLabel21);
        jLabel21.setBounds(26, 214, 110, 22);

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(227, 212, 221));
        jLabel15.setText("Email             :    ");
        side_bar.add(jLabel15);
        jLabel15.setBounds(26, 256, 110, 22);

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(227, 212, 221));
        jLabel17.setText("Gender          :  ");
        side_bar.add(jLabel17);
        jLabel17.setBounds(26, 298, 110, 22);

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(227, 212, 221));
        jLabel18.setText("Date of Birth :   ");
        side_bar.add(jLabel18);
        jLabel18.setBounds(26, 340, 122, 22);

        jLabel25.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(227, 212, 221));
        jLabel25.setText("Post               :   ");
        side_bar.add(jLabel25);
        jLabel25.setBounds(26, 382, 110, 22);

        lbl_areaH.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_areaH.setForeground(new java.awt.Color(227, 212, 221));
        lbl_areaH.setText("Specialized Areas :");
        side_bar.add(lbl_areaH);
        lbl_areaH.setBounds(26, 422, 143, 22);

        lbl_empName.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        lbl_empName.setText("Name");
        side_bar.add(lbl_empName);
        lbl_empName.setBounds(150, 12, 250, 32);

        jLabel19.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Employee,");
        side_bar.add(jLabel19);
        jLabel19.setBounds(55, 12, 90, 32);

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(227, 212, 221));
        jLabel22.setText("Employee ID :   ");
        side_bar.add(jLabel22);
        jLabel22.setBounds(26, 50, 110, 22);

        lbl_id.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id.setText("id");
        lbl_id.setFocusCycleRoot(true);
        side_bar.add(lbl_id);
        lbl_id.setBounds(143, 50, 250, 22);

        lbl_fname.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_fname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fname.setText("name");
        side_bar.add(lbl_fname);
        lbl_fname.setBounds(143, 90, 250, 22);

        lbl_lname.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_lname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_lname.setText("name");
        side_bar.add(lbl_lname);
        lbl_lname.setBounds(143, 130, 250, 22);

        lbl_phone.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_phone.setForeground(new java.awt.Color(255, 255, 255));
        lbl_phone.setText("Phone");
        side_bar.add(lbl_phone);
        lbl_phone.setBounds(143, 214, 250, 22);

        lbl_email.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("email");
        side_bar.add(lbl_email);
        lbl_email.setBounds(143, 256, 250, 22);

        lbl_gen.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_gen.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gen.setText("gender");
        side_bar.add(lbl_gen);
        lbl_gen.setBounds(143, 296, 250, 22);

        lbl_birth.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_birth.setForeground(new java.awt.Color(255, 255, 255));
        lbl_birth.setText("birth");
        side_bar.add(lbl_birth);
        lbl_birth.setBounds(143, 340, 250, 22);

        lbl_postAND.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        lbl_postAND.setForeground(new java.awt.Color(255, 255, 255));
        lbl_postAND.setText("&");
        side_bar.add(lbl_postAND);
        lbl_postAND.setBounds(235, 382, 20, 22);

        lbl_post1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_post1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_post1.setText("Post 1 ");
        side_bar.add(lbl_post1);
        lbl_post1.setBounds(143, 382, 110, 22);

        lbl_post2.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_post2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_post2.setText("Post 2");
        side_bar.add(lbl_post2);
        lbl_post2.setBounds(270, 382, 110, 22);

        pnl_areas.setBackground(new java.awt.Color(126, 176, 180));
        pnl_areas.setLayout(null);

        lbl_area1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area1.setText("hair");
        pnl_areas.add(lbl_area1);
        lbl_area1.setBounds(5, 3, 120, 22);

        lbl_area2.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area2.setText("hair");
        pnl_areas.add(lbl_area2);
        lbl_area2.setBounds(130, 3, 120, 22);

        lbl_area3.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area3.setText("hair ");
        pnl_areas.add(lbl_area3);
        lbl_area3.setBounds(255, 3, 120, 22);

        lbl_area5.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area5.setText("hair");
        pnl_areas.add(lbl_area5);
        lbl_area5.setBounds(130, 27, 120, 22);

        lbl_area4.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area4.setText("hair");
        pnl_areas.add(lbl_area4);
        lbl_area4.setBounds(5, 27, 120, 22);

        lbl_area6.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area6.setText("hair ");
        pnl_areas.add(lbl_area6);
        lbl_area6.setBounds(255, 27, 120, 22);

        lbl_area7.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area7.setText("hair");
        pnl_areas.add(lbl_area7);
        lbl_area7.setBounds(5, 50, 120, 22);

        lbl_area8.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area8.setText("hair");
        pnl_areas.add(lbl_area8);
        lbl_area8.setBounds(130, 50, 120, 22);

        lbl_area9.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area9.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area9.setText("hair ");
        pnl_areas.add(lbl_area9);
        lbl_area9.setBounds(255, 50, 120, 22);

        lbl_area10.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area10.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area10.setText("hair");
        pnl_areas.add(lbl_area10);
        lbl_area10.setBounds(5, 73, 120, 22);

        lbl_area11.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area11.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area11.setText("hair");
        pnl_areas.add(lbl_area11);
        lbl_area11.setBounds(130, 73, 120, 22);

        lbl_area12.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area12.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area12.setText("hair ");
        pnl_areas.add(lbl_area12);
        lbl_area12.setBounds(255, 73, 120, 22);

        lbl_area15.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area15.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area15.setText("hair ");
        pnl_areas.add(lbl_area15);
        lbl_area15.setBounds(255, 96, 120, 22);

        lbl_area14.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area14.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area14.setText("hair");
        pnl_areas.add(lbl_area14);
        lbl_area14.setBounds(130, 96, 120, 22);

        lbl_area13.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_area13.setForeground(new java.awt.Color(255, 255, 255));
        lbl_area13.setText("hair");
        pnl_areas.add(lbl_area13);
        lbl_area13.setBounds(5, 96, 120, 22);

        side_bar.add(pnl_areas);
        pnl_areas.setBounds(20, 450, 380, 128);

        jScrollPane1.setBorder(null);

        lbl_add.setBackground(new java.awt.Color(12, 173, 183));
        lbl_add.setColumns(12);
        lbl_add.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lbl_add.setForeground(new java.awt.Color(255, 255, 255));
        lbl_add.setLineWrap(true);
        lbl_add.setRows(3);
        lbl_add.setBorder(null);
        jScrollPane1.setViewportView(lbl_add);

        side_bar.add(jScrollPane1);
        jScrollPane1.setBounds(143, 168, 250, 42);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_bar, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_bar, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(414, 618));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered

        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton2MouseEntered

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
            java.util.logging.Logger.getLogger(ViewEmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ViewEmpDetails().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lbl_add;
    private javax.swing.JLabel lbl_area1;
    private javax.swing.JLabel lbl_area10;
    private javax.swing.JLabel lbl_area11;
    private javax.swing.JLabel lbl_area12;
    private javax.swing.JLabel lbl_area13;
    private javax.swing.JLabel lbl_area14;
    private javax.swing.JLabel lbl_area15;
    private javax.swing.JLabel lbl_area2;
    private javax.swing.JLabel lbl_area3;
    private javax.swing.JLabel lbl_area4;
    private javax.swing.JLabel lbl_area5;
    private javax.swing.JLabel lbl_area6;
    private javax.swing.JLabel lbl_area7;
    private javax.swing.JLabel lbl_area8;
    private javax.swing.JLabel lbl_area9;
    private javax.swing.JLabel lbl_areaH;
    private javax.swing.JLabel lbl_birth;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_empName;
    private javax.swing.JLabel lbl_fname;
    private javax.swing.JLabel lbl_gen;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_lname;
    private javax.swing.JLabel lbl_phone;
    private javax.swing.JLabel lbl_post1;
    private javax.swing.JLabel lbl_post2;
    private javax.swing.JLabel lbl_postAND;
    private javax.swing.JPanel pnl_areas;
    private javax.swing.JPanel side_bar;
    // End of variables declaration//GEN-END:variables
}
