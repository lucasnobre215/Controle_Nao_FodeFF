/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.Millisecond;

/**
 *
 * @author lucasnobre
 */
public class FuncaoTimeSeries extends TimeSeriesChart {

    public FuncaoTimeSeries(String titulo, String grandeza, String legenda) {
        super(titulo, grandeza, legenda);
    }

    @Override
    public Range getRangeY() {
        return new Range(-5,4);
    } 

    @Override
    public Range getRangeX() {
        return new Range(0,240);}

    @Override
    protected XYItemRenderer getRenderer() {
       return new XYStepRenderer();
    }
    
}
