package visao.Home1_;

import visao.componentes.Desenho1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import modelo.Estatistica;
import net.miginfocom.swing.MigLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import visao.componentes.Cor;
import visao.componentes.EscolhaAno;
import visao.componentes.EscolhaMes;
import visao.componentes.Mostre1;
import visao.componentes.Mostre2;
import visao.componentes.Mostre4;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Painel1;
import visao.componentes.Rolagem;
import visao.graficos.BarChart1_AWT;
import visao.graficos.BarChart_AWT;
import visao.graficos.PieChart_AWT;

public class Home1Estatistica extends Painel1 {
//atributos

    static Estatistica estat = new Estatistica();
    static Painel pnlGrafic2 = new Painel();
    static Painel pnlGrafic1 = new Painel();
    
    Mostre2 lblNrCadastro = new Mostre2("55");
    Mostre2 lblNrActivos = new Mostre2("32");
    Mostre2 lblNrInactivos = new Mostre2("23");
    Mostre1 lblNrFem = new Mostre1("25");
    Mostre1 lblNrMasc = new Mostre1("15");
    Mostre2 lblNrDispensados = new Mostre2("12");
    EscolhaAno anoEmCausa = new EscolhaAno();
    EscolhaMes mesEmCausa = new EscolhaMes();
    public static Desenho1 bolaEsquerda = new Desenho1("24", Cor.PRETO);
    public static Desenho1 bolaDireita = new Desenho1("26", Cor.AZUL);

    //construtor
    public Home1Estatistica() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, new Rolagem(formatarInformacao()));
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.EAST, new Painel1());
        this.add(BorderLayout.WEST, new Painel1());
        this.Actualizar(2017, 2);
    }
    
    public Painel formatarCabecalho() {
        Painel a = new Painel();
        //O titulo
        Painel titulo = new Painel();
        titulo.setLayout(new MigLayout("align right"));
        Mostre2 t = new Mostre2("Estatística");
        t.setForeground(Cor.CINZA_ESCURO);
        titulo.add(t);
        Painel tt = new Painel();
        tt.setLayout(new BorderLayout());
        tt.add(BorderLayout.CENTER, titulo);
        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(1, 1));
        bar.setBackground(Cor.CINZA_TEXTO);
        tt.add(BorderLayout.SOUTH, bar);
        
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, tt); //tt
        return a;
    }
    
    public Painel formatarInformacao() {
        Painel1 a = new Painel1();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.CENTER, formatarBases());
        a.add(BorderLayout.NORTH, formatarCabecalhoInformacao());
        return a;
    }
    
    public Painel formatarCabecalhoInformacao() {
        Painel1 a = new Painel1();
        
        Painel1 pnlCabecalho = new Painel1();
        pnlCabecalho.setLayout(new BorderLayout());
        Painel1 pnlGrids = new Painel1();
        pnlCabecalho.add(BorderLayout.NORTH, pnlGrids);
        pnlCabecalho.add(BorderLayout.CENTER, new Painel1());
        pnlCabecalho.add(BorderLayout.EAST, new Painel1());
        pnlCabecalho.add(BorderLayout.WEST, new Painel1());
        
        pnlGrids.setLayout(new GridLayout(1, 6, 55, 55));
        //Os paineis do cabecalho da informacao
        Painel1 pnlGrid1 = new Painel1();
        Painel1 pnlGrid2 = new Painel1();
        Painel1 pnlGrid3 = new Painel1();
        Painel1 pnlGrid4 = new Painel1();
        Painel1 pnlGrid5 = new Painel1();

        //Adicionando os paineis do grid no painel cabecalho
        pnlGrids.add(pnlGrid1);
        pnlGrids.add(pnlGrid2);
        pnlGrids.add(pnlGrid3);
        pnlGrids.add(pnlGrid4);
        pnlGrids.add(new Painel1());
        pnlGrids.add(pnlGrid5);

        //Formatacao do pnlGrid1
        pnlGrid1.setLayout(new BorderLayout());
        
        Painel1 pnlGridCadastros = new Painel1();
        Painel1 pnlGridnrCadastros = new Painel1();
        pnlGrid1.add(BorderLayout.NORTH, pnlGridCadastros);
        pnlGrid1.add(BorderLayout.CENTER, pnlGridnrCadastros);

        //Formatacao do grid11
        Mostre4 lblCadastro = new Mostre4("Cadastrados");
        lblCadastro.setForeground(Cor.BRANCO);
        
        pnlGridCadastros.add(lblCadastro);
        pnlGridCadastros.setBackground(Cor.VERDE);
        pnlGridnrCadastros.add(lblNrCadastro);
        pnlGridnrCadastros.setBackground(Cor.BRANCO);

        //Formatacao do pnlGrid2     
        pnlGrid2.setLayout(new BorderLayout());
        Painel1 pnlGridActivos = new Painel1();
        Painel1 pnlGridNrActivos = new Painel1();
        pnlGrid2.add(BorderLayout.NORTH, pnlGridActivos);
        pnlGrid2.add(BorderLayout.CENTER, pnlGridNrActivos);

        //Formataco do grid12
        Mostre4 lblActivos = new Mostre4("Activos");
        lblActivos.setForeground(Cor.BRANCO);
        
        lblNrActivos.setForeground(new Color(219, 180, 145));
        pnlGridActivos.setBackground(new Color(219, 180, 145));
        pnlGridNrActivos.setBackground(Cor.BRANCO);
        pnlGridActivos.add(lblActivos);
        pnlGridNrActivos.add(lblNrActivos);

        //Formatacao do pnlGrid3
        pnlGrid3.setLayout(new BorderLayout());
        Painel1 pnlGridInactivos = new Painel1();
        pnlGridInactivos.setBackground(new Color(79, 79, 240));
        Painel1 pnlGridNrInactivos = new Painel1();
        pnlGridNrInactivos.setBackground(Cor.BRANCO);
        pnlGrid3.add(BorderLayout.NORTH, pnlGridInactivos);
        pnlGrid3.add(BorderLayout.CENTER, pnlGridNrInactivos);

        //Formataco do grid13
        Mostre4 lblInactivos = new Mostre4("Inactivos");
        lblInactivos.setForeground(Cor.BRANCO);
        
        lblNrInactivos.setForeground(new Color(79, 79, 240));
        pnlGridInactivos.add(lblInactivos);
        pnlGridNrInactivos.add(lblNrInactivos);

        //Formatacao do pnlGrid4
        pnlGrid4.setLayout(new BorderLayout());
        Painel1 pnlGridDispensados = new Painel1();
        Painel1 pnlGridNrDispensados = new Painel1();
        pnlGrid4.add(BorderLayout.NORTH, pnlGridDispensados);
        pnlGrid4.add(BorderLayout.CENTER, pnlGridNrDispensados);

        //Formatacao do grid14
        Mostre4 lblDispensados = new Mostre4("Dispensados");
        lblDispensados.setForeground(Cor.BRANCO);
        
        lblNrDispensados.setForeground(new Color(255, 157, 60));
        pnlGridDispensados.add(lblDispensados);
        pnlGridDispensados.setBackground(new Color(255, 157, 60));
        pnlGridNrDispensados.add(lblNrDispensados);
        pnlGridNrDispensados.setBackground(Cor.BRANCO);

        //Formatacao dos comboBox
        pnlGrid5.setLayout(new MigLayout("align center, wrap 1"));
        
        pnlGrid5.add(anoEmCausa);
        anoEmCausa.setMaximum(new Date().getYear() + 1900);
//        pnlGrid5.add(mesEmCausa);
        anoEmCausa.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                int ano = anoEmCausa.getYear();
                Actualizar(ano, 234);
            }
        });
        
        a.add(pnlCabecalho);
        
        return a;
    }
    
    public Painel formatarBases() {
        Painel1 a = new Painel1();
        a.setLayout(new GridLayout(2, 1, 15, 15));
        a.add(formatarBase1());
        a.add(formatarBase2());
        return a;
    }
    
    public Painel formatarBase1() {
        Painel1 a = new Painel1();
        Painel1 pnlVazio = new Painel1();
        
        a.setLayout(new MigLayout("align center, wrap 3"));
        a.add(this.formatarGrafico1());
        a.add(pnlVazio);
        a.add(this.formatarGrafico2());
        return a;
    }
    
    public Painel formatarGrafico1() {
        Painel a = new Painel();
        Painel cabecalho = new Painel();
        
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, cabecalho);
        a.add(BorderLayout.CENTER, new Rolagem(pnlGrafic1));
        a.setPreferredSize(new Dimension(600, 500));
        
        pnlGrafic1.add(new BarChart_AWT("", new Dimension(350, 183), new Date().getYear() + 1900));

        //Formatacao do cabecalho do grafico
        cabecalho.setBackground(new Color(75, 166, 214));
        Mostre4 lblCabecalho = new Mostre4("Gastos com os funcionarios                                    ");
        lblCabecalho.setForeground(Cor.CINZA_CLARO);
        cabecalho.setLayout(new MigLayout("align left"));
        cabecalho.add(lblCabecalho);

        //Formatacao do corpo do grafico
        //aqui e onde vai conter o grafico
        return a;
    }
    
    public Painel formatarGrafico2() {
        Painel a = new Painel();
        
        Painel pnlGraficoCabecalho = new Painel();
        Painel pnlGraficoCorpo = new Painel();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, pnlGraficoCabecalho);
        a.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pnlGraficoCorpo)));
        a.setPreferredSize(new Dimension(750, 500));
        //Formatacao do cabecalho do grafico
        pnlGraficoCabecalho.setBackground(new Color(173, 164, 154));
        Mostre4 lblCabecalho = new Mostre4("Visão geral dos funcionários ");
        lblCabecalho.setForeground(Color.WHITE);
        pnlGraficoCabecalho.setLayout(new MigLayout("align left"));
        pnlGraficoCabecalho.add(lblCabecalho);

        //Formatacao do corpo do grafico
        pnlGraficoCorpo.add(new PieChart_AWT());
        //onde va contero grafico 
        return a;
    }
    
    public Painel formatarBase2() {
        Painel1 a = new Painel1();
        
        a.setLayout(new GridLayout(1, 3, 10, 10));
        
        Painel pnlGrafico1 = new Painel();
        Painel pnlGrafico2 = new Painel();
        Painel pnlGrafico3 = new Painel();

        //Adicionando os paineis dos graficos no grid
        a.add(pnlGrafico1);
        a.add(pnlGrafico2);
        a.add(pnlGrafico3);

        //Formatacao so grafico 1
        pnlGrafico1.setLayout(new BorderLayout());
        
        Painel pnlCentro = new Painel();
        Painel pnlSul = new Painel();
        pnlGrafico1.add(BorderLayout.CENTER, pnlCentro);
        pnlGrafico1.add(BorderLayout.NORTH, pnlSul);

        //Formatacao do painel norte e sul
        pnlCentro.setLayout(new GridLayout(1, 2));
        
        pnlCentro.add(bolaEsquerda);
        
        Mostre1 mafiaMasc = new Mostre1("  ");
        bolaEsquerda.setLayout(new MigLayout("align center, wrap 1"));
//        bolaEsquerda.add(mafiaMasc);
//        bolaEsquerda.add(lblNrMasc);

        pnlCentro.add(bolaDireita);
        
        lblNrFem.setForeground(Cor.AZUL);
        Mostre1 mafiaFem = new Mostre1("  ");
        
        bolaDireita.setLayout(new MigLayout("align center, wrap 1"));
//        bolaDireita.add(mafiaFem);
//        bolaDireita.add(lblNrFem);

        pnlSul.setLayout(new GridLayout(1, 2));
        Painel pnlMasc = new Painel();
        Painel pnlFem = new Painel();
        pnlSul.add(pnlMasc);
        pnlSul.add(pnlFem);

        //Formatacao dos grids 
        //aqui vai conter as bolas do paint component
        Mostre6 lblMasc = new Mostre6("Masculino");
        pnlMasc.add(lblMasc);
        
        Mostre6 lblFem = new Mostre6("Feminino");
        pnlFem.add(lblFem);

        //Formatacao do grafico 2
        pnlGrafico2.setLayout(new BorderLayout());
        Painel pnlGraficoCabecalho = new Painel();
        
        pnlGrafico2.add(BorderLayout.NORTH, pnlGraficoCabecalho);
        pnlGrafico2.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pnlGrafic2)));
        
        pnlGraficoCabecalho.setBackground(new Color(140, 223, 175));
        Mostre4 lblCabecalho = new Mostre4("Somatorio de Faltas mensais ");
        lblCabecalho.setForeground(Color.WHITE);
        pnlGraficoCabecalho.setLayout(new MigLayout("align left"));
        pnlGraficoCabecalho.add(lblCabecalho);
        pnlGrafic2.add(new BarChart1_AWT("", new Dimension(350, 183), new Date().getYear() + 1900));
        return a;
    }
    
    public void Actualizar(int ano, int mes) {
        
        lblNrCadastro.setText(Integer.toString(estat.getCadastrados()));
        lblNrDispensados.setText(Integer.toString(estat.getDispensados()));
        lblNrActivos.setText(Integer.toString(estat.getActivo()));
        lblNrDispensados.setText(Integer.toString(estat.getDispensados()));
        lblNrInactivos.setText(Integer.toString(estat.getInactivo()));
        bolaDireita.numero = Integer.toString(estat.getMasculino());
        bolaEsquerda.numero = Integer.toString(estat.getFeminino());
        
        pnlGrafic1.removeAll();
        pnlGrafic1.repaint();
        BarChart_AWT.barChart = ChartFactory.createBarChart(" ", "", "", BarChart_AWT.createDataset(ano), PlotOrientation.VERTICAL, true, true, false);
        pnlGrafic1.add(new BarChart_AWT("", new Dimension(350, 183), ano));
        pnlGrafic1.revalidate();
        
        pnlGrafic2.removeAll();
        pnlGrafic2.repaint();
        BarChart1_AWT.barChart = ChartFactory.createBarChart(" ", "", "", BarChart1_AWT.createDataset(ano), PlotOrientation.VERTICAL, true, true, false);
        pnlGrafic2.add(new BarChart1_AWT("", new Dimension(350, 183), ano));
        pnlGrafic2.revalidate();
    }
    
}
