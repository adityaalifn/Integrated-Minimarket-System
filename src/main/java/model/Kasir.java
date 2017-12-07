/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tabul
 */
public class Kasir extends Pegawai{
    public Kasir(String username, String password, String name, String email, String akses, long gaji) {
        super(username, password, name, email, akses, gaji);
    }
    
    public void tambahTransaksi(long total_harga, String kasir ){
        String query = "INSERT INTO transaksi (tanggal, total_harga, id_kasir) "
                            + "VALUES (NOW(), " + total_harga + ", '" + kasir + "')";
                    try {
                        Database.getInstance().getStatement().executeUpdate(query);
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    
    public ResultSet scanBarcode(String barcode){
        try {
            return Database.getInstance().getStatement().
                    executeQuery("SELECT * FROM barang WHERE barcode='"
                            + barcode +"'");
        } catch (SQLException ex) {
            Logger.getLogger(Kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void batalkanTransaksi(){
        
    }
}
