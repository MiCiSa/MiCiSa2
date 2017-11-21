/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 50enta
 */
@Entity
class MesHorasExtras implements Mes{

    @Id
    @GeneratedValue
    private int idMesHorasExtras;
    @Temporal(TemporalType.DATE)
    private Date dataDeMarcacao;
    private int horasExtras;

    /**
     * @return the idMesHorasExtras
     */
    public int getIdMesHorasExtras() {
        return idMesHorasExtras;
    }

    /**
     * @param idMesHorasExtras the idMesHorasExtras to set
     */
    public void setIdMesHorasExtras(int idMesHorasExtras) {
        this.idMesHorasExtras = idMesHorasExtras;
    }

    /**
     * @return the dataDeMarcacao
     */
    public Date getDataDeMarcacao() {
        return dataDeMarcacao;
    }

    /**
     * @param dataDeMarcacao the dataDeMarcacao to set
     */
    public void setDataDeMarcacao(Date dataDeMarcacao) {
        this.dataDeMarcacao = dataDeMarcacao;
    }

    /**
     * @return the horasExtras
     */
    public int getHorasExtras() {
        return horasExtras;
    }

    /**
     * @param horasExtras the horasExtras to set
     */
    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public Mes getMes(int mes) {
        return null;
    }

    
    
}
