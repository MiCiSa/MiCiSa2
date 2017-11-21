/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Subclasse de JTextField, para receber valores numéricos
 *
 * @see Introduza
 * @see Introduza1
 * @see Introduza2
 * @author 50enta
 */
public class Introduza2 extends Introduza implements KeyListener {

     public Introduza2(String txt){
        super(txt);
        this.addKeyListener(this);
    }
     public Introduza2(String txt, int j){
         super(txt,j);
         this.addKeyListener(this);
     }
    
    //eventos do teclado
    @Override
    public void keyTyped(KeyEvent ke) {
        if (!(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') && (ke.getKeyChar() != '.') && (ke.getKeyChar() != ',')) {
            ke.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
