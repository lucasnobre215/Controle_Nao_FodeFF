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
public class Senoide implements Onda {

    ConfiguracaoProjeto cfg;

    public Senoide(ConfiguracaoProjeto cfg) {
        this.cfg = cfg;

    }

    @Override
    public double calcular(float tempo) {
        if (cfg.getPeriodo() == 0) {
            return 0;
        } else if (cfg.getTipoMalha().equals(TipoMalha.Aberta)) {
            return cfg.getOffSet() + cfg.getAmplitude() * MathUtil.round(Math.sin((tempo / cfg.getPeriodo()) * (2 * Math.PI)), 2);
        } else if (cfg.getTipoMalha().equals(TipoMalha.Fechada)) {
            return cfg.getAmplitude() * MathUtil.round(Math.sin((tempo / cfg.getPeriodo()) * (2 * Math.PI)), 2);
        }
        return 0;
    }

    @Override
    public TipoOnda getTipoOnda() {
        return TipoOnda.Senoide;
    }

}
