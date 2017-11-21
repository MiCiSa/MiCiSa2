/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Subclasse de JTextField, para receber valores do tipo texto (String)
 *
 * @see Introduza
 * @see Introduza1
 * @see Introduza2
 * @author 50enta
 */
public class Introduza1 extends Introduza implements KeyListener {

    public Introduza1(String txt){
        super(txt);
        this.addKeyListener(this);
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        String df = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ áéíóú ÚÁÉÍÓ ÃÕ Ç ç ãõ ê Ê";
        if (!df.contains(Character.toString(ke.getKeyChar()))) {
            //  if (ke.getSource() != CadTela1.txtEmail) {
            ke.consume();
            // }
        } else {

        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
