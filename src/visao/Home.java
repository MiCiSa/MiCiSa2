/*
 * Esta é a janela que irá conter a primeira pa'gina exibida no programa,
 * O Home, mais concretamente, onde por cada JPanel pressionado, exibirá a janela seguinte correspondente
 */
package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import net.miginfocom.swing.MigLayout;
import visao.componentes.Cor;
import visao.componentes.Desenho;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre3;
import visao.componentes.Painel;
import visao.componentes.Painel1;
import visao.componentes.Painel2;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Home extends Painel {

    //atributos
    Painel p1 = new Painel(); //Painel pessoas
    Painel p2 = new Painel(); //Painel Ausências
    Painel p3 = new Painel(); //Painel Férias
    Painel p4 = new Painel(); //Painel Salários
    Painel p5 = new Painel(); //Painel Estatística
    Painel p6 = new Painel(); //Painel Configurações

    Painel mae = new Painel(); //Painel que ficará no centro e conterá: norte, centro e sul

    Painel norte = new Painel(); //Painel que cuidará do cabecalho do "Home"
    Painel centro = new Painel(); //corpo do Home, onde serão adicionanos os itens p1, p2 e p3, p4, p5 e p6
    Painel sul = new Painel();//corpo do Home, onde serão adicionanos os itens p4, p5 e p6

    Painel1 baseInfo = new Painel1(); //é onde serão exiidos os paineizinhos dos resultados da pesqisa, e será adicionado ao centro de direita
    //construtor

    public Home() {
        this.setLayout(new BorderLayout());
//        this.add(BorderLayout.EAST, new Painel1());
//        this.add(BorderLayout.WEST, new Painel1());
        this.add(BorderLayout.CENTER, mae);
        this.add(BorderLayout.SOUTH, new Painel());

        //adicionando as três telas na mãe
        mae.setLayout(new GridLayout(3, 1));
        mae.add(norte);
        mae.add(centro);
        mae.add(sul);

        this.formatarCabecalho();
        this.formatarCorpo();

    }

    //outros métodos
    private void formatarCabecalho() { //métodos para o tratamento do cabeçalho, sua tela é "norte"
        norte.setLayout(new BorderLayout());

        // Painel1 esquerda = new Painel1();
        Desenho esquerda = new Desenho();
        Painel1 direita = new Painel1();
        Painel1 a = new Painel1();//para adicionar os paineis esquerda e direita

        //esquerda
//        esquerda.setLayout(new BorderLayout());
//         Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/micisa2.png"));
        Mostre logo = new Mostre();
        logo.setIcon(new ImageIcon(getClass().getResource("imagens/micisa2.png")));
//        baseInfo.add(new JLabel(logo));
        baseInfo.setBackground(Color.red);
        baseInfo.setLayout(new BorderLayout());
        Painel1 f = new Painel1();
        f.add(logo);
        f.setPreferredSize(new Dimension(200, 200));
        f.setBackground(Cor.AZUL);
        baseInfo.add(BorderLayout.SOUTH, f);

        //direita
        direita.setLayout(new BorderLayout());

        Painel1 st = new Painel1();
        st.setLayout(new MigLayout("align center"));
        ImageIcon im = new ImageIcon(getClass().getResource("imagens/pesquisaP.png"));
//        st.add(new JLabel(im));
        st.add(logo);
        direita.add(BorderLayout.CENTER, baseInfo);
        direita.add(BorderLayout.SOUTH, st);

        a.setLayout(new GridLayout(1, 2));
        a.add(esquerda);
        a.add(direita);

        Painel2 div = new Painel2();
        div.setLayout(new GridLayout(1, 1));
        div.add(new Painel2());

        div.setPreferredSize(new Dimension(4, 4));
        norte.add(BorderLayout.SOUTH, div);
        norte.add(BorderLayout.WEST, new Painel1());
        norte.add(BorderLayout.EAST, new Painel1());
        norte.add(BorderLayout.CENTER, a);
    }

    private void formatarCorpo() { //método para a formatação do corpo, seus paineis são: "centro e sul"
        //adicionando p1, p2, p3 à tela centro
        centro.setLayout(new GridLayout(1, 3, 4, 4));
        centro.add(p1);
        centro.add(p2);
        centro.add(p3);
        this.formatarP1();
        this.formatarP2();
        this.formatarP3();

        //adicionando p4, p5, p6 à tela sul
        sul.setLayout(new GridLayout(1, 3, 4, 4));
        sul.add(p4);
        sul.add(p5);
        sul.add(p6);
        this.formatarP4();
        this.formatarP5();
        this.formatarP6();
    }

    //Métodos para formatação das telas p1 à p6
    private void formatarP1() {

        ImageIcon pessoas = new ImageIcon(getClass().getResource("imagens/pessoasG.png")); //icons do painel
        Mostre lbl1 = new Mostre(); //label para o icon
        lbl1.setIcon(pessoas); //adicionando o icon
        Mostre2 lbl2 = new Mostre2("Funcionários"); //label to titulo 1
        Mostre3 lbl3 = new Mostre3("Iniciar Processo, Visualizar perfil, ver... "); //label do titulo 2

        Painel c = new Painel();
        Painel d = new Painel();

        d.setPreferredSize(new Dimension(312, 15)); //para o icon não colar a borda superior do p1
        p1.add(d);
        Painel ic = new Painel();
        ic.setPreferredSize(new Dimension(312, 72)); //para o icon não colar a borda superior do p1
        ic.add(lbl1);
        p1.add(ic);
        c.setPreferredSize(new Dimension(312, 10));
        p1.add(c);
        Painel a1 = new Painel();
        a1.setPreferredSize(new Dimension(312, 35));
        a1.add(lbl2);
        p1.add(a1);
        Painel a2 = new Painel();
        a2.setPreferredSize(new Dimension(312, 20));
        a2.add(lbl3);
        p1.add(a2);

        //evento do p1
        p1.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent me) {
                p1.setBorder(new EtchedBorder(Cor.VERDE, Cor.VERDE));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                p1.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                JanelaPrincipal.mudarParaHome1();
                Home1.irParaFuncionarios(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

        });
    }

    private void formatarP2() {

        ImageIcon pessoas = new ImageIcon(getClass().getResource("imagens/ausencasG.png")); //icons do painel
        Mostre lbl1 = new Mostre(); //label para o icon
        lbl1.setIcon(pessoas); //adicionando o icon
        Mostre2 lbl2 = new Mostre2("Ausências"); //label to titulo 1
        Mostre3 lbl3 = new Mostre3("Controle de ausenças, assiduidade... "); //label do titulo 2

        Painel c = new Painel();
        Painel d = new Painel();

        d.setPreferredSize(new Dimension(312, 15)); //para o icon não colar a borda superior do p1
        p2.add(d);
        Painel ic = new Painel();
        ic.setPreferredSize(new Dimension(312, 72)); //para o icon não colar a borda superior do p1
        ic.add(lbl1);
        p2.add(ic);
        c.setPreferredSize(new Dimension(312, 10));
        p2.add(c);
        Painel a1 = new Painel();
        a1.setPreferredSize(new Dimension(312, 35));
        a1.add(lbl2);
        p2.add(a1);
        Painel a2 = new Painel();
        a2.setPreferredSize(new Dimension(312, 20));
        a2.add(lbl3);
        p2.add(a2);

        //evento do p2
        p2.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent me) {
                p2.setBorder(new EtchedBorder(Cor.VERDE, Cor.VERDE));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                p2.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                JanelaPrincipal.mudarParaHome1();
                Home1.irParaAusencias(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

        });
    }

    private void formatarP3() {

        ImageIcon pessoas = new ImageIcon(getClass().getResource("imagens/feriasG.png")); //icons do painel
        Mostre lbl1 = new Mostre(); //label para o icon
        lbl1.setIcon(pessoas); //adicionando o icon
        Mostre2 lbl2 = new Mostre2("Férias"); //label to titulo 1
        Mostre3 lbl3 = new Mostre3("Iniciar férias, visualizar calendário de férias..."); //label do titulo 2

        Painel c = new Painel();
        Painel d = new Painel();

        d.setPreferredSize(new Dimension(312, 15)); //para o icon não colar a borda superior do p1
        p3.add(d);
        Painel ic = new Painel();
        ic.setPreferredSize(new Dimension(312, 72)); //para o icon não colar a borda superior do p1
        ic.add(lbl1);
        p3.add(ic);
        c.setPreferredSize(new Dimension(312, 10));
        p3.add(c);
        Painel a1 = new Painel();
        a1.setPreferredSize(new Dimension(312, 35));
        a1.add(lbl2);
        p3.add(a1);
        Painel a2 = new Painel();
        a2.setPreferredSize(new Dimension(312, 20));
        a2.add(lbl3);
        p3.add(a2);

        //evento do p3
        p3.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent me) {
                p3.setBorder(new EtchedBorder(Cor.VERDE, Cor.VERDE));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                p3.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                JanelaPrincipal.mudarParaHome1();
                Home1.irParaFerias(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

        });
    }

    private void formatarP4() {

        ImageIcon pessoas = new ImageIcon(getClass().getResource("imagens/salario1G.png")); //icons do painel
        Mostre lbl1 = new Mostre(); //label para o icon
        lbl1.setIcon(pessoas); //adicionando o icon
        Mostre2 lbl2 = new Mostre2("Salários"); //label to titulo 1
        Mostre3 lbl3 = new Mostre3("Gerar folha de salário, ver tabela salarial..."); //label do titulo 2

        Painel c = new Painel();
        Painel d = new Painel();

        d.setPreferredSize(new Dimension(312, 15)); //para o icon não colar a borda superior do p1
        p4.add(d);
        Painel ic = new Painel();
        ic.setPreferredSize(new Dimension(312, 72)); //para o icon não colar a borda superior do p1
        ic.add(lbl1);
        p4.add(ic);
        c.setPreferredSize(new Dimension(312, 10));
        p4.add(c);
        Painel a1 = new Painel();
        a1.setPreferredSize(new Dimension(312, 35));
        a1.add(lbl2);
        p4.add(a1);
        Painel a2 = new Painel();
        a2.setPreferredSize(new Dimension(312, 20));
        a2.add(lbl3);
        p4.add(a2);

        //evento do p4
        p4.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent me) {
                p4.setBorder(new EtchedBorder(Cor.VERDE, Cor.VERDE));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                p4.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                JanelaPrincipal.mudarParaHome1();
                Home1.irParaSalarios(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

        });
    }

    private void formatarP5() {

        ImageIcon pessoas = new ImageIcon(getClass().getResource("imagens/estatisticaG.png")); //icons do painel
        Mostre lbl1 = new Mostre(); //label para o icon
        lbl1.setIcon(pessoas); //adicionando o icon
        Mostre2 lbl2 = new Mostre2("Estatística"); //label to titulo 1
        Mostre3 lbl3 = new Mostre3("Análise estatística dos custos de Recursos..."); //label do titulo 2

        Painel c = new Painel();
        Painel d = new Painel();

        d.setPreferredSize(new Dimension(312, 15)); //para o icon não colar a borda superior do p1
        p5.add(d);
        Painel ic = new Painel();
        ic.setPreferredSize(new Dimension(312, 72)); //para o icon não colar a borda superior do p1
        ic.add(lbl1);
        p5.add(ic);
        c.setPreferredSize(new Dimension(312, 10));
        p5.add(c);
        Painel a1 = new Painel();
        a1.setPreferredSize(new Dimension(312, 35));
        a1.add(lbl2);
        p5.add(a1);
        Painel a2 = new Painel();
        a2.setPreferredSize(new Dimension(312, 20));
        a2.add(lbl3);
        p5.add(a2);

        //evento do p5
        p5.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent me) {
                p5.setBorder(new EtchedBorder(Cor.VERDE, Cor.VERDE));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                p5.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                JanelaPrincipal.mudarParaHome1();
                Home1.irParaEstatistica(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

        });
    }

    private void formatarP6() {
        ImageIcon pessoas = new ImageIcon(getClass().getResource("imagens/configuracoesG.png")); //icons do painel
        Mostre lbl1 = new Mostre(); //label para o icon
        lbl1.setIcon(pessoas); //adicionando o icon
        Mostre2 lbl2 = new Mostre2("Configurações"); //label to titulo 1
        Mostre3 lbl3 = new Mostre3("Configurações gerais do software.."); //label do titulo 2

        Painel c = new Painel();
        Painel d = new Painel();

        d.setPreferredSize(new Dimension(312, 15)); //para o icon não colar a borda superior do p1
        p6.add(d);
        Painel ic = new Painel();
        ic.setPreferredSize(new Dimension(312, 72)); //para o icon não colar a borda superior do p1
        ic.add(lbl1);
        p6.add(ic);
        c.setPreferredSize(new Dimension(312, 10));
        p6.add(c);
        Painel a1 = new Painel();
        a1.setPreferredSize(new Dimension(312, 35));
        a1.add(lbl2);
        p6.add(a1);
        Painel a2 = new Painel();
        a2.setPreferredSize(new Dimension(312, 20));
        a2.add(lbl3);
        p6.add(a2);

        //evento do p6
        p6.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent me) {
                p6.setBorder(new EtchedBorder(Cor.VERDE, Cor.VERDE));

            }

            @Override
            public void mouseExited(MouseEvent me) {
                p6.setBorder(null);

            }

            @Override
            public void mouseClicked(MouseEvent me) {
                JanelaPrincipal.mudarParaHome1();
                Home1.irParaFuncionarios(false);
                Home1.irParaConfiguracoes(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

        });
    }

}
