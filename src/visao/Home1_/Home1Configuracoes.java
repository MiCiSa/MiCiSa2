/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import visao.Home1;
import visao.componentes.Cor;
import visao.componentes.Mostre2;
import visao.componentes.Painel;
import visao.componentes.Painel3;

/**
 *
 * @author 50enta
 */
public class Home1Configuracoes extends Painel {
//atributos

    public Home1Configuracoes() {
        this.setBackground(Cor.VERDE);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarMenu());
    }

    public Painel3 formatarCabecalho() {
        Painel3 a = new Painel3();
        //O titulo
        Painel3 titulo = new Painel3();
        titulo.setLayout(new MigLayout("align right"));
        Mostre2 t = new Mostre2("Configurações");
        t.setForeground(Cor.BRANCO);
        titulo.add(t);
        Painel3 tt = new Painel3();
        tt.setLayout(new BorderLayout());
        tt.add(BorderLayout.CENTER, titulo);
        Painel3 bar = new Painel3();
        bar.setPreferredSize(new Dimension(1, 1));
        bar.setBackground(Cor.BRANCO);
        tt.add(BorderLayout.SOUTH, bar);

        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, tt); //tt
        return a;
    }

    public Painel3 formatarMenu() {
        Painel3 a = new Painel3();
        a.setLayout(new GridLayout(10, 1));
        a.add(formatarMenuCategorias());
        a.add(formatarMenuSubsidios());
        a.add(formatarMenuTaxas());
        a.add(formatarMenuUsuarios());
        a.add(formatarMenuAcessos());
        a.add(formatarMenuAjuda());
        a.add(formatarMenuSobre());
        Painel3 b = new Painel3();
        b.setLayout(new BorderLayout());
        b.add(BorderLayout.CENTER, a);
        Painel c = new Painel3();
        c.setPreferredSize(new Dimension(100, 200));
        b.add(BorderLayout.SOUTH, c);
        return b;
    }

    public Painel3 formatarMenuCategorias() {
        Painel3 a = new Painel3();
        a.setLayout(new MigLayout("align left, wrap 1"));
        Mostre2 lb = new Mostre2("Categorias");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.BRANCO);
        lb.setAlignmentX(LEFT_ALIGNMENT);
        lb.setAlignmentY(CENTER_ALIGNMENT);
        a.add(lb);
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Home1.irParaConfigCategorias();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lb.setForeground(Cor.CINZA_CLARO);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lb.setForeground(Cor.BRANCO);
            }

        });
        return a;
    }

    public Painel3 formatarMenuSubsidios() {
        Painel3 a = new Painel3();
        a.setLayout(new MigLayout("align left, wrap 1"));
        Mostre2 lb = new Mostre2("Subsídios e cargos");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.BRANCO);
        lb.setAlignmentX(LEFT_ALIGNMENT);
        lb.setAlignmentY(CENTER_ALIGNMENT);
        a.add(lb);
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Home1.irParaConfigSubsidios();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lb.setForeground(Cor.CINZA_CLARO);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lb.setForeground(Cor.BRANCO);
            }

        });
        return a;
    }

    public Painel3 formatarMenuTaxas() {
        Painel3 a = new Painel3();
        a.setLayout(new MigLayout("align left, wrap 1"));
        Mostre2 lb = new Mostre2("Taxas e impostos");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.BRANCO);
        lb.setAlignmentX(LEFT_ALIGNMENT);
        lb.setAlignmentY(CENTER_ALIGNMENT);
        a.add(lb);
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Home1.irParaConfigTaxas();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lb.setForeground(Cor.CINZA_CLARO);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lb.setForeground(Cor.BRANCO);
            }

        });
        return a;
    }

    public Painel3 formatarMenuUsuarios() {
        Painel3 a = new Painel3();
        a.setLayout(new MigLayout("align left, wrap 1"));
        Mostre2 lb = new Mostre2("Usuários do Sistema");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.BRANCO);
        lb.setAlignmentX(LEFT_ALIGNMENT);
        lb.setAlignmentY(CENTER_ALIGNMENT);
        a.add(lb);
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Home1.irParaConfigUsuarios();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lb.setForeground(Cor.CINZA_CLARO);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lb.setForeground(Cor.BRANCO);
            }

        });
        return a;
    }

    public Painel3 formatarMenuAcessos() {
        Painel3 a = new Painel3();
        a.setLayout(new MigLayout("align left, wrap 1"));
        Mostre2 lb = new Mostre2("Acessos ao Sistema");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.BRANCO);
        lb.setAlignmentX(LEFT_ALIGNMENT);
        lb.setAlignmentY(CENTER_ALIGNMENT);
        a.add(lb);
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Home1.irParaConfigAcessos();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lb.setForeground(Cor.CINZA_CLARO);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lb.setForeground(Cor.BRANCO);
            }

        });
        return a;
    }

    public Painel3 formatarMenuAjuda() {
        Painel3 a = new Painel3();
        a.setLayout(new MigLayout("align left, wrap 1"));
        Mostre2 lb = new Mostre2("Central de Ajuda");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.BRANCO);
        lb.setAlignmentX(LEFT_ALIGNMENT);
        lb.setAlignmentY(CENTER_ALIGNMENT);
        a.add(lb);
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Home1.irParaConfigAjuda();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lb.setForeground(Cor.CINZA_CLARO);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lb.setForeground(Cor.BRANCO);
            }

        });
        return a;
    }

    public Painel3 formatarMenuSobre() {
        Painel3 a = new Painel3();
        a.setLayout(new MigLayout("align left, wrap 1"));
        Mostre2 lb = new Mostre2("Sobre");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.BRANCO);
        lb.setAlignmentX(LEFT_ALIGNMENT);
        lb.setAlignmentY(CENTER_ALIGNMENT);
        a.add(lb);
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Home1.irParaConfigSobre();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lb.setForeground(Cor.CINZA_CLARO);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lb.setForeground(Cor.BRANCO);
            }

        });
        return a;
    }
}
