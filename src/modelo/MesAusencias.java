
package modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
class MesAusencias implements Mes{

    @Id
    @GeneratedValue
    private int indMesAusencias;
    @Temporal(TemporalType.DATE)
    private Date dataDeMarcacao;
    private int faltas;

    public MesAusencias() {
        this.dataDeMarcacao = new Date();
    }

    /**
     * @return the indMesAusencias
     */
    public int getIndMesAusencias() {
        return indMesAusencias;
    }

    /**
     * @param indMesAusencias the indMesAusencias to set
     */
    public void setIndMesAusencias(int indMesAusencias) {
        this.indMesAusencias = indMesAusencias;
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
     * @return the faltas
     */
    public int getFaltas() {
        return faltas;
    }

    /**
     * @param faltas the faltas to set
     */
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    @Override
    public Mes getMes(int mes) {
        return null;
    }
    
    
    
}
