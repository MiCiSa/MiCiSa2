/*
 * Esta clase é sublclasse da classe JFrame 
 * serve para instanciar os principas botoes usados neste sistema
 * inicializa a instancia de cada botão com as algumas caraceristicas
 *  que todos objectos terão em comum
 */
package visao.componentes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import visao.ControleAcessos;

public class Parede extends JFrame {
    //atributos

    //construtores
    public Parede(String a) {
        super(a);//título da janela
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                super.windowClosing(we);
                int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo fechar? ");
                if (i == JOptionPane.YES_OPTION) {
//                    try {
                        ControleAcessos.usuarioActual.sair();
//                    } catch (NullPointerException s) {}
                    dispose();
                    System.exit(0);
                }
            }
        });
    }

    public Parede() { //Construtor vazio

    }

    @Override
    public void setDefaultCloseOperation(int i) {
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public synchronized void addWindowListener(WindowEvent wl) {
        if (wl.getID() == WindowEvent.WINDOW_CLOSING) {
            int op = JOptionPane.showConfirmDialog(null, "Deseja sair realmente? ");
            if (op == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
