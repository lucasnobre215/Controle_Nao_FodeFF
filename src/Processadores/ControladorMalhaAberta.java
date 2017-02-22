/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processadores;

import Graficos.FuncaoTimeSeries;
import Graficos.TimeSeriesChart;
import br.ufrn.dca.controle.QuanserClient;
import br.ufrn.dca.controle.QuanserClientException;
import funcoes.Onda;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfiguracaoProjeto;

/**
 *
 * @author lucasnobre
 */
public class ControladorMalhaAberta extends Controlador {

    QuanserClient client;
    double tensaoSaida;
    double tensaoSaidaSaturada;

    public ControladorMalhaAberta(ConfiguracaoProjeto cfg, TimeSeriesChart graficoFuncao) {
        super(cfg, graficoFuncao);
    }

    @Override
    public void run() {
        float tempo = 0;
        cfg.setIsRunning(true);
        try {
            //        QuanserClient client = new QuanserClient("192.168.0.1", 0);
            while (cfg.isRunning()) {
                tempo += 0.1;
                tensaoSaida = cfg.getOnda().calcular(tempo);
                System.out.println(tensaoSaida);
                //System.out.println(cfg.getOnda().getTipoOnda());
                //lersensor
//                tratarTensao
//                graficoFuncao.atualizarGrafico(tensaoSaidaSaturada);
                graficoFuncao.atualizarGrafico(tensaoSaida);
                //client.escrever(tensaoSaidaSaturada);

                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorMalhaAberta.class.getName()).log(Level.SEVERE, null, ex);
        }

//        } catch (QuanserClientException ex) { temporizador = new Temporizador(cfg);
//            Logger.getLogger(ControladorMalhaAberta.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
