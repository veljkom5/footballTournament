/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import FormeSudija.FormaNoviSudija;
import FormeSudija.FormaPretragaSudije;
import FormeTurnir.FormaDetaljiTurnira;
import kontroler.KlijentskiKontroler;
import domeni.Administrator;
import domeni.Sudija;
import domeni.Tim;
import domeni.Turnir;
import domeni.Utakmica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeli.ModelTabeleTurniri;
import modeli.ModelTabeleUtakmice;
import sesija.Sesija;

/**
 *
 * @author veljk
 */
public class Main extends javax.swing.JFrame {

    Administrator ulogovani;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        this.ulogovani = Sesija.getInstance().getUlogovani();
        lblUlogovani.setText("Ulogovani administrator: " + ulogovani);
        setTitle("Klijentska forma");
        tblUtakmice.setModel(new ModelTabeleUtakmice());
        tblTurniri.setModel(new ModelTabeleTurniri());
        popuniSudije();
        popuniTimove();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUlogovani = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtDatumOd = new javax.swing.JFormattedTextField();
        txtDatumDo = new javax.swing.JFormattedTextField();
        cmbGrad = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbSudija = new javax.swing.JComboBox();
        cmbPrviTim = new javax.swing.JComboBox();
        cmbDrugiTim = new javax.swing.JComboBox();
        txtBrojGolovaPrvi = new javax.swing.JFormattedTextField();
        txtBrojGolovaDrugi = new javax.swing.JFormattedTextField();
        btnDodajUtakmicu = new javax.swing.JButton();
        btnObrisiUtakmicu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUtakmice = new javax.swing.JTable();
        btnUnesi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTurniri = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        miNoviSudija = new javax.swing.JMenuItem();
        miPretragaSudije = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miOdjava = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setText("Ulogovani");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Turnir"));

        jLabel1.setText("Naziv:");

        jLabel2.setText("Datum od:");

        jLabel3.setText("Datum do:");

        jLabel4.setText("Grad:");

        txtNaziv.setText("Turnir");

        txtDatumOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumOd.setText("01.02.2024");

        txtDatumDo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumDo.setText("11.02.2024");

        cmbGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beograd", "Leskovac", "Nis", "Pirot", "Subotica" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Utakmice"));

        jLabel5.setText("Sudija:");

        jLabel6.setText("Prvi tim:");

        jLabel7.setText("Drugi tim:");

        jLabel8.setText("Broj golova prvog tima:");

        jLabel9.setText("Broj golova drugog tima:");

        cmbSudija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbPrviTim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDrugiTim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtBrojGolovaPrvi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtBrojGolovaPrvi.setText("3");

        txtBrojGolovaDrugi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtBrojGolovaDrugi.setText("1");

        btnDodajUtakmicu.setText("Dodaj utakmicu");
        btnDodajUtakmicu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajUtakmicuActionPerformed(evt);
            }
        });

        btnObrisiUtakmicu.setText("Obrisi utakmicu");
        btnObrisiUtakmicu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiUtakmicuActionPerformed(evt);
            }
        });

        tblUtakmice.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUtakmice);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(119, 119, 119)
                        .addComponent(cmbSudija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(24, 24, 24)
                        .addComponent(txtBrojGolovaDrugi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDrugiTim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPrviTim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBrojGolovaPrvi))))
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnDodajUtakmicu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisiUtakmicu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbSudija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPrviTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBrojGolovaPrvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDrugiTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBrojGolovaDrugi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajUtakmicu)
                    .addComponent(btnObrisiUtakmicu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnUnesi.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnUnesi.setText("Unesi turnir");
        btnUnesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnesiActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga turnira"));

        jLabel10.setText("Pretraga (naziv timova):");

        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        tblTurniri.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblTurniri);

        btnDetalji.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDetalji.setText("Detalji turnira");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPretraga)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(294, 294, 294))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetalji)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNaziv)
                                    .addComponent(txtDatumOd)
                                    .addComponent(txtDatumDo)
                                    .addComponent(cmbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnUnesi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(btnUnesi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu6.setText("Sudija");

        miNoviSudija.setText("Novi sudija");
        miNoviSudija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviSudijaActionPerformed(evt);
            }
        });
        jMenu6.add(miNoviSudija);

        miPretragaSudije.setText("Pretraga sudije");
        miPretragaSudije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaSudijeActionPerformed(evt);
            }
        });
        jMenu6.add(miPretragaSudije);

        jMenuBar1.add(jMenu6);

        jMenu8.setText("Odjava");

        miOdjava.setText("Odjavi se");
        miOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOdjavaActionPerformed(evt);
            }
        });
        jMenu8.add(miOdjava);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUlogovani))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNoviSudijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviSudijaActionPerformed
        new FormaNoviSudija(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviSudijaActionPerformed

    private void miPretragaSudijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaSudijeActionPerformed
        new FormaPretragaSudije(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaSudijeActionPerformed

    private void miOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOdjavaActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "se odjavite sa sistema?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            new LoginForma().setVisible(true);
            Sesija.getInstance().setUlogovani(null);
            this.dispose();
        }

    }//GEN-LAST:event_miOdjavaActionPerformed

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        String param = txtPretraga.getText();
        ((ModelTabeleTurniri) tblTurniri.getModel()).setParametar(param);
    }//GEN-LAST:event_txtPretragaKeyReleased

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed

        int row = tblTurniri.getSelectedRow();

        if (row >= 0) {
            Turnir t = ((ModelTabeleTurniri) tblTurniri.getModel()).getSelectedTurnir(row);
            new FormaDetaljiTurnira(this, true, t).setVisible(true);
        }

    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void btnDodajUtakmicuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajUtakmicuActionPerformed

        Sudija sudija = (Sudija) cmbSudija.getSelectedItem();
        Tim prviTim = (Tim) cmbPrviTim.getSelectedItem();
        Tim drugiTim = (Tim) cmbDrugiTim.getSelectedItem();
        int brojGolovaPrvi = Integer.parseInt(txtBrojGolovaPrvi.getText());
        int brojGolovaDrugi = Integer.parseInt(txtBrojGolovaDrugi.getText());
        String pobednik = "Nereseno!";

        if (prviTim.getTimID().equals(drugiTim.getTimID())) {
            JOptionPane.showMessageDialog(this, "Prvi i drugi tim moraju biti razliciti!");
            return;
        }

        if (brojGolovaPrvi < 0 || brojGolovaPrvi > 99) {
            JOptionPane.showMessageDialog(this, "Broj golova prvog tima mora biti izmedju "
                    + "0 i 99!");
            return;
        }

        if (brojGolovaDrugi < 0 || brojGolovaDrugi > 99) {
            JOptionPane.showMessageDialog(this, "Broj golova drugog tima mora biti izmedju "
                    + "0 i 99!");
            return;
        }

        if (brojGolovaPrvi > brojGolovaDrugi) {
            pobednik = prviTim.getNaziv();
        }

        if (brojGolovaDrugi > brojGolovaPrvi) {
            pobednik = drugiTim.getNaziv();
        }

        Utakmica u = new Utakmica(null, -1, brojGolovaPrvi, brojGolovaDrugi,
                pobednik, prviTim, drugiTim, sudija);

        ModelTabeleUtakmice tm = (ModelTabeleUtakmice) tblUtakmice.getModel();
        tm.dodajUtakmicu(u);

    }//GEN-LAST:event_btnDodajUtakmicuActionPerformed

    private void btnObrisiUtakmicuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiUtakmicuActionPerformed

        int row = tblUtakmice.getSelectedRow();

        if (row >= 0) {
            ModelTabeleUtakmice tm = (ModelTabeleUtakmice) tblUtakmice.getModel();
            tm.obrisiUtakmicu(row);
        }

    }//GEN-LAST:event_btnObrisiUtakmicuActionPerformed

    private void btnUnesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnesiActionPerformed

        try {
            if (txtDatumDo.getText().isEmpty() || txtDatumOd.getText().isEmpty()
                    || txtNaziv.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
                return;
            }

            String naziv = txtNaziv.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumOd = sdf.parse(txtDatumOd.getText());
            Date datumDo = sdf.parse(txtDatumDo.getText());
            String grad = (String) cmbGrad.getSelectedItem();

            ModelTabeleUtakmice tm = (ModelTabeleUtakmice) tblUtakmice.getModel();

            Turnir t = new Turnir(null, naziv, datumOd, datumDo, grad, ulogovani, tm.getLista());

            KlijentskiKontroler.getInstance().addTurnir(t);
            txtNaziv.setText("");
            txtBrojGolovaDrugi.setText("");
            txtBrojGolovaPrvi.setText("");
            txtDatumDo.setText("");
            txtDatumOd.setText("");
            tm.getLista().clear();
            tm.fireTableDataChanged();

            ModelTabeleTurniri tmt = (ModelTabeleTurniri) tblTurniri.getModel();
            tmt.refreshTable();

            JOptionPane.showMessageDialog(this, "Uspesno sacuvan turnir!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnUnesiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnDodajUtakmicu;
    private javax.swing.JButton btnObrisiUtakmicu;
    private javax.swing.JButton btnUnesi;
    private javax.swing.JComboBox cmbDrugiTim;
    private javax.swing.JComboBox<String> cmbGrad;
    private javax.swing.JComboBox cmbPrviTim;
    private javax.swing.JComboBox cmbSudija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miNoviSudija;
    private javax.swing.JMenuItem miOdjava;
    private javax.swing.JMenuItem miPretragaSudije;
    private javax.swing.JTable tblTurniri;
    private javax.swing.JTable tblUtakmice;
    private javax.swing.JFormattedTextField txtBrojGolovaDrugi;
    private javax.swing.JFormattedTextField txtBrojGolovaPrvi;
    private javax.swing.JFormattedTextField txtDatumDo;
    private javax.swing.JFormattedTextField txtDatumOd;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    public void refreshTable() {
        ModelTabeleTurniri tmt = (ModelTabeleTurniri) tblTurniri.getModel();
        tmt.refreshTable();
    }

    public void popuniSudije() {
        try {
            ArrayList<Sudija> sudije = KlijentskiKontroler.getInstance().getAllSudija();

            cmbSudija.removeAllItems();

            for (Sudija sudija : sudije) {
                cmbSudija.addItem(sudija);
            }

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniTimove() {
        try {
            ArrayList<Tim> timovi = KlijentskiKontroler.getInstance().getAllTim();

            cmbPrviTim.removeAllItems();
            cmbDrugiTim.removeAllItems();

            for (Tim tim : timovi) {
                cmbPrviTim.addItem(tim);
                cmbDrugiTim.addItem(tim);
            }

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}