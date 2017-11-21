/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.cadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.config.ConfigCategoria;
import modelo.config.ConfigSubsidio;
import net.miginfocom.swing.MigLayout;
import visao.ControleAcessos;
import static visao.Home1_.Home1Funcionarios.formatarSubtitulo;
import visao.componentes.Botao3;
import visao.componentes.Checagem;
import visao.componentes.Escolha;
import visao.componentes.EscolhaData;
import visao.componentes.Fonte;
import visao.componentes.Introduza;
import visao.componentes.Introduza1;
import visao.componentes.Mostre;
import visao.componentes.Mostre5;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Painel2;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Cad1 extends Painel {

//atributos 
    String caminhoFoto = ControleAcessos.CAMINHO_FOTO_PADRAO;
//    String caminhoFoto = new Home().getClass().getResource("imagens/fotoPadrao.png");
    public Mostre lblFoto = new Mostre();
    public Mostre6 lblCode = new Mostre6("0 "); //para mostrar o código
    public Introduza1 txtNome = new Introduza1("ex: Samira Flávia");
    public Introduza txtEmail = new Introduza("ex: Samira@gmail.com");
    public Escolha jcbCargo = new Escolha(Cad3.cargos.getCargos().toArray());
    public Escolha jcbDept = new Escolha(new String[]{"Geral"});
    public Escolha jcbSupervisor = new Escolha(Cad3.funcionarios.getFuncionario().toArray());

    public EscolhaData dtDataAdmissao = new EscolhaData();

    public ArrayList<Checagem> subsudiosDisponiveis = new ArrayList<>(); //por rever
    public ArrayList<Mostre6> lblSubsidios = new ArrayList<>(); //por rever

    public Escolha jcbCategoria = new Escolha(Cad3.categorias.getCategorias().toArray()); //esperando pela inicializacao de banco de dados
    public Mostre6 lblSalBase = new Mostre6(Double.toString(((ConfigCategoria) jcbCategoria.getSelectedItem()).getValor()));

    //construtores
    public Cad1() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, formatarGeral());
        this.add(BorderLayout.SOUTH, formatarRodape());

    }

    public Painel formatarRodape() {
        Painel a = new Painel();
        a.setLayout(new MigLayout("align right"));
        Botao3 btnContinuar = new Botao3("Continuar");
        btnContinuar.setAlignmentX(RIGHT_ALIGNMENT);
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //chamar tela2
                Cad.irParaTela2();
            }
        });
        a.add(btnContinuar);
        return a;
    }

    public Component formatarGeral() {
        Painel a = new Painel();
        Painel b = new Painel();
        b.setLayout(new GridLayout(3, 1));
        b.add(formatarBase1());
        b.add(formatarBase2());
        b.add(formatarBase3());
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.CENTER, b);
        a.add(BorderLayout.WEST, new Painel());
        return new Rolagem(new Rolagem(a), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    /**
     * Será mais ou menos o cabeçalho, irá conter os dados básicos- incluindo a
     * foto
     *
     * @return
     */
    public Painel formatarBase1() {
        Painel a = new Painel();
        Painel2 div = new Painel2();
        a.setLayout(new BorderLayout());
        div.setPreferredSize(new Dimension(2, 2));
        a.add(BorderLayout.NORTH, div);

        Painel pnlFoto = new Painel();
        pnlFoto.setBorder(new TitledBorder("Escolher foto"));
        pnlFoto.setLayout(new BorderLayout());
//        Image img = Toolkit.getDefaultToolkit().getImage(new Home().getClass().getResource("imagens/fotoPadrao.png"));
        Image img = Toolkit.getDefaultToolkit().getImage(caminhoFoto);

        lblFoto.setIcon(new ImageIcon(img.getScaledInstance(104, 112, Image.SCALE_DEFAULT)));
        pnlFoto.add(BorderLayout.CENTER, lblFoto);

        lblFoto.addMouseListener(new MouseAdapter() {
            //metodo para buscar foto
            public String escolherImagem() { //retorna o caminho
                JFileChooser escolher = new JFileChooser();
                escolher.setFileFilter(new FileNameExtensionFilter("Image files", "bmp", "png", "jpg"));
                int op = escolher.showOpenDialog(null);

                if (op == JFileChooser.CANCEL_OPTION) {
                    return caminhoFoto; //continua a foto actual
                } else {
                    return escolher.getSelectedFile().getPath(); //o caminho do ficheiro
                }

            }

            @Override
            public void mouseClicked(MouseEvent me) {

                caminhoFoto = escolherImagem();
                Image img = Toolkit.getDefaultToolkit().getImage(caminhoFoto);
                lblFoto.setIcon(new ImageIcon(img.getScaledInstance(104, 112, Image.SCALE_DEFAULT)));

            }

        });
        Painel esquerda = new Painel();
        esquerda.setLayout(new BorderLayout());

        esquerda.add(BorderLayout.WEST, new Painel());
        esquerda.add(BorderLayout.EAST, new Painel());
        esquerda.add(BorderLayout.CENTER, pnlFoto);
        esquerda.add(BorderLayout.SOUTH, new Painel());
        esquerda.add(BorderLayout.NORTH, new Painel());

        //para adicionar os labels da exibição da informação
        Painel base = new Painel();
        Painel baseInfo1 = new Painel();
        Painel baseInfo2 = new Painel();
        base.setLayout(new GridLayout(1, 2));
        base.add(baseInfo1);
        base.add(baseInfo2);

        //baseInfo1
        baseInfo1.setLayout(new MigLayout("align center, wrap 1"));
        baseInfo1.add(new Mostre5("Nome completo"));
        baseInfo1.add(new A().arranjar(txtNome, true));
        baseInfo1.add(new Mostre("  "));
        baseInfo1.add(new Mostre5("E-mail"));
        baseInfo1.add(new A().arranjar(txtEmail, false));

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Cargo"));
        baseInfo2.add(new A().arranjar(jcbCargo, true));
        baseInfo2.add(new Mostre("  "));
        baseInfo2.add(new Mostre5("Supervisor"));
        baseInfo2.add(new A().arranjar(jcbSupervisor, false));

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, pnlFoto);
        juncao.add(BorderLayout.CENTER, base);

        a.add(BorderLayout.CENTER, juncao);
        return a;
    }

    public void colocarFoto(String caminho) {
        this.caminhoFoto = caminho;
        //Image img = Toolkit.getDefaultToolkit().getImage(new Home().getClass().getResource("imagens/fotoPadrao.png"));
        Image img = Toolkit.getDefaultToolkit().getImage(caminhoFoto);
        lblFoto.setIcon(new ImageIcon(img.getScaledInstance(104, 112, Image.SCALE_DEFAULT)));

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
        baseInfo1.add(new Mostre5("Departamento"));
        baseInfo1.add(new A().arranjar(jcbDept, false));
        baseInfo1.add(new Mostre("  "));
        baseInfo1.add(new Mostre5("Data de admissão"));
        baseInfo1.add(new A().arranjar(dtDataAdmissao, false));
//        baseInfo1.add(new Mostre("  "));
//        baseInfo1.add(new Mostre5("Sexo"));
//        baseInfo1.add(lblSexo);

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Salário Base "));
        baseInfo2.add(new A().arranjar(lblSalBase, false));
        baseInfo2.add(new Mostre("  "));
        baseInfo2.add(new Mostre("  "));
        baseInfo2.add(new Mostre5("Categoria"));
        baseInfo2.add(new A().arranjar(jcbCategoria, true));
        jcbCategoria.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String sal = Double.toString(((ConfigCategoria) jcbCategoria.getSelectedItem()).getValor());
                lblSalBase.setText(sal);
            }

        });
//        baseInfo2.add(new Mostre("  "));
//        baseInfo2.add(new Mostre5("e de"));
//        baseInfo2.add(lblNomePai);

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("   CATEGORIA  ", "E", "SALÁRIOS"));
        juncao.add(BorderLayout.CENTER, base);

        a.add(BorderLayout.CENTER, juncao);
        return a;
    }

    public Painel formatarBase3() {
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

        this.subsidios();

        //baseInfo1
        baseInfo1.setLayout(new MigLayout("align center, wrap 1"));
        int h = 0;
        for (Checagem che : subsudiosDisponiveis) {
            baseInfo1.add(che);
        }

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        for (Mostre6 lb : lblSubsidios) {
            baseInfo2.add(new A().arranjar(lb, false));
        }

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("", "    SUBSÍDIOS    ", ""));
        juncao.add(BorderLayout.CENTER, base);

        a.add(BorderLayout.CENTER, juncao);
        return a;
    }

    public void subsidios() {

        for (ConfigSubsidio sub : Cad3.subsidios.getSubsidios()) {
            Checagem vc = new Checagem(sub.getNome());
            vc.setRequestFocusEnabled(false);
            Mostre6 ln = new Mostre6("0.0");
            this.lblSubsidios.add(ln);
            this.subsudiosDisponiveis.add(vc);
            vc.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    if (vc.isSelected()) {
                        ConfigSubsidio sub = Cad3.subsidios.pesquisar(vc.getText());
                        String k = Double.toString((sub == null) ? 0 : sub.getValor());
                        ln.setText(k);
                    } else {
                        ln.setText("0.0");
                    }
                }
            });
        }

    }

    public static class A {

        public Painel arranjar(Component cmp, boolean obrigatorio) {
            Painel a = new Painel();
            a.add(new Mostre("    "));
            a.add(cmp);
            if (obrigatorio) {
                Mostre lbl = new Mostre("*");
                lbl.setForeground(Color.red);
                lbl.setFont(Fonte.CALIBRI_SUBTITULO);
                a.add(lbl);
            }
            return a;
        }
    }
}
