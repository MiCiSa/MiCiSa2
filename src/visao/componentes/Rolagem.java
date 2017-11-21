/*
 * Esta clase é sublclasse da classe JScrollBar 
 * serve para instanciar os principas botoes usados neste sistema
 * inicializa a instancia de cada botão com as algumas caraceristicas
 *  que todos objectos terão em comum
 */
package visao.componentes;

import static java.awt.Color.white;
import java.awt.Component;
import javax.swing.JScrollPane;

public class Rolagem extends JScrollPane {
    // atributos

    //construtores
    public Rolagem(Component a) {
        super(a);
        this.setBorder(null);
        this.setBackground(white);

    }

    public Rolagem() {
        this.setBorder(null);
        this.setBackground(white);
    }

    public Rolagem(Component a, int b, int c) {
        super(a, b, c);
        this.setBorder(null);
        this.setBackground(white);
    }

}
