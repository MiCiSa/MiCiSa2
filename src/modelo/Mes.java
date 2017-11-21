
package modelo;

/**
 * Interface para moldar todos os meses, ou seja, a informação que será
 * controlada mensalmente
 *
 * @author 50enta
 */
public interface Mes {

    /**
     * Para facilitar a identificação de um determinado mês, dado o seu
     * correspondente em inteiro e o contexto em que for utilizado
     *
     * @param mes
     * @return
     */
    public Mes getMes(int mes);

}
