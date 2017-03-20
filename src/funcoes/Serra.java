/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import Enum.TipoMalha;
import Enum.TipoOnda;
import projetocontrole.util.MathUtil;
import util.ConfiguracaoProjeto;

/**
 *
 * @author lucasnobre
 */
public class Serra implements Onda {

    ConfiguracaoProjeto cfg;

    public Serra(ConfiguracaoProjeto cfg) {
        this.cfg = cfg;

    }

    @Override
    public double calcular(float tempo) {
        if (cfg.getPeriodo() == 0) {
            return 0;
        } else {
            double saida;
            float tempoAtual = tempo % cfg.getPeriodo();
            saida = cfg.getOffSet() + (2 * cfg.getAmplitude() * (tempoAtual / cfg.getPeriodo()) - cfg.getAmplitude());

            if (cfg.getTipoMalha().equals(TipoMalha.Aberta)) {
                saida = cfg.getOffSet() + (2 * cfg.getAmplitude() * (tempoAtual / cfg.getPeriodo()) - cfg.getAmplitude());
            } else if (cfg.getTipoMalha().equals(TipoMalha.Fechada)) {
                saida = (2 * cfg.getAmplitude() * (tempoAtual / cfg.getPeriodo()) - cfg.getAmplitude());
            }

            return saida;
        }
    }

    @Override
    public TipoOnda getTipoOnda() {
      return TipoOnda.Serra;
    }
}