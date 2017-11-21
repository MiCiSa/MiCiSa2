/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import visao.Home1;
import visao.cadastro.Cad;
import visao.componentes.Cor;
import visao.componentes.Fonte;
import visao.componentes.Mostre3;
import visao.componentes.Painel;
import visao.componentes.Painel1;

/**
 *
 * @author 50enta
 */
public class MenuFuncionarios extends Painel {

    public MenuFuncionarios() {
        this.setLayout(new GridLayout(1, 5, -1, -1));
        this.add(formatar1());
        this.add(formatar2());
        this.add(formatar3());
        this.add(formatar4());
        this.add(formatar5());
    }

    public Painel formatar1() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        Mostre3 texto = new Mostre3("Cadastrar");
        Painel barra = new Painel();
        barra.setPreferredSize(new Dimension(2, 3));

        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(2, 1));
        bar.setBackground(Cor.CINZA_TEXTO);

        Painel g = new Painel();
        g.add(texto);

        a.add(BorderLayout.CENTER, g);
        a.add(BorderLayout.SOUTH, barra);
        a.add(BorderLayout.NORTH, new Painel());
//        a.add(BorderLayout.EAST, bar);

        texto.setFont(Fonte.CALIBRI_NORMAL);
        texto.setForeground(Cor.CINZA_ESCURO);
        a.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaCadastro(true);
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                barra.setBackground(Cor.AZUL);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
//                a.setBorder(null);
                barra.setBackground(Cor.BRANCO);
            }

        });

        return a;
    }

    public Painel formatar2() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        Mostre3 texto = new Mostre3("Salário");
        Painel barra = new Painel();
        barra.setPreferredSize(new Dimension(2, 3));

        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(2, 1));
        bar.setBackground(Cor.CINZA_TEXTO);

        Painel g = new Painel();
        g.add(texto);

        a.add(BorderLayout.CENTER, g);
        a.add(BorderLayout.SOUTH, barra);
        a.add(BorderLayout.NORTH, new Painel());
        // a.add(BorderLayout.EAST, bar);

        texto.setFont(Fonte.CALIBRI_NORMAL);
        texto.setForeground(Cor.CINZA_ESCURO);
        a.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1Funcionarios.irParaPromover(true);
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                barra.setBackground(Cor.AZUL);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
//                a.setBorder(null);
                barra.setBackground(Cor.BRANCO);
            }

        });

        return a;
    }

    public Painel formatar3() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        Mostre3 texto = new Mostre3("Editar");
        Painel barra = new Painel();
        barra.setPreferredSize(new Dimension(2, 3));

        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(2, 1));
        bar.setBackground(Cor.CINZA_TEXTO);

        Painel g = new Painel();
        g.add(texto);

        a.add(BorderLayout.CENTER, g);
        a.add(BorderLayout.SOUTH, barra);
        a.add(BorderLayout.NORTH, new Painel());
        // a.add(BorderLayout.EAST, bar);

        texto.setFont(Fonte.CALIBRI_NORMAL);
        texto.setForeground(Cor.CINZA_ESCURO);
        a.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);

                if (!(Home1Funcionarios.funcionario == null)) {
                    Home1.irParaCadastro(true);
                    Cad.inicializarComDados(Home1Funcionarios.funcionario);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione um funcionário");
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                barra.setBackground(Cor.AZUL);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
//                a.setBorder(null);
                barra.setBackground(Cor.BRANCO);
            }

        });

        return a;
    }

    public Painel formatar4() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        Mostre3 texto = new Mostre3("Status");
        Painel barra = new Painel();
        barra.setPreferredSize(new Dimension(2, 3));

        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(2, 1));
        bar.setBackground(Cor.CINZA_TEXTO);

        Painel g = new Painel();
        g.add(texto);

        a.add(BorderLayout.CENTER, g);
        a.add(BorderLayout.SOUTH, barra);
        a.add(BorderLayout.NORTH, new Painel());
        // a.add(BorderLayout.EAST, bar);

        texto.setFont(Fonte.CALIBRI_NORMAL);
        texto.setForeground(Cor.CINZA_ESCURO);
        a.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1Funcionarios.irParaStatus(true);
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                barra.setBackground(Cor.AZUL);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
//                a.setBorder(null);
                barra.setBackground(Cor.BRANCO);
            }

        });

        return a;
    }

    public Painel formatar5() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        Mostre3 texto = new Mostre3("Histórico");
        Painel barra = new Painel();
        barra.setPreferredSize(new Dimension(2, 3));

        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(2, 1));
        bar.setBackground(Cor.CINZA_TEXTO);

        Painel g = new Painel();
        g.add(texto);

        a.add(BorderLayout.CENTER, g);
        a.add(BorderLayout.SOUTH, barra);
        a.add(BorderLayout.NORTH, new Painel());
        // a.add(BorderLayout.EAST, bar);

        texto.setFont(Fonte.CALIBRI_NORMAL);
        texto.setForeground(Cor.CINZA_ESCURO);
        a.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1Funcionarios.irParaHistorico(true);

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                barra.setBackground(Cor.AZUL);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
//                a.setBorder(null);
                barra.setBackground(Cor.BRANCO);
            }

        });

        return a;
    }
}
