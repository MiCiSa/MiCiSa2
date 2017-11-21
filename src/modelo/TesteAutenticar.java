/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import visao.ControleAcessos;
import visao.cadastro.Cad3;

/**
 * Classe que serve para autenticar
 *
 * @author 50enta
 */
public class TesteAutenticar {

    public static boolean autenticar(String senha, String usuario) {
        //vai buscar os usuarios da bd para autenticacao
        for (Funcionario func : Cad3.funcionarios.getFuncionario()) {
            try {
                Usu usu = func.getUsuario();
                if (usu != null) {
                    if (usu.isActivo()) {
                        if (senha == null && usuario == null) {
                            ControleAcessos.usuarioActual = func;
                            if (ControleAcessos.usuarioActual != null) {
                                ControleAcessos.usuarioActual.entrar();
                            }
                        }

                        if (usu.getUsuario().equalsIgnoreCase(usuario)
                                && usu.getSenha().equalsIgnoreCase(senha)) {
//                    if ("".equalsIgnoreCase(usuario)
//                            && "".equalsIgnoreCase(senha)) {
                            ControleAcessos.usuarioActual = func;
                            if (ControleAcessos.usuarioActual != null) {
                                ControleAcessos.usuarioActual.entrar();
                            }
                            return true;
                        }
                    }

                }
            } catch (NullPointerException g) {
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(autenticar(" ", " "));
    }
}
