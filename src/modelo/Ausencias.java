/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Classe contém a regra de negócio relativa ao tratamento da efectividade dos
 * funcionários da empresa
 *
 * @author user
 * @see Salario
 * @see Ferias
 */
@Entity
public class Ausencias implements Mes {

    @Id
    @GeneratedValue
    private int idAusencias;

    private int ano;
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias janeiro = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias fevereiro = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias marco = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias abril = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias maio = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias junho = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias julho = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias agosto = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias setembro = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias outubro = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias novembro = new MesAusencias();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesAusencias dezembro = new MesAusencias();

    /**
     * Para facilitar a identificação fácil do Mês, recebe um inteiro e retorna
     * o mês com conteúdo
     *
     * @param mes
     * @return
     */
    @Override
    public MesAusencias getMes(int mes) {
        switch (mes) {
            case 0:
                return janeiro;
            case 1:
                return fevereiro;
            case 2:
                return marco;
            case 3:
                return abril;
            case 4:
                return maio;
            case 5:
                return junho;
            case 6:
                return julho;
            case 7:
                return agosto;
            case 8:
                return setembro;
            case 9:
                return outubro;
            case 10:
                return novembro;
            case 11:
                return dezembro;
        }
        return null;
    }

    /**
     * Recebe a quantidade de faltas que serão marcadas e identifica o mês
     * actual para a marcação das referdas faltas
     *
     * @return
     */
    public boolean marcarFalta(int faltas) {
        if (this.getMes(new Date().getMonth()).getFaltas() == 0) {
            this.getMes(new Date().getMonth()).setFaltas(faltas);
            this.getMes(new Date().getMonth()).setDataDeMarcacao(new Date());
            return true;
        }
        return false;
    }

    /**
     * Cancela as faltas já marcadas no mês corrente
     *
     * @return
     */
    public boolean cancelar() {
        this.getMes(new Date().getMonth()).setFaltas(0);
        this.getMes(new Date().getMonth()).setDataDeMarcacao(null);
        return true;
    }

    public int getIdAusencias() {
        return idAusencias;
    }

    public void setIdAusencias(int idAusencias) {
        this.idAusencias = idAusencias;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the janeiro
     */
    public MesAusencias getJaneiro() {
        return janeiro;
    }

    /**
     * @param janeiro the janeiro to set
     */
    public void setJaneiro(MesAusencias janeiro) {
        this.janeiro = janeiro;
    }

    /**
     * @return the fevereiro
     */
    public MesAusencias getFevereiro() {
        return fevereiro;
    }

    /**
     * @param fevereiro the fevereiro to set
     */
    public void setFevereiro(MesAusencias fevereiro) {
        this.fevereiro = fevereiro;
    }

    /**
     * @return the marco
     */
    public MesAusencias getMarco() {
        return marco;
    }

    /**
     * @param marco the marco to set
     */
    public void setMarco(MesAusencias marco) {
        this.marco = marco;
    }

    /**
     * @return the abril
     */
    public MesAusencias getAbril() {
        return abril;
    }

    /**
     * @param abril the abril to set
     */
    public void setAbril(MesAusencias abril) {
        this.abril = abril;
    }

    /**
     * @return the maio
     */
    public MesAusencias getMaio() {
        return maio;
    }

    /**
     * @param maio the maio to set
     */
    public void setMaio(MesAusencias maio) {
        this.maio = maio;
    }

    /**
     * @return the junho
     */
    public MesAusencias getJunho() {
        return junho;
    }

    /**
     * @param junho the junho to set
     */
    public void setJunho(MesAusencias junho) {
        this.junho = junho;
    }

    /**
     * @return the julho
     */
    public MesAusencias getJulho() {
        return julho;
    }

    /**
     * @param julho the julho to set
     */
    public void setJulho(MesAusencias julho) {
        this.julho = julho;
    }

    /**
     * @return the agosto
     */
    public MesAusencias getAgosto() {
        return agosto;
    }

    /**
     * @param agosto the agosto to set
     */
    public void setAgosto(MesAusencias agosto) {
        this.agosto = agosto;
    }

    /**
     * @return the setembro
     */
    public MesAusencias getSetembro() {
        return setembro;
    }

    /**
     * @param setembro the setembro to set
     */
    public void setSetembro(MesAusencias setembro) {
        this.setembro = setembro;
    }

    /**
     * @return the outubro
     */
    public MesAusencias getOutubro() {
        return outubro;
    }

    /**
     * @param outubro the outubro to set
     */
    public void setOutubro(MesAusencias outubro) {
        this.outubro = outubro;
    }

    /**
     * @return the novembro
     */
    public MesAusencias getNovembro() {
        return novembro;
    }

    /**
     * @param novembro the novembro to set
     */
    public void setNovembro(MesAusencias novembro) {
        this.novembro = novembro;
    }

    /**
     * @return the dezembro
     */
    public MesAusencias getDezembro() {
        return dezembro;
    }

    /**
     * @param dezembro the dezembro to set
     */
    public void setDezembro(MesAusencias dezembro) {
        this.dezembro = dezembro;
    }

}
