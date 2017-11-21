/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * esta classe sera responsavel por formatar o componente herdado por ele
 * @author 50enta
 */
public class Botao2 extends Botao implements MouseListener{

    public Botao2(String cadastrar) {
        super(cadastrar);
        this.setFont(Fonte.CALIBRI_NORMAL);
        this.setForeground(Cor.CINZA_ESCURO);
        this.setBackground(Cor.CINZA_CLARO);
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.setBackground(Color.yellow);
    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
    
}
