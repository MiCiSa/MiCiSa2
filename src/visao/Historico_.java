/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import visao.componentes.Painel;
import modelo.Historico;
import net.miginfocom.swing.MigLayout;
import visao.componentes.Cor;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre6;
import visao.componentes.Painel1;

/**
 * O modo pelo qual cada instãncia do histórico irá funcionar. Este é o moolde
 * deste comportamento
 *
 * @author 50enta
 */
public class Historico_ extends Painel {

    //atribtuos
    public Historico historico;

    public Historico_(Historico hist) {
        this.historico = hist;
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(400, 60));
        this.setMaximumSize(new Dimension(1300, 44));
        this.add(formatarNotificacao());
    }

    public Painel1 formatarNotificacao() {
        Painel1 a = new Painel1();
        a.setLayout(new BorderLayout());

        Painel1 pnlFoto = new Painel1();
        pnlFoto.setLayout(new BorderLayout());
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/notificacaoP.png"));
//        Image img = Toolkit.getDefaultToolkit().getImage("imagens/notificacaoPB.png");
        Mostre lblFoto = new Mostre();
        lblFoto.setIcon(new ImageIcon(img));
        pnlFoto.add(BorderLayout.CENTER, lblFoto);

        Painel1 esquerda = new Painel1();
        esquerda.setLayout(new BorderLayout());

        esquerda.add(BorderLayout.WEST, new Painel1());
        esquerda.add(BorderLayout.EAST, new Painel1());
        esquerda.add(BorderLayout.CENTER, pnlFoto);
        esquerda.add(BorderLayout.SOUTH, new Painel1());
        esquerda.add(BorderLayout.NORTH, new Painel1());

        Painel1 baseInfo = new Painel1();
        baseInfo.setLayout(new MigLayout("align center"));
        Mostre2 lb = new Mostre2(historico.getTexto());
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 19));
        lb.setForeground(Cor.CINZA_ESCURO);
        baseInfo.add(lb, "wrap");
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        Mostre6 lblDataInicio = new Mostre6("   Desconhecida");
        if (historico.getDtInicio() != null) {
            lblDataInicio.setText("         " + dt.format(historico.getDtInicio()) + "        ");
        }
        lblDataInicio.setForeground((Cor.AZUL));
        lblDataInicio.setFont(new Font("calibri", Font.BOLD, 14));

        Mostre6 lblDataFim = new Mostre6("     hoje         ");
        if (historico.getDtFim() != null) {
            lblDataFim.setText("         " + dt.format((historico.getDtFim() != null) ? historico.getDtFim() : new Date()) + "         ");
        }
        lblDataFim.setForeground((Cor.AZUL));
        lblDataFim.setFont(new Font("cambria", Font.BOLD, 14));

        Painel1 direita = new Painel1();
        direita.setLayout(new BorderLayout());
        direita.add(BorderLayout.CENTER, baseInfo);

        Painel barra = new Painel();
        barra.setBackground(Cor.CINZA_TEXTO);
        barra.setPreferredSize(new Dimension(1, 2));

//        a.add(BorderLayout.WEST, esquerda);
        a.add(BorderLayout.WEST, lblDataInicio);
        a.add(BorderLayout.CENTER, direita);
        a.add(BorderLayout.SOUTH, barra);
        a.add(BorderLayout.EAST, lblDataFim);
        return a;
    }

    public static void main(String[] args) {
        Historico hist = new Historico();
        hist.setDtFim(new Date());
        hist.setDtInicio(new Date());
        hist.setTexto("Função: Contabilista");

        JFrame a = new JFrame();
        a.setDefaultCloseOperation(3);
        a.add(new Historico_(hist));
        a.setVisible(true);
//        a.setPreferredSize(new Dimension(500, 500));
        a.pack();
    }
}
