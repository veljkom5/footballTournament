/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author veljk
 */
public class KlijentskiZahtev implements Serializable {

    private int operacija;
    private Object parametar;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public Object getParametar() {
        return parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

}
