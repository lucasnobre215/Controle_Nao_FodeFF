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
public class Degrau implements Onda{
    
    float amplitude;

    public Degrau(float amplitude) {
        this.amplitude = amplitude;
    }
    

    @Override
    public double calcular(float tempo) {
        return amplitude;
    }
    
    @Override
    public TipoOnda getTipoOnda() {
        return TipoOnda.Degrau;
    }
    
}
