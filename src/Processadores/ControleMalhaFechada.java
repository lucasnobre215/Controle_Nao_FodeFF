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
import javax.swing.JLabel;
import util.ConfiguracaoProjeto;
import util.TravaSeguranca;

/**
 *
 * @author lucasnobre
 */
public class ControleMalhaFechada extends Controlador {

    ConexaoQuanser conexao;
    double setPoint;
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

    public ControleMalhaFechada(ConfiguracaoProjeto cfg, TimeSeriesChart graficoFuncao, TimeSeriesChart graficoNivel, JLabel valorLido, JLabel valorEsperado) {
        super(cfg, graficoFuncao, graficoNivel, valorEsperado, valorLido);
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
                setPoint = cfg.getOnda().calcular(tempo);
                conexao.readValue(cfg.getCanalSensorControle());
                valorLido.setText(String.valueOf(cfg.getValorSensor()));
                erro = setPoint - cfg.getValorSensor();
                sinalSaida = funcoesControle.calcular(erro);

                //Gabiarra para funcionar, isso precisa ser deletado, ajustar 
                // o programa para suportar leituras de multiplos canais
                double valorSensorSeguranca = conexao.lerSensorSegurnacao(cfg.getCanalSensorSeguranca());

                sinalSaida = tensaoSegura = TravaSeguranca.limitarTensaoMaxima(sinalSaida);
                tensaoNivelSeguro = TravaSeguranca.limitarTensaoPorNivelTanque(valorSensorSeguranca, tensaoSegura);

                graficoFuncao.atualizarGrafico(tensaoNivelSeguro, "Função de Entrada");
                graficoNivel.atualizarGrafico(setPoint, "SetPoint");
                if (cfg.getCanalSensorControle() == 1) {
                    graficoNivel.atualizarGrafico(valorSensorSeguranca, "Nivel Tanque 1");
                    graficoNivel.atualizarGrafico(cfg.getValorSensor(), "Nivel Tanque 2");
                } else {
                    graficoNivel.atualizarGrafico(cfg.getValorSensor(), "Nivel Tanque 1");
                }
                conexao.writeValue(0, tensaoNivelSeguro);
                sleep(100);
            }
            conexao.writeValue(0, 0d);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorMalhaAberta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
