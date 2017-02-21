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
public class Quadrada implements Onda{

    float amplitude;
    float periodo;

    public Quadrada(float amplitude, float periodo) {
        this.amplitude = amplitude;
        this.periodo = periodo;
    }
    
    @Override
    public TipoOnda getTipoOnda() {
        return TipoOnda.Quadrada;
    }
       
    @Override
    public double calcular(float tempo) {
      if(periodo == 0) {
            return 0;
        }

        float tempoAtual = tempo%periodo;
        if (tempoAtual < periodo/2.0) {
            return amplitude;
        } else {
            return -1*amplitude;
        }
    }
}
