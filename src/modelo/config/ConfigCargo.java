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
public class ConfigCargo implements Serializable {
    @Id
    @GeneratedValue
    private int idConfigCargo;
    private boolean activo;
    private String nome;
    private String termosReferencia;

    public int getIdConfigCargo() {
        return idConfigCargo;
    }

    public void setIdConfigCargo(int idConfigCargo) {
        this.idConfigCargo = idConfigCargo;
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

    public String getTermosReferencia() {
        return termosReferencia;
    }

    public void setTermosReferencia(String termosReferencia) {
        this.termosReferencia = termosReferencia;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
