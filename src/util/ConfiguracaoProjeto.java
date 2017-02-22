/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Enum.TipoOnda;
import funcoes.Onda;

/**
 *
 * @author lucasnobre
 */
public class ConfiguracaoProjeto {
    
    private Onda onda;
    private TipoOnda tipoOnda;
    private float amplitude;
    private float periodo;
    private double amplitudeMax;
    private double amplitudeMin;
    private float duracaoMax;
    private float duracaoMin;
    private boolean isRunning;

    public ConfiguracaoProjeto() {
    }

    public Onda getOnda() {
        return onda;
    }

    public void setOnda(Onda onda) {
        this.onda = onda;
    }

    public float getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(float amplitude) {
        this.amplitude = amplitude;
    }

    public float getPeriodo() {
        return periodo;
    }

    public void setPeriodo(float periodo) {
        this.periodo = periodo;
    }

    public TipoOnda getTipoOnda() {
        return tipoOnda;
    }

    public void setTipoOnda(TipoOnda tipoOnda) {
        this.tipoOnda = tipoOnda;
    }
    
    public double getAmplitudeMax() {
        return amplitudeMax;
    }

    public void setAmplitudeMax(double amplitudeMax) {
        this.amplitudeMax = amplitudeMax;
    }

    public double getAmplitudeMin() {
        return amplitudeMin;
    }

    public void setAmplitudeMin(double amplitudeMin) {
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

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
    
    

    public boolean isRunning() {
        return isRunning;
    }
    
    
}
