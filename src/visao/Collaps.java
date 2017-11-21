/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.jdesktop.swingx.JXCollapsiblePane;
import visao.componentes.Botao;
import visao.componentes.Mostre;
import visao.componentes.Painel;
import visao.componentes.Painel2;

/**
 *
 * @author 50enta
 */
public class Collaps extends Painel {
    
    Painel painel1 = new Painel();
    Painel2 painel2 = new Painel2();
    Botao btn = new Botao("Clicar");
    
    JXCollapsiblePane col = new JXCollapsiblePane(JXCollapsiblePane.Direction.LEFT);
    
    public Collaps() {
        col.setCollapsed(true);
        col.setLayout(new BorderLayout());
        col.add(painel2);
        
     
        painel1.add(new Mostre(new ImageIcon(new Home().getClass().getResource("imagens/micisa.png"))));
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.EAST, col);
        this.add(BorderLayout.CENTER, painel1);
        this.add(BorderLayout.SOUTH, btn);
           painel2.setPreferredSize(new Dimension(300, 100));
           
        btn.addActionListener(col.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION));
    }
    
    public static void main(String[] args) {
        JFrame a = new JFrame();
        a.setDefaultCloseOperation(3);
        a.add(new Collaps());
        a.setVisible(true);
        a.setPreferredSize(new Dimension(500, 500));
        a.pack();
    }
}
