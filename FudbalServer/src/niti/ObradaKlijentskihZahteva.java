/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import kontroler.ServerskiKontroler;
import domeni.Administrator;
import domeni.Sudija;
import domeni.Turnir;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.StatusOdgovora;
import transfer.util.Operacije;

/**
 *
 * @author veljk
 */
public class ObradaKlijentskihZahteva extends Thread {

    private Socket socket;

    ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev kz = (KlijentskiZahtev) ois.readObject();
                ServerskiOdgovor so = obradiZahtev(kz);
                
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(so);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor(null, null, StatusOdgovora.Success);
        try {
            switch (kz.getOperacija()) {
                case Operacije.ADD_SUDIJA:
                    ServerskiKontroler.getInstance().addSudija((Sudija) kz.getParametar());
                    break;
                case Operacije.ADD_TURNIR:
                    ServerskiKontroler.getInstance().addTurnir((Turnir) kz.getParametar());
                    break;
                case Operacije.DELETE_SUDIJA:
                    ServerskiKontroler.getInstance().deleteSudija((Sudija) kz.getParametar());
                    break;
                case Operacije.DELETE_TURNIR:
                    ServerskiKontroler.getInstance().deleteTurnir((Turnir) kz.getParametar());
                    break;
                case Operacije.UPDATE_SUDIJA:
                    ServerskiKontroler.getInstance().updateSudija((Sudija) kz.getParametar());
                    break;
                case Operacije.UPDATE_TURNIR:
                    ServerskiKontroler.getInstance().updateTurnir((Turnir) kz.getParametar());
                    break;
                case Operacije.GET_ALL_FUDBALER:
                    so.setOdgovor(ServerskiKontroler.getInstance().getAllFudbaler());
                    break;
                case Operacije.GET_ALL_IGRAC:
                    so.setOdgovor(ServerskiKontroler.getInstance().getAllIgrac());
                    break;
                case Operacije.GET_ALL_SUDIJA:
                    so.setOdgovor(ServerskiKontroler.getInstance().getAllSudija());
                    break;
                case Operacije.GET_ALL_TIM:
                    so.setOdgovor(ServerskiKontroler.getInstance().getAllTim());
                    break;
                case Operacije.GET_ALL_TURNIR:
                    so.setOdgovor(ServerskiKontroler.getInstance().getAllTurnir());
                    break;
                case Operacije.GET_ALL_UTAKMICA:
                    so.setOdgovor(ServerskiKontroler.getInstance().getAllUtakmica((Turnir) kz.getParametar()));
                    break;
                case Operacije.LOGIN:
                    Administrator administrator = (Administrator) kz.getParametar();
                    Administrator ulogovani = ServerskiKontroler.getInstance().login(administrator);
                    so.setOdgovor(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception ex) {
            so.setStatusOdgovora(StatusOdgovora.Error);
            so.setException(ex);
        }
        return so;
    }

}
