/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoesControlador;

import Enum.TipoControlador;
import Enum.TipoOnda;

/**
 *
 * @author lucasnobre
 */
public interface FuncaoControle {

    double calcular(double erro);

    TipoControlador getTipoOnda();
}
