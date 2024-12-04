/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domeni;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author veljk
 */
public class Sudija extends ApstraktnaDomena {

    private Long sudijaID;
    private String ime;
    private String prezime;
    private Date datumRodjenja;

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public Sudija(Long sudijaID, String ime, String prezime, Date datumRodjenja) {
        this.sudijaID = sudijaID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    public Sudija() {
    }

    @Override
    public String nazivTabele() {
        return " Sudija ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<ApstraktnaDomena> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktnaDomena> lista = new ArrayList<>();

        while (rs.next()) {
            Sudija s = new Sudija(rs.getLong("SudijaID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getDate("DatumRodjenja"));

            lista.add(s);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, DatumRodjenja) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + new java.sql.Date(datumRodjenja.getTime()) + "' ";
    }

    @Override
    public String uslov() {
        return " SudijaID = " + sudijaID;
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', "
                + "datumRodjenja = '" + new java.sql.Date(datumRodjenja.getTime()) + "' ";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getSudijaID() {
        return sudijaID;
    }

    public void setSudijaID(Long sudijaID) {
        this.sudijaID = sudijaID;
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

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

}
