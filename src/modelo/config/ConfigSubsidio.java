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
public class ConfigSubsidio implements Serializable {

    @Id
    @GeneratedValue
    private int idConfigSubsidio;
    private boolean activo;
    private String nome;
    private double valor;

    public int getIdConfigSubsidio() {
        return idConfigSubsidio;
    }

    public void setIdConfigSubsidio(int idConfigSubsidio) {
        this.idConfigSubsidio = idConfigSubsidio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
