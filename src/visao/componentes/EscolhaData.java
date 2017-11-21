/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import visao.Home;

/**
 *
 * @author 50enta
 */
public class EscolhaData extends JDateChooser {

    public EscolhaData() {
        this.setPreferredSize(new Dimension(140, 25));
        this.setBackground(Cor.BRANCO);
        this.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/calendarioP.png")));
        //this.setDateFormatString("YYYY-MM-dd");
    }
}
