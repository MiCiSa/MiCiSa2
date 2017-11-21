/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import static controlo.ControloFuncionario.factory;
import java.util.List;
import java.util.Vector;
import modelo.config.ConfigCargo;
import modelo.config.ConfigSubsidio;
import org.hibernate.Session;

/**
 *Esta classe ser responsavel por fazer o controlo de todas categorias do sistema,
 * buscando os dados da base de dados e moldar na tela
 * @author 50enta
 */
public class ControloConfigSubsidios {

    private static Vector<ConfigSubsidio> subsidios;
/**
 * Construtor da classe que instancia subsidios e inicializa a lista
 */
    public ControloConfigSubsidios() {
        subsidios = new Vector<>();
        actualizar(subsidios);

    }
/**
 * Metodo estatico que sera responsavel por salvar os dados na base de dados e 
     colocar os dados dos subsidios na lista
 * @param cargo
 * @return 
 */
    public static boolean salvar(ConfigSubsidio cargo) {
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        sessao.saveOrUpdate(cargo);

        sessao.getTransaction().commit();
        sessao.close();
        actualizar(getSubsidios());
        return true;
    }
    
    /**
     * este metodo sera responsavel por retornar uma lista que contem subsidios activos 
     * @return 
     */

    public List<ConfigSubsidio> pesquisarTodos() {
        List<ConfigSubsidio> aux = new Vector<>();
        for(ConfigSubsidio s : subsidios){
            if(s.isActivo()){
                aux.add(s);
            }
        }
        
        return aux;
    }

    /**
     * metodo responsavel por fazer uma pesquisa atraves dum atributo e
     * por sua vez retornar os dados de tal subsidio
     * @param nome
     * @return 
     */
    public ConfigSubsidio pesquisar(String nome) {
        for (ConfigSubsidio sub : this.pesquisarTodos()) {
            if (sub.getNome().equalsIgnoreCase(nome)) {
                return sub;
            }
        }
        return null;
    }
    /**
     * metodo estatico que buscara os dados da base de dados e colocar na estrutura de dados 
     * @param lista
     * @return 
     */

    public static boolean actualizar(Vector<ConfigSubsidio> lista) {
        Session sessao = ControloFuncionario.factory.openSession();
        sessao.beginTransaction();

        lista.clear();
        for (ConfigSubsidio a : (List<ConfigSubsidio>) sessao.createCriteria(ConfigSubsidio.class).list()) {
            lista.add(a);
        }

        sessao.getTransaction().commit();
        sessao.close();
        return true;
    }
    /**
     * metodo responsavel por desativar um determinado subsidio, isto e, 
     * eliminar a sua vizualicacao na aplicacao
     * @param objecto
     * @return 
     */

    public boolean desactivar(Object objecto) {
        ((ConfigSubsidio) objecto).setActivo(false);
        this.salvar((ConfigSubsidio) objecto);
        return true;
    }

    /**metodo estatico que retorna uma lista de todos os subsidios activos
     * @return the subsidios
     */
    public static Vector<ConfigSubsidio> getSubsidios() {
         Vector<ConfigSubsidio> aux = new Vector<>();
         for(ConfigSubsidio s : subsidios ){
             if(s.isActivo()== true){
                 aux.add(s);
             }
         }
        return aux;
    }

    /** metodo estatico que vai modificar os subsidios contidos na lista
     * @param aSubsidios the subsidios to set
     */
    public static void setSubsidios(Vector<ConfigSubsidio> aSubsidios) {
        subsidios = aSubsidios;
    }

}
