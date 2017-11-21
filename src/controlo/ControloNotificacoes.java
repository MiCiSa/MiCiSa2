/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import static controlo.ControloFuncionario.factory;
import java.util.List;
import java.util.Vector;
import modelo.Notificacao;
import modelo.config.ConfigCargo;
import org.hibernate.Session;

/**
 *
 * @author 50enta
 */
public class ControloNotificacoes {

    public static Vector<Notificacao> notificacoes;

    public ControloNotificacoes() {
        notificacoes = new Vector<>();
        actualizar(notificacoes);

    }

    public static boolean salvar(Notificacao cargo) {
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        sessao.saveOrUpdate(cargo);

        sessao.getTransaction().commit();
        sessao.close();
        actualizar(notificacoes);
        return true;
    }

    public List<Notificacao> pesquisarTodos() {
        return notificacoes;
    }

    public static boolean actualizar(Vector<Notificacao> lista) {
        Session sessao = ControloFuncionario.factory.openSession();
        sessao.beginTransaction();

        lista.clear();
        for (Notificacao a : (List<Notificacao>) sessao.createCriteria(Notificacao.class).list()) {
            lista.add(a);
        }

        sessao.getTransaction().commit();
        sessao.close();
        return true;
    }

    public boolean desactivar(Object objecto) {
        ((Notificacao) objecto).setActivo(false);
        this.salvar((Notificacao) objecto);
        return true;
    }

    public static Vector<Notificacao> getNotificacoes() {
        Vector<Notificacao> not = new Vector<>();
        for (Notificacao a : notificacoes) {
            if (a.isActivo()) {
                not.add(a);
            }
        }
        return not;
    }

    public static void setNotificacoes(Vector<Notificacao> notificacoes) {
        ControloNotificacoes.notificacoes = notificacoes;
    }

}
