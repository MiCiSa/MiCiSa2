/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import visao.cadastro.Cad3;

/**
 * Aqui será feito o processo referente à estatistica da empresa,desde os
 * métodos que actualizam os valores das labels, até a integração com os
 * respectivos funcionários
 *
 * * @author 50enta
 * @author Micaela Freitas
 * @author Samira Flávia
 */
public class Estatistica {

  
/**
 * este metodo e responsavel por calcular o numero de funcionarios activos na empresa
 * @return 
 */
    public int getActivo() {
        int i = 0;
        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            if (a.getStatus().equalsIgnoreCase(Status.ACTIVO)) {
                i++;
            }
        }
        return i;
    }
/**
 * este metodo sera responsavel por calcular o numero de funcionarios demitios, 
 * doentes, em licenca de parto, reforma, suspenso e em ferias
 * @return 
 */
    public int getInactivo() {
        int i = 0;
        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            if ((a.getStatus().equalsIgnoreCase(Status.DEMITIDO))
                    || (a.getStatus().equalsIgnoreCase(Status.DOENTE))
                    || (a.getStatus().equalsIgnoreCase(Status.LICENCA_DE_PARTO))
                    || (a.getStatus().equalsIgnoreCase(Status.REFORMA))
                    || (a.getStatus().equalsIgnoreCase(Status.SUSPENSO))
                    || (a.getStatus().equalsIgnoreCase(Status.FERIAS))) {

                i++;
            }
        }
        return i;

    }
/**
 * este metodo sera responsavel por calcular o numero de funcionarios cadastrados
 * @return 
 */
    public int getDispensados() {
        int i = 0;
        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            if (a.getStatus().equalsIgnoreCase(Status.DISPENSADO)) {
                i++;
            }
        }

        return i;
    }
/**
 * metodo responsavel por calcular o numero de cadastrados na empresa
 * @return 
 */
    public int getCadastrados() {
        return Cad3.funcionarios.getFuncionario().size();

    }
/**
 * metodo responsavel por calcular o numero de funcionarios do sexo feminino
 * @return 
 */
    public int getFeminino() {
        int i = 0;

        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            if (a.getSexo().equalsIgnoreCase("Feminino")) {
                i++;
            }
        }
        return i;
    }

    /**
     * A quantidade de funcionários sexo mascunlino
     *
     * @return
     */
    public int getMasculino() {
        int i = 0;
        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            if (a.getSexo().equalsIgnoreCase("Masculino")) {
                i++;
            }
        }
        return i;
    }
/**
 * metodo responsavel por calcular o numero de funcionarios doentes
 * @return 
 */
        public int numeroDoentes(){
        int i = 0;
        for(Funcionario a : Cad3.funcionarios.getFuncionario()){
            if(a.getStatus().equalsIgnoreCase(Status.DOENTE))
                i++;
    }
    
    
    return i;
    
    }
    /**
     * metodo responsavel por calcular o numero de funcionarios em ferias
     * @return 
     */
    public int numeroFerias(){
           int i = 0;
        for(Funcionario a : Cad3.funcionarios.getFuncionario()){
            if(a.getStatus().equalsIgnoreCase(Status.FERIAS))
                i++;
    }
        
        return i;
    }
    /**
     * metodo responsavel por calcular o numero de funcionarios demitidos
     * @return 
     */
        public int numeroDemitidos(){
           int i = 0;
        for(Funcionario a : Cad3.funcionarios.getFuncionario()){
            if(a.getStatus().equalsIgnoreCase(Status.DEMITIDO))
                i++;
    }
        
        return i;
    }
    /**
     * metodo responsavel por calcular o numero de funcionarios suspensos
     * @return 
     */
        public int numeroSuspensos(){
           int i = 0;
        for(Funcionario a : Cad3.funcionarios.getFuncionario()){
            if(a.getStatus().equalsIgnoreCase(Status.SUSPENSO))
                i++;
    }
        
        return i;
    }
    /**
     * metodo responsavel por calcular o numero de funcionarios em reforma
     * @return 
     */
        public int numeroReforma(){
           int i = 0;
        for(Funcionario a : Cad3.funcionarios.getFuncionario()){
            if(a.getStatus().equalsIgnoreCase(Status.REFORMA))
                i++;
    }
        
        return i;
    }
       /**
        * metodo responsavel por calcular o numero de funcionarios em licenca de parto
        * @return 
        */
         public int numeroLincensaParto(){
           int i = 0;
        for(Funcionario a : Cad3.funcionarios.getFuncionario()){
            if(a.getStatus().equalsIgnoreCase(Status.LICENCA_DE_PARTO))
                i++;
    }
        
        return i;
    }
 
    
    /**
     * Retorna o somatório de salários auferido pelos fucionários, dado um certo
     * ano e mes passados por parâmetro
     *
     * @param ano
     * @param mes
     * @return
     */
    public double getTotalLiquido(int ano, int mes) {
        double soma = 0;
        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            soma += a.getTotalLiquido(ano, mes);
        }
        return soma;
    }

    /**
     * Relativo à quantidade de faltas globais referente a um determinado ano e
     * mês passados or parâmetro
     *
     * @param ano
     * @param mes
     * @return
     */
    public int getTotalFaltas(int ano, int mes) {
        int soma = 0;
        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            soma += a.getFaltas(ano, mes);
        }
        return soma;
    }
}
