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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import visao.componentes.Cor;
import visao.componentes.Painel;
import static visao.graficos.BarChart1_AWT.barChart;

public class BarChart_AWT extends Painel {

  public static JFreeChart barChart;
    ChartPanel chartPanel;

    public Image criarImagem() {
        ChartRenderingInfo a = new ChartRenderingInfo();
        return barChart.createBufferedImage(400, 250, a);
    }

    public BarChart_AWT(String chartTitle, Dimension dimensao, int ano) {

        barChart = ChartFactory.createBarChart(chartTitle, "", "", createDataset(ano), PlotOrientation.VERTICAL, true, true, false);

        chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(dimensao);

barChart.getLegend().setVisible(false);
        this.add(chartPanel);
        CategoryPlot plot;
        plot = barChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);
        plot.setOutlineVisible(false);

        CategoryPlot plot1 = barChart.getCategoryPlot();

        BarRenderer render = (BarRenderer) plot1.getRenderer();
        render.setSeriesPaint(0, new Color(95,95,95));

        barChart.setBackgroundPaint(Color.WHITE);

    }

    public static CategoryDataset createDataset(int ano) {
        String fiat = " ";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Estatistica a = new Estatistica();
       
 
        dataset.addValue(a.getTotalLiquido(ano, 0), fiat, new String("Ja"));
        dataset.addValue(a.getTotalLiquido(ano, 1), fiat, new String("Fe"));
        dataset.addValue(a.getTotalLiquido(ano, 2), fiat, new String("Ma"));
        dataset.addValue(a.getTotalLiquido(ano, 3), fiat, new String("Ab"));
        dataset.addValue(a.getTotalLiquido(ano, 4), fiat, new String("Mai"));
        dataset.addValue(a.getTotalLiquido(ano, 5), fiat, new String("Ju"));
        dataset.addValue(a.getTotalLiquido(ano, 6), fiat, new String("Jul"));
        dataset.addValue(a.getTotalLiquido(ano, 7), fiat, new String("Ag"));
        dataset.addValue(a.getTotalLiquido(ano, 8), fiat, new String("Se"));
        dataset.addValue(a.getTotalLiquido(ano, 9), fiat, new String("Ou"));
        dataset.addValue(a.getTotalLiquido(ano, 10), fiat, new String("No"));
        dataset.addValue(a.getTotalLiquido(ano, 11), fiat, new String("De"));

        return dataset;
    }

    public static void main(String[] args) {
        BarChart_AWT chart = new BarChart_AWT("", new Dimension(400, 200),2017);
        JFrame frame = new JFrame();
        frame.add(chart);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.pack();

    }

}
