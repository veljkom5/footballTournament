/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import kontroler.KlijentskiKontroler;
import domeni.Turnir;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author veljk
 */
public class ModelTabeleTurniri extends AbstractTableModel implements Runnable {

    private ArrayList<Turnir> lista;
    private String[] kolone = {"ID", "Naziv", "Datum od", "Datum do", "Grad"};
    private String parametar = "";

    public ModelTabeleTurniri() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllTurnir();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleTurniri.class.getName()).log(Level.SEVERE, null, ex);
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
        Turnir t = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (column) {
            case 0:
                return t.getTurnirID();
            case 1:
                return t.getNaziv();
            case 2:
                return sdf.format(t.getDatumOd());
            case 3:
                return sdf.format(t.getDatumDo());
            case 4:
                return t.getGrad();

            default:
                return null;
        }
    }

    public Turnir getSelectedTurnir(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ModelTabeleTurniri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllTurnir();
            if (!parametar.equals("")) {
                ArrayList<Turnir> novaLista = new ArrayList<>();
                for (Turnir t : lista) {
                    if (t.getNaziv().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(t);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
