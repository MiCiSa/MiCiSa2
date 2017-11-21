/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Classe mãe para exibição de textos em Label's.
 *
 * @see Mostre
 * @see Mostre1
 * @see Mostre3
 * @see Mostre2
 * @author 50enta
 */
public class Mostre extends JLabel {
    
    public Mostre() {
        this.setBackground(Cor.BRANCO);
    }
    
    public Mostre(String texto) {
        super(texto);
        this.setFont(new Font("calibri", Font.PLAIN, 1));
    }

    public Mostre(ImageIcon a) {
        super(a);
    }
    
}
