/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import modelo.Funcionario;
import modelo.Subsidios;
import modelo.config.ConfigCargo;
import modelo.config.ConfigSubsidio;
import net.miginfocom.swing.MigLayout;
import visao.cadastro.Cad3;
import visao.componentes.Cor;
import visao.componentes.Escolha;
import visao.componentes.Mostre4;
import visao.componentes.Painel;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Home1Promover extends Painel {
//atributos

    Funcionario funcionario;
    Mostre4 lblValorFuncao = new Mostre4("");
    Mostre4 lblValorSalBase = new Mostre4("");
    Mostre4 lblValSubsidio = new Mostre4(" ..");
    Mostre4 lblValCategoria = new Mostre4(" ");
    Escolha jcbNovoCargo = new Escolha();
    Escolha jcbNovoSubsidio = new Escolha();
    Escolha jcbSubsidios = new Escolha();
    Mostre4 lblFuncao = new Mostre4("Funcao:    ");

    /**
     * Actualiza os campos de dados, quando um determinado funcionário é
     * seleccionado
     */
    public void mostrarDados(Funcionario func) {
        this.funcionario = func;
        jcbNovoSubsidio.setModel(new DefaultComboBoxModel(Cad3.subsidios.getSubsidios()));
        if (funcionario != null) {
            try {
                jcbSubsidios.setModel(new DefaultComboBoxModel(funcionario.getSubsidios().toArray()));
                lblValorSalBase.setText(Double.toString(funcionario.getSalBase()));
                lblValCategoria.setText(funcionario.getCategoria().getNome());
                lblFuncao.setText(func.getCargo());
                DecimalFormat a = new DecimalFormat("0.00");
                String f = Double.toString(((Subsidios) jcbSubsidios.getSelectedItem()).getValor());
                lblValSubsidio.setText(f);
            } catch (Exception e) {
            }
        }

        jcbNovoCargo.setModel(new DefaultComboBoxModel(Cad3.cargos.getCargos()));
    }

    /**
     * Construtor, que inicializa a tela logo ao instanciar
     *
     */
    public Home1Promover() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.SOUTH, new Painel());
        this.add(BorderLayout.WEST, new Painel());
        this.add(BorderLayout.EAST, new Painel());
        this.add(BorderLayout.NORTH, this.formatarNorte());
        this.add(BorderLayout.CENTER, new Rolagem(this.formatarCentro()));
    }

    // A barra acima
    public Painel formatarNorte() {
        Painel bar = new Painel();
        bar.setPreferredSize(new Dimension(1, 1));
        bar.setBackground(Cor.CINZA_TEXTO);
        return bar;
    }

    public Painel formatarCentro() {
        Painel a = new Painel();
        a.setLayout(new GridLayout(1, 2));
        a.add(formatarGrid1());
        a.add(formatarGrid2());
        return a;
    }

    public Painel formatarGrid1() {
        Painel a = new Painel();
        Painel pnlCargo = new Painel();
        Painel pnlBar = new Painel();
        Painel pnlCentro = new Painel();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, pnlCargo);
        a.add(BorderLayout.EAST, pnlBar);
        a.add(BorderLayout.WEST, new Painel());
        a.add(BorderLayout.CENTER, pnlCentro);
        a.add(BorderLayout.SOUTH, new Painel());

        pnlCargo.setLayout(new MigLayout("align left"));
        Mostre4 lblCargo = new Mostre4("Cargo");
        pnlCargo.add(lblCargo);

        pnlBar.setPreferredSize(new Dimension(1, 1));
        pnlBar.setBackground(Cor.PRETO);

        Painel pnl1 = new Painel();
        Painel pnl2 = new Painel();
        Painel pnl3 = new Painel();

        pnlCentro.setLayout(new BorderLayout());
        pnlCentro.add(BorderLayout.NORTH, pnl1);
        pnlCentro.add(BorderLayout.CENTER, pnl2);
        pnlCentro.add(BorderLayout.SOUTH, pnl3);

        pnl1.setLayout(new MigLayout("align center, wrap 2"));

        pnl1.add(lblFuncao);
        pnl1.add(lblValorFuncao);

        pnl2.setLayout(new MigLayout("align center, wrap 2"));
        Mostre4 lblNovoCargo = new Mostre4("Novo Cargo");

        pnl2.add(lblNovoCargo);
        pnl2.add(jcbNovoCargo);

        pnl3.setLayout(new MigLayout("align center, wrap 1"));
        Painel pnlAdicionar = new Painel();
        Mostre4 lblAdicionar = new Mostre4("Actualizar");
        pnlAdicionar.add(lblAdicionar);
        pnlAdicionar.setBorder(new EtchedBorder(1, Cor.PRETO, Cor.PRETO));
        pnl3.add(new Painel());
        pnl3.add(new Painel());
        pnl3.add(pnlAdicionar);
        pnlAdicionar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                funcionario.adicionarCargo((ConfigCargo) jcbNovoCargo.getSelectedItem());
                JOptionPane.showMessageDialog(null, Cad3.funcionarios.salvar(funcionario) ? "Sucesso" : "Erro");
                lblValorFuncao.setText(funcionario.getCargo());
            }
        });

        return a;
    }

    public Painel formatarGrid2() {
        Painel a = new Painel();

        Painel pnlSalario = new Painel();
        Painel pnlCentro = new Painel();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, pnlSalario);

        a.add(BorderLayout.CENTER, pnlCentro);

        pnlSalario.setLayout(new MigLayout());
        Mostre4 lblSalarios = new Mostre4("Salarios");
        pnlSalario.add(lblSalarios);
        pnlCentro.setLayout(new MigLayout("align center, wrap 2"));
        Mostre4 lblSalarioBase = new Mostre4("Salario Base:   ");
        Mostre4 lblCategoria = new Mostre4("Categoria:  ");
        Mostre4 lblAdicionarSubsidio = new Mostre4("Adicionar novo");
        Painel pnlAdicionar = new Painel();
        pnlAdicionar.setBorder(new EtchedBorder(1, Cor.PRETO, Cor.PRETO));
        Mostre4 lblAdicionar = new Mostre4("Adicionar");
        pnlAdicionar.add(lblAdicionar);
        pnlAdicionar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (funcionario != null) {
                    funcionario.adicionarSubsidio((ConfigSubsidio) jcbNovoSubsidio.getSelectedItem());
                    JOptionPane.showMessageDialog(null, Cad3.funcionarios.salvar(funcionario) ? "Sucesso" : "Erro");
                    jcbSubsidios.setModel(new DefaultComboBoxModel(funcionario.getSubsidios().toArray()));
                }
            }

        });
        pnlCentro.add(lblSalarioBase);
        pnlCentro.add(lblValorSalBase);
        pnlCentro.add(lblCategoria);
        pnlCentro.add(lblValCategoria);
        pnlCentro.add(lblValSubsidio);
        pnlCentro.add(jcbSubsidios);
        pnlCentro.add(new Painel());
        pnlCentro.add(new Painel());
        pnlCentro.add(lblAdicionarSubsidio);
        pnlCentro.add(jcbNovoSubsidio);
        pnlCentro.add(new Painel());
        pnlCentro.add(pnlAdicionar);

        jcbSubsidios.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
//                DecimalFormat a = new DecimalFormat("0.00");
                String f = Double.toString(((Subsidios) jcbSubsidios.getSelectedItem()).getValor());
                lblValSubsidio.setText(f);
            }
        });

        return a;
    }

}
