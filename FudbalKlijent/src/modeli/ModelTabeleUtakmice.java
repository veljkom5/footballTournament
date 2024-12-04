/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import kontroler.KlijentskiKontroler;
import domeni.Turnir;
import domeni.Utakmica;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author veljk
 */
public class ModelTabeleUtakmice extends AbstractTableModel {

    private ArrayList<Utakmica> lista;
    private String[] kolone = {"Rb", "Sudija", "Prvi tim", "Broj golova prvog", "Drugi tim",
        "Broj golova drugog", "Pobednik"};
    private int rb = 0;

    public ModelTabeleUtakmice() {
        lista = new ArrayList<>();
    }

    public ModelTabeleUtakmice(Turnir turnir) {
        try {
            lista = KlijentskiKontroler.getInstance().getAllUtakmica(turnir);
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleUtakmice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Utakmica u = lista.get(row);

        switch (column) {
            case 0:
                return u.getRb();
            case 1:
                return u.getSudija();
            case 2:
                return u.getPrviTim();
            case 3:
                return u.getBrojGolovaPrvi();
            case 4:
                return u.getDrugiTim();
            case 5:
                return u.getBrojGolovaDrugi();
            case 6:
                return u.getPobednik();

            default:
                return null;
        }
    }

    public void dodajUtakmicu(Utakmica u) {
        rb = lista.size();
        u.setRb(++rb);
        lista.add(u);
        fireTableDataChanged();
    }

    public void obrisiUtakmicu(int row) {
        lista.remove(row);
        
        rb = 0;
        for (Utakmica utakmica : lista) {
            utakmica.setRb(++rb);
        }
        
        fireTableDataChanged();
    }

    public ArrayList<Utakmica> getLista() {
        return lista;
    }

}
