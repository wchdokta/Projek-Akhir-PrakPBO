/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekfix.models;
import java.sql.DriverManager;
import java.sql.Connection; 
import java.sql.SQLException; 
import java.sql.Statement;

/**
 *
 * @author wachid op
 */
public class Database {
    String DBurl = "jdbc:mysql://localhost/vcd_db";
    String DBusername = "root";
    String DBpassword = "";
    public Connection koneksi;
    public Statement statement;
    
    public Database(){  
        try{  
           Class.forName("com.mysql.jdbc.Driver");
           koneksi = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
        }catch(Exception e){
            System.out.println(e);
        }  
    }
}
