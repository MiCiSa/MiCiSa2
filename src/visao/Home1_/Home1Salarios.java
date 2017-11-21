package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.im.spi.InputMethod;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import modelo.Funcionario;
import modelo.Subsidios;
import net.miginfocom.swing.MigLayout;
import visao.componentes.Cor;
import visao.componentes.Escolha;
import visao.componentes.EscolhaAno;
import visao.componentes.EscolhaMes;
import visao.componentes.Mostre1;
import visao.componentes.Mostre2;
import visao.componentes.Mostre3;
import visao.componentes.Mostre4;
import visao.componentes.Painel;
import visao.componentes.Rolagem;
import visao.relatorios.Itext;
import visao.relatorios.ItextTodos;

public class Home1Salarios extends Painel {
//atributosa

    Funcionario funcionario = new Funcionario();
    private Mostre2 lblNome = new Mostre2("Nome do funcionário");
    private Mostre3 lblCargo = new Mostre3("Função");
    private Mostre3 lblCategoria = new Mostre3("Categoria");
    private EscolhaAno anoEmCausa = new EscolhaAno();
    private EscolhaMes mesEmCausa = new EscolhaMes();
    Mostre4 lblNrP1 = new Mostre4("0.0");
    Mostre4 lblNrP2 = new Mostre4("0.0");
    Mostre4 lblNrP3 = new Mostre4("0.0");
    Mostre4 lblNrP4 = new Mostre4("0.0");
    Mostre3 lblValorTotal = new Mostre3("0.0");
    Mostre3 lblValorSubs = new Mostre3("0.0");
    Mostre3 lblTotalSubs = new Mostre3("0.0");
    Mostre3 lblNrSalBase = new Mostre3("0.0");
    Mostre3 lblNrHorasExtras = new Mostre3("0.00");
    Mostre3 lblValorTotal1 = new Mostre3("0.0");
    Mostre1 lblTotSalLiquido = new Mostre1("0.0");
    Escolha jcbTodosSubsidios = new Escolha(new String[]{});
//construtos

    public Home1Salarios() {
        this.setLayout(new BorderLayout());
//        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, new Rolagem(new Rolagem(formatarGeral())));
    }

    public Painel formatarCabecalho() {
        Painel a = new Painel();
        //O titulo
        Painel titulo = new Painel();
        titulo.setLayout(new MigLayout("align right"));
        Mostre2 t = new Mostre2("Salário");
        t.setForeground(Cor.CINZA_ESCURO);
        titulo.add(t);
        Painel tt = new Painel();
        tt.setLayout(new BorderLayout());
        tt.add(BorderLayout.CENTER, titulo);
        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(1, 1));
        bar.setBackground(Cor.CINZA_CLARO);
        tt.add(BorderLayout.SOUTH, bar);

        Painel pnlMes = new Painel();
        Painel pnlMesEsquerda = new Painel();
        Painel pnlGerarDireita = new Painel();
        pnlMes.setLayout(new BorderLayout());
        pnlMes.add(BorderLayout.WEST, pnlMesEsquerda);
        pnlMes.add(BorderLayout.CENTER, pnlGerarDireita);
        pnlMes.add(BorderLayout.EAST, new Painel());
        pnlMes.add(BorderLayout.SOUTH, new Painel());

        //Formatacao do painel onde contem as datas
        pnlMesEsquerda.setLayout(new MigLayout("align left"));
        pnlMesEsquerda.add(mesEmCausa);
        pnlMesEsquerda.add(anoEmCausa);
        anoEmCausa.setMaximum(new Date().getYear() + 1900);
        anoEmCausa.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {

                int ano = anoEmCausa.getYear();
                int mes = mesEmCausa.getMonth();
                actualizar(ano, mes);

            }
        });
        
        mesEmCausa.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {

                int ano = anoEmCausa.getYear();
                int mes = mesEmCausa.getMonth();
                actualizar(ano, mes);

            }
        });
        //Formatacao do painel onde contem os buttoes que geram a folha
        Painel pnlColectivo = new Painel();
        Painel pnlIndividual = new Painel();
        pnlGerarDireita.setLayout(new MigLayout("align right, wrap 2"));
        pnlGerarDireita.add(pnlColectivo);
        pnlColectivo.setBorder(new EtchedBorder(1, Cor.PRETO, Cor.PRETO));
        pnlGerarDireita.add(pnlIndividual);
        pnlIndividual.setBorder(new EtchedBorder(1, Cor.PRETO, Cor.PRETO));

        Mostre4 lblColectivo = new Mostre4("imprimir");
        lblColectivo.setForeground(Cor.PRETO);
        Mostre4 lblIndividual = new Mostre4("imprimir para todos");
        lblIndividual.setForeground(Cor.PRETO);

        pnlColectivo.add(lblColectivo);
        pnlIndividual.add(lblIndividual);
    
        pnlIndividual.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                  int ano = anoEmCausa.getYear();
                int mes = mesEmCausa.getMonth();
             ItextTodos.gerarFolha(funcionario, ano, mes);
         
            }

        }
        );
        
          pnlColectivo.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int ano = anoEmCausa.getYear();
                int mes = mesEmCausa.getMonth();
               
                Itext.gerarFolha(funcionario, ano, mes);
         
            }

        }
        );
        Painel pnlNome = new Painel();
        pnlNome.setLayout(new MigLayout("align center, wrap 1"));
        pnlNome.add(lblNome);
        pnlNome.add(lblCargo);
        pnlNome.add(lblCategoria);
        pnlNome.add(new Painel());
        pnlNome.add(new Painel());
        pnlNome.add(new Painel());
        pnlNome.add(new Painel());
        pnlNome.add(new Painel());

        lblNome.setForeground(Cor.VERDE);
        lblCargo.setForeground(Cor.CINZA_ESCURO);
        lblCategoria.setForeground(Cor.CINZA_ESCURO);

        Painel z = new Painel();
        z.setLayout(new BorderLayout());
        z.add(BorderLayout.NORTH, pnlMes);
        z.add(BorderLayout.CENTER, pnlNome);

        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, tt); //tt
        a.add(BorderLayout.CENTER, z);
        return a;
    }

    public Painel formatarGeral() {
        Painel a = new Painel();
        a.setLayout(new GridLayout(3, 1));
        a.add(formatarBase1());
        a.add(formatarBase2());
        a.add(formatarBase3());
//        return a;
        Painel b = new Painel();
        b.setLayout(new BorderLayout());
        b.add(BorderLayout.NORTH, formatarCabecalho());
        b.add(BorderLayout.CENTER, a);

        return b;
    }

    public Painel formatarBase1() {
        Painel a = new Painel();

        Painel pnlDescontos = new Painel();
        Painel pnlCentroDescontos = new Painel();
        Painel pnlCentro = new Painel();
        Painel pnlTotal = new Painel();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.WEST, new Painel());
        a.add(BorderLayout.EAST, new Painel());
        a.add(BorderLayout.CENTER, pnlCentro);

        pnlCentro.setLayout(new BorderLayout());
        pnlCentro.add(BorderLayout.NORTH, pnlDescontos);
        pnlDescontos.setBackground(new Color(128, 171, 198));
        pnlCentro.add(BorderLayout.CENTER, pnlCentroDescontos);
        pnlCentro.add(BorderLayout.SOUTH, pnlTotal);
        //Formatar painel de descontos
        Mostre3 lblDescontos = new Mostre3("Descontos - MZN");
        lblDescontos.setForeground(Cor.BRANCO);
        pnlDescontos.setLayout(new MigLayout("align left, wrap 1"));
        pnlDescontos.add(lblDescontos);
        //Formatar painel com os campos e seus valores
        pnlCentroDescontos.setLayout(new GridLayout(1, 4, 5, 5));
        Painel p1 = new Painel();
        Painel p2 = new Painel();
        Painel p3 = new Painel();
        Painel p4 = new Painel();

        pnlCentroDescontos.add(p1);
        pnlCentroDescontos.add(p2);
        pnlCentroDescontos.add(p3);
        pnlCentroDescontos.add(p4);

        Mostre4 lblP1 = new Mostre4("Inss");
        Mostre4 lblP2 = new Mostre4("Irps");
        Mostre4 lblP3 = new Mostre4("Faltas");
        Mostre4 lblP4 = new Mostre4("Outros");

        lblNrP1.setForeground(Cor.CINZA_TEXTO);

        lblNrP2.setForeground(Cor.CINZA_TEXTO);

        lblNrP3.setForeground(Cor.CINZA_TEXTO);

        lblNrP4.setForeground(Cor.CINZA_TEXTO);

        p1.setLayout(new MigLayout("align center, wrap 1"));
        p1.add(lblP1);
        p1.add(lblNrP1);
        p2.setLayout(new MigLayout("align center, wrap 1"));
        p2.add(lblP2);
        p2.add(lblNrP2);
        p3.setLayout(new MigLayout("align center, wrap 1"));
        p3.add(lblP3);
        p3.add(lblNrP3);
        p4.setLayout(new MigLayout("align center, wrap 1"));
        p4.add(lblP4);
        p4.add(lblNrP4);

        //Formatar o painel total
        Painel pnlDireitaTotal = new Painel();
        pnlTotal.setLayout(new BorderLayout());
        pnlTotal.add(BorderLayout.WEST, new Painel());
        pnlTotal.add(BorderLayout.EAST, new Painel());
        pnlTotal.add(BorderLayout.CENTER, pnlDireitaTotal);
        Mostre3 lblTotal = new Mostre3("Total:");
        lblTotal.setForeground(Cor.PRETO);

        lblValorTotal.setForeground(Color.red);
        pnlDireitaTotal.setLayout(new MigLayout("align right, wrap 3"));
        pnlDireitaTotal.add(lblTotal);
        pnlDireitaTotal.add(new Painel());
        pnlDireitaTotal.add(lblValorTotal);

        return a;
    }

    public Painel formatarBase2() {
        Painel a = new Painel();
        Painel pnlCentro = new Painel();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.WEST, new Painel());
        a.add(BorderLayout.EAST, new Painel());
        a.add(BorderLayout.CENTER, pnlCentro);

        pnlCentro.setLayout(new BorderLayout());
        Painel pnlSalBruto = new Painel();
        pnlSalBruto.setBackground(new Color(128, 171, 198));
        Painel pnlCentro1 = new Painel();
        Painel pnlTotal = new Painel();
        pnlCentro.add(BorderLayout.NORTH, pnlSalBruto);
        pnlCentro.add(BorderLayout.CENTER, pnlCentro1);
        //pnlCentro.add(BorderLayout.SOUTH, pnlTotal);

        Mostre3 lblSalBruto = new Mostre3("Salario Bruto - MZN");
        lblSalBruto.setForeground(Cor.BRANCO);
        pnlSalBruto.setLayout(new MigLayout("align left, wrap 1"));
        pnlSalBruto.add(lblSalBruto);

        pnlCentro1.setLayout(new GridLayout(1, 2, 5, 5));
        Painel gridEsquerdo = new Painel();
        Painel pnlSubsidios = new Painel();
        pnlCentro1.add(gridEsquerdo);
        pnlCentro1.add(pnlSubsidios);

        //Formatacao do grid esquerdo
        Painel pnlSalBase = new Painel();
        Painel pnlHorasExtras = new Painel();
        gridEsquerdo.setLayout(new GridLayout(1, 2, 5, 5));
        gridEsquerdo.add(pnlSalBase);
        gridEsquerdo.add(pnlHorasExtras);
        pnlSalBase.setLayout(new MigLayout("align Center, wrap 1"));
        Mostre3 lblSalBase = new Mostre3("Sal Base");
        lblSalBase.setForeground(Cor.CINZA_ESCURO);

        pnlSalBase.add(lblSalBase);
        pnlSalBase.add(lblNrSalBase);

        pnlHorasExtras.setLayout(new MigLayout("align Center, wrap 1"));
        Mostre3 lblHorasExtras = new Mostre3("Horas Extras");
        lblHorasExtras.setForeground(Cor.CINZA_ESCURO);

        pnlHorasExtras.add(lblHorasExtras);
        pnlHorasExtras.add(lblNrHorasExtras);

        pnlSubsidios.setLayout(new GridLayout(2, 1));
        Painel pnlSubs = new Painel();
        Painel pnlCombo = new Painel();
        pnlSubsidios.add(pnlSubs);
        pnlSubsidios.add(pnlCombo);
        Mostre3 lblSubs = new Mostre3("Subsidios");
        lblSubs.setForeground(Cor.CINZA_ESCURO);
        pnlSubs.setLayout(new MigLayout("align center, wrap 1"));
        pnlSubs.add(lblSubs);

        pnlCombo.setLayout(new MigLayout("align center, wrap 4"));
        Painel pnlTotalSubs = new Painel();
        pnlTotalSubs.setBorder(new EtchedBorder(3, Cor.PRETO, Cor.PRETO));

        pnlTotalSubs.add(lblTotalSubs);
        lblTotalSubs.setForeground(Cor.PRETO);
        pnlCombo.add(jcbTodosSubsidios);
        jcbTodosSubsidios.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    lblValorSubs.setText(Double.toString(((Subsidios) jcbTodosSubsidios.getSelectedItem()).getValor()));
                } catch (Exception b) {

                }
            }
        });
        pnlCombo.add(lblValorSubs);
        pnlCombo.add(new JLabel("     "));
        pnlCombo.add(pnlTotalSubs);

        return a;
    }

    public Painel formatarBase3() {
        Painel a = new Painel();

        a.setLayout(new BorderLayout());
        Painel pnlTotal = new Painel();
        Painel pnlSalLiquido = new Painel();
        Painel pnlPrincipal = new Painel();
        a.add(BorderLayout.WEST, new Painel());
        a.add(BorderLayout.EAST, new Painel());
        a.add(BorderLayout.CENTER, pnlPrincipal);

        pnlPrincipal.setLayout(new BorderLayout());
        pnlPrincipal.add(BorderLayout.NORTH, pnlTotal);
        pnlPrincipal.add(BorderLayout.CENTER, pnlSalLiquido);

        //Formatar o painel total
        Painel pnlDireitaTotal = new Painel();
        pnlTotal.setLayout(new BorderLayout());
        pnlTotal.add(BorderLayout.CENTER, pnlDireitaTotal);
        Mostre3 lblTotal = new Mostre3("Total:");
        lblTotal.setForeground(Cor.PRETO);

        lblValorTotal1.setForeground(new Color(0, 232, 232));
        pnlDireitaTotal.setLayout(new MigLayout("align right, wrap 3"));
        pnlDireitaTotal.add(lblTotal);
        pnlDireitaTotal.add(new Painel());
        pnlDireitaTotal.add(lblValorTotal1);

        pnlSalLiquido.setLayout(new MigLayout("align Center, wrap 2"));
        Mostre1 lblSalLiquido = new Mostre1("Salario Liquido:  ");

        lblTotSalLiquido.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
        lblTotSalLiquido.setForeground(Cor.PRETO);
        pnlSalLiquido.add(lblSalLiquido);
        lblSalLiquido.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        pnlSalLiquido.add(lblTotSalLiquido);
        return a;
    }

    public void limparCampos() {
        this.lblNome.setText(" ");
        this.lblCategoria.setText(" ");
        this.lblCargo.setText(" ");
        this.lblNrP1.setText("");
        this.lblNrP2.setText("");
        this.lblNrP3.setText("");
        this.lblValorTotal.setText("");
        this.lblValorSubs.setText("");
        this.lblTotalSubs.setText("");
        this.lblNrSalBase.setText("");
        this.lblNrHorasExtras.setText("");
        this.lblTotSalLiquido.setText("");
        this.jcbTodosSubsidios.setModel(new DefaultComboBoxModel());

    }

    public void mostardados(Funcionario func) {
        funcionario = func;
        limparCampos();
        this.mesEmCausa.setMonth(new Date().getMonth());
        this.anoEmCausa.setYear(new Date().getYear() + 1900);

        lblNome.setText(func.getNome());
        lblCategoria.setText(func.getCategoria().getNome());
        lblCargo.setText(func.getCargo());
        this.actualizar(new Date().getYear() + 1900, new Date().getMonth());

    }

    public void actualizar(int ano, int mes) {
        limparCampos();
 DecimalFormat a = new DecimalFormat("0.00");
        if (funcionario != null) {
            try {
                lblNome.setText(funcionario.getNome());
                lblCategoria.setText(funcionario.getCategoria().getNome());
                lblCargo.setText(funcionario.getCargo());
                jcbTodosSubsidios.setModel(new DefaultComboBoxModel(funcionario.getSubsidios().toArray()));

                lblValorSubs.setText(a.format(((Subsidios) jcbTodosSubsidios.getSelectedItem()).getValor()));
            } catch (Exception e) {

            }
        }

        lblNrP1.setText(a.format(funcionario.calcularDescontoPorInss()));
        lblNrP2.setText(a.format(new Double(0)));
        lblNrP3.setText(a.format(funcionario.calcularDescontoPorFaltas(ano, mes)));
        lblNrP4.setText(a.format(new Double(0)));
        lblValorTotal.setText(a.format(funcionario.getTotalDescontos(ano, mes)));
        lblNrSalBase.setText(a.format(funcionario.getSalBase()));
        lblNrHorasExtras.setText(a.format(funcionario.calcularAcrescimoPorHorasExtras(ano, mes)));
        lblValorTotal1.setText(a.format(funcionario.getSalarioBruto(ano, mes)));
        lblTotSalLiquido.setText(a.format(funcionario.getTotalLiquido(ano, mes)));
        lblTotalSubs.setText(a.format(funcionario.somarValorDosSubsidios()));

    }
}
