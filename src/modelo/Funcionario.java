/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import modelo.config.ConfigAcess;
import modelo.config.ConfigCargo;
import modelo.config.ConfigCategoria;
import modelo.config.ConfigSubsidio;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import visao.cadastro.Cad3;

/**
 * Classe funcionário, contém os moldes do comportamento de cada funcionário, é
 * praticamento a classe que será utilizada na maioria dos casos, ela já
 * dispoões da relação de agregaçAo com as demais classes, isto é, para ter
 * acesso às faltas de um determinado funcionário, basta identifica-lo por uma
 * instãncia de @Funcionario.
 *
 * @author user
 * @see Administrador
 * @see Usu
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario implements Serializable, Cloneable {

    /**
     * Provisorio - para testes
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getNome();
    }

    public void entrar() {
        ConfigAcess acess = new ConfigAcess();
        acess.setDataInicio(new Date());
        acess.setUsuario(this);
        Cad3.acessos.salvar(acess);
    }

    public void sair() {
        ConfigAcess aux = null;
        for (ConfigAcess a : Cad3.acessos.getAcessos()) {
            aux = a;
        }
        aux.setDataFim(new Date());
        Cad3.acessos.salvar(aux);
    }

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private Usu usuario;

    private String caminhoFoto; //A fotos não são salvas na base de dados, apenas a refenrência (caminho absoluto ou relativo)
    private String nome;
    private String estado = Status.ACTIVO;
    private int codigo; //o códgoé atribuido de forma aleatória a partir de um método

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Cargo> cargos;

    private String departamento; //predefido nas configuracoes

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Funcionario> supervisor;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAdmissao;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Subsidios> subsidios;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Categoria> categoria;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Ausencias> ausencias;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<HorasExtras> horasExtras;
//    @OneToMany(fetch = FetchType.LAZY)
//    @Cascade(CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Ferias> ferias;
    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Salario> salario;

    //dados pessoais
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String nomeMae;
    private String nomePai;
    private String nacionalidade;
    private String estadoCivil;
    private String sexo;
    private String bi;
    private String nuit;

//contactos e enderecos
    private String bairro;
    private String rua;
    private String cidade;
    private String distrito;
    private String numeroCasa;
    private String quarteirao;
    private String telefone;
    private String celular;
    private String email;
    private String celEmergencia;
    private String nomeEmergencia;

    //dados bancarios
    private String nomeBanco;
    private String nrConta;

    //dados academicos
    private String escolaridade;
    private String curso;
    private String instituicao;

    /**
     * Construtor que inicializa todas as colecções, não recebe nenhum parâmetro
     */
    public Funcionario() {
        this.salario = new Vector<>();
        this.ausencias = new Vector<>();
        this.ferias = new Vector<>();
        this.horasExtras = new Vector<>();
        this.categoria = new Vector<>();
        this.subsidios = new Vector<>();
        this.supervisor = new Vector<>();
        this.cargos = new Vector<>();
        this.usuario = new Usu();
    }
//Os métodos do negócio

    /**
     * Recebe um cargo, desactiva o anterior e adiciona o passado por parametro
     *
     * @param configCargo
     */
    public void adicionarCargo(ConfigCargo configCargo) {
        Cargo carg = new Cargo();
        carg.setCargoBD(configCargo);
        carg.setAtivo(true);
        carg.setDataAtribuicao(new Date());

        //pegar o actual
        Cargo a = null;
        for (Cargo f : cargos) {
            a = f;
        }
        if (a != null) {
            a.setAtivo(false);
            a.setDataLargamento(new Date());
        }
        cargos.add(carg);
    }

    /**
     * Adiciona os subsídio
     *
     * @param configSubs
     * @return
     */
    public boolean adicionarSubsidio(ConfigSubsidio configSubs) {
        Subsidios subs = new Subsidios();
        subs.setSubsidioBD(configSubs);
        subsidios.add(subs);
        return true;
    }

    /**
     * Adiciona o novo supervisor
     *
     * @param sup
     */
    public void adicionarSupervisor(Funcionario sup) {
        supervisor.add(sup);
    }

    /* Start here - Sobre os salários */
    /**
     * Percorre por todos os subsídios que o funcionários aufere (Os que estão
     * activos no momento) e vai somando o valor de cada um, para ser usado no
     * processo do cálculo do salário
     *
     * @return soma dos subisdios
     */
    public double somarValorDosSubsidios() {
        double soma = 0;
        for (Subsidios a : getSubsidios()) {
//            if (a.isActivo()) {
            soma += a.getValor();
//            }
        }
        return soma;
    }

    /**
     * Calcula o salário brtuo de um determinado ano e mês introduzidos por
     * parâmetro
     *
     * @param ano
     * @param mes
     * @return
     */
    public double getSalarioBruto(int ano, int mes) {
        for (Salario sal : salario) {
            if (ano == sal.getAno()) {
                return sal.getMes(mes).carcularSalBruto(somarValorDosSubsidios(), getSalBase(), calcularAcrescimoPorHorasExtras(ano, mes));
            }
        }
        return 0;
    }

    /**
     * Retorna o total dos descontos que o funcionártio sofrerá no salário
     *
     * @param ano
     * @param mes
     * @return
     */
    public double getTotalDescontos(int ano, int mes) {
        for (Salario sal : salario) {
            if (ano == (new Date().getYear() + 1900)) {
                return sal.getMes(mes).carcularTotalDescontos(calcularDescontoPorInss(), calcularDescontoPorFaltas(ano, mes), 0);
            }
        }
        return 0;
    }

    /**
     * calcula o salário do funcionário - o salário que irá para a conta do
     * cliente relamente
     *
     * @param ano
     * @param mes
     * @return
     */
    public double getTotalLiquido(int ano, int mes) {
        for (Salario sal : this.getSalario()) {
            if (sal.getAno() == ano) {
                return sal.getMes(mes).calcularTotalLiquido(getSalarioBruto(ano, mes), getTotalDescontos(ano, mes));
            }
        }

        this.getSalario().add(new Salario());
        Salario s = null;
        for (Salario a : this.getSalario()) {
            s = a;
        }
        s.setAno(ano);
        return s.getMes(mes).calcularTotalLiquido(getSalarioBruto(ano, mes), getTotalDescontos(ano, mes));
    }

    /**
     * Retorna o salário base actual, da última categoria mais concretamente
     *
     * @return
     */
    public double getSalBase() {
        Categoria ultimaCat = null;
        for (Categoria a : categoria) {
            ultimaCat = a;
        }
        return (ultimaCat == null) ? 0 : ultimaCat.getValor();
    }

    public double calcularDescontoPorFaltas(int ano, int mes) {
        return (getFaltas(ano, mes) * getSalBase()) / 24;
    }

    public double calcularDescontoPorInss() {
        return (Configuracoes.INSS) * getSalBase();
    }

    /**
     * Calcula o acrescimo que o funcionário terá por horas extras
     *
     * @param ano
     * @param mes
     * @return
     */
    public double calcularAcrescimoPorHorasExtras(int ano, int mes) {
        return (getHorasExtras(ano, mes) * Configuracoes.HORAS_EXTRAS) * getSalBase();
    }


    /*End here - sobre os salarios*/
    /**
     * Retorna o último cargos da lista
     *
     * @return
     */
    public String getCargo() {
        String ultimoCargo = "";
        for (Cargo a : cargos) {
            ultimoCargo = a.getCargo();
        }
        return ultimoCargo;
    }

    /**
     * Retorna o último cargos da lista
     *
     * @return
     */
    public String getStatus() {
        return this.estado;
    }

    /**
     * Recebe uma lista de novos subsídios que o funcionário passará a ter
     *
     * @param sus
     * @return
     */
    public boolean promover(List<Subsidios> sus) {
        for (Subsidios a : sus) {
            this.setSubsidios(a);
        }
        return true;
    }

    /**
     * Para desativar subsídio, em caso do funcionário deixar de auferir
     *
     * @param sub
     */
    public void excluirSubsidio(Subsidios sub) {
        for (Subsidios a : getSubsidios()) {
            if (a.equals(sub)) {
                a.desativar();
            }
        }
    }

    /**
     * Dado que so se pode ter apenas uma categoria de cada vez, este método
     * recebe a nova categoria e desactiva a que está activa até então
     *
     * @param configCat
     */
    public void adicionarCategoria(ConfigCategoria configCat) {
        Categoria novacat = new Categoria();
        novacat.setCategoriaBD(configCat);

        if (!categoria.isEmpty()) {
            Categoria c = null;
            for (Categoria a : categoria) {
                c = a;
            }
            c.desativar();
        }

        novacat.activar();
        categoria.add(novacat);
    }

    /**
     * Recebe o ano e o mês e por sua vez retorna as faltas do ano e mês
     * informados por parâmetro
     *
     * @param ano
     * @param mes
     * @return
     */
    public int getFaltas(int ano, int mes) {
        //indentificar o ano
        for (Ausencias a : getAusencias()) {
            if (a.getAno() == ano) {
                return a.getMes(mes).getFaltas();
            }
        }
        return 0;
    }

    /**
     * recebe as faltas do mes por parâmetro e identifica o ano actual a partir
     * do sistema e chama o metodo marcar faltas mais interno que depende do mes
     * actual
     *
     * @param faltas
     * @return
     */
    public boolean marcarFaltas(int faltas) {
        for (Ausencias a : getAusencias()) {
            if (a.getAno() == (new Date().getYear() + 1900)) {
                return a.marcarFalta(faltas);
            }
        }
        getAusencias().add(new Ausencias());
        Ausencias aus = null;
        for (Ausencias a : getAusencias()) {
            aus = a;
        }
        aus.setAno(new Date().getYear() + 1900);
        return aus.marcarFalta(faltas);
    }

    /**
     * Canceala as faltas marcadas no corrente mês, em caso de falha
     *
     * @return
     */
    public boolean cancelarFaltas() {
        for (Ausencias a : getAusencias()) {
            if (a.getAno() == (new Date().getYear() + 1900)) {
                a.cancelar();
                return true;
            }
        }
        return false;
    }

    /**
     * Dado o ano e mês, este método retorna a quantidade de horas extras
     * referentes ao ano e mês introduzidos por parâmetro
     *
     * @param ano
     * @param mes
     * @return
     */
    public int getHorasExtras(int ano, int mes) {
        for (HorasExtras a : this.getHorasExtras()) {
            if (a.getAno() == ano) {
                return a.getMes(mes).getHorasExtras();
            }
        }
        return 0;
    }

    /**
     * recebe as horas extras do mes em causa por parâmetro e identifica o ano
     * actual a partir do sistema e chama o metodo marcar faltas mais interno
     * que depende do mes actual
     *
     * @param horasExtras
     * @return
     */
    public boolean marcarHorasExtras(int horasExtras) {
        for (HorasExtras a : this.getHorasExtras()) {
            if (a.getAno() == (new Date().getYear() + 1900)) {
                return a.marcarHorasExtras(horasExtras);

            }
        }
        this.getHorasExtras().add(new HorasExtras());
        HorasExtras he = null;
        for (HorasExtras a : this.getHorasExtras()) {
            he = a;
        }
        he.setAno(new Date().getYear() + 1900);
        return he.marcarHorasExtras(horasExtras);
    }

    /**
     * Canceala as faltas marcadas no corrente mês, em caso de falha
     *
     * @return verdadeiro ou falso
     */
    public boolean cancelarHorasExtras() {
        for (HorasExtras a : this.getHorasExtras()) {
            if (a.getAno() == (new Date().getYear() + 1900)) {
                a.cancelar();
                return true;
            }
        }
        return false;
    }

    /**
     * Recebe o ano e o mês e por sua vez retorna as faltas do ano e mês
     * informados por parâmetro
     *
     * @param ano
     * @param mes
     * @return
     */
    /**
     * Marcação de férias para o corrente ano, terá que passar duas datas como
     * parâmetro
     *
     * @param d1
     * @param d2
     * @return
     * @throws java.text.ParseException
     */
    public boolean marcarFerias(Date d1, Date d2) throws ParseException {
        //identificar o ano corrente
        if (!getFerias().isEmpty()) {
            for (Ferias a : getFerias()) {
                if (a.isActivo() && (a.getAno() == (new Date().getYear() + 1900))) {
                    return false;
                }
            }
        }
        getFerias().add(new Ferias());
        Ferias fe = null;
        for (Ferias a : this.getFerias()) {
            fe = a;
        }
        fe.setAno(new Date().getYear() + 1900);
        fe.marcarFerias(d1, d2);
        return true;
    }

    /**
     * Retorna o objecto férias referente ao ano passado por parâmetro
     *
     * @param ano
     * @return
     */
    public Ferias getFerias(int ano) {
        for (Ferias a : getFerias()) {
            if (ano == a.getAno()) {
                return a;
            }
        }
//        Ferias fe = new Ferias();
//        fe.setAno(ano);
//        fe.setDataFim(new Date());
//        fe.setDataInicio(new Date());
//        fe.setActivo(false);
//        return fe;
        return null;
    }

    public Date getFeriasInicio(int ano) {
        for (Ferias a : getFerias()) {
            if (ano == a.getAno()) {
                return a.getDataInicio();
            }
        }
        return null;
    }

    public Date getFeriasFim(int ano) {
        for (Ferias a : getFerias()) {
            if (ano == a.getAno()) {
                return a.getDataFim();
            }
        }
        return null;
    }

    /**
     * É claro que a ideia é a mesma, cancelar faltas marcadas do mes em curso
     *
     * @return
     */
    public boolean cancelarFerias() {
        for (Ferias a : this.getFerias()) {
            if ((new Date().getYear() + 1900) == a.getAno()) {
                return a.cancelar();
            }
        }
        return false;
    }

    /**
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the caminhoFoto
     */
    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    /**
     * @param caminhoFoto the caminhoFoto to set
     */
    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    public Usu getUsuario() {
        return usuario;
    }

    public void setUsuario(Usu usuario) {
        this.usuario = usuario;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the supervisor
     */
    public List<Funcionario> getSupervisores() {
        return supervisor;
    }

    /**
     * @return supervisor - O suervisor actual, o último neste caso
     */
    public Funcionario getSupervisor() {
        Funcionario aux = new Funcionario();
        for (Funcionario a : this.getSupervisores()) {
            aux = a;
        }
        return aux;
    }

    /**
     * @param supervisor the supervisor to set
     */
    private void setSupervisor(List<Funcionario> supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * Adiciona um supervisor, em caso de alguma modificação
     *
     * @param supervisor the supervisor to set
     */
    private void setSupervisor(Funcionario supervisor) {
        this.supervisor.add(supervisor);
    }

    /**
     * @return the dataAdmissao
     */
    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    /**
     * @param dataAdmissao the dataAdmissao to set
     */
    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    /**
     * Retorna a lista de subsídio, activos assim também como não
     *
     * @return the subsidios
     */
    public List<Subsidios> getSubsidios() {
        return subsidios;
    }

    /**
     * Adiciona um novo subsídio, em caso de promoção ou seja la o que for
     *
     * @param subsidios the subsidios to set
     */
    public void setSubsidios(Subsidios subsidios) {
        ((Vector<Subsidios>) this.getSubsidios()).add(subsidios);
    }

    /**
     * retorna a ultima categoria
     *
     * @return the categoria
     */
    public Categoria getCategoria() {
        Categoria g = null;
        for (Categoria cat : categoria) {
            g = cat;
        }
        return g;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return this.categoria;
    }

    /**
     * @return the ausencias
     */
    public List<Ausencias> getAusencias() {
        return ausencias;
    }

    /**
     * @param ausencias the ausencias to set
     */
    public void setAusencias(List<Ausencias> ausencias) {
        this.ausencias = ausencias;
    }

    /**
     * @return the horasExtras
     */
    public List<HorasExtras> getHorasExtras() {
        return horasExtras;
    }

    /**
     * @param horasExtras the horasExtras to set
     */
    public void setHorasExtras(List<HorasExtras> horasExtras) {
        this.horasExtras = horasExtras;
    }

    /**
     * @return the ferias
     */
    public List<Ferias> getFerias() {
        return ferias;
    }

    /**
     * @param ferias the ferias to set
     */
    public void setFerias(List<Ferias> ferias) {
        this.ferias = ferias;
    }

    /**
     * @return the salario
     */
    public List<Salario> getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(List<Salario> salario) {
        this.salario = salario;
    }

    public void setSupervisores(List<Funcionario> a) {
        this.supervisor = a;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * @return the nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * @param nomePai the nomePai to set
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the bi
     */
    public String getBi() {
        return bi;
    }

    /**
     * @param bi the bi to set
     */
    public void setBi(String bi) {
        this.bi = bi;
    }

    /**
     * @return the nuit
     */
    public String getNuit() {
        return nuit;
    }

    /**
     * @param nuit the nuit to set
     */
    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the distrito
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * @param distrito the distrito to set
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the celEmergencia
     */
    public String getCelEmergencia() {
        return celEmergencia;
    }

    /**
     * @param celEmergencia the celEmergencia to set
     */
    public void setCelEmergencia(String celEmergencia) {
        this.celEmergencia = celEmergencia;
    }

    /**
     * @return the nomeEmergencia
     */
    public String getNomeEmergencia() {
        return nomeEmergencia;
    }

    /**
     * @param nomeEmergencia the nomeEmergencia to set
     */
    public void setNomeEmergencia(String nomeEmergencia) {
        this.nomeEmergencia = nomeEmergencia;
    }

    /**
     * @return the nomeBanco
     */
    public String getNomeBanco() {
        return nomeBanco;
    }

    /**
     * @param nomeBanco the nomeBanco to set
     */
    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    /**
     * @return the nrConta
     */
    public String getNrConta() {
        return nrConta;
    }

    /**
     * @param nrConta the nrConta to set
     */
    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

    /**
     * @return the escolaridade
     */
    public String getEscolaridade() {
        return escolaridade;
    }

    /**
     * @param escolaridade the escolaridade to set
     */
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the instituicao
     */
    public String getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @return the cargos
     */
    public List<Cargo> getCargos() {
        return cargos;
    }

    /**
     * @param cargos the cargos to set
     */
    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    /**
     * @param subsidios the subsidios to set
     */
    public void setSubsidios(List<Subsidios> subsidios) {
        this.subsidios = subsidios;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(String quarteirao) {
        this.quarteirao = quarteirao;
    }

}
