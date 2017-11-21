package visao.cadastro;

import java.awt.BorderLayout;
import java.awt.Component;
import static java.awt.Component.RIGHT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import static visao.Home1_.Home1Funcionarios.formatarSubtitulo;
import visao.componentes.Botao3;
import visao.componentes.Escolha;
import visao.componentes.EscolhaData;
import visao.componentes.EscolhaValor;
import visao.componentes.Introduza1;
import visao.componentes.Introduza2;
import visao.componentes.Mostre;
import visao.componentes.Mostre5;
import visao.componentes.Painel;
import visao.componentes.Painel2;
import visao.componentes.Rolagem;
import visao.componentes.limite_de_digitos;

/**
 *
 * @author 50enta
 */
public class Cad2 extends Painel {
    //atributos
    //dados pessoais

    EscolhaData dtNascimento = new EscolhaData();
    Escolha jcbNacionalidade = new Escolha(new String[]{"Moçambique", "Timor Leste", "Índia"});
    Escolha jcbSexo = new Escolha(new String[]{"Masculino", "Feminino", "Ambos"});

    Escolha jcbEstadoCivil = new Escolha(new String[]{"Solteiro", "Casado", "Maritalmente"});/*Configuracoes.estadoCivil*/

    Introduza1 txtNomeMae = new Introduza1("ex: Maria Mondlane");
    Introduza1 txtNomePai = new Introduza1("ex: Fimínio Dos Santos");

    //Contactos
    Introduza2 txtTelefone = new Introduza2("ex: 505050");
    Introduza2 txtCelular = new Introduza2("ex: 82505050");
    Introduza2 txtCelular2 = new Introduza2("ex: 82505050");
    Introduza2 txtContEmergencia = new Introduza2("ex: 820000000");
    Introduza1 txtNomeEmergencia = new Introduza1("ex: Maria Mondlane");

//    endereços
    Introduza1 txtBairro = new Introduza1("ex: Polana Caniço \"B\"");
    EscolhaValor spnQuarteirao = new EscolhaValor();
    Introduza2 txtNCasa = new Introduza2("ex: 987");
    Introduza1 txtAvRua = new Introduza1("ex: Acordos de Lusaka");

    //construtores
    public Cad2() {
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
                Cad.irParaTela1();
            }
        });

        Botao3 btnContinuar = new Botao3("Continuar");
        btnContinuar.setAlignmentX(RIGHT_ALIGNMENT);
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //chamar tela2
                Cad.irParaTela3();
            }
        });

        a.add(btnVoltar);
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
        baseInfo1.add(new Mostre5("Data de nascimento"));
        baseInfo1.add(new Cad1.A().arranjar(dtNascimento, false));
//        baseInfo1.add(new Mostre5("  "));
        baseInfo1.add(new Mostre5("Nacionalidade"));
        baseInfo1.add(new Cad1.A().arranjar(jcbNacionalidade, false));
//        baseInfo1.add(new Mostre5("  "));
        baseInfo1.add(new Mostre5("Sexo"));
        baseInfo1.add(new Cad1.A().arranjar(jcbSexo, false));

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Estado civil"));
        baseInfo2.add(new Cad1.A().arranjar(jcbEstadoCivil, false));
//        baseInfo2.add(new Mostre("  "));
        baseInfo2.add(new Mostre5("Nome da mãe"));
        baseInfo2.add(new Cad1.A().arranjar(txtNomeMae, false));
//        baseInfo2.add(new Mostre("  "));
        baseInfo2.add(new Mostre5("Nome da pai"));
        baseInfo2.add(new Cad1.A().arranjar(txtNomePai, false));

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("INFORMAÇÃO", "PESSOAL", ""));
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
        baseInfo1.add(new Mostre5("Bairro"));
        baseInfo1.add(new Cad1.A().arranjar(txtBairro, false));
        baseInfo1.add(new Mostre5("  "));
        baseInfo1.add(new Mostre5("Quarteirão                  "));
        baseInfo1.add(new Cad1.A().arranjar(spnQuarteirao, false));
//        baseInfo1.add(new Mostre("  "));
//        baseInfo1.add(new Mostre5("Sexo"));
//        baseInfo1.add(lblSexo);

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Número da casa"));
        baseInfo2.add(new Cad1.A().arranjar(txtNCasa, false));
        baseInfo2.add(new Mostre5("  "));
        baseInfo2.add(new Mostre5("Avenida/ Rua"));
        baseInfo2.add(new Cad1.A().arranjar(txtAvRua, false));
//        baseInfo2.add(new Mostre("  "));
//        baseInfo2.add(new Mostre5("e de"));
//        baseInfo2.add(lblNomePai);

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("", "  ENDEREÇOS  ", ""));
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

        //baseInfo1
        baseInfo1.setLayout(new MigLayout("align center, wrap 1"));
        baseInfo1.add(new Mostre5("Celular "));
        baseInfo1.add(baseInfo2.add(new Cad1.A().arranjar(txtCelular, false)));
        txtCelular.setDocument(new limite_de_digitos(9));
        baseInfo1.add(new Mostre("  "));
        baseInfo1.add(new Mostre5("Celular 2"));
        baseInfo1.add(baseInfo2.add(new Cad1.A().arranjar(txtCelular2, false)));
        txtCelular2.setDocument(new limite_de_digitos(9));
        baseInfo1.add(new Mostre("  "));

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Cont Emergencia"));
        baseInfo2.add(baseInfo2.add(new Cad1.A().arranjar(txtContEmergencia, false)));
//        baseInfo2.add(new Mostre5("Estado civil"));
//        baseInfo2.add(lblEstadoCivil);
//        baseInfo2.add(new Mostre("  "));
//        baseInfo2.add(new Mostre5("Filho de                  "));
//        baseInfo2.add(lblNomeMae);
//        baseInfo2.add(new Mostre("  "));
//        baseInfo2.add(new Mostre5("e de"));
//        baseInfo2.add(lblNomePai);

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("", "CONTACTOS", ""));
        juncao.add(BorderLayout.CENTER, base);

        a.add(BorderLayout.CENTER, juncao);
        return a;
    }
}
