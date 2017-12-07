/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;
import java.sql.SQLException;

/**
 *
 * @author Tabul
 */
public class Gudang extends Pegawai{
    
    public Gudang(int gaji, Blob sidikJari, String username, String password, String name, String email, String akses) {
        super(gaji, sidikJari, username, password, name, email, akses);
    }
    
    public Gudang(String username, String password, String name, String email, String akses, long gaji) {
        super(username, password, name, email, akses, gaji);
    }

    public void inputSupplier(String nama, String alamat, int no_kontak){
        Database.getInstance().connect();
        try {
            String query = "INSERT INTO supplier (nama, no_kontak, alamat) "
                        + "VALUES ('"+ nama + "', + "+ no_kontak +", '"+ alamat +"')";
            Database.getInstance().getStatement().execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Data Supplier sudah terdaftar!");
        }
    }
}
