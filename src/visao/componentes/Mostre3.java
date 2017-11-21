/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

/**
 * Classe para moldar Label's com texto médio de terceira ordem, como a exibição
 * dos títulos em painel títulos por exemplo
 *
 * @see Mostre
 * @see Mostre1
 * @see Mostre3
 * @see Mostre2
 *
 * @author 50enta
 */
public class Mostre3 extends Mostre {

    public Mostre3() {
        this.setFont(Fonte.TIMES_NEW_ROMAN);
        this.setForeground(Cor.CINZA_TEXTO);
    }

    public Mostre3(String h) {
        super(h);
        this.setFont(Fonte.TIMES_NEW_ROMAN);
        this.setForeground(Cor.CINZA_TEXTO);

    }
}
