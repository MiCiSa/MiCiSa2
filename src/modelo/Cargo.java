/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import modelo.config.ConfigCargo;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Classe que serve para fazer a integração dos cargos da base de dados e um
 * determinado funcionário
 *
 * @see ConfigCargo
 *
 * @author 50enta
 * @author Micaela Freitas
 * @author Samira Flávia
 */
@Entity
public class Cargo implements Serializable {

    @Id
    @GeneratedValue
    private int idCargo;

    private boolean ativo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataAtribuicao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLargamento;
    private String cargo;
    private String obs;
    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
//    @Fetch(FetchMode.SUBSELECT)
    private ConfigCargo cargoBD = new ConfigCargo();

    public int getIdCargo() {
        return idCargo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public Date getDataAtribuicao() {
        return DataAtribuicao;
    }

    public void setDataAtribuicao(Date DataAtribuicao) {
        this.DataAtribuicao = DataAtribuicao;
    }

    public Date getDataLargamento() {
        return dataLargamento;
    }

    public void setDataLargamento(Date dataLargamento) {
        this.dataLargamento = dataLargamento;
    }

    public String getCargo() {
        return this.getCargoBD().getNome();
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getObs() {
        return this.getCargoBD().getTermosReferencia();
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return this.cargo;
    }

    public ConfigCargo getCargoBD() {
        return cargoBD;
    }

    public void setCargoBD(ConfigCargo cargoBD) {
        this.cargoBD = cargoBD;
    }

}
