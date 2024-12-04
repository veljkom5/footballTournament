/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.utakmica;

import dbb.DBBroker;
import domeni.ApstraktnaDomena;
import domeni.Utakmica;
import java.util.ArrayList;
import so.ApstraktnaSistemskaOperacija;

/**
 *
 * @author veljk
 */
public class SOGetAllUtakmica extends ApstraktnaSistemskaOperacija {

    private ArrayList<Utakmica> lista;

    @Override
    protected void validacija(ApstraktnaDomena ado) throws Exception {
        if (!(ado instanceof Utakmica)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Utakmica!");
        }
    }

    @Override
    protected void izvrsiOperaciju(ApstraktnaDomena ado) throws Exception {
        ArrayList<ApstraktnaDomena> utakmice = DBBroker.getInstance().vrati(ado);
        lista = (ArrayList<Utakmica>) (ArrayList<?>) utakmice;
    }

    public ArrayList<Utakmica> getLista() {
        return lista;
    }

}
