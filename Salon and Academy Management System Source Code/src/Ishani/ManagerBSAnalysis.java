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
public class ManagerBSAnalysis extends javax.swing.JFrame {
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
           int d;
      int a;
      int s;
      int p;
      int g;
      int f1;
      int f2;
      int f3;
    
    public ManagerBSAnalysis() {
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
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        diaProgressBa = new javax.swing.JProgressBar();
        platinumbar = new javax.swing.JProgressBar();
        goldbar = new javax.swing.JProgressBar();
        silverbar = new javax.swing.JProgressBar();
        otherbar = new javax.swing.JProgressBar();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        minbservice = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        maxbservice = new javax.swing.JLabel();
        maxnum = new javax.swing.JLabel();
        minnum = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cus = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cuSat1 = new javax.swing.JProgressBar();
        cuSat2 = new javax.swing.JProgressBar();
        cuSat3 = new javax.swing.JProgressBar();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        high = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        medunm = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        low = new javax.swing.JLabel();
        diamondbutton = new javax.swing.JButton();
        diamondbutton1 = new javax.swing.JButton();
        diamondbutton2 = new javax.swing.JButton();
        side_bar = new javax.swing.JPanel();
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
            .addGap(0, 177, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

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

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 255, 255));
        jLabel21.setText("USAGE");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(140, 20, 90, 20);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Silver");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(310, 140, 50, 10);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Diamond");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(310, 50, 70, 10);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Plantinum");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(310, 80, 70, 10);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Gold");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(310, 110, 50, 10);

        diaProgressBa.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.add(diaProgressBa);
        diaProgressBa.setBounds(10, 50, 290, 14);

        platinumbar.setBackground(new java.awt.Color(102, 102, 102));
        platinumbar.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(platinumbar);
        platinumbar.setBounds(10, 80, 290, 14);

        goldbar.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(goldbar);
        goldbar.setBounds(10, 110, 290, 14);

        silverbar.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(silverbar);
        silverbar.setBounds(10, 140, 290, 14);

        otherbar.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(otherbar);
        otherbar.setBounds(10, 170, 290, 14);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Customized");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(310, 170, 80, 10);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(50, 90, 380, 190);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(null);

        jLabel22.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 255));
        jLabel22.setText("USAGE");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(140, 20, 90, 20);

        minbservice.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        minbservice.setForeground(new java.awt.Color(255, 255, 255));
        minbservice.setText("Min");
        jPanel3.add(minbservice);
        minbservice.setBounds(130, 110, 190, 24);

        jLabel24.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Min");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(30, 110, 29, 24);

        jLabel25.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Max");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(30, 60, 54, 24);

        maxbservice.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        maxbservice.setForeground(new java.awt.Color(255, 255, 255));
        maxbservice.setText("Max");
        jPanel3.add(maxbservice);
        maxbservice.setBounds(130, 60, 190, 24);

        maxnum.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        maxnum.setForeground(new java.awt.Color(255, 255, 255));
        maxnum.setText("Max");
        jPanel3.add(maxnum);
        maxnum.setBounds(320, 60, 50, 24);

        minnum.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        minnum.setForeground(new java.awt.Color(255, 255, 255));
        minnum.setText("Min");
        jPanel3.add(minnum);
        minnum.setBounds(320, 110, 29, 24);

        jLabel26.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Customized");
        jPanel3.add(jLabel26);
        jLabel26.setBounds(30, 150, 120, 24);

        cus.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        cus.setForeground(new java.awt.Color(255, 255, 255));
        cus.setText("Max");
        jPanel3.add(cus);
        cus.setBounds(320, 150, 50, 24);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(50, 290, 380, 190);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        jLabel23.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 255, 255));
        jLabel23.setText("Customer Satisfaction");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("High");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Medium");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Low");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cuSat1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuSat2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cuSat3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuSat1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuSat2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuSat3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(450, 90, 350, 190);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        high.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        high.setForeground(new java.awt.Color(255, 255, 255));
        high.setText("Max");

        jLabel27.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 255, 255));
        jLabel27.setText("Customer Satisfaction");

        jLabel28.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Highly Satisfied");

        medunm.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        medunm.setForeground(new java.awt.Color(255, 255, 255));
        medunm.setText("Max");

        jLabel30.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Satisfied");

        jLabel31.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Not Satisfied");

        low.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        low.setForeground(new java.awt.Color(255, 255, 255));
        low.setText("Max");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(high, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(medunm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(low, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(high)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medunm)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(low)
                    .addComponent(jLabel31))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7);
        jPanel7.setBounds(450, 290, 350, 190);

        diamondbutton.setBackground(new java.awt.Color(12, 173, 183));
        diamondbutton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        diamondbutton.setForeground(new java.awt.Color(0, 102, 102));
        diamondbutton.setText("Appoinment Report");
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
        diamondbutton.setBounds(530, 20, 160, 40);

        diamondbutton1.setBackground(new java.awt.Color(12, 173, 183));
        diamondbutton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        diamondbutton1.setForeground(new java.awt.Color(0, 102, 102));
        diamondbutton1.setText("Bridal Service Usage");
        diamondbutton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        diamondbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                diamondbutton1MouseEntered(evt);
            }
        });
        diamondbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diamondbutton1ActionPerformed(evt);
            }
        });
        jPanel2.add(diamondbutton1);
        diamondbutton1.setBounds(170, 20, 160, 40);

        diamondbutton2.setBackground(new java.awt.Color(12, 173, 183));
        diamondbutton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        diamondbutton2.setForeground(new java.awt.Color(0, 102, 102));
        diamondbutton2.setText("FeedBack Report");
        diamondbutton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        diamondbutton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                diamondbutton2MouseEntered(evt);
            }
        });
        diamondbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diamondbutton2ActionPerformed(evt);
            }
        });
        jPanel2.add(diamondbutton2);
        diamondbutton2.setBounds(350, 20, 160, 40);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 540);

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
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1080, 702));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   
      
      String query=" SELECT COUNT(app_id) as dcount FROM appointment where status= 'Default' and price='250000' ";
      String query1=" SELECT COUNT(app_id) as pcount FROM appointment where status= 'Default' and price='200000' ";
      String query2=" SELECT COUNT(app_id) as gcount FROM appointment where status= 'Default' and price='180000' ";
      String query3=" SELECT COUNT(app_id) as scount FROM appointment where status= 'Default' and price='150000' ";
      String query4=" SELECT BservicesId ,COUNT(BservicesId) as scount FROM costomizepackages GROUP BY  BservicesId";
      String query5=" SELECT COUNT(feedback_id) as fdcount FROM feedbacki where result < '1' AND result >= '0'  ";
      String query6=" SELECT COUNT(feedback_id) as fdcount FROM feedbacki where result < '3' AND result >= '1'  ";
      String query7=" SELECT COUNT(feedback_id) as fdcount FROM feedbacki where result <= '4' AND result >= '3'  ";
      String query8=" SELECT  COUNT(DISTINCT PackId) as acount FROM costomizepackages where PackId > '4' ";
        try
        {
            
            
             pst = dbc.con.prepareStatement(query);
             this.rs = this.pst.executeQuery();
            
              while(rs.next())
            {  
                d=rs.getInt("dcount");                
                diaProgressBa.setValue(d*10);   
            }
              
              pst = dbc.con.prepareStatement(query1);
             this.rs = this.pst.executeQuery();
           
              while(rs.next())
            {  
                p=rs.getInt("pcount");               
                platinumbar.setValue(p*10);
            }
              pst = dbc.con.prepareStatement(query2);
             this.rs = this.pst.executeQuery();
            
              while(rs.next())
            {  
                g=rs.getInt("gcount");
                goldbar.setValue(g*10);
            }
              pst = dbc.con.prepareStatement(query3);
             this.rs = this.pst.executeQuery();
            
              while(rs.next())
            {  
                s=rs.getInt("scount");
                silverbar.setValue(s*10);
            }
              
                pst = dbc.con.prepareStatement(query5);
             this.rs = this.pst.executeQuery();
            
              while(rs.next())
            {  
                f1=rs.getInt("fdcount");
                cuSat3.setValue(f1*5);
                low.setText(Integer.toString(f1));
            }
              
                 pst = dbc.con.prepareStatement(query6);
             this.rs = this.pst.executeQuery();
            
              while(rs.next())
            {  
                f2=rs.getInt("fdcount");
                cuSat2.setValue(f2*5);
                medunm.setText(Integer.toString(f2));
            }
              
              pst = dbc.con.prepareStatement(query7);
             this.rs = this.pst.executeQuery();
            
              while(rs.next())
            {  
                f3=rs.getInt("fdcount");
                cuSat1.setValue(f3*5);
                high.setText(Integer.toString(f3));
            }
              
             pst = dbc.con.prepareStatement(query8);
             this.rs = this.pst.executeQuery();
           
              while(rs.next())
            {  
                a=rs.getInt("acount");
                otherbar.setValue(a*5);
                cus.setText(Integer.toString(a));
            }
                
                int arr[]={d,p,g,s};
                int max=arr[0];
                int min=arr[0];
                for(int i=0;i<arr.length;i++)
                {
                    if(arr[i]>max)
                    {
                        max=arr[i];
                    }
                }
                    maxnum.setText(Integer.toString(max));
                     
                    
                 for(int i=0;i<arr.length;i++)
                {
                    if(arr[i]<min)
                    {
                        min=arr[i];
                    }
                }
                    minnum.setText(Integer.toString(min));
                     
                    
                if(min==d )
                    minbservice.setText("DIAMOND");
                else if(min==g )
                    minbservice.setText("GOLD");
                else if(min==p )
                    minbservice.setText("PLATINUM");
                else if (min==s)
                    minbservice.setText("SILVER");
                
                if(max==d )
                    maxbservice.setText("DIAMOND");
                else if(max==g )
                    maxbservice.setText("GOLD");
                else if(max==p )
                    maxbservice.setText("PLATINUM");
                else if (max==s)
                    maxbservice.setText("SILVER");
            
              
        }
        
        catch(Exception e)
        {
        }
        
      
      
        
    }//GEN-LAST:event_formWindowOpened

    private void lbl_AddMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_AddMemMouseClicked
        ManagerBSAnalysis mbsa=new ManagerBSAnalysis();
        mbsa.setVisible(true);
    }//GEN-LAST:event_lbl_AddMemMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        ManagerBridalPanal mbp=new ManagerBridalPanal();
        mbp.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Managerdefaultpac mdp =new Managerdefaultpac();
        mdp.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void diamondbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diamondbuttonMouseEntered
 
    }//GEN-LAST:event_diamondbuttonMouseEntered

    private void diamondbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diamondbuttonActionPerformed

        ReportView e =new ReportView("C:\\Users\\User\\Documents\\NetBeansProjects\\Salon_9_14\\src\\Ishani\\ImagesCustom\\report3.jasper");
        e.setVisible(true);

    }//GEN-LAST:event_diamondbuttonActionPerformed

    private void diamondbutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diamondbutton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_diamondbutton1MouseEntered

    private void diamondbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diamondbutton1ActionPerformed
        ReportView x =new ReportView("C:\\Users\\ASUSI7\\Desktop\\ireports\\ish.jasper");
        x.setVisible(true);
    }//GEN-LAST:event_diamondbutton1ActionPerformed

    private void diamondbutton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diamondbutton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_diamondbutton2MouseEntered

    private void diamondbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diamondbutton2ActionPerformed
        ReportView y =new ReportView("C:\\Users\\User\\Documents\\NetBeansProjects\\Salon_9_14\\src\\Ishani\\ImagesCustom\\report7.jasper");
        y.setVisible(true);
    }//GEN-LAST:event_diamondbutton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerBSAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerBSAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerBSAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerBSAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ManagerBSAnalysis().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JProgressBar cuSat1;
    private javax.swing.JProgressBar cuSat2;
    private javax.swing.JProgressBar cuSat3;
    private javax.swing.JLabel cus;
    private javax.swing.JProgressBar diaProgressBa;
    private javax.swing.JButton diamondbutton;
    private javax.swing.JButton diamondbutton1;
    private javax.swing.JButton diamondbutton2;
    private javax.swing.JProgressBar goldbar;
    private javax.swing.JLabel high;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_AddMem;
    private javax.swing.JLabel low;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel maxbservice;
    private javax.swing.JLabel maxnum;
    private javax.swing.JLabel medunm;
    private javax.swing.JLabel minbservice;
    private javax.swing.JLabel minnum;
    private javax.swing.JProgressBar otherbar;
    private javax.swing.JProgressBar platinumbar;
    private javax.swing.JPanel side_bar;
    private javax.swing.JProgressBar silverbar;
    private javax.swing.JPanel top_panel;
    // End of variables declaration//GEN-END:variables
}
