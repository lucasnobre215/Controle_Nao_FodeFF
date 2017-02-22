/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static Enum.TipoOnda.Degrau;
import static Enum.TipoOnda.Quadrada;
import funcoes.Degrau;
import funcoes.Onda;
import funcoes.Quadrada;
import funcoes.Senoide;
import projetocontrole.dominio.Aleatoria;

/**
 *
 * @author lucasnobre
 */
public class FabricaOnda {
    
    public static Onda fabricarOnda(ConfiguracaoProjeto cfg) {
        Onda geradorOnda = null;
        switch (cfg.getTipoOnda()) {
            case Degrau:
                geradorOnda = new Degrau(cfg);
                break;
            case Quadrada:
                geradorOnda = new Quadrada(cfg);
                break;
            case Senoide:
                geradorOnda = new Senoide(cfg);
                break;
            case Serra:
//                geradorOnda = new Serra(cfg.getAmplitude(), cfg.getPeriodo());  
                break;
            case Aleatoria:
                geradorOnda = new Aleatoria(cfg);
                break;

            default:
                throw new UnsupportedOperationException("Tipo de onda inválida");
        }

        return geradorOnda;
    }
    
}
