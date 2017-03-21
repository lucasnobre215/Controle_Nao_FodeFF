/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static Enum.TipoMalha.Aberta;
import Graficos.TimeSeriesChart;
import Processadores.Controlador;
import Processadores.ControladorMalhaAberta;
import Processadores.ControleMalhaFechada;
import funcoes.Serra;
import javax.swing.JLabel;


/**
 *
 * @author lucasnobre
 */
public class FabricaControlador {
    
    public static Controlador gerarControlador(ConfiguracaoProjeto cfg, TimeSeriesChart graficoFuncao,
            TimeSeriesChart graficoNivel, JLabel valorLido, JLabel valorEsperado){
        Controlador c;
        
        switch (cfg.getTipoMalha()) {
            case Aberta:
                c = new ControladorMalhaAberta(cfg, graficoFuncao, graficoNivel, valorLido, valorEsperado);  
                break;
            case Fechada:
                c = new ControleMalhaFechada(cfg, graficoFuncao, graficoNivel, valorLido, valorEsperado);
                break;
            default:
                throw new UnsupportedOperationException("Tipo de onda inválida");
        }
        return c;
    }
    
}
