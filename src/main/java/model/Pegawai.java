/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author Tabul
 */
public abstract class Pegawai extends User{
    private long gaji;
    private Blob sidikJari;

    public Pegawai(String username, String password, String name, String email, String akses, long gaji) {
        super(username, password, name, email, akses);
        this.gaji = gaji;
    }

    
    
    public Pegawai(int gaji, Blob sidikJari, String username, String password, String name, String email, String akses) {
        super(username, password, name, email, akses);
        this.gaji = gaji;
        this.sidikJari = sidikJari;
    }

    public long getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public Blob getSidikJari() {
        return sidikJari;
    }

    public void setSidikJari(Blob sidikJari) {
        this.sidikJari = sidikJari;
    }
    
    
}
