/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processadores;

import Graficos.FuncaoTimeSeries;
import funcoes.Onda;

/**
 *
 * @author lucasnobre
 */
public abstract class Controlador implements Runnable{
    
    private Onda onda;
    private FuncaoTimeSeries graficoFuncao;
    //adicionar funcao
    private Float tempo;

    public Controlador(Onda onda, FuncaoTimeSeries grafico) {
        this.onda = onda;
        this.graficoFuncao = graficoFuncao;
        this.tempo = 0f;
    }
    
    
    
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
