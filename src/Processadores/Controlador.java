/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processadores;

import Graficos.FuncaoTimeSeries;
import Graficos.TimeSeriesChart;
import funcoes.Onda;
import funcoesControlador.FuncaoControle;
import javax.swing.JLabel;
import util.ConfiguracaoProjeto;
import util.FabricaOnda;

/**
 *
 * @author lucasnobre
 */
public abstract class Controlador implements Runnable{
    
    public Onda onda;
    public FuncaoControle funcoesControle;
    public ConfiguracaoProjeto cfg;
    public TimeSeriesChart graficoFuncao;
    public TimeSeriesChart graficoNivel;
    public JLabel valorLido;
    public JLabel valorEsperado;
    //adicionar funcao
    
    public Controlador(ConfiguracaoProjeto cfg, TimeSeriesChart graficoFuncao, TimeSeriesChart graficoNivel, JLabel valorLido, JLabel valorEsperado) {
        this.onda = cfg.getOnda();
        this.funcoesControle = cfg.getFuncoesControle();
        this.cfg = cfg;
        this.graficoFuncao = graficoFuncao;
        this.graficoNivel = graficoNivel;
        this.valorEsperado = valorEsperado;
        this.valorLido = valorLido;
    }    
    
    
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
