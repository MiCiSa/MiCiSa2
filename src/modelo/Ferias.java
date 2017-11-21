/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author 50enta
 * @author Micaela Freitas
 * @author Samira Flávia
 */
@Entity
public class Ferias implements Serializable {

    @Id
    @GeneratedValue
    private int idFerias;
    private int ano;
    private boolean activo; //activo quando tem ferias marcadas para o tal ano e durante a gozação, else desactivo
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    /**
     * Recebe duas datas e procede com a marcação de férias para o corrente ano
     *
     * @param dat1
     * @param dat2
     * @return
     */
    public boolean marcarFerias(Date dat1, Date dat2) throws ParseException {
        if (diferencaEntreDatas(dat1, dat2) > 0) {
            this.setActivo(true);
            setDataInicio(dat1);
            setDataFim(dat2);
            return true;
        }
        return false;
    }

    /**
     * Responsável por calclar a diferença entre duas datas. Recebe duas datas,
     * sendo a datainicial e data final e retorna um valor inteiro refente ao
     * número de dias existente entre essas duas datas
     *
     * @param data1
     * @param data2
     * @return
     * @throws ParseException
     */
    public static long diferencaEntreDatas(Date data1, Date data2) throws ParseException {
        
        try{
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        String d1 = df.format(data1);
        String d2 = df.format(data2);

        Date d11 = df.parse(d1);
        Date d12 = df.parse(d2);
        long dt = (d12.getTime() - d11.getTime()) + 3600000;
         return dt / 86400000L;
        }catch(Exception h){
            
        }
       return -10;
    }

    /**
     * Cancela as faltas já marcadas. Considera as faltas marcadas no mês em
     * curso. 'Caso tenha ultrapassado o mês, já nã é possível cancelar.
     *
     * @return
     */
    public boolean cancelar() {
        this.setActivo(false);
        this.setDataFim(null);
        this.setDataInicio(null);
        this.setAno(-1);
        return true;
    }

    public int getIdFerias() {
        return idFerias;
    }

    public void setIdFerias(int idFerias) {
        this.idFerias = idFerias;
    }



    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     *
     * @return
     */
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
   

    @Override
    public String toString() {
        try {
            return this.getDataInicio() + ", " + this.getDataFim() + ", " + this.diferencaEntreDatas(dataInicio, dataFim) + ", " + this.isActivo();
        } catch (ParseException ex) {
            Logger.getLogger(Ferias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
