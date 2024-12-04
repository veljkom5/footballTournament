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
public class Utakmica extends ApstraktnaDomena {

    private Turnir turnir;
    private int rb;
    private int brojGolovaPrvi;
    private int brojGolovaDrugi;
    private String pobednik;
    private Tim prviTim;
    private Tim drugiTim;
    private Sudija sudija;

    public Utakmica(Turnir turnir, int rb, int brojGolovaPrvi, int brojGolovaDrugi, String pobednik, Tim prviTim, Tim drugiTim, Sudija sudija) {
        this.turnir = turnir;
        this.rb = rb;
        this.brojGolovaPrvi = brojGolovaPrvi;
        this.brojGolovaDrugi = brojGolovaDrugi;
        this.pobednik = pobednik;
        this.prviTim = prviTim;
        this.drugiTim = drugiTim;
        this.sudija = sudija;
    }

    public Utakmica() {
    }

    @Override
    public String nazivTabele() {
        return " Utakmica ";
    }

    @Override
    public String alijas() {
        return " u ";
    }

    @Override
    public String join() {
        return " JOIN SUDIJA S ON (S.SUDIJAID = U.SUDIJAID) "
                + "JOIN TURNIR T ON (T.TURNIRID = U.TURNIRID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID) "
                + "JOIN TIM PRVITIM ON (PRVITIM.TIMID = U.PRVITIMID) "
                + "JOIN TIM DRUGITIM ON (DRUGITIM.TIMID = U.DRUGITIMID) ";
    }

    @Override
    public ArrayList<ApstraktnaDomena> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktnaDomena> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("a.Ime"), rs.getString("a.Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Turnir t = new Turnir(rs.getLong("turnirID"), rs.getString("naziv"),
                    rs.getDate("datumOd"), rs.getDate("datumDo"), rs.getString("grad"), a, null);

            Sudija s = new Sudija(rs.getLong("SudijaID"),
                    rs.getString("s.Ime"), rs.getString("s.Prezime"),
                    rs.getDate("DatumRodjenja"));

            Tim prviTim = new Tim(rs.getLong("prviTim.TimID"), rs.getString("prviTim.Naziv"), null);

            Tim drugiTim = new Tim(rs.getLong("drugiTim.TimID"), rs.getString("drugiTim.Naziv"), null);

            Utakmica u = new Utakmica(t, rs.getInt("rb"), rs.getInt("brojGolovaPrvi"),
                    rs.getInt("brojGolovaDrugi"), rs.getString("pobednik"), prviTim, drugiTim, s);

            lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (turnirID, rb, brojGolovaPrvi, brojGolovaDrugi, pobednik, "
                + "prviTimID, drugiTimID, sudijaID) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + turnir.getTurnirID() + ", " + rb + ", " + brojGolovaPrvi + ", "
                + " " + brojGolovaDrugi + ", '" + pobednik + "', "
                + prviTim.getTimID() + ", " + drugiTim.getTimID() + ", "
                + sudija.getSudijaID();
    }

    @Override
    public String uslov() {
        return " turnirID = " + turnir.getTurnirID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        if (sudija != null) {
            return " WHERE S.SUDIJAID = " + sudija.getSudijaID();
        }
        return " WHERE T.TURNIRID = " + turnir.getTurnirID();
    }

    public Turnir getTurnir() {
        return turnir;
    }

    public void setTurnir(Turnir turnir) {
        this.turnir = turnir;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getBrojGolovaPrvi() {
        return brojGolovaPrvi;
    }

    public void setBrojGolovaPrvi(int brojGolovaPrvi) {
        this.brojGolovaPrvi = brojGolovaPrvi;
    }

    public int getBrojGolovaDrugi() {
        return brojGolovaDrugi;
    }

    public void setBrojGolovaDrugi(int brojGolovaDrugi) {
        this.brojGolovaDrugi = brojGolovaDrugi;
    }

    public String getPobednik() {
        return pobednik;
    }

    public void setPobednik(String pobednik) {
        this.pobednik = pobednik;
    }

    public Tim getPrviTim() {
        return prviTim;
    }

    public void setPrviTim(Tim prviTim) {
        this.prviTim = prviTim;
    }

    public Tim getDrugiTim() {
        return drugiTim;
    }

    public void setDrugiTim(Tim drugiTim) {
        this.drugiTim = drugiTim;
    }

    public Sudija getSudija() {
        return sudija;
    }

    public void setSudija(Sudija sudija) {
        this.sudija = sudija;
    }

}
