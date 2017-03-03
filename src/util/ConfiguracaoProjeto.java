/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Enum.TipoMalha;
import Enum.TipoOnda;
import funcoes.Onda;

/**
 *
 * @author lucasnobre
 */
public class ConfiguracaoProjeto {
    
    private Onda onda;
    private double offSet;
    private TipoOnda tipoOnda;
    private TipoMalha tipoMalha;
    private double amplitude;
    private float periodo;
    private double amplitudeMax;
    private double amplitudeMaxMalhaFechada;
    private double amplitudeMinMalhaFechada;
    private double amplitudeMin;
    private float duracaoMax;
    private float duracaoMin;
    private boolean isRunning;
    private double valorSensor;
    private String ipServidor;
    private int portaServidor; 
    private String tipoDeMalha;
    private double alturaDesejada;

    public ConfiguracaoProjeto() {
        this.amplitude = 0;
        this.periodo = 0;
        this.amplitudeMax = 0;
        this.amplitudeMin = 0;
        this.offSet = 0;
        this.amplitudeMaxMalhaFechada = 4;
        this.amplitudeMinMalhaFechada = 0;
        this.duracaoMax = 0;
        this.duracaoMin = 0;
        this.isRunning = false;
        this.valorSensor = 0d;
        this.ipServidor = "10.13.99.69";
        this.portaServidor = 20081;
        this.tipoDeMalha = "Aberta";
        this.alturaDesejada = 10.0;
    }
    

    public String getIpServidor() {
        return ipServidor;
    }

    public double getAmplitudeMaxMalhaFechada() {
        return amplitudeMaxMalhaFechada;
    }

    public void setAmplitudeMaxMalhaFechada(double amplitudeMaxMalhaFechada) {
        this.amplitudeMaxMalhaFechada = amplitudeMaxMalhaFechada;
    }

    public double getAmplitudeMinMalhaFechada() {
        return amplitudeMinMalhaFechada;
    }

    public TipoMalha getTipoMalha() {
        return tipoMalha;
    }

    public void setTipoMalha(TipoMalha tipoMalha) {
        this.tipoMalha = tipoMalha;
    }
    

    public void setAmplitudeMinMalhaFechada(double amplitudeMinMalhaFechada) {
        this.amplitudeMinMalhaFechada = amplitudeMinMalhaFechada;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public int getPortaServidor() {
        return portaServidor;
    }
    

    public void setPortaServidor(int portaServidor) {
        this.portaServidor = portaServidor;
    }
            

    public Double getValorSensor() {
        return valorSensor;
    }

    public void setValorSensor(Double valorSensor) {
        this.valorSensor = valorSensor;
    }
    
    public Double getOffSet() {
        return offSet;
    }

    public void setOffSet(Double offSet) {
        this.offSet = offSet;
    }

    public Onda getOnda() {
        return onda;
    }

    public void setOnda(Onda onda) {
        this.onda = onda;
    }

    public double getAmplitude() {       
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
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
    
    public String getTipoDeMalha(){
        return this.tipoDeMalha;
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

    public double getAlturaDesejada(){
        return alturaDesejada;
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
    
    public void setTipoDeMalha(String malha){
        this.tipoDeMalha = malha;
    }
    
    public void setAlturaDesejada(double altura){
        this.alturaDesejada = altura;
    }

    public boolean isRunning() {
        return isRunning;
    }    
}
