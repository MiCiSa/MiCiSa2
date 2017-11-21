/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.confiuracoes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import visao.Home;
import visao.Home1;
import visao.componentes.Cor;
import visao.componentes.EscolhaValor;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Painel3;
import visao.confiuracoes.Categorias.MostreVerde;

/**
 *
 * @author 50enta
 */
public class Taxas extends Painel3 {

    //Atribtutos
    Categorias.MostreVerde lblTaxaDescontoPorFalta = new Categorias.MostreVerde("2%");
    EscolhaValor spnTaxaDescontoPorFalta = new EscolhaValor();

    Categorias.MostreVerde lblTaxaDescontoPorHoraExtra = new Categorias.MostreVerde("1%");
    EscolhaValor spnTaxaDescontoPorHoraExtra = new EscolhaValor();

    Categorias.MostreVerde lblTaxaDescontoInss = new Categorias.MostreVerde("3%");
    EscolhaValor spnTaxaDescontoInss = new EscolhaValor();

    //construtores
    public Taxas() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarGeral());
    }

    public Painel3 formatarCabecalho() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.LINE_AXIS));
        Mostre lblVoltar = new Mostre();
        lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
        Mostre2 lb = new Mostre2("Taxas e impostos");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 22));
        lb.setForeground(Cor.BRANCO);
        Mostre2 i = new Mostre2("espa");
        a.add(i);
        a.add(lblVoltar);
        a.add(lb);
        lblVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaConfiguracoesInicio();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarP.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
            }

        });
        a.setPreferredSize(new Dimension(50, 50));
        return a;
    }

    public Painel3 formatarGeral() {
        Painel3 a = new Painel3();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.CENTER, formatarBase1());
        return a;
    }

    public Painel3 formatarBase1() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.PAGE_AXIS));
        a.add(new Painel3());
//        Painel3 u = new Painel3();
//        u.add(new MostreVerde("Desconto por cada falta"));
//        a.add(u);
//        Painel3 b = new Painel3();
//        b.add(lblTaxaDescontoPorFalta);
//        lblTaxaDescontoPorFalta.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 24));
//        a.add(b);
//        Painel3 o = new Painel3();
//        o.add(spnTaxaDescontoPorFalta);
//        a.add(o);
//        a.add(formatabarBotaoFalta());
        a.add(new Painel3());
        a.add(new Painel3());

        Painel3 c5 = new Painel3();
        c5.add(new MostreVerde("Desconto por Hora Extra "));
        a.add(c5);
        Painel3 j = new Painel3();
        j.add(lblTaxaDescontoPorHoraExtra);
        lblTaxaDescontoPorHoraExtra.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 24));
        a.add(j);
        Painel3 c = new Painel3();
        c.add(spnTaxaDescontoPorHoraExtra);
        a.add(c);
        a.add(formatabarBotaoHorasExtras());
        a.add(new Painel3());
        a.add(new Painel3());

        Painel3 c51 = new Painel3();
        c51.add(new MostreVerde("Desconto para inss"));
        a.add(c51);
        Painel3 j1 = new Painel3();
        j1.add(lblTaxaDescontoInss);
        lblTaxaDescontoInss.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 24));
        a.add(j1);
        Painel3 c1 = new Painel3();
        c1.add(spnTaxaDescontoInss);
        a.add(c1);
        a.add(formatabarBotaoInss());
        spnTaxaDescontoInss.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                lblTaxaDescontoInss.setText((String) spnTaxaDescontoInss.getValue() + "%");
            }
        });
        spnTaxaDescontoPorHoraExtra.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                lblTaxaDescontoPorHoraExtra.setText((String) spnTaxaDescontoInss.getValue() + "%");
            }
        });
        a.add(new Painel3());
        a.add(new Painel3());
        return a;
    }

    public Painel3 formatabarBotaoFalta() {
        Painel3 a = new Painel3();

        Painel3 pnlbot = new Painel3();
        pnlbot.setBorder(new EtchedBorder(4, Cor.BRANCO, Cor.BRANCO));
        pnlbot.add(new Categorias.MostreVerde("Actualizar"));
        pnlbot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int i = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                if(i == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Sucesso");
                }
            }

        });
        Mostre2 lblExcluir = new Mostre2("Excl         uir");
        lblExcluir.setForeground(Cor.VERDE);

        a.add(new Painel3());
        a.add(lblExcluir);
        a.add(pnlbot);
        return a;
    }

    public Painel3 formatabarBotaoHorasExtras() {
        Painel3 a = new Painel3();

        Painel3 pnlbot = new Painel3();
        pnlbot.setBorder(new EtchedBorder(4, Cor.BRANCO, Cor.BRANCO));
        pnlbot.add(new Categorias.MostreVerde("Actualizar"));
        pnlbot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                 int i = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                if(i == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Sucesso");
                }
            }

        });
        Mostre2 lblExcluir = new Mostre2("Exc         luir");
        lblExcluir.setForeground(Cor.VERDE);

        a.add(new Painel3());
        a.add(lblExcluir);
        a.add(pnlbot);
        return a;
    }

    public Painel3 formatabarBotaoInss() {
        Painel3 a = new Painel3();

        Painel3 pnlbot = new Painel3();
        pnlbot.setBorder(new EtchedBorder(4, Cor.BRANCO, Cor.BRANCO));
        pnlbot.add(new Categorias.MostreVerde("Actualizar"));
        pnlbot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //
                //os ways de malta salvar 
                //
            }

        });
        Mostre2 lblExcluir = new Mostre2("Excl         uir");
        lblExcluir.setForeground(Cor.VERDE);

        a.add(new Painel3());
        a.add(lblExcluir);
        a.add(pnlbot);

        return a;
    }
}
