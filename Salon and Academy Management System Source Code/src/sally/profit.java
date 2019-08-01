/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sally;

import Sohan.HomePage;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ASUSI7
 */
public class profit extends javax.swing.JFrame {

    ResultSet rs,rs1,rs2,rs3,rs4;
    PreparedStatement pst,pst1,pst2,pst3,pst4;  
    Statement st;  
    DBconnection dbc = new DBconnection(); 
    int count1 =0;
    int count2=0;
    int count3=0;
    int count4=0;
    int sal_inc=0;
    int acd_inc=0;
    int inv_exp=0;
    int sal_exp=0;
    
    public profit() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_ok1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_1 = new javax.swing.JLabel();
        txt_2 = new javax.swing.JLabel();
        txt_3 = new javax.swing.JLabel();
        txt_4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_profit = new javax.swing.JLabel();
        txt_loss = new javax.swing.JLabel();
        txt_income = new javax.swing.JLabel();
        txt_expense = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        cmb_exp = new javax.swing.JComboBox<>();
        cmb_inc = new javax.swing.JComboBox<>();
        btn_ok2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmb_year = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cmb_month = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        graph = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(12, 173, 183));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Expense ->");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Income ->");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Profit");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 50, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Loss");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 40, -1));

        btn_ok1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ok1.setText("Go");
        btn_ok1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ok1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_ok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, -1));

        jPanel7.setBackground(new java.awt.Color(10, 124, 124));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Salon Income      : ");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 120, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Academy Income : ");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Inventory Expense:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Salary Expense    :");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txt_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_1.setOpaque(true);
        jPanel7.add(txt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, 20));

        txt_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_2.setOpaque(true);
        jPanel7.add(txt_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 110, 20));

        txt_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_3.setOpaque(true);
        jPanel7.add(txt_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 110, 20));

        txt_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_4.setOpaque(true);
        jPanel7.add(txt_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 110, 20));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 250, 130));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 70, -1));

        txt_profit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_profit.setForeground(new java.awt.Color(0, 0, 153));
        txt_profit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_profit.setOpaque(true);
        jPanel3.add(txt_profit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 100, 40));

        txt_loss.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_loss.setForeground(new java.awt.Color(204, 0, 0));
        txt_loss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_loss.setOpaque(true);
        jPanel3.add(txt_loss, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 90, 40));

        txt_income.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_income.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_income.setOpaque(true);
        jPanel3.add(txt_income, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 140, 20));

        txt_expense.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_expense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_expense.setOpaque(true);
        jPanel3.add(txt_expense, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 140, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 740, 150));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Profit/Loss");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 11, -1, -1));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(12, 173, 183));
        jButton2.setText("Income");

        table1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Income"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jButton2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 220));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(12, 173, 183));
        jButton3.setText("Expenses");

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Expense"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, 220));

        cmb_exp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmb_exp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Salary", "Inventory" }));
        cmb_exp.setToolTipText("");
        jPanel2.add(cmb_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 130, -1));

        cmb_inc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmb_inc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Salon", "Academy" }));
        cmb_inc.setToolTipText("");
        jPanel2.add(cmb_inc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 130, -1));

        btn_ok2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_ok2.setText("OK");
        btn_ok2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 153, 153)));
        btn_ok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ok2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 60, 30));

        jPanel6.setBackground(new java.awt.Color(12, 173, 183));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Year :");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cmb_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005" }));
        jPanel6.add(cmb_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Month :");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        cmb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        jPanel6.add(cmb_month, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 270, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sally/images/home--1-.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 50));

        txt_date.setBackground(new java.awt.Color(255, 255, 255));
        txt_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_date.setOpaque(true);
        jPanel2.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 130, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Date :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 40, -1));

        graph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sally/images/iconchart.png"))); // NOI18N
        graph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graphMouseClicked(evt);
            }
        });
        jPanel2.add(graph, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 100, 90, 70));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Profit and Loss Statement");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Balance Sheet");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 220, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, 100, -1));

        jButton7.setText("Income");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ok1ActionPerformed
        String date = txt_date.getText();
        String year = cmb_year.getSelectedItem().toString();
       String month = cmb_month.getSelectedItem().toString();
        txt_date.setText(year+"-"+month);
        String date2 = txt_date.getText();
       
        try{
            
        String sql ="select sum(Amount) from salon_income where Date1 LIKE '"+date2+"%'";
        pst = dbc.con.prepareStatement(sql);
        rs=pst.executeQuery();
        String sql1 ="select sum(Amount) from acd_income where Date1 LIKE '"+date2+"%'";
        pst1 = dbc.con.prepareStatement(sql1);
        rs1=pst1.executeQuery();
        String sql2 ="select sum(Amount) from inv_exp where Date1 LIKE '"+date2+"%'";
        pst2 = dbc.con.prepareStatement(sql2);
        rs2=pst2.executeQuery();
        String sql3 ="select sum(Amount) from salary_exp where Date1 LIKE '"+date2+"%'";
        pst3 = dbc.con.prepareStatement(sql2);
        rs3=pst3.executeQuery();
        
            if(rs.next())
            {
                String sum = rs.getString("sum(Amount)");
                 txt_1.setText(sum);
                 count1++;
            }
        
            if(rs1.next())
            {
                String sum1 = rs1.getString("sum(Amount)");
                 txt_2.setText(sum1);
                 count2++;
                
            }
            
            if(rs2.next())
            {
                String sum1 = rs2.getString("sum(Amount)");
                 txt_3.setText(sum1);
                 count3++;
                
            }
            if(rs3.next())
            {
                String sum1 = rs3.getString("sum(Amount)");
                 txt_4.setText(sum1);
                 count4++;
                
            }
            
            if(count1==0 || count2==0 || count3==0 || count4==0){
                JOptionPane.showMessageDialog(null, "No record found","Error",JOptionPane.ERROR_MESSAGE);
            
            
            }
            
             sal_inc = Integer.parseInt(txt_1.getText());
             acd_inc = Integer.parseInt(txt_2.getText());
             inv_exp = Integer.parseInt(txt_3.getText());
            sal_exp = Integer.parseInt(txt_4.getText());
            int total_income = (sal_inc + acd_inc);
            txt_income.setText(Integer.toString(total_income));
            int total_exp = inv_exp+sal_exp;
            txt_expense.setText(Integer.toString(total_exp));
            
            int final_amount = (total_income -total_exp);
            
            if(final_amount < 0)
            {
                txt_loss.setText(Integer.toString(final_amount));
            
            }
            if(final_amount > 0)
            {
                txt_profit.setText(Integer.toString(final_amount));
            
            }
            
            
        }
        catch(Exception e)
        {}
        
    }//GEN-LAST:event_btn_ok1ActionPerformed

    private void btn_ok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ok2ActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
        String income = cmb_inc.getSelectedItem().toString();
        String expense = cmb_exp.getSelectedItem().toString();
        
       String year = cmb_year.getSelectedItem().toString();
       String month = cmb_month.getSelectedItem().toString();
        txt_date.setText(year+"-"+month);
        String date = txt_date.getText();
        try{
            
//            String sql ="SELECT * from salon_income";
//            pst = dbc.con.prepareStatement(sql);
//            rs=pst.executeQuery();
//            
//            String sql2 ="SELECT * from acd_income";
//            pst2 = dbc.con.prepareStatement(sql2);
//            rs2=pst2.executeQuery();
//            
//            String sql3 ="SELECT * from inv_exp";
//            pst3 = dbc.con.prepareStatement(sql3);
//            rs3=pst3.executeQuery();
//            
//            String sql4 ="SELECT * from salary_exp";
//            pst4 = dbc.con.prepareStatement(sql4);
//            rs4=pst4.executeQuery();
         
           if(cmb_inc.getSelectedItem().toString() =="Salon")
           {
//               while(rs.next())
//               {
//                        String date_1 = rs.getString("Date1");
//                        String date_2 = date_1.substring(0, 7);

                        String sql1 = "select * from salon_income where Date1 LIKE '"+date+"%' ";
                        pst1 = dbc.con.prepareStatement(sql1);
                        rs1=pst1.executeQuery();

                        while(rs1.next()){
                        
                       String Date_1 = rs1.getString("Date1");
                       String income_1 = Double.toString(rs1.getDouble("Amount"));
                       count1++;
                       model1.addRow(new Object[]{Date_1,income_1});
                   
                   }
                        if(count1==0){
                    JOptionPane.showMessageDialog(null, "No record found","Error",JOptionPane.ERROR_MESSAGE);
                    txt_date.setText("");
                }  
                   
               //}
               
           }
           
           else if(cmb_inc.getSelectedItem().toString() =="Academy")
           {
//               while(rs2.next())
//               {
//                        String date_1 = rs2.getString("Date1");
//                        String date_2 = date_1.substring(0, 7);

                        String sql2 = "select * from acd_income where Date1 LIKE '"+date+"%' ";
                        pst2 = dbc.con.prepareStatement(sql2);
                        rs2=pst2.executeQuery();

                        while(rs2.next()){
                   
                       String Date_1 = rs2.getString("Date1");
                       String income_1 = rs2.getString("Amount");
                       model1.addRow(new Object[]{Date_1,income_1});
                       count2++;
                   }
                        if(count2==0){
                    JOptionPane.showMessageDialog(null, "No record found","Error",JOptionPane.ERROR_MESSAGE);
                    txt_date.setText("");
                }  
                   
              // }
               
           }
           else if(cmb_inc.getSelectedItem().toString() =="Inventory")
           {
//               while(rs3.next())
//               {
//                        String date_1 = rs3.getString("Date1");
//                        String date_2 = date_1.substring(0, 7);

                        String sql3 = "select * from inv_exp where Date1 LIKE '"+date+"%' ";
                        pst1 = dbc.con.prepareStatement(sql3);
                        rs1=pst1.executeQuery();

                        while(rs1.next()){
                   
                       String Date_1 = rs1.getString("Date1");
                       String income_1 = rs1.getString("Amount");
                       model2.addRow(new Object[]{Date_1,income_1});
                       count3++;
                   
                   }
                        if(count3==0){
                    JOptionPane.showMessageDialog(null, "No record found","Error",JOptionPane.ERROR_MESSAGE);
                    txt_date.setText("");
                }  
                   
               //}
               
           }
           else if(cmb_inc.getSelectedItem().toString() =="Salary")
           {
//               while(rs4.next())
//               {
                        String date_1 = rs4.getString("Date1");
                        String date_2 = date_1.substring(0, 7);

                        String sql1 = "select * from salary_exp where Date1 LIKE '"+date+"%' ";
                        pst1 = dbc.con.prepareStatement(sql1);
                        rs1=pst1.executeQuery();

                        while(rs1.next()){
                   
                       String Date_1 = rs1.getString("Date1");
                       String income_1 = rs1.getString("Amount");
                       model2.addRow(new Object[]{Date_1,income_1});
                       count4++;
                   }
                        if(count4==0){
                    JOptionPane.showMessageDialog(null, "No record found","Error",JOptionPane.ERROR_MESSAGE);
                    txt_date.setText("");
                }  
                   
               //}
               
           }
               
                
        
        
        
        
        }
        
        catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
        
        
    }//GEN-LAST:event_btn_ok2ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
        
//        profit pro = new profit();
//        pro.dispose();
        
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String year = cmb_year.getSelectedItem().toString();
        String month = cmb_month.getSelectedItem().toString();
        String income = txt_income.getText();
        String expense = txt_expense.getText();
        
        String sql ="select * from inc_exp where Year='"+year+"' and Month = '"+month+"'";
        
        try{
        
            pst = dbc.con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                
                String year1= rs.getString("Year");
                String month1= rs.getString("Month");
            if(year.equals(year1)&&month.equals(month1)){
                JOptionPane.showMessageDialog(null, "According to thiis date data is already added","Inane error",JOptionPane.ERROR_MESSAGE);
            
            }
            
            else{
            
            String sql1="insert into IncExp values(year,month,income,expense)";
            pst1 = dbc.con.prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            
            }
            
                
            
            }
        
        } 
        
        
        
        catch(Exception e){}
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void graphMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphMouseClicked
        String year = cmb_year.getSelectedItem().toString();
        String month = cmb_month.getSelectedItem().toString();
        String income = txt_income.getText();
        int inc = Integer.parseInt(income);
        String expense = txt_expense.getText();
        int exp = Integer.parseInt(expense);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(inc, "Income and expense(Rupees)", "Income");
        dataset.setValue(exp, "Income and expense(Rupees)", "Expense");
        
        JFreeChart chart = ChartFactory.createBarChart("Income an Expense", year+"-"+month, "Income and Expense", dataset, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot p =chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.blue);
        ChartFrame frame = new ChartFrame("Bar CHart for income and expense", chart);
        frame.setVisible(true);
        frame.setSize(500, 600);
    }//GEN-LAST:event_graphMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        BalanceSheet bs = new BalanceSheet();
        bs.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        profitloss pl = new profitloss();
        pl.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        txt_date.setText("");
        txt_income.setText("");
        txt_expense.setText("");
        txt_1.setText("");
        txt_2.setText("");
        txt_3.setText("");
        txt_4.setText("");
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
        model1.setRowCount(0);
        model2.setRowCount(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       ReportView11 x =new ReportView11("C:\\Users\\ASUSI7\\Desktop\\ireports\\sally1.jasper");
        x.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed


    // </editor-fold>                        

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profit().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok1;
    private javax.swing.JButton btn_ok2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmb_exp;
    private javax.swing.JComboBox<String> cmb_inc;
    private javax.swing.JComboBox<String> cmb_month;
    private javax.swing.JComboBox<String> cmb_year;
    private javax.swing.JLabel graph;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JLabel txt_1;
    private javax.swing.JLabel txt_2;
    private javax.swing.JLabel txt_3;
    private javax.swing.JLabel txt_4;
    private javax.swing.JLabel txt_date;
    private javax.swing.JLabel txt_expense;
    private javax.swing.JLabel txt_income;
    private javax.swing.JLabel txt_loss;
    private javax.swing.JLabel txt_profit;
    // End of variables declaration//GEN-END:variables
}
