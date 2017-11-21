/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import modelo.Funcionario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import visao.ControleAcessos;

/**
 *
 * @author 50enta
 */
public class ControloFuncionario {

    public static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static Vector<Funcionario> funcionario;

    public ControloFuncionario() {
        funcionario = new Vector();
        funcionario = actualizarLista();
    }

    public static boolean salvar(Object objecto) {
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        sessao.saveOrUpdate(objecto);

        sessao.getTransaction().commit();
        sessao.close();
        funcionario = actualizarLista();
        switch (ControleAcessos.painelActual) {
            case 1:
                ExibirPessoas.actualizarAusencias();
                break;
            case 2:
                ExibirPessoas.actualizarFerias();
                break;
            case 3:
                ExibirPessoas.actualizarSalarios();
                break;
            default:
                ExibirPessoas.actualizar();
                break;
        }

        return true;
    }

    public static Object pesquisar(String nome) { //a pesquisa é feita na lista
        for (Funcionario a : funcionario) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    public List<Funcionario> pesquisarTodos() {
        return funcionario;
    }

    public static boolean desactivar(Object objecto) {

        return true;
    }

    public static Vector<Funcionario> actualizarLista() {
        Vector<Funcionario> lista = new Vector<>();
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        lista.clear();
        for (Funcionario a : (List<Funcionario>) sessao.createCriteria(Funcionario.class).list()) {
            lista.add(a);
        }

        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }

    /**
     * Gera um codigo que resultda da concatenação do ano em causa (actual) e um
     * número gerado aleatoriamente e compreendido entre 100 à 999
     *
     * @return
     */
    public static int gerarCodigo() {
        Vector<Integer> codigosAnteriores = new Vector<>();
        for (Funcionario func : funcionario) {
            codigosAnteriores.add(func.getCodigo());
        }
        int cod;
        //gerar novo codigo
        do {
            cod = ((100 + (int) (Math.random() * 900)));
            String df = Integer.toString(new Date().getYear() + 1900) + cod;
            cod = Integer.parseInt(df);
            if (!codigosAnteriores.contains(cod)) {
                break;
            }
        } while (true);
        return cod;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public Vector<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Vector<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

}
