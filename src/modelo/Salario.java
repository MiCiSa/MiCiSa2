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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author user
 */
@Entity
public class Salario implements Mes, Serializable {

    @Id
    @GeneratedValue
    private int idSalario;

    private int ano;
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario janeiro = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario fevereiro = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario marco = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario abril = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario maio = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario junho = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario julho = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario agosto = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario setembro = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario outubro = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario novembro = new MesSalario();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesSalario dezembro = new MesSalario();

    @Override
    public MesSalario getMes(int mes) {
        switch (new Date().getMonth()) {
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
     * @return the idSalario
     */
    public int getIdSalario() {
        return idSalario;
    }

    /**
     * @param idSalario the idSalario to set
     */
    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
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
    public MesSalario getJaneiro() {
        return janeiro;
    }

    /**
     * @param janeiro the janeiro to set
     */
    public void setJaneiro(MesSalario janeiro) {
        this.janeiro = janeiro;
    }

    /**
     * @return the fevereiro
     */
    public MesSalario getFevereiro() {
        return fevereiro;
    }

    /**
     * @param fevereiro the fevereiro to set
     */
    public void setFevereiro(MesSalario fevereiro) {
        this.fevereiro = fevereiro;
    }

    /**
     * @return the marco
     */
    public MesSalario getMarco() {
        return marco;
    }

    /**
     * @param marco the marco to set
     */
    public void setMarco(MesSalario marco) {
        this.marco = marco;
    }

    /**
     * @return the abril
     */
    public MesSalario getAbril() {
        return abril;
    }

    /**
     * @param abril the abril to set
     */
    public void setAbril(MesSalario abril) {
        this.abril = abril;
    }

    /**
     * @return the maio
     */
    public MesSalario getMaio() {
        return maio;
    }

    /**
     * @param maio the maio to set
     */
    public void setMaio(MesSalario maio) {
        this.maio = maio;
    }

    /**
     * @return the junho
     */
    public MesSalario getJunho() {
        return junho;
    }

    /**
     * @param junho the junho to set
     */
    public void setJunho(MesSalario junho) {
        this.junho = junho;
    }

    /**
     * @return the julho
     */
    public MesSalario getJulho() {
        return julho;
    }

    /**
     * @param julho the julho to set
     */
    public void setJulho(MesSalario julho) {
        this.julho = julho;
    }

    /**
     * @return the agosto
     */
    public MesSalario getAgosto() {
        return agosto;
    }

    /**
     * @param agosto the agosto to set
     */
    public void setAgosto(MesSalario agosto) {
        this.agosto = agosto;
    }

    /**
     * @return the setembro
     */
    public MesSalario getSetembro() {
        return setembro;
    }

    /**
     * @param setembro the setembro to set
     */
    public void setSetembro(MesSalario setembro) {
        this.setembro = setembro;
    }

    /**
     * @return the outubro
     */
    public MesSalario getOutubro() {
        return outubro;
    }

    /**
     * @param outubro the outubro to set
     */
    public void setOutubro(MesSalario outubro) {
        this.outubro = outubro;
    }

    /**
     * @return the novembro
     */
    public MesSalario getNovembro() {
        return novembro;
    }

    /**
     * @param novembro the novembro to set
     */
    public void setNovembro(MesSalario novembro) {
        this.novembro = novembro;
    }

    /**
     * @return the dezembro
     */
    public MesSalario getDezembro() {
        return dezembro;
    }

    /**
     * @param dezembro the dezembro to set
     */
    public void setDezembro(MesSalario dezembro) {
        this.dezembro = dezembro;
    }

}
