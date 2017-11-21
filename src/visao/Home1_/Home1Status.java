/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import modelo.Funcionario;
import modelo.Status;
import net.miginfocom.swing.MigLayout;
import visao.cadastro.Cad3;
import visao.componentes.Cor;
import visao.componentes.Mostre;
import visao.componentes.Mostre6;
import visao.componentes.Painel;

/**
 *
 * @author 50enta
 */
public class Home1Status extends Painel {

    //atributos
    Funcionario funcionario;

    Painel p1 = new Painel();
    Painel p2 = new Painel();//paineis dos estados
    Painel p3 = new Painel();
    Painel p4 = new Painel();
    Painel p5 = new Painel();
    Painel p6 = new Painel();
    Painel p7 = new Painel();
    Painel p8 = new Painel();

    Painel cabecalho = new Painel();
    Painel meio = new Painel();
    Painel base = new Painel();

    public Home1Status() { //receberá o instãncia de cadastro para poder exibir dados e fazer modificações

        this.setLayout(new BorderLayout());

        //chamada aos métodos de formatação
        this.formatarBase();

        this.add(BorderLayout.CENTER, base);

    }

    public Home1Status(Funcionario func) { //receberá o instãncia de cadastro para poder exibir dados e fazer modificações

        this.setLayout(new BorderLayout());

        //chamada aos métodos de formatação
        this.formatarBase();

        this.add(BorderLayout.NORTH, cabecalho);
        this.add(BorderLayout.CENTER, base);

    }

    public void formatarBase() {//base
        base.setLayout(new GridLayout(2, 4));
        base.add(p1);
        base.add(p2);
        base.add(p3);
        base.add(p4);
        base.add(p5);
        base.add(p6);
        base.add(p7);
        base.add(p8);

        //métodos de formatação
        formatarP1();
        formatarP2();
        formatarP3();
        formatarP4();
        formatarP5();
        formatarP6();
        formatarP7();
        formatarP8();

    }

    public void formatarP1() {//p1
        p1.setLayout(new MigLayout("align center, wrap 1"));
        Mostre6 texto = new Mostre6(Status.ACTIVO);
        p1.setBackground(new Color(240, 240, 240));
        p1.setBorder(new EtchedBorder(Cor.VERDE, Cor.VERDE));
        texto.setForeground(new Color(5, 5, 5));
        texto.setFont(new java.awt.Font("calibri", java.awt.Font.BOLD, 16));
        p1.add(new Mostre6("   "));
        p1.add(new Mostre6("   "));
        p1.add(texto);
        p1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
//                status = "Serviço";
                if (funcionario != null) {
                     int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo mudar status ? ");
                    if( i == JOptionPane.YES_OPTION){
                       
                    funcionario.setEstado(Status.ACTIVO);
                    JOptionPane.showMessageDialog(null, (Cad3.funcionarios.salvar(funcionario) ? "Sucesso!" : "Erro"));
                    }
                        
                   
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                //p1.setBorder(new EtchedBorder());
                texto.setForeground(Cor.AZUL);
                p1.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                texto.setForeground(new Color(5, 5, 5));
                p1.setBackground(new Color(240, 240, 240));
                //p1.setBorder(null);
            }

        });
    }

    public void formatarP2() {//p2
        p2.setLayout(new MigLayout("align center, wrap 1"));
        Mostre6 texto = new Mostre6(Status.FERIAS);
        p2.setBackground(new Color(240, 240, 240));
        texto.setForeground(new Color(5, 5, 5));
        texto.setFont(new java.awt.Font("calibri", java.awt.Font.BOLD, 16));
        p2.add(new Mostre6("   "));
        p2.add(new Mostre6("   "));
        p2.add(texto);
        p2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
//                status = "Serviço";
//verificar se já está de férias
                if (funcionario != null) {
                       int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo mudar status ? ");
                    if( i == JOptionPane.YES_OPTION){
                    funcionario.setEstado(Status.FERIAS);
                    JOptionPane.showMessageDialog(null, (Cad3.funcionarios.salvar(funcionario) ? "Sucesso!" : "Erro"));
                }
            }
            }
            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                texto.setForeground(Cor.AZUL);
                p2.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                texto.setForeground(new Color(5, 5, 5));
                p2.setBackground(new Color(240, 240, 240));
            }

        });
    }

    public void formatarP3() {//p1
        p3.setLayout(new MigLayout("align center, wrap 1"));
        Mostre6 texto = new Mostre6(Status.DOENTE);
        p3.setBackground(new Color(240, 240, 240));
        p3.setBorder(new EtchedBorder(Cor.VERDE, Cor.VERDE));
        texto.setForeground(new Color(5, 5, 5));
        texto.setFont(new java.awt.Font("calibri", java.awt.Font.BOLD, 16));
        p3.add(new Mostre("   "));
        p3.add(new Mostre("   "));
        p3.add(texto);
        p3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                //método para mudar status entra aqui
                if (funcionario != null) {
                       int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo mudar status ? ");
                    if( i == JOptionPane.YES_OPTION){
                    funcionario.setEstado(Status.DOENTE);
                    JOptionPane.showMessageDialog(null, (Cad3.funcionarios.salvar(funcionario) ? "Sucesso!" : "Erro"));
                }
            }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                texto.setForeground(Cor.AZUL);
                p3.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                texto.setForeground(new Color(5, 5, 5));
                p3.setBackground(new Color(240, 240, 240));
            }

        });
    }

    public void formatarP4() {//p1
        p4.setLayout(new MigLayout("align center, wrap 1"));
        Mostre6 texto = new Mostre6(Status.LICENCA_DE_PARTO);
        p4.setBackground(new Color(240, 240, 240));
        texto.setForeground(new Color(5, 5, 5));
        texto.setFont(new java.awt.Font("calibri", java.awt.Font.BOLD, 16));
        p4.add(new Mostre("   "));
        p4.add(new Mostre("   "));
        p4.add(texto);
        p4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
//                //método para mudar status entra aqui
                if (funcionario != null) {
                       int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo mudar status ? ");
                    if( i == JOptionPane.YES_OPTION){
                    funcionario.setEstado(Status.LICENCA_DE_PARTO);
                    JOptionPane.showMessageDialog(null, (Cad3.funcionarios.salvar(funcionario) ? "Sucesso!" : "Erro"));
                }
            }

            }
            @Override
            public void mouseEntered(MouseEvent me) {
                texto.setForeground(Cor.AZUL);
                p4.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                texto.setForeground(new Color(5, 5, 5));
                p4.setBackground(new Color(240, 240, 240));
                p4.setBorder(null);
            }

        });
    }

    public void formatarP5() {//p1
        p5.setLayout(new MigLayout("align center, wrap 1"));
        Mostre6 texto = new Mostre6(Status.SUSPENSO);
        p5.setBackground(new Color(240, 240, 240));
        texto.setForeground(new Color(5, 5, 5));
        texto.setFont(new java.awt.Font("calibri", java.awt.Font.BOLD, 16));
        p5.add(new Mostre("   "));
        p5.add(new Mostre("   "));
        p5.add(texto);
        p5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                //método para mudar status entra aqui
                if (funcionario != null) {
                       int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo mudar status ? ");
                    if( i == JOptionPane.YES_OPTION){
                    funcionario.setEstado(Status.SUSPENSO);
                    JOptionPane.showMessageDialog(null, (Cad3.funcionarios.salvar(funcionario) ? "Sucesso!" : "Erro"));
                }
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                texto.setForeground(Cor.AZUL);
                p5.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                texto.setForeground(new Color(5, 5, 5));
                p5.setBackground(new Color(240, 240, 240));
            }

        });
    }

    public void formatarP6() {//p1
        p6.setLayout(new MigLayout("align center, wrap 1"));
        Mostre6 texto = new Mostre6(Status.DEMITIDO);
        p6.setBackground(new Color(240, 240, 240));
        p6.setBorder(new EtchedBorder(Cor.AZUL, Cor.AZUL));
        texto.setForeground(new Color(5, 5, 5));
        texto.setFont(new java.awt.Font("calibri", java.awt.Font.BOLD, 16));
        p6.add(new Mostre("   "));
        p6.add(new Mostre("   "));
        p6.add(texto);
        p6.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
//                status = "Demitido";
                if (funcionario != null) {
                       int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo mudar status ? ");
                    if( i == JOptionPane.YES_OPTION){
                    funcionario.setEstado(Status.DEMITIDO);
                    JOptionPane.showMessageDialog(null, (Cad3.funcionarios.salvar(funcionario) ? "Sucesso!" : "Erro"));
                }
            }
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                texto.setForeground(Cor.AZUL);
                p6.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                texto.setForeground(new Color(5, 5, 5));
                p6.setBackground(new Color(240, 240, 240));
            }

        });
    }

    public void formatarP7() {//p1
        p7.setLayout(new MigLayout("align center, wrap 1"));
        Mostre6 texto = new Mostre6(Status.REFORMA);
        p7.setBackground(new Color(240, 240, 240));
        texto.setForeground(new Color(5, 5, 5));
        texto.setFont(new java.awt.Font("calibri", java.awt.Font.BOLD, 16));
        p7.add(new Mostre("   "));
        p7.add(new Mostre("   "));
        p7.add(texto);
        p7.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (funcionario != null) {
                       int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo mudar status ? ");
                    if( i == JOptionPane.YES_OPTION){
                    funcionario.setEstado(Status.REFORMA);
                    JOptionPane.showMessageDialog(null, (Cad3.funcionarios.salvar(funcionario) ? "Sucesso!" : "Erro"));
                }
            }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                texto.setForeground(Cor.AZUL);
                p7.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                texto.setForeground(new Color(5, 5, 5));
                p7.setBackground(new Color(240, 240, 240));
            }

        });
    }

    public void formatarP8() {//p1
        p8.setLayout(new MigLayout("align center, wrap 1"));
        Mostre6 texto = new Mostre6(Status.DISPENSADO);
        p8.setBackground(new Color(240, 240, 240));
        p8.setBorder(new EtchedBorder(Cor.AZUL, Cor.AZUL));
        texto.setForeground(new Color(5, 5, 5));
        texto.setFont(new java.awt.Font("calibri", java.awt.Font.BOLD, 16));
        p8.add(new Mostre("   "));
        p8.add(new Mostre("   "));
        p8.add(texto);
        p8.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (funcionario != null) {
                       int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo mudar status ? ");
                    if( i == JOptionPane.YES_OPTION){
                    funcionario.setEstado(Status.DISPENSADO);
                    JOptionPane.showMessageDialog(null, (Cad3.funcionarios.salvar(funcionario) ? "Sucesso!" : "Erro"));
                }
            }
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                texto.setForeground(Cor.AZUL);
                p8.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                texto.setForeground(new Color(5, 5, 5));
                p8.setBackground(new Color(240, 240, 240));
            }

        });

    }

    /**
     * Método que inicializa os dados sobre o status de um determinado
     * funcionário cada vez que ele for seleccionado
     *
     * @param func
     */
    public void mostrarDados(Funcionario func) {
        this.funcionario = func;
    }
}
