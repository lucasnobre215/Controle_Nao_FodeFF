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
public class FuncaoPID implements FuncaoControle {

    private double acaoProporcional;
    private double acaoDerivativa;
    private double acaoIntegrativa;
    private double erroAnterior;
    private ConfiguracaoProjeto cfg;

    public FuncaoPID(ConfiguracaoProjeto cfg) {
        this.acaoProporcional = 0;
        this.acaoDerivativa = 0;
        this.acaoIntegrativa = 0;
        this.cfg = cfg;
    }

    @Override
    public double calcular(double erro) {
        acaoProporcional = cfg.getKp() * erro;
        acaoIntegrativa = acaoIntegrativa + (cfg.getKi() * cfg.getTempoAmostragem() * erro);
        acaoDerivativa = cfg.getKd() * (erro - erroAnterior) / (cfg.getTempoAmostragem());
        erroAnterior = erro;
        return acaoProporcional + acaoIntegrativa + acaoDerivativa;
    }

    @Override
    public TipoControlador getTipoOnda() {
        return TipoControlador.PID;
        
    }

}
