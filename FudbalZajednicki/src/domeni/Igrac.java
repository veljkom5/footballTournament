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
public class Igrac extends ApstraktnaDomena {

    private Tim tim;
    private int brojNaDresu;
    private String pozicija;
    private Fudbaler fudbaler;

    public Igrac(Tim tim, int brojNaDresu, String pozicija, Fudbaler fudbaler) {
        this.tim = tim;
        this.brojNaDresu = brojNaDresu;
        this.pozicija = pozicija;
        this.fudbaler = fudbaler;
    }

    public Igrac() {
    }

    @Override
    public String nazivTabele() {
        return " Igrac ";
    }

    @Override
    public String alijas() {
        return " i ";
    }

    @Override
    public String join() {
        return " JOIN FUDBALER F ON (F.FUDBALERID = I.FUDBALERID) "
                + "JOIN TIM TIM ON (TIM.TIMID = I.TIMID) ";
    }

    @Override
    public ArrayList<ApstraktnaDomena> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktnaDomena> lista = new ArrayList<>();

        while (rs.next()) {
            
            Fudbaler f = new Fudbaler(rs.getLong("FudbalerID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getInt("Godine"));
            
            Tim tim = new Tim(rs.getLong("TimID"),
                    rs.getString("Naziv"), null);
            
            Igrac i = new Igrac(tim, rs.getInt("brojNaDresu"), rs.getString("pozicija"), f);
            
            lista.add(i);
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
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public int getBrojNaDresu() {
        return brojNaDresu;
    }

    public void setBrojNaDresu(int brojNaDresu) {
        this.brojNaDresu = brojNaDresu;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public Fudbaler getFudbaler() {
        return fudbaler;
    }

    public void setFudbaler(Fudbaler fudbaler) {
        this.fudbaler = fudbaler;
    }

}
