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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Database;

/**
 *
 * @author Nadine Azhalia
 */
public class DaftarSupplier extends javax.swing.JFrame implements View{

    /**
     * Creates new form Supplier
     */
    public DaftarSupplier() {
        initComponents();
        try {
            DefaultTableModel target = (DefaultTableModel) tableSupplier.getModel();
            ResultSet rs = Database.getInstance().getStatement().executeQuery("SELECT * FROM supplier");
            while (rs.next()){
                target.addRow(new Object[]{rs.getString("id_supplier"), rs.getString("nama"), rs.getString("no_kontak"), rs.getString("alamat")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarSupplier.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNamaSupplier = new javax.swing.JTextField();
        tfKontakSupplier = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfAlamatSupplier = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(142, 0, 0));
        jLabel3.setText("Nama Supplier  :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(142, 0, 0));
        jLabel4.setText("Alamat               :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(142, 0, 0));
        jLabel5.setText("No. Kontak        :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, -1));

        jPanel2.setBackground(new java.awt.Color(142, 0, 0));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Citramart");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Input dan Data Supplier");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 100));

        tfNamaSupplier.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        tfNamaSupplier.setForeground(new java.awt.Color(51, 51, 51));
        tfNamaSupplier.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(142, 0, 0), 1, true));
        jPanel1.add(tfNamaSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 140, -1));

        tfKontakSupplier.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        tfKontakSupplier.setForeground(new java.awt.Color(51, 51, 51));
        tfKontakSupplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(142, 0, 0)));
        tfKontakSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKontakSupplierActionPerformed(evt);
            }
        });
        jPanel1.add(tfKontakSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 140, -1));

        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/submit.png"))); // NOI18N
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 80, 20));

        tfAlamatSupplier.setColumns(20);
        tfAlamatSupplier.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfAlamatSupplier.setForeground(new java.awt.Color(51, 51, 51));
        tfAlamatSupplier.setRows(5);
        tfAlamatSupplier.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(142, 0, 0), 1, true));
        tfAlamatSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(tfAlamatSupplier);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 140, 120));

        jSeparator1.setForeground(new java.awt.Color(142, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 30, 350));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(142, 0, 0));
        jLabel7.setText("Input Supplier");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        tableSupplier.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(142, 0, 0), 1, true));
        tableSupplier.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Supplier", "Nama Supplier", "No. Kontak", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableSupplierKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tableSupplier);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 350, 230));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Backbtn.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 400, 80, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(142, 0, 0));
        jLabel8.setText("Data Supplier");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void tfKontakSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKontakSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKontakSupplierActionPerformed

    private void tableSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableSupplierKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_DELETE){
            System.out.println("AA");
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            String id_sup = (String) target.getModel().getValueAt(row, 0);
            String query = "DELETE FROM supplier\n" +
                        "WHERE id_supplier = " + id_sup + "";
            try {
                Database.getInstance().getStatement().executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(LaporanKoor.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadTable();
        }
        else if (evt.getKeyChar() == KeyEvent.VK_ENTER){
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            String id_sup = target.getValueAt(row, 0).toString();
            String nama = target.getValueAt(row, 1).toString();
            String kontak = target.getValueAt(row, 2).toString();
            String alamat = target.getValueAt(row, 3).toString();
            
            String query = "UPDATE supplier "
                    + "SET nama='" + nama + "', no_kontak=" + kontak + ", alamat='" + alamat + "' "
                    + "WHERE id_supplier=" + id_sup;
            try {
                System.out.println("AA");
                Database.getInstance().getStatement().executeUpdate(query);
                System.out.println("A");
                showMessage("Data supplier berhasil diubah");
            } catch (SQLException ex) {
                Logger.getLogger(LaporanKoor.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadTable();
        }
    }//GEN-LAST:event_tableSupplierKeyPressed

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
            java.util.logging.Logger.getLogger(DaftarSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextArea tfAlamatSupplier;
    private javax.swing.JTextField tfKontakSupplier;
    private javax.swing.JTextField tfNamaSupplier;
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

    public JTable getTableSupplier() {
        return tableSupplier;
    }

    public void setTableSupplier(JTable tableSupplier) {
        this.tableSupplier = tableSupplier;
    }

    public JTextArea getTfAlamatSupplier() {
        return tfAlamatSupplier;
    }

    public void setTfAlamatSupplier(JTextArea tfAlamatSupplier) {
        this.tfAlamatSupplier = tfAlamatSupplier;
    }

    public JTextField getTfKontakSupplier() {
        return tfKontakSupplier;
    }

    public void setTfKontakSupplier(JTextField tfKontakSupplier) {
        this.tfKontakSupplier = tfKontakSupplier;
    }

    public JTextField getTfNamaSupplier() {
        return tfNamaSupplier;
    }

    public void setTfNamaSupplier(JTextField tfNamaSupplier) {
        this.tfNamaSupplier = tfNamaSupplier;
    }
    
    public void loadTable(){
        try {
            DefaultTableModel target = (DefaultTableModel) tableSupplier.getModel();
            target.setRowCount(0);
            ResultSet rs = Database.getInstance().getStatement().executeQuery("SELECT * FROM supplier");
            while (rs.next()){
                target.addRow(new Object[]{rs.getString("id_supplier"), rs.getString("nama"), rs.getString("no_kontak"), rs.getString("alamat")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearText(){
        tfAlamatSupplier.setText("");
        tfNamaSupplier.setText("");
        tfKontakSupplier.setText("");
    }
}