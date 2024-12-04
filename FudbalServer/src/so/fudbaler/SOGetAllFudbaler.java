/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.fudbaler;

import dbb.DBBroker;
import domeni.ApstraktnaDomena;
import domeni.Fudbaler;
import java.util.ArrayList;
import so.ApstraktnaSistemskaOperacija;

/**
 *
 * @author veljk
 */
public class SOGetAllFudbaler extends ApstraktnaSistemskaOperacija {

    private ArrayList<Fudbaler> lista;

    @Override
    protected void validacija(ApstraktnaDomena ado) throws Exception {
        if (!(ado instanceof Fudbaler)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Fudbaler!");
        }
    }

    @Override
    protected void izvrsiOperaciju(ApstraktnaDomena ado) throws Exception {
        ArrayList<ApstraktnaDomena> fudbaleri = DBBroker.getInstance().vrati(ado);
        lista = (ArrayList<Fudbaler>) (ArrayList<?>) fudbaleri;
    }

    public ArrayList<Fudbaler> getLista() {
        return lista;
    }

}
