/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.confiuracoes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import modelo.config.ConfigCargo;
import modelo.config.ConfigSubsidio;
import visao.Home;
import visao.Home1;
import visao.cadastro.Cad3;
import visao.componentes.Cor;
import visao.componentes.Escolha;
import visao.componentes.Introduza1;
import visao.componentes.Introduza2;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Painel3;

/**
 *
 * @author 50enta
 */
public class Subsidios extends Painel3 {

    //atributos
    Escolha jcbSubsidiosDisponiveis = new Escolha(Cad3.subsidios.getSubsidios().toArray()); //subsidios disponives, serão puchados da base de dados
    Introduza1 txtNomeNovoSubsidio = new Introduza1("ex: Subs Alimentação");
    Introduza2 txtValorNovoSubsidio = new Introduza2("ex: 23000");
    Categorias.MostreVerde lblValorSubsidio = new Categorias.MostreVerde(Double.toString(((ConfigSubsidio) jcbSubsidiosDisponiveis.getSelectedItem()).getValor()));

    Escolha jcbCargosDisponiveis = new Escolha(Cad3.cargos.getCargos().toArray());
    Introduza1 txtNovoCargo = new Introduza1("ex: Contabilista");

    public Subsidios() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarGeral());
    }

    public Painel3 formatarCabecalho() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.LINE_AXIS));
        Mostre lblVoltar = new Mostre();
        lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
        Mostre2 lb = new Mostre2("Subsídios e cargos");
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
        Painel3 b = new Painel3();
//        b.add(new MostreVerde("Salário Base   "));
        b.add(lblValorSubsidio);
        lblValorSubsidio.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 24));
//        b.add(new MostreVerde("               "));
        a.add(b);
        Painel3 c5 = new Painel3();
//        c5.add(new MostreVerde("Disponíveis     "));
        c5.add(jcbSubsidiosDisponiveis);
        jcbSubsidiosDisponiveis.setPreferredSize(new Dimension(210, 25));
        jcbSubsidiosDisponiveis.setRequestFocusEnabled(false);
        jcbSubsidiosDisponiveis.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                lblValorSubsidio.setText(Double.toString(((ConfigSubsidio) jcbSubsidiosDisponiveis.getSelectedItem()).getValor()));
            }
        });

        a.add(c5);
        Painel3 c = new Painel3();
        c.add(new MostreVerde("Novo subsídio"));
        c.add(txtNomeNovoSubsidio);
        a.add(c);
        Painel3 c1 = new Painel3();
        c1.add(new MostreVerde("Valor                  "));
        c1.add(txtValorNovoSubsidio);
        a.add(c1);
        a.add(new Painel3());
        a.add(formatabarBotoes());

        //cargos
        a.add(new Painel3());
        a.add(new Painel3());
        a.add(new Painel3());
        a.add(new Painel3());
        Painel3 cf = new Painel3();
        MostreVerde carg = new MostreVerde("Cargos (funções)");
        cf.add(carg);
        carg.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 22));
        a.add(cf);
        Painel3 g = new Painel3();
        g.add(jcbCargosDisponiveis);
        jcbCargosDisponiveis.setPreferredSize(new Dimension(210, 25));
        jcbCargosDisponiveis.setRequestFocusEnabled(false);
        a.add(g);
        Painel3 cv = new Painel3();
        cv.add(new MostreVerde("Novo            "));
        cv.add(txtNovoCargo);
        a.add(cv);
        a.add(new Painel3());
        a.add(formatabarBotoesCargos());
        a.add(new Painel3());

        return a;
    }

    public Painel3 formatabarBotoes() {
        Painel3 a = new Painel3();

        Painel3 pnlbot = new Painel3();
        pnlbot.setBorder(new EtchedBorder(4, Cor.BRANCO, Cor.BRANCO));
        pnlbot.add(new MostreVerde("Adicionar"));
        pnlbot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ConfigSubsidio novoSub = new ConfigSubsidio();
                novoSub.setActivo(true);
                try {
                    novoSub.setValor(Double.parseDouble((txtValorNovoSubsidio.getText().equalsIgnoreCase("ex: 23000")) ? "0" : txtValorNovoSubsidio.getText()));
                } catch (NumberFormatException f) {

                }
                novoSub.setNome((txtNomeNovoSubsidio.getText().equalsIgnoreCase("ex: Subs Alimentação")) ? null : txtNomeNovoSubsidio.getText());
                if (novoSub.getNome() != null && novoSub.getValor() > 0) {
                    JOptionPane.showMessageDialog(null, (Cad3.subsidios.salvar(novoSub)) ? "Sucesso!" : "Erro");
                    limparCampos();
                    jcbSubsidiosDisponiveis.setModel(new DefaultComboBoxModel(Cad3.subsidios.getSubsidios()));

                }

            }

        });
        Mostre lblExcluir = new Mostre("desactivar");
        lblExcluir.setForeground(Cor.BRANCO);
        lblExcluir.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 12));
        lblExcluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                JOptionPane.showMessageDialog(null, (Cad3.subsidios.desactivar(jcbSubsidiosDisponiveis.getSelectedItem())) ? "Sucesso!" : "Erro");
                jcbSubsidiosDisponiveis.setModel(new DefaultComboBoxModel(Cad3.subsidios.getSubsidios()));

            }

        });
        a.add(new Painel3());
        a.add(pnlbot);
        a.add(lblExcluir);
        return a;
    }

    public Painel3 formatabarBotoesCargos() {
        Painel3 a = new Painel3();

        Painel3 pnlbot = new Painel3();
        pnlbot.setBorder(new EtchedBorder(4, Cor.BRANCO, Cor.BRANCO));
        pnlbot.add(new MostreVerde("Adicionar"));
        pnlbot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ConfigCargo novoCargo = new ConfigCargo();
                novoCargo.setActivo(true);
                novoCargo.setNome((txtNovoCargo.getText().equalsIgnoreCase("ex: Contabilista")) ? null : txtNovoCargo.getText());
                if (novoCargo.getNome() != null) {
                    JOptionPane.showMessageDialog(null, (Cad3.cargos.salvar(novoCargo)) ? "Sucesso!" : "Erro");
                    jcbCargosDisponiveis.setModel(new DefaultComboBoxModel(Cad3.cargos.getCargos()));
                    limparCampos();

                }
            }

        });
        Mostre lblExcluir = new Mostre("desactivar");
        lblExcluir.setForeground(Cor.BRANCO);
        lblExcluir.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 12));
        lblExcluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int i = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                if (i == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, (Cad3.cargos.desactivar(jcbCargosDisponiveis.getSelectedItem())) ? "Sucesso!" : "Erro");
                }
                jcbCargosDisponiveis.setModel(new DefaultComboBoxModel(Cad3.cargos.getCargos()));

            }

        });
        a.add(new Painel3());
        a.add(pnlbot);
        a.add(lblExcluir);
        return a;
    }

    public void limparCampos() {
        txtNomeNovoSubsidio.setText(txtNomeNovoSubsidio.getTexto());
        txtNovoCargo.setText(txtNovoCargo.getTexto());
        txtValorNovoSubsidio.setText(txtValorNovoSubsidio.getTexto());
    }

    static class MostreVerde extends Mostre6 {

        public MostreVerde(String txt) {
            super(txt);
            this.setForeground(Cor.BRANCO);
            this.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 15));
        }
    }
}
