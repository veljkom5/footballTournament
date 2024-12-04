/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.turnir;

import dbb.DBBroker;
import domeni.ApstraktnaDomena;
import domeni.Turnir;
import domeni.Utakmica;
import java.util.Date;
import so.ApstraktnaSistemskaOperacija;

/**
 *
 * @author veljk
 */
public class SOUpdateTurnir extends ApstraktnaSistemskaOperacija {

    @Override
    protected void validacija(ApstraktnaDomena ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Turnir!");
        }
        
        Turnir t = (Turnir) ado;

        if (t.getDatumOd().after(new Date()) || t.getDatumDo().after(new Date())) {
            throw new Exception("Datumi turnira ne smeju biti nakon danasnjeg datuma "
                    + "jer je turnir zavrsen!");
        }

        if (t.getUtakmice().size() < 2) {
            throw new Exception("Morate uneti barem dve utakmice za turnir!");
        }
        
    }

    @Override
    protected void izvrsiOperaciju(ApstraktnaDomena ado) throws Exception {
      
        DBBroker.getInstance().izmeni(ado);
        
        Turnir t = (Turnir) ado;
    
        DBBroker.getInstance().obrisi(t.getUtakmice().get(0));
        
    
        for (Utakmica utakmica : t.getUtakmice()) {
            DBBroker.getInstance().ubaci(utakmica);
        }
        
        
        
    }

}
