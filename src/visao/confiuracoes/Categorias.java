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
import modelo.config.ConfigCategoria;
import visao.Home;
import visao.Home1;
import visao.cadastro.Cad3;
import visao.componentes.Cor;
import visao.componentes.Escolha;
import visao.componentes.Introduza;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre6;
import visao.componentes.Painel3;

/**
 *
 * @author 50enta
 */
public class Categorias extends Painel3 {
//atributos

    Escolha jcbCategoria = new Escolha(Cad3.categorias.getCategorias().toArray()); //categorias disponives, serão puchados da base de dados
    Introduza txtNovaCategoria = new Introduza("ex: Nível Superior");
    Introduza txtSalBase = new Introduza("ex: 23000");
    Escolha jcbClasse = new Escolha(new String[]{"A", "B", "C", "D"});
    MostreVerde lblSalBase = new MostreVerde("");// = new MostreVerde(Double.toString(((ConfigCategoria) jcbCategoria.getSelectedItem()).getValor()));

    public Categorias() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarGeral());
        try {
            lblSalBase = new MostreVerde(Double.toString(((ConfigCategoria) jcbCategoria.getSelectedItem()).getValor()));
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public Painel3 formatarCabecalho() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.LINE_AXIS));
        Mostre lblVoltar = new Mostre();
        lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
        Mostre2 lb = new Mostre2("Categorias");
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
        try {
            b.add(lblSalBase);
        }
        catch(NullPointerException hg
        
        
        ){
        
    }

        lblSalBase.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 24));
//        b.add(new MostreVerde("               "));
        a.add(b);
        Painel3 c5 = new Painel3();
//        c5.add(new MostreVerde("Disponíveis     "));
        c5.add(jcbCategoria);
        jcbCategoria.setRequestFocusEnabled(false);
        jcbCategoria.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                lblSalBase.setText(Double.toString(((ConfigCategoria) jcbCategoria.getSelectedItem()).getValor()));
            }
        });
        a.add(c5);
        Painel3 c = new Painel3();
        c.add(new MostreVerde("Nova categoria"));
        c.add(txtNovaCategoria);
        a.add(c);
        Painel3 c1 = new Painel3();
        c1.add(new MostreVerde("Salário base      "));
        c1.add(txtSalBase);
        a.add(c1);
        Painel3 c2 = new Painel3();
        c2.add(new MostreVerde("Classe      "));
        c2.add(jcbClasse);
        jcbClasse.setPreferredSize(new Dimension(50, 25));
        c2.add(new MostreVerde("        "));
        c2.add(new MostreVerde("        "));
        a.add(c2);
        a.add(new Painel3());
        a.add(new Painel3());
        a.add(formatabarBotoes());
        a.add(new Painel3());
        a.add(new Painel3());
        return a;
    }

    public Painel3 formatabarBotoes() {
        Painel3 a = new Painel3();

        Painel3 pnlbot = new Painel3();
        pnlbot.setBorder(new EtchedBorder(4, Cor.BRANCO, Cor.BRANCO));
        pnlbot.add(new MostreVerde("Actualizar"));
        pnlbot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ConfigCategoria novoSub = new ConfigCategoria();
                novoSub.setActivo(true);
                try {
                    novoSub.setValor(Double.parseDouble(txtSalBase.getText()));
                } catch (NumberFormatException h) {

                }

                novoSub.setClasse((String) jcbClasse.getSelectedItem());
                novoSub.setNome((txtNovaCategoria.getText().equalsIgnoreCase("ex: Nível Superior")) ? null : txtNovaCategoria.getText());
                if (novoSub.getNome() != null && novoSub.getValor() > 0) {
                    JOptionPane.showMessageDialog(null, (Cad3.categorias.salvar(novoSub)) ? "Sucesso!" : "Erro");
                    limparCampos();
                    jcbCategoria.setModel(new DefaultComboBoxModel(Cad3.categorias.getCategorias()));

                }
            }

        });
        Mostre lblExcluir = new Mostre("Desactivar");
        lblExcluir.setForeground(Cor.BRANCO);
        lblExcluir.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 12));
        lblExcluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int i = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                if (i == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, (Cad3.categorias.desactivar(jcbCategoria.getSelectedItem())) ? "Sucesso!" : "Erro");
                }
                jcbCategoria.setModel(new DefaultComboBoxModel(Cad3.categorias.getCategorias()));
            }

        });
        a.add(new Painel3());
        a.add(pnlbot);
        a.add(lblExcluir);
        return a;
    }

    public void limparCampos() {
        txtNovaCategoria.setText(txtNovaCategoria.getTexto());
        txtSalBase.setText(txtSalBase.getTexto());
    }

    static class MostreVerde extends Mostre6 {

        public MostreVerde(String txt) {
            super(txt);
            this.setForeground(Cor.BRANCO);
            this.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 15));
        }
    }
}
