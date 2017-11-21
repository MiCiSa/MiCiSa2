package visao.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.Funcionario;
import visao.Home1;
import visao.People;
import visao.cadastro.Cad3;

/**
 *
 * @author 50enta
 */
public class IntroduzaPesquisa extends JTextField implements FocusListener {

    //atributos
    private String texto;

    public IntroduzaPesquisa() {
        this.setPreferredSize(new Dimension(175, 28));
        this.setForeground(Cor.VERDE);
        this.setCaretColor(new Color(182, 182, 182));
        this.setBorder(null);
        this.addFocusListener(this);
    }

    public IntroduzaPesquisa(String texto) {
        super(texto);
        this.setTexto(texto);
        this.setPreferredSize(new Dimension(175, 28));
        this.setForeground(Cor.VERDE);
        this.setCaretColor(new Color(182, 182, 182));
        this.setBorder(null);
        this.addFocusListener(this);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                String texto = getText();
                if (texto != null || texto.equalsIgnoreCase("    Localizar funcionário")) {
                    actualizar(texto);
                }
            }
        });
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
//                String texto = getText();
//                if (texto != null || texto.equalsIgnoreCase("    Localizar funcionário")) {
//                    actualizar(texto);
//                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String texto = getText();
                if (texto != null || texto.equalsIgnoreCase("    Localizar funcionário")) {
                    actualizar(texto);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
//                String texto = getText();
//                actualizar(texto);
            }
        });
    }

    public void actualizar(String texto) {
        Home1.pnlPessoas.removeAll();
        Home1.pnlPessoas.repaint();
        Painel pess = new Painel1();
        pess.setLayout(new BoxLayout(pess, BoxLayout.PAGE_AXIS));
        for (Funcionario func : Cad3.funcionarios.pesquisarTodos()) {
            if (func.getNome().toUpperCase().contains(texto.toUpperCase())
                    || Integer.toString(func.getCodigo()).toUpperCase().contains(texto.toUpperCase())
                    || func.getCargo().toUpperCase().contains(texto.toUpperCase())) {
                pess.add(new People(func));
            }
        }
        Home1.pnlPessoas.add(BorderLayout.CENTER, new Rolagem(new Rolagem(pess), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        Home1.pnlPessoas.revalidate();

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;

    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (this.getTexto().equalsIgnoreCase(this.getText())) {
            this.setText("");
            this.setForeground(Cor.PRETO);

        } else {

        }

    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (this.getText().equalsIgnoreCase("")) {
            this.setText(this.getTexto());
            this.setForeground(Cor.VERDE);
        } else {

        }
        this.setBorder(null);

    }

}
