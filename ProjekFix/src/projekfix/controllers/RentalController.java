/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekfix.controllers;
import javax.swing.JOptionPane;
import projekfix.models.Rental;

/**
 *
 * @author wachid op
 */
public class RentalController extends Controller{
    Rental rental;
    Object[][] rent = new Object[100][1];
    Object[][] customer = new Object[100][3];
    public RentalController(Rental rental){
       this.rental = rental;
    }
    
    public Object[][] index(){
       rent = rental.getVcd();
       return rent;
   } 
    public Object[][] indexCust(){
       customer = rental.getCust();
       return customer;
   } 
    
    public void store(String nm_vcd, double harga){
        boolean sudahada = false;
        for (int i = 0; rent[i][0] != null; i++) {
            if(rent[i][0].toString().equals(nm_vcd)){
                sudahada = true;
                break;
            }
        }
        if(sudahada){
            JOptionPane.showMessageDialog(null,"Data Sudah ada dalam database!");
        } else {
            
                rental.insert(nm_vcd, harga);
                JOptionPane.showMessageDialog(null,"Berhasil Menambahkan Data!");
            
        }
    }
    
    public void update(String nm_vcd, double harga){
        boolean ketemu = false;
        int index = -1;
        for (int i = 0; rent[i][0] != null; i++) {
            if(rent[i][0].toString().equals(nm_vcd)){
                index = i;
                ketemu = true;
                break;
            }
        }
        if(ketemu){
            
                rental.update(rent[index][0].toString(), harga);
                JOptionPane.showMessageDialog(null,"Berhasil Mengupdate Data!");
            
        }else{
           JOptionPane.showMessageDialog(null,"Data tidak ditemukan!"); 
        }
    }
    
    public void delete(String nm_vcd){
        boolean ketemu = false;
        int index = -1;
        for (int i = 0; rent[i][0] != null; i++) {
            if(rent[i][0].toString().equals(nm_vcd)){
                index = i;
                ketemu = true;
                break;
            }
        }
        if(ketemu){
            rental.delete(rent[index][0].toString());
            JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data!");
        }else{
           JOptionPane.showMessageDialog(null,"Data tidak ditemukan!"); 
        }
    }
    

    public void storeCust(String nm_cust, String nm_vcd, double durasi, double harga) {
        rental.insertCust(nm_cust, nm_vcd, durasi, harga);
        JOptionPane.showMessageDialog(null,"Berhasil Menambahkan Data Cust!");
    }

    public void deleteCust(String nm_vcd) {
        rental.deleteCust(nm_vcd);
        }
    
}
