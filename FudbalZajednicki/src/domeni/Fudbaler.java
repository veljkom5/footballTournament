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
public class Fudbaler extends ApstraktnaDomena {

    private Long fudbalerID;
    private String ime;
    private String prezime;
    private int godine;

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public Fudbaler(Long fudbalerID, String ime, String prezime, int godine) {
        this.fudbalerID = fudbalerID;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
    }

    public Fudbaler() {
    }

    @Override
    public String nazivTabele() {
        return " Fudbaler ";
    }

    @Override
    public String alijas() {
        return " f ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<ApstraktnaDomena> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktnaDomena> lista = new ArrayList<>();

        while (rs.next()) {
            Fudbaler f = new Fudbaler(rs.getLong("FudbalerID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getInt("Godine"));

            lista.add(f);
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
        return " FudbalerID = " + fudbalerID;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getFudbalerID() {
        return fudbalerID;
    }

    public void setFudbalerID(Long fudbalerID) {
        this.fudbalerID = fudbalerID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

}
