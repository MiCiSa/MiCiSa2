/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Cargo;
import modelo.Categoria;
import modelo.Funcionario;
import modelo.Historico;
import visao.cadastro.Cad3;

/**
 * Classe que irá gerar o histórico de determinado funcionário, cada vez que for
 * pressionado
 *
 * @author 50enta
 */
public class ControloHistorico {

    public static List<Historico> gerarHistorico(Funcionario func) {
        List<Historico> hist = new ArrayList<>();
        //para categorias
        for (Categoria a : func.getCategorias()) {
            hist.add(new Historico("Categoria: " + a.getNome() + "  ", a.getDataDeAtribuicao(), a.getDataLargamento()));
        }

        //para supervisores
        for(Funcionario a1: Cad3.funcionarios.getFuncionario()){
            if(a1.getSupervisor().equals(func)){
                hist.add(new Historico("Supervisionou: "+a1.toString(), a1.getDataAdmissao(), new Date()));
            }
        }
        //para cargos
        for(Cargo a2: func.getCargos()){
            hist.add(new Historico("Função (cargo): "+"  "+a2.getCargo(), a2.getDataAtribuicao(), a2.getDataLargamento()));
        }
        
        //enfim
        return hist;

    }
}
