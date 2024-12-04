/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import kontroler.KlijentskiKontroler;
import domeni.Sudija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author veljk
 */
public class ModelTabeleSudije extends AbstractTableModel implements Runnable {

    private ArrayList<Sudija> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Datum rodjenja"};
    private String parametar = "";

    public ModelTabeleSudije() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllSudija();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleSudije.class.getName()).log(Level.SEVERE, null, ex);
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
        Sudija s = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch (column) {
            case 0:
                return s.getSudijaID();
            case 1:
                return s.getIme();
            case 2:
                return s.getPrezime();
            case 3:
                return sdf.format(s.getDatumRodjenja());

            default:
                return null;
        }
    }

    public Sudija getSelectedSudija(int row) {
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
            Logger.getLogger(ModelTabeleSudije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllSudija();
            if (!parametar.equals("")) {
                ArrayList<Sudija> novaLista = new ArrayList<>();
                for (Sudija s : lista) {
                    if (s.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || s.getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(s);
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
