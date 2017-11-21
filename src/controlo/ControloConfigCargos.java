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
import org.hibernate.Session;

/**
 *
 * @author 50enta
 */
public class ControloConfigCargos {

    public static Vector<ConfigCargo> cargos;

    public ControloConfigCargos() {
        cargos = new Vector<>();
        actualizar(cargos);

    }

    public static boolean salvar(ConfigCargo cargo) {
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        sessao.saveOrUpdate(cargo);

        sessao.getTransaction().commit();
        sessao.close();
        actualizar(cargos);
        return true;
    }

    public List<ConfigCargo> pesquisarTodos() {
         List<ConfigCargo> aux = new Vector<>();
         for(ConfigCargo s : cargos){
             if(s.isActivo()){
                 aux.add(s);
             }
         }
        
        return aux;
    }

    public static boolean actualizar(Vector<ConfigCargo> lista) {
        Session sessao = ControloFuncionario.factory.openSession();
        sessao.beginTransaction();

        lista.clear();
        for (ConfigCargo a : (List<ConfigCargo>) sessao.createCriteria(ConfigCargo.class).list()) {
            lista.add(a);
        }

        sessao.getTransaction().commit();
        sessao.close();
        return true;
    }

    public boolean desactivar(Object objecto) {
        ((ConfigCargo) objecto).setActivo(false);
        this.salvar((ConfigCargo) objecto);
        return true;
    }

    public static Vector<ConfigCargo> getCargos() {
        Vector<ConfigCargo> aux = new Vector<>();
         for(ConfigCargo s : cargos){
             if(s.isActivo()){
                 aux.add(s);
             }
         }
        
        return aux;
        
    }

    public static void setCargos(Vector<ConfigCargo> cargos) {
        ControloConfigCargos.cargos = cargos;
    }

}
