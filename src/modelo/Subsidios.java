/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import modelo.config.ConfigSubsidio;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author user
 */
@Entity
public class Subsidios implements Serializable {

    @Id
    @GeneratedValue
    private int idSbsidios;
    private double valor;
    private String nomeSubsiidio;
    private String observacao;
    private boolean activo;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private ConfigSubsidio subsidioBD = new ConfigSubsidio();

    public boolean desativar() {
        this.setActivo(false);
        return true;
    }

    /**
     * @return the idSbsidios
     */
    public int getIdSbsidios() {
        return idSbsidios;
    }

    /**
     * @param idSbsidios the idSbsidios to set
     */
    public void setIdSbsidios(int idSbsidios) {
        this.idSbsidios = idSbsidios;
    }

    public ConfigSubsidio getSubsidioBD() {
        return subsidioBD;
    }

    public void setSubsidioBD(ConfigSubsidio subsidioBD) {
        this.subsidioBD = subsidioBD;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        try {
            return this.getSubsidioBD().getValor();
        } catch (NullPointerException a) {

        }
        return 0;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the nomeSubsiidio
     */
    public String getNomeSubsiidio() {
        try {
            return this.getSubsidioBD().getNome();
        } catch (Exception e) {
        }
        return " ";
    }

    /**
     * @param nomeSubsiidio the nomeSubsiidio to set
     */
    public void setNomeSubsiidio(String nomeSubsiidio) {
        this.nomeSubsiidio = nomeSubsiidio;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return this.getNomeSubsiidio();
    }

}
