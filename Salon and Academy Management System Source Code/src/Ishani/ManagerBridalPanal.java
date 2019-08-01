/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ishani;

import Sohan.HomePage;
import Sohan.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class ManagerBridalPanal extends javax.swing.JFrame {
    ResultSet rs;
    PreparedStatement pst;
    Statement st;

    GetDBConnection dbc = new GetDBConnection(); //connect to database
    DefaultTableModel model;
    DefaultListModel modellist;
    Double price; 
    int ID;
    
    public ManagerBridalPanal() {
        initComponents();
        idAutoGenerate();
    }
    
         private int idAutoGenerate()
    {
        String queryid = "SELECT MAX(BservicesId) FROM bridalservices";
        int nextbid;

        try {
            pst = dbc.con.prepareStatement(queryid);
            rs = this.pst.executeQuery();

            while (rs.next()) {
                nextbid = rs.getInt(1);
                Integer bid = nextbid+1;
                return bid;
               
            }

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }       
        return 0;
        
    }

    
   
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_AddMem = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        serNametext = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        searchtext = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bserviceTable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        pricetext = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchlist = new javax.swing.JList();
        side_bar = new javax.swing.JPanel();
        top_panel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btn_back1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 20));
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

        jPanel11.setBackground(new java.awt.Color(12, 173, 183));
        jPanel11.setPreferredSize(new java.awt.Dimension(190, 3));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Bridal Services");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Default pack Manager");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        lbl_AddMem.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lbl_AddMem.setForeground(new java.awt.Color(255, 255, 255));
        lbl_AddMem.setText("Bridal Services Analysis");
        lbl_AddMem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_AddMem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_AddMemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(lbl_AddMem)
                .addGap(266, 266, 266))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_AddMem)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

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

        serNametext.setMinimumSize(new java.awt.Dimension(5, 20));
        serNametext.setOpaque(false);
        serNametext.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(serNametext);
        serNametext.setBounds(150, 130, 210, 25);

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(33, 33, 33));
        jLabel14.setText("Service Name");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(30, 130, 110, 20);

        searchtext.setMinimumSize(new java.awt.Dimension(5, 20));
        searchtext.setOpaque(false);
        searchtext.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(searchtext);
        searchtext.setBounds(30, 20, 210, 30);

        jPanel1.setBackground(new java.awt.Color(102, 185, 213));

        bserviceTable.setAutoCreateRowSorter(true);
        bserviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bridal Service", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        bserviceTable.setGridColor(new java.awt.Color(204, 204, 204));
        bserviceTable.setRowHeight(30);
        bserviceTable.setRowMargin(10);
        bserviceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bserviceTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bserviceTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(430, 60, 350, 219);

        jButton5.setBackground(new java.awt.Color(12, 173, 183));
        jButton5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 102, 102));
        jButton5.setText("Search");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(250, 40, 80, 25);

        delete.setBackground(new java.awt.Color(12, 173, 183));
        delete.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.setLabel("Delete Bridal Service");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete);
        delete.setBounds(120, 410, 180, 40);

        pricetext.setMinimumSize(new java.awt.Dimension(5, 20));
        pricetext.setOpaque(false);
        pricetext.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(pricetext);
        pricetext.setBounds(150, 190, 210, 25);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 33, 33));
        jLabel21.setText("Price");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(30, 190, 110, 20);

        jButton9.setBackground(new java.awt.Color(12, 173, 183));
        jButton9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(102, 102, 102));
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setLabel("Add Bridal Service");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(10, 350, 180, 40);

        update.setBackground(new java.awt.Color(12, 173, 183));
        update.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        update.setForeground(new java.awt.Color(102, 102, 102));
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.setEnabled(false);
        update.setLabel("Update Bridal Service");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update);
        update.setBounds(240, 350, 180, 40);

        searchlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(searchlist);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 210, 70);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 510);

        side_bar.setBackground(new java.awt.Color(12, 173, 183));

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        main_panel.add(side_bar);
        side_bar.setBounds(860, 50, 220, 610);

        top_panel1.setBackground(new java.awt.Color(52, 53, 57));
        top_panel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome");
        top_panel1.add(jLabel3);
        jLabel3.setBounds(90, 10, 71, 25);

        jButton3.setBackground(new java.awt.Color(12, 173, 183));
        jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("LOGOUT");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setOpaque(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        top_panel1.add(jButton3);
        jButton3.setBounds(975, 9, 90, 32);

        btn_back1.setBackground(new java.awt.Color(57, 60, 64));
        btn_back1.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back1.setForeground(new java.awt.Color(204, 204, 204));
        btn_back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_keyboard_arrow_left_white_24dp_1x.png"))); // NOI18N
        btn_back1.setBorderPainted(false);
        btn_back1.setContentAreaFilled(false);
        btn_back1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back1.setIconTextGap(10);
        btn_back1.setOpaque(true);
        btn_back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back1ActionPerformed(evt);
            }
        });
        top_panel1.add(btn_back1);
        btn_back1.setBounds(0, 0, 60, 50);

        main_panel.add(top_panel1);
        top_panel1.setBounds(0, 0, 1080, 50);

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

    private void lbl_AddMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_AddMemMouseClicked
        ManagerBSAnalysis mbsa=new ManagerBSAnalysis();
        mbsa.setVisible(true);
    }//GEN-LAST:event_lbl_AddMemMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       
        DefaultTableModel model=(DefaultTableModel) bserviceTable.getModel();
        
        String ServiceName= serNametext.getText();
        Double price= Double.parseDouble(pricetext.getText());
        int bserviceid= idAutoGenerate();
        
        
        try{
            
        String sql="INSERT INTO bridalservices VALUES('"+ServiceName+"','"+ bserviceid +"', '"+price+"' )";
        pst=dbc.con.prepareStatement(sql);
        pst.execute();
        
        model.addRow(new Object[]{ServiceName,price});
        }
        
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e); 
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
        DefaultListModel model = new DefaultListModel();
        String ServiceName= searchtext.getText();
        
        try{
            
        String sql="select Bservices from bridalservices where Bservices LIKE CONCAT('" + ServiceName + "','%')";
        pst=dbc.con.prepareStatement(sql);
        this.rs = this.pst.executeQuery();
        
         while(rs.next())
            {                
                
                        String searchval = rs.getString("Bservices"); //get the element in column "Bservices"
                        model.addElement(searchval); //add each item to the model
            }
         searchlist.setModel(model);
         
         update.setEnabled(true);
         delete.setEnabled(true);
        
        }
        
        
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e); 
        }
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void searchlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchlistMouseClicked
       
       
        
        String ServiceName= (searchlist.getSelectedValue()).toString();
       
        serNametext.setText(ServiceName);
        
        
        try{
        
        String sql="select Price from bridalservices where Bservices ='" + ServiceName + "'";
        
        pst=dbc.con.prepareStatement(sql);
        this.rs = this.pst.executeQuery();
        
         while(rs.next())
            {                
                 price= rs.getDouble("Price");
                 pricetext.setText(price.toString());
                        
            }
        
         
         searchtext.setText("");
        DefaultTableModel model1=(DefaultTableModel) bserviceTable.getModel();
          
         model1.addRow(new Object[]{ServiceName,price});
        
        }
        
        
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e); 
        }
        
        
        
    }//GEN-LAST:event_searchlistMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        DefaultTableModel model=(DefaultTableModel) bserviceTable.getModel();
        String ServiceName= serNametext.getText();
        Double price= Double.parseDouble(pricetext.getText());
        
        int x= JOptionPane.showConfirmDialog(null, "Do you really want to update?");
        if(x==0){
            
           try{  
               String sql = "select BservicesId from bridalservices where Bservices ='" + ServiceName + "'";

               pst = dbc.con.prepareStatement(sql);
               this.rs = this.pst.executeQuery();
               

               while (rs.next()) 
               {
                   ID = rs.getInt("BservicesId");
                   

               }
            
               String sql2="Update bridalservices SET  Bservices='"+ServiceName+"' , Price='"+price+"'  WHERE BservicesId='"+ID+"' ";
           
                pst=dbc.con.prepareStatement(sql2);
                
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully Updated");
                
                
                serNametext.setText("");
                pricetext.setText("");
                model.setRowCount(0);
                searchtext.setText("");
                searchlist.removeAll();
              
   
            
            
           }
          
           catch(Exception e)
           {
            JOptionPane.showMessageDialog(null, e);
           }
            
            
            
            
            
            
                 }
        
        
        
    }//GEN-LAST:event_updateActionPerformed

    private void bserviceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bserviceTableMouseClicked
       
        DefaultTableModel model=(DefaultTableModel) bserviceTable.getModel();
        int r=bserviceTable.getSelectedRow();
        
        String ServiceName =model.getValueAt(r, 0).toString();
        Double price=(Double) model.getValueAt(r, 1);
        
        serNametext.setText(ServiceName);
        pricetext.setText(price.toString());
        
        
        
    }//GEN-LAST:event_bserviceTableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        DefaultTableModel model=(DefaultTableModel) bserviceTable.getModel();
         String ServiceName= serNametext.getText();
         try{
        
        String sql="select BservicesId from bridalservices where Bservices ='" + ServiceName + "'";
        pst=dbc.con.prepareStatement(sql);
        this.rs = this.pst.executeQuery();
        
         while(rs.next())
            {                
                 ID= rs.getInt("BservicesId");
                 
                        
            }
        
         
         
      
         String sql2 = "delete  from bridalservices where BservicesId='" + ID + "'";

        
            pst = dbc.con.prepareStatement(sql2);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Deleted !!!");
                serNametext.setText("");
                pricetext.setText("");
                model.setRowCount(0);
                searchtext.setText("");
                searchlist.removeAll();
         
        
        }
        
        
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e); 
        }
        
        
        
    }//GEN-LAST:event_deleteActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
      ManagerBridalPanal mbp=new ManagerBridalPanal();
      mbp.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       Managerdefaultpac mdp =new Managerdefaultpac();
       mdp.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

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

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered

        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Login l = new Login();
        l.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back1ActionPerformed

        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_back1ActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerBridalPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerBridalPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerBridalPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerBridalPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ManagerBridalPanal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bserviceTable;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_back1;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_AddMem;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField pricetext;
    private javax.swing.JList searchlist;
    private javax.swing.JTextField searchtext;
    private javax.swing.JTextField serNametext;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    private javax.swing.JPanel top_panel1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
