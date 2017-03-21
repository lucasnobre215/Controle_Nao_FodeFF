/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;


/**
 *
 * @author lucasnobre
 */
public abstract class TimeSeriesChart extends JPanel {

    private static final long serialVersionUID = 5128935838291298041L;
    private Map<Object,Integer> seriesGraficas;
    private TimeSeries series;
    private final JFreeChart chart;
    private int contador;
    private static final String[] cores = {"#F44336", "#009688", "#3F51B5",
        "#FFC107", "#2196F3", "#9C27B0", "#4CAF50", "#673AB7", "#FF5722"};
    
    public abstract Range getRangeY();
    public abstract Range getRangeX();
    
    

    public TimeSeriesChart(String titulo, String grandeza, String legenda) {
        seriesGraficas = new HashMap<>();
        contador = 0;
        seriesGraficas.put(titulo, contador);
        
        this.series = new TimeSeries(legenda, Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        chart = createChart(dataset, titulo, grandeza);
        ChartPanel chartPanel = new ChartPanel( chart );
        add(chartPanel);
        contador++;
        
    }

    private JFreeChart createChart(final XYDataset dataset,String titulo, String grandeza) {
       final JFreeChart result = ChartFactory.createTimeSeriesChart(
                titulo,
                "Tempo (m)",
                grandeza,
                dataset,
                true,
                true,
                false
        );
       
        final XYPlot plot = result.getXYPlot();
        plot.setBackgroundPaint(new Color(0xffffe0));
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.lightGray);
        
        XYItemRenderer renderer = getRenderer();
        renderer.setSeriesPaint(0, Color.decode(cores[contador]));
        renderer.setSeriesStroke(0, new BasicStroke(1.3f));
        plot.setRenderer(renderer);
        
        ValueAxis xaxis = plot.getDomainAxis();

        //Domain axis would show data of 60 seconds for a time
        xaxis.setFixedAutoRange(120000.0);  // 600 seconds
//        xaxis.setVerticalTickLabels(true);

        ValueAxis yaxis = plot.getRangeAxis();
        configuraEixoy(yaxis, true);
       
        return result;
    }
    private void configuraEixoy(ValueAxis eixoy, boolean isAutoRange) {
        eixoy.setRange(getRangeY());
        eixoy.setAutoRange(isAutoRange);
        eixoy.setAutoRangeMinimumSize(getRangeY().getLength());
    }

    public void adicionarSerie(String legenda){
        XYPlot plot = chart.getXYPlot();
        TimeSeries timeSeries = new TimeSeries(legenda, Millisecond.class);
        TimeSeriesCollection dataSet = new TimeSeriesCollection(timeSeries);
        seriesGraficas.put(legenda, contador);
        plot.setDataset(contador, dataSet);
        XYItemRenderer renderer = getRenderer();
        renderer.setSeriesPaint(0, Color.decode(cores[contador]));
        renderer.setSeriesStroke(0, new BasicStroke(1.3f));
        plot.setRenderer(contador,renderer);
        System.out.println(plot.getSeriesCount());
        contador++;
    }
    protected abstract XYItemRenderer getRenderer();
   
    public void atualizarGrafico(double lastValue, String identificadorSerie) {
        XYPlot plot = chart.getXYPlot();
        Integer indexDataSet = seriesGraficas.get(identificadorSerie);
        ((TimeSeriesCollection)plot.getDataset(indexDataSet)).getSeries(0).add(new Millisecond(), lastValue);

    }

}
