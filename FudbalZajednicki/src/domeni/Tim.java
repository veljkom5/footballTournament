/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domeni;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author veljk
 */
public class Tim extends ApstraktnaDomena {

    private Long timID;
    private String naziv;
    private ArrayList<Igrac> igraci;

    @Override
    public String toString() {
        return naziv;
    }

    public Tim(Long timID, String naziv, ArrayList<Igrac> igraci) {
        this.timID = timID;
        this.naziv = naziv;
        this.igraci = igraci;
    }

    public Tim() {
    }

    @Override
    public String nazivTabele() {
        return " Tim ";
    }

    @Override
    public String alijas() {
        return " tim ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<ApstraktnaDomena> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktnaDomena> lista = new ArrayList<>();

        while (rs.next()) {
            Tim tim = new Tim(rs.getLong("TimID"),
                    rs.getString("Naziv"), null);

            lista.add(tim);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String uslov() {
        return " TimID = " + timID;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getTimID() {
        return timID;
    }

    public void setTimID(Long timID) {
        this.timID = timID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ArrayList<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(ArrayList<Igrac> igraci) {
        this.igraci = igraci;
    }

}
