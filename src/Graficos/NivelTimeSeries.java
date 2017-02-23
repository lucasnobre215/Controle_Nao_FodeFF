/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import org.jfree.data.Range;

/**
 *
 * @author lucasnobre
 */
public class NivelTimeSeries extends TimeSeriesChart{

     public NivelTimeSeries(String titulo, String grandeza,String legenda) {
        super(titulo, grandeza, legenda);
    }

    @Override
    public Range getRangeY() {
        return new Range(-1, 30);
    } 

    @Override
    public Range getRangeX() {
        return new Range(0,240);}
    
}
