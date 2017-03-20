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
    double sinalSaida;
    double valorSensorAnterior;
    double tensaoSegura;
    double tensaoNivelSeguro;
    double erroAnterior;
    double acaoProporcional;
    double acaoDerivativa;
    double acaoIntegrativa;
    double erro;

    public ControleMalhaFechada(ConfiguracaoProjeto cfg, TimeSeriesChart graficoFuncao, TimeSeriesChart graficoNivel) {
        super(cfg, graficoFuncao, graficoNivel);
        conexao = new ConexaoQuanser(cfg);
    }

    @Override
    public void run() {
        float tempo = 0;
        cfg.setIsRunning(true);
        erroAnterior = 0;
        erro = 0;
        acaoIntegrativa = 0;
        valorSensorAnterior = 0;

        try {
            // A classe chamada onda tem uma interface, tem que implementar o calcular, tambem recebe a classe de configuracao
            //Essa classe implementa uma thread
            while (cfg.isRunning()) {
                tempo += cfg.getTempoAmostragem();
                tensaoSaida = cfg.getOnda().calcular(tempo);
                conexao.readValue(0);
                erro = cfg.getAlturaDesejada() - cfg.getValorSensor();

                acaoProporcional = cfg.getKp() * erro;
                acaoIntegrativa = acaoIntegrativa + (cfg.getKi() * cfg.getTempoAmostragem() * erro);
                if (!"PI-D".equals(cfg.getTipoControlador())) {
                    acaoDerivativa = cfg.getKd() * (erro - erroAnterior) / (cfg.getTempoAmostragem());
                } else {
                    acaoDerivativa = cfg.getKd() * (cfg.getValorSensor() - valorSensorAnterior) / (cfg.getTempoAmostragem());

                }
                erroAnterior = erro;
                valorSensorAnterior = cfg.getValorSensor();
                sinalSaida = acaoProporcional + acaoIntegrativa + acaoDerivativa;
                tensaoSegura = TravaSeguranca.limitarTensaoMaxima(sinalSaida);
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
