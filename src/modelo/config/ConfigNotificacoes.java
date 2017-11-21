/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.config;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ferias;
import modelo.Funcionario;
import modelo.Notificacao;
import visao.cadastro.Cad3;

/**
 *
 * @author 50enta
 */
public class ConfigNotificacoes {

    /**
     * Responsável por procurar notificações e salv'-las na base de dados, cada
     * vezque achar
     *
     * @param func
     * @return
     */
    public static void procurarNotificacoes(List<Funcionario> todosFuncs) {

        for (Funcionario func : todosFuncs) {
            //faltando 3 dias para ir de férias

            Ferias ferias = func.getFerias(new Date().getYear() + 1900);
            try {
                if (ferias != null) {
                    long dias = Ferias.diferencaEntreDatas(new Date(), ferias.getDataInicio());

                    if (dias <= 3 && dias >= 0) {
                        Notificacao not = new Notificacao();
                        not.setTexto(" deverá ir de férias em " + dias + " dias e regressará em " + ferias.getDataFim());
                        not.setFuncionarioEmCausa(func);
                        if (!existe(not)) {
                            Cad3.notificacoes.salvar(not);
                        }
                    }

                    //faltando 3 dias para regressar de férias
                    long dias1 = Ferias.diferencaEntreDatas(new Date(), ferias.getDataFim());
                    if (dias1 <= 3 && dias1 >= 0) {
                        Notificacao not = new Notificacao();
                        not.setTexto(" deverá regressar de férias em " + dias1 + " em dias e regressará em " + ferias.getDataFim());
                        not.setFuncionarioEmCausa(func);
                        if (!existe(not)) {
                            Cad3.notificacoes.salvar(not);
                        }
                    }
                }
                // faltando 3 dias para mudar categoria
                if (func.getCategoria() != null) {
                    long dias2 = Ferias.diferencaEntreDatas(new Date(), func.getCategoria().getDataDeAtribuicao());
                    if (dias2 >= 1040 && dias2 <= 1090) {
                        Notificacao not = new Notificacao();
                        not.setTexto(" deverá mudar de categoria em " + dias2 + " dias, a nova categoria será valida até 3 anos ");
                        not.setFuncionarioEmCausa(func);
                        if (!existe(not)) {
                            Cad3.notificacoes.salvar(not);
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(ConfigNotificacoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean existe(Notificacao not) {
        for (Notificacao a : Cad3.notificacoes.pesquisarTodos()) {
            if (a.getTexto().equalsIgnoreCase(not.getTexto()) && !a.isActivo()) {
                return true;
            }
        }
        return false;
    }
}
