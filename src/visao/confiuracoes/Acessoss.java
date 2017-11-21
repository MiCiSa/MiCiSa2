
package visao.confiuracoes;

import controlo.ControloConfigAcessos;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import modelo.config.ConfigAcess;
import visao.Acesso_;
import visao.Home;
import visao.Home1;
import visao.componentes.Cor;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Painel;
import visao.componentes.Painel3;
import visao.componentes.Rolagem;

/**
 *
 * @author 50enta
 */
public class Acessoss extends Painel3 {

    public static Painel3 pnlAcessos = new Painel3();

    public Acessoss() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarGeral());
    }

    public Painel3 formatarCabecalho() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.LINE_AXIS));
        Mostre lblVoltar = new Mostre();
        lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
        Mostre2 lb = new Mostre2("Acessos ao sistema");
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

    public Painel formatarGeral() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.NORTH, new Painel3());
        a.add(BorderLayout.EAST, new Painel3());
        a.add(BorderLayout.WEST, new Painel3());
        a.add(BorderLayout.SOUTH, new Painel3());
        a.add(BorderLayout.CENTER, formatarBase());
        return a;
    }

    public Painel formatarBase() { //incui o painel notificacoes
        Painel a = new Painel();
        pnlAcessos.setLayout(new BorderLayout());
        //
        //
        Painel3 pess = new Painel3();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        for (ConfigAcess u : ControloConfigAcessos.getAcessos()) {
            pess.add(new Acesso_(u));
        }
        pnlAcessos.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        //
        //
        //
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.CENTER, new Rolagem(pnlAcessos));
        a.add(BorderLayout.EAST, new Painel3());
        a.add(BorderLayout.WEST, new Painel3());
        a.add(BorderLayout.NORTH, new Painel3());
        a.add(BorderLayout.SOUTH, new Painel3());
        return a;
    }
}
