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
public class Degrau implements Onda {

    ConfiguracaoProjeto cfg;

    public Degrau(ConfiguracaoProjeto cfg) {
        this.cfg = cfg;
    }

    @Override
    public double calcular(float tempo) {
        if (cfg.getTipoMalha().equals(TipoMalha.Aberta)) {
            return cfg.getAmplitude() + cfg.getOffSet();
        } else if (cfg.getTipoMalha().equals(TipoMalha.Fechada)) {
            return cfg.getAmplitude();
        }
        return 0;
    }

    @Override
    public TipoOnda getTipoOnda() {
        return TipoOnda.Degrau;
    }

}
