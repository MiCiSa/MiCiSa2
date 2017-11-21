/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author 50enta
 */
@Entity
public class MesSalario implements Mes, Serializable {

    @Id
    @GeneratedValue
    private int idMesSalario;

    private double descPorFaltas;
    private double salarioBruto;
    private double salarioLiquido;
    private double inss;

    public double carcularSalBruto(double somatorioubsidios, double salBase, double valorHExtras) {
        salarioBruto = somatorioubsidios + salBase + valorHExtras;
        return salarioBruto;
    }

    public double carcularTotalDescontos(double inss, double faltas, double outros) {
        this.inss = inss;
        this.descPorFaltas = faltas;

        return this.inss + this.descPorFaltas + outros;
    }

    public double calcularTotalLiquido(double totalBruto, double totalDescontos) {
        salarioLiquido = totalBruto-totalDescontos;
        return salarioLiquido;
    }

    /**
     * @return the idMesSalario
     */
    public int getIdMesSalario() {
        return idMesSalario;
    }

    /**
     * @param idMesSalario the idMesSalario to set
     */
    public void setIdMesSalario(int idMesSalario) {
        this.idMesSalario = idMesSalario;
    }

    /**
     * @return the salarioBruto
     */
    public double getSalarioBruto() {
        return salarioBruto;
    }

    /**
     * @param salarioBruto the salarioBruto to set
     */
    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    /**
     * @return the salarioLiquido
     */
    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    /**
     * @param salarioLiquido the salarioLiquido to set
     */
    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    /**
     * @return the inss
     */
    public double getInss() {
        return inss;
    }

    /**
     * @param inss the inss to set
     */
    public void setInss(double inss) {
        this.inss = inss;
    }

    @Override
    public Mes getMes(int mes) {
        return null;
    }

}
