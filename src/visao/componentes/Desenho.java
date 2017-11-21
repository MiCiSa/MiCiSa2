/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visao.Home;

/**
 * Algoritimo do desenho da tela inicial
 *
 * @author 50enta
 */
public class Desenho extends Painel1 {
   

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Cor.CINZA_TEXTO);
        for (int i = 0; i < 21; i++) {
            g.drawRect(10 + i * 10, 10 + i * 10,
                    50 + i * 10, 50 + i * 10);
            switch (i % 2) {
                case 0:
                    g.setColor(Cor.BRANCO);
                    break;
                case 1:
                    g.setColor(Cor.VERDE);
                    break;
            }
        }
    }

}
