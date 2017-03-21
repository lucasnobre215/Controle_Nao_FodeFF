/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoesControlador;

import Enum.TipoControlador;
import Enum.TipoOnda;
import util.ConfiguracaoProjeto;

/**
 *
 * @author lucasnobre
 */
public class FuncaoPI implements FuncaoControle{

    private double acaoProporcional;
    private double acaoIntegrativa;
    private ConfiguracaoProjeto cfg;

    public FuncaoPI( ConfiguracaoProjeto cfg) {
        this.acaoProporcional = 0;
        this.acaoIntegrativa = 0;
        this.cfg = cfg;
    }
    
    
       
    @Override
    public double calcular(double erro) {
         acaoProporcional = cfg.getKp() * erro;
         acaoIntegrativa = acaoIntegrativa + (cfg.getKi() * cfg.getTempoAmostragem() * erro);
         return acaoProporcional + acaoIntegrativa;
    }

    @Override
    public TipoControlador getTipoOnda() {
        return TipoControlador.PI;
    }
    
}