/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author 50enta
 */
public class Introduza extends JTextField implements FocusListener {

    //atributos
    private String texto;

    public Introduza() {
       this.setPreferredSize(new Dimension(140, 25));
        this.setForeground(new Color(182, 182, 182));
        this.setCaretColor(new Color(182, 182, 182));
        this.addFocusListener(this);
    }

    public Introduza(String txt, int j) {
        super(txt, j);
        this.setTexto(txt);
        this.setPreferredSize(new Dimension(140, 25));
        this.setForeground(new Color(182, 182, 182));
        this.setCaretColor(new Color(182, 182, 182));
        this.addFocusListener(this);
    }

    public Introduza(String texto) {
        super(texto);
        this.setTexto(texto);
        this.setPreferredSize(new Dimension(140, 25));
        this.setForeground(new Color(182, 182, 182));
        this.setCaretColor(new Color(182, 182, 182));
        this.addFocusListener(this);

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;

    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (this.getTexto().equalsIgnoreCase(this.getText())) {
            this.setText("");
            this.setForeground(Cor.PRETO);
        } else {

        }

    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (this.getText().equalsIgnoreCase("")) {
            this.setText(this.getTexto());
            this.setForeground(new Color(182, 182, 182));
        } else {

        }
    }

}
