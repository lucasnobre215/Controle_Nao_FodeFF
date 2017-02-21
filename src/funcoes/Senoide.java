/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import Enum.TipoOnda;
import projetocontrole.util.MathUtil;

/**
 *
 * @author lucasnobre
 */
public class Senoide implements Onda {

    float amplitude;
    float periodo;

    public Senoide(float amplitude, float periodo) {
        this.amplitude = amplitude;
        this.periodo = periodo;
    }

    @Override
    public double calcular(float tempo) {
        if (periodo == 0) {
            return 0;
        } else {
            return amplitude * MathUtil.round(Math.sin((tempo/periodo)*(2*Math.PI)) , 2);
        }
    }

    @Override
    public TipoOnda getTipoOnda() {
        return TipoOnda.Senoide;
    }

}
