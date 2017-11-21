/*Esta é a janela principal, onde serão adicionados todos outros componentes, janelas entre outros
 * esta classe herda componentes da classe Parede, que por sua vez herda da classe JFrame e dispõe de todas propriedades iniciais
 *
 */
package visao;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import visao.componentes.Painel;
import visao.componentes.Parede;

public class JanelaPrincipal extends Parede {
//atributos    

    public static Painel controlador = new Painel(); //Painel que receberá o cardLayout para o controle entre Home e a tela do menú
    public static CardLayout cartao = new CardLayout(); //

    //intâncias a serem adicionadas ao controlador
    Home iHome = new Home();
    Home1 iHome1 = new Home1();
    //construtor

    public JanelaPrincipal() {
        super("Gestão de Recuros Humanos"); //titulo da janela/Parede
        URL url = getClass().getResource("imagens/icomoonP.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        controlador.setLayout(cartao);
        controlador.add(iHome, "1"); //adiciona o painel Home1 ao cntrolador 
        controlador.add(iHome1, "2"); //adiciona o painel Home ao controlador

        //provisório - para testes
        cartao.show(controlador, "1");

        this.add(controlador); //adiciona o controlador à parede

        //this.setResizable(false);
        this.setSize(1000, 690); // coordenadas da dimensão do painel
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    //método para mudar de tela
    public static void mudarParaHome1() {
        JanelaPrincipal.cartao.show(controlador, "2");
    }

    public static void mudarParaHome() {
        JanelaPrincipal.cartao.show(controlador, "1");
    }

//método main - provisório
//    public static void main(String[] args) {
//        // Propriedades look and feel
//        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//            if ("Windows".equals(info.getName())) {
////                if ("Nimbus".equals(info.getName())) {
//                try {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                }
//                break;
//            }
//        }
//
//        new JanelaPrincipal();
//    }

}
