/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Database;
import model.Kasir;
import model.Koordinator;
import model.Manajer;
import model.Session;
import report.ReportGenerator;
import view.HalamanLogin;
import view.*;

/**
 *
 * @author Tabul
 */
public class Controller extends MouseAdapter implements ActionListener{
    private View view;
    
    public Controller(){
        HalamanLogin hl = new HalamanLogin();
        hl.setVisible(true);
        hl.addListener((ActionListener) this);
        view = hl;
        Database.getInstance().connect();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (view instanceof HalamanLogin){
            HalamanLogin hl = (HalamanLogin) view;
            if (source.equals(hl.getBtnLogin())){
                try{
                    Session.getInstance().login(hl.getTfUsername().getText(), hl.getTfPassword().getText());
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(hl, "Username atau password tidak cocok");
                }
                if (Session.getPegawai() != null && Session.getManajer() == null){
                    if (Session.getPegawai().getAkses().equalsIgnoreCase("koordinator")){
                        MenuKoordinator mk = new MenuKoordinator();
                        mk.setVisible(true);
                        mk.addListener(this);
                        hl.dispose();
                        view = mk;
                    }
                    else if (Session.getPegawai().getAkses().equalsIgnoreCase("kasir")){
                        MenuKasir mks = new MenuKasir();
                        mks.setVisible(true);
                        mks.addListener(this);
                        hl.dispose();
                        view = mks;
                    }
                    else if (Session.getPegawai().getAkses().equalsIgnoreCase("gudang")){
                        MainGudang mg = new MainGudang();
                        hl.dispose();
                        mg.setVisible(true);
                        mg.addListener(this);
                        view = mg;
                    }
                }
                else if (Session.getManajer() != null && Session.getPegawai() == null){
                    MainManajer mm = new MainManajer();
                    hl.dispose();
                    mm.setVisible(true);
                    mm.addListener(this);
                    view = mm;
                }
                else{
                    System.out.println("ERROR!!");
                }
            }
        }
        else if (view instanceof MainManajer){
            MainManajer mm = (MainManajer) view;
            if (source.equals(mm.getBtnLogout())){
                Session.setManajer(null);
                Session.setPegawai(null);
                HalamanLogin hl = new HalamanLogin();
                mm.dispose();
                hl.addListener(this);
                hl.setVisible(true);
                view = hl;
            }
            else if (source.equals(mm.getBtnDataLaporan())){
                LaporanManajer lm = new LaporanManajer();
                mm.dispose();
                lm.setVisible(true);
                lm.addListener(this);
                view = lm;
            }
            else if (source.equals(mm.getBtnRegistrasi())){
                InputPegawai ip = new InputPegawai();
                mm.dispose();
                ip.setVisible(true);
                ip.addListener(this);
                view = ip;
            }
            else if (source.equals(mm.getBtnDataPegawai())){
                LihatPegawai lp = new LihatPegawai();
                mm.dispose();
                lp.setVisible(true);
                lp.addListener(this);
                view = lp;
            }
        }
        else if (view instanceof LihatPegawai){
            LihatPegawai lp = (LihatPegawai) view;
            if (source.equals(lp.getBtnBack())){
                MainManajer mm = new MainManajer();
                lp.dispose();
                mm.setVisible(true);
                mm.addListener(this);
                view = mm;
            }
        }
        else if (view instanceof InputPegawai){
            InputPegawai ip = (InputPegawai) view;
            if (source.equals(ip.getBtnBack())){
                System.out.println("AAA");
                MainManajer mm = new MainManajer();
                ip.dispose();
                mm.setVisible(true);
                mm.addListener(this);
                view = mm;
            }
            else if (source.equals(ip.getBtnSubmit())){
                System.out.println("AAA");
                String noktp = ip.getTfNoKtp().getText();
                String nama = ip.getTfNama().getText();
                String alamat = ip.getTfAlamat().getText();
                String gaji = ip.getTfGaji().getText();
                String username = ip.getTfUsername().getText();
                String password = ip.getTfPassword().getText();
                String email = ip.getTfEmail().getText();
                String posisi = ip.getCbPosisi().getItemAt(ip.getCbPosisi()
                        .getSelectedIndex());
                System.out.println(posisi);
                
//                Manajer man = (Manajer) Session.getManajer();
//                man.daftarPegawai(noktp, nama, alamat, gaji, username, password, email, posisi, ip);
                try {
                    String query = "INSERT INTO user VALUES ('"
                        + username + "', '" 
                        + password + "', '" + nama + "', '"
                        + email + "', '" 
                        + posisi + "', " 
                        + gaji + ", '" 
                        + noktp + "', '" 
                        + alamat + "')";
                    Database.getInstance().getStatement().executeUpdate(query);
                    ip.showMessage("Data pegawai berhasil diinput");
                } catch (SQLException ex) {
                    ip.showMessage("Username telah digunakan");
                }
            }
        }
        else if (view instanceof MenuKasir){
            MenuKasir mks = (MenuKasir) view;
            if (source.equals(mks.getBtnLogout())){
                Session.setManajer(null);
                Session.setPegawai(null);
                HalamanLogin lg = new HalamanLogin();
                lg.setVisible(true);
                lg.addListener(this);
                mks.dispose();
                view = lg;
            }
            else if (source.equals(mks.getBtnTransaksi())){
                Transaksi trk = new Transaksi();
                trk.setVisible(true);
                trk.addListener(this);
                mks.dispose();
                view = trk;
            }
        }
        else if (view instanceof MenuKoordinator){
            MenuKoordinator mk = (MenuKoordinator) view;
            if (source.equals(mk.getBtnLogout())){
                Session.setManajer(null);
                Session.setPegawai(null);
                HalamanLogin lg = new HalamanLogin();
                lg.setVisible(true);
                lg.addListener(this);
                mk.dispose();
                view = lg;
            }
            else if (source.equals(mk.getBtnPengeluaran())){
                Date date= new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                System.out.println(month);
                System.out.println(year);
                try{
                    String query = "SELECT * FROM laporan WHERE MONTH(tanggal) = " + month + " AND YEAR(tanggal) = " + year;
                    Statement statement = Database.getInstance().getStatement();
                    ResultSet rs = statement.executeQuery(query);
                    if (!rs.next()){
                        PengeluaranOp po = new PengeluaranOp();
                        po.setVisible(true);
                        po.addListener(this);
                        mk.dispose();
                        view = po;
                    }
                    else{
                        JOptionPane.showMessageDialog(mk, "Anda sudah membuat laporan untuk bulan sebelumnya dan belum saatnya membuat laporan bulan ini.");
                    }
                }
                catch (SQLException e){
                    throw new IllegalArgumentException("Error for notifications!");
                }
            }
            else if (source.equals(mk.getBtnLaporan())){
                LaporanKoor lk = new LaporanKoor();
                mk.dispose();
                lk.setVisible(true);
                lk.addListener(this);                
                view = lk;
            }
            else if (source.equals(mk.getBtnPemesanan())){
                PemesananBarang pb = new PemesananBarang();
                pb.setVisible(true);
                pb.addListener(this);
                mk.dispose();
                view = pb;
            }
        }
        else if (view instanceof MainManajer){
            
        }
        else if (view instanceof LihatBarang){
            LihatBarang lb = (LihatBarang) view;
            if (source.equals(lb.getBtnBack())){
                MainGudang mg = new MainGudang();
                lb.dispose();
                mg.setVisible(true);
                mg.addListener(this);
                view = mg;
            }
        }
        else if (view instanceof MainGudang){
            MainGudang mg = (MainGudang) view;
            if (source.equals(mg.getBtnDaftarBarang())){
                LihatBarang lb = new LihatBarang();
                mg.dispose();
                lb.setVisible(true);
                lb.addListener(this);
                view = lb;
            }
            else if (source.equals(mg.getBtnSupplier())){
                DaftarSupplier ds = new DaftarSupplier();
                mg.dispose();
                ds.setVisible(true);
                ds.addListener(this);
                view = ds;
            }
            else if (source.equals(mg.getBtnInputBarang())){
                InputBarang ib = new InputBarang();
                mg.dispose();
                ib.setVisible(true);
                ib.addListener(this);
                view = ib;
            }
            else if (source.equals(mg.getBtnLogout())){
                Session.setManajer(null);
                Session.setPegawai(null);
                HalamanLogin hl = new HalamanLogin();
                mg.dispose();
                hl.setVisible(true);
                hl.addListener(this);
                view = hl;
            }
        }
        else if (view instanceof InputBarang){
            InputBarang ib = (InputBarang) view;
            if (source.equals(ib.getBtnBack())){
                MainGudang mg = new MainGudang();
                ib.dispose();
                mg.setVisible(true);
                mg.addListener(this);
                view = mg;
            }
            else if (source.equals(ib.getBtnSubmit())){
                String barcode = ib.getTfKodeBarang().getText();
                String nama = ib.getTfNamaBarang().getText();
                String jenis = ib.getTfJenisBarang().getText();
                String harga_beli = ib.getTfHargaBeli().getText();
                String harga_jual = ib.getTfHargaJual().getText();
                String jumlah = ib.getTfJumlah().getValue().toString();
                System.out.println(jumlah);
                
                String query = "INSERT INTO barang (barcode, nama, jenis, harga_beli, harga_jual, stok) "
                        + "VALUES ('"+ barcode + "', + '"+ nama +"', '"+ jenis +"', " + harga_beli +", " + harga_jual + ", " + jumlah +")";
                try {
                    Database.getInstance().getStatement().executeUpdate(query);
                    ib.showMessage("Data barang berhasil diinput");
                } catch (SQLException ex) {
                    query = "UPDATE barang SET stok=stok+" + jumlah + " "
                            + "WHERE barcode='" + barcode + "'" ;
                    try {
                        Database.getInstance().getStatement().executeUpdate(query);
                        ib.showMessage("Stok berhasil diupdate");
                    } catch (SQLException ex1) {
                        ib.showMessage("Lengkapi semua data");
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        }
        else if (view instanceof DaftarSupplier){
            DaftarSupplier ds = (DaftarSupplier) view;
            if (source.equals(ds.getBtnBack())){
                ds.dispose();
                MainGudang mg = new MainGudang();
                mg.setVisible(true);
                mg.addListener(this);
                view = mg;
            }
            else if (source.equals(ds.getBtnSubmit())){
                String nama = ds.getTfNamaSupplier().getText();
                String no_kontak = ds.getTfKontakSupplier().getText();
                String alamat = ds.getTfAlamatSupplier().getText();
                        
                String query = "INSERT INTO supplier (nama, no_kontak, alamat) "
                        + "VALUES ('"+ nama + "', + "+ no_kontak +", '"+ alamat +"')";
                try {
                    Database.getInstance().getStatement().executeUpdate(query);
                    ds.showMessage("Data supplier berhasil diinput");
                    ds.clearText();
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    ds.showMessage("Input tidak sesuai (cek nomer kontak)");
                }
                ds.loadTable();
            }
        }
        else if (view instanceof PemesananBarang){
            PemesananBarang pb = (PemesananBarang) view;
            if (source.equals(pb.getBtnBack())){
                pb.dispose();
                MenuKoordinator mk = new MenuKoordinator();
                mk.setVisible(true);
                mk.addListener(this);
                view = mk;
            }
            else if (source.equals(pb.getBtnSubmit())){
                long total_harga = Long.parseLong(pb.getTfTotal().getText());
                int id_pemesanan = Integer.valueOf(pb.getTfIdPemesanan().getText());
                Koordinator koor = (Koordinator) Session.getPegawai();
                koor.pengadaanBarang(total_harga);
                DefaultTableModel target = (DefaultTableModel) pb.getTablePemesananBarang().getModel();
                for (int i=0; i<target.getRowCount(); i++){
                    String barcode = target.getValueAt(i, 0).toString();
                    int jml_beli = Integer.parseInt(target.getValueAt(i, 6).toString());
                    if (jml_beli > 0){
                        String query = "INSERT INTO detil_pengadaan VALUES "
                                + "(" + id_pemesanan + ", '" + barcode + "', " + jml_beli + ")";
                        try {
                            Database.getInstance().getStatement().executeUpdate(query);
                        } catch (SQLException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                pb.showMessage("Data pemesanan telah disimpan.");
                target.setRowCount(0);
                pb.clearPemesanan();
            }   
        }
        else if (view instanceof Transaksi){
            Transaksi trk = (Transaksi) view;
            if (source.equals(trk.getBtnBack())){
                MenuKasir mks = new MenuKasir();
                trk.dispose();
                mks.setVisible(true);
                mks.addListener(this);
                view = mks;
            }
            else if (source.equals(trk.getBtnOk())){
                DefaultTableModel target = (DefaultTableModel) trk.getTableTranksaksi().getModel();
                if (target.getColumnCount() == 0){
                    JOptionPane.showMessageDialog(trk, "Belum ada barang dalam transaksi");
                }
                else if ("".equals(trk.getTfBayar().getText())){
                    JOptionPane.showMessageDialog(trk, "Anda belum memasukkan jumlah bayar konsumen");
                }
                else if (Integer.parseInt(trk.getTfBayar().getText()) < Integer.parseInt(trk.getTfTotalHarga().getText())){
                    trk.showMessage("Uang konsumen kurang euy!");
                }
                else{
                    int id_transaksi = Integer.parseInt(trk.getTfNoTransaksi().getText());
                    long total_harga = Long.parseLong(trk.getTfTotalHarga().getText());
                    
                    Kasir kas = (Kasir) Session.getPegawai();
                    kas.tambahTransaksi(total_harga, kas.getName());
                    
                    for (int i=0; i<target.getRowCount(); i++){
                        String barcode = target.getValueAt(i, 1).toString();
                        int jml_beli = Integer.parseInt(target.getValueAt(i, 3).toString());
                        if (jml_beli > 0){
                            try {
                                String query = "INSERT INTO detil_transaksi VALUES "
                                    + "(" + id_transaksi + ", '" + barcode + "', " + jml_beli + ")";
                                Database.getInstance().getStatement().executeUpdate(query);
                                
                                query = "UPDATE barang SET stok=stok-"+ jml_beli +" WHERE barcode='" + barcode +"'";
                                Database.getInstance().getStatement().executeUpdate(query);
                            } catch (SQLException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    target.setRowCount(0);
                    trk.updateTrk();
                }
            }
        }
        else if (view instanceof LaporanKoor){
            LaporanKoor lk = (LaporanKoor) view;
            if (source.equals(lk.getBtnBack())){
                MenuKoordinator mk = new MenuKoordinator();
                lk.dispose();
                mk.setVisible(true);
                mk.addListener(this);
                view = mk;
            }
        }
        else if (view instanceof LaporanManajer){
            LaporanManajer lm = (LaporanManajer) view;
            if (source.equals(lm.getBtnBack())){
                MainManajer mm = new MainManajer();
                lm.dispose();
                mm.setVisible(true);
                mm.addListener(this);
                view = mm;
            }
        }
        else if (view instanceof PengeluaranOp){
            PengeluaranOp po = (PengeluaranOp) view;
            if (source.equals(po.getBtnSubmit())){
                try {
                    long total_tagihan = Long.parseLong(po.getTfTagihanListrik().getText()) + Long.parseLong(po.getTfTagihanListrik().getText());
                    Koordinator koor = (Koordinator) Session.getPegawai();
                    koor.buatLaporan(total_tagihan);
                    po.showMessage("Laporan sudah dibuat secara otomatis");
                    MenuKoordinator mk = new MenuKoordinator();
                    mk.setVisible(true);
                    mk.addListener(this);
                    po.dispose();
                    view = mk;
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    po.showMessage("Something wrong!");
                }
            }
            else if (source.equals(po.getBtnBack())){
                MenuKoordinator mk = new MenuKoordinator();
                po.dispose();
                mk.setVisible(true);
                mk.addListener(this);
                view = mk;
            }
        }
    }
}
