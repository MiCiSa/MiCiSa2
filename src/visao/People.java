package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Funcionario;
import modelo.Status;
import net.miginfocom.swing.MigLayout;
import static visao.ControleAcessos.painelActual;
import visao.Home1_.Home1Funcionarios;
import visao.cadastro.Cad;
import visao.componentes.Cor;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Painel1;

/**
 * Modelo para moldar todas pessoas exibidas na lista
 *
 * @author 50enta
 */
public class People extends Painel1 {

    Funcionario funcionario = new Funcionario();

    //atributos
    private String caminhoFoto;
    private Mostre lblFoto = new Mostre();

    private String nome;
    private String funcao;
    private int code;
    private String status;

    /**
     * Construtor que recebe os dados que serão exibidos para cada objecto que
     * representa um determinado funcionário do Vector<>
     *
     * @param nome
     * @param funcao
     * @param code
     * @param status
     */
//    public People(String caminho, String nome, String funcao, int code, String status) {
    public People(Funcionario func) {

        funcionario = func;
        this.setCaminhoFoto(func.getCaminhoFoto());
        this.setNome(func.getNome());
        this.setFuncao(func.getCargo());
        this.setCode(func.getCodigo());
        this.setStatus(func.getEstado());

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(400, 60));
        this.setMaximumSize(new Dimension(1000, 74));
        this.add(formatarPeople());

    }

    /**
     * Formatação da parte gráfica responsável por exibir os dados de forma
     * agradável
     *
     * @return
     */
    public Painel1 formatarPeople() {
        Painel1 a = new Painel1();
        a.setLayout(new BorderLayout());

        Painel1 pnlFoto = new Painel1();
        pnlFoto.setLayout(new BorderLayout());
//        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/cinquenta.jpg"));
        Image img = Toolkit.getDefaultToolkit().getImage(this.getCaminhoFoto());
        getLblFoto().setIcon(new ImageIcon(img.getScaledInstance(30, 36, Image.SCALE_DEFAULT)));
        pnlFoto.add(BorderLayout.CENTER, getLblFoto());

        Painel1 esquerda = new Painel1();
        esquerda.setLayout(new BorderLayout());

        esquerda.add(BorderLayout.WEST, new Painel1());
        esquerda.add(BorderLayout.EAST, new Painel1());
        esquerda.add(BorderLayout.CENTER, pnlFoto);
        esquerda.add(BorderLayout.SOUTH, new Painel1());
        esquerda.add(BorderLayout.NORTH, new Painel1());

        Painel1 baseInfo = new Painel1();
        baseInfo.setLayout(new MigLayout("align left"));
        Mostre2 lb = new Mostre2(this.getNome());
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.CINZA_ESCURO);
        baseInfo.add(lb, "wrap");
        baseInfo.add(new Mostre6(this.getFuncao()), "wrap");
        Mostre6 lbl = new Mostre6(this.getStatus() + "     ");
        if (this.getStatus() != null) {
            switch (this.getStatus()) {
                case Status.ACTIVO:
                    lbl.setForeground(Cor.AZUL);
                    break;
                case Status.DEMITIDO:
                    lbl.setForeground(Color.RED);
                    break;
                default:
                    lbl.setForeground(Color.orange);
                    break;
            }
        }
        lbl.setFont(new Font("calibri", Font.BOLD, 10));

        lbl.setAlignmentY(BOTTOM_ALIGNMENT);
        lbl.setAlignmentX(CENTER_ALIGNMENT);
        baseInfo.add(new Mostre6(Integer.toString(this.getCode())));

        Painel1 direita = new Painel1();
        direita.setLayout(new BorderLayout());
        direita.add(BorderLayout.CENTER, baseInfo);

        Painel barra = new Painel();
        barra.setBackground(Cor.CINZA_TEXTO);
        barra.setPreferredSize(new Dimension(1, 2));

        a.add(BorderLayout.WEST, esquerda);
        a.add(BorderLayout.CENTER, direita);
        a.add(BorderLayout.SOUTH, barra);
        a.add(BorderLayout.EAST, lbl);

        lblFoto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                new VerFoto(caminhoFoto);
            }

        });

        a.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    switch (painelActual) {
                        case 0:
                            Home1.iFuncionarios.mostrarDados(funcionario);

                            break;
                        case 1:
                            //ausecncias -
                            Home1.iAusencias.mostrarDados(funcionario);
                            break;
                        case 2:
                            //ferias
                            Home1.iFerias.mostrardados(funcionario);
                            break;
                        case 3:
                            //salarios
                            Home1.iSalarios.mostardados(funcionario);
                            break;
                        case 7:
                            //Cadastros - preencher tela cadastro com os dados da pessoa seleccionada e protificar para editar
                            Cad.inicializarComDados(funcionario);
                            break;

                    }
                } catch (NullPointerException a) {

                }
            }

        });
        return a;
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
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return the lblFoto
     */
    public Mostre getLblFoto() {
        return lblFoto;
    }

    /**
     * @param lblFoto the lblFoto to set
     */
    public void setLblFoto(Mostre lblFoto) {
        this.lblFoto = lblFoto;
    }
}
