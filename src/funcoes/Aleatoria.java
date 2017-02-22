/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocontrole.dominio;

import Enum.TipoOnda;
import funcoes.Onda;
import java.util.Random;
import util.ConfiguracaoProjeto;

/**
 * Classe que representa uma onda Pseudoaleatoria
 * @author Victor
 */
public class Aleatoria implements Onda {

    ConfiguracaoProjeto cfg;
    float duracaoAleatoria;
    double amplitudeAleatoria;
    
    public Aleatoria(ConfiguracaoProjeto cfg) {
        this.cfg = cfg;
        duracaoAleatoria = -1;
    }
    
    
    
    private float geraDuracao() {
        return (float) geraNumAleatorio(cfg.getDuracaoMax(), cfg.getDuracaoMin());
    }
    
    private double geraNumAleatorio(double max, double min) {
        Random rand = new Random();
        return rand.nextDouble()*(max - min) + min;
    }

    
    @Override
    public TipoOnda getTipoOnda() {
        return TipoOnda.Aleatoria;
    }

    @Override
    public double calcular(float tempo) {
        duracaoAleatoria -= 0.1;
        if(duracaoAleatoria < 0){
            duracaoAleatoria = geraDuracao();
            return amplitudeAleatoria = geraNumAleatorio(cfg.getAmplitudeMax(), cfg.getAmplitudeMin());
        }else{
            return amplitudeAleatoria;
        }
    }
}
