package visao.componentes;

import javax.swing.JCheckBox;

/**
 *
 * @author 50enta
 */
public class Checagem extends JCheckBox {

    public Checagem() {
        this.setBackground(Cor.BRANCO);
        this.setForeground(Cor.CINZA_ESCURO);
        this.setFont(Fonte.CALIBRI_NORMAL);
    }

    public Checagem(String subs_Transporte) {
        super(subs_Transporte);
        this.setBackground(Cor.BRANCO);
        this.setForeground(Cor.CINZA_ESCURO);
        this.setFont(Fonte.CALIBRI_NORMAL);
    }

    public Checagem(String a, boolean c) {
        super(a, c);
        this.setBackground(Cor.BRANCO);
        this.setForeground(Cor.CINZA_ESCURO);
        this.setFont(Fonte.CALIBRI_NORMAL);
    }
}
