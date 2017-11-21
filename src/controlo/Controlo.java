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
import org.hibernate.Session;

/**
 *
 * @author 50enta
 */
public class Controlo<T> {

    private Vector<T> dados;
    Class<?> tipoCalsse;

    /**
     * Construtor único, que obrigatoriamente recebe o tipo da classe que será o
     * controlo, para facilitar a busca de dados da base de dados
     *
     * @param classeTipo
     */
    public Controlo(Class<?> classeTipo) {
        this.tipoCalsse = classeTipo;
        dados = new Vector<>();
        actualizar(dados);
    }

    /**
     * Método para salvar os dados. Ao salvar salvar os dados na base de dados,
     * a lista contida qui na classe controle é actualizada, razão pela qual é
     * rem=comendado ter apenas uma única instãncia do controlo para cada
     * classe, para que os dados sejam sempre sincronizados
     *
     * @param cargo
     * @return
     */
    public boolean salvar(T cargo) {
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        sessao.saveOrUpdate(cargo);

        sessao.getTransaction().commit();
        sessao.close();
        actualizar(dados);
        return true;
    }

    /**
     * Tem a função de actualizar a lista de dados sempre que for necessário.
     *
     * @param lista
     * @return
     */
    private boolean actualizar(Vector<T> lista) {
        Session sessao = ControloFuncionario.factory.openSession();
        sessao.beginTransaction();

        lista.clear();
        for (T a : (List<T>) sessao.createCriteria(tipoCalsse).list()) {
            lista.add(a);
        }

        sessao.getTransaction().commit();
        sessao.close();
        return true;
    }

    public boolean desactivar(Object objecto) {
        ((ConfigCategoria) objecto).setActivo(false);
        this.salvar((T) objecto);
        return true;
    }

    public Vector<T> getDados() {
        Vector<T> aux = new Vector<>();
        for (T c : dados) {
            aux.add(c);
        }
        return aux;
    }

    private void setDados(Vector<T> dados) {
        this.dados = dados;
    }

}
