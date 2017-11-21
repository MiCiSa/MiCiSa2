package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Modelo das notificações
 *
 * @author user
 */
@Entity
public class Notificacao implements Serializable {

    @Id
    @GeneratedValue
    private int idNotificacao;
    private String texto;
    private boolean activo;
    private Date data;
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Funcionario funcionarioEmCausa;

    /**
     * Construtor, para faciliatar a vida no monento de instanciar
     *
     * @param texto
     * @param func
     */
    public Notificacao(String texto, Funcionario func) {
        this.funcionarioEmCausa = func;
        this.texto = texto;
        this.data = new Date();
        this.activo = true;
    }

    public Notificacao() {
         this.data = new Date();
        this.activo = true;
    }

    /**
     * @return the idNotificacao
     */
    public int getIdNotificacao() {
        return idNotificacao;
    }

    /**
     * @param idNotificacao the idNotificacao to set
     */
    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
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

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the funcionarioEmCausa
     */
    public Funcionario getFuncionarioEmCausa() {
        return funcionarioEmCausa;
    }

    /**
     * @param funcionarioEmCausa the funcionarioEmCausa to set
     */
    public void setFuncionarioEmCausa(Funcionario funcionarioEmCausa) {
        this.funcionarioEmCausa = funcionarioEmCausa;
    }

}
