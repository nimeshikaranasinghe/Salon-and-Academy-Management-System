
package thilini;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import Classes.*;
import Sohan.HomePage;
import Sohan.Login;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jdesktop.xswingx.PromptSupport;


public class Supplier_inventory extends javax.swing.JFrame {
    
         Connection conn=MySQLConn.ConnectDB();
         PreparedStatement pst=null;
         ResultSet rs=null;
         Statement stmt = null;
         
         
         
         
   
    public Supplier_inventory() {
        
        initComponents();
        TableLoad("select * from supplier");
        clearText();
        search();
       // notf1_name.setText("Soiyeah");
       // notf1.setVisible(true);
        
        
    }
    
   
    
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
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
        jLabel11 = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        Name = new javax.swing.JTextField();
        Company = new javax.swing.JTextField();
        NIC = new javax.swing.JTextField();
        Tel_No = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        Sup_ID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        search_txt = new javax.swing.JTextField();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("     SUPPLIER DETAILS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Sup ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Company");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("NIC");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Tel No");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Email");

        ADD.setText("ADD");
        ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDMouseClicked(evt);
            }
        });
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameMouseClicked(evt);
            }
        });
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        Company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompanyActionPerformed(evt);
            }
        });

        NIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NICActionPerformed(evt);
            }
        });

        Tel_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tel_NoActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Address");

        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });

        Sup_ID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sup_IDMouseClicked(evt);
            }
        });
        Sup_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sup_IDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ADD)
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4)
                            .addComponent(jLabel20)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Tel_No, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(Company)
                                .addComponent(Name)
                                .addComponent(NIC, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                            .addComponent(Sup_ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Sup_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Company, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(NIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Tel_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(ADD)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 240, 460);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sup_Id", "Name", "Company", "NIC", "Email", "Tel_No", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(240, 110, 570, 280);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(12, 173, 183));
        jLabel13.setText("SUPPLIER REGISTRY");

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
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(search_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(250, 0, 560, 110);

        delete_btn.setText("DELETE");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        jPanel2.add(delete_btn);
        delete_btn.setBounds(520, 400, 100, 23);

        update_btn.setText("UPDATE");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        jPanel2.add(update_btn);
        update_btn.setBounds(651, 400, 100, 23);

        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(410, 400, 90, 23);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
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
            .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1075, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
     //   notf1.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

   
    
    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        
    }//GEN-LAST:event_NameActionPerformed

    private void NICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NICActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        
        //supplier id validation
        if(Sup_ID.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Set Supplier Id");
           Sup_ID.requestFocus();
            return;    
        }
        //name validation
       if(Name.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter supplier's name"); 
            Name.requestFocus();
            return;  
            }
       
     //brand validation
        if(Company.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter company name"); 
            Company.requestFocus();
            return;  
            }
        
        //NIC validation
         //nic validation
         if (NIC.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter NIC"); 
            NIC.requestFocus();
            return;
        }
        
        if (NIC.getText().length() != 10)
        {
            JOptionPane.showMessageDialog(null, "Invalid NIC"); 
            NIC.requestFocus();
            return;
        }
        
         if(NIC.getText().charAt(9) != 'v')  
        {
            if(NIC.getText().charAt(9) !='V')
            {
            JOptionPane.showMessageDialog(null, "Invalid NIC"); 
            NIC.requestFocus();
            return;
            }
        }
         //tel non validation
          if (Tel_No.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Tel No"); 
            NIC.requestFocus();
            return;
            
        }
         
        if((Tel_No.getText().length() > 10) || (Tel_No.getText().length() < 10)){
        
            JOptionPane.showMessageDialog(null, "Invalid Telephone number"); 
            NIC.requestFocus();
            return;
        }
       //email validation 
        if(Email.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Email address"); 
            Email.requestFocus();
            return;  
            }
        //address validation
        if(Address.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Address"); 
            Address.requestFocus();
            return;  
            }
        
        
        String address = Address.getText();
        String company = Company.getText();
        String email=Email.getText();
        String nic= NIC.getText();
        String name= Name.getText();
        
        String sup_id= Sup_ID.getText();
        //int sid =Integer.parseInt(sup_id);
        
        String tel_no= Tel_No.getText();
        
        System.out.println(nic+address+company+email+name+sup_id+tel_no);
        
        /* PreparedStatement pstmt = null;
         Statement stmt =null;
            ResultSet rs = null;
            Connection conn =MySQLConn.ConnectDB();*/
            /*
                name varchar(25)," +
                    "	company varchar(25)," +
                    "	contact_no char(10)," +
                    "	nic char(10) unique not null," +
                    "	email varchar(50)," +
                    "	address varchar(100)," 
            */
            
           String sql = "INSERT INTO supplier(sup_id,sName,company,contact_no,nic,email,address) "
                   + "VALUES('"+sup_id+"','"+name+"','"+company+"','"+nic+"','"+tel_no+"','"+email+"','"+address+"')";   
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
            TableLoad("select * from supplier");
           
    }//GEN-LAST:event_ADDActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
         
        
        String sql="DELETE FROM supplier where sup_id =?";
        
        try{
                pst=conn.prepareStatement(sql);
                pst.setString(1, Sup_ID.getText());
                pst.execute();
                System.out.println("Thilini");
            
                
                JOptionPane.showMessageDialog(null, "Supplier Deleted");
            
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
         clearText();
         TableLoad("select * from supplier");
        
        
    }//GEN-LAST:event_delete_btnActionPerformed

    private void CompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompanyActionPerformed

    private void Tel_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tel_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tel_NoActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
       
    }//GEN-LAST:event_AddressActionPerformed

    private void ADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDMouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseReleased

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
      
            String address = Address.getText();
            String company = Company.getText();
            String email=Email.getText();
            String nic= NIC.getText();
            String name= Name.getText();
            
            String sup_id= Sup_ID.getText();
            //int sid =Integer.parseInt(sup_id);
            
            String tel_no= Tel_No.getText();
           
          
            String sql = "update supplier set sup_id='"+sup_id+"',SName='"+name+"',company='"+company+"',contact_no='"+tel_no+"',nic='"+nic+"',email='"+email+"', address='"+address+"'where sup_id='"+sup_id+"'";
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
       TableLoad("select * from supplier");
       
    }//GEN-LAST:event_update_btnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel dtm =(DefaultTableModel)jTable1.getModel();
        int rowindex=jTable1.getSelectedRow();
        
        Sup_ID.setText(dtm.getValueAt(rowindex, 0).toString());
        Name.setText(dtm.getValueAt(rowindex, 1).toString());
        Company.setText(dtm.getValueAt(rowindex, 2).toString());
        NIC.setText(dtm.getValueAt(rowindex, 3).toString());
        Tel_No.setText(dtm.getValueAt(rowindex, 4).toString());
        Email.setText(dtm.getValueAt(rowindex, 5).toString());
        Address.setText(dtm.getValueAt(rowindex, 6).toString());
    }//GEN-LAST:event_jTable1MouseClicked
    
    
    public int a;
    public String qw=null;
    
    
    private void supplierAuto(){
    
        int highest=0;
        int current=0;
        String sql="select * from supplier";
        try{ 
                  stmt = conn.createStatement();
                  rs = stmt.executeQuery(sql);
                  
                  while(rs.next()){
                       qw=rs.getString("sup_id");
                        current=Integer.parseInt(qw.substring(3));
                       if(current>highest)
                           highest=current;
                  }
                 
                 
                 System.out.println(a);
                        
       }catch(SQLException | HeadlessException e){
           
        }
        highest=highest+1;
        if(qw==null)
            Sup_ID.setText("SUP1");
        else
        {
            a=Integer.parseInt(qw.substring(3))+1;
            Sup_ID.setText("SUP"+highest);
        }
    }
    private void NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMouseClicked
        supplierAuto();
    }//GEN-LAST:event_NameMouseClicked

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
         DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
       
            String sql="select * from supplier where sName like '"+search_txt.getText()+"%'"
                    + "||sup_id like '"+search_txt.getText()+"%'"
                    + "||company like '"+search_txt.getText()+"%'"
                    + "||address like '"+search_txt.getText()+"%'";
            TableLoad(sql);
            
    }//GEN-LAST:event_search_txtKeyReleased

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TableLoad("select * from supplier");
        clearText();
        
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void Sup_IDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sup_IDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Sup_IDMouseClicked

    private void Sup_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sup_IDActionPerformed
        supplierAuto();
    }//GEN-LAST:event_Sup_IDActionPerformed

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
            java.util.logging.Logger.getLogger(Supplier_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier_inventory().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField Address;
    private javax.swing.JTextField Company;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField NIC;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Sup_ID;
    private javax.swing.JTextField Tel_No;
    private javax.swing.JButton btn_back;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_grn;
    private javax.swing.JLabel lbl_order;
    private javax.swing.JLabel lbl_product;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JLabel lbl_supplier;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField search_txt;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables

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

    private void clearText() {
        
        Sup_ID.setText("");
        Name.setText("");
        Company.setText("");
        NIC.setText("");
        Tel_No.setText("");
        Email.setText("");
        Address.setText("");
        
    }
    
    

    private void search() {
        
        PromptSupport.setPrompt("Search here..", search_txt);
        
    }

 
    
    
}