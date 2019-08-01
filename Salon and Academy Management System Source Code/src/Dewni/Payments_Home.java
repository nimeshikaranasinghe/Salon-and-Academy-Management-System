/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dewni;

import Sohan.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author it15-102560
 */
public class Payments_Home extends javax.swing.JFrame {

    /**
     * Creates new form gui
     */
    
     ResultSet rs;
    PreparedStatement ps;
   // Connection con =null;
    
    DBconnect dbc = new DBconnect();
    public Payments_Home() {
        initComponents();
        Show_Users();
         
    }
    Payment_Student_FILLDATA reg = new Payment_Student_FILLDATA();
    Payments_Students pay = new Payments_Students();
      //-------when click add button data go jtable in another jfram-------------//
    
    String stdid,course,date,type;
    double fee,current,remain;
    
    public Payments_Home(String val1,String val2,double val3,double val4,String val5,String val6,double val7){
    
    initComponents();
        this.stdid = val1;
        this.course = val2;
        this.fee = val3;
        this.current = val4;
        this.type = val5;
        this.date = val6;
        this.remain = val7;
        
         AddDataToTable();
         
                 

    
    }
    
    

    
     void AddDataToTable(){
    
        DefaultTableModel dt = (DefaultTableModel) pay_table.getModel();
        //int f = dt.getRowCount();
        Vector v = new Vector();
            
             v.add(stdid);
             v.add(course);
             v.add(fee);
             v.add(current);
             v.add(type);
             v.add(date);
            v.add(remain);
             
                dt.addRow(v);
    
     }
     
     
     //---------------get values in database---//
    public ArrayList<Payments> getPaymentList(){
    
        ArrayList<Payments> paymentList = new ArrayList<Payments>();
        
        String select = "SELECT * FROM payments";
        
        try{
        
             ps=dbc.con.prepareStatement(select);
             rs=ps.executeQuery();
             Payments payments;
             while(rs.next()){
             
             payments= new Payments(rs.getString("studentId"),rs.getString("course"),rs.getDouble("fullFee"),rs.getDouble("paidAmount"),rs.getString("paymentType"),rs.getString("Date"),rs.getDouble("remainingAmount"));
              paymentList.add(payments);
             }
        
        }
        catch(Exception e){}
        return  paymentList;
    }
    
    //--------------------display data in jtable------//                                                                                                                                                                                                        
    public void Show_Users(){
    ArrayList<Payments> list = getPaymentList();
    DefaultTableModel model =  (DefaultTableModel)pay_table.getModel(); 
    Object[] row = new Object[7];
    
    for(int i = 0 ; i < list.size() ; i++){

    row [0] = list.get(i).getID();
    row [1] = list.get(i).getCourse();
    row [2] = list.get(i).getcourseFee();
    row [3] = list.get(i).getCurrentPayment();
    row [4] = list.get(i).getType();
    row [5] = list.get(i).getDate();
    row [6] = list.get(i). remainAmount();
   
    
    model.addRow(row);
    }
    }
    
       
    
    
    
    
    
    /*------------------ballaa-------------------------*/
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        msg_venue = new javax.swing.JLabel();
        amount3 = new javax.swing.JLabel();
        msg_title = new javax.swing.JLabel();
        msg_description = new javax.swing.JLabel();
        msg_datetime = new javax.swing.JLabel();
        side_bar = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        notf1 = new javax.swing.JPanel();
        notf1_name = new javax.swing.JLabel();
        amount2 = new javax.swing.JLabel();
        amount1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pay_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_idd = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();

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

        top_panel.setBackground(new java.awt.Color(52, 53, 57));
        top_panel.setMinimumSize(getPreferredSize());
        top_panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dewni/images/3.jpg"))); // NOI18N
        jLabel2.setText("Payments");
        top_panel.add(jLabel2);
        jLabel2.setBounds(100, 0, 160, 50);

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("LOGOUT");
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
        top_panel.add(jButton2);
        jButton2.setBounds(986, 9, 79, 32);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dewni/images/MB__home.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        top_panel.add(jLabel3);
        jLabel3.setBounds(920, 10, 50, 40);

        jButton4.setBackground(new java.awt.Color(12, 173, 183));
        jButton4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOGOUT");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        top_panel.add(jButton4);
        jButton4.setBounds(975, 9, 90, 32);

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

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));

        jPanel6.setBackground(new java.awt.Color(12, 173, 183));

        jLabel5.setText("jLabel4");

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dewni/images/add-user-xxl~2.png"))); // NOI18N
        jButton3.setText("Add");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(45, 49));
        jButton3.setMinimumSize(new java.awt.Dimension(45, 49));
        jButton3.setPreferredSize(new java.awt.Dimension(31, 49));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 204, 204));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dewni/images/edit-user-xxl~1.png"))); // NOI18N
        btn_edit.setText("New Payment");
        btn_edit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_edit.setContentAreaFilled(false);
        btn_edit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_edit.setMaximumSize(new java.awt.Dimension(45, 49));
        btn_edit.setMinimumSize(new java.awt.Dimension(45, 49));
        btn_edit.setPreferredSize(new java.awt.Dimension(31, 49));
        btn_edit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dewni/images/reload.png"))); // NOI18N
        jLabel1.setText("Refresh");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(327, 327, 327)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(325, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 810, 100);

        jPanel5.setBackground(new java.awt.Color(59, 62, 67));
        jPanel5.setLayout(null);

        msg_venue.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        msg_venue.setForeground(new java.awt.Color(204, 204, 204));
        msg_venue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg_venue.setText("Hall 2689");
        jPanel5.add(msg_venue);
        msg_venue.setBounds(40, 70, 190, 16);

        amount3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        amount3.setForeground(new java.awt.Color(51, 51, 51));
        amount3.setText("M");
        jPanel5.add(amount3);
        amount3.setBounds(5, 3, 11, 16);

        msg_title.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        msg_title.setForeground(new java.awt.Color(153, 153, 153));
        msg_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg_title.setText("Meeting");
        jPanel5.add(msg_title);
        msg_title.setBounds(40, 8, 190, 18);

        msg_description.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        msg_description.setForeground(new java.awt.Color(204, 204, 204));
        msg_description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg_description.setText("Staff meeting scheduled ");
        jPanel5.add(msg_description);
        msg_description.setBounds(40, 30, 190, 16);

        msg_datetime.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        msg_datetime.setForeground(new java.awt.Color(204, 204, 204));
        msg_datetime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg_datetime.setText("2.45 pm : 12.08.16");
        jPanel5.add(msg_datetime);
        msg_datetime.setBounds(40, 50, 190, 16);

        main_panel.add(jPanel5);
        jPanel5.setBounds(810, 50, 270, 100);

        side_bar.setBackground(new java.awt.Color(12, 173, 183));

        jButton1.setBackground(new java.awt.Color(12, 173, 183));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD CONTACT");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        notf1.setBackground(new java.awt.Color(31, 156, 162));

        notf1_name.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        notf1_name.setForeground(new java.awt.Color(255, 255, 255));
        notf1_name.setText("Eric Reffortson");

        amount2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        amount2.setForeground(new java.awt.Color(255, 255, 255));
        amount2.setText("Fri May 3rd");

        amount1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        amount1.setForeground(new java.awt.Color(255, 255, 255));
        amount1.setText("0770053513");

        javax.swing.GroupLayout notf1Layout = new javax.swing.GroupLayout(notf1);
        notf1.setLayout(notf1Layout);
        notf1Layout.setHorizontalGroup(
            notf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notf1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(notf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amount2)
                    .addComponent(amount1)
                    .addComponent(notf1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        notf1Layout.setVerticalGroup(
            notf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notf1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notf1_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
            .addComponent(notf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_barLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(notf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        main_panel.add(side_bar);
        side_bar.setBounds(810, 150, 270, 460);

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

        pay_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pay_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID ", "Course", "Full Course Payment", "Paid amount", "Payment Type", "Date", "Remaining amount"
            }
        ));
        jScrollPane1.setViewportView(pay_table);

        main_panel.add(jScrollPane1);
        jScrollPane1.setBounds(0, 360, 810, 250);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Student ID :");

        txt_idd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(12, 173, 183));

        jButton6.setBackground(new java.awt.Color(0, 204, 204));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Search");
        jButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton6.setContentAreaFilled(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(45, 49));
        jButton6.setMinimumSize(new java.awt.Dimension(45, 49));
        jButton6.setPreferredSize(new java.awt.Dimension(31, 49));
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel6)
                .addGap(54, 54, 54)
                .addComponent(txt_idd, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        main_panel.add(jPanel1);
        jPanel1.setBounds(60, 160, 540, 180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1075, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
      //  side_bar.setVisible(false);
        
        System.exit(0);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
  
        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
       
        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton2MouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        notf1.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
       Payments_Students phome = new  Payments_Students();
        phome.setVisible(true);
       
      
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed



         int index = pay_table.getSelectedRow();
        TableModel model = pay_table.getModel();
        
        String id = model.getValueAt(index, 0).toString();
        String course = model.getValueAt(index, 1).toString();
        String fee = model.getValueAt(index, 2).toString();
        String last = model.getValueAt(index, 3).toString();
        String type = model.getValueAt(index, 4).toString();
       // String date = model.getValueAt(index, 5).toString();
        
        
        



         reg.setVisible(true);
        //----------
        reg.pack();
        reg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //-----------get the registration form variable names aftre set public//////////
        ///////////////////and set the values to text fields///////////////
        reg.txt_id.setText(id);
        reg.txt_course.setText(course);
        reg.txt_fee.setText(fee);
        reg.txt_lastpay.setText(last);
        reg.txt_type.setText(type);
      //  reg.lbl_date.setText(date);
       
    }//GEN-LAST:event_btn_editActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        DefaultTableModel model = (DefaultTableModel) pay_table.getModel();
        model.setRowCount(0);
        Show_Users();
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
          HomePage home = new   HomePage();
        home.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        String id = txt_idd.getText();
        
        try{
            String ser = "select studentId, course, fullFee, currentPayment, paymentType, Date, remainingAmount from Payments where studentId ='" + id + "'";
            ps = dbc.con.prepareStatement(ser);
            rs =ps.executeQuery();
            System.out.println("success");
            
            if(rs.next()){
            
                System.out.println("inside");
                String stdid = rs.getString("studentId");
                String course = rs.getString("course");
                Double full = rs.getDouble("fullFee");
                Double pay = rs.getDouble("currentPayment");
                String type = rs.getString("paymentType");
                Date date = rs.getDate("Date");
                Double remain = rs.getDouble("remainingAmount");
                
                //----------send values to tabel--------------

                DefaultTableModel model = (DefaultTableModel) pay_table.getModel();
                model.setRowCount(0);
                model.addRow(new Object[]{stdid,course,full,pay,type,date,remain});
                
            
            }
           
        }catch(Exception e){
        
            System.out.println("error");
        
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
     
    }//GEN-LAST:event_btn_editMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        System.out.println("click");

        notf1_name.setText("Soiyeah");
        notf1.setVisible(true);

        /* jPanel5.setBackground(Color.RED);

        amount.setForeground(Color.RED);

        jLabel2.setForeground(new java.awt.Color(210, 189, 25));

        jPanel4.add(lab1);

        JLabel label = new JLabel("Hello StackOverflow!");//Make a label
        jPanel4.add(label);

        pack();

        */

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered

        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Login l = new Login();
        l.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Payments_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payments_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payments_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payments_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Payments_Home().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount1;
    private javax.swing.JLabel amount2;
    private javax.swing.JLabel amount3;
    private javax.swing.JButton btn_back;
    public javax.swing.JButton btn_edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel msg_datetime;
    private javax.swing.JLabel msg_description;
    private javax.swing.JLabel msg_title;
    private javax.swing.JLabel msg_venue;
    private javax.swing.JPanel notf1;
    private javax.swing.JLabel notf1_name;
    private javax.swing.JTable pay_table;
    private javax.swing.JPanel side_bar;
    private javax.swing.JPanel top_panel;
    private javax.swing.JTextField txt_idd;
    // End of variables declaration//GEN-END:variables
}
