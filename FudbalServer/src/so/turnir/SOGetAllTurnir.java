/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.turnir;

import dbb.DBBroker;
import domeni.ApstraktnaDomena;
import domeni.Turnir;
import java.util.ArrayList;
import so.ApstraktnaSistemskaOperacija;

/**
 *
 * @author veljk
 */
public class SOGetAllTurnir extends ApstraktnaSistemskaOperacija {

    private ArrayList<Turnir> lista;

    @Override
    protected void validacija(ApstraktnaDomena ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Turnir!");
        }
    }

    @Override
    protected void izvrsiOperaciju(ApstraktnaDomena ado) throws Exception {
        ArrayList<ApstraktnaDomena> turniri = DBBroker.getInstance().vrati(ado);
        lista = (ArrayList<Turnir>) (ArrayList<?>) turniri;
    }

    public ArrayList<Turnir> getLista() {
        return lista;
    }

}
