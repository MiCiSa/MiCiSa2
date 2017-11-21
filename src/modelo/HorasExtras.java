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

/**
 *
 * @author user
 */
@Entity
public class HorasExtras implements Mes, Serializable {

    @Id
    @GeneratedValue
    private int idHorasExtras;

    private int ano;
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras janeiro = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras fevereiro = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras marco = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras abril = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras maio = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras junho = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras julho = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras agosto = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras setembro = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras outubro = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras novembro = new MesHorasExtras();
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private MesHorasExtras dezembro = new MesHorasExtras();

    @Override
    public MesHorasExtras getMes(int mes) {
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
     * Recebe a quantidade de Horas Extras trabalhadas pelo funcionário que
     * serão marcadas e identifica o mês actual para a marcação das referdas
     * faltas
     *
     * @return
     */
    public boolean marcarHorasExtras(int faltas) {
        if (this.getMes(new Date().getMonth()).getHorasExtras() == 0) {
            this.getMes(new Date().getMonth()).setHorasExtras(faltas);
            this.getMes(new Date().getMonth()).setDataDeMarcacao(new Date());
            return true;
        }
        return false;
    }

    /**
     * Cancela as Horas extras já marcadas no mês corrente
     *
     * @return
     */
    public boolean cancelar() {
        this.getMes(new Date().getMonth()).setHorasExtras(0);
        this.getMes(new Date().getMonth()).setDataDeMarcacao(null);
        return true;
    }

    /**
     * @return the idHorasExtras
     */
    public int getIdHorasExtras() {
        return idHorasExtras;
    }

    /**
     * @param idHorasExtras the idHorasExtras to set
     */
    public void setIdHorasExtras(int idHorasExtras) {
        this.idHorasExtras = idHorasExtras;
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
    public MesHorasExtras getJaneiro() {
        return janeiro;
    }

    /**
     * @param janeiro the janeiro to set
     */
    public void setJaneiro(MesHorasExtras janeiro) {
        this.janeiro = janeiro;
    }

    /**
     * @return the fevereiro
     */
    public MesHorasExtras getFevereiro() {
        return fevereiro;
    }

    /**
     * @param fevereiro the fevereiro to set
     */
    public void setFevereiro(MesHorasExtras fevereiro) {
        this.fevereiro = fevereiro;
    }

    /**
     * @return the marco
     */
    public MesHorasExtras getMarco() {
        return marco;
    }

    /**
     * @param marco the marco to set
     */
    public void setMarco(MesHorasExtras marco) {
        this.marco = marco;
    }

    /**
     * @return the abril
     */
    public MesHorasExtras getAbril() {
        return abril;
    }

    /**
     * @param abril the abril to set
     */
    public void setAbril(MesHorasExtras abril) {
        this.abril = abril;
    }

    /**
     * @return the maio
     */
    public MesHorasExtras getMaio() {
        return maio;
    }

    /**
     * @param maio the maio to set
     */
    public void setMaio(MesHorasExtras maio) {
        this.maio = maio;
    }

    /**
     * @return the junho
     */
    public MesHorasExtras getJunho() {
        return junho;
    }

    /**
     * @param junho the junho to set
     */
    public void setJunho(MesHorasExtras junho) {
        this.junho = junho;
    }

    /**
     * @return the agosto
     */
    public MesHorasExtras getAgosto() {
        return agosto;
    }

    /**
     * @param agosto the agosto to set
     */
    public void setAgosto(MesHorasExtras agosto) {
        this.agosto = agosto;
    }

    /**
     * @return the outubro
     */
    public MesHorasExtras getOutubro() {
        return outubro;
    }

    /**
     * @param outubro the outubro to set
     */
    public void setOutubro(MesHorasExtras outubro) {
        this.outubro = outubro;
    }

    /**
     * @return the novembro
     */
    public MesHorasExtras getNovembro() {
        return novembro;
    }

    /**
     * @param novembro the novembro to set
     */
    public void setNovembro(MesHorasExtras novembro) {
        this.novembro = novembro;
    }

    /**
     * @return the dezembro
     */
    public MesHorasExtras getDezembro() {
        return dezembro;
    }

    /**
     * @param dezembro the dezembro to set
     */
    public void setDezembro(MesHorasExtras dezembro) {
        this.dezembro = dezembro;
    }

}
