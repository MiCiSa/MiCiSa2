/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.Ferias;
import modelo.Funcionario;
import net.miginfocom.swing.MigLayout;
import visao.cadastro.Cad3;
import visao.componentes.Botao;
import visao.componentes.Cor;
import visao.componentes.EscolhaAno;
import visao.componentes.EscolhaData;
import visao.componentes.Introduza;
import visao.componentes.Mostre1;
import visao.componentes.Mostre2;
import visao.componentes.Mostre5;
import visao.componentes.MostreMes;
import visao.componentes.Painel;
import visao.componentes.Painel4;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Home1Ferias extends Painel {

    //atributos
    Funcionario funcionario;
    EscolhaAno anoEmCausa = new EscolhaAno();

    MostreMes meses = new MostreMes();

    Mostre2 lblNome = new Mostre2("Silja Ferro Dimas");
    Mostre1 lblDiasRestantes = new Mostre1("23");
    Mostre1 lblDiasPassados = new Mostre1("7");
    Mostre1 lblTotalDias = new Mostre1("30");

    EscolhaData dtInicio = new EscolhaData();
    EscolhaData dtFim = new EscolhaData();

    public Home1Ferias() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarGeral());
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
        return new Rolagem(new Rolagem(a));
    }

    public Painel formatarBase1() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());

        //
        //
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy");
        Date dat1 = null;
        Date dat2 = null;
        try {
            dat1 = sdf1.parse("12/03/2017");
            dat2 = sdf1.parse("12/04/2017");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter datas");
        }

        try {
            this.seleccionarDatas(dat1, dat2);
        } catch (ParseException ex) {
            Logger.getLogger(Home1Ferias.class.getName()).log(Level.SEVERE, null, ex);
        }

        //
        //
        meses.setFlaggedDayForeground(Cor.AZUL);
        meses.setFont(new Font("calibri", Font.BOLD, 15));
        meses.setForeground(Cor.CINZA_TEXTO);
        a.add(BorderLayout.CENTER, meses);
        return a;
    }

    /**
     * Recebe duas datas e selecciona no calendário o intervalo de datas
     * correspondentes às datas introduzodas
     *
     * @param d1
     * @param d2
     */
    public void seleccionarDatas(Date d1, Date d2) throws ParseException {
        meses.setFirstDisplayedDay(d1);
        Calendar a = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy");

        a.setTime(d1);
        Long n = Ferias.diferencaEntreDatas(d1, d2);
        Integer dias = Integer.valueOf(n.toString());

        Date[] data = new Date[dias + 1];
        int i = 0;
        for (Date d = d1; d.compareTo(d2) <= 0;) {

            data[i++] = (sdf1.parse(sdf1.format(d)));
            a.add(Calendar.DATE, +1);
            d = a.getTime();
            if (i == dias + 1) {
                break;
            }
        }
        meses.setFlaggedDates(data);
        meses.setFlaggedDayForeground(Color.red);
    } //479319616973 

    public Painel formatarBase2() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());

        Painel esquerda = new Painel();
        esquerda.setLayout(new MigLayout("align center, wrap 3"));
        esquerda.add(new Mostre5("     "), "wrap");
        esquerda.add(new Mostre5("     "), "wrap");
        esquerda.add(new Mostre5("Data de início"));
        esquerda.add(new Mostre5("     "));
        esquerda.add(dtInicio);
        esquerda.add(new Mostre5("Data do fim"));
        esquerda.add(new Mostre5("     "));
        esquerda.add(dtFim);

        dtInicio.setMinSelectableDate(new Date());
        Calendar hj = Calendar.getInstance();
        hj.setTime(dtInicio.getMaxSelectableDate());
        hj.add(Calendar.DATE, +30);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy");
        try {
            dtFim.setMaxSelectableDate(sdf1.parse(sdf1.format(hj.getTime()))); //dia 31
            dtFim.setMinSelectableDate(dtInicio.getDate());
        } catch (ParseException ex) {
            Logger.getLogger(Home1Ferias.class.getName()).log(Level.SEVERE, null, ex);
        }
        Introduza txt = new Introduza();
        txt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                if (dtInicio.getDate() != null && dtFim.getDate() != null) {
                    try {
                        if (dtFim.getDate().compareTo(dtInicio.getDate()) >= 1) {
                            seleccionarDatas(dtInicio.getDate(), dtFim.getDate());
                            actualizarDashBorads(dtInicio.getDate(), dtFim.getDate());
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Home1Ferias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                if (dtInicio.getDate() != null && dtFim.getDate() != null) {
                    try {
                        if (dtFim.getDate().compareTo(dtInicio.getDate()) >= 1) {
                            seleccionarDatas(dtInicio.getDate(), dtFim.getDate());
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Home1Ferias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                if (dtInicio.getDate() != null && dtFim.getDate() != null) {
                    try {
                        if (dtFim.getDate().compareTo(dtInicio.getDate()) >= 1) {
                            seleccionarDatas(dtInicio.getDate(), dtFim.getDate());
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Home1Ferias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        dtFim.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {

                if (dtInicio.getDate() != null) {
                    txt.setText(" ");

                }
            }
        }
        );

        Painel direita = new Painel();

        direita.setLayout(
                new GridLayout(1, 3, 8, 8));
        Painel p1 = new Painel();

        p1.setLayout(
                new BorderLayout());
        Painel p2 = new Painel();

        p2.setLayout(
                new BorderLayout());
        Painel p3 = new Painel();

        p3.setLayout(
                new BorderLayout());

        p1.add(BorderLayout.NORTH,
                new Painel4("Passados", new Color(108, 108, 183)));
        p1.add(BorderLayout.CENTER,
                new Painel(lblDiasPassados));
        p2.add(BorderLayout.NORTH,
                new Painel4("Restantes", new Color(128, 171, 198)));
        p2.add(BorderLayout.CENTER,
                new Painel(lblDiasRestantes));
        p3.add(BorderLayout.NORTH,
                new Painel4("Total", Color.lightGray));
        p3.add(BorderLayout.CENTER,
                new Painel(lblTotalDias));

        direita.add(p1);

        direita.add(p2);

        direita.add(p3);

        Painel kkk = new Painel();

        kkk.setPreferredSize(
                new Dimension(50, 30));
        Painel direita1 = new Painel();

        direita1.setLayout(
                new BorderLayout());
        direita1.add(BorderLayout.CENTER, direita);

        direita1.add(BorderLayout.SOUTH, kkk);

        direita1.add(BorderLayout.NORTH,
                new Painel());

        Painel esquerdaDireita = new Painel();

        esquerdaDireita.setLayout(
                new GridLayout(1, 2));
        esquerdaDireita.add(esquerda);

        esquerdaDireita.add(direita1);

        //classe que contém o rodapezinho
        class A {

            public Painel formatarRodaPe() {
                Painel a = new Painel();
                Botao btnActulizar = new Botao("Actualizar");
                a.add(btnActulizar);
                btnActulizar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (dtInicio.getDate() == null || dtFim.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Por favor, verfique as datas");
                            return;
                        }
                        if (funcionario != null) {
                            try {
                                boolean a = funcionario.marcarFerias(dtInicio.getDate(), dtFim.getDate());
                                JOptionPane.showMessageDialog(null, a ? "Sucesso" : "Erro");
                                if (a) {
                                    Cad3.funcionarios.salvar(funcionario);

                                }
                            } catch (ParseException ex) {
                                Logger.getLogger(Home1Ferias.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione algum funcionário");
                        }

                    }
                });
                return a;
            }
        }
        Painel4 subtitulo = new Painel4("Detalhes ", Cor.BRANCO);

        a.add(BorderLayout.CENTER, esquerdaDireita);

        a.add(BorderLayout.SOUTH,
                new A().formatarRodaPe());
        a.add(BorderLayout.NORTH,
                new Painel4("Detalhes ", true));
        return a;

    }

    public Painel formatarCabecalho() {
        Painel a = new Painel();
        //O titulo
        Painel titulo = new Painel();
        titulo.setLayout(new MigLayout("align right"));
        Mostre2 t = new Mostre2("Férias");
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
        pnlMes.add(anoEmCausa);
        anoEmCausa.setMaximum(new Date().getYear() + 1900);
        Painel pnlNome = new Painel();
        pnlNome.add(lblNome);
        lblNome.setForeground(Cor.CINZA_ESCURO);
        anoEmCausa.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                limparCampos();
                int ano = anoEmCausa.getYear();
                if (funcionario != null) {
                    actualizar(ano);
                }

            }
        });
        Painel z = new Painel();
        z.setLayout(new BorderLayout());
        z.add(BorderLayout.NORTH, pnlMes);
        z.add(BorderLayout.CENTER, pnlNome);

        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, tt); //tt
        a.add(BorderLayout.CENTER, z);
        return a;
    }

    private Painel formatarRodape() {
        Painel a = new Painel();
        a.setLayout(new MigLayout("align right"));
        Mostre5 lblCancelar = new Mostre5("Cancelar    ");
        lblCancelar.setFont(new Font("calibri", Font.PLAIN, 10));
        a.add(lblCancelar);

        lblCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                int ano = anoEmCausa.getYear();
                if (ano == new Date().getYear() + 1900) {

                    if (funcionario != null) {
                        funcionario.cancelarFerias();
                        int i = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                        if (i == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, Cad3.funcionarios.salvar(funcionario) ? "Sucesso" : "Erro");
                        }
                        actualizar(ano);
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleciona Funcionario");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Nao pode cancelar ferias deste mes");
                }

            }
        });

        return a;
    }

    public void limparCampos() {
        this.lblNome.setText("Nenhum funcionário seleccionado");
        this.lblDiasPassados.setText("0");
        this.lblDiasRestantes.setText("0");
        this.lblTotalDias.setText("0");
        dtFim.setDate(null);
        dtInicio.setDate(null);
        try {
            this.seleccionarDatas(new Date(), new Date());
        } catch (ParseException ex) {
        }
    }

    public void mostrardados(Funcionario func) {
        limparCampos();
        funcionario = func;
        lblNome.setText(funcionario.getNome());
        this.actualizar(new Date().getYear() + 1900);
    }

    public void actualizar(int ano) {
        this.limparCampos();
        try {
            if (funcionario != null) {
                lblNome.setText(funcionario.getNome());
                Ferias fe = funcionario.getFerias(ano);
                if (fe != null) {
                    dtInicio.setDate(fe.getDataInicio());
                    dtFim.setDate(fe.getDataFim());
                    this.seleccionarDatas(fe.getDataInicio(), fe.getDataFim());

                    //para os dias restates, faltantes e total
                    if ((fe.getDataInicio().compareTo(new Date()) >= 0)) { //já começou férias
                        actualizarDashBorads(fe.getDataInicio(), fe.getDataFim());
                    } else {
//                        lblDiasPassados.setText(Long.toString(Ferias.diferencaEntreDatas(fe.getDataInicio(), new Date())));
//                        lblDiasRestantes.setText(Long.toString(Ferias.diferencaEntreDatas(new Date(), fe.getDataFim())));
//                        lblTotalDias.setText(Long.toString(Ferias.diferencaEntreDatas(fe.getDataInicio(), fe.getDataFim())));
                    }
                }
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Confusão com as datas");
        }
    }

    public void actualizarDashBorads(Date d1, Date d2) throws ParseException {
        lblDiasPassados.setText(Long.toString(Ferias.diferencaEntreDatas(d1, new Date())));
        lblDiasRestantes.setText(Long.toString(Ferias.diferencaEntreDatas(new Date(), d2)));
        lblTotalDias.setText(Long.toString(Ferias.diferencaEntreDatas(d1, d2)));
    }
}
