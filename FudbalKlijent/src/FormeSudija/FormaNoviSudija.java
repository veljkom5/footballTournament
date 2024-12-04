/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormeSudija;

import kontroler.KlijentskiKontroler;
import domeni.Sudija;
import forme.Main;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author veljk
 */
public class FormaNoviSudija extends javax.swing.JDialog {

    public FormaNoviSudija(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Unos sudije");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        btnZatvori = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDatumRodjenja = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Ime:");

        txtIme.setText("Hrastislav");

        jLabel3.setText("Prezime:");

        txtPrezime.setText("Nedeljkov");
        txtPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrezimeActionPerformed(evt);
            }
        });

        btnZatvori.setText("Zatvori");
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj sudiju");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel8.setText("Datum rodjenja:");

        txtDatumRodjenja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumRodjenja.setText("11.02.1992");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIme, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(txtPrezime)
                            .addComponent(txtDatumRodjenja))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZatvori)
                    .addComponent(btnDodaj))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            if (txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty()
                    || txtDatumRodjenja.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
                return;
            }

            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumRodjenja = sdf.parse(txtDatumRodjenja.getText());

            Sudija s = new Sudija(null, ime, prezime, datumRodjenja);

            KlijentskiKontroler.getInstance().addSudija(s);
            Main mf = (Main) getParent();
            mf.popuniSudije();
            JOptionPane.showMessageDialog(this, "Uspesno dodat sudija.");
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JFormattedTextField txtDatumRodjenja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables
}
