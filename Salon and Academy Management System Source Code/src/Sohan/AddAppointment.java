/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sohan;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author it15-102560
 */
public class AddAppointment extends javax.swing.JFrame {


   
    double pricelist [] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    double total = 0.0;
    
    
    void setTime(boolean val)
    {
        
        
        Thread one = new Thread()
        {
            public void run()
            {
                try
                {
        
                    while(val == true)
                    {
                    
                       Thread.sleep(50000);

                       Date d  = new Date();
                   
                       spin_time.setValue(d);
             
                       
                    }
                } 
                
                catch (InterruptedException v)
                {
                    System.out.println(v);
                }               
                
                
            }
        };
        one.start();            // start the thread
        
        

    }
      
//======================== VARIABLES ==============================//     
        
    ResultSet rs;
    ResultSet rs1;
    PreparedStatement pst;  
    Statement st;  
    
    GetDBConnection dbc = new GetDBConnection(); //connect to database
    
    
    int areaCount = 0;                      //to keep track of selected area count
    String areas[] = new String[10];        //array to store selected areas
    List valid = Arrays.asList(areas);      //used to check an array element is empty
    
    
    
    Double discountp = 0.25;
    Double finTotal = 0.0;
    Double discountamnt = 0.0;
    Double discount = 0.0;
    
    
    private String app_id;
    private String fname = "";
    private String lname = "";
    private String phone = "0";
    private String gender = "";
    private String time = "";
    private String date="";
    private String appType;
    private String loyal_id;
    private String status;
    private String price;
    private String t_type;
    private String treat;
    private int empId;
    
        
    
    private boolean newCustomer = true;
    
//==================================================================//    
    
    
    public AddAppointment() {
        
        initComponents();
        

        pnl_Sareas.setEnabled(true);
        aError.setVisible(false);       //cannot add more than 10 areas error
      

        
        idAutoGenerate();
        
        setTime(true);
       
        setSareasInvisible();  
        
    }

    
    
//======make selected areas invisible======================//
    
    
    public void setSareasInvisible()
    {
        pnl_a1.setVisible(false);
        pnl_a2.setVisible(false);
        pnl_a3.setVisible(false);
        pnl_a4.setVisible(false);
        pnl_a5.setVisible(false);
        pnl_a6.setVisible(false);
        pnl_a7.setVisible(false);
        pnl_a8.setVisible(false);
        pnl_a9.setVisible(false);
        pnl_a10.setVisible(false);
        
    }    
    
    
    
 //======Reset areas related feilds and make invisible them =============/
    
    
    public void ResetAreaSuff()
    {
        
        cmb_treat.setSelectedIndex(0);
        pnl_Sareas.setEnabled(false);
        setSareasInvisible(); 
        areaCount = 0;
        aError.setVisible(false);
    }   
    
    
    
    
//======set lables to selected area============================///
    
    
    private void setLables() {
        
        String a1 = cmb_treat.getSelectedItem().toString();
        double price=0.0;
        
        
        String que = "SELECT tId,price FROM treatment WHERE tName = '"+a1+"'";  
                    try 
                    {
                        
                        pst = dbc.con.prepareStatement(que);
                        rs = this.pst.executeQuery();

                        while (rs.next())
                        {
                                
                                price = rs.getDouble(2);  
                             
                        }
                        
                    } 
                    catch (SQLException err)
                    {
                        JOptionPane.showMessageDialog(this, err);
                    }
                    
        
        
        
                
        System.out.println("selected item = "+a1 + "   " + Double.toString(price));
        
        
        if(areaCount <= 10)
        {
            if(!valid.contains(a1))                 //check whether the combo selected item 
            {
                aError.setVisible(false);
                
                if (!pnl_a1.isVisible()) {
                    pnl_a1.setVisible(true);
                    area1.setText(a1);
                }

                else if (!pnl_a2.isVisible()) {
                    pnl_a2.setVisible(true);
                    area2.setText(a1);           
                }
                else if (!pnl_a3.isVisible()) {
                    pnl_a3.setVisible(true);
                    area3.setText(a1);           
                }
                else if (!pnl_a4.isVisible()) {
                    pnl_a4.setVisible(true);
                    area4.setText(a1);           
                }
                else if (!pnl_a5.isVisible()) {
                    pnl_a5.setVisible(true);
                    area5.setText(a1);           
                }
                else if (!pnl_a6.isVisible()) {
                    pnl_a6.setVisible(true);
                    area6.setText(a1);           
                }
                else if (!pnl_a7.isVisible()) {
                    pnl_a7.setVisible(true);
                    area7.setText(a1);           
                }
                else if (!pnl_a8.isVisible()) {
                    pnl_a8.setVisible(true);
                    area8.setText(a1);           
                }
                else if (!pnl_a9.isVisible()) {
                    pnl_a9.setVisible(true);
                    area9.setText(a1);           
                }
                else{
                    pnl_a10.setVisible(true);
                    area10.setText(a1);           
                }
                
                areas[areaCount] = a1;
                pricelist[areaCount] = price;
                areaCount++;
               
            }
            else
            {
                aError.setVisible(true);
                aError.setText("Area has already added");
            }
            
        }
        else
        {
            
            aError.setVisible(true);
            aError.setText("Only 10 areas are allowed at a time");
        }
         
     }
        

    

//================ FILL Category combo box ===================//


    private void fillTypes()
    {
        
        
        
        String st = "SELECT distinct type\n" +
                       "FROM treatment";

        String area;
        int count=0;

        try 
        {
            
                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();

            while(rs.next()) 
            {
                
                 // System.out.println(rs.getString(1));
                
                count++;           
                cmb_t_type.addItem(rs.getString(1));    
                //System.out.println(count);
            }

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }
    }

    

//================ FILL Beauticians combo box ===================//


    public void fillBeauticians()
    {
        
        
        
        String st = "select distinct e.empFName, e.empLName \n" +
                    "from employee e, EmpSpecIn s\n" +
                    "where e.empId = s.empId";


        String fullname="";
        String fname="";
        String lname="";

        try 
        {           
            
                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();

            while(rs.next()) 
            {
                
                fname =  rs.getString(1);
                lname =  rs.getString(2);
                           
                fullname = fname +" "+ lname;
                
                cmb_beautician.addItem(fullname);    

            }

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }
        
    }
    

//================ get EMPID of empName ===================//


    public int getEmpId(String empName)
    {
        
        int id = 0;
        
        String firstWord = empName.split(" ",2)[0];
       
        System.out.println("firstName = "+firstWord);
        
        String st = "select empId\n" +
                    "from employee\n" +
                    "where empFname = '"+firstWord+"' ";


        try 
        {           
            
                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();

            while(rs.next()) 
            {
                
                id =  rs.getInt(1);
   

            }

        } 
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }
        
        return id;
        
    }


    
  //======================= CHECK BIRTHDAY ============================//     
    
    
    
    
    public void calPrice()
    {
    
        
        total = 0.0;
        finTotal = 0.0;
        
        
        for (int c = 0; c < pricelist.length; c++)
        {
            if (pricelist[c] != 0.0) 
            {
                total = pricelist[c]+total;
                continue;
            }
        }
        
        lbl_amount.setText(Double.toString(total)+"0");
        lbl_amount1.setText(Double.toString(total)+"0");
        
        discount = (discountamnt * total);
        lbl_discount.setText(Double.toString(discount));
        
        finTotal = (total - discount);
        lbl_total.setText(Double.toString(finTotal)+"0");
                       
            
    }
    
    
    
    

    
    
//======================= CHECK BIRTHDAY ============================//   
    
    
    public boolean checkBirthday(int phone)
    {
        
        discountamnt = 0.0;
        
        
        boolean birthday = false;
        
        String today = "";
        DateFormat fmt;
        fmt = new SimpleDateFormat("MM-dd");
        Date d = new Date();
        today = fmt.format(d);
        System.out.println("today is " + today);
        
        try
        {
            String st = "SELECT dob\n"
                    + "FROM customer\n"
                    + "WHERE dob LIKE '%" + today + "' and phone LIKE " + phone + "";
            pst = dbc.con.prepareStatement(st);
            rs = pst.executeQuery();
            
            while (rs.next())
            {
                rs.getString(1);
                birthday = true;
                lbl_birthday.setVisible(true);                              
                System.out.println("today is birthday");
            }
            
            
            if(birthday)
            {
                discountamnt = discountp;
            }
                       
        } catch (SQLException err)
        {
            JOptionPane.showMessageDialog(this, err);
        }
        return birthday;   
}    
    
    
    
    
    
    
//======================= ID AUTO GENERATE ==========================//
    
    private void idAutoGenerate()
    {
        String queryid = "SELECT MAX(app_id) FROM Appointment";
        String nextempid;
        
        try 
        {
            pst = dbc.con.prepareStatement(queryid);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                nextempid = rs.getString(1);
                lbl_app_id.setText(Integer.toString(Integer.parseInt(nextempid)+1));
            }
        } 
        
        catch (SQLException err) 
        {
            JOptionPane.showMessageDialog(this, err);
        }       
        
    }
    
    
    
//====================================================================//
    
    
    
    
    JLabel lab1 = new JLabel("User Name");
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        side_bar = new javax.swing.JPanel();
        lbl_amount = new javax.swing.JLabel();
        pnl_Sareas = new javax.swing.JPanel();
        pnl_a2 = new javax.swing.JPanel();
        area2 = new javax.swing.JLabel();
        lbl_ax2 = new javax.swing.JLabel();
        pnl_a3 = new javax.swing.JPanel();
        area3 = new javax.swing.JLabel();
        lbl_ax3 = new javax.swing.JLabel();
        pnl_a1 = new javax.swing.JPanel();
        area1 = new javax.swing.JLabel();
        lbl_ax1 = new javax.swing.JLabel();
        pnl_a4 = new javax.swing.JPanel();
        area4 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        pnl_a5 = new javax.swing.JPanel();
        area5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnl_a6 = new javax.swing.JPanel();
        area6 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        pnl_a8 = new javax.swing.JPanel();
        area8 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        pnl_a7 = new javax.swing.JPanel();
        area7 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pnl_a10 = new javax.swing.JPanel();
        area10 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        pnl_a9 = new javax.swing.JPanel();
        area9 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_fname = new javax.swing.JTextField();
        lbl_fname = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        lbl_phone = new javax.swing.JLabel();
        txt_lname = new javax.swing.JTextField();
        lbl_lname = new javax.swing.JLabel();
        txt_loyalId = new javax.swing.JTextField();
        lbl_loyalId = new javax.swing.JLabel();
        cmb_gender = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        cmb_AppTypeN = new javax.swing.JComboBox<>();
        cmb_t_type = new javax.swing.JComboBox<>();
        lbl_app_id = new javax.swing.JLabel();
        cmb_treat = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cmb_beautician = new javax.swing.JComboBox<>();
        val_fname = new javax.swing.JLabel();
        val_lname = new javax.swing.JLabel();
        val_phone = new javax.swing.JLabel();
        pnl_mand_loyal = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pnl_mand_phone = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        cal_AppDate = new com.toedter.calendar.JDateChooser();
        spin_time = new javax.swing.JSpinner();
        lbl_newCus = new javax.swing.JLabel();
        lbl_birthday = new javax.swing.JLabel();
        aError = new javax.swing.JLabel();
        btn_addApp = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_amount1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_discount = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        viewapp = new javax.swing.JButton();
        addapp = new javax.swing.JButton();
        btn_back5 = new javax.swing.JButton();
        btn_back6 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();

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

        jPanel5.setBackground(new java.awt.Color(59, 62, 67));
        jPanel5.setLayout(null);
        main_panel.add(jPanel5);
        jPanel5.setBounds(830, 50, 250, 100);

        side_bar.setBackground(new java.awt.Color(67, 70, 75));
        side_bar.setLayout(null);

        lbl_amount.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        lbl_amount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_amount.setText("0.00");
        side_bar.add(lbl_amount);
        lbl_amount.setBounds(80, 440, 120, 40);

        pnl_Sareas.setBackground(new java.awt.Color(67, 70, 75));
        pnl_Sareas.setEnabled(false);
        pnl_Sareas.setLayout(null);

        pnl_a2.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a2.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a2.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a2.setLayout(null);

        area2.setBackground(new java.awt.Color(204, 204, 204));
        area2.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area2.setForeground(new java.awt.Color(255, 255, 255));
        area2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area2.setText("Nail Coloring");
        pnl_a2.add(area2);
        area2.setBounds(0, 0, 190, 30);

        lbl_ax2.setBackground(new java.awt.Color(12, 173, 183));
        lbl_ax2.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        lbl_ax2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ax2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ax2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        lbl_ax2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ax2.setOpaque(true);
        lbl_ax2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ax2MouseClicked(evt);
            }
        });
        pnl_a2.add(lbl_ax2);
        lbl_ax2.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a2);
        pnl_a2.setBounds(9, 50, 230, 30);

        pnl_a3.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a3.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a3.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a3.setLayout(null);

        area3.setBackground(new java.awt.Color(204, 204, 204));
        area3.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area3.setForeground(new java.awt.Color(255, 255, 255));
        area3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area3.setText("Nail Coloring");
        pnl_a3.add(area3);
        area3.setBounds(0, 0, 190, 30);

        lbl_ax3.setBackground(new java.awt.Color(12, 173, 183));
        lbl_ax3.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        lbl_ax3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ax3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ax3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        lbl_ax3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ax3.setOpaque(true);
        lbl_ax3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ax3MouseClicked(evt);
            }
        });
        pnl_a3.add(lbl_ax3);
        lbl_ax3.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a3);
        pnl_a3.setBounds(9, 85, 230, 30);

        pnl_a1.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a1.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a1.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a1.setLayout(null);

        area1.setBackground(new java.awt.Color(204, 204, 204));
        area1.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area1.setForeground(new java.awt.Color(255, 255, 255));
        area1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area1.setText("Nail Coloring");
        pnl_a1.add(area1);
        area1.setBounds(0, 0, 190, 30);

        lbl_ax1.setBackground(new java.awt.Color(12, 173, 183));
        lbl_ax1.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        lbl_ax1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ax1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ax1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        lbl_ax1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ax1.setOpaque(true);
        lbl_ax1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ax1MouseClicked(evt);
            }
        });
        pnl_a1.add(lbl_ax1);
        lbl_ax1.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a1);
        pnl_a1.setBounds(9, 15, 230, 30);

        pnl_a4.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a4.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a4.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a4.setLayout(null);

        area4.setBackground(new java.awt.Color(204, 204, 204));
        area4.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area4.setForeground(new java.awt.Color(255, 255, 255));
        area4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area4.setText("Nail Coloring");
        pnl_a4.add(area4);
        area4.setBounds(0, 0, 190, 30);

        jLabel31.setBackground(new java.awt.Color(12, 173, 183));
        jLabel31.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        pnl_a4.add(jLabel31);
        jLabel31.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a4);
        pnl_a4.setBounds(9, 120, 230, 30);

        pnl_a5.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a5.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a5.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a5.setLayout(null);

        area5.setBackground(new java.awt.Color(204, 204, 204));
        area5.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area5.setForeground(new java.awt.Color(255, 255, 255));
        area5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area5.setText("Nail Coloring");
        pnl_a5.add(area5);
        area5.setBounds(0, 0, 190, 30);

        jLabel4.setBackground(new java.awt.Color(12, 173, 183));
        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        pnl_a5.add(jLabel4);
        jLabel4.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a5);
        pnl_a5.setBounds(9, 155, 230, 30);

        pnl_a6.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a6.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a6.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a6.setLayout(null);

        area6.setBackground(new java.awt.Color(204, 204, 204));
        area6.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area6.setForeground(new java.awt.Color(255, 255, 255));
        area6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area6.setText("Nail Coloring");
        pnl_a6.add(area6);
        area6.setBounds(0, 0, 190, 30);

        jLabel33.setBackground(new java.awt.Color(12, 173, 183));
        jLabel33.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        jLabel33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel33.setOpaque(true);
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        pnl_a6.add(jLabel33);
        jLabel33.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a6);
        pnl_a6.setBounds(9, 190, 230, 30);

        pnl_a8.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a8.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a8.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a8.setLayout(null);

        area8.setBackground(new java.awt.Color(204, 204, 204));
        area8.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area8.setForeground(new java.awt.Color(255, 255, 255));
        area8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area8.setText("Nail Coloring");
        pnl_a8.add(area8);
        area8.setBounds(0, 0, 190, 30);

        jLabel35.setBackground(new java.awt.Color(12, 173, 183));
        jLabel35.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel35.setOpaque(true);
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });
        pnl_a8.add(jLabel35);
        jLabel35.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a8);
        pnl_a8.setBounds(9, 260, 230, 30);

        pnl_a7.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a7.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a7.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a7.setLayout(null);

        area7.setBackground(new java.awt.Color(204, 204, 204));
        area7.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area7.setForeground(new java.awt.Color(255, 255, 255));
        area7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area7.setText("Nail Coloring");
        pnl_a7.add(area7);
        area7.setBounds(0, 0, 190, 30);

        jLabel37.setBackground(new java.awt.Color(12, 173, 183));
        jLabel37.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.setOpaque(true);
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        pnl_a7.add(jLabel37);
        jLabel37.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a7);
        pnl_a7.setBounds(9, 225, 230, 30);

        pnl_a10.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a10.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a10.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a10.setLayout(null);

        area10.setBackground(new java.awt.Color(204, 204, 204));
        area10.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area10.setForeground(new java.awt.Color(255, 255, 255));
        area10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area10.setText("Nail Coloring");
        pnl_a10.add(area10);
        area10.setBounds(0, 0, 190, 30);

        jLabel39.setBackground(new java.awt.Color(12, 173, 183));
        jLabel39.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel39.setOpaque(true);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        pnl_a10.add(jLabel39);
        jLabel39.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a10);
        pnl_a10.setBounds(9, 330, 230, 30);

        pnl_a9.setBackground(new java.awt.Color(12, 173, 183));
        pnl_a9.setMinimumSize(new java.awt.Dimension(80, 30));
        pnl_a9.setPreferredSize(new java.awt.Dimension(85, 25));
        pnl_a9.setLayout(null);

        area9.setBackground(new java.awt.Color(204, 204, 204));
        area9.setFont(new java.awt.Font("Leelawadee UI", 0, 15)); // NOI18N
        area9.setForeground(new java.awt.Color(255, 255, 255));
        area9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area9.setText("Nail Coloring");
        pnl_a9.add(area9);
        area9.setBounds(0, 0, 190, 30);

        jLabel41.setBackground(new java.awt.Color(12, 173, 183));
        jLabel41.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_close_white_16dp_1x.png"))); // NOI18N
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel41.setOpaque(true);
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        pnl_a9.add(jLabel41);
        jLabel41.setBounds(200, 0, 30, 30);

        pnl_Sareas.add(pnl_a9);
        pnl_a9.setBounds(9, 295, 230, 30);

        side_bar.add(pnl_Sareas);
        pnl_Sareas.setBounds(0, 30, 250, 370);

        jLabel5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Treatments");
        side_bar.add(jLabel5);
        jLabel5.setBounds(30, 0, 190, 30);

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Rs.");
        side_bar.add(jLabel3);
        jLabel3.setBounds(20, 440, 50, 40);

        main_panel.add(side_bar);
        side_bar.setBounds(830, 150, 250, 510);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        txt_fname.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_fname.setNextFocusableComponent(txt_lname);
        txt_fname.setOpaque(false);
        txt_fname.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_fname);
        txt_fname.setBounds(190, 190, 210, 25);

        lbl_fname.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_fname.setForeground(new java.awt.Color(33, 33, 33));
        lbl_fname.setText("First Name");
        jPanel2.add(lbl_fname);
        lbl_fname.setBounds(80, 190, 90, 20);

        txt_phone.setFocusCycleRoot(true);
        txt_phone.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_phone.setNextFocusableComponent(txt_fname);
        txt_phone.setPreferredSize(new java.awt.Dimension(5, 20));
        txt_phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_phoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_phoneFocusLost(evt);
            }
        });
        jPanel2.add(txt_phone);
        txt_phone.setBounds(190, 90, 210, 25);

        lbl_phone.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_phone.setForeground(new java.awt.Color(33, 33, 33));
        lbl_phone.setText("Phone");
        jPanel2.add(lbl_phone);
        lbl_phone.setBounds(80, 90, 90, 20);

        txt_lname.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_lname.setNextFocusableComponent(cmb_gender);
        txt_lname.setOpaque(false);
        txt_lname.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_lname);
        txt_lname.setBounds(190, 240, 210, 25);

        lbl_lname.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_lname.setForeground(new java.awt.Color(33, 33, 33));
        lbl_lname.setText("Last Name");
        jPanel2.add(lbl_lname);
        lbl_lname.setBounds(80, 240, 90, 20);

        txt_loyalId.setMinimumSize(new java.awt.Dimension(5, 20));
        txt_loyalId.setOpaque(false);
        txt_loyalId.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel2.add(txt_loyalId);
        txt_loyalId.setBounds(190, 140, 210, 25);

        lbl_loyalId.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_loyalId.setForeground(new java.awt.Color(33, 33, 33));
        lbl_loyalId.setText("Loyalty ID");
        jPanel2.add(lbl_loyalId);
        lbl_loyalId.setBounds(80, 140, 90, 20);

        cmb_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "female", "male" }));
        cmb_gender.setNextFocusableComponent(cmb_t_type);
        cmb_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_genderActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_gender);
        cmb_gender.setBounds(190, 290, 110, 25);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 33, 33));
        jLabel21.setText("Appointment No");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(480, 20, 120, 30);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 370, 860, 10);

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(33, 33, 33));
        jLabel22.setText("Customer type");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(80, 20, 120, 30);

        lbl_gender.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_gender.setForeground(new java.awt.Color(33, 33, 33));
        lbl_gender.setText("Gender");
        jPanel2.add(lbl_gender);
        lbl_gender.setBounds(80, 290, 90, 20);

        cmb_AppTypeN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal Customer", "Loyalty Customer" }));
        cmb_AppTypeN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_AppTypeNActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_AppTypeN);
        cmb_AppTypeN.setBounds(230, 20, 170, 30);

        cmb_t_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_t_typeActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_t_type);
        cmb_t_type.setBounds(610, 200, 170, 25);

        lbl_app_id.setFont(new java.awt.Font("Nirmala UI", 0, 20)); // NOI18N
        lbl_app_id.setForeground(new java.awt.Color(33, 33, 33));
        lbl_app_id.setText("ID");
        jPanel2.add(lbl_app_id);
        lbl_app_id.setBounds(640, 20, 100, 30);

        cmb_treat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_treatActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_treat);
        cmb_treat.setBounds(610, 240, 170, 25);

        jLabel23.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(33, 33, 33));
        jLabel23.setText("Appointment Time");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel23);
        jLabel23.setBounds(480, 130, 120, 20);

        jLabel24.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(33, 33, 33));
        jLabel24.setText("Treatment");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(480, 240, 120, 20);

        jLabel25.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(33, 33, 33));
        jLabel25.setText("Category");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(480, 200, 120, 20);

        cmb_beautician.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deepika Gunasekara", "Dewni Perera", "Sahani De Silva", "Gavishka Dias", "Supun Pathirana", "Sam Ranasingha" }));
        jPanel2.add(cmb_beautician);
        cmb_beautician.setBounds(610, 320, 170, 25);

        val_fname.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        val_fname.setForeground(new java.awt.Color(237, 50, 50));
        val_fname.setText("Name can contain only letters.");
        jPanel2.add(val_fname);
        val_fname.setBounds(190, 216, 210, 20);

        val_lname.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        val_lname.setForeground(new java.awt.Color(237, 50, 50));
        val_lname.setText("Name can contain only letters.");
        jPanel2.add(val_lname);
        val_lname.setBounds(190, 270, 250, 20);

        val_phone.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        val_phone.setForeground(new java.awt.Color(237, 50, 50));
        val_phone.setText("Phone must contain 10 digits");
        jPanel2.add(val_phone);
        val_phone.setBounds(190, 120, 250, 20);

        pnl_mand_loyal.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_loyalLayout = new javax.swing.GroupLayout(pnl_mand_loyal);
        pnl_mand_loyal.setLayout(pnl_mand_loyalLayout);
        pnl_mand_loyalLayout.setHorizontalGroup(
            pnl_mand_loyalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_loyalLayout.setVerticalGroup(
            pnl_mand_loyalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_loyal);
        pnl_mand_loyal.setBounds(50, 148, 8, 8);

        jLabel20.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(33, 33, 33));
        jLabel20.setText("Beautician");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(480, 320, 90, 20);

        pnl_mand_phone.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout pnl_mand_phoneLayout = new javax.swing.GroupLayout(pnl_mand_phone);
        pnl_mand_phone.setLayout(pnl_mand_phoneLayout);
        pnl_mand_phoneLayout.setHorizontalGroup(
            pnl_mand_phoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pnl_mand_phoneLayout.setVerticalGroup(
            pnl_mand_phoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(pnl_mand_phone);
        pnl_mand_phone.setBounds(50, 98, 8, 8);

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(33, 33, 33));
        jLabel27.setText("Appointment Date");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(480, 90, 120, 20);

        cal_AppDate.setDateFormatString("yyyy-M-d ");
        cal_AppDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cal_AppDate.setMaxSelectableDate(new java.util.Date(253370748674000L));
        cal_AppDate.setMinSelectableDate(new java.util.Date(-62135785714000L));
        jPanel2.add(cal_AppDate);
        cal_AppDate.setBounds(640, 90, 140, 25);

        spin_time.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spin_time.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jPanel2.add(spin_time);
        spin_time.setBounds(640, 130, 140, 30);

        lbl_newCus.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_newCus.setForeground(new java.awt.Color(237, 50, 50));
        lbl_newCus.setText("New Customer*");
        jPanel2.add(lbl_newCus);
        lbl_newCus.setBounds(80, 330, 110, 30);

        lbl_birthday.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbl_birthday.setForeground(new java.awt.Color(237, 50, 50));
        lbl_birthday.setText("Today is Birthday*");
        jPanel2.add(lbl_birthday);
        lbl_birthday.setBounds(220, 330, 140, 30);

        aError.setFont(new java.awt.Font("Nirmala UI", 0, 11)); // NOI18N
        aError.setForeground(new java.awt.Color(237, 50, 50));
        aError.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        aError.setText("Only 10 areas are allowed at a time");
        jPanel2.add(aError);
        aError.setBounds(540, 270, 240, 20);

        btn_addApp.setBackground(new java.awt.Color(12, 173, 183));
        btn_addApp.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_addApp.setForeground(new java.awt.Color(255, 255, 255));
        btn_addApp.setText("Add Appointment");
        btn_addApp.setBorder(null);
        btn_addApp.setContentAreaFilled(false);
        btn_addApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addApp.setOpaque(true);
        btn_addApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addAppActionPerformed(evt);
            }
        });
        jPanel2.add(btn_addApp);
        btn_addApp.setBounds(560, 440, 240, 40);

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(0, 60, 860, 10);

        lbl_amount1.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        lbl_amount1.setForeground(new java.awt.Color(51, 51, 51));
        lbl_amount1.setText("0.00");
        jPanel2.add(lbl_amount1);
        lbl_amount1.setBounds(160, 410, 120, 22);

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Total :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(290, 440, 70, 32);

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Rs.");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(120, 440, 30, 30);

        lbl_discount.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        lbl_discount.setForeground(new java.awt.Color(51, 51, 51));
        lbl_discount.setText("0.00");
        jPanel2.add(lbl_discount);
        lbl_discount.setBounds(160, 440, 120, 30);

        lbl_total.setFont(new java.awt.Font("Leelawadee UI", 1, 26)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(51, 51, 51));
        lbl_total.setText("0.00");
        jPanel2.add(lbl_total);
        lbl_total.setBounds(410, 430, 130, 50);

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Rs.");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(370, 440, 30, 32);

        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Rs.");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(120, 410, 30, 25);

        jLabel10.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Amount :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 410, 100, 25);

        jLabel11.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Discount :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 440, 100, 25);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 830, 510);

        jPanel8.setBackground(new java.awt.Color(52, 53, 57));
        jPanel8.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 255, 51));
        jLabel26.setText("Mandatory Field");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel8.add(jLabel26);
        jLabel26.setBounds(60, 0, 90, 20);

        jPanel3.setBackground(new java.awt.Color(109, 215, 39));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel3);
        jPanel3.setBounds(40, 8, 8, 8);

        main_panel.add(jPanel8);
        jPanel8.setBounds(-10, 660, 1090, 30);

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));
        jPanel4.setLayout(null);

        viewapp.setBackground(new java.awt.Color(67, 70, 75));
        viewapp.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        viewapp.setForeground(new java.awt.Color(204, 204, 204));
        viewapp.setText("View Appointments");
        viewapp.setBorderPainted(false);
        viewapp.setContentAreaFilled(false);
        viewapp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewapp.setIconTextGap(10);
        viewapp.setOpaque(true);
        viewapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewappActionPerformed(evt);
            }
        });
        jPanel4.add(viewapp);
        viewapp.setBounds(220, 25, 180, 70);

        addapp.setBackground(new java.awt.Color(67, 70, 75));
        addapp.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        addapp.setForeground(new java.awt.Color(255, 255, 255));
        addapp.setText("Add Appointment");
        addapp.setBorderPainted(false);
        addapp.setContentAreaFilled(false);
        addapp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addapp.setIconTextGap(10);
        addapp.setOpaque(true);
        addapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addappActionPerformed(evt);
            }
        });
        jPanel4.add(addapp);
        addapp.setBounds(10, 25, 180, 70);

        btn_back5.setBackground(new java.awt.Color(67, 70, 75));
        btn_back5.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back5.setForeground(new java.awt.Color(204, 204, 204));
        btn_back5.setText("Update Appointments");
        btn_back5.setBorderPainted(false);
        btn_back5.setContentAreaFilled(false);
        btn_back5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back5.setIconTextGap(10);
        btn_back5.setOpaque(true);
        btn_back5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back5ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_back5);
        btn_back5.setBounds(430, 25, 190, 70);

        btn_back6.setBackground(new java.awt.Color(67, 70, 75));
        btn_back6.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back6.setForeground(new java.awt.Color(204, 204, 204));
        btn_back6.setText("Cancel Appointments");
        btn_back6.setBorderPainted(false);
        btn_back6.setContentAreaFilled(false);
        btn_back6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back6.setIconTextGap(10);
        btn_back6.setOpaque(true);
        btn_back6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back6ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_back6);
        btn_back6.setBounds(640, 25, 190, 70);

        jPanel12.setBackground(new java.awt.Color(12, 173, 183));
        jPanel12.setPreferredSize(new java.awt.Dimension(190, 3));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel12);
        jPanel12.setBounds(10, 90, 180, 10);

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

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

    private void btn_addAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addAppActionPerformed
        
        
        
        String empName;
          
       
        int count=0;
        int areacode=0;
        Double price = 0.0;
        Double sum = 0.0;
        
        Double discount =0.0;
        Double total =0.0;
        
        System.out.println("time1 = "+time);
        

        
     
       SimpleDateFormat formater = new SimpleDateFormat("hh:mm");
       time = formater.format(spin_time.getValue());
       
        System.out.println("time2 = "+time);
 
        price = Double.parseDouble(lbl_total.getText());
        app_id = lbl_app_id.getText();
        fname = txt_fname.getText();
        lname = txt_lname.getText();
        phone = txt_phone.getText();
        
        status = "in queue";
        Object selectedItem1 = cmb_AppTypeN.getSelectedItem();
        appType = selectedItem1.toString();
        
        Object selectedItem = cmb_gender.getSelectedItem();
        gender = selectedItem.toString();

        Object selectedbeauty = cmb_beautician.getSelectedItem();
        empName = selectedbeauty.toString();
       
        
        empId = getEmpId(empName);
        
        
        
        DateFormat fmt;       
        fmt = new SimpleDateFormat("yyyy-MM-dd");
        date = fmt.format(cal_AppDate.getDate());        
            
       

       
        
     if(validateInput())
     {        
                 
        try
        {

              if(newCustomer)
            {
                
                String  st = "insert into Customer (phone,fname,lname,gender) values(?,?,?,?)";

                pst  = dbc.con.prepareStatement(st);

                pst.setString(1,phone);
                pst.setString(2,fname);
                pst.setString(3,lname);
                pst.setString(4,gender);


                pst.execute();

                st = "insert into Appointment (phone,app_id,empId, app_type,status,app_date,app_time,price) values(?,?,?,?,?,?,?,?)";

                pst  = dbc.con.prepareStatement(st);

                pst.setString(1,phone);
                pst.setString(2,app_id);
                pst.setInt(3,empId);
                pst.setString(4,appType);
                pst.setString(5,status);
                pst.setString(6,date);
                pst.setString(7,time);
                pst.setDouble(8,price);

                pst.execute();


                
            }    
           else
             {
                 

                System.out.println("Added customer");
                
                String st6 = "insert into Appointment (phone,app_id,empId,app_type,status,app_date,app_time,price) values(?,?,?,?,?,?,?,?)";

                pst  = dbc.con.prepareStatement(st6);

                pst.setString(1,phone);
                pst.setString(2,app_id);
                pst.setInt(3,empId);
                pst.setString(4,appType);
                pst.setString(5,status);
                pst.setString(6,date);
                pst.setString(7,time);
                pst.setDouble(8,price);

                pst.execute();
                
            }    
            
            
            
                
 //======================== TREATMENTS PART ====================================//               
                
                String area = "";
                
                while(areaCount > 0)
                { 
                    //----get selected area value one at a time-------//
                    
                    for (int i=0; i<areas.length; i++)
                    {
                        if (areas[i] != null) 
                        {
                            area = areas[i];
                            areas[i] = null;  
                            break;
                        }
                    }
                    
                    
                    //-----add record to database------------//
                    
                    
                    String que = "SELECT tId,price FROM treatment WHERE tName = '"+area+"'";  
                    try 
                    {
                        
                        pst = dbc.con.prepareStatement(que);
                        rs = this.pst.executeQuery();

                        while (rs.next())
                        {
                                
                                areacode = Integer.parseInt(rs.getString(1));  
                                price = rs.getDouble(2);  
                                
                        //=================================//        
                                sum = sum + price;
                        //=================================//        
                                
                                String st3 = "INSERT INTO apphastreat\n" +
                                             "VALUES("+app_id+","+areacode+")";

                                pst  = dbc.con.prepareStatement(st3);
                                pst.execute();
                                
                        }
                        
                    } 
                    catch (SQLException err)
                    {
                        JOptionPane.showMessageDialog(this, err);
                    }
                    
                    areaCount--;
                }
                
              
            
            
            lbl_amount.setText(Double.toString(sum));
            lbl_amount1.setText(Double.toString(sum));
            
            
            if(checkBirthday(Integer.parseInt(phone)))
            {
                     
                discount = sum * discountp;
                        
                lbl_discount.setText(Double.toString(discount));
                
                total = sum - discount;
                
                lbl_total.setText(Double.toString(total));
                
                
            }
            else
            {    
                        
                lbl_discount.setText("0");
                
                total = sum;
                
                lbl_total.setText(Double.toString(total));
                
            }
            
//=================================================================================//            
            

        idAutoGenerate();
        
        JOptionPane.showMessageDialog(null,"New appointment added Successfuly.");                
        resetFields();
        ResetAreaSuff();            
        setSareasInvisible(); 

            
            btn_addApp.setVisible(true);
            
        }
        catch(SQLException e)
        {
                        
            JOptionPane.showMessageDialog(null,e);
            
        }
        
         resetFields();
    }  
        
     
     
     
     
        SpinnerDateModel spinnermodel = new SpinnerDateModel();
        spinnermodel.setCalendarField(Calendar.MINUTE);
        spin_time.setModel(spinnermodel);
        spin_time.setEditor(new JSpinner.DateEditor(spin_time , "hh:mm"));
     
     
     
        fillBeauticians();
        
    }//GEN-LAST:event_btn_addAppActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        

        Login l = new Login();
        l.setVisible(true);
        this.dispose();
                
            
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
  
        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
       
        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton2MouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
           
        
        
        cmb_beautician.removeAllItems();        
        fillBeauticians();
        
        cmb_t_type.removeAllItems();        
        fillTypes();
        
        lbl_birthday.setVisible(false);
        
        Date cdate = new Date();
        cal_AppDate.setMinSelectableDate(cdate);
        
        lbl_newCus.setVisible(false);
        
        cal_AppDate.setDate(cdate);
        
        System.out.println("date = "+cdate);
        
        
    
        
       SimpleDateFormat formater = new SimpleDateFormat("hh:mm");
       time = formater.format(spin_time.getValue());
       
        System.out.println("time "+time );
        
        

        spin_time.setEditor(new JSpinner.DateEditor(spin_time, "hh:mm"));
        
   
       
        
        val_phone.setText("Field can't be empty.");
        
        txt_phone.requestFocusInWindow();
        
        pnl_mand_loyal.setVisible(false);
        
        val_phone.setVisible(false);
        val_fname.setVisible(false);
        val_lname.setVisible(false);

      
        txt_loyalId.setEnabled(false);
        lbl_loyalId.setEnabled(false);

        
        
       
        
        
    }//GEN-LAST:event_formWindowOpened

    private void cmb_AppTypeNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_AppTypeNActionPerformed

        
        
        
        
        Object selectedItem = cmb_AppTypeN.getSelectedItem();
        String appType = selectedItem.toString();

        System.out.println(appType);

        if(appType.equals("Normal Customer"))
        {

            
            pnl_mand_loyal.setVisible(false);
            pnl_mand_phone.setVisible(true);
            
            
       //==============ENABLED================//

            txt_fname.setEnabled(true);
            lbl_fname.setEnabled(true);

            txt_lname.setEnabled(true);
            lbl_lname.setEnabled(true);

            txt_phone.setEnabled(true);
            lbl_phone.setEnabled(true);

            txt_fname.setEnabled(true);
            lbl_fname.setEnabled(true);

            cmb_gender.setEnabled(true);
            lbl_gender.setEnabled(true);

         //==============DISABLED================//

            txt_loyalId.setEnabled(false);
            lbl_loyalId.setEnabled(false);

        }
        else
        {
            
            pnl_mand_loyal.setVisible(true);
            pnl_mand_phone.setVisible(false);
            
            
        //==============DISABLED================//

            
            txt_fname.setEnabled(false);
            lbl_fname.setEnabled(false);

            txt_lname.setEnabled(false);
            lbl_lname.setEnabled(false);

//            txt_phone.setEnabled(false);
//            lbl_phone.setEnabled(false);

            txt_fname.setEnabled(false);
            lbl_fname.setEnabled(false);

            cmb_gender.setEnabled(false);
            lbl_gender.setEnabled(false);

            
         //==============ENABLED================//

            txt_loyalId.setEnabled(true);
            lbl_loyalId.setEnabled(true);

        }

    }//GEN-LAST:event_cmb_AppTypeNActionPerformed
    
    private void cmb_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_genderActionPerformed

        
    }//GEN-LAST:event_cmb_genderActionPerformed

    private void cmb_t_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_t_typeActionPerformed
        
      
        cmb_treat.removeAllItems();
               
        
        Object selectedItem1 = cmb_t_type.getSelectedItem();
        t_type = selectedItem1.toString();

        
        System.out.println("type = "+t_type);
    
        try
        {
            
                String  st1 = "SELECT tName\n" +
                             "FROM treatment\n" +
                             "WHERE type = '"+t_type+"'";

                pst  = dbc.con.prepareStatement(st1);
                
                rs1 = pst.executeQuery();
                
                cmb_treat.addItem("Select treatment");
                
                while (rs1.next())
                {   
                        cmb_treat.addItem(rs1.getString(1));
                }
                    
        }
        catch(SQLException e2)
        {
            JOptionPane.showMessageDialog(null,e2);
        }
        
        
        
    }//GEN-LAST:event_cmb_t_typeActionPerformed

    private void cmb_treatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_treatActionPerformed
        
       
        
        int i = cmb_treat.getSelectedIndex();
              
        
        if(i > 0)
        {

            
            setLables();
        
           
        }
        
        
        calPrice();
        
        
        
        
    }//GEN-LAST:event_cmb_treatActionPerformed

    private void txt_phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_phoneFocusGained
       
        
          txt_phone.setBackground(new java.awt.Color(255,255,255));
        
        
    }//GEN-LAST:event_txt_phoneFocusGained

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_backActionPerformed
    {//GEN-HEADEREND:event_btn_backActionPerformed
        
        
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btn_backActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel23MouseClicked
    {//GEN-HEADEREND:event_jLabel23MouseClicked

        System.out.println("clicked");
        
       
    }//GEN-LAST:event_jLabel23MouseClicked

    private void txt_phoneFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_txt_phoneFocusLost
    {//GEN-HEADEREND:event_txt_phoneFocusLost
     
        
       
        
        System.out.println("losttt");
       
        lbl_newCus.setVisible(false);
        lbl_birthday.setVisible(false);
        txt_fname.setText("");
        txt_lname.setText("");
        
        
        try
        {
            
                int iphone = Integer.parseInt(txt_phone.getText());
            
                String  st = "SELECT phone, fname, lname, gender, dob, loyal_id FROM Customer WHERE phone LIKE "+iphone+"";

                pst  = dbc.con.prepareStatement(st);
                
                rs = pst.executeQuery();

                int count = 0;
                
                    while (rs.next())
                    {   
                        
                        count++;

                        txt_phone.setText(Integer.toString(rs.getInt(1)));
                       
                        txt_fname.setText(rs.getString(2));

                        txt_lname.setText(rs.getString(3));

                        cmb_gender.setSelectedItem(rs.getString(4));
                        
                        txt_loyalId.setText(rs.getString(6));


                        
                        try
                        {
                        
                        if(rs.getString(6).equals(null))
                        {
                            System.out.println("null");
                            idAutoGenerate();
                        }

                        
                        }
                        catch(NullPointerException n)
                        {
                             System.out.println("null");
                             idAutoGenerate();
                        }
                       
                    }
                
                    
                    
                    if(count > 0)
                    {  
                        
                        checkBirthday(iphone);
                        
                        newCustomer =false;
                        System.out.println("not a new customer");
                        
                    }                    
                    else
                    {
                        System.out.println("new customer");
                        lbl_newCus.setVisible(true);
                        
                    }
                    
                    
                    
                }

            
            catch(SQLException e2)
            {
                    JOptionPane.showMessageDialog(null,e2);
            }
            catch(NumberFormatException e3)
            {
                    
                System.out.println("phone is null");
                
            }
        
        
        
        
        
    }//GEN-LAST:event_txt_phoneFocusLost

  
    
    
    private void lbl_ax2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbl_ax2MouseClicked
    {//GEN-HEADEREND:event_lbl_ax2MouseClicked
        pnl_a2.setVisible(false);
        areaCount--;
        areas[1]=null;
        pricelist[1]=0.0;
        calPrice();        
    }//GEN-LAST:event_lbl_ax2MouseClicked

    private void lbl_ax3MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbl_ax3MouseClicked
    {//GEN-HEADEREND:event_lbl_ax3MouseClicked
        pnl_a3.setVisible(false);
        areaCount--;
        areas[2]=null;
        pricelist[2]=0.0;
        calPrice();
    }//GEN-LAST:event_lbl_ax3MouseClicked

    private void lbl_ax1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbl_ax1MouseClicked
    {//GEN-HEADEREND:event_lbl_ax1MouseClicked
        pnl_a1.setVisible(false);
        areaCount--;
        areas[0]=null;
        pricelist[0]=0.0;
        calPrice();
    }//GEN-LAST:event_lbl_ax1MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel31MouseClicked
    {//GEN-HEADEREND:event_jLabel31MouseClicked
        pnl_a4.setVisible(false);
        areaCount--;
        areas[3]=null;
        pricelist[3]=0.0;
        calPrice();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MouseClicked
    {//GEN-HEADEREND:event_jLabel4MouseClicked
        pnl_a5.setVisible(false);
        areaCount--;
        areas[4]=null;
        pricelist[4]=0.0;
        calPrice();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel33MouseClicked
    {//GEN-HEADEREND:event_jLabel33MouseClicked
        pnl_a6.setVisible(false);
        areaCount--;
        areas[6]=null;
        pricelist[6]=0.0;
        calPrice();
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel35MouseClicked
    {//GEN-HEADEREND:event_jLabel35MouseClicked
        pnl_a8.setVisible(false);
        areaCount--;
        areas[7]=null;
        pricelist[7]=0.0;
        calPrice();
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel37MouseClicked
    {//GEN-HEADEREND:event_jLabel37MouseClicked
        pnl_a7.setVisible(false);
        areaCount--;
        areas[5]=null;
        pricelist[5]=0.0;
        calPrice();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel39MouseClicked
    {//GEN-HEADEREND:event_jLabel39MouseClicked
        pnl_a10.setVisible(false);
        areaCount--;
        areas[9]=null;
        pricelist[9]=0.0;
        calPrice();
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel41MouseClicked
    {//GEN-HEADEREND:event_jLabel41MouseClicked
        pnl_a9.setVisible(false);
        areaCount--;
        areas[8]=null;
        pricelist[8]=0.0;
        calPrice();
    }//GEN-LAST:event_jLabel41MouseClicked

    private void viewappActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewappActionPerformed
    {//GEN-HEADEREND:event_viewappActionPerformed
        Appointments a = new Appointments();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewappActionPerformed

    private void addappActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addappActionPerformed
    {//GEN-HEADEREND:event_addappActionPerformed

        AddAppointment a = new AddAppointment();
        a.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_addappActionPerformed

    private void btn_back5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_back5ActionPerformed
    {//GEN-HEADEREND:event_btn_back5ActionPerformed
        UpdateAppointment a = new UpdateAppointment();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_back5ActionPerformed

    private void btn_back6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_back6ActionPerformed
    {//GEN-HEADEREND:event_btn_back6ActionPerformed

        Appointments b = new Appointments();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_back6ActionPerformed

    
    
   //===================== VALIDATE INPUTS ==================//
    
    private boolean validateInput()
    {

        if(phone.equals(""))
        {
            txt_phone.requestFocusInWindow();
            val_phone.setVisible(true);
            txt_phone.setBackground(new java.awt.Color(255,102,102));
            return false;
        }
        
        
        else if(phone.length() < 9)
        {
            txt_phone.requestFocusInWindow();
            val_phone.setText("Phone must contain 10 digits");
            txt_phone.setBackground(new java.awt.Color(255,102,102));
            val_phone.setVisible(true);          
            
            return false;
        }
        
        else if(!fname.matches("^[a-zA-Z\\s]*$"))
        {    
            txt_fname.requestFocusInWindow();
            val_fname.setVisible(true);
            return false;
        }
        else if(!lname.matches("^[a-zA-Z\\s]*$"))
        {      
            txt_lname.requestFocusInWindow();
            val_lname.setVisible(true);
            return false;
        }
        
        else if(!dateValidation())
        {      
            return false;
        }
        
        else if(areaCount == 0)
        {      
            JOptionPane.showMessageDialog(null,"Select treatments");
            return false;
        }
        
       
        else
            return true;
        
    }
    
    
    
    
    //======================== DATE VALIDATE =========================//
    
    public boolean dateValidation()
    {
    
        
        Date today = Calendar.getInstance().getTime();         //get current date  

        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
       
        int boo = sdf.format(today).compareTo(sdf.format(cal_AppDate.getDate()));
       
        if(boo == 0 )        
        {    
            
            
            
            
                Date now = Calendar.getInstance().getTime();         //get current date  

                SimpleDateFormat spd = new SimpleDateFormat("hh");

                int timess = spd.format(today).compareTo(spd.format(spin_time.getValue()));



                if(timess <= 0 )        
                {    

                    return true;
                }               
                else
                {
                    JOptionPane.showMessageDialog(null,"invalid time");
                    return false;
                }     
            
            
        }               
        
        
        return true;
        
    }
    
    
    //======================== DATE VALIDATE =========================//
    
    public boolean timeValidation()
    {
    
        
        Date today = Calendar.getInstance().getTime();         //get current date  

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
       
        int boo = sdf.format(today).compareTo(sdf.format(spin_time.getValue()));
       
        if(boo <= 0 )        
        {    
            
            return true;
        }               
        else
        {
            JOptionPane.showMessageDialog(null,"invalid time");
            return false;
        }     
        
    }
    
    
 //===================== RESET FIELDS ==========================//   
    
    
    public void resetFields()  
    {
        txt_fname.setText("");
        txt_lname.setText("");
        txt_phone.setText("");
        txt_loyalId.setText("");
//      txt_note.setText("");
        
        newCustomer = true;
        
        lbl_newCus.setVisible(false);
        
        cmb_AppTypeN.setSelectedItem(0);
        cmb_gender.setSelectedItem(0);
        
        txt_phone.setBackground(new java.awt.Color(255,255,255));
                      
        pnl_mand_loyal.setVisible(false);
        
        val_phone.setText("Field can't be empty.");
        
        val_phone.setVisible(false);
        val_fname.setVisible(false);
        val_lname.setVisible(false);
        
        lbl_amount.setText("0.00");
        lbl_amount1.setText("0.00");
        lbl_discount.setText("0.00");
        lbl_total.setText("0.00");
        
        lbl_birthday.setVisible(false);
        
        cmb_beautician.removeAllItems();
        
        lbl_amount.setText("0.00");
        lbl_amount1.setText("0.00");
        lbl_total.setText("0.00");
        
        finTotal = 0.0;
        discountamnt = 0.0;
        discount = 0.0;

        
        setSareasInvisible(); 
        
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
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AddAppointment().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aError;
    private javax.swing.JButton addapp;
    private javax.swing.JLabel area1;
    private javax.swing.JLabel area10;
    private javax.swing.JLabel area2;
    private javax.swing.JLabel area3;
    private javax.swing.JLabel area4;
    private javax.swing.JLabel area5;
    private javax.swing.JLabel area6;
    private javax.swing.JLabel area7;
    private javax.swing.JLabel area8;
    private javax.swing.JLabel area9;
    private javax.swing.JButton btn_addApp;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_back5;
    private javax.swing.JButton btn_back6;
    private com.toedter.calendar.JDateChooser cal_AppDate;
    private javax.swing.JComboBox<String> cmb_AppTypeN;
    private javax.swing.JComboBox<String> cmb_beautician;
    private javax.swing.JComboBox<String> cmb_gender;
    private javax.swing.JComboBox<String> cmb_t_type;
    private javax.swing.JComboBox<String> cmb_treat;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_amount1;
    private javax.swing.JLabel lbl_app_id;
    private javax.swing.JLabel lbl_ax1;
    private javax.swing.JLabel lbl_ax2;
    private javax.swing.JLabel lbl_ax3;
    private javax.swing.JLabel lbl_birthday;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JLabel lbl_fname;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_lname;
    private javax.swing.JLabel lbl_loyalId;
    private javax.swing.JLabel lbl_newCus;
    private javax.swing.JLabel lbl_phone;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel pnl_Sareas;
    private javax.swing.JPanel pnl_a1;
    private javax.swing.JPanel pnl_a10;
    private javax.swing.JPanel pnl_a2;
    private javax.swing.JPanel pnl_a3;
    private javax.swing.JPanel pnl_a4;
    private javax.swing.JPanel pnl_a5;
    private javax.swing.JPanel pnl_a6;
    private javax.swing.JPanel pnl_a7;
    private javax.swing.JPanel pnl_a8;
    private javax.swing.JPanel pnl_a9;
    private javax.swing.JPanel pnl_mand_loyal;
    private javax.swing.JPanel pnl_mand_phone;
    private javax.swing.JPanel side_bar;
    private javax.swing.JSpinner spin_time;
    private javax.swing.JPanel top_panel;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_loyalId;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JLabel val_fname;
    private javax.swing.JLabel val_lname;
    private javax.swing.JLabel val_phone;
    private javax.swing.JButton viewapp;
    // End of variables declaration//GEN-END:variables
}
