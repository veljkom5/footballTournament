/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.igrac;

import dbb.DBBroker;
import domeni.ApstraktnaDomena;
import domeni.Igrac;
import java.util.ArrayList;
import so.ApstraktnaSistemskaOperacija;

/**
 *
 * @author veljk
 */
public class SOGetAllIgrac extends ApstraktnaSistemskaOperacija {

    private ArrayList<Igrac> lista;

    @Override
    protected void validacija(ApstraktnaDomena ado) throws Exception {
        if (!(ado instanceof Igrac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Igrac!");
        }
    }

    @Override
    protected void izvrsiOperaciju(ApstraktnaDomena ado) throws Exception {
        ArrayList<ApstraktnaDomena> igraci = DBBroker.getInstance().vrati(ado);
        lista = (ArrayList<Igrac>) (ArrayList<?>) igraci;
    }

    public ArrayList<Igrac> getLista() {
        return lista;
    }

}
