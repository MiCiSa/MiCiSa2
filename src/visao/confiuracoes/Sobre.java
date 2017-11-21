/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.confiuracoes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import visao.Home;
import visao.Home1;
import visao.componentes.Cor;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Painel3;

/**
 *
 * @author 50enta
 */
public class Sobre extends Painel3 {

    public Sobre() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarGeral());
    }

    public Painel3 formatarCabecalho() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.LINE_AXIS));
        Mostre lblVoltar = new Mostre();
        lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
        Mostre2 lb = new Mostre2("Sobre ");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 22));
        lb.setForeground(Cor.BRANCO);
        Mostre2 i = new Mostre2("espa");
        a.add(i);
        a.add(lblVoltar);
        a.add(lb);
        lblVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaConfiguracoesInicio();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarP.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
            }

        });
        a.setPreferredSize(new Dimension(50, 50));
        return a;
    }

    public Painel3 formatarGeral() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.PAGE_AXIS));
        Painel3 b1 = new Painel3();
        a.add(new Painel3());
        a.add(new Categorias.MostreVerde("MiCiSa"));
        Painel3 b2 = new Painel3();
        a.add(new Categorias.MostreVerde("<html> Sisitema genérico, desenvolvido      para auxiliar no processo de gestão de recursos humanos</html>"));
        Painel3 b3 = new Painel3();
        b3.add(new Categorias.MostreVerde("versão: 2.0"));
        a.add(new Painel3());
        a.add(b3);
        a.add(new Painel3());
        
        a.add(new Painel3());
        a.add(new Painel3());
a.add(new Painel3());
        a.add(new Categorias.MostreVerde("Autores:"));
        a.add(new Categorias.MostreVerde("Micaela de Araújo Freitas"));
        a.add(new Categorias.MostreVerde("Válter Cinquenta Eusébio Sitoe"));
        a.add(new Categorias.MostreVerde("Samira Flávia Bezerra dos Santos"));
        a.add(new Painel3());
        return a;
    }
}
