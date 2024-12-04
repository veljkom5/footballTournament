/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domeni.Administrator;
import domeni.Fudbaler;
import domeni.Igrac;
import domeni.Sudija;
import domeni.Tim;
import domeni.Turnir;
import domeni.Utakmica;
import java.util.ArrayList;
import so.fudbaler.SOGetAllFudbaler;
import so.igrac.SOGetAllIgrac;
import so.login.SOLogin;
import so.sudija.SOAddSudija;
import so.sudija.SODeleteSudija;
import so.sudija.SOGetAllSudija;
import so.sudija.SOUpdateSudija;
import so.tim.SOGetAllTim;
import so.turnir.SOAddTurnir;
import so.turnir.SODeleteTurnir;
import so.turnir.SOGetAllTurnir;
import so.turnir.SOUpdateTurnir;
import so.utakmica.SOGetAllUtakmica;

/**
 *
 * @author veljk
 */
public class ServerskiKontroler {

    private static ServerskiKontroler instance;

    private ServerskiKontroler() {
    }

    public static ServerskiKontroler getInstance() {
        if (instance == null) {
            instance = new ServerskiKontroler();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.izvrsiSablon(administrator);
        return so.getUlogovani();
    }

    public void addSudija(Sudija sudija) throws Exception {
        (new SOAddSudija()).izvrsiSablon(sudija);
    }

    public void addTurnir(Turnir turnir) throws Exception {
        (new SOAddTurnir()).izvrsiSablon(turnir);
    }

    public void deleteSudija(Sudija sudija) throws Exception {
        (new SODeleteSudija()).izvrsiSablon(sudija);
    }

    public void deleteTurnir(Turnir turnir) throws Exception {
        (new SODeleteTurnir()).izvrsiSablon(turnir);
    }

    public void updateSudija(Sudija sudija) throws Exception {
        (new SOUpdateSudija()).izvrsiSablon(sudija);
    }

    public void updateTurnir(Turnir turnir) throws Exception {
        (new SOUpdateTurnir()).izvrsiSablon(turnir);
    }

    public ArrayList<Sudija> getAllSudija() throws Exception {
        SOGetAllSudija so = new SOGetAllSudija();
        so.izvrsiSablon(new Sudija());
        return so.getLista();
    }

    public ArrayList<Turnir> getAllTurnir() throws Exception {
        SOGetAllTurnir so = new SOGetAllTurnir();
        so.izvrsiSablon(new Turnir());
        return so.getLista();
    }

    public ArrayList<Fudbaler> getAllFudbaler() throws Exception {
        SOGetAllFudbaler so = new SOGetAllFudbaler();
        so.izvrsiSablon(new Fudbaler());
        return so.getLista();
    }

    public ArrayList<Tim> getAllTim() throws Exception {
        SOGetAllTim so = new SOGetAllTim();
        so.izvrsiSablon(new Tim());
        return so.getLista();
    }

    public ArrayList<Igrac> getAllIgrac() throws Exception {
        SOGetAllIgrac so = new SOGetAllIgrac();
        so.izvrsiSablon(new Igrac());
        return so.getLista();
    }

    public ArrayList<Utakmica> getAllUtakmica(Turnir turnir) throws Exception {
        SOGetAllUtakmica so = new SOGetAllUtakmica();
        
        Utakmica utakmica = new Utakmica();
        utakmica.setTurnir(turnir);
        
        so.izvrsiSablon(utakmica);
        return so.getLista();
    }

}
