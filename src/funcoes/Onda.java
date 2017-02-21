/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import Enum.TipoOnda;

/**
 *
 * @author lucasnobre
 */
public interface Onda {
    
    double calcular(float tempo);
    TipoOnda getTipoOnda();
    
}
