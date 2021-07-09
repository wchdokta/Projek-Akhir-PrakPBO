/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekfix.models;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author wachid op
 */
public class Rental extends Model{
    public Rental(Database DB){
        this.DB = DB;
    }
    
    public Object[][] getVcd(){
        Object[][] rental = new Object[100][2];
        try{
            DB.statement = DB.koneksi.createStatement();
            ResultSet result = DB.statement.executeQuery("SELECT * FROM `vcd`");
            
            int i = 0;
            while(result.next()){
                rental[i][0] = result.getString("nm_vcd");
                rental[i][1] = result.getString("harga");
                i++;
            }
            DB.statement.close();
        } catch(Exception err){
            System.out.println(err);
        }
        return rental;
    }
    
    public Object[][] getCust(){
        Object[][] cust = new Object[100][4];
        try{
            DB.statement = DB.koneksi.createStatement();
            ResultSet result = DB.statement.executeQuery("SELECT * FROM `penyewa`");
            
            int i = 0;
            while(result.next()){
                cust[i][0] = result.getString("nm_cust");
                cust[i][1] = result.getString("nm_vcd");
                cust[i][2] = result.getString("biaya");
                cust[i][3] = result.getString("status");
                i++;
            }
            DB.statement.close();
        } catch(Exception err){
            System.out.println(err);
        }
        return cust;
    }
    
    public void insert(String nm_vcd, double harga){
        try{
            DB.statement = DB.koneksi.createStatement(); 
            String query = "INSERT INTO `vcd` (`nm_vcd`, `harga`) VALUES ('"+ nm_vcd +"', '"+ harga +"')";
            DB.statement.execute(query);
        }catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void update(String nm_vcd, double harga){
        try{
            
            DB.statement = DB.koneksi.createStatement(); 
            String query = "UPDATE `vcd` SET `harga` = '"+harga+"' WHERE `vcd`.`nm_vcd` = '" + nm_vcd + "'";
            DB.statement.execute(query);
        }catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void delete(String nm_vcd){
        try{
            DB.statement = DB.koneksi.createStatement(); 
            String query = "DELETE FROM `vcd` WHERE `vcd`.`nm_vcd` = \'"+nm_vcd+"\'";
            DB.statement.execute(query);
        }catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void insertCust(String nm_cust, String nm_vcd, double durasi, double harga){
        try{
            double biaya = (durasi*harga);
            String status = "Dipinjam";
            DB.statement = DB.koneksi.createStatement(); 
            String query = "INSERT INTO `penyewa` (`nm_cust`, `nm_vcd`, `biaya`, `status`) VALUES ('"+ nm_cust+"', '"+ nm_vcd +"', '"+ biaya +"', '"+ status +"')";
            DB.statement.execute(query);
        }catch(Exception err){
            System.out.println(err);
        }
    }

    public void deleteCust(String nm_vcd) {
        try{
            DB.statement = DB.koneksi.createStatement(); 
            String query = "DELETE FROM `penyewa` WHERE `nm_vcd` = \'"+nm_vcd+"\'";
            DB.statement.execute(query);
        }catch(Exception err){
            System.out.println(err);
        }}
}
