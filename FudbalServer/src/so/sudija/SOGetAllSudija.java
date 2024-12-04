/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sudija;

import dbb.DBBroker;
import domeni.ApstraktnaDomena;
import domeni.Sudija;
import java.util.ArrayList;
import so.ApstraktnaSistemskaOperacija;

/**
 *
 * @author veljk
 */
public class SOGetAllSudija extends ApstraktnaSistemskaOperacija {

    private ArrayList<Sudija> lista;

    @Override
    protected void validacija(ApstraktnaDomena ado) throws Exception {
        if (!(ado instanceof Sudija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Sudija!");
        }
    }

    @Override
    protected void izvrsiOperaciju(ApstraktnaDomena ado) throws Exception {
        ArrayList<ApstraktnaDomena> sudije = DBBroker.getInstance().vrati(ado);
        lista = (ArrayList<Sudija>) (ArrayList<?>) sudije;
    }

    public ArrayList<Sudija> getLista() {
        return lista;
    }

}
