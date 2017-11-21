package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import modelo.Funcionario;
import modelo.Status;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXCollapsiblePane;
import visao.ControleAcessos;
import visao.VerFoto;
import visao.cadastro.Cad1;
import visao.componentes.Botao;
import visao.componentes.Cor;
import visao.componentes.Fonte;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre3;
import visao.componentes.Mostre4;
import visao.componentes.Mostre5;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Painel2;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Home1Funcionarios extends Painel {

    public static Funcionario funcionario = new Funcionario();

    //atributos
    public String caminhoFoto = ControleAcessos.CAMINHO_FOTO_PADRAO;
    public Mostre lblFoto = new Mostre("");
    public Mostre2 lblNome = new Mostre2("Nome do funcionário");
    public Mostre4 lblFuncao = new Mostre4("Função");
    public Mostre4 lblDepto = new Mostre4("Geral");
    public Mostre4 lblStatus = new Mostre4("");
    public Mostre4 lblCode = new Mostre4("");

    public Mostre6 lbldtAdmissao = new Mostre6("");
    public Mostre6 lblEmail = new Mostre6("");
    Mostre6 lbldtNascimento = new Mostre6("");
    Mostre6 lblSexo = new Mostre6("");
    Mostre6 lblEstadoCivil = new Mostre6("");
    Mostre6 lblNomeMae = new Mostre6("");
    Mostre6 lblNomePai = new Mostre6("");

    ArrayList<Mostre6> lblCelular = new ArrayList();
    Mostre6 lblCidade = new Mostre6("");
    Mostre6 lblBairro = new Mostre6("");
    Mostre6 lblAvRua = new Mostre6("");
    Mostre6 lblNCasa = new Mostre6("");

    Mostre6 lblCurso = new Mostre6("");
    Mostre6 lblInstituicao = new Mostre6("");
    Mostre6 lblCategoria = new Mostre6("");
    Mostre6 lblSalBase = new Mostre6("");
    ArrayList<Object> subsidios = new ArrayList<>();

    public Painel pnlStatus = new Painel();

    public static JXCollapsiblePane colPromover = new JXCollapsiblePane(JXCollapsiblePane.Direction.DOWN);
    public static JXCollapsiblePane colStatus = new JXCollapsiblePane(JXCollapsiblePane.Direction.DOWN);
    public static JXCollapsiblePane colHistorico = new JXCollapsiblePane(JXCollapsiblePane.Direction.DOWN);

    public static Home1Promover iPromover = new Home1Promover();
    public static Home1Status iStatus = new Home1Status();
    public static Home1Historico iHistorico = new Home1Historico();

    public Home1Funcionarios() {

        //adicionando as partes
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, this.formatarCabecalho());
        this.add(BorderLayout.CENTER, this.formatarJuntarExpandivelEGeral());
        this.add(BorderLayout.WEST, new Painel());
    }

    public Painel2 formatarExpandivel() {
        Painel2 a = new Painel2();
        a.setLayout(new BorderLayout());

        //addicionando os paineis
        iHistorico.setPreferredSize(new Dimension(0, 0));

        colPromover.add(iPromover);
        colPromover.setCollapsed(true);
        colHistorico.add(iHistorico);
        colHistorico.setCollapsed(true);
        colStatus.add(iStatus);
        colStatus.setCollapsed(true);

        a.add(BorderLayout.SOUTH, colHistorico);
        a.add(BorderLayout.NORTH, colPromover);
        a.add(BorderLayout.CENTER, colStatus);

        //para deixar o deslize mais suave
        Home1Funcionarios.irParaStatus(false);
        Home1Funcionarios.irParaStatus(false);

        Home1Funcionarios.irParaPromover(false);
        Home1Funcionarios.irParaPromover(false);

        return a;
    }

    public Painel formatarJuntarExpandivelEGeral() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, formatarExpandivel());
        a.add(BorderLayout.CENTER, new Rolagem(this.formatarGeral()));
        return a;
    }

    public Painel formatarCabecalho() {
        Painel a = new Painel();
        //O titulo
        Painel titulo = new Painel();
        titulo.setLayout(new MigLayout("align right"));
        Mostre2 t = new Mostre2("Funcionários");
        t.setForeground(Cor.CINZA_ESCURO);
        titulo.add(t);
        Painel tt = new Painel();
        tt.setLayout(new BorderLayout());
        tt.add(BorderLayout.CENTER, titulo);
        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(1, 1));
        bar.setBackground(Cor.CINZA_CLARO);
        tt.add(BorderLayout.SOUTH, bar);

        MenuFuncionarios menu = new MenuFuncionarios();
        menu.setPreferredSize(new Dimension(45, 45));

        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, tt); //tt
        a.add(BorderLayout.CENTER, menu);
        return a;
    }

    //integração dos métodos que cmpõem o corpo
    public Component formatarGeral() {
        Painel geral = new Painel();
        geral.setLayout(new GridLayout(4, 1));
        geral.add(formatarBaseFoto());
        geral.add(formatarBase1());
        geral.add(formatarBase2());
        geral.add(formatarBase3());
        return new Rolagem(geral);
    }

    //o cabeçalho qu econtéma foto, nome.. esses ways
    public Painel formatarBaseFoto() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());

        Painel pnlFoto = new Painel();
        pnlFoto.setBorder(new TitledBorder(""));
        pnlFoto.setLayout(new BorderLayout());

        this.colocarFoto(caminhoFoto);

        pnlFoto.add(BorderLayout.CENTER, lblFoto);

        lblFoto.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                new VerFoto(caminhoFoto);
            }

        }
        );

        Painel esquerda = new Painel();

        esquerda.setLayout(new BorderLayout());

        esquerda.add(BorderLayout.WEST, new Painel());
        esquerda.add(BorderLayout.EAST, new Painel());
        esquerda.add(BorderLayout.CENTER, pnlFoto);

        esquerda.add(BorderLayout.SOUTH, new Painel());
        esquerda.add(BorderLayout.NORTH, new Painel());

        Painel baseInfo = new Painel();
        baseInfo.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo.add(lblNome);
        lblNome.setForeground(Cor.PRETO);
        baseInfo.add(lblFuncao);
        baseInfo.add(lblDepto);

        this.escolherCorStatus(lblStatus.getText());

        lblStatus.setForeground(Cor.BRANCO);
        pnlStatus.setPreferredSize(new Dimension(40, 6));
        baseInfo.add(pnlStatus);
        baseInfo.add(lblCode);

        Painel direita = new Painel();

        direita.setLayout(new BorderLayout());
        direita.add(BorderLayout.CENTER, baseInfo);
        direita.add(BorderLayout.WEST, new Painel());

        a.add(BorderLayout.WEST, esquerda);
        a.add(BorderLayout.CENTER, direita);
        a.add(BorderLayout.NORTH, new Painel());
        Painel o = new Painel();
        o.setPreferredSize(new Dimension(1, 30));
        a.add(BorderLayout.SOUTH, o);
        return a;
    }

    public void escolherCorStatus(String st) {
        lblStatus.setText(st);

        switch (st) {
            case Status.ACTIVO:
                pnlStatus.setBackground(Cor.AZUL);
                break;
            case Status.DEMITIDO:
                pnlStatus.setBackground(Color.RED);
                break;
            default:
                pnlStatus.setBackground(Color.orange);
                break;
        }

        pnlStatus.add(lblStatus);
        return;

    }

    public void colocarFoto(String caminho) {
        this.caminhoFoto = caminho;
        //Image img = Toolkit.getDefaultToolkit().getImage(new Home().getClass().getResource("imagens/fotoPadrao.png"));
        Image img = Toolkit.getDefaultToolkit().getImage(caminhoFoto);
        lblFoto.setIcon(new ImageIcon(img.getScaledInstance(104, 112, Image.SCALE_DEFAULT)));
        return;
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
        baseInfo1.add(new Mostre5("E-mail"));
        baseInfo1.add(new Cad1.A().arranjar(lblEmail, false));
        baseInfo1.add(new Mostre5("Data de admissão"));
        baseInfo1.add(new Cad1.A().arranjar(lbldtAdmissao, false));
        baseInfo1.add(new Mostre5("Sexo"));
        baseInfo1.add(new Cad1.A().arranjar(lblSexo, false));

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Estado civil"));
        baseInfo2.add(new Cad1.A().arranjar(lblEstadoCivil, false));
        baseInfo2.add(new Mostre5("Filho de                  "));
        baseInfo2.add(new Cad1.A().arranjar(lblNomeMae, false));
        baseInfo2.add(new Mostre5("e de"));
        baseInfo2.add(new Cad1.A().arranjar(lblNomePai, false));

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("INFORMAÇÃO", "BÁSICA", ""));
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
        for (Mostre6 cell : lblCelular) {
            baseInfo1.add(new Mostre5("Celular"));
            baseInfo1.add(new Cad1.A().arranjar(cell, false));
        }
        baseInfo1.add(new Mostre5("Cidade"));
        baseInfo1.add(new Cad1.A().arranjar(lblCidade, false));
        baseInfo1.add(new Mostre5("Bairro"));
        baseInfo1.add(new Cad1.A().arranjar(lblBairro, false));

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        baseInfo2.add(new Mostre5("Número da casa"));
        baseInfo2.add(new Cad1.A().arranjar(lblNCasa, false));
        baseInfo2.add(new Mostre5("Avenida/ Rua            "));
        baseInfo2.add(new Cad1.A().arranjar(lblAvRua, false));

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("CONTACTOS ", "E ", "ENDEREÇO"));
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

//    Mostre6 lblSalBase = new Mostre6("30.903");
//    ArrayList<Object> subsidios = new ArrayList<>();
        //baseInfo1
        baseInfo1.setLayout(new MigLayout("align center, wrap 1"));
        baseInfo1.add(new Mostre5("Curso"));
        baseInfo1.add(new Cad1.A().arranjar(lblCurso, false));
        baseInfo1.add(new Mostre5("Categoria"));
        baseInfo1.add(new Cad1.A().arranjar(lblCategoria, false));
        baseInfo1.add(new Mostre5("Salário Base"));
        baseInfo1.add(new Cad1.A().arranjar(lblSalBase, false));

        //baseInfo2
        baseInfo2.setLayout(new MigLayout("align left, wrap 1"));
        for (Object subs : subsidios) {
            baseInfo2.add(new Mostre5("nome do subsidio"));
            baseInfo2.add(new Mostre6("0.0"));
            baseInfo2.add(new Mostre("  "));
        }

        Painel juncao = new Painel();
        juncao.setLayout(new BorderLayout());
        juncao.add(BorderLayout.WEST, formatarSubtitulo("SALÁRIO ", "E", "SUBSÍDIOS"));
        juncao.add(BorderLayout.CENTER, base);

        a.add(BorderLayout.CENTER, juncao);
        return a;
    }

    //formatação do subtitulo
    public static Painel formatarSubtitulo(String a, String b, String c) {
        //Para adicionar os labels correspondentes ao t'titulo
        Painel subTitulo = new Painel();
        subTitulo.setLayout(new BoxLayout(subTitulo, BoxLayout.Y_AXIS));
        subTitulo.add(new Painel());
        // subTitulo.add(new Painel());
        Mostre3 txt = new Mostre3(a);
        Mostre3 txt1 = new Mostre3(b);
        Mostre3 txt2 = new Mostre3(c);
        txt.setFont(Fonte.CALIBRI_SUBTITULO);
        txt1.setFont(Fonte.CALIBRI_SUBTITULO);
        txt2.setFont(Fonte.CALIBRI_SUBTITULO);
        txt.setForeground(Cor.VERDE);
        txt2.setForeground(Cor.VERDE);
        txt1.setForeground(Cor.VERDE);
        txt.setAlignmentX(CENTER_ALIGNMENT);
        txt1.setAlignmentX(CENTER_ALIGNMENT);
        txt2.setAlignmentX(CENTER_ALIGNMENT);

        subTitulo.add(txt);
        subTitulo.add(txt1);
        subTitulo.add(txt2);
        subTitulo.add(new Painel());
        return subTitulo;
    }

    //métodos para mudar de telas
    public static void irParaStatus(boolean contar) {
        if (contar) {
            ControleAcessos.historioPaineis.push(10);
            ControleAcessos.painelActual = 0;
        }
        Botao btn = new Botao("");
        iStatus.setPreferredSize(new Dimension(200, 200));
        btn.addActionListener(colStatus.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION));

        btn.doClick();
    }

    public static void irParaHistorico(boolean contar) {
        if (contar) {
            ControleAcessos.historioPaineis.push(11);
            ControleAcessos.painelActual = 0;
        }
        Botao btn = new Botao("");
        iHistorico.setPreferredSize(new Dimension(200, 260));
        btn.addActionListener(colHistorico.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION));

        btn.doClick();
    }

    public static void irParaPromover(boolean contar) {
        if (contar) {
            ControleAcessos.historioPaineis.push(8);
            ControleAcessos.painelActual = 0;
        }
        Botao btn = new Botao("");
        iPromover.setPreferredSize(new Dimension(200, 215));
        btn.addActionListener(colPromover.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION));
        btn.doClick();
    }

    /**
     * método que preenche os campos de dados refere
     *
     * @param func
     */
    public void mostrarDados(Funcionario func) {
        this.limparCampos();
        this.funcionario = func;

        this.colocarFoto(func.getCaminhoFoto());
        this.escolherCorStatus(func.getStatus());

        iHistorico.mostrarDados(func);

        lblNome.setText(func.getNome());
        lblFuncao.setText(func.getCargo());
        lblBairro.setText(func.getBairro());
        lblFuncao.setText(func.getCargo());

        lblDepto.setText(func.getDepartamento());
        lblCode.setText(Integer.toString(func.getCodigo()));
        lbldtAdmissao.setText(func.getDataAdmissao().toString());
        lblEmail.setText(func.getEmail());
        lbldtNascimento.setText(func.getDataNascimento().toString());
        lblSexo.setText(func.getSexo());
        lblEstadoCivil.setText(func.getEstadoCivil());
        lblNomeMae.setText(func.getNomeMae());
        lblNomePai.setText(func.getNomePai());

        //lblCelular faltaa
        //
        //
        lblCidade.setText(func.getCidade());
        lblBairro.setText(func.getBairro());
        lblAvRua.setText(func.getRua());
//        lblNCasa.setText(Integer.toString(func.getNumeroCasa()));
        lblCurso.setText(func.getCurso());
        lblInstituicao.setText(func.getInstituicao());
        lblCategoria.setText(func.getCategoria().toString());
        lblCidade.setText(func.getCidade());

        //os outros paineis da dependência do perfil
        iPromover.mostrarDados(func);
        iStatus.mostrarDados(func);

    }

    /**
     * Método que limpa os campos antes de mostrar dados para um determinado
     * funcionário seleccionado
     */
    public void limparCampos() {

        //para mostrar4
        this.caminhoFoto = " ";
        this.lblNome.setText(" ");
        this.lblFuncao.setText(" ");
        this.lblDepto.setText(" ");
        this.lblStatus.setText(" ");
        this.lblCode.setText(" ");

        //para mostrar6
        this.lbldtAdmissao.setText(" ");
        this.lblEmail.setText(" ");
        this.lbldtNascimento.setText(" ");
        this.lblSexo.setText(" ");
        this.lblEstadoCivil.setText(" ");
        this.lblNomeMae.setText(" ");

        //continuando mostar6
        this.lblCidade.setText(" ");
        this.lblBairro.setText(" ");
        this.lblAvRua.setText(" ");
        this.lblNCasa.setText(" ");

        //continuando
        this.lblCurso.setText(" ");
        this.lblInstituicao.setText(" ");
        this.lblCategoria.setText(" ");
        this.lblSalBase.setText(" ");

    }

}
