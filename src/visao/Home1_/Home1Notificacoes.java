/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Home1_;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import modelo.Notificacao;
import modelo.config.ConfigNotificacoes;
import net.miginfocom.swing.MigLayout;
import visao.Notificacao_;
import visao.cadastro.Cad3;
import visao.componentes.Cor;
import visao.componentes.Escolha;
import visao.componentes.EscolhaAno;
import visao.componentes.EscolhaMes;
import visao.componentes.Mostre2;
import visao.componentes.Painel;
import visao.componentes.Painel1;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Home1Notificacoes extends Painel {
    //stribtuos

    public static Painel1 pnlNotificacoes = new Painel1();
    public EscolhaMes mesEmCausa = new EscolhaMes();
    public EscolhaAno anoEmCausa = new EscolhaAno();

    //construtor
    public Home1Notificacoes() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
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
        pnlNotificacoes.setLayout(new BorderLayout());
        //
        //
        actualizarPainelNotificacoes(false);
        //
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.CENTER, new Rolagem(pnlNotificacoes));
        a.add(BorderLayout.EAST, new Painel());
        a.add(BorderLayout.WEST, new Painel());
        a.add(BorderLayout.NORTH, new Painel());
        a.add(BorderLayout.SOUTH, new Painel());
        return a;
    }

    /**
     * Método responsável por procurar notic=ficações e actualiza o painel
     * resonsável por exibílas
     */
    public static void actualizarPainelNotificacoes(boolean sim) {
        if (sim) {
            ConfigNotificacoes.procurarNotificacoes(Cad3.funcionarios.getFuncionario());
        }
        pnlNotificacoes.removeAll();
        pnlNotificacoes.repaint();
        Painel pess = new Painel1();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        for (Notificacao not : Cad3.notificacoes.getNotificacoes()) {
            pess.add(new Notificacao_(not));
        }
        pnlNotificacoes.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        pnlNotificacoes.revalidate();
//
    }

    public Painel formatarCabecalho() {
        Painel a = new Painel();
        //O titulo
        Painel titulo = new Painel();
        titulo.setLayout(new MigLayout("align right"));
        Mostre2 t = new Mostre2("Notificações");
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
        Escolha jcb = new Escolha(new String[]{"Não Vistas", "Vistas"});
        pnlMes.add(jcb);
        jcb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (((String) jcb.getSelectedItem()).equalsIgnoreCase("Vistas")) {
                    pnlNotificacoes.removeAll();
                    pnlNotificacoes.repaint();
                    Vector<Notificacao> vet = new Vector<>();
                    ConfigNotificacoes.procurarNotificacoes(Cad3.funcionarios.getFuncionario());
                    Painel pess = new Painel1();
                    pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
                    for (Notificacao not : Cad3.notificacoes.pesquisarTodos()) {
                        if (!not.isActivo() && !existe(not, vet)) {
                            vet.add(not);
                            pess.add(new Notificacao_(not));
                        }
                    }
                    pnlNotificacoes.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
                    pnlNotificacoes.revalidate();
                } else {
                    Home1Notificacoes.actualizarPainelNotificacoes(true);
                }
            }
        });
        jcb.setPreferredSize(new Dimension(75, 24));
        jcb.setRequestFocusEnabled(false);
//        pnlMes.add(mesEmCausa);
//        pnlMes.add(anoEmCausa);

        Painel z = new Painel();
        z.setLayout(new BorderLayout());
        z.add(BorderLayout.NORTH, pnlMes);

        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, tt); //tt
        a.add(BorderLayout.CENTER, z);
        return a;
    }
     public static boolean existe(Notificacao not, Vector<Notificacao> vet){
        for(Notificacao a: vet){
            if(a.getTexto().equalsIgnoreCase(not.getTexto()) && !a.isActivo()){
                return true;
            }
        }
        return false;
    }
}
