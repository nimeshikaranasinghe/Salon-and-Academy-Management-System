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
public class Managerdefaultpac extends javax.swing.JFrame {
    ResultSet rs;
    PreparedStatement pst;
    Statement st;

    GetDBConnection dbc = new GetDBConnection(); //connect to database
    DefaultTableModel model;
    DefaultListModel modellist;
    Double price; 
    int ID;
    int BID;
    int Packid;
     String database;
    
    public Managerdefaultpac() {
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
        side_bar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        value = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bserviceTable = new javax.swing.JTable();
        test = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        pacname = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        allserviceTable = new javax.swing.JTable();
        silverbutt = new javax.swing.JButton();
        diamondbutton = new javax.swing.JButton();
        goldbutt = new javax.swing.JButton();
        platinumbutt = new javax.swing.JButton();
        gototable = new javax.swing.JLabel();
        items = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        labPrice = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

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
                .addGap(28, 28, 28)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(lbl_AddMem)
                .addGap(266, 266, 266))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

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

        jPanel8.setBackground(new java.awt.Color(52, 53, 57));
        jPanel8.setForeground(new java.awt.Color(153, 153, 153));

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

        value.setFont(new java.awt.Font("Nirmala UI", 0, 20)); // NOI18N
        value.setForeground(new java.awt.Color(33, 33, 33));
        jPanel2.add(value);
        value.setBounds(700, 100, 130, 20);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(500, 170, 350, 219);

        test.setBackground(new java.awt.Color(12, 173, 183));
        test.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        test.setForeground(new java.awt.Color(153, 153, 153));
        test.setText("Test");
        test.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });
        jPanel2.add(test);
        test.setBounds(650, 400, 80, 25);

        jLabel19.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(33, 33, 33));
        jLabel19.setText("Total :");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(600, 100, 60, 20);

        pacname.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        pacname.setForeground(new java.awt.Color(33, 33, 33));
        jPanel2.add(pacname);
        pacname.setBounds(690, 30, 120, 30);

        allserviceTable.setAutoCreateRowSorter(true);
        allserviceTable.setModel(new javax.swing.table.DefaultTableModel(
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
        allserviceTable.setGridColor(new java.awt.Color(204, 204, 204));
        allserviceTable.setRowHeight(30);
        allserviceTable.setRowMargin(10);
        allserviceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allserviceTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(allserviceTable);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(40, 160, 390, 230);

        silverbutt.setBackground(new java.awt.Color(12, 173, 183));
        silverbutt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        silverbutt.setForeground(new java.awt.Color(0, 102, 102));
        silverbutt.setText("Silver");
        silverbutt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        silverbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                silverbuttMouseEntered(evt);
            }
        });
        silverbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silverbuttActionPerformed(evt);
            }
        });
        jPanel2.add(silverbutt);
        silverbutt.setBounds(420, 50, 80, 25);

        diamondbutton.setBackground(new java.awt.Color(12, 173, 183));
        diamondbutton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        diamondbutton.setForeground(new java.awt.Color(0, 102, 102));
        diamondbutton.setText("Diamond");
        diamondbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        diamondbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                diamondbuttonMouseEntered(evt);
            }
        });
        diamondbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diamondbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(diamondbutton);
        diamondbutton.setBounds(30, 50, 90, 25);

        goldbutt.setBackground(new java.awt.Color(12, 173, 183));
        goldbutt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        goldbutt.setForeground(new java.awt.Color(0, 102, 102));
        goldbutt.setText("Gold");
        goldbutt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goldbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goldbuttMouseEntered(evt);
            }
        });
        goldbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldbuttActionPerformed(evt);
            }
        });
        jPanel2.add(goldbutt);
        goldbutt.setBounds(300, 50, 80, 25);

        platinumbutt.setBackground(new java.awt.Color(12, 173, 183));
        platinumbutt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        platinumbutt.setForeground(new java.awt.Color(0, 102, 102));
        platinumbutt.setText("Platinum");
        platinumbutt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        platinumbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                platinumbuttMouseEntered(evt);
            }
        });
        platinumbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platinumbuttActionPerformed(evt);
            }
        });
        jPanel2.add(platinumbutt);
        platinumbutt.setBounds(160, 50, 90, 25);

        gototable.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        gototable.setForeground(new java.awt.Color(0, 102, 102));
        gototable.setText(">");
        gototable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gototableMouseClicked(evt);
            }
        });
        jPanel2.add(gototable);
        gototable.setBounds(450, 220, 30, 40);

        items.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        items.setForeground(new java.awt.Color(33, 33, 33));
        jPanel2.add(items);
        items.setBounds(730, 60, 30, 30);

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(33, 33, 33));
        jLabel17.setText("Rs. ");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(660, 100, 40, 20);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 33, 33));
        jLabel21.setText("#Of Services :");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(600, 60, 120, 30);

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(33, 33, 33));
        jLabel22.setText("Package :");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(600, 30, 120, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("<");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1);
        jLabel1.setBounds(450, 310, 21, 40);

        jLabel20.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(33, 33, 33));
        jLabel20.setText("Labeled:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(600, 130, 70, 20);

        labPrice.setFont(new java.awt.Font("Nirmala UI", 0, 20)); // NOI18N
        labPrice.setForeground(new java.awt.Color(33, 33, 33));
        jPanel2.add(labPrice);
        labPrice.setBounds(700, 130, 120, 20);

        jLabel23.setFont(new java.awt.Font("Nirmala UI", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(33, 33, 33));
        jLabel23.setText("Rs. ");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(670, 130, 40, 20);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 510);

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
            String query1 = "";
      query1=" SELECT Bservices , Price FROM BridalServices ";
      
              
        try{
            
           DefaultTableModel model = (DefaultTableModel) allserviceTable.getModel();
            
            pst = dbc.con.prepareStatement(query1);
            this.rs = this.pst.executeQuery();
           
            
            while(rs.next())
            {              
                String BridalServ = rs.getString("Bservices");
               
                Double price = rs.getDouble("Price");
               
                model.addRow(new Object[]{BridalServ, price });        
            }
                

            
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Error: " + err, "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_formWindowOpened

    private void lbl_AddMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_AddMemMouseClicked
       ManagerBSAnalysis mbsa=new ManagerBSAnalysis();
        mbsa.setVisible(true);
    }//GEN-LAST:event_lbl_AddMemMouseClicked

    private void bserviceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bserviceTableMouseClicked
       
        DefaultTableModel model=(DefaultTableModel) bserviceTable.getModel();
        int r=bserviceTable.getSelectedRow();
        
        String ServiceName =model.getValueAt(r, 0).toString();
        Double price=(Double) model.getValueAt(r, 1);
        
       
        
        
        
    }//GEN-LAST:event_bserviceTableMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        ManagerBridalPanal mbp=new ManagerBridalPanal();
        mbp.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
                        
           DefaultTableModel model = (DefaultTableModel) allserviceTable.getModel();
           DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
           
          double total=0;
          int numofrow =cart.getRowCount();
          items.setText(Integer.toString(numofrow));
          for(int i=0;i<numofrow;i++)
           {
            Double val=(Double)cart.getValueAt(i, 1);
             total=val+total;
           }
       value.setText(Double.toString(total));
      
    }//GEN-LAST:event_testActionPerformed

    private void allserviceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allserviceTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_allserviceTableMouseClicked

    private void silverbuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silverbuttActionPerformed
       
              String query1 = "";
      query1=" SELECT * FROM silverpack";
      pacname.setText("SILVER");
              
        try{
            
           DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
            
            pst = dbc.con.prepareStatement(query1);
            this.rs = this.pst.executeQuery();
           
            
            while(rs.next())
            {              
                String BridalServ = rs.getString("Bservices");
               
                Double price = rs.getDouble("Price");
               
                cart.addRow(new Object[]{BridalServ, price });        
            }
            String query2=" SELECT Price FROM defaultpackage where PackId= '4'";
             pst = dbc.con.prepareStatement(query2);
             this.rs = this.pst.executeQuery();
             
              while(rs.next())
            {              
                
                Double price = rs.getDouble("Price");
                labPrice.setText((price).toString());
                      
            }
                

            
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Error: " + err, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_silverbuttActionPerformed

    private void diamondbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diamondbuttonActionPerformed
        
                   String query1 = "";
      query1=" SELECT * FROM diamondpack ";
      pacname.setText("DIAMOND");
              
        try{
            
           DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
            
            pst = dbc.con.prepareStatement(query1);
            this.rs = this.pst.executeQuery();
           
            
            while(rs.next())
            {              
                String BridalServ = rs.getString("Bservices");
               
                Double price = rs.getDouble("Price");
               
                cart.addRow(new Object[]{BridalServ, price });        
            }
                
            String query2=" SELECT Price FROM defaultpackage where PackId= '1' ";
             pst = dbc.con.prepareStatement(query2);
             this.rs = this.pst.executeQuery();
             
              while(rs.next())
            {              
                
                Double price = rs.getDouble("Price");
                labPrice.setText((price).toString());
                      
            }
            
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Error: " + err, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_diamondbuttonActionPerformed

    private void goldbuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldbuttActionPerformed
        
              String query1 = "";
      query1=" SELECT * FROM goldpack ";
      pacname.setText("GOLD");
              
        try{
            
           DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
            
            pst = dbc.con.prepareStatement(query1);
            this.rs = this.pst.executeQuery();
           
            
            while(rs.next())
            {              
                String BridalServ = rs.getString("Bservices");
               
                Double price = rs.getDouble("Price");
               
                cart.addRow(new Object[]{BridalServ, price });        
            }
            
            String query2=" SELECT Price FROM defaultpackage where PackId='3'";
             pst = dbc.con.prepareStatement(query2);
             this.rs = this.pst.executeQuery();
             
              while(rs.next())
            {              
                
                Double price = rs.getDouble("Price");
                labPrice.setText((price).toString());
                      
            }
                

            
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Error: " + err, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_goldbuttActionPerformed

    private void platinumbuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platinumbuttActionPerformed
       
              String query1 = "";
      query1=" SELECT * FROM platinumpack ";
       pacname.setText("PLATINUM");
              
        try{
            
           DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
            
            pst = dbc.con.prepareStatement(query1);
            this.rs = this.pst.executeQuery();
           
            
            while(rs.next())
            {              
                String BridalServ = rs.getString("Bservices");
               
                Double price = rs.getDouble("Price");
               
                cart.addRow(new Object[]{BridalServ, price });        
            }
            String query2=" SELECT Price FROM defaultpackage where PackId= '2'";
             pst = dbc.con.prepareStatement(query2);
             this.rs = this.pst.executeQuery();
             
              while(rs.next())
            {              
                
                Double price = rs.getDouble("Price");
                labPrice.setText((price).toString());
                      
            }
                

            
            
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Error: " + err, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_platinumbuttActionPerformed

    private void gototableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gototableMouseClicked
           DefaultTableModel model = (DefaultTableModel) allserviceTable.getModel();
           DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
          
           String packagename = pacname.getText();
            if(packagename.equals("DIAMOND"))
                   database="diamondpack";
            if(packagename.equals("PLATINUM"))
                   database="platinumpack";
            if(packagename.equals("GOLD"))
                   database="goldpack";
            if(packagename.equals("SILVER"))
                  database="silverpack";
          
           int row = allserviceTable.getSelectedRow();
           int rowcount=cart.getRowCount();
           System.out.println(row);
           
           String Bridalservice=  allserviceTable.getValueAt(row, 0).toString();  
            
           String prize =  allserviceTable.getValueAt(row, 1).toString();
            
           Double price=Double.parseDouble(prize);
           
           for(int i=0;i<rowcount;i++)
           {
              String bs=cart.getValueAt(i, 0).toString();
              if( (bs.equals(Bridalservice)))
              {
                  JOptionPane.showMessageDialog(null, "Duplicate");
                  return;
                  
              }
              
           }
                   
                   cart.addRow(new Object[]{Bridalservice,price});
                   model.removeRow(row);
              
             try
             {
                 
            String sql1="select BservicesId from bridalservices where Bservices='" + Bridalservice + "'";
            pst = dbc.con.prepareStatement(sql1);
            this.rs = this.pst.executeQuery();
             
               while (rs.next()) 
               {
                   BID = rs.getInt("BservicesId");
                  
               }
                 
            String sql="INSERT INTO "+ database +" VALUES('"+Bridalservice+"','"+ BID +"', '"+prize+"' )";
            pst=dbc.con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Insert");     
             }
             catch(Exception e)
             {
                 JOptionPane.showMessageDialog(this, e);
             }
          
             
           
    }//GEN-LAST:event_gototableMouseClicked

    private void diamondbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diamondbuttonMouseEntered
         DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
         cart.setRowCount(0);
    }//GEN-LAST:event_diamondbuttonMouseEntered

    private void goldbuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goldbuttMouseEntered
       DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
         cart.setRowCount(0);
    }//GEN-LAST:event_goldbuttMouseEntered

    private void platinumbuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_platinumbuttMouseEntered
        DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
         cart.setRowCount(0);
    }//GEN-LAST:event_platinumbuttMouseEntered

    private void silverbuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_silverbuttMouseEntered
        DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
         cart.setRowCount(0);
    }//GEN-LAST:event_silverbuttMouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         
        DefaultTableModel cart = (DefaultTableModel) bserviceTable.getModel();
        DefaultTableModel model = (DefaultTableModel) allserviceTable.getModel();
        int row =bserviceTable.getSelectedRow();
        String Bridalservice= cart.getValueAt(row, 0).toString();
        Double price= (Double) cart.getValueAt(row, 1);
       
        String packagename = pacname.getText();
            if(packagename.equals("DIAMOND"))
                   database="diamondpack";
            if(packagename.equals("PLATINUM"))
                   database="platinumpack";
            if(packagename.equals("GOLD"))
                   database="goldpack";
            if(packagename.equals("SILVER"))
                  database="silverpack";
        
         try{
              int rowcount=model.getRowCount();
               
                 for(int i=0;i<rowcount;i++)
           {
              String bs=model.getValueAt(i, 0).toString();
              if( (bs.equals(Bridalservice)))
              {
                  JOptionPane.showMessageDialog(null, "removed");
                  cart.removeRow(row);
                  String sql2 = "delete  from " + database + " where Bservices='" + Bridalservice + "'";
                  pst = dbc.con.prepareStatement(sql2);
                  pst.execute();
                  JOptionPane.showMessageDialog(null, "Deleted !!!");
                  return;
                  
              }
              
           }
                   JOptionPane.showMessageDialog(null, "removed");
                   model.addRow(new Object[]{Bridalservice,price});
                   cart.removeRow(row);
                   
             String sql2 = "delete  from "+database+" where Bservices='" + Bridalservice + "'";
             pst = dbc.con.prepareStatement(sql2);
             pst.execute();
             JOptionPane.showMessageDialog(null, "Deleted !!!");

 
                 
                 
             }
             catch(Exception e){}
          
        
        cart.removeRow(row);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Managerdefaultpac mdp =new Managerdefaultpac();
        mdp.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(Managerdefaultpac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Managerdefaultpac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Managerdefaultpac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Managerdefaultpac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
 

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Managerdefaultpac().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allserviceTable;
    private javax.swing.JTable bserviceTable;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton diamondbutton;
    private javax.swing.JButton goldbutt;
    private javax.swing.JLabel gototable;
    private javax.swing.JLabel items;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labPrice;
    private javax.swing.JLabel lbl_AddMem;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel pacname;
    private javax.swing.JButton platinumbutt;
    private javax.swing.JPanel side_bar;
    private javax.swing.JButton silverbutt;
    private javax.swing.JButton test;
    private javax.swing.JPanel top_panel;
    private javax.swing.JLabel value;
    // End of variables declaration//GEN-END:variables
}
