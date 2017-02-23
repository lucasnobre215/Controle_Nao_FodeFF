/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
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
    private TimeSeries series;
    private final JFreeChart chart;
    
    public abstract Range getRangeY();
    public abstract Range getRangeX();
    
    

    public TimeSeriesChart(String titulo, String grandeza) {
        this.series = new TimeSeries("Fluxo", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        chart = createChart(dataset, titulo, grandeza);
        final ChartPanel chartPanel = new ChartPanel( chart );
        add(chartPanel);
        
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

        ValueAxis xaxis = plot.getDomainAxis();

        //Domain axis would show data of 60 seconds for a time
        xaxis.setFixedAutoRange(120000.0);  // 600 seconds
        xaxis.setVerticalTickLabels(true);

        ValueAxis yaxis = plot.getRangeAxis();
        configuraEixoy(yaxis, true);

        return result;
    }
    private void configuraEixoy(ValueAxis eixoy, boolean isAutoRange) {
        eixoy.setRange(getRangeY());
        eixoy.setAutoRange(isAutoRange);
        eixoy.setAutoRangeMinimumSize(getRangeY().getLength());
    }

   
    public void atualizarGrafico(double lastValue) {
        final Millisecond now = new Millisecond();
        this.series.add(new Millisecond(), lastValue);
    }

}

