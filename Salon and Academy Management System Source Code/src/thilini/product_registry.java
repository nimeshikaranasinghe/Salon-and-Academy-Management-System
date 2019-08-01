
package thilini;

import Classes.MySQLConn;
import Sohan.HomePage;
import Sohan.Login;
import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.xswingx.PromptSupport;


public class product_registry extends javax.swing.JFrame {
    
        Connection conn=MySQLConn.ConnectDB();
         PreparedStatement pst=null;
         ResultSet rs=null;
         Statement stmt = null;
         // private BufferedImage image;

    public product_registry() {
        
        initComponents();
        
        clearText();
        TableLoad("select* from product");
        search();
        System.out.println("1");
      
        

        
     
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        brand = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        Add = new javax.swing.JButton();
        product_id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        search_txt = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
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

        jPanel1.setBackground(new java.awt.Color(12, 173, 183));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("     Product Registry Details");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Priduct ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Product Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Brand");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Descrption");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Price");

        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandActionPerformed(evt);
            }
        });

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        description.setColumns(20);
        description.setRows(5);
        jScrollPane2.setViewportView(description);

        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        product_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_idMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(product_id, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(Add)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(product_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(Add)
                .addGap(33, 33, 33))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 250, 460);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product_ID", "Product Name", "Brand", "Description", "Unit Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(250, 110, 560, 240);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(12, 173, 183));
        jLabel11.setText("PRODUCT REGISTRY");

        jButton3.setText("View All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        search_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_txtActionPerformed(evt);
            }
        });
        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jButton3))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(search_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(250, 0, 560, 110);

        jButton12.setText("UPDATE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(380, 420, 100, 23);

        delete_btn.setText("DELETE PRODUCT");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        jPanel2.add(delete_btn);
        delete_btn.setBounds(509, 420, 140, 23);

        jButton14.setText("REFRESH");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(670, 420, 100, 23);

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
            .addGap(0, 97, Short.MAX_VALUE)
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
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        
    }//GEN-LAST:event_formWindowOpened

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
          
        String sql="DELETE FROM product where Product_ID =?";
        
        try{
                pst=conn.prepareStatement(sql);
                pst.setString(1, product_id.getText());
                pst.execute();
                System.out.println("Thilini");
            
                
                JOptionPane.showMessageDialog(null, "Product Deleted");
            
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
         clearText();
         TableLoad("select* from product");
        
        
    }//GEN-LAST:event_delete_btnActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        
        //product id validation
        if(product_id.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Set Product Id");
           product_id.requestFocus();
            return;    
        }
        //name validation
       if(name.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter product name"); 
            name.requestFocus();
            return;  
            }
       
     //brand validation
        if(brand.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter brand name"); 
            brand.requestFocus();
            return;  
            }
       //price validation 
        if(price.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter price"); 
            price.requestFocus();
            return;  
            }
        
        
        String Product_ID = product_id.getText();
        String Name = name.getText();
        String Brand=brand.getText();
        String Description= description.getText();
        String Unit_Price= price.getText();
        
        String sql = "INSERT INTO product(Product_ID ,pName,Brand,Description,Unit_Price) "
                    + "VALUES('"+Product_ID+"','"+Name+"','"+Brand+"','"+Description+"','"+Unit_Price+"')";   
            System.out.println(sql);
                       
            try {
                System.out.println("thilini");
                stmt = conn.createStatement();
                System.out.println("thilini");
                stmt.executeUpdate(sql);
                System.out.println("thilini");
                
                 clearText();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            TableLoad("select* from product");    
            
           JOptionPane.showMessageDialog(null,"Barcode generated in Desktop");
    }//GEN-LAST:event_AddActionPerformed

    private void brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         DefaultTableModel dtm =(DefaultTableModel)jTable1.getModel();
        int rowindex=jTable1.getSelectedRow();
        
        product_id.setText(dtm.getValueAt(rowindex, 0).toString()); //now
        name.setText(dtm.getValueAt(rowindex, 1).toString());
        brand.setText(dtm.getValueAt(rowindex, 2).toString());
        description.setText(dtm.getValueAt(rowindex, 3).toString());
        price.setText(dtm.getValueAt(rowindex, 4).toString());
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       TableLoad("select* from product");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        clearText();
        TableLoad("select* from product");
    }//GEN-LAST:event_jButton14ActionPerformed

    
    
        
    public int a;
    String qw=null;
    private void ProductAuto(){
        //int a;
        int highest=0;
        int current=0;
        String sql="select * from product";
        try{ 
            
                  stmt = conn.createStatement();
                  rs = stmt.executeQuery(sql);
                  
                  while(rs.next()){
                       qw=rs.getString("product_id");
                       current=Integer.parseInt(qw.substring(3));
                       
                       if(current>highest)
                           highest=current;
                  }                
                  System.out.println(a);                        
       }catch(SQLException | HeadlessException e){       
       }     
        highest=highest+1;
       System.out.println(highest);
         if(rs==null)
            product_id.setText("PRD1");
        else{
            product_id.setText("PRD"+highest);
        }
       
    }
    
    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        
            String id = product_id.getText();
            
            BarCode barcode = new BarCode();
            System.out.println("2");
            barcode.setCodeToEncode(id);
            System.out.println("3");
            barcode.setSymbology(IBarCode.CODE128);
            System.out.println("4");
            barcode.setX(2);
            barcode.setY(50);
            barcode.setRightMargin(0);
            barcode.setLeftMargin(0);
            barcode.setTopMargin(0);
            barcode.setBottomMargin(0);
            System.out.println("5");
            barcode.setChecksumEnabled(false);
            barcode.setFnc1(IBarCode.FNC1_NONE);
            System.out.println("6");
            try
            {
                System.out.println("7");
                
            barcode.draw("C:\\Users\\ASUSI7\\Desktop\\"+id+".gif");
            System.out.println("8");
            }
            catch (Exception e) {
            e.printStackTrace();
            }
        
    }//GEN-LAST:event_nameMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
         
            String Pid = product_id.getText();
            String Name = name.getText();
            String Brand=brand.getText();
            String Description= description.getText();
            String Price= price.getText();
            
          
           
            String sql = "update product set Product_ID='"+Pid+"',Name='"+Name+"',Brand='"+Brand+"',Description='"+Description+"',Unit_Price='"+Price+"' where Product_ID='"+Pid+"'";
            System.out.println("thilini");
              try{ 
                  pst=conn.prepareStatement(sql);
                  System.out.println("thilini");
                  pst.execute();
                 
            JOptionPane.showMessageDialog(null, "Table Updated");
            
       }catch(SQLException | HeadlessException e){
           JOptionPane.showMessageDialog(null, e);
        }
       clearText();
       TableLoad("select * from product");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        // try {
            String sql="select * from product where product_id like '"+search_txt.getText()+"%'"
            + "||pName like '"+search_txt.getText()+"%'"
            + "||Brand like '"+search_txt.getText()+"%'"
            + "||Unit_Price like '"+search_txt.getText()+"%'"
            + "||description like '"+search_txt.getText()+"%'";
            TableLoad(sql);
            //while (rs.next()) {
                // Vector v = new Vector();

                /* v.add(rs.getString("sup_id"));
                v.add(rs.getString("sName"));
                v.add(rs.getString("company"));
                v.add(rs.getString("contact_no"));
                v.add(rs.getString("nic"));
                v.add(rs.getString("email"));
                v.add(rs.getString("address"));
                dtm.addRow(v);
            }*/
            //chech tis out

            //} catch (Exception e) {
            //}
    }//GEN-LAST:event_search_txtKeyReleased

    private void product_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_idMouseClicked
        ProductAuto();
    }//GEN-LAST:event_product_idMouseClicked

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
            java.util.logging.Logger.getLogger(product_registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product_registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product_registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product_registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product_registry().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField brand;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextArea description;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_grn;
    private javax.swing.JLabel lbl_order;
    private javax.swing.JLabel lbl_product;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JLabel lbl_supplier;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTextField product_id;
    private javax.swing.JTextField search_txt;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    // End of variables declaration//GEN-END:variables

 

    private void clearText() {
        
        product_id.setText(""); //now
        name.setText("");
        brand.setText("");
        description.setText("");
        price.setText("");
        
    }

    private void TableLoad(String s) {
         try {
            String SQL = (s);
            pst = conn.prepareStatement(SQL);
            rs=pst.executeQuery();
       
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
        catch (Exception e) {
        }
    }

    private void search() {
        PromptSupport.setPrompt("Search here..", search_txt);
    }

   
}
