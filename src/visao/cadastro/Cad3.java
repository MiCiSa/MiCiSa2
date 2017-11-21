/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.cadastro;

import controlo.ControloConfigAcessos;
import controlo.ControloConfigCargos;
import controlo.ControloConfigCategorias;
import controlo.ControloConfigSubsidios;
import controlo.ControloFuncionario;
import controlo.ControloNotificacoes;
import java.awt.BorderLayout;
import java.awt.Component;
import static java.awt.Component.RIGHT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import static visao.Home1_.Home1Funcionarios.formatarSubtitulo;
import visao.componentes.Botao3;
import visao.componentes.Escolha;
import visao.componentes.Introduza1;
import visao.componentes.Introduza2;
import visao.componentes.Mostre5;
import visao.componentes.Painel;
import visao.componentes.Painel2;
import visao.componentes.Rolagem;

/**
 * Uma das telas que complementa o prceeso de cadastro.
 *
 * @author 50enta
 */
public class Cad3 extends Painel {
    //atributos

    //vzriavel geral - lista de todos os funcionários
    public static ControloFuncionario funcionarios = new ControloFuncionario();
    public static ControloConfigCargos cargos = new ControloConfigCargos();
    public static ControloConfigSubsidios subsidios = new ControloConfigSubsidios();
    public static ControloConfigCategorias categorias = new ControloConfigCategorias();
    public static ControloConfigAcessos acessos = new ControloConfigAcessos();
    public static ControloNotificacoes notificacoes = new ControloNotificacoes();

    Introduza2 txtBi = new Introduza2("ex: 110100000083");
    Introduza2 txtNuit = new Introduza2("ex: 123456778");
    Introduza1 txtBanco = new Introduza1("ex: Millenium Bim");
    Introduza2 txtNConta = new Introduza2("ex: 3456789");

    //formação académica
    Escolha jcbEscolaridade = new Escolha(new String[]{"Ensino Primário", "Ensino Básico", "Ensino Médio", "Ensino Técnico Médio", "Ensino Superior"});/*Configuracoes.escolaridades*/
    Introduza1 txtCurso = new Introduza1("ex: Informática");
    Introduza1 txtInstituicao = new Introduza1("ex: Uiversidade Eduardo Mondlane");

    //construtores
    public Cad3() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, formatarGeral());
        this.add(BorderLayout.SOUTH, formatarRodape());

    }

    public Painel formatarRodape() {
        Painel a = new Painel();
        a.setLayout(new MigLayout("align right"));
        Botao3 btnVoltar = new Botao3("Voltar");
        btnVoltar.setAlignmentX(RIGHT_ALIGNMENT);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //chamar tela2
                Cad.irParaTela2();
            }
        });

        Botao3 btnSalvar = new Botao3("Salvar");
        btnSalvar.setAlignmentX(RIGHT_ALIGNMENT);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                //identificar se é modificar ou salvar pela primeira vez
                //salvar caso seja salvar
                //modificar caso seja modificar
                try {
                    if (!Cad.recolherDados().getNome().equalsIgnoreCase("")) {
                        if (funcionarios.salvar(Cad.recolherDados())) {
                            JOptionPane.showMessageDialog(null, "Sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Preencha os dados obrigatórios");
                    }
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Upp's!! ocorreu algum erro!");
                }
            }
        });
        a.add(btnVoltar);
        a.add(btnSalvar);
        return a;
    }

    public Component formatarGeral() {
        Painel a = new Painel();
        Painel b = new Painel();
        b.setLayout(new GridLayout(3, 1));
        b.add(formatarBase1());
        b.add(formatarBase2());
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.CENTER, b);
        a.add(BorderLayout.WEST, new Painel());
        return new Rolagem(new Rolagem(a), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public Painel formatarBase1() {
        Painel a = new Painel();
        Painel2 div = new Painel2();
        a.setLayout(new BorderLayout());
        div.setPreferredSize(new Dimension(2, 2));
        a.add(BorderLayout.NORTH, div);

        //para adicionar os labels da exibição da informação
        Painel base = new Painel();
        Painel baseInfo1 = new Painel();
        Painel baseInfo2 = new Painel();
        base.setLayout(new GridLayout(1, 2));
        base.add(baseInfo1);
        base.add(baseInfo2);

        //baseInfo1
        baseInfo1.setLayout(new MigLayout("align center, wrap 1"));
        baseInfo1.add(new Mostre5("Numero de B.I"));
        baseInfo1.add(new Cad1.A().arranjar(txtBi, true));
        baseInfo1.add(new Mostre5("  "));
        baseInfo1.add(new Mostre5("Número de NUIT"));
        baseInfo1.add(new Cad1.A().arranjar(txtNuit, false));

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Número da conta"));
        baseInfo2.add(new Cad1.A().arranjar(txtNConta, false));
        baseInfo2.add(new Mostre5("  "));
        baseInfo2.add(new Mostre5("Banco                  "));
        baseInfo2.add(new Cad1.A().arranjar(txtBanco, false));

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("OUTRAS", "INFORMAÇÕES", ""));
        juncao.add(BorderLayout.CENTER, base);

        a.add(BorderLayout.CENTER, juncao);
        return a;
    }

    public Painel formatarBase2() {
        Painel a = new Painel();
        Painel2 div = new Painel2();
        a.setLayout(new BorderLayout());
        div.setPreferredSize(new Dimension(2, 2));
        a.add(BorderLayout.NORTH, div);

        //para adicionar os labels da exibição da informação
        Painel base = new Painel();
        Painel baseInfo1 = new Painel();
        Painel baseInfo2 = new Painel();
        base.setLayout(new GridLayout(1, 2));
        base.add(baseInfo1);
        base.add(baseInfo2);

        //baseInfo1
        baseInfo1.setLayout(new MigLayout("align center, wrap 1"));
        baseInfo1.add(new Mostre5("Escolaridade"));
        baseInfo1.add(new Cad1.A().arranjar(jcbEscolaridade, false));
        baseInfo1.add(new Mostre5("  "));
        baseInfo1.add(new Mostre5("Curso"));
        baseInfo1.add(new Cad1.A().arranjar(txtCurso, false));

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Intituição"));
        baseInfo2.add(new Cad1.A().arranjar(txtInstituicao, false));

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("INFORMAÇÀO", "ACADÉMICA", ""));
        juncao.add(BorderLayout.CENTER, base);

        a.add(BorderLayout.CENTER, juncao);
        return a;
    }

}
