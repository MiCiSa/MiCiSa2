/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

/**
 *Classe para moldar Label's com texto maior de segunda ordem, como a exibição do painel Funcionários por exemplo
 *  @see Mostre
 * @see Mostre1
 * @see Mostre3
 * @see Mostre2
 * @author 50enta
 */
public class Mostre2 extends Mostre{
    public Mostre2(){
        this.setFont(Fonte.COMIC_SANS_MS);
        this.setForeground(Cor.VERDE);
    }
    public Mostre2(String t){
        super(t);
         this.setFont(Fonte.COMIC_SANS_MS);
         this.setForeground(Cor.VERDE);
    }
}
