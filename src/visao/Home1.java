package visao;

import controlo.ControloNotificacoes;
import controlo.ExibirPessoas;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EmptyStackException;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import modelo.config.ConfigNotificacoes;
import org.jdesktop.swingx.JXCollapsiblePane;
import visao.Home1_.Home1Ausencias;
import visao.Home1_.Home1Configuracoes;
import visao.Home1_.Home1Estatistica;
import visao.Home1_.Home1Ferias;
import visao.Home1_.Home1Funcionarios;
import visao.Home1_.Home1Notificacoes;
import visao.Home1_.Home1Salarios;
import visao.cadastro.Cad;
import visao.cadastro.Cad3;
import visao.componentes.Botao;
import visao.componentes.Cor;
import visao.componentes.Desenho11;
import visao.componentes.Escolha;
import visao.componentes.Fonte;
import visao.componentes.IntroduzaPesquisa;
import visao.componentes.Mostre;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Painel1;
import visao.componentes.Painel2;
import visao.componentes.Rolagem;
import visao.confiuracoes.Acessoss;
import visao.confiuracoes.Ajuda;
import visao.confiuracoes.Categorias;
import visao.confiuracoes.Sobre;
import visao.confiuracoes.Subsidios;
import visao.confiuracoes.Taxas;
import visao.confiuracoes.Usuarios;

/**
 * Painel para moldar a visão base da interface gráfica do utilizador, neste
 * painel será/ é mostrado o cabeçalho - lateral - o menú que servirá de para
 * suportar os icones para a transição entre as telas centro - onde tudo será
 * concentrado, de acordo com o atalho pressionado nomes - para exibir a lista
 * de funcionários
 */
public class Home1 extends Painel {
//Atributos

    public static Home1Funcionarios iFuncionarios = new Home1Funcionarios();
    static Home1Ausencias iAusencias = new Home1Ausencias();
    static Home1Ferias iFerias = new Home1Ferias();
    static Home1Salarios iSalarios = new Home1Salarios();
    static Home1Notificacoes iNotificacoes = new Home1Notificacoes();
    static Home1Configuracoes iConfiguracoes = new Home1Configuracoes();
    static Home1Estatistica iEstatistica = new Home1Estatistica();
    Cad iCadastro = new Cad();

    public static CardLayout cartao1 = new CardLayout();
    public static CardLayout cartao2 = new CardLayout();
    public static Painel pnlBase1 = new Painel();
    public static Painel pnlBase2 = new Painel();
    public static Painel pnlPessoas = new Painel();

    static JXCollapsiblePane col = new JXCollapsiblePane(JXCollapsiblePane.Direction.RIGHT);
    static CardLayout cartaoConfig = new CardLayout();
    static Painel baseConfig = new Painel();
    static Categorias iConfigCategorias = new Categorias();
    static Subsidios iConfigSubsidios = new Subsidios();
    static Taxas iConfigTaxas = new Taxas();
    static Usuarios iConfigUsusarios = new Usuarios();
    static Acessoss iConfigAcessos = new Acessoss();
    static Ajuda iConfigAjuda = new Ajuda();
    static Sobre iConfigSobre = new Sobre();

    IntroduzaPesquisa txtPesquisar = new IntroduzaPesquisa("    Localizar funcionário");
    Escolha jcbClassificar = new Escolha(new String[]{"Todos", "Activos", "Demitidos",});

    //construtor
    public Home1() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, formatarGeral());

    }

    public Painel formatarGeral() {
        Painel mae = new Painel();
        mae.setLayout(new BorderLayout());
        mae.add(BorderLayout.NORTH, formatarCabecalho()); //adicionando o cabeçalho

        Painel centro = new Painel();
        centro.setLayout(new BorderLayout());
        centro.add(BorderLayout.WEST, formatarMenu());
        centro.add(BorderLayout.CENTER, formatarBase1());

        mae.add(BorderLayout.CENTER, centro);
        return mae;
    }

    //formatação do cabeçalho
    private Painel formatarCabecalho() {
        Painel1 cabecalho = new Painel1();
        cabecalho.setPreferredSize(new Dimension(200, 70));
//        cabecalho.setPreferredSize(new Dimension(200, 500));
        cabecalho.setLayout(new BorderLayout());

        //barra escura no sul
        Painel2 div = new Painel2();

        div.setPreferredSize(new Dimension(3, 3));

        Desenho11 esquerda = new Desenho11();
        Painel1 direita = new Painel1();
        direita.setLayout(new GridLayout(1, 1));
        //icone estará sobre direita

        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/micisa.png"));
        Mostre lblIcon = new Mostre();
        lblIcon.setIcon(new ImageIcon(img.getScaledInstance(380, 280, Image.SCALE_DEFAULT)));

        Painel1 g = new Painel1();
        g.setLayout(new BorderLayout());
        g.add(BorderLayout.EAST, lblIcon);
        g.add(BorderLayout.CENTER, new Painel1());

//        direita.add(new Painel1());
        direita.add(g);

        esquerda.setLayout(new FlowLayout((int) LEFT_ALIGNMENT));
        Mostre lblVoltar = new Mostre(new ImageIcon(new Home().getClass().getResource("imagens/voltarP.png")));
//        Mostre lblVoltar = new Mostre(new ImageIcon(new Home().getClass().getResource("imagens/micisa.png")));
        esquerda.add(lblVoltar);
        lblVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);

                try {
                    if (!ControleAcessos.historioPaineis.isEmpty()) {
                        ControleAcessos.historioPaineis.pop();
                        switch (ControleAcessos.historioPaineis.pop()) {
                            case 0:
                                //funcionarios 
                                Home1.irParaFuncionarios(false);
                                break;
                            case 1:
                                //ausecncias -
                                Home1.irParaAusencias(false);

                                break;
                            case 2:
                                //ferias
                                Home1.irParaFerias(false);
                                break;
                            case 3:
                                //salarios
                                Home1.irParaSalarios(false);
                                break;
                            case 4:
                                //Estatistica
                                Home1.irParaEstatistica(false);
                                break;
                            case 5:
                                //Notificações
                                Home1.irParaNotificacoes(false);
                                break;
                            case 6:
                                //Configuações
                                Home1.irParaConfiguracoes(false);
                                break;
                            case 7:
                                //cadastro
                                Home1.irParaCadastro(false);
                                break;
                            case 8:
                                //promover
                                Home1Funcionarios.irParaPromover(false);
                                break;
                            case 9:
                                //Editar

                                break;
                            case 10:
                                //status
                                Home1Funcionarios.irParaStatus(false);
                                break;

                            case 11:
                                //Historico
                                Home1Funcionarios.irParaHistorico(false);
                                break;
                        }
                    } else {
                        JanelaPrincipal.mudarParaHome();
                    }
                } catch (EmptyStackException h) {

                }
            }
        });
        Painel1 esquerdaDireita = new Painel1();
//        esquerdaDireita.setLayout(new GridLayout(1, 2));
//        esquerdaDireita.add(esquerda);
//        esquerdaDireita.add(direita);
        esquerdaDireita.setLayout(new BorderLayout());
        esquerdaDireita.add(BorderLayout.CENTER,esquerda);
        esquerdaDireita.add(BorderLayout.EAST, direita);

        cabecalho.add(BorderLayout.SOUTH, div);
        cabecalho.add(BorderLayout.CENTER, esquerdaDireita);
        return cabecalho;
    }

    //formatações do menuu
    private Painel formatarMenu() {
        return new Menu();
    }

    public Component formatarPessoas() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());

        Painel c = new Painel();
        c.add(new Mostre("    "));
//        c.add(new Mostre("    "));
//        c.add(new Mostre("    "));
//        c.add(new Mostre("    "));
//        c.add(new Mostre("    "));
//        c.add(new Mostre("    "));
        c.add(new Mostre(new ImageIcon(getClass().getResource("imagens/pesquisaP.png"))));
        c.add(txtPesquisar);
        txtPesquisar.setPreferredSize(new Dimension(120, 24));

        Painel d = new Painel();
        d.add(new Mostre6("Mostrar "));
        d.add(new Mostre("   "));
        d.add(jcbClassificar);
        jcbClassificar.setFont(Fonte.TIMES_NEW_ROMAN);
        jcbClassificar.setPreferredSize(new Dimension(100, 25));
        jcbClassificar.setRequestFocusEnabled(false);

        Painel e = new Painel();
        e.setLayout(new BorderLayout());
        e.add(BorderLayout.CENTER, d);
        Painel barra = new Painel();
        barra.setBackground(Cor.CINZA_TEXTO);
        barra.setPreferredSize(new Dimension(1, 2));
        e.add(BorderLayout.SOUTH, barra);

        Painel b = new Painel();
        b.setLayout(new BorderLayout());
        b.add(BorderLayout.NORTH, c);
        b.add(BorderLayout.CENTER, e);

        pnlPessoas.setLayout(new BorderLayout());

        a.setPreferredSize(new Dimension(337, 300));
        a.add(BorderLayout.NORTH, new Rolagem(new Rolagem(b)));
        a.add(BorderLayout.CENTER, new Rolagem(pnlPessoas));
        // inicializa com os dados 
        ExibirPessoas.actualizar();
        //
        jcbClassificar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                switch ((String) jcbClassificar.getSelectedItem()) {
                    case "Todos":
                        ExibirPessoas.actualizar();
                        break;
                    case "Activos":
                        ExibirPessoas.actualizarActivos();
                        break;
                    case "Demitidos":
                        ExibirPessoas.actualizarDeimitidos();
                        break;
                }

            }
        });
        return a;
    }

    public Component formatarJuntarPessoasEBase2() {

        return new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formatarPessoas(), new Rolagem(formatarBase2()));
    }

    private Painel formatarBase1() { //conterá: pnlPessoas e pnlBase2
        Painel a = new Painel();
        a.setLayout(new BorderLayout());

        formatarExpandivel();
        col.add(baseConfig);
        col.setCollapsed(true);

        pnlBase1.setLayout(cartao1);
        pnlBase1.add(formatarJuntarPessoasEBase2(), "1");
        pnlBase1.add(iEstatistica, "2");
        pnlBase1.add(iNotificacoes, "4");
        a.add(BorderLayout.CENTER, pnlBase1);
        a.add(BorderLayout.EAST, col);

        return a;
    }

    public Painel formatarExpandivel() {

        baseConfig.setPreferredSize(new Dimension(290, 290));
        baseConfig.setLayout(cartaoConfig);
        baseConfig.add(iConfiguracoes, "7");
        baseConfig.add(iConfigCategorias, "1");
        baseConfig.add(iConfigSubsidios, "8");
        baseConfig.add(iConfigTaxas, "2");
        baseConfig.add(iConfigUsusarios, "3");
        baseConfig.add(iConfigAcessos, "4");
        baseConfig.add(iConfigAjuda, "5");
        baseConfig.add(iConfigSobre, "6");
        cartaoConfig.show(baseConfig, "7");
        return baseConfig;
    }

    public static void irParaConfigSobre() {
        cartaoConfig.show(baseConfig, "6");
    }

    public static void irParaConfigAjuda() {
        cartaoConfig.show(baseConfig, "5");
    }

    public static void irParaConfigAcessos() {
        cartaoConfig.show(baseConfig, "4");
    }

    public static void irParaConfigUsuarios() {
        cartaoConfig.show(baseConfig, "3");
    }

    public static void irParaConfigTaxas() {
        cartaoConfig.show(baseConfig, "2");
    }

    public static void irParaConfigSubsidios() {
        cartaoConfig.show(baseConfig, "8");
    }

    public static void irParaConfigCategorias() {
        cartaoConfig.show(baseConfig, "1");
    }

    public static void irParaConfiguracoesInicio() {
        cartaoConfig.show(baseConfig, "7");
    }

    private Painel formatarBase2() {
        pnlBase2.setLayout(cartao2);
        pnlBase2.add(iFuncionarios, "1");
        pnlBase2.add(iAusencias, "2");
        pnlBase2.add(iSalarios, "3");
        pnlBase2.add(iFerias, "4");
        pnlBase2.add(iNotificacoes, "5");
        pnlBase2.add(iCadastro, "6");
        return pnlBase2;
    }

//métodos para mudar entre as telas
    public static void irParaFuncionarios(boolean contar) {
//        if (ControleAcessos.usuarioActual.getPermissoes().contains(0)) {
        if (contar) {
            ControleAcessos.historioPaineis.push(0);
            ControleAcessos.painelActual = 0;
        }
        ExibirPessoas.actualizar();
        irParaBase2EPessoas();
        cartao2.show(pnlBase2, "1");
        Menu.mudarTodos();
        Menu.pnlFunc.setBackground(Cor.VERDE);
//        }
    }

    public static void irParaAusencias(boolean contar) {
//        if (ControleAcessos.usuarioActual.getPermissoes().contains(1)) {
        if (contar) {
            ControleAcessos.historioPaineis.push(1);
            ControleAcessos.painelActual = 1;
        }
        ExibirPessoas.actualizarAusencias();
        irParaBase2EPessoas();
        cartao2.show(pnlBase2, "2");
        Menu.mudarTodos();
        Menu.pnlAus.setBackground(Cor.VERDE);
//        }
    }

    public static void irParaCadastro(boolean contar) {
        if (contar) {
            ControleAcessos.historioPaineis.push(7);
            ControleAcessos.painelActual = 7;
        }
        cartao2.show(pnlBase2, "6");
    }

    public static void irParaSalarios(boolean contar) {
//        if (ControleAcessos.usuarioActual.getPermissoes().contains(2)) {
        if (contar) {
            ControleAcessos.historioPaineis.push(3);
            ControleAcessos.painelActual = 3;
        }
        ExibirPessoas.actualizarSalarios();
        irParaBase2EPessoas();
        cartao2.show(pnlBase2, "3");
        Menu.mudarTodos();
        Menu.pnlSal.setBackground(Cor.VERDE);
//        }
    }

    public static void irParaFerias(boolean contar) {
//        if (ControleAcessos.usuarioActual.getPermissoes().contains(2)) {
        if (contar) {
            ControleAcessos.historioPaineis.push(2);
            ControleAcessos.painelActual = 2;
        }
        ExibirPessoas.actualizarFerias();
        irParaBase2EPessoas();
        cartao2.show(pnlBase2, "4");
        Menu.mudarTodos();
        Menu.pnlFer.setBackground(Cor.VERDE);
//        }
    }

    public static void irParaNotificacoes(boolean contar) {
//        if (ControleAcessos.usuarioActual.getPermissoes().contains(5)) {
        if (contar) {
            ControleAcessos.historioPaineis.push(5);
            ControleAcessos.painelActual = 5;
        }
        ConfigNotificacoes.procurarNotificacoes(Cad3.funcionarios.getFuncionario());
        cartao1.show(pnlBase1, "4");
        Menu.mudarTodos();
        Menu.pnlNot.setBackground(Cor.VERDE);
//        }
    }

    public static void irParaBase2EPessoas() {
        cartao1.show(pnlBase1, "1");
    }

    public static void irParaConfiguracoes(boolean contar) {
//        if (ControleAcessos.usuarioActual.getPermissoes().contains(6)) {
        if (contar) {
            ControleAcessos.historioPaineis.push(6);
            //  ControleAcessos.painelActual = 6;
        }
        Botao btn = new Botao("");
        btn.addActionListener(col.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION));
        btn.doClick();
//        cartao1.show(pnlBase1, "3");
//        Menu.mudarTodos();
//        Menu.pnlConfig.setBackground(Cor.VERDE);
//        }
    }

    public static void irParaEstatistica(boolean contar) {
//        if (ControleAcessos.usuarioActual.getPermissoes().contains(4)) {
        if (contar) {
            ControleAcessos.historioPaineis.push(4);
            ControleAcessos.painelActual = 4;
        }
        cartao1.show(pnlBase1, "2");
        Menu.mudarTodos();
        Menu.pnlEst.setBackground(Cor.VERDE);
    }
//    }
}
