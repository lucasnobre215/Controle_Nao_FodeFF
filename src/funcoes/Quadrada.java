/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import Enum.TipoMalha;
import Enum.TipoOnda;
import util.ConfiguracaoProjeto;

/**
 *
 * @author lucasnobre
 */
public class Quadrada implements Onda {

    float amplitude;
    float periodo;
    ConfiguracaoProjeto cfg;

    public Quadrada(ConfiguracaoProjeto cfg) {
        this.cfg = cfg;
    }

    @Override
    public TipoOnda getTipoOnda() {
        return TipoOnda.Quadrada;
    }

    @Override
    public double calcular(float tempo) {
        double retorno = cfg.getOffSet();
        if (cfg.getTipoMalha().equals(TipoMalha.Fechada)) {
            retorno = 0;
        }
        if (cfg.getPeriodo() == 0) {
            return 0;
        }

        float tempoAtual = tempo % cfg.getPeriodo();
        if (tempoAtual < cfg.getPeriodo() / 2.0) {
            retorno += cfg.getAmplitude();
        } else {
            retorno += 0;
        }
        return retorno;
    }
}
