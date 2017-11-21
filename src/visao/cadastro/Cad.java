package visao.cadastro;

import controlo.ControloFuncionario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import modelo.Funcionario;
import modelo.config.ConfigCargo;
import modelo.config.ConfigCategoria;
import visao.componentes.Checagem;
import visao.componentes.Cor;
import visao.componentes.Fonte;
import visao.componentes.Mostre;
import visao.componentes.Painel;
import visao.componentes.Painel2;

/**
 * Painel Base para o formulário de cadastro
 *
 * @author 50enta
 */
public class Cad extends Painel {

    public static Funcionario funcionario = new Funcionario();
    //atributos
    public static CardLayout cartao = new CardLayout();
    public static Painel geral = new Painel();
    static Cad1 tela1 = new Cad1();
    static Cad2 tela2 = new Cad2();
    static Cad3 tela3 = new Cad3();

    public static boolean salvar;


    //construtores
    public Cad() {
        salvar = true;
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, formatarGeral());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.SOUTH, new Painel());
        this.add(BorderLayout.EAST, new Painel());
    }

    public Cad(Funcionario func) {
        salvar = false;
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, formatarGeral());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.SOUTH, new Painel());
        this.add(BorderLayout.EAST, new Painel());
    }

    /**
     *
     * @return a - Painel com formatações referentes ao cabeçalho
     */
    public Painel formatarCabecalho() {
        Painel a = new Painel();
        a.setLayout(new BorderLayout());

        Mostre lbl = new Mostre("Cadastro");
        lbl.setFont(Fonte.CALIBRI_SUBTITULO);
        lbl.setForeground(Cor.BRANCO);

        Painel2 b = new Painel2();
        b.setPreferredSize(new Dimension(30, 40));
        b.add(lbl);

        a.add(BorderLayout.CENTER, b);
        a.add(BorderLayout.NORTH, new Painel());

        return a;
    }

    private Painel formatarGeral() {
        geral.setLayout(cartao);
        geral.add(tela1, "1");
        geral.add(tela2, "2");
        geral.add(tela3, "3");
        //para exibir o primeiro ao iniciar
        cartao.show(geral, "1");
        return geral;
    }

    //métodos para alternar entre as telas
    public static void irParaTela1() {
        Cad.cartao.show(geral, "1");
    }

    public static void irParaTela2() {
        Cad.cartao.show(geral, "2");
    }

    public static void irParaTela3() {
        Cad.cartao.show(geral, "3");
    }

    public static Funcionario recolherDados() {

        Funcionario func = funcionario;

        if (salvar) {
            func = new Funcionario();
            func.setCodigo(ControloFuncionario.gerarCodigo());
        }

        func.setNome(!tela1.txtNome.getText().equals("ex: Samira Flávia") ? tela1.txtNome.getText() : null);
        func.setCaminhoFoto(tela1.caminhoFoto);

        func.adicionarCargo((ConfigCargo) tela1.jcbCargo.getSelectedItem());
        func.adicionarCategoria((ConfigCategoria) tela1.jcbCategoria.getSelectedItem());

        for (Checagem a : tela1.subsudiosDisponiveis) {
            if (a.isSelected()) {
                func.adicionarSubsidio(Cad3.subsidios.pesquisar(a.getText()));
            }
        }

        func.setEmail(!tela1.txtEmail.getText().equals("ex: Samira@gmail.com") ? tela1.txtEmail.getText() : null);
        func.setDataAdmissao(tela1.dtDataAdmissao.getDate());

        //Tela2
        func.setCelular(!tela2.txtCelular.getText().equals("ex: 82505050") ? tela2.txtCelular.getText() : null);
        // func.setTelefone(!tela2.txtTelefone.getText().equals("ex: 505050") ?tela2.txtTelefone.getText(): null );

        func.setNomeEmergencia(!tela2.txtNomeEmergencia.getText().equals("ex: Maria Mondlane") ? tela2.txtNomeEmergencia.getText() : null);
        func.setCelEmergencia(!tela2.txtContEmergencia.getText().equals("ex: 820000000") ? tela2.txtContEmergencia.getText() : null);
        func.setNomePai(!tela2.txtNomePai.getText().equalsIgnoreCase("ex: Fimínio Dos Santos") ? tela2.txtNomePai.getText() : null);
        func.setSexo((String) tela2.jcbSexo.getSelectedItem());
        func.setNacionalidade((String) tela2.jcbNacionalidade.getSelectedItem());
        func.setNomeMae((!tela2.txtNomeMae.getText().equalsIgnoreCase("ex: Maria Mondlane")) ? tela2.txtNomeMae.getText() : null);
        func.setDataNascimento(tela2.dtNascimento.getDate());
        func.setEstadoCivil((String) tela2.jcbEstadoCivil.getSelectedItem());
        func.setNumeroCasa(tela2.txtNCasa.getText());
        func.setBairro(!tela2.txtBairro.getText().equalsIgnoreCase("ex: Polana Caniço \"B\"") ? tela2.txtBairro.getText() : null);
        func.setRua(!tela2.txtAvRua.getText().equals("ex: Acordos de Lusaka") ? tela2.txtAvRua.getText() : null);
        func.setQuarteirao((String) tela2.spnQuarteirao.getValue());

        //Tela3
        func.setBi(!tela3.txtBi.getText().equals("ex: 110100000083") ? tela3.txtBi.getText() : null);
        func.setNuit(!tela3.txtNuit.getText().equals("ex: 123456778") ? tela3.txtNuit.getText() : null);
        func.setNomeBanco(!tela3.txtBanco.getText().equals("ex: Millenium Bim") ? tela3.txtBanco.getText() : null);
        func.setNrConta(!tela3.txtNConta.getText().equals("ex: 3456789") ? tela3.txtNConta.getText() : null);
        func.setEscolaridade((String) tela3.jcbEscolaridade.getSelectedItem());
        func.setInstituicao(!tela3.txtInstituicao.getText().equals("ex: Uiversidade Eduardo Mondlane") ? tela3.txtInstituicao.getText() : null);
        func.setCurso(!tela3.txtCurso.getText().equals("ex: Informática") ? tela3.txtCurso.getText() : null);
        return func;
    }

    /**
     * Recebe um funcionário por parâmetro e inicializa os campos com ados Usado
     * para editar
     *
     * @param func
     */
    public static void inicializarComDados(Funcionario func) {

        limparCampos();

        funcionario = func;

        tela1.colocarFoto(func.getCaminhoFoto());
        tela1.txtNome.setText(func.getNome());

        tela1.dtDataAdmissao.setDate(func.getDataAdmissao());
        tela1.jcbDept.setSelectedItem(func.getDepartamento());
        tela2.txtAvRua.setText(func.getRua());
        tela2.txtBairro.setText(func.getBairro());
        tela2.txtCelular.setText(func.getCelular());
        tela2.txtTelefone.setText(func.getTelefone());
     
        tela2.txtNomeEmergencia.setText(func.getNomeEmergencia());
        tela2.txtContEmergencia.setText(func.getCelEmergencia());
//        tela2.spnQuarteirao.set((func.getQuarteirao()));
        tela2.jcbSexo.setSelectedItem(func.getSexo());
        tela2.jcbNacionalidade.setSelectedItem(func.getNacionalidade());
        tela2.jcbEstadoCivil.setSelectedItem(func.getEstado());
        tela2.txtNomePai.setText(func.getNomePai());
        tela2.txtNomeMae.setText(func.getNomeMae());
        tela2.dtNascimento.setDate(func.getDataNascimento());
        tela2.txtNCasa.setText(func.getNumeroCasa());

        tela3.jcbEscolaridade.setSelectedItem(func.getEscolaridade());
        tela3.txtBanco.setText(func.getNomeBanco());
        tela3.txtNConta.setText(func.getNrConta());
        tela3.txtBi.setText(func.getBi());
        tela3.txtCurso.setText(func.getCurso());
        tela3.txtInstituicao.setText(func.getInstituicao());
        tela3.txtNuit.setText(func.getNuit());
    }

    /**
     * Limpar as caixas de texto e mudar cor ao inicializar dados pra editar
     */
    public static void limparCampos() {
        
        tela1.txtNome.setText(tela1.txtNome.getTexto());
        tela1.txtEmail.setText(tela1.txtEmail.getTexto());
        tela2.txtAvRua.setText(tela2.txtAvRua.getTexto());
        tela2.txtBairro.setText(tela2.txtBairro.getTexto());
        tela2.txtCelular.setText(tela2.txtCelular.getTexto());
        tela2.txtContEmergencia.setText(tela2.txtContEmergencia.getTexto());
        tela2.txtNCasa.setText(tela2.txtNCasa.getTexto());
        tela2.txtNomeEmergencia.setText(tela2.txtNomeEmergencia.getTexto());
        tela2.txtNomeMae.setText(tela2.txtNomeMae.getTexto());
        tela2.txtNomePai.setText(tela2.txtNomePai.getTexto());
        tela2.txtTelefone.setText(tela2.txtTelefone.getTexto());
        tela3.txtBanco.setText(tela2.txtBairro.getTexto());
        tela3.txtBi.setText(tela3.txtBi.getTexto());
        tela3.txtCurso.setText(tela3.txtCurso.getTexto());
        tela3.txtInstituicao.setText(tela3.txtInstituicao.getTexto());
        tela3.txtNConta.setText(tela3.txtNConta.getTexto());
        tela3.txtNuit.setText(tela3.txtNuit.getTexto());
    }
}
