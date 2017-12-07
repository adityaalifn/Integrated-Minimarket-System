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
public class Laporan {
    private String idLaporan;
    private String tanggal;
    private String jenis;
    private Blob fileLaporan;

    public Laporan(String idLaporan, String tanggal, String jenis, Blob fileLaporan) {
        this.idLaporan = idLaporan;
        this.tanggal = tanggal;
        this.jenis = jenis;
        this.fileLaporan = fileLaporan;
    }

    public String getIdLaporan() {
        return idLaporan;
    }

    public void setIdLaporan(String idLaporan) {
        this.idLaporan = idLaporan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Blob getFileLaporan() {
        return fileLaporan;
    }

    public void setFileLaporan(Blob fileLaporan) {
        this.fileLaporan = fileLaporan;
    }
    
    
}
