/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopsem2.main;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import workshopsem2.Utils;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tole
 */
public class PengeluaranForm extends javax.swing.JFrame {

    /**
     * Creates new form PengeluaranForm
     */
    List<Integer> listIDKategori = new ArrayList<Integer>();
    List<Integer> listIDPengeluaran = new ArrayList<Integer>();
    int idPengeluaranForm, cond;
    
    public PengeluaranForm() {
        initComponents();
        loadData("");
        loadKategoriPengeluaran();
        dis();
    }
    
    void loadData(String param){
        String query = "select pengeluaran.deskripsi pengeluaran.id_pengeluaran, mst_kategori_pengeluaran.nama_kategori, pengeluaran.jumlah_pengeluaran, pengeluaran.tgl_pengeluaran from pengeluaran join mst_kategori_pengeluaran on mst_kategori_pengeluaran.id_kategori_pengeluaran = pengeluaran.id_kategori_pengeluaran " + param;
        try {
            Statement st = Utils.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            DefaultTableModel dt = new DefaultTableModel();
            dt.addColumn("No");
            dt.addColumn("Nama pengeluaran");
            dt.addColumn("Besaran");
            dt.addColumn("Tanggal");
            dt.addColumn("Deskripsi");
            jTable1.setModel(dt);
            int i = 1;
            
            while(rs.next()){
                dt.addRow(new Object[]{
                    i++,
                    rs.getString("nama_kategori"),
                    rs.getInt("jumlah_pengeluaran"),
                    new SimpleDateFormat("dd MMMM YYYY").format(rs.getDate("tgl_pengeluaran")),
                    (rs.getString("deskripsi") != null) ? rs.getString("deskripsi") : "-"
                });
                
                jTable1.setModel(dt);
                listIDPengeluaran.add(rs.getInt("id_pengeluaran"));
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    void loadKategoriPengeluaran(){
        String query = "select * from mst_kategori_pengeluaran";
        try {
            Statement st = (Statement) Utils.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                listIDKategori.add(rs.getInt("id_kategori_pengeluaran"));
                jComboBox1.addItem(rs.getString("nama_kategori"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PengeluaranForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void dis(){
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jComboBox1.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
    }
    
    void enabled(){
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jComboBox1.setEnabled(true);
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
    }
    
    void clear(){
        jTextField1.setText("");
        jTextField2.setText("");
    }
    
    boolean val(){
        if (jComboBox1.getSelectedItem() == null || jTextField1.getText().length() < 1) {
           JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
           return false;
        }
        
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(401, 401, 401)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGap(416, 416, 416)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cond = 1;
        enabled();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (idPengeluaranForm != 0) {
            cond = 2;
            enabled();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (idPengeluaranForm != 0) {
            int i = JOptionPane.showConfirmDialog(this, "Konfirmasi", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                String query = "DELETE FROM pengeluaran where id_pengeluaran = " + idPengeluaranForm;
                try {
                    Utils.execQuery(query);
                    JOptionPane.showMessageDialog(this, "Sukses");
                    
                    clear();
                    loadData("");
                    dis();
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String query, message;
        if (val()) {
            int idPengeluaran = listIDKategori.get(jComboBox1.getSelectedIndex());
            int jumlahPengeluaran = Integer.valueOf(jTextField1.getText().toString());
            if (cond == 1) {
                query = "INSERT INTO pengeluaran VALUES(null, 1, "+ idPengeluaran +", "+ jumlahPengeluaran +", now(), '"+jTextField2.getText().toString()+"')";
                message = "menambahkan";
            } else {
                query = "UPDATE `pengeluaran` SET id_kategori_pengeluaran = " + idPengeluaran +", jumlah_pengeluaran = " + jumlahPengeluaran + ", deskripsi = '"+ jTextField2.getText().toString() +"' where id_pengeluaran = " + idPengeluaranForm;
                System.out.println(query);
                message = "mengubah";
            }
            
            try {
                Utils.execQuery(query);
                JOptionPane.showMessageDialog(this, "Berhasil " + message + " data.");
                clear();
                dis();
                loadData("");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dis();
        clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        idPengeluaranForm = listIDPengeluaran.get(index);
        jComboBox1.setSelectedItem(jTable1.getValueAt(index, 1));
        jTextField1.setText(jTable1.getValueAt(index, 2).toString());
        jTextField2.setText(jTable1.getValueAt(index, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(PengeluaranForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengeluaranForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengeluaranForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengeluaranForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengeluaranForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
