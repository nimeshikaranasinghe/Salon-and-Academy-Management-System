
package thilini;

import Classes.MySQLConn;
import Sohan.HomePage;
import Sohan.Login;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class Good_Recieved_Note extends javax.swing.JFrame {

    
    Connection conn=MySQLConn.ConnectDB();
    PreparedStatement pst=null;
    ResultSet rs=null;
    Statement stmt = null;
    
    
    public Good_Recieved_Note() {
        initComponents();
        exlabel.setVisible(false);
        ProductCombo.setVisible(false);
        expdate.setVisible(false);
        ExpAdd.setVisible(false);
        Quantitylabel.setVisible(false);
        Quantity.setVisible(false);
        
        setValuesToCombo("select * from orders where orderstatus='Pending'",orderCombo,"order_id");

        
        
    

        try {
             new Thread(new Runnable() {

            @Override
            public void run() {
                Date d = new Date();
                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

                String s2 = sd.format(d);
                jLabel20.setText(s2);

            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Date d = new Date();
                    String s = d.toString();
                    String ar[] = s.split(" ");
                    jLabel21.setText(ar[3]);

                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }).start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        side_bar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        GRN_No = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        orderCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        GRN_Submit_btn = new javax.swing.JButton();
        Discount = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Amount = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        order_details = new javax.swing.JTable();
        expdate = new datechooser.beans.DateChooserCombo();
        ProductCombo = new javax.swing.JComboBox();
        exlabel = new javax.swing.JLabel();
        ExpAdd = new javax.swing.JButton();
        Quantity = new javax.swing.JTextField();
        Quantitylabel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_supplier = new javax.swing.JLabel();
        lbl_grn = new javax.swing.JLabel();
        lbl_product = new javax.swing.JLabel();
        lbl_stock = new javax.swing.JLabel();
        lbl_order = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
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

        side_bar.setBackground(new java.awt.Color(12, 173, 183));
        side_bar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                side_barMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        main_panel.add(side_bar);
        side_bar.setBounds(810, 50, 270, 560);

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
        jPanel8.setBounds(-10, 610, 1090, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(67, 70, 75));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setText("GRN No");

        jLabel10.setText("Date");

        jLabel11.setText("Time");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GRN_No, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GRN_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel21))
                .addContainerGap())
        );

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Order Id");

        orderCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        orderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select order Id" }));
        orderCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderComboMouseClicked(evt);
            }
        });
        orderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(orderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 40, 810, 111);

        jLabel5.setBackground(new java.awt.Color(12, 173, 183));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(12, 173, 183));
        jLabel5.setText("Good Recieved Note");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(290, 0, 250, 40);

        GRN_Submit_btn.setText("Submit GRN");
        GRN_Submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GRN_Submit_btnActionPerformed(evt);
            }
        });
        jPanel2.add(GRN_Submit_btn);
        GRN_Submit_btn.setBounds(480, 410, 106, 23);
        jPanel2.add(Discount);
        Discount.setBounds(580, 320, 89, 20);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Net Discount %");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(440, 320, 120, 17);

        Amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AmountMouseEntered(evt);
            }
        });
        jPanel2.add(Amount);
        Amount.setBounds(580, 350, 89, 20);

        jLabel29.setText("jLabel29");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(430, 70, 40, 14);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Amount");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(440, 350, 80, 20);

        order_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "product ID", "Quantity", "Product ID", "Product Name", "Brand", "Description", "Unit Price"
            }
        ));
        jScrollPane2.setViewportView(order_details);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(0, 170, 810, 130);
        jPanel2.add(expdate);
        expdate.setBounds(250, 330, 155, 20);

        ProductCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        ProductCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductComboActionPerformed(evt);
            }
        });
        jPanel2.add(ProductCombo);
        ProductCombo.setBounds(140, 330, 90, 20);

        exlabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exlabel.setText("Expiry Date");
        jPanel2.add(exlabel);
        exlabel.setBounds(10, 330, 110, 22);

        ExpAdd.setText("Add");
        ExpAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpAddActionPerformed(evt);
            }
        });
        jPanel2.add(ExpAdd);
        ExpAdd.setBounds(140, 410, 70, 23);
        jPanel2.add(Quantity);
        Quantity.setBounds(140, 380, 80, 20);

        Quantitylabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Quantitylabel.setText("Quantity");
        jPanel2.add(Quantitylabel);
        Quantitylabel.setBounds(60, 380, 70, 17);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 810, 460);

        jPanel12.setBackground(new java.awt.Color(67, 70, 75));

        lbl_supplier.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl_supplier.setForeground(new java.awt.Color(255, 255, 255));
        lbl_supplier.setText("Supplier");
        lbl_supplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_supplierMouseClicked(evt);
            }
        });

        lbl_grn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl_grn.setForeground(new java.awt.Color(255, 255, 255));
        lbl_grn.setText("Good Recieved Note");
        lbl_grn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_grn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_grnMouseClicked(evt);
            }
        });

        lbl_product.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl_product.setForeground(new java.awt.Color(255, 255, 255));
        lbl_product.setText("Product");
        lbl_product.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productMouseClicked(evt);
            }
        });

        lbl_stock.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl_stock.setForeground(new java.awt.Color(255, 255, 255));
        lbl_stock.setText("Stock");
        lbl_stock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_stockMouseClicked(evt);
            }
        });

        lbl_order.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl_order.setForeground(new java.awt.Color(255, 255, 255));
        lbl_order.setText("Order");
        lbl_order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_orderMouseClicked(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(12, 173, 183));
        jPanel11.setPreferredSize(new java.awt.Dimension(190, 3));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(lbl_grn)
                        .addGap(93, 93, 93)
                        .addComponent(lbl_product)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(lbl_supplier)
                        .addGap(123, 123, 123)
                        .addComponent(lbl_stock)
                        .addGap(106, 106, 106)
                        .addComponent(lbl_order)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_grn)
                    .addComponent(lbl_product)
                    .addComponent(lbl_supplier)
                    .addComponent(lbl_stock)
                    .addComponent(lbl_order, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        main_panel.add(jPanel12);
        jPanel12.setBounds(0, 50, 810, 100);

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
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1075, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1075, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void setValuesToCombo(String s,JComboBox combo,String idColName){
        try {    
            
            String SQL = (s);
            pst = conn.prepareStatement(SQL);
            rs=pst.executeQuery();     
            
            while(rs.next()){
                combo.addItem(rs.getString(idColName));                
            }
            //table.setModel(DbUtils.resultSetToTableModel(rs));       
            
        }
        catch (Exception e){            
        }
    }

    
    private void TableLoad(String s,JTable table) {
        
         try {  
             
            String SQL = (s);
            pst = conn.prepareStatement(SQL);
            rs=pst.executeQuery();       
            table.setModel(DbUtils.resultSetToTableModel(rs));       
            
        }
        catch (Exception e){
            
        }
         
    }
    
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
    }//GEN-LAST:event_formWindowOpened
    String qw1=null;
    String stockId=null;
    private void GRN_Submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GRN_Submit_btnActionPerformed
        System.out.println("0mmmmm");
        String GrnNo=GRN_No.getText();
        String orderID= orderCombo.getSelectedItem().toString();
        DateFormat datefro= new SimpleDateFormat("yyyy-MM-dd");
        Date daa= new Date();
        String datee= datefro.format(daa);
        int Amnt=Integer.parseInt(Amount.getText());
        System.out.println("1");
        String sql1="update orders set orderstatus='Received' where order_id ='"+orderID+"'";
        try{
            pst=conn.prepareStatement(sql1);
            System.out.println("thilini");
            pst.execute();
        }catch(Exception e){        
        }
        String sql2 ="insert into grn values('"+GrnNo+"','"+datee+"','"+orderID+"',"+Amnt+")";
        try{
            pst=conn.prepareStatement(sql2);
            System.out.println("thilini");
            pst.execute();
        }catch(Exception e){        
        }
        
        int highest=0;
        int current=0;
        
        String sql="select * from stock";
        try{ 
            
                  stmt = conn.createStatement();
                  rs = stmt.executeQuery(sql);
                  
                  while(rs.next()){
                       qw1=rs.getString("stock_id");
                       current=Integer.parseInt(qw.substring(3));
                       
                       if(current>highest)
                           highest=current;
                  }                
                  System.out.println(a);                        
       }catch(SQLException | HeadlessException e){       
       }     
        highest=highest+1;
       System.out.println(highest);
         if(qw1==null)
            stockId="STK1";
        else{
            stockId="STK"+Integer.toString(highest+1);
        }
       
         
       String sql4="insert into stock values ('"+stockId+"','"+datee+"')";
        try{
            pst=conn.prepareStatement(sql4);
            System.out.println("thilini");
            pst.execute();
        }catch(Exception e){        
        }
        
        exlabel.setVisible(true);
        expdate.setVisible(true);
        ExpAdd.setVisible(true);
        Quantitylabel.setVisible(true);
        Quantity.setVisible(true);
        
        
        setValuesToCombo("select * from orders_product where order_id='"+orderID+"'",ProductCombo,"product_id");
         ProductCombo.setVisible(true);
        
        
        
    }//GEN-LAST:event_GRN_Submit_btnActionPerformed

    
    
    
    private void side_barMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_barMouseClicked

    }//GEN-LAST:event_side_barMouseClicked

    private void orderComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderComboMouseClicked
            
    }//GEN-LAST:event_orderComboMouseClicked

    private void orderComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderComboActionPerformed
        GRNAuto();
        String orderID= orderCombo.getSelectedItem().toString();
       TableLoad("SELECT * FROM orders_product,product where orders_product.product_id=product.product_id and orders_product.order_id='"+orderID+"'", order_details);
    }//GEN-LAST:event_orderComboActionPerformed

    private void AmountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmountMouseEntered
        String orderID= orderCombo.getSelectedItem().toString();
        int amount=0;
        int discount= Integer.parseInt(Discount.getText());
        String sql = "SELECT * FROM orders_product,product where orders_product.product_id=product.product_id and orders_product.order_id='"+orderID+"'";
          try {  
             
            
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();  
            while(rs.next()){
                amount=amount+(Integer.parseInt(rs.getString("Unit_Price")))*Integer.parseInt(rs.getString("quantity"));
            }
                  
            
        }
        catch (Exception e){
            
        }
       Amount.setText(Integer.toString(amount*(100-discount)/100));
    }//GEN-LAST:event_AmountMouseEntered

    private void ProductComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductComboActionPerformed

    private void ExpAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpAddActionPerformed
       String date=expdate.getText();
       String day=null;
       String month=null;
       String year = null;
        StringTokenizer bb =new StringTokenizer(date,"/");
        while(bb.hasMoreElements()){
            day=bb.nextToken();
            month=bb.nextToken();
            year = bb.nextToken();
        }
        
       String prd = ProductCombo.getSelectedItem().toString();
       int quantity =  Integer.parseInt(Quantity.getText());
        String sql4="insert into stock_product values ('"+stockId+"','"+prd+"',"+quantity+",'"+"20"+year+"-"+day+"-"+month+"')";
        System.out.println(sql4);
        try{
            pst=conn.prepareStatement(sql4);
            System.out.println("thilini");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Product added to the Stock successfully");
            
        }catch(SQLException | HeadlessException e){        
        }
        
       
    }//GEN-LAST:event_ExpAddActionPerformed

    private void lbl_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_supplierMouseClicked
        new Supplier_inventory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_supplierMouseClicked

    private void lbl_grnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_grnMouseClicked
        new Good_Recieved_Note().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_grnMouseClicked

    private void lbl_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_productMouseClicked
        new product_registry().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_productMouseClicked

    private void lbl_stockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_stockMouseClicked
        new Stock().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_stockMouseClicked

    private void lbl_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_orderMouseClicked
        new order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_orderMouseClicked

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

     
    public int a;
    public String qw=null;
    public String qv=null;
    
    private void GRNAuto(){
        int highest=0;
        int current=0;
        String sql="select GRN_No from grn";
        try{ 
                  stmt = conn.createStatement();
                  rs = stmt.executeQuery(sql);
                  
                  while(rs.next()){
                       qw=rs.getString("GRN_No");
                        current=Integer.parseInt(qw.substring(3));
                       if(current>highest)
                           highest=current;
                  }
                 
                 
                 System.out.println(a);
                        
       }catch(SQLException | HeadlessException e){
           
        }
        highest=highest+1;
        if(qw==null)
            GRN_No.setText("GRN1");
        else
        {
            a=Integer.parseInt(qw.substring(3))+1;
            GRN_No.setText("GRN"+highest);
        }
    }
    
   
    

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
            java.util.logging.Logger.getLogger(Good_Recieved_Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Good_Recieved_Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Good_Recieved_Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Good_Recieved_Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Good_Recieved_Note().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JTextField Discount;
    private javax.swing.JButton ExpAdd;
    private javax.swing.JTextField GRN_No;
    private javax.swing.JButton GRN_Submit_btn;
    private javax.swing.JComboBox ProductCombo;
    private javax.swing.JTextField Quantity;
    private javax.swing.JLabel Quantitylabel;
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel exlabel;
    private datechooser.beans.DateChooserCombo expdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_grn;
    private javax.swing.JLabel lbl_order;
    private javax.swing.JLabel lbl_product;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JLabel lbl_supplier;
    private javax.swing.JPanel main_panel;
    private javax.swing.JComboBox<String> orderCombo;
    private javax.swing.JTable order_details;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    // End of variables declaration//GEN-END:variables


}