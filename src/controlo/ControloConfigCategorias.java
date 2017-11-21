/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import static controlo.ControloFuncionario.factory;
import java.util.List;
import java.util.Vector;
import modelo.config.ConfigCategoria;
import modelo.config.ConfigSubsidio;
import org.hibernate.Session;

/**
 *
 * @author 50enta
 */
public class ControloConfigCategorias {

    private static Vector<ConfigCategoria> categorias;

    public ControloConfigCategorias() {
        categorias = new Vector<>();
        actualizar(categorias);

    }

    public static boolean salvar(ConfigCategoria cargo) {
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        sessao.saveOrUpdate(cargo);

        sessao.getTransaction().commit();
        sessao.close();
        actualizar(categorias);
        return true;
    }

    public List<ConfigCategoria> pesquisarTodos() {
        List<ConfigCategoria> aux = new Vector<>();
        for (ConfigCategoria s : categorias) {
            if (s.isActivo()) {
                aux.add(s);
            }
        }
        return aux;
    }

    public ConfigCategoria pesquisar(String nome) {
        for (ConfigCategoria sub : this.pesquisarTodos()) {
            if (sub.getNome().equalsIgnoreCase(nome)) {
                return sub;
            }
        }
        return null;
    }

    public static boolean actualizar(Vector<ConfigCategoria> lista) {
        Session sessao = ControloFuncionario.factory.openSession();
        sessao.beginTransaction();

        lista.clear();
        for (ConfigCategoria a : (List<ConfigCategoria>) sessao.createCriteria(ConfigCategoria.class).list()) {
            lista.add(a);
        }

        sessao.getTransaction().commit();
        sessao.close();
        return true;
    }

    public boolean desactivar(Object objecto) {
           ((ConfigCategoria) objecto).setActivo(false);
        this.salvar((ConfigCategoria) objecto);
        return true;
    }

    public static Vector<ConfigCategoria> getCategorias() {
        Vector<ConfigCategoria> aux = new Vector<>();
        for (ConfigCategoria c : categorias) {
            if (c.isActivo() == true) {

                aux.add(c);
            }

        }
        return aux;
    }

    public static void setCategorias(Vector<ConfigCategoria> categorias) {
        ControloConfigCategorias.categorias = categorias;
    }

}
