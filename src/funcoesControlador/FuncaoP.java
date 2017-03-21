/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoesControlador;

import Enum.TipoControlador;
import util.ConfiguracaoProjeto;


/**
 *
 * @author lucasnobre
 */
public class FuncaoP implements FuncaoControle{

    ConfiguracaoProjeto cfg;
    
    public FuncaoP(ConfiguracaoProjeto cfg) {
        this.cfg = cfg;
    }
    
    @Override
    public double calcular(double erro) {
        return  cfg.getKp() * erro;
    }

    @Override
    public TipoControlador getTipoOnda() {
        return TipoControlador.P;
    }
    
}
