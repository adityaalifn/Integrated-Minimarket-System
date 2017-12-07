/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import static com.lowagie.text.xml.simpleparser.EntitiesToSymbol.map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Database;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Tabul
 */
public class ReportGenerator {
    private long total_tagihan = 0;
    private long total_penjualan = 0;
    private long total_pengadaan = 0;
    
    
    public ReportGenerator(long total_tagihan) {
        this.total_tagihan = total_tagihan;
    }
    
    public void generateLaporanPenjualan() throws Exception{
        Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        String fileName = month + "_" + year + "_penjualan.pdf";
        String dateStr = year + "-" + month + "-" + day;
        System.out.println(fileName);
        Database.getInstance().connect();
        ResultSet rs = Database.getInstance().getStatement().executeQuery("SELECT id_transaksi, tanggal, total_harga, SUM(total_harga) AS total_penjualan FROM transaksi\n" +
                                                                        "WHERE MONTH(tanggal) = MONTH(CURRENT_DATE())-1\n" +
                                                                        "AND YEAR(tanggal) = YEAR(CURRENT_DATE())\n" +
                                                                        "GROUP BY tanggal\n" +
                                                                        "ORDER BY tanggal ASC");
        
        JRDataSource jds = new JRResultSetDataSource(rs);
        JasperReport jr = JasperCompileManager.compileReport("D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\LaporanPenjualan.jrxml");
        JasperPrint jp = JasperFillManager.fillReport(jr,null, jds);
        JasperExportManager.exportReportToPdfFile(jp, "D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\"+fileName);
        
        rs = Database.getInstance().getStatement().executeQuery("SELECT SUM(total_harga) as total_penjualan FROM transaksi "
                + "WHERE MONTH(tanggal) = MONTH(CURRENT_DATE())-1 "
                + "AND YEAR(tanggal) = YEAR(CURRENT_DATE())");
        
        while (rs.next()){
            total_penjualan += rs.getLong("total_penjualan");
        }
        System.out.println(total_penjualan);
        
        
        String query = "INSERT INTO laporan (idLaporan, tanggal, jenis, path) VALUES (null, DATE_SUB(NOW(), INTERVAL 1 MONTH), 'penjualan', ?)";
        PreparedStatement ps = Database.getInstance().getConn().prepareStatement(query);
        ps.setString(1, "D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\"+fileName+"");
        ps.executeUpdate();
    }
    
    public void generateLaporanPengadaan() throws Exception{
        Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        String fileName = month + "_" + year + "_pengadaan.pdf";
        String dateStr = year + "-" + month + "-" + day;
        System.out.println(fileName);
        Database.getInstance().connect();
        ResultSet rs = Database.getInstance().getStatement().executeQuery("SELECT id_pengadaan, total_pengeluaran, tanggal, SUM(total_pengeluaran) AS total_pengadaan\n" +
                                                                        "FROM pengadaan\n" +
                                                                        "WHERE MONTH(tanggal) = MONTH(CURRENT_DATE())-1\n" +
                                                                        "AND YEAR(tanggal) = YEAR(CURRENT_DATE())\n" +
                                                                        "GROUP BY tanggal\n" +
                                                                        "ORDER BY tanggal ASC");
        
        JRDataSource jds = new JRResultSetDataSource(rs);
        JasperReport jr = JasperCompileManager.compileReport("D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\LaporanPengadaan.jrxml");
        JasperPrint jp = JasperFillManager.fillReport(jr,null, jds);
        JasperExportManager.exportReportToPdfFile(jp, "D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\"+fileName);
        
        rs = Database.getInstance().getStatement().executeQuery("SELECT SUM(total_pengeluaran) as total_pengadaan FROM pengadaan "
                + "WHERE MONTH(tanggal) = MONTH(CURRENT_DATE())-1 "
                + "AND YEAR(tanggal) = YEAR(CURRENT_DATE())");
        
        while (rs.next()){
            total_pengadaan += rs.getInt("total_pengadaan");
        }
        System.out.println(total_pengadaan);
        
        String query = "INSERT INTO laporan (idLaporan, tanggal, jenis, path) VALUES (null, DATE_SUB(NOW(), INTERVAL 1 MONTH), 'pengadaan', ?)";
        PreparedStatement ps = Database.getInstance().getConn().prepareStatement(query);
        ps.setString(1, "D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\"+fileName+"");
        ps.executeUpdate();
    }
    
    public void generateLaporanKeuangan() throws Exception{
        Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        String fileName = month + "_" + year + "_keuangan.pdf";
        String dateStr = year + "-" + month + "-" + day;
        System.out.println(fileName);
        Database.getInstance().connect();
        String queryInserPengeluaran = "INSERT INTO pengeluaran (id_pengeluaran, tanggal, total_tagihan, total_penjualan, total_pengadaan)"
                + " VALUES (NULL, DATE_SUB(NOW(), INTERVAL 1 MONTH), " + this.total_tagihan + ", " + this.total_penjualan +", " + this.total_pengadaan +");";
        Database.getInstance().getStatement().executeUpdate(queryInserPengeluaran);
        ResultSet rs = Database.getInstance().getStatement().executeQuery("SELECT MONTHNAME(tanggal) as bulan, YEAR(tanggal) as tahun, total_tagihan, total_penjualan, total_pengadaan, (total_penjualan-total_tagihan-total_pengadaan) AS laba FROM pengeluaran\n" +
                                                                        "WHERE MONTH(tanggal) = MONTH(CURRENT_DATE())-1\n" +
                                                                        "AND YEAR(tanggal) = YEAR(CURRENT_DATE())\n" +
                                                                        "GROUP BY tanggal\n" +
                                                                        "ORDER BY tanggal ASC");
        
        
        JRDataSource jds = new JRResultSetDataSource(rs);
        JasperReport jr = JasperCompileManager.compileReport("D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\LaporanKeuangan.jrxml");
        JasperPrint jp = JasperFillManager.fillReport(jr,null, jds);
        JasperExportManager.exportReportToPdfFile(jp, "D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\"+fileName);
        
        String query = "INSERT INTO laporan (idLaporan, tanggal, jenis, path) VALUES (null, DATE_SUB(NOW(), INTERVAL 1 MONTH), 'keuangan', ?)";
        PreparedStatement ps = Database.getInstance().getConn().prepareStatement(query);
        ps.setString(1, "D:\\!Telkom University\\Implementasi dan Pengujian Perangkat Lunak\\Object Oriented\\!BISMILLAH\\CIISys-FIX\\src\\report\\"+fileName+"");
        ps.executeUpdate();
    }
    
    public static void main(String[] args) throws Exception {
        ReportGenerator rg = new ReportGenerator(1000);
        rg.generateLaporanPenjualan();
        rg.generateLaporanPengadaan();
        rg.generateLaporanKeuangan();
    }
}
