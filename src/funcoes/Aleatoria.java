/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocontrole.dominio;

import Enum.TipoOnda;
import funcoes.Onda;
import java.util.Random;

/**
 * Classe que representa uma onda Pseudoaleatoria
 * @author Victor
 */
public class Aleatoria implements Onda {

    private double amplitudeMax;
    private double amplitudeMin;
    private float duracaoMax;
    private float duracaoMin;
    private float duracaoAleatoria;
    private double amplitudeAleatoria;
    
    public Aleatoria() {
    }
    
    public Aleatoria(double amplitudeMax, double amplitudeMin,
            float duracaoMax, float duracaoMin) {
        this.amplitudeMax = amplitudeMax;
        this.amplitudeMin = amplitudeMin;
        this.duracaoMax = duracaoMax;
        this.duracaoMin = duracaoMin;
        this.duracaoAleatoria = geraDuracao();
        this.amplitudeAleatoria = geraNumAleatorio(amplitudeMax,amplitudeMin);
    }
    
    private float geraDuracao() {
        return (float) geraNumAleatorio(duracaoMax, duracaoMin);
    }
    
    private double geraNumAleatorio(double max, double min) {
        Random rand = new Random();
        return rand.nextDouble()*(max - min) + min;
    }

    public double getAmplitudeMax() {
        return amplitudeMax;
    }

    public void setAmplitudeMax(float amplitudeMax) {
        this.amplitudeMax = amplitudeMax;
    }

    public double getAmplitudeMin() {
        return amplitudeMin;
    }

    public void setAmplitudeMin(float amplitudeMin) {
        this.amplitudeMin = amplitudeMin;
    }

    public float getDuracaoMax() {
        return duracaoMax;
    }

    public void setDuracaoMax(float duracaoMax) {
        this.duracaoMax = duracaoMax;
    }

    public float getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(float duracaoMin) {
        this.duracaoMin = duracaoMin;
    } 
    
    public float getDuracaoAleatoria() {
        return duracaoAleatoria;
    }

    public void setDuracaoAleatoria(float duracaoAleatoria) {
        this.duracaoAleatoria = duracaoAleatoria;
    }

    public double getAmplitudeAleatoria() {
        return amplitudeAleatoria;
    }

    public void setAmplitudeAleatoria(double amplitudeAleatoria) {
        this.amplitudeAleatoria = amplitudeAleatoria;
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
            return amplitudeAleatoria = geraNumAleatorio(amplitudeMax, amplitudeMin);
        }else{
            return amplitudeAleatoria;
        }
    }
}
