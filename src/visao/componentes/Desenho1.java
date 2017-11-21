/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import visao.Home1_.Home1Estatistica;
import visao.componentes.Cor;
import visao.componentes.Fonte;
import visao.componentes.Painel;

/**
 *
 * @author admin
 */
public class Desenho1 extends Painel {

    private Color cor;
    public String numero;
    public Desenho1(String num,Color c) {
        this.numero = num;
        this.cor = c;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(cor);
        g.fillArc((int) (Home1Estatistica.bolaEsquerda.getWidth() * 0.1), (int) (Home1Estatistica.bolaEsquerda.getHeight() * 0.1), (int) (Home1Estatistica.bolaEsquerda.getWidth() * 0.8), (int) (Home1Estatistica.bolaEsquerda.getWidth() * 0.8) - 7, 100, 360);
        g.setColor(Cor.BRANCO);
        g.fillArc((int) (Home1Estatistica.bolaEsquerda.getWidth() * 0.1) + 10, (int) (Home1Estatistica.bolaEsquerda.getHeight() * 0.1) + 10, (int) (Home1Estatistica.bolaEsquerda.getWidth() * 0.8) - 5 - 5 - 10, (int) (Home1Estatistica.bolaEsquerda.getWidth() * 0.8) - 7 - 10 - 10, 100, 360);
       g.setColor(cor);
       g.setFont(Fonte.COMIC_SANS_MS);
        g.drawString(numero, (int) (Home1Estatistica.bolaEsquerda.getWidth() * 0.433), (int) (Home1Estatistica.bolaEsquerda.getHeight() * 0.35) );
    }

}
