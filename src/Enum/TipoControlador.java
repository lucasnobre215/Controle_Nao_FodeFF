/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author lucasnobre
 */
public enum TipoControlador {
    P, PD, PI, PID, PI_D, ABERTO;

    public static TipoControlador valorDe(String s) {
        if (s.equals("PI-D")) {
            return TipoControlador.PI_D;
        } else {
            return valueOf(s);
        }
    }
}
