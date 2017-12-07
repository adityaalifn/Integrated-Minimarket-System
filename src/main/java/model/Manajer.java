/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import view.DaftarSupplier;
import view.InputPegawai;
import view.View;

/**
 *
 * @author Tabul
 */
public class Manajer extends User{
    public Manajer(String username, String password, String name, String email, String akses) {
        super(username, password, name, email, akses);
    }
    
    public void lihatLaporan(DefaultTableModel table_keuangan, DefaultTableModel table_pengadaan, DefaultTableModel table_penjualan){
        table_keuangan.setRowCount(0);
        try{
            String query = "SELECT * FROM laporan WHERE jenis='keuangan'";
            Statement statement = Database.getInstance().getStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("A");
            while (rs.next()){
                System.out.println("B");
                table_keuangan.addRow(new Object[]{rs.getString("idLaporan"), rs.getString("tanggal"), rs.getString("jenis")});
            }
        }
        catch (SQLException e){
            throw new IllegalArgumentException("error loading laporan!");
        }
        
        table_pengadaan.setRowCount(0);
        try{
            String query = "SELECT * FROM laporan WHERE jenis='pengadaan'";
            Statement statement = Database.getInstance().getStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("A");
            while (rs.next()){
                System.out.println("B");
                table_pengadaan.addRow(new Object[]{rs.getString("idLaporan"), rs.getString("tanggal"), rs.getString("jenis")});
            }
        }
        catch (SQLException e){
            throw new IllegalArgumentException("error loading laporan!");
        }
        
        table_penjualan.setRowCount(0);
        try{
            String query = "SELECT * FROM laporan WHERE jenis='penjualan'";
            Statement statement = Database.getInstance().getStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("A");
            while (rs.next()){
                System.out.println("B");
                table_penjualan.addRow(new Object[]{rs.getString("idLaporan"), rs.getString("tanggal"), rs.getString("jenis")});
            }
        }
        catch (SQLException e){
            throw new IllegalArgumentException("error loading laporan!");
        }
    }
    
    public void lihatDataPegawai(DefaultTableModel target){
        target.setRowCount(0);
        try {
            ResultSet rs = Database.getInstance().getStatement().executeQuery("SELECT * FROM user");
            while (rs.next()){
                target.addRow(new Object[]{rs.getString("noktp"), rs.getString("nama"), rs.getString("alamat"), rs.getInt("gaji"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("akses")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void daftarPegawai(String noktp, String nama, String alamat, String gaji,
                String username, String password, String email, String posisi, InputPegawai gui){
        String query = "INSERT INTO user VALUES ('"
                        + username + "', '" + password + "', '" + nama + "', '"
                        + email + "', '" + posisi + "', " + gaji + ", '" + noktp + "', '" + alamat + "')";
                
                try {
                    Database.getInstance().getStatement().executeQuery(query);
                    gui.showMessage("Data pegawai berhasil diinput");
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    gui.showMessage("Username telah digunakan");
                }
                
    }
}
