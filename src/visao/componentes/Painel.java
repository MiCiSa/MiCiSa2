/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Component;
import javax.swing.border.EtchedBorder;
import org.jdesktop.swingx.JXPanel;

/**
 * Painel mãe para todos os outros paineis, a sua cor padrão é branco
 *
 * @author 50enta
 */
public class Painel extends JXPanel {

    public Painel() {
        this.setBackground(Cor.BRANCO);
//        this.setBorder(new EtchedBorder());
    }

    public Painel(Component comp) {
        this.setBackground(Cor.BRANCO);
        this.setBorder(new EtchedBorder());
        this.add(comp);
    }

}
