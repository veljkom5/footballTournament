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
public class Turnir extends ApstraktnaDomena {

    private Long turnirID;
    private String naziv;
    private Date datumOd;
    private Date datumDo;
    private String grad;
    private Administrator administrator;
    private ArrayList<Utakmica> utakmice;

    public Turnir(Long turnirID, String naziv, Date datumOd, Date datumDo, String grad, Administrator administrator, ArrayList<Utakmica> utakmice) {
        this.turnirID = turnirID;
        this.naziv = naziv;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.grad = grad;
        this.administrator = administrator;
        this.utakmice = utakmice;
    }

    public Turnir() {
    }

    @Override
    public String nazivTabele() {
        return " Turnir ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return " JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID) ";
    }

    @Override
    public ArrayList<ApstraktnaDomena> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktnaDomena> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Turnir t = new Turnir(rs.getLong("turnirID"), rs.getString("naziv"),
                    rs.getDate("datumOd"), rs.getDate("datumDo"), rs.getString("grad"), a, null);

            lista.add(t);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (naziv, datumOd, datumDo, grad, administratorID) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + naziv + "', '" + new java.sql.Date(datumOd.getTime()) + "', "
                + "'" + new java.sql.Date(datumDo.getTime()) + "', '" + grad + "', "
                + administrator.getAdministratorID();
    }

    @Override
    public String uslov() {
        return " turnirID = " + turnirID;
    }

    @Override
    public String vrednostiZaUpdate() {
        return " naziv = '" + naziv + "', "
                + "datumOd = '" + new java.sql.Date(datumOd.getTime()) + "', "
                + "datumDo = '" + new java.sql.Date(datumDo.getTime()) + "', "
                + "grad = '" + grad + "' ";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getTurnirID() {
        return turnirID;
    }

    public void setTurnirID(Long turnirID) {
        this.turnirID = turnirID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<Utakmica> getUtakmice() {
        return utakmice;
    }

    public void setUtakmice(ArrayList<Utakmica> utakmice) {
        this.utakmice = utakmice;
    }

}
