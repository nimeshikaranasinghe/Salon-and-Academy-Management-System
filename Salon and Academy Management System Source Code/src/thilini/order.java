/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thilini;

//import invenory_management.test.src.test.*;
//import java.awt.Color;
//import java.awt.Component;
import Classes.MySQLConn;
import Sohan.HomePage;
import Sohan.Login;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import net.proteanit.sql.DbUtils;
import java.util.Date;


public class order extends javax.swing.JFrame {
        
         Connection conn=MySQLConn.ConnectDB();
         PreparedStatement pst=null;
         ResultSet rs=null;
         Statement stmt = null;    
        
                  

    public order() {
        
        initComponents();      
        again_1.setVisible(false);
        again_2.setVisible(false);
        again_3.setVisible(false);
        Confirm_new_Order_buttn.setVisible(false);
        order_details.removeAll();
        TableLoad("SELECT * FROM product",Product_Table);        
        setValuesToCombo("select * from supplier",sup_Combo,"sup_id");
        setValuesToCombo("select * from orders where orderstatus='Pending'",orderCombo,"order_id");
        setValuesToCombo("select * from product",productCombo,"product_id");

    }
    int t=0;
    public void insertTO(){
       // int t =0;
        
        String order_ID=Order_Id.getText();
        String produt_ID=productCombo.getSelectedItem().toString();
        String quantity=Quantity.getText();
        String supplier=sup_Combo.getSelectedItem().toString();
        
        DateFormat datefro= new SimpleDateFormat("yyyy-MM-dd");
        Date daa= new Date();
        String datee= datefro.format(daa);
        
        String orderStatus = "Pending";
        
        String sql2 = "INSERT INTO orders VALUES ('"+order_ID+"','"+datee+"','"+orderStatus+"','"+supplier+"')";
         
        String sql = "INSERT INTO orders_product VALUES('"+order_ID+"','"+produt_ID+"',"+quantity+")";   
         
           if(t==0) {   
             try {
                System.out.println("thilini");
                stmt = conn.createStatement();
                System.out.println("thilini");
                stmt.executeUpdate(sql2);
                System.out.println("thilini");

                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
             t++;
           }
            
            
            try {
                System.out.println("thilini");
                stmt = conn.createStatement();
                System.out.println("thilini");
                stmt.executeUpdate(sql);
                System.out.println("thilini");
                JOptionPane.showMessageDialog(null, "one product added");

                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            
            //orderCombo.removeAllItems();
            //setValuesToCombo("select * from orders",orderCombo,"order_id");
            order_details.removeAll();
            setValuesToCombo("select * from orders",orderCombo,"order_id");
    }
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
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        main_panel = new javax.swing.JPanel();
        side_bar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        again_1 = new javax.swing.JPanel();
        Order_Id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Quantity = new javax.swing.JTextField();
        Add_Product = new javax.swing.JButton();
        Confirm_new_Order_buttn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Product_Table = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        sup_Combo = new javax.swing.JComboBox<>();
        again_3 = new javax.swing.JLabel();
        again_2 = new javax.swing.JLabel();
        productCombo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        order_details = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        orderCombo = new javax.swing.JComboBox<>();
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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(12, 173, 183));
        jLabel1.setText("Order Stock");
        main_panel.add(jLabel1);
        jLabel1.setBounds(320, 160, 190, 29);

        jPanel1.setBackground(new java.awt.Color(12, 173, 183));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        again_1.setBackground(new java.awt.Color(67, 70, 75));

        Order_Id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Order_IdMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Order Id");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Product Id");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Quantity");

        Quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });

        Add_Product.setText("Add");
        Add_Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ProductActionPerformed(evt);
            }
        });

        Confirm_new_Order_buttn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Confirm_new_Order_buttn.setText("Confirm and Submit");
        Confirm_new_Order_buttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirm_new_Order_buttnActionPerformed(evt);
            }
        });

        Product_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product Id", "Product Name", "Brand", "Description", "Unit_Price"
            }
        ));
        jScrollPane2.setViewportView(Product_Table);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Supplier ID");

        sup_Combo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sup_Combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        sup_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sup_ComboActionPerformed(evt);
            }
        });

        again_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        again_3.setForeground(new java.awt.Color(255, 255, 255));
        again_3.setText("To add more select again and add");

        again_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        again_2.setForeground(new java.awt.Color(255, 255, 255));
        again_2.setText("If completed press  confirm and submit");

        productCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));

        javax.swing.GroupLayout again_1Layout = new javax.swing.GroupLayout(again_1);
        again_1.setLayout(again_1Layout);
        again_1Layout.setHorizontalGroup(
            again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(again_1Layout.createSequentialGroup()
                .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(again_1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(again_1Layout.createSequentialGroup()
                                .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sup_Combo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Order_Id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Add_Product))
                            .addComponent(again_3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(again_1Layout.createSequentialGroup()
                        .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(again_1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(Confirm_new_Order_buttn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(again_1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(again_2))
                            .addGroup(again_1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17))))
                        .addGap(0, 483, Short.MAX_VALUE)))
                .addContainerGap())
        );
        again_1Layout.setVerticalGroup(
            again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(again_1Layout.createSequentialGroup()
                .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(again_1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(again_1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Order_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sup_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(30, 30, 30)
                        .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(again_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add_Product))
                        .addGap(18, 18, 18)
                        .addComponent(again_3)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addComponent(again_2)
                .addGap(18, 18, 18)
                .addComponent(Confirm_new_Order_buttn)
                .addGap(64, 64, 64))
        );

        jTabbedPane1.addTab("Add new order", again_1);

        jPanel3.setBackground(new java.awt.Color(67, 70, 75));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        order_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Product ID", "Quantity", "Product ID", "Product Name", "Brand", "Description", "Unit_price"
            }
        ));
        jScrollPane1.setViewportView(order_details);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pending Orders");

        orderCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        orderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select an order" }));
        orderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(orderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(398, 398, 398))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View orders", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main_panel.add(jPanel1);
        jPanel1.setBounds(0, 190, 810, 420);

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
            .addGap(0, 91, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
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

    
 
    public String qw=null;
    private void OrderIdAuto(){
         int highest=0;
        int current=0;
        String sql="select order_id from orders order by order_id desc limit 1";
        try{ 
                  stmt = conn.createStatement();
                  rs = stmt.executeQuery(sql);
                  
                  if(rs.next()){
                       qw=rs.getString("order_id");
                        current=Integer.parseInt(qw.substring(3));
                       if(current>highest)
                           highest=current;
                  }                
                 
                
                        
       }catch(SQLException | HeadlessException e){
           
        }
        highest=highest+1;
        if(qw==null)
            Order_Id.setText("ORD1");
        else
        {
           
            Order_Id.setText("ORD"+highest);
           
        }
    }
    
    
    /* private void AutoFill(){
        
        String supID;
        supID=sup_id.getText();
        String sql="select * from supplier where sup_id='"+supID+"'";
        try{ 
                  stmt = conn.createStatement();
                  rs = stmt.executeQuery(sql);
                  
                  if(rs.next()){
                      
                       x=rs.getString("sName");
                       y=rs.getNString("email");
                       z=rs.getNString("contact_no");
                  }
                 sup_name.setText(x);
                 email.setText(y);
                 contact_no.setText(z);
                 
                 System.out.println(a);
                        
       }catch(SQLException | HeadlessException e){
           
        }

     }*/


    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
    }//GEN-LAST:event_formWindowOpened

    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityActionPerformed

    private void Order_IdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Order_IdMouseClicked
         OrderIdAuto();
        
    }//GEN-LAST:event_Order_IdMouseClicked

    private void Add_ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ProductActionPerformed
        
        String id= Order_Id.getText();
        again_1.setVisible(true);
        again_2.setVisible(true);
        again_3.setVisible(true);
        Confirm_new_Order_buttn.setVisible(true);
        insertTO();
    }//GEN-LAST:event_Add_ProductActionPerformed

    private void sup_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sup_ComboActionPerformed
        
    }//GEN-LAST:event_sup_ComboActionPerformed

    private void orderComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderComboActionPerformed
        String orderID= orderCombo.getSelectedItem().toString();
        TableLoad("SELECT * FROM orders_product,product where orders_product.product_id=product.product_id and orders_product.order_id='"+orderID+"'", order_details);
    }//GEN-LAST:event_orderComboActionPerformed

    private void Confirm_new_Order_buttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confirm_new_Order_buttnActionPerformed
        order nn = new order();
        this.hide();
        nn.show();
        
        
    }//GEN-LAST:event_Confirm_new_Order_buttnActionPerformed

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

        Home_inventory home = new Home_inventory();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Product;
    private javax.swing.JButton Confirm_new_Order_buttn;
    private javax.swing.JTextField Order_Id;
    private javax.swing.JTable Product_Table;
    private javax.swing.JTextField Quantity;
    private javax.swing.JPanel again_1;
    private javax.swing.JLabel again_2;
    private javax.swing.JLabel again_3;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbl_grn;
    private javax.swing.JLabel lbl_order;
    private javax.swing.JLabel lbl_product;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JLabel lbl_supplier;
    private javax.swing.JPanel main_panel;
    private javax.swing.JComboBox<String> orderCombo;
    private javax.swing.JTable order_details;
    private javax.swing.JComboBox<String> productCombo;
    private javax.swing.JPanel side_bar;
    private javax.swing.JComboBox<String> sup_Combo;
    private javax.swing.JPanel top_panel;
    // End of variables declaration//GEN-END:variables
    
    
}