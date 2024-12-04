/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author veljk
 */
public interface Operacije {

    public static final int LOGIN = 0;

    public static final int ADD_SUDIJA = 1;
    public static final int DELETE_SUDIJA = 2;
    public static final int UPDATE_SUDIJA = 3;
    public static final int GET_ALL_SUDIJA = 4;

    public static final int ADD_TURNIR = 5;
    public static final int DELETE_TURNIR = 6;
    public static final int UPDATE_TURNIR = 7;
    public static final int GET_ALL_TURNIR = 8;

    public static final int GET_ALL_UTAKMICA = 9;
    
    public static final int GET_ALL_TIM = 10;
    
    public static final int GET_ALL_IGRAC = 11;
    
    public static final int GET_ALL_FUDBALER = 12;

}
