/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import report.ReportGenerator;
import view.LaporanKoor;

/**
 *
 * @author Tabul
 */
public class Koordinator extends Pegawai{
    public Koordinator(int gaji, Blob sidikJari, String username, String password, String name, String email, String akses) {
        super(gaji, sidikJari, username, password, name, email, akses);
    }
    
    public Koordinator(String username, String password, String name, String email, String akses, long gaji) {
        super(username, password, name, email, akses, gaji);
    }
    
    public void buatLaporan(long total_tagihan){
        try {
            ReportGenerator rg = new ReportGenerator(total_tagihan);
            rg.generateLaporanPenjualan();
            rg.generateLaporanPengadaan();
            rg.generateLaporanKeuangan();
        } catch (Exception ex) {
            Logger.getLogger(Koordinator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pengadaanBarang(long total_harga){
        String query = "INSERT INTO pengadaan (total_pengeluaran, tanggal) "
                        + "VALUES (" + total_harga + ", NOW())";
                try {
                    Database.getInstance().getStatement().executeUpdate(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public void editPengadaanBarang(){
        
    }
    
    public void batalkanPengadaanBarang(){
        
    }
    
    public void hapusLaporan(String tanggal){
        String query = "DELETE FROM laporan\n" +
                        "WHERE tanggal = '" + tanggal + "'";
            try {
                Database.getInstance().getStatement().executeUpdate(query);
                query = "DELETE FROM pengeluaran\n" +
                        "WHERE tanggal = '" + tanggal + "'";
                Database.getInstance().getStatement().executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(LaporanKoor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
