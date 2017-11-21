package visao;

import java.awt.BorderLayout;
import static java.awt.Component.BOTTOM_ALIGNMENT;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import modelo.Funcionario;
import modelo.Notificacao;
import net.miginfocom.swing.MigLayout;
import visao.cadastro.Cad3;
import visao.componentes.Cor;
import visao.componentes.Mostre;
import visao.componentes.Mostre2;
import visao.componentes.Mostre6;
import visao.componentes.Painel;
import visao.componentes.Painel1;

/**
 *
 * @author 50enta
 */
public class Notificacao_ extends Painel1 {

    Notificacao notificacao;

    public Notificacao_(Notificacao not) {
        this.notificacao = not;

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(400, 60));
        this.setMaximumSize(new Dimension(1300, 60));
        this.add(formatarNotificacao());
    }

    public Painel1 formatarNotificacao() {
        Painel1 a = new Painel1();
        a.setLayout(new BorderLayout());

        Painel1 pnlFoto = new Painel1();
        pnlFoto.setLayout(new BorderLayout());
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/notificacaoP.png"));
        Image imgVisto = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/visto.png"));
        Mostre lblFoto = new Mostre();
        lblFoto.setIcon(new ImageIcon(notificacao.isActivo() ? img : imgVisto));
        lblFoto.setToolTipText("Marcar como visto");
        lblFoto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ///propriedades da notificação vista aqui
                lblFoto.setIcon(new ImageIcon(imgVisto));
                Cad3.notificacoes.desactivar(notificacao);
            }

        });
        pnlFoto.add(BorderLayout.CENTER, lblFoto);

        Painel1 esquerda = new Painel1();
        esquerda.setLayout(new BorderLayout());

        esquerda.add(BorderLayout.WEST, new Painel1());
        esquerda.add(BorderLayout.EAST, new Painel1());
        esquerda.add(BorderLayout.CENTER, pnlFoto);
        esquerda.add(BorderLayout.SOUTH, new Painel1());
        esquerda.add(BorderLayout.NORTH, new Painel1());

        Painel1 baseInfo = new Painel1();
        baseInfo.setLayout(new MigLayout("align left"));
        Mostre2 lb = new Mostre2("O funcionário " + this.notificacao.getFuncionarioEmCausa().toString() + "  " + this.notificacao.getTexto());
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 17));
        lb.setForeground(Cor.CINZA_ESCURO);
        baseInfo.add(lb, "wrap");
//        baseInfo.add(new Mostre6(this.getFuncao()), "wrap");
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        String dh = "";
        try {
            dh = dt.format(this.notificacao.getData());
        } catch (Exception h) {

        }
        Mostre6 lbl = new Mostre6(dh + "     ");
        lbl.setForeground((Cor.AZUL));
        lbl.setFont(new Font("calibri", Font.BOLD, 10));

        lbl.setAlignmentY(BOTTOM_ALIGNMENT);
        lbl.setAlignmentX(CENTER_ALIGNMENT);
//        baseInfo.add(new Mostre6(Integer.toString(this.getCode())));

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

//        a.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent me) {
//                switch (painelActual) {
//                    case 0:
//                        //funcionarios - exibir perfil
////             Teste .... Terá que se criar um metodo inicializar com dados que passa por parâmetro um Funcinario
//                        Home1.iFuncionarios.lblNome.setText(getNome());
//                        Home1.iFuncionarios.escolherCorStatus(getStatus());
//                        Home1.iFuncionarios.colocarFoto(caminhoFoto);
//                        break;
//                    case 1:
//                        //ausecncias -
//                        JOptionPane.showMessageDialog(null, "Ausências");
//
//                        break;
//                    case 2:
//                        //ferias
//                        JOptionPane.showMessageDialog(null, "Férias");
//                        break;
//                    case 3:
//                        //salarios
//                        JOptionPane.showMessageDialog(null, "Salários");
//                        break;
//                    case 7:
//                        //Cadastros - preencher tela cadastro com os dados da pessoa seleccionada e protificar para editar
//                        JOptionPane.showMessageDialog(null, "Cadastro");
//                        break;
//
//                }
//            }
//
//        });
        return a;
    }

}
