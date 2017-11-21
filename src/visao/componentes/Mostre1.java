
package visao.componentes;

import java.awt.Color;
import java.awt.Font;

/**
 *Classe para moldar Label's com texto maior de todas, como a exibição do nome em Perfil por exemplo
 *  @see Mostre
 * @see Mostre1
 * @see Mostre3
 * @see Mostre2
 * @author 50enta
 */
public class Mostre1 extends Mostre{
    public Mostre1(){
        
    }
    public Mostre1(String txt){
        super(txt);
        this.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        this.setForeground(Cor.CINZA_ESCURO);
    }
}
