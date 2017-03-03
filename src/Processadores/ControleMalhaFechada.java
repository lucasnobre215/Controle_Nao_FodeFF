/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processadores;

import Graficos.TimeSeriesChart;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfiguracaoProjeto;
import util.TravaSeguranca;

/**
 *
 * @author lucasnobre
 */
public class ControleMalhaFechada extends Controlador {

    ConexaoQuanser conexao;
    double tensaoSaida;
    double alturaDesejada;
    double erro;
    double tensaoSegura;
    double tensaoNivelSeguro;

    public ControleMalhaFechada(ConfiguracaoProjeto cfg, TimeSeriesChart graficoFuncao, TimeSeriesChart graficoNivel) {
        super(cfg, graficoFuncao, graficoNivel);
        conexao = new ConexaoQuanser(cfg);
    }
    
    @Override
    public void run() {
        float tempo = 0;
        cfg.setIsRunning(true);
        try {
            // A classe chamada onda tem uma interface, tem que implementar o calcular, tambem recebe a classe de configuracao
            //Essa classe implementa uma thread
            while (cfg.isRunning()) {
                tempo += 0.1;
                tensaoSaida = cfg.getOnda().calcular(tempo);
                conexao.readValue(0);
                erro = tensaoSaida * (1 - cfg.getValorSensor()/cfg.getAlturaDesejada());
                tensaoSegura = TravaSeguranca.limitarTensaoMaxima(erro);
                tensaoNivelSeguro = TravaSeguranca.limitarTensaoPorNivelTanque(cfg.getValorSensor(), tensaoSegura);
                graficoFuncao.atualizarGrafico(tensaoNivelSeguro);
                graficoNivel.atualizarGrafico(cfg.getValorSensor());
                conexao.writeValue(0, tensaoNivelSeguro);
                sleep(100);
            }
            conexao.writeValue(0, 0d);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorMalhaAberta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
