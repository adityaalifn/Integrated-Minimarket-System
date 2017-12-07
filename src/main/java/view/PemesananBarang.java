/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import model.Database;

/**
 *
 * @author Nadine Azhalia
 */
public class PemesananBarang extends javax.swing.JFrame implements View{

    /**
     * Creates new form PemesananBarang
     */
    public PemesananBarang() {
        initComponents();
        Database.getInstance().connect();
        tfTotal.setEditable(false);
        tfIdPemesanan.setEditable(false);
        
        tfTotal.setText("0");
        try {
            ResultSet rs = Database.getInstance().getStatement().executeQuery("SELECT MAX(id_pengadaan) AS no_trk FROM pengadaan");
            rs.next();
            tfIdPemesanan.setText(String.valueOf(rs.getInt("no_trk")+1));
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel target = (DefaultTableModel) tablePemesananBarang.getModel();
        try{
            String query = "SELECT * FROM barang";
            Statement statement = Database.getInstance().getStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("A");
            while (rs.next()){
                System.out.println("B");
                target.addRow(new Object[]{rs.getString("barcode"), rs.getString("nama"), rs.getString("jenis"), rs.getInt("harga_jual"), rs.getInt("harga_beli"), rs.getInt("stok"), 0});
            }
        }
        catch (SQLException e){
            throw new IllegalArgumentException("error loading laporan!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePemesananBarang = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        tfTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfIdPemesanan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jLabel3.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(142, 0, 0));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Citramart");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pemesanan Barang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30))))
        );

        tablePemesananBarang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(142, 0, 0), 1, true));
        tablePemesananBarang.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        tablePemesananBarang.setForeground(new java.awt.Color(142, 0, 0));
        tablePemesananBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jenis", "Harga Jual", "Harga Beli", "Stok", "Jumlah yang dipesan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePemesananBarang.setGridColor(new java.awt.Color(255, 255, 255));
        tablePemesananBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tablePemesananBarangFocusLost(evt);
            }
        });
        tablePemesananBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablePemesananBarangKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablePemesananBarang);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Backbtn.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/submit.png"))); // NOI18N
        btnSubmit.setBorder(null);
        btnSubmit.setBorderPainted(false);
        btnSubmit.setContentAreaFilled(false);

        tfTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(142, 0, 0), 1, true));
        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        jLabel2.setText("Total Pemesanan: ");

        jLabel4.setText("Rp.");

        tfIdPemesanan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(142, 0, 0), 1, true));
        tfIdPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPemesananActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Pemesanan:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIdPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack)
                            .addGap(18, 18, 18)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfIdPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    private void tfIdPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPemesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPemesananActionPerformed

    private void tablePemesananBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablePemesananBarangFocusLost
        // TODO add your handling code here:
        int jml = 0;
        for (int i=0; i<tablePemesananBarang.getRowCount(); i++){
            jml += Integer.parseInt(tablePemesananBarang.getValueAt(i, 4).toString()) * Integer.parseInt(tablePemesananBarang.getValueAt(i, 6).toString());
        }
        tfTotal.setText(String.valueOf(jml));
    }//GEN-LAST:event_tablePemesananBarangFocusLost

    private void tablePemesananBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablePemesananBarangKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER){
            int jml = 0;
            for (int i=0; i<tablePemesananBarang.getRowCount(); i++){
                jml += Integer.parseInt(tablePemesananBarang.getValueAt(i, 4).toString()) * Integer.parseInt(tablePemesananBarang.getValueAt(i, 6).toString());
            }
            tfTotal.setText(String.valueOf(jml));
        }
    }//GEN-LAST:event_tablePemesananBarangKeyPressed

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
            java.util.logging.Logger.getLogger(PemesananBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PemesananBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PemesananBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PemesananBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PemesananBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePemesananBarang;
    private javax.swing.JTextField tfIdPemesanan;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addListener(ActionListener e) {
        btnBack.addActionListener(e);
        btnSubmit.addActionListener(e);
    }

    @Override
    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(JButton btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    public JTable getTablePemesananBarang() {
        return tablePemesananBarang;
    }

    public void setTablePemesananBarang(JTable tablePemesananBarang) {
        this.tablePemesananBarang = tablePemesananBarang;
    }

    public JTextField getTfTotal() {
        return tfTotal;
    }

    public void setTfTotal(JTextField tfTotal) {
        this.tfTotal = tfTotal;
    }

    public JTextField getTfIdPemesanan() {
        return tfIdPemesanan;
    }

    public void setTfIdPemesanan(JTextField tfIdPemesanan) {
        this.tfIdPemesanan = tfIdPemesanan;
    }
    
    public void clearPemesanan(){
        tfTotal.setText("0");
        try {
            ResultSet rs = Database.getInstance().getStatement().executeQuery("SELECT MAX(id_pengadaan) AS no_peng FROM pengadaan");
            rs.next();
            tfIdPemesanan.setText(String.valueOf(rs.getInt("no_peng")+1));
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void tableChanged(TableModelEvent cel){
        
                
    }
}