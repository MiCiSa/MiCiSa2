/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.config;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author 50enta
 */
@Entity
public class ConfigCategoria implements Serializable {

    @Id
    @GeneratedValue
    private int idConfigCategoria;
    private boolean activo;
    private String nome;
    private double valor;
    private String classe;

    /**
     * @return the idConfigCategoria
     */
    public int getIdConfigCategoria() {
        return idConfigCategoria;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    /**
     * @param idConfigCategoria the idConfigCategoria to set
     */
    public void setIdConfigCategoria(int idConfigCategoria) {
        this.idConfigCategoria = idConfigCategoria;
    }

    public String getNome() {
        return nome +" " + this.getClasse();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
