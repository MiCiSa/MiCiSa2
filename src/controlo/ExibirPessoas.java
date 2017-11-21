/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import modelo.Funcionario;
import modelo.Status;
import visao.Home1;
import visao.People;
import visao.cadastro.Cad3;
import visao.componentes.Painel;
import visao.componentes.Painel1;
import visao.componentes.Rolagem;

/**
 * Formas de classsificaçõ a exibição dos dados... entre outros
 *
 * @author 50enta
 */
public class ExibirPessoas {

    
    /**
     * Metodo estatico responsavel por organizar a lista dos funcionarios
     */
    public static void actualizar() {
        Home1.pnlPessoas.removeAll();
        Home1.pnlPessoas.repaint();
        Painel pess = new Painel1();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        Cad3.funcionarios.pesquisarTodos().forEach((func) -> {
            pess.add(new People(func));
        });
        Home1.pnlPessoas.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        Home1.pnlPessoas.revalidate();

    }
/**
 * metodo estatico responsavel  por organizar a lista dos 
 * funcionarios com base nos funcionarios activos
 */
    public static void actualizarActivos() {
        Home1.pnlPessoas.removeAll();
        Home1.pnlPessoas.repaint();
        Painel pess = new Painel1();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        Cad3.funcionarios.pesquisarTodos().forEach((func) -> {
            if (func.getStatus() != null) {
                if (func.getStatus().equalsIgnoreCase(Status.ACTIVO)) {
                    pess.add(new People(func));
                }
            }
        });
        Home1.pnlPessoas.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        Home1.pnlPessoas.revalidate();
    }
/**
 * metodo estatico responsavel  por organizar a lista dos 
 * funcionarios com base nos funcionarios demitidos
 */
    public static void actualizarDeimitidos() {
        Home1.pnlPessoas.removeAll();
        Home1.pnlPessoas.repaint();
        Painel pess = new Painel1();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        Cad3.funcionarios.pesquisarTodos().forEach((func) -> {
            if (func.getStatus() != null) {
                if (func.getStatus().equalsIgnoreCase(Status.DEMITIDO)) {
                    pess.add(new People(func));
                }
            }
        });
        Home1.pnlPessoas.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        Home1.pnlPessoas.revalidate();
    }
/**
 * metodo estatico responsavel  por organizar a lista dos 
 * funcionarios com base nos funcionarios ferias
 */
    public static void actualizarFerias() {
        Home1.pnlPessoas.removeAll();
        Home1.pnlPessoas.repaint();
        Painel pess = new Painel1();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        Cad3.funcionarios.pesquisarTodos().forEach((func) -> {
            if (func.getStatus() != null) {
                if (!func.getStatus().equalsIgnoreCase(Status.DEMITIDO)
                        && !func.getStatus().equalsIgnoreCase(Status.LICENCA_DE_PARTO)
                        && !func.getStatus().equalsIgnoreCase(Status.SUSPENSO)
                        && !func.getStatus().equalsIgnoreCase(Status.REFORMA)) {
                    pess.add(new People(func));
                }
            }
        });
        Home1.pnlPessoas.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        Home1.pnlPessoas.revalidate();
    }
/**
 * metodo estatico responsavel  por organizar a lista dos 
 * funcionarios com base nos funcionarios em que a empresa nao paga salario
 */
    public static void actualizarSalarios() {
        Home1.pnlPessoas.removeAll();
        Home1.pnlPessoas.repaint();
        Painel pess = new Painel1();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        Cad3.funcionarios.pesquisarTodos().forEach((func) -> {
            if (func.getStatus() != null) {
                if (!func.getStatus().equalsIgnoreCase(Status.DEMITIDO)
                        && !func.getStatus().equalsIgnoreCase(Status.LICENCA_DE_PARTO)
                        && !func.getStatus().equalsIgnoreCase(Status.REFORMA)) {
                    pess.add(new People(func));
                }
            }
        });
        Home1.pnlPessoas.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        Home1.pnlPessoas.revalidate();
    }
     
    /**
     * este metodo chama o metodo actualizarActivos em que organiza a lista dos funcionarios activos
     */
    public static void actualizarAusencias() {
        actualizarActivos();
    }

}
