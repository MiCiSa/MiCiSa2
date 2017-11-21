/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author 50enta
 */
public class Escolha extends JComboBox {

    //construtor
    public Escolha() {
        this.setPreferredSize(new Dimension(140, 22));
        this.setBackground(Cor.BRANCO);
        this.setFont(Fonte.CALIBRI_NORMAL);
        this.setForeground(Cor.CINZA_ESCURO);
    }

    public Escolha(String[] a) {
        super(a);
        this.setPreferredSize(new Dimension(150, 30));
        this.setBackground(Cor.BRANCO);
        this.setFont(Fonte.CALIBRI_NORMAL);
        this.setForeground(Cor.CINZA_ESCURO);
    }

    public Escolha(Object[] a) {
        for (Object g : a) {
            this.addItem(g);
        }

        this.setPreferredSize(new Dimension(150, 30));
        this.setBackground(Cor.BRANCO);
        this.setFont(Fonte.CALIBRI_NORMAL);
        this.setForeground(Cor.CINZA_ESCURO);
    }

    public Escolha(DefaultComboBoxModel a) {
        super(a);
        this.setPreferredSize(new Dimension(150, 30));
        this.setBackground(Cor.BRANCO);
        this.setFont(Fonte.CALIBRI_NORMAL);
        this.setForeground(Cor.CINZA_ESCURO);
    }
    //utros metodos
}
