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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import modelo.Usu;
import modelo.config.ConfigAcess;
import net.miginfocom.swing.MigLayout;
import visao.componentes.Cor;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Painel1;
import visao.componentes.Painel3;

/**
 * Moldar o exibição de um determinado acesso
 *
 * @author 50enta
 */
public class Acesso_ extends Painel {

    ConfigAcess acess = new ConfigAcess();

    public Acesso_(ConfigAcess ace) {
        acess = ace;

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(400, 60));
        this.setMaximumSize(new Dimension(1000, 74));
        this.add(formatarAcesso());
    }

    /**
     * Formatação da parte gráfica responsável por exibir os dados de forma
     * agradável
     *
     * @return
     */
    public Painel1 formatarAcesso() {
        Painel1 a = new Painel1();
        a.setLayout(new BorderLayout());

        Painel3 pnlFoto = new Painel3();
        pnlFoto.setLayout(new BorderLayout());
//        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/cinquenta.jpg"));
        Image img = Toolkit.getDefaultToolkit().getImage(acess.getUsuario().getCaminhoFoto());

        Mostre lblFoto = new Mostre();

        lblFoto.setIcon(new ImageIcon(img.getScaledInstance(30, 36, Image.SCALE_DEFAULT)));
        pnlFoto.add(BorderLayout.CENTER, lblFoto);

        Painel3 esquerda = new Painel3();
        esquerda.setLayout(new BorderLayout());

        esquerda.add(BorderLayout.WEST, new Painel3());
        esquerda.add(BorderLayout.EAST, new Painel3());
        esquerda.add(BorderLayout.CENTER, pnlFoto);
        esquerda.add(BorderLayout.SOUTH, new Painel3());
        esquerda.add(BorderLayout.NORTH, new Painel3());
        Painel3 baseInfo = new Painel3();
        baseInfo.setLayout(new MigLayout("align center, wrap 2"));
        Mostre2 lblNome = new Mostre2(acess.getUsuario().getNome());
        lblNome.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lblNome.setForeground(Cor.BRANCO);
        baseInfo.add(lblNome, "wrap");

        SimpleDateFormat dt = new SimpleDateFormat("HH:mm");
        String dh = dt.format(acess.getDataInicio());

        Mostre6 lblHoraInicio = new Mostre6(dh + "  ");
        lblHoraInicio.setForeground(Cor.BRANCO);
        lblHoraInicio.setFont(new Font("calibri", Font.BOLD, 16));

        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        String dh1 = dt1.format(acess.getDataInicio());
        Mostre6 lblData = new Mostre6(dh1);
        lblData.setForeground(Cor.BRANCO);
        lblData.setFont(new Font("calibri", Font.BOLD, 12));
        String dh2 = " ";
        try {
            dh2 = dt.format((acess.getDataFim()));
        } catch (Exception g) {

        }

        Mostre6 lblHoraFim = new Mostre6(dh2);
        lblHoraFim.setForeground(Cor.BRANCO);
        lblHoraFim.setFont(new Font("calibri", Font.BOLD, 16));

        Mostre cv = new Mostre("            ");
        cv.setForeground(Cor.BRANCO);
        cv.setFont(new Font("calibri", Font.BOLD, 16));

        baseInfo.add(lblData, "wrap");
        Painel3 jk = new Painel3();
        jk.setLayout(new BorderLayout());
        jk.add(BorderLayout.WEST, lblHoraInicio);
        jk.add(BorderLayout.CENTER, cv);
        jk.add(BorderLayout.EAST, lblHoraFim);

        baseInfo.add(jk);

        Painel3 direita = new Painel3();
        direita.setLayout(new BorderLayout());
        direita.add(BorderLayout.CENTER, baseInfo);

        Painel3 barra = new Painel3();
        barra.setBackground(Cor.BRANCO);
        barra.setPreferredSize(new Dimension(1, 1));

        a.add(BorderLayout.WEST, esquerda);
        a.add(BorderLayout.CENTER, direita);
        a.add(BorderLayout.SOUTH, barra);
//        a.add(BorderLayout.EAST, lblData);

        return a;
    }

    public static void main(String[] args) {
        Usu u = new Usu();
//        u.setNome("Válter Cinquenta Sitoe");
        ConfigAcess ac = new ConfigAcess();
//        ac.setUsuario(u);
        JFrame a = new JFrame();
        a.setDefaultCloseOperation(3);
        a.add(new Acesso_(ac));
        a.setVisible(true);
//        a.setPreferredSize(new Dimension(500, 500));
        a.pack();
    }
}
