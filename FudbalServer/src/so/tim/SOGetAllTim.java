/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tim;

import dbb.DBBroker;
import domeni.ApstraktnaDomena;
import domeni.Tim;
import java.util.ArrayList;
import so.ApstraktnaSistemskaOperacija;

/**
 *
 * @author veljk
 */
public class SOGetAllTim extends ApstraktnaSistemskaOperacija {

    private ArrayList<Tim> lista;

    @Override
    protected void validacija(ApstraktnaDomena ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }
    }

    @Override
    protected void izvrsiOperaciju(ApstraktnaDomena ado) throws Exception {
        ArrayList<ApstraktnaDomena> timovi = DBBroker.getInstance().vrati(ado);
        lista = (ArrayList<Tim>) (ArrayList<?>) timovi;
    }

    public ArrayList<Tim> getLista() {
        return lista;
    }

}
