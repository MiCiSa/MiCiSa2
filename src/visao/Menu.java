/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controlo.ExibirPessoas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.JXCollapsiblePane;
import static visao.Home1.col;
import visao.componentes.Cor;
import visao.componentes.Mostre;
import visao.componentes.Painel;
import visao.componentes.Painel2;

/**
 *
 * @author 50enta
 */
public class Menu extends Painel2 {
//aributos

    int intNot = 0, intFunc = 0, intAus = 0, intFer = 0, intSal = 0, intEst = 0;
    public static Painel2 pnlNot = new Painel2();
    public static Painel2 pnlFunc = new Painel2();
    public static Painel2 pnlAus = new Painel2();
    public static Painel2 pnlFer = new Painel2();
    public static Painel2 pnlSal = new Painel2();
    public static Painel2 pnlEst = new Painel2();
    public static Painel2 pnlConfig = new Painel2();

    public static void mudarTodos() {
        pnlNot.setBackground(Cor.PRETO);
        pnlFunc.setBackground(Cor.PRETO);
        pnlAus.setBackground(Cor.PRETO);
        pnlFer.setBackground(Cor.PRETO);
        pnlSal.setBackground(Cor.PRETO);
        pnlEst.setBackground(Cor.PRETO);
        pnlConfig.setBackground(Cor.PRETO);
    }

    public Menu() {
        this.setPreferredSize(new Dimension(50, 50));
        this.setLayout(new GridLayout(11, 1, 7, 7));
        this.add(formatarFuncionario());
        this.add(formatarAusencias());
        this.add(this.formatarFerias());
        this.add(formatarSalarios());
        this.add(formatarEstatistica());
        this.add(formatarNotificaoes());
        for (int i = 0; i < 4; i++) {
            this.add(new Painel2());
        }
        //verificar nivel de acesso
        this.add(formatarConfiguracoes());
    }

    public Painel formatarFuncionario() {

        Mostre icon = new Mostre();
        icon.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/pessoasPB.png")));
        pnlFunc.add(icon);
        pnlFunc.setToolTipText("Funcionários");

        pnlFunc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);

                Home1.irParaFuncionarios(true);

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                if (pnlFunc.getBackground() != Cor.VERDE) {
                    pnlFunc.setBackground(new Color(60, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                if (pnlFunc.getBackground() != Cor.VERDE) {
                    pnlFunc.setBackground(Cor.PRETO);
                }
            }

        });
        return pnlFunc;
    }

    //métodos para ausências
    public Painel formatarAusencias() {

        Mostre icon = new Mostre();
        icon.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/ausenciasPG.png")));
        pnlAus.add(icon);
        pnlAus.setToolTipText("Ausências");

        pnlAus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaAusencias(true);

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                if (pnlAus.getBackground() != Cor.VERDE) {
                    pnlAus.setBackground(new Color(60, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                if (pnlAus.getBackground() != Cor.VERDE) {
                    pnlAus.setBackground(Cor.PRETO);
                }
            }

        });
        return pnlAus;
    }

    public Painel formatarFerias() {

        Mostre icon = new Mostre();
        icon.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/feriasPB.png")));
        pnlFer.add(icon);
        pnlFer.setToolTipText("Férias");

        pnlFer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                super.mouseClicked(me);
                Home1.irParaFerias(true);

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                if (pnlFer.getBackground() != Cor.VERDE) {
                    pnlFer.setBackground(new Color(60, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                if (pnlFer.getBackground() != Cor.VERDE) {
                    pnlFer.setBackground(Cor.PRETO);
                }
            }

        });
        return pnlFer;
    }

    public Painel formatarSalarios() {

        Mostre icon = new Mostre();
        icon.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/salariosPB.png")));
        pnlSal.add(icon);
        pnlSal.setToolTipText("Salários");

        pnlSal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaSalarios(true);

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                if (pnlSal.getBackground() != Cor.VERDE) {
                    pnlSal.setBackground(new Color(60, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                if (pnlSal.getBackground() != Cor.VERDE) {
                    pnlSal.setBackground(Cor.PRETO);
                }
            }

        });
        return pnlSal;
    }

    public Painel formatarEstatistica() {

        Mostre icon = new Mostre();
        icon.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/estatisticaPB.png")));
        pnlEst.add(icon);
        pnlEst.setToolTipText("Estatística");

        pnlEst.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaEstatistica(true);

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                if (pnlEst.getBackground() != Cor.VERDE) {
                    pnlEst.setBackground(new Color(60, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                if (pnlEst.getBackground() != Cor.VERDE) {
                    pnlEst.setBackground(Cor.PRETO);
                }
            }

        });
        return pnlEst;
    }

    public Painel formatarConfiguracoes() {
        Mostre icon = new Mostre();
        icon.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/configuracoesPB.png")));
        pnlConfig.add(icon);
        pnlConfig.setToolTipText("Configurações");

        pnlConfig.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaConfiguracoes(true);

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                if (pnlConfig.getBackground() != Cor.VERDE) {
                    pnlConfig.setBackground(new Color(60, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                if (pnlConfig.getBackground() != Cor.VERDE) {
                    pnlConfig.setBackground(Cor.PRETO);
                }
            }

        });
        return pnlConfig;
    }

    public Painel formatarNotificaoes() {

        Mostre icon = new Mostre();
        icon.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/notificacaoPB.png")));
        pnlNot.add(icon);
        pnlNot.setToolTipText("Notificações");

        pnlNot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaNotificacoes(true);

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                if (pnlNot.getBackground() != Cor.VERDE) {
                    pnlNot.setBackground(new Color(60, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                if (pnlNot.getBackground() != Cor.VERDE) {
                    pnlNot.setBackground(Cor.PRETO);
                }
            }

        });
        return pnlNot;
    }
}
