/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import static controlo.ControloFuncionario.factory;
import java.util.List;
import java.util.Vector;
import modelo.config.ConfigAcess;
import org.hibernate.Session;

/**
 *
 * @author 50enta
 */
public class ControloConfigAcessos {

    private static Vector<ConfigAcess> acessos;

    public ControloConfigAcessos() {
        acessos = new Vector<>();
        actualizar(acessos);

    }

    public static boolean salvar(ConfigAcess cargo) {
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        sessao.saveOrUpdate(cargo);

        sessao.getTransaction().commit();
        sessao.close();
        actualizar(getAcessos());
        return true;
    }

    public List<ConfigAcess> pesquisarTodos() {
        return getAcessos();
    }

    public static boolean actualizar(Vector<ConfigAcess> lista) {
        Session sessao = ControloFuncionario.factory.openSession();
        sessao.beginTransaction();

        lista.clear();
        for (ConfigAcess a : (List<ConfigAcess>) sessao.createCriteria(ConfigAcess.class).list()) {
            lista.add(a);
        }

        sessao.getTransaction().commit();
        sessao.close();
        return true;
    }

    public boolean desactivar(Object objecto) {
//        ((ConfigAcess) objecto).setActivo(false);
        this.salvar((ConfigAcess) objecto);
        return true;
    }

    /**
     * @return the acessos
     */
    public static Vector<ConfigAcess> getAcessos() {
        return acessos;
    }

    /**
     * @param aAcessos the acessos to set
     */
    public static void setAcessos(Vector<ConfigAcess> aAcessos) {
        acessos = aAcessos;
    }

}
