/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processadores;

import Graficos.FuncaoTimeSeries;
import Graficos.TimeSeriesChart;
import funcoes.Onda;
import util.ConfiguracaoProjeto;
import util.FabricaOnda;

/**
 *
 * @author lucasnobre
 */
public abstract class Controlador implements Runnable{
    
    public Onda onda;
    public ConfiguracaoProjeto cfg;
    public TimeSeriesChart graficoFuncao;
    //adicionar funcao
    
    public Controlador(ConfiguracaoProjeto cfg, TimeSeriesChart graficoFuncao) {
        this.onda = cfg.getOnda();
        this.cfg = cfg;
        this.graficoFuncao = graficoFuncao;
    }    
    
    
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
