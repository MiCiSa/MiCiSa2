/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Home1_;

import controlo.ControloHistorico;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import modelo.Funcionario;
import modelo.Historico;
import visao.Historico_;
import visao.Home1;
import visao.componentes.Painel;
import visao.componentes.Painel1;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Home1Historico extends Painel {

    //atribtuos
    Funcionario funcionario;

    public static Painel1 pnlHistorico = new Painel1();

    public Home1Historico() {
        this.setLayout(new BorderLayout());
//        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarGeral());

    }

    public Painel formatarGeral() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, new Painel());
        a.add(BorderLayout.EAST, new Painel());
        a.add(BorderLayout.WEST, new Painel());
        a.add(BorderLayout.SOUTH, new Painel());
        a.add(BorderLayout.CENTER, formatarBase());
        return a;
    }

    public Painel formatarBase() { //incui o painel notificacoes
        Painel a = new Painel();
        pnlHistorico.setLayout(new BorderLayout());
        //
        //

        Painel pess = new Painel1();
//        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
//        for (int i = 0; i < 5; i++) {
//            int n = (int) (Math.random() * 2);
//            pess.add(new Historico_(new Historico("Texto ", new Date(), new Date())));
//            pess.add(new Historico_(new Historico("Texto ", new Date(), new Date())));
//        }
        pnlHistorico.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        //
        //
        //
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.CENTER, new Rolagem(pnlHistorico));
        a.add(BorderLayout.EAST, new Painel());
        a.add(BorderLayout.WEST, new Painel());
        a.add(BorderLayout.NORTH, new Painel());
        a.add(BorderLayout.SOUTH, new Painel());
        return a;
    }

    public void gerarHistorico(Funcionario func) {
        pnlHistorico.removeAll();
        pnlHistorico.repaint();
        Painel pess = new Painel1();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        if (func != null) {
            for (Historico a : ControloHistorico.gerarHistorico(func)) {
                pess.add(new Historico_(a));
            }
        }
        pnlHistorico.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        pnlHistorico.revalidate();
    }

    public void mostrarDados(Funcionario func) {
        pnlHistorico.removeAll();
//        pnlHistorico.repaint();
        pnlHistorico.revalidate();
        this.funcionario = func;
        this.gerarHistorico(func);
    }

}
