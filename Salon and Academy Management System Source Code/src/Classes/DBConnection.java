package Classes;

import java.sql.*;

public class DBConnection{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Salons?useSSL=false";
   
    //Datastore URL
    static final String DS_URL ="jdbc:mysql://localhost:3306/";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "sally";

    public DBConnection(){
        Connection conn = null;
        Statement stmt = null;
   
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DS_URL, USER, PASS);

            //System.out.println("Creating database...");
            stmt = conn.createStatement();
      
            String sql = "CREATE DATABASE IF NOT EXISTS inventory";
            stmt.executeUpdate(sql);
            
            System.out.println("Database created successfully...");          
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            
            sql = "create table if not exists supplier(" +
                    "	sup_id int unique auto_increment  not null," +
                    "	name varchar(25)," +
                    "	company varchar(25)," +
                    "	contact_no char(10)," +
                    "	nic char(10) unique not null," +
                    "	email varchar(50)," +
                    "	address varchar(100)," +
                    "	primary key pk_sup (sup_id)," +
                    "	constraint check_nic check (nic like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]V')," +
                    "	constraint check_contact_no check (phone like '[0][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')" +
                   ")";
      
           

            stmt.executeUpdate(sql);
            
            System.out.println("Created table in given database...");
            
            
            sql = "create table if not exists admin(" +
                    "eid int,"+
                    "username varchar(25)," +
                    "password_admin char(32)," +
                    "primary key pk_admin (eid,username)," +
                    "foreign key fk_admin (eid) references employee (eid)" +
                    "--    foreign key fk_admin_username (username) references employee(username)" +
                    ")";

            stmt.executeUpdate(sql);
            
            System.out.println("Created table in given database...");
            
             sql = "create table if not exists product(" +
                    "	Product_ID int unique auto_increment  not null," +
                    "	Name varchar(25)," +
                    "	Description varchar(25)," +
                    "	Unit_Price char(10)," +
                    "	primary key pk_product (Product_ID)," +
                     ")";
             
              stmt.executeUpdate(sql);
            
            System.out.println("Created product table in given database...");
      
            
        }catch(SQLException | ClassNotFoundException se){
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
            }
        }
        //System.out.println("Goodbye!");
    }
}
