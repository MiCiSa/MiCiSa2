/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Date;
import javax.swing.JFrame;
import modelo.Estatistica;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import visao.componentes.Cor;
import visao.componentes.Painel;

public class BarChart1_AWT extends Painel {

    public static JFreeChart barChart;
    ChartPanel chartPanel;

    public Image criarImagem() {
        ChartRenderingInfo a = new ChartRenderingInfo();
        return barChart.createBufferedImage(400, 250, a);
    }

    public BarChart1_AWT(String chartTitle, Dimension dimensao, int ano) {

        barChart = ChartFactory.createBarChart(chartTitle, "", "", createDataset(ano), PlotOrientation.VERTICAL, true, true, false);

        chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(350, 250));

        Painel pnl = new Painel();
        pnl.setBackground(Color.red);
        pnl.add(chartPanel);

        this.add(chartPanel);
        CategoryPlot plot;
        plot = barChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);
        plot.setOutlineVisible(false);

        CategoryPlot plot1 = barChart.getCategoryPlot();
        ValueAxis axis = plot.getRangeAxis();
        axis.setVisible(false);
        
         barChart.getLegend().setVisible(false);

        BarRenderer render = (BarRenderer) plot1.getRenderer();
        render.setSeriesPaint(0, new Color(160,145,183));
        render.setSeriesPaint(1, Cor.AZUL);
        render.setSeriesPaint(3, Cor.PRETO);
        render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        render.setBaseItemLabelsVisible(true);
        barChart.setBackgroundPaint(Color.WHITE);
        render.setBaseItemLabelPaint(Cor.PRETO);

    }

    public static CategoryDataset createDataset(int ano) {
        String fiat = " ";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Estatistica a = new Estatistica();

        dataset.addValue(a.getTotalFaltas(ano, 0), fiat, new String("Ja"));
        dataset.addValue(a.getTotalFaltas(ano, 1), fiat, new String("Fe"));
        dataset.addValue(a.getTotalFaltas(ano, 2), fiat, new String("Ma"));
        dataset.addValue(a.getTotalFaltas(ano, 3), fiat, new String("Ab"));
        dataset.addValue(a.getTotalFaltas(ano, 4), fiat, new String("Mai"));
        dataset.addValue(a.getTotalFaltas(ano, 5), fiat, new String("Ju"));
        dataset.addValue(a.getTotalFaltas(ano, 6), fiat, new String("Jul"));
        dataset.addValue(a.getTotalFaltas(ano, 7), fiat, new String("Ag"));
        dataset.addValue(a.getTotalFaltas(ano, 8), fiat, new String("Se"));
        dataset.addValue(a.getTotalFaltas(ano, 9), fiat, new String("Ou"));
        dataset.addValue(a.getTotalFaltas(ano, 10), fiat, new String("No"));
        dataset.addValue(a.getTotalFaltas(ano, 11), fiat, new String("De"));

        return dataset;
    }

    public static void main(String[] args) {
        BarChart1_AWT chart = new BarChart1_AWT("", new Dimension(400, 190), 2017);
        JFrame frame = new JFrame();
        frame.add(chart);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.pack();

    }
}
