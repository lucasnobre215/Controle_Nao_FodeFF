/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlelab1;

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
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author lucasnobre
 */
public class TimeSeriesChart extends JPanel {

    private static final long serialVersionUID = 5128935838291298041L;
    private final DynamicTimeSeriesCollection dataset;
    private final JFreeChart chart;

    public TimeSeriesChart(String titulo, String grandeza) {
        dataset = new DynamicTimeSeriesCollection(1, 1000, new Second());
        chart = createChart(dataset, titulo, grandeza);
        final ChartPanel chartPanel = new ChartPanel( chart );
         chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        add(chartPanel);
        
    }

    private JFreeChart createChart(final XYDataset dataset,String titulo, String grandeza) {
       final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            null, 
            "tempo", 
            grandeza,
            null,
            true,                
            true,                    
            false                    
        );

        chart.setBackgroundPaint(Color.getColor("#6d9df"));
        
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.lightGray);
       
        
        ValueAxis valueaxis = plot.getDomainAxis (); 
        valueaxis.setAutoRange (true);
        valueaxis.setFixedAutoRange (120001D);
        Font fonte = new Font(valueaxis.getTickLabelFont().getFontName(), Font.PLAIN, 11);
        valueaxis.setTickLabelFont(fonte);
        configuraEixoy(plot.getRangeAxis(), fonte, false);
        
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        DateTickUnit unit = new DateTickUnit(DateTickUnitType.SECOND, 10);
        axis.setTickUnit(unit);
        axis.setDateFormatOverride(new SimpleDateFormat("mm:ss"));
        return chart;
    }
    private void configuraEixoy(ValueAxis eixoy, Font fonte, boolean isAutoRange) {
        eixoy.setTickLabelFont(fonte);
        eixoy.setRange(new Range(-1, 31));
        eixoy.setAutoRange(isAutoRange);
        eixoy.setAutoRangeMinimumSize(new Range(-1, 31).getLength());
    }

    public void update(float value) {
        float[] newData = new float[1];
        newData[0] = value;
        dataset.advanceTime();
        dataset.appendData(newData);
    }
}

