/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.lowagie.text.pdf.PdfName;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Database;
import model.Manajer;
import model.Session;

/**
 *
 * @author Nadine Azhalia
 */
public class LaporanManajer extends javax.swing.JFrame implements View{

    /**
     * Creates new form LaporanKoor
     */
    public LaporanManajer() {
        initComponents();
        Database.getInstance().connect();
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableLaporanKeuangan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableLaporanPengadaan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableLaporanPenjualan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(142, 0, 0));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Laporan Citramart");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Citramart");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Backbtn.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);

        jTabbedPane5.setForeground(new java.awt.Color(142, 0, 0));
        jTabbedPane5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        JTableLaporanKeuangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Laporan", "Tanggal", "Jenis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableLaporanKeuangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableLaporanKeuanganMouseClicked(evt);
            }
        });
        JTableLaporanKeuangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTableLaporanKeuanganKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTableLaporanKeuangan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        jTabbedPane5.addTab("Laporan Keuangan", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        JTableLaporanPengadaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Laporan", "Tanggal", "Jenis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableLaporanPengadaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableLaporanPengadaanMouseClicked(evt);
            }
        });
        JTableLaporanPengadaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTableLaporanPengadaanKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(JTableLaporanPengadaan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        jTabbedPane5.addTab("Laporan Pengadaan Barang", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        JTableLaporanPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Laporan", "Tanggal", "Jenis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableLaporanPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableLaporanPenjualanMouseClicked(evt);
            }
        });
        JTableLaporanPenjualan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTableLaporanPenjualanKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(JTableLaporanPenjualan);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        jTabbedPane5.addTab("Laporan Penjualan", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableLaporanKeuanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableLaporanKeuanganMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            System.out.println(row);
            if (Desktop.isDesktopSupported()){
                try{
                    String idLap = (String) target.getModel().getValueAt(row, 0);
                    System.out.println(idLap);
                    String query = "SELECT path FROM laporan WHERE idLaporan="+idLap;
                    ResultSet rs = Database.getInstance().getStatement().executeQuery(query);
                    rs.next();
                    File myFile = new File(rs.getString("path"));
                    Desktop.getDesktop().open(myFile);
                }
                catch (IOException e){
                    System.out.println("no such file!");
                } catch (SQLException ex) {
                    System.out.println("connection error!/Query WRong!!");
                }
            }
        }
    }//GEN-LAST:event_JTableLaporanKeuanganMouseClicked

    private void JTableLaporanPengadaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableLaporanPengadaanMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            System.out.println(row);
            if (Desktop.isDesktopSupported()){
                try{
                    String idLap = (String) target.getModel().getValueAt(row, 0);
                    System.out.println(idLap);
                    String query = "SELECT path FROM laporan WHERE idLaporan="+idLap;
                    ResultSet rs = Database.getInstance().getStatement().executeQuery(query);
                    rs.next();
                    File myFile = new File(rs.getString("path"));
                    Desktop.getDesktop().open(myFile);
                }
                catch (IOException e){
                    System.out.println("no such file!");
                } catch (SQLException ex) {
                    System.out.println("connection error!/Query WRong!!");
                }
            }
        }
    }//GEN-LAST:event_JTableLaporanPengadaanMouseClicked

    private void JTableLaporanPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableLaporanPenjualanMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            System.out.println(row);
            if (Desktop.isDesktopSupported()){
                try{
                    String idLap = (String) target.getModel().getValueAt(row, 0);
                    System.out.println(idLap);
                    String query = "SELECT path FROM laporan WHERE idLaporan="+idLap;
                    ResultSet rs = Database.getInstance().getStatement().executeQuery(query);
                    rs.next();
                    File myFile = new File(rs.getString("path"));
                    Desktop.getDesktop().open(myFile);
                }
                catch (IOException e){
                    System.out.println("no such file!");
                } catch (SQLException ex) {
                    System.out.println("connection error!/Query WRong!!");
                }
            }
        }
    }//GEN-LAST:event_JTableLaporanPenjualanMouseClicked

    private void JTableLaporanKeuanganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTableLaporanKeuanganKeyPressed
        // TODO add your handling code here:        
        if (evt.getKeyChar() == KeyEvent.VK_DELETE){
            System.out.println("AA");
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            String tanggal = (String) target.getModel().getValueAt(row, 1);
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
            loadTable();
        }
    }//GEN-LAST:event_JTableLaporanKeuanganKeyPressed

    private void JTableLaporanPengadaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTableLaporanPengadaanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_DELETE){
            System.out.println("AA");
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            String tanggal = (String) target.getModel().getValueAt(row, 1);
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
            loadTable();
        }
    }//GEN-LAST:event_JTableLaporanPengadaanKeyPressed

    private void JTableLaporanPenjualanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTableLaporanPenjualanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_DELETE){
            System.out.println("AA");
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            String tanggal = (String) target.getModel().getValueAt(row, 1);
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
            loadTable();
        }
    }//GEN-LAST:event_JTableLaporanPenjualanKeyPressed

    private void loadTable(){
        DefaultTableModel table_keuangan = (DefaultTableModel) JTableLaporanKeuangan.getModel();
        
        
        DefaultTableModel table_pengadaan = (DefaultTableModel) JTableLaporanPengadaan.getModel();
        
        DefaultTableModel table_penjualan = (DefaultTableModel) JTableLaporanPenjualan.getModel();
        
        Manajer man = (Manajer) Session.getManajer();
        man.lihatLaporan(table_keuangan, table_pengadaan, table_penjualan);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LaporanKoor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanKoor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanKoor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanKoor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanKoor().setVisible(true);
            }
        });
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableLaporanKeuangan;
    private javax.swing.JTable JTableLaporanPengadaan;
    private javax.swing.JTable JTableLaporanPenjualan;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addListener(ActionListener e) {
        btnBack.addActionListener(e);
    }

    @Override
    public void showMessage(String msg) {
    }
}
