/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JWindow;
import visao.componentes.Mostre;

/**
 *
 * @author 50enta
 */
public class VerFoto extends JWindow {

    private String caminhoFoto;
    private Mostre lblFoto = new Mostre();

    //construtores
    public VerFoto(String caminhoFoto) {
        this.setCaminhoFoto(caminhoFoto);
        this.requestFocus();

        Image img = Toolkit.getDefaultToolkit().getImage(this.getCaminhoFoto());
        lblFoto.setIcon(new ImageIcon(img.getScaledInstance(400, 500, Image.SCALE_FAST)));

        //propriedades iniciais
        this.add(lblFoto);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);

        //definições de fechamento
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    dispose();
                }
            }

        });
        this.addFocusListener(new FocusListener() {
            private boolean foco = false;

            @Override
            public void focusGained(FocusEvent fe) {
                foco = true;
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (foco) {
                    dispose();
                }
            }
        });

    


      

    }
                

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

  
}
