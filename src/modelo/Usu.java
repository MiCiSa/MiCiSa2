/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import visao.ControleAcessos;
import visao.cadastro.Cad3;

/**
 *
 * @author user
 */
@Entity
public class Usu implements Serializable {

    @Id
    @GeneratedValue
    private Long idUsu;
    private boolean activo;
    private String usuario;
    private String senha;
    private String tipo; //Administrador ou Normal
    @ElementCollection
    private List<Integer> permissoes = new ArrayList<>();

    public static boolean autenticar(String senha, String usuario) {
        //vai buscar os usuarios da bd para autenticacao
        for (Funcionario func : Cad3.funcionarios.getFuncionario()) {
            Usu usu = func.getUsuario();
            if (usu != null) {
                if (usu.isActivo()) {
//                    if (usu.getUsuario().equalsIgnoreCase(usuario)
//                            && usu.getSenha().equalsIgnoreCase(senha)) {
                    if ("".equalsIgnoreCase(usuario)
                            && "".equalsIgnoreCase(senha)) {
                        ControleAcessos.usuarioActual = func;
                        if(ControleAcessos.usuarioActual != null){
                            ControleAcessos.usuarioActual.entrar();
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Long getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Long idUsu) {
        this.idUsu = idUsu;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Integer> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Integer> permissoes) {
        this.permissoes = permissoes;
    }

}
