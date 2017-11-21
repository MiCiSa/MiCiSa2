/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.Funcionario;
import modelo.Status;
import net.miginfocom.swing.MigLayout;
import visao.Home;
import visao.cadastro.Cad3;
import visao.componentes.Botao;
import visao.componentes.Cor;
import visao.componentes.EscolhaAno;
import visao.componentes.EscolhaMes;
import visao.componentes.EscolhaValor;
import visao.componentes.Fonte;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre5;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Home1Ausencias extends Painel {
    //Atributos

    Funcionario funcionario;

    EscolhaMes mesEmCausa = new EscolhaMes();
    EscolhaAno anoEmCausa = new EscolhaAno();

    Mostre2 lblNome = new Mostre2("Micaela de Araújo Freitas");

    Mostre6 lblFaltasMesPassado = new Mostre6("0");
    Mostre6 lblFaltasEsteMes = new Mostre6("0");
    EscolhaValor spnFaltas = new EscolhaValor();
    Botao btnMarcarFaltas = new Botao("Salvar");

    Mostre6 lblHorasExtrasMesPassado = new Mostre6("0");
    Mostre6 lblHorasExtrasEsteMes = new Mostre6("0");
    EscolhaValor spnHorasExtras = new EscolhaValor();
    Botao btnMarcarHorasExtras = new Botao("Salvar");

    //construtor
    public Home1Ausencias() {

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, new Rolagem(formatarGeral()));
    }

    public Painel formatarCabecalho() {
        Painel a = new Painel();
        //O titulo
        Painel titulo = new Painel();
        titulo.setLayout(new MigLayout("align right"));
        Mostre2 t = new Mostre2("Ausências");
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
        pnlMes.setLayout(new MigLayout("align left"));
        pnlMes.add(mesEmCausa);
        anoEmCausa.setMaximum(new Date().getYear() + 1900);
        anoEmCausa.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                limparCampos();
                int ano = anoEmCausa.getYear();
                int mes = mesEmCausa.getMonth();
                actualizar(ano, mes);

            }
        });
        mesEmCausa.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                limparCampos();
                int ano = anoEmCausa.getYear();
                int mes = mesEmCausa.getMonth();
                actualizar(ano, mes);

            }
        });

        pnlMes.add(anoEmCausa);
        anoEmCausa.setMaximum(new Date().getYear() + 1900);
        Painel pnlNome = new Painel();
        pnlNome.add(lblNome);

        Painel z = new Painel();
        z.setLayout(new BorderLayout());
        z.add(BorderLayout.NORTH, pnlMes);
        z.add(BorderLayout.CENTER, pnlNome);

        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, tt); //tt
        a.add(BorderLayout.CENTER, z);
        return a;
    }

    public Painel formatarBase1() {
        Painel a = new Painel();
        a.setBorder(new TitledBorder(new EtchedBorder(2, Cor.CINZA_TEXTO, Cor.CINZA_TEXTO), "Efectividade", 0, 1, Fonte.CALIBRI_NORMAL, Cor.CINZA_TEXTO));
        a.setLayout(new BorderLayout());

        Painel esquerda = new Painel();
        esquerda.setLayout(new BoxLayout(esquerda, BoxLayout.PAGE_AXIS));
        esquerda.add(new Painel());
        Mostre5 k1 = new Mostre5("Mês passado");
        k1.setAlignmentX(CENTER_ALIGNMENT);
        esquerda.add(k1);
        esquerda.add(lblFaltasMesPassado);
        lblFaltasMesPassado.setFont(Fonte.COMIC_SANS_MS);
        lblFaltasMesPassado.setAlignmentX(CENTER_ALIGNMENT);
        Mostre5 k2 = new Mostre5("Este Mês");
        k2.setAlignmentX(CENTER_ALIGNMENT);
        esquerda.add(k2);
        esquerda.add(lblFaltasEsteMes);
        lblFaltasEsteMes.setFont(Fonte.COMIC_SANS_MS);
        lblFaltasEsteMes.setAlignmentX(CENTER_ALIGNMENT);
        Painel m = new Painel();
        m.add(spnFaltas);
        m.add(btnMarcarFaltas);
        esquerda.add(m);
        m.setAlignmentX(CENTER_ALIGNMENT);
        spnFaltas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblFaltasEsteMes.setText((String) spnFaltas.getValue());
            }
        });
        btnMarcarFaltas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int marcarFaltas = Integer.parseInt((String) spnFaltas.getValue());
                if (funcionario != null) {

                    if (funcionario.getStatus().equalsIgnoreCase(Status.ACTIVO)) {
                        boolean marcou = funcionario.marcarFaltas(marcarFaltas);
                        boolean salvou = Cad3.funcionarios.salvar(funcionario);
                        JOptionPane.showMessageDialog(null, marcou ? (salvou ? "Sucesso" : "Erro ao salvar") : "Erro, ja marcar faltas para este mes");
                    } else {
                        JOptionPane.showMessageDialog(null, "Impossível marcar faltas para funcionarios " + funcionario.getStatus());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleciona Funcionario");

                }
            }
        });

        Painel direita = new Painel();
        direita.setPreferredSize(new Dimension(200, 50));
        direita.setLayout(new BorderLayout());
        direita.add(new Mostre(new ImageIcon(new Home().getClass().getResource("imagens/ausencasG.png"))));

        a.add(BorderLayout.CENTER, esquerda);
        a.add(BorderLayout.EAST, direita);
        return a;
    }

    public Painel formatarBase2() {
        Painel a = new Painel();
        a.setBorder(new TitledBorder(new EtchedBorder(2, Cor.CINZA_TEXTO, Cor.CINZA_TEXTO), "Horas extras", 0, 1, Fonte.CALIBRI_NORMAL, Cor.CINZA_TEXTO));
        a.setLayout(new BorderLayout());

        Painel esquerda = new Painel();
        esquerda.setLayout(new BoxLayout(esquerda, BoxLayout.PAGE_AXIS));
        esquerda.add(new Painel());
        Mostre5 k1 = new Mostre5("Mês passado");
        k1.setAlignmentX(CENTER_ALIGNMENT);
        esquerda.add(k1);
        esquerda.add(lblHorasExtrasMesPassado);
        lblHorasExtrasMesPassado.setFont(Fonte.COMIC_SANS_MS);
        lblHorasExtrasMesPassado.setAlignmentX(CENTER_ALIGNMENT);
        Mostre5 k2 = new Mostre5("Este Mês ");
        k2.setAlignmentX(CENTER_ALIGNMENT);
        esquerda.add(k2);
        esquerda.add(lblHorasExtrasEsteMes);
        lblHorasExtrasEsteMes.setFont(Fonte.COMIC_SANS_MS);
        lblHorasExtrasEsteMes.setAlignmentX(CENTER_ALIGNMENT);
        Painel m = new Painel();
        m.add(spnHorasExtras);
        m.add(btnMarcarHorasExtras);
        esquerda.add(m);

        spnHorasExtras.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblHorasExtrasEsteMes.setText((String) spnHorasExtras.getValue());
            }
        });
        btnMarcarHorasExtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int horasExtras = Integer.parseInt((String) spnFaltas.getValue());
                if (funcionario != null) {
                    if (funcionario.getStatus().equalsIgnoreCase(Status.ACTIVO)) {
                        boolean marcou = funcionario.marcarHorasExtras(horasExtras);
                        boolean salvou = Cad3.funcionarios.salvar(funcionario);
                        JOptionPane.showMessageDialog(null, marcou ? (salvou ? "Sucesso" : "Erro ao salvar") : "Erro, horas extras para este mes.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Impossível marcar horas extras para funcionarios " + funcionario.getStatus());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "seleciona o funcionario");
                }
            }
        });

        Painel direita = new Painel();
        direita.setPreferredSize(new Dimension(200, 50));
        direita.setLayout(new BorderLayout());
        direita.add(new Mostre(new ImageIcon(new Home().getClass().getResource("imagens/HorasExtrasG.png"))));

        a.add(BorderLayout.CENTER, esquerda);
        a.add(BorderLayout.EAST, direita);
        return a;
    }

    private Component formatarGeral() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        Painel b = new Painel();
        b.setLayout(new GridLayout(2, 1));
        b.add(formatarBase1());
        b.add(formatarBase2());

        a.add(BorderLayout.EAST, new Painel());
        a.add(BorderLayout.WEST, new Painel());
        a.add(BorderLayout.NORTH, new Painel());
        a.add(BorderLayout.SOUTH, formatarRodape());
        a.add(BorderLayout.CENTER, b);
        return new Rolagem(a);
    }

    private Painel formatarRodape() {
        Painel a = new Painel();
        a.setLayout(new MigLayout("align right"));
        Mostre5 lblCancelar = new Mostre5("Cancelar    ");
        lblCancelar.setFont(new Font("calibri", Font.PLAIN, 12));
        a.add(lblCancelar);

        lblCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                int mes = mesEmCausa.getMonth();
                int ano = anoEmCausa.getYear();
                if (mes == new Date().getMonth() && ano == new Date().getYear() + 1900) {

                    if (funcionario != null) {
                        funcionario.cancelarFaltas();
                        funcionario.cancelarHorasExtras();
                        int i = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                        if (i == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, Cad3.funcionarios.salvar(funcionario) ? "Sucesso" : "Erro");
                        }
                        actualizar(ano, mes);

                    } else {
                        JOptionPane.showMessageDialog(null, "Seleciona Funcionario");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Nao pode cancelar faltas deste mes");
                }

            }
        });

        return a;
    }

    public void limparCampos() {
        this.lblNome.setText(" ");
        this.lblFaltasMesPassado.setText(" ");
        this.lblFaltasEsteMes.setText(" ");
        this.lblHorasExtrasMesPassado.setText(" ");
        this.lblHorasExtrasEsteMes.setText(" ");

    }

    public void mostrarDados(Funcionario func) {
        funcionario = func;

        limparCampos();

        lblNome.setText(funcionario.getNome());
        lblFaltasMesPassado.setText(Integer.toString(funcionario.getFaltas(new Date().getYear() + 1900, new Date().getMonth() - 1)));
        lblFaltasEsteMes.setText(Integer.toString(funcionario.getFaltas(new Date().getYear() + 1900, new Date().getMonth())));
        lblHorasExtrasMesPassado.setText(Integer.toString(funcionario.getHorasExtras(new Date().getYear() + 1900, new Date().getMonth() - 1)));
        lblHorasExtrasEsteMes.setText(Integer.toString(funcionario.getHorasExtras(new Date().getYear() + 1900, new Date().getMonth())));
    }

    public void actualizar(int ano, int mes) {
        limparCampos();
        if (funcionario != null) {
            try {
                lblNome.setText(funcionario.getNome());
                lblFaltasMesPassado.setText(Integer.toString(funcionario.getFaltas(ano, mes - 1)));
                lblFaltasEsteMes.setText(Integer.toString(funcionario.getFaltas(ano, mes)));
                lblHorasExtrasMesPassado.setText(Integer.toString(funcionario.getHorasExtras(ano, mes - 1)));
                lblHorasExtrasEsteMes.setText(Integer.toString(funcionario.getHorasExtras(ano, mes)));
            } catch (Exception h) {

            }
        }

    }

}
