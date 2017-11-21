/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.Estatistica;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;
import visao.componentes.Painel;

public class PieChart_AWT extends Painel {

    public PieChart_AWT() {
       // super(title);
       // setContentPane(createDemoPanel());
       this.add(createDemoPanel());
    }

    private static PieDataset createDataset() {
        //comeca aquii
        Estatistica a = new Estatistica();
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Ferias ", a.numeroFerias());
        dataset.setValue("Doenca", a.numeroDoentes());
        dataset.setValue("Licenca de Parto", a.numeroLincensaParto());
        dataset.setValue("Afastamento", a.numeroSuspensos());
        dataset.setValue("Demitidos", a.numeroDemitidos());
        dataset.setValue("Reforma", a.numeroReforma());
        dataset.setValue("Reforma", a.getActivo());
        //termin aqui
        //

        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                null, // chart title 
                dataset, // data    
                true, // include legend   
                true,
                false);
       
          
        PiePlot  plot = (PiePlot) chart.getPlot();
        plot.setShadowXOffset(0);
        plot.setShadowYOffset(0);
        plot.setLegendItemShape(new Rectangle(8, 6));
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setSectionPaint(1, new Color(255, 174, 94));
        plot.setSectionPaint(2, new Color(20,184,205));
        plot.setSectionPaint(3, new Color(3,61,51));
         plot.setSectionPaint(4, new Color(239,228,176));
          plot.setSectionPaint(5, new Color(64,128,128));
        
        plot.setLabelLinksVisible(false);
        plot.setLabelBackgroundPaint(new Color(255, 255, 255));
        plot.setLabelFont(new Font("calibri", Font.BOLD, 0));
        plot.setLabelShadowPaint(null);
        plot.setLabelGap(-10);
     
      
        PieSectionLabelGenerator a = new StandardPieSectionLabelGenerator("{0}:{1}({2}", new DecimalFormat("0"), new DecimalFormat("0.00%"));
 
      plot.setSectionOutlinePaint(1, new Color(255,255,255));
      plot.setSectionOutlinePaint(2, new Color(255,255,255));
      plot.setSectionOutlinePaint(3, new Color(255,255,255));
      plot.setSectionOutlinePaint(4, new Color(255,255,255));     
      plot.setSectionOutlinePaint(5, new Color(255,255,255));
      
                        
           
        LegendTitle legend  = chart.getLegend();
        legend.setPosition(RectangleEdge.RIGHT);
        legend.setBorder(BlockBorder.NONE);
        legend.setVerticalAlignment(VerticalAlignment.CENTER);
        legend.setFrame(BlockBorder.NONE);
        
        
        plot.setSectionOutlinesVisible(true);
        plot.setLabelLinkPaint(new Color(103,103,103));
       
        return chart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
          ChartPanel a = new ChartPanel(chart);
          a.setPreferredSize(new Dimension(395,215));
        return a;
    }

    public static void main(String[] args) {
//        PieChart_AWT demo = new PieChart_AWT("Mobile Sales");
//        demo.setSize(560, 367);
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);

      JFrame a = new JFrame();
      a.setVisible(true);
      a.setDefaultCloseOperation(3);
      a.pack();
      a.add(new PieChart_AWT());
      
    }
}
