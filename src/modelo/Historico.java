package modelo;

import java.util.Date;

/**
 * A ideia é moldar o comportamento de um determinado histórico.
 *
 * @author 50enta
 */
public class Historico {

    private String texto;
    private Date dtInicio;
    private Date dtFim;

    public Historico(String txt, Date d1, Date d2) {
        this.texto = txt;
        this.dtInicio = d1;
        this.dtFim = d2;
    }

    public Historico() {

    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

}
