/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sohan;

import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JOptionPane;


 


public class Login extends javax.swing.JFrame {

  
    
    
/*------------ db connect-----------------*/    
    
    
    ResultSet rs;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
    
    
    
    public Login() {
        initComponents();
    }

     


    private String username;
    private String password;
    
    public static String curUserFname= null;      // first name of the currently logged in user

    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(226, 226, 226));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 204, 204));
        jLabel3.setText("About Us");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(500, 330, 70, 15);

        jLabel4.setBackground(new java.awt.Color(226, 226, 226));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 204, 204));
        jLabel4.setText("Forgot password?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(230, 330, 120, 15);

        txt_username.setBackground(new java.awt.Color(7, 102, 130));
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setBorder(null);
        txt_username.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_username);
        txt_username.setBounds(340, 190, 180, 23);

        txt_password.setBackground(new java.awt.Color(7, 102, 130));
        txt_password.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(null);
        txt_password.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_password);
        txt_password.setBounds(340, 230, 180, 23);

        jButton2.setBackground(new java.awt.Color(7, 102, 130));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(340, 270, 80, 30);

        btn_login.setBackground(new java.awt.Color(7, 102, 130));
        btn_login.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Login");
        btn_login.setBorder(null);
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_login);
        btn_login.setBounds(430, 270, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/LoginB.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(800, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        
     txt_username.setBackground(new java.awt.Color(7,102,130));
        
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        
        
        username = txt_username.getText();      // get login info from the user
        password = txt_password.getText();
        
        
        curUserFname = username;
        
        if(validateFields())                    // if fieds are not null
        {
            
            if(username.equalsIgnoreCase("manager") && password.equals("123"))
            {
            

                 ManagerPanel m = new ManagerPanel();
                 m.setVisible(true);
                 this.dispose();
                 
            }     
                 
                 
            else if(username.equalsIgnoreCase("accountant") && password.equals("123"))
            {
            
                 ManagerPanel m = new ManagerPanel();
                 m.setVisible(true);
                 this.dispose();
                 
            }     
                
            if(username.equalsIgnoreCase("lecturer") && password.equals("123"))
            {
            
                 ManagerPanel m = new ManagerPanel();
                 m.setVisible(true);
                 this.dispose();
                 
            }     
            if(username.equalsIgnoreCase("sohan") && password.equals("123"))
            {
            
                 HomePage r = new HomePage();
                 r.setVisible(true);
                 this.dispose();
                 
            }     
            
            else
            {
                
               //  System.out.println(password);
                txt_username.setText("");
                txt_password.setText("");
              //  JOptionPane.showMessageDialog(null,"Invalid Username or Password!");    // display error message
            }                
                 
                 
                 
                 
                 
                 
        /*         
            String st = "select * from Employee where username=? and password=?";  // look for the user in DB
            
            
            try
            {    
                pst  = dbc.con.prepareStatement(st);

                pst.setString(1, username);
                
                pst.setString(2, password);
                

                ResultSet rs = pst.executeQuery();
                
                if(rs.next())
                {
                    
                    
                    
                    
                    curUserFname = rs.getString("fname");       // retreiving user's firstname from the database
                    String post = rs.getString("post");             // retreiving user's post
                    
                    
               /* -------perform login depending on the post------- */
                                                              
                /*    if(post.equals("Manager"))                      // if post is Manager go to Manager panel
                    {
                       
                        ManagerPanel M1 = new ManagerPanel();       // New ManagerPanel object    
                        M1.setVisible(true);                       
                        this.dispose();
                       
                    }

                    else if(post.equals("Gate"))                    // if post is Gate go to Operator panel           
                    {
                        OperatorPanel G1 = new OperatorPanel();
                        G1.setVisible(true);
                        this.dispose();
                    }
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password!");    // display error message
                }  
            
               
                
                
                
               }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"Error in Login");

            }
            
                   */ 
        }
          
        
        
        
    }//GEN-LAST:event_btn_loginActionPerformed

    
    
    
     private boolean validateFields()
    {
        if(username.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please enter your Username");
            txt_username.setText("");
            txt_username.requestFocusInWindow();                // move cursor to username field
            return false;
        }
        
        else if(password.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please enter your Password");
            txt_password.setText("");
            txt_password.requestFocusInWindow();
            return false;
        }
        else
            return true;
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
