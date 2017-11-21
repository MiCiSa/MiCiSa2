/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import net.miginfocom.swing.MigLayout;

/**
 * Este painel é referente ao título, a ideia é fcilitar o processo de
 * títitulos, dai que passamos o tútulo como parametro e a classe trata de tudo
 * o resto
 *
 * @author 50enta
 */
public class Painel4 extends Painel {

    Mostre3 lblTitulo;

    public Painel4(String titulo, boolean a) {
        lblTitulo = new Mostre3(titulo);
        lblTitulo.setFont(Fonte.CALIBRI_NORMAL);
        lblTitulo.setForeground(Cor.BRANCO);
        this.setBackground(new Color(128, 171, 198));
        this.setLayout(new MigLayout("align left"));
        this.add(lblTitulo);
    }

    public Painel4(String titulo, Color cor) {
        this.setPreferredSize(new Dimension(50, 30));
        lblTitulo = new Mostre3(titulo);
        lblTitulo.setFont(Fonte.CALIBRI_NORMAL);
        lblTitulo.setForeground(Cor.BRANCO);
        this.setBackground(cor);
        this.setLayout(new MigLayout("align center"));
        this.add(lblTitulo);
    }

}
