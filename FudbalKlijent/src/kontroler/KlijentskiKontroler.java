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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sesija.Sesija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.StatusOdgovora;
import transfer.util.Operacije;

/**
 *
 * @author veljk
 */
public class KlijentskiKontroler {

    private static KlijentskiKontroler instance;

    private KlijentskiKontroler() {
    }

    public static KlijentskiKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentskiKontroler();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) posaljiZahtev(Operacije.LOGIN, administrator);
    }

    public void addSudija(Sudija sudija) throws Exception {
        posaljiZahtev(Operacije.ADD_SUDIJA, sudija);
    }

    public void addTurnir(Turnir turnir) throws Exception {
        posaljiZahtev(Operacije.ADD_TURNIR, turnir);
    }

    public void deleteSudija(Sudija sudija) throws Exception {
        posaljiZahtev(Operacije.DELETE_SUDIJA, sudija);
    }

    public void deleteTurnir(Turnir turnir) throws Exception {
        posaljiZahtev(Operacije.DELETE_TURNIR, turnir);
    }

    public void updateSudija(Sudija sudija) throws Exception {
        posaljiZahtev(Operacije.UPDATE_SUDIJA, sudija);
    }

    public void updateTurnir(Turnir turnir) throws Exception {
        posaljiZahtev(Operacije.UPDATE_TURNIR, turnir);
    }

    public ArrayList<Sudija> getAllSudija() throws Exception {
        return (ArrayList<Sudija>) posaljiZahtev(Operacije.GET_ALL_SUDIJA, null);
    }

    public ArrayList<Turnir> getAllTurnir() throws Exception {
        return (ArrayList<Turnir>) posaljiZahtev(Operacije.GET_ALL_TURNIR, null);
    }

    public ArrayList<Tim> getAllTim() throws Exception {
        return (ArrayList<Tim>) posaljiZahtev(Operacije.GET_ALL_TIM, null);
    }

    public ArrayList<Igrac> getAllIgrac() throws Exception {
        return (ArrayList<Igrac>) posaljiZahtev(Operacije.GET_ALL_IGRAC, null);
    }

    public ArrayList<Fudbaler> getAllFudbaler() throws Exception {
        return (ArrayList<Fudbaler>) posaljiZahtev(Operacije.GET_ALL_FUDBALER, null);
    }

    public ArrayList<Utakmica> getAllUtakmica(Turnir turnir) throws Exception {
        return (ArrayList<Utakmica>) posaljiZahtev(Operacije.GET_ALL_UTAKMICA, turnir);
    }

    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(operacija, parametar);

        ObjectOutputStream oos = new ObjectOutputStream(Sesija.getInstance().getSocket().getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(Sesija.getInstance().getSocket().getInputStream());
        ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();

        if (so.getStatusOdgovora().equals(StatusOdgovora.Error)) {
            throw so.getException();
        } else {
            return so.getOdgovor();
        }

    }
}
