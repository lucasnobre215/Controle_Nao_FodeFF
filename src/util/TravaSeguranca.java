/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author lucasnobre
 */
public class TravaSeguranca {

    public static double limitarTensaoMaxima(double tensao) {
        double retorno = tensao;
        if (tensao > 4) {
            retorno = 4;
        } else if (tensao < -4) {
            retorno = -4;
        }
        return retorno;
    }

    public static double limitarTensaoPorNivelTanque(double nivel, double tensao) {
        double retorno = tensao;
        if (nivel > 28) {
            retorno = 0;
        } else if (nivel < 4 && tensao < 0) {
            retorno = 0.1;
        }
        return retorno;
    }
}
