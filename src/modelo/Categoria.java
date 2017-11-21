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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import modelo.config.ConfigCategoria;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Cada funcionário dispoõe de uma categoria, tendo em conta que as categorias
 * não são fixas, ou seja, são predefenidas na base de dados de acordo com as
 * configuração de cada empresa, então esta classe faz o relacionamento entre a
 * classe que cntém um determinado cargo e um determinado funcionários
 *
 * @author user
 */
@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private int idCategoria;
    @Temporal(TemporalType.DATE)
    private Date dataDeAtribuicao;
    @Temporal(TemporalType.DATE)
    private Date dataLargamento;
    private double valor;
    private String nome;
    private String observacao;
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private ConfigCategoria categoriaBD = new ConfigCategoria();

    /**
     * Activar a cateoria, marcando a data de atribuição
     *
     * @return
     */
    public boolean activar() {
        this.dataDeAtribuicao = new Date();
        return true;
    }

    public boolean desativar() {
        this.dataLargamento = new Date();
        return true;
    }

    public ConfigCategoria getCategoriaBD() {
        return categoriaBD;
    }

    public void setCategoriaBD(ConfigCategoria categoriaBD) {
        this.categoriaBD = categoriaBD;
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the dataDeAtribuicao
     */
    public Date getDataDeAtribuicao() {
        return dataDeAtribuicao;
    }

    /**
     * @param dataDeAtribuicao the dataDeAtribuicao to set
     */
    public void setDataDeAtribuicao(Date dataDeAtribuicao) {
        this.dataDeAtribuicao = dataDeAtribuicao;
    }

    /**
     * @return the dataLargamento
     */
    public Date getDataLargamento() {
        return dataLargamento;
    }

    /**
     * @param dataLargamento the dataLargamento to set
     */
    public void setDataLargamento(Date dataLargamento) {
        this.dataLargamento = dataLargamento;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        try {
            return this.getCategoriaBD().getValor();
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
     * @return the nome
     */
    public String getNome() {
        return this.getCategoriaBD().getNome();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return this.getNome();
    }

}
