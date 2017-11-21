/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.confiuracoes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import modelo.Funcionario;
import modelo.Usu;
import visao.Home;
import visao.Home1;
import visao.cadastro.Cad3;
import visao.componentes.Checagem;
import visao.componentes.Cor;
import visao.componentes.Escolha;
import visao.componentes.Fonte;
import visao.componentes.Mostre;
import visao.componentes.Mostre1;
import visao.componentes.Mostre2;
import visao.componentes.Painel3;

/**
 *
 * @author 50enta
 */
public class Usuarios extends Painel3 {
//atribtuos

    Escolha jcbUsuariosActivos = new Escolha(); //usuarios activos
    Categorias.MostreVerde lblTipoUsuario = new Categorias.MostreVerde("Normal");

    Escolha jcbPossiveisUsuarios = new Escolha(); //possiveis usuarios
    Escolha jcbTipoUsuario = new Escolha(new String[]{"Normal", "Administrador"});

    Checagem cbFuncionarios = new Checagem("Perfil");
    Checagem cbAusencias = new Checagem("Ausências");
    Checagem cbFerias = new Checagem("Férias");
    Checagem cbSalarios = new Checagem("Salários");
    Checagem cbEstatistica = new Checagem("Estatística");
    Checagem cbNotificacoes = new Checagem("Notificações");
    Checagem cbConfiguracoes = new Checagem("Configurações");

    //construtor
    public Usuarios() {
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, formatarCabecalho());
        this.add(BorderLayout.CENTER, formatarGeral());

        this.actualizar();
    }

    public Painel3 formatarCabecalho() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.LINE_AXIS));
        Mostre lblVoltar = new Mostre();
        lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
        Mostre2 lb = new Mostre2("Usuários do Sistema");
        lb.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 22));
        lb.setForeground(Cor.BRANCO);
        Mostre2 i = new Mostre2("espa");
        a.add(i);
        a.add(lblVoltar);
        a.add(lb);
        lblVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Home1.irParaConfiguracoesInicio();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarP.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me);
                lblVoltar.setIcon(new ImageIcon(new Home().getClass().getResource("imagens/voltarPB.png")));
            }

        });
        a.setPreferredSize(new Dimension(50, 50));
        return a;
    }

    public Painel3 formatarGeral() {
        Painel3 a = new Painel3();
        a.setLayout(new BorderLayout());
        a.add(BorderLayout.CENTER, formatarBase1());
        return a;
    }

    public Painel3 formatarBase1() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.PAGE_AXIS));
        a.add(new Painel3());
        Painel3 u = new Painel3();
        u.add(new Categorias.MostreVerde("Usuários activos"));
        a.add(u);
        Painel3 b = new Painel3();
        b.add(jcbUsuariosActivos);
        jcbUsuariosActivos.setPreferredSize(new Dimension(210, 25));
        jcbUsuariosActivos.setRequestFocusEnabled(false);
        lblTipoUsuario.setFont(new Font("calibri", Font.ROMAN_BASELINE | Font.PLAIN, 22));
        a.add(b);
        Painel3 o = new Painel3();
        o.add(lblTipoUsuario);
        a.add(o);
        a.add(new Painel3());
        a.add(formatarPermissoes());
        a.add(formatabarBotaoDesactivar());

        Painel3 c5 = new Painel3();
        c5.add(new Categorias.MostreVerde("Possíveis Usuários"));
        a.add(c5);
        Painel3 j = new Painel3();
        j.add(jcbPossiveisUsuarios);
        jcbPossiveisUsuarios.setPreferredSize(new Dimension(210, 25));
        jcbPossiveisUsuarios.setRequestFocusEnabled(false);
        a.add(j);
        Painel3 c = new Painel3();
        c.add(new Subsidios.MostreVerde("Tipo de acesso "));
        c.add(jcbTipoUsuario);
        jcbTipoUsuario.setPreferredSize(new Dimension(80, 25));
        a.add(c);
        a.add(formatabarBotaoActivar());
        a.add(new Painel3());
        a.add(new Painel3());
        a.add(new Painel3());
        a.add(new Painel3());
        return a;
    }

    public Painel3 formatarPermissoes() {
        Painel3 a = new Painel3();
        a.setLayout(new BoxLayout(a, BoxLayout.PAGE_AXIS));
        a.setBorder(new TitledBorder(new EtchedBorder(2, Cor.VERDE, Cor.VERDE), "Permissões", 0, 1, Fonte.CALIBRI_NORMAL, Cor.BRANCO));
//        a.add(new Categorias.MostreVerde("Permissões"));
        a.add(cbFuncionarios);
        cbFuncionarios.setBackground(Cor.VERDE);
        cbFuncionarios.setRequestFocusEnabled(false);
        cbFuncionarios.setForeground(Cor.BRANCO);
        a.add(cbAusencias);
        cbAusencias.setBackground(Cor.VERDE);
        cbAusencias.setRequestFocusEnabled(false);
        cbAusencias.setForeground(Cor.BRANCO);
        a.add(cbFerias);
        cbFerias.setBackground(Cor.VERDE);
        cbFerias.setRequestFocusEnabled(false);
        cbFerias.setForeground(Cor.BRANCO);
        a.add(cbSalarios);
        cbSalarios.setBackground(Cor.VERDE);
        cbSalarios.setRequestFocusEnabled(false);
        cbSalarios.setForeground(Cor.BRANCO);
        a.add(cbEstatistica);
        cbEstatistica.setBackground(Cor.VERDE);
        cbEstatistica.setRequestFocusEnabled(false);
        cbEstatistica.setForeground(Cor.BRANCO);
        a.add(cbNotificacoes);
        cbNotificacoes.setBackground(Cor.VERDE);
        cbNotificacoes.setRequestFocusEnabled(false);
        cbNotificacoes.setForeground(Cor.BRANCO);
        a.add(cbConfiguracoes);
        cbConfiguracoes.setBackground(Cor.VERDE);
        cbConfiguracoes.setRequestFocusEnabled(false);
        cbConfiguracoes.setForeground(Cor.BRANCO);

        Painel3 b = new Painel3();
        b.setLayout(new GridLayout(1, 2));
        b.add(a);
        b.add(new Painel3());
        Painel3 c = new Painel3();
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER, b);
        c.add(BorderLayout.WEST, new Painel3());
        return c;
    }

    public Painel3 formatabarBotaoDesactivar() {
        Painel3 a = new Painel3();

        Painel3 pnlbot = new Painel3();
        pnlbot.setBorder(new EtchedBorder(4, Cor.BRANCO, Cor.BRANCO));
        pnlbot.add(new Categorias.MostreVerde("Desactivar"));
        pnlbot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Funcionario) jcbUsuariosActivos.getSelectedItem()).setUsuario(null);
                int i = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                if (i == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, Cad3.funcionarios.salvar(((Funcionario) jcbUsuariosActivos.getSelectedItem())) ? "Sucesso" : "Erro");
                }
                actualizar();
            }

        });
        Mostre1 lblExcluir = new Mostre1("                                             salvar");
        lblExcluir.setFont(new Font("calibri", Font.PLAIN, 15));
        lblExcluir.setForeground(Cor.BRANCO);
        lblExcluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Usu u = ((Funcionario) jcbUsuariosActivos.getSelectedItem()).getUsuario();
                if (u != null) {
                    u.setPermissoes(recolherPermissoes());
                    int i = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                    if (i == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, Cad3.funcionarios.salvar(((Funcionario) jcbUsuariosActivos.getSelectedItem())) ? "Sucesso" : "Erro");
                    }

                }
            }

        });
        a.add(new Painel3());
        a.add(lblExcluir);
        a.add(pnlbot);
        return a;
    }

    /**
     * Formatação do botão desactivar usuário
     *
     * @return
     */
    public Painel3 formatabarBotaoActivar() {
        Painel3 a = new Painel3();

        Painel3 pnlbot = new Painel3();
        pnlbot.setBorder(new EtchedBorder(4, Cor.BRANCO, Cor.BRANCO));
        pnlbot.add(new Categorias.MostreVerde("   Activar   "));
        pnlbot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //activar usuario
//                if (((Funcionario) jcbPossiveisUsuarios.getSelectedItem()).getUsuario() != null) {

                Usu u = new Usu();
                u.setActivo(true);
                u.setTipo((String) jcbTipoUsuario.getSelectedItem());

                u.setPermissoes(recolherPermissoes());
                ((Funcionario) jcbPossiveisUsuarios.getSelectedItem()).setUsuario(u);
                JOptionPane.showMessageDialog(null, Cad3.funcionarios.salvar(((Funcionario) jcbPossiveisUsuarios.getSelectedItem())) ? "Sucesso" : "Erro");
                actualizar();
//            } else {
//                    ((Funcionario) jcbPossiveisUsuarios.getSelectedItem()).getUsuario().setActivo(true);
//                    JOptionPane.showMessageDialog(null, Cad3.funcionarios.salvar(((Funcionario) jcbPossiveisUsuarios.getSelectedItem())) ? "Sucesso" : "Erro");
//                }
            }

        });
        Mostre2 lblExcluir = new Mostre2("Exc            luir");
        lblExcluir.setForeground(Cor.VERDE);

        a.add(new Painel3());
        a.add(lblExcluir);
        a.add(pnlbot);
        return a;
    }

    /**
     * Recolher permissões concebidas ao usuário seleccionado
     *
     * @return
     */
    public List<Integer> recolherPermissoes() {
        ArrayList<Integer> a = new ArrayList<>();
        if (cbFuncionarios.isSelected()) {
            a.add(0);
        }
        if (cbAusencias.isSelected()) {
            a.add(1);
        }
        if (cbFerias.isSelected()) {
            a.add(2);
        }
        if (cbSalarios.isSelected()) {
            a.add(3);
        }
        if (cbEstatistica.isSelected()) {
            a.add(4);
        }
        if (cbNotificacoes.isSelected()) {
            a.add(5);
        }
        if (cbConfiguracoes.isSelected()) {
            a.add(6);
        }

        return a;
    }

    /**
     * metodo para actualizar a informação, quando for executada alguma
     * alteração
     */
    public void actualizar() {
        jcbUsuariosActivos.setModel(new DefaultComboBoxModel());
        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            if (a.getUsuario() != null) {
                if (a.getUsuario().isActivo()) {
                    jcbUsuariosActivos.addItem(a);
                }
            }
        }

        jcbPossiveisUsuarios.setModel(new DefaultComboBoxModel());
        for (Funcionario a : Cad3.funcionarios.getFuncionario()) {
            if (a.getUsuario() != null) {
                if (!a.getUsuario().isActivo()) {
                    jcbPossiveisUsuarios.addItem(a);
                }
            }
            if (a.getUsuario() == null) {
                jcbPossiveisUsuarios.addItem(a);
            }
        }
        jcbUsuariosActivos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                lblTipoUsuario.setText((String) ((Funcionario) jcbUsuariosActivos.getSelectedItem()).getUsuario().getTipo());
                List<Integer> perm = ((Funcionario) jcbUsuariosActivos.getSelectedItem()).getUsuario().getPermissoes();
                cbAusencias.setSelected(false);
                if (perm.contains(1)) {
                    cbAusencias.setSelected(true);
                }
                cbFuncionarios.setSelected(false);
                if (perm.contains(0)) {
                    cbFuncionarios.setSelected(true);
                }
                cbFerias.setSelected(false);
                if (perm.contains(2)) {
                    cbFerias.setSelected(true);
                }
                cbSalarios.setSelected(false);
                if (perm.contains(3)) {
                    cbSalarios.setSelected(true);
                }
                cbSalarios.setSelected(false);
                if (perm.contains(4)) {
                    cbSalarios.setSelected(true);
                }
                cbNotificacoes.setSelected(false);
                if (perm.contains(5)) {
                    cbNotificacoes.setSelected(true);
                }
                cbConfiguracoes.setSelected(false);
                if (perm.contains(6)) {
                    cbConfiguracoes.setSelected(true);
                }
            }
        });
        lblTipoUsuario.setText((String) ((Funcionario) jcbUsuariosActivos.getSelectedItem()).getUsuario().getTipo());
        List<Integer> perm = ((Funcionario) jcbUsuariosActivos.getSelectedItem()).getUsuario().getPermissoes();
        cbAusencias.setSelected(false);
        if (perm.contains(1)) {
            cbAusencias.setSelected(true);
        }
        cbFuncionarios.setSelected(false);
        if (perm.contains(0)) {
            cbFuncionarios.setSelected(true);
        }
        cbFerias.setSelected(false);
        if (perm.contains(2)) {
            cbFerias.setSelected(true);
        }
        cbSalarios.setSelected(false);
        if (perm.contains(3)) {
            cbSalarios.setSelected(true);
        }
        cbSalarios.setSelected(false);
        if (perm.contains(4)) {
            cbSalarios.setSelected(true);
        }
        cbNotificacoes.setSelected(false);
        if (perm.contains(5)) {
            cbNotificacoes.setSelected(true);
        }
        cbConfiguracoes.setSelected(false);
        if (perm.contains(6)) {
            cbConfiguracoes.setSelected(true);
        }
    }

    /**
     * Recebe um funcionário e converte - o para Usuário
     *
     * @param func
     * @return
     */
//    public Usu paraUsuario(Funcionario func) {
//        Usu u = new Usu();
//        u.setId(func.getId());
//        u.setNome(func.getNome());
//        u.setCaminhoFoto(func.getCaminhoFoto());
//        u.setEstado(func.getEstado());
//        u.setCodigo(func.getCodigo());
//        u.setCargos(func.getCargos());
//        u.setDepartamento(func.getDepartamento());
//        u.setDataAdmissao(func.getDataAdmissao());
//        u.setSubsidios(func.getSubsidios());
//        // u.setCategoria(func.getCategoria());
//        u.setAusencias(func.getAusencias());
//        u.setFerias(func.getFerias());
//        u.setSalario(func.getSalario());
//        u.setDataNascimento(func.getDataNascimento());
//        u.setNomePai(func.getNomePai());
//        u.setNomeMae(func.getNomeMae());
//        u.setNacionalidade(func.getNacionalidade());
//        u.setBi(func.getBi());
//        u.setNuit(func.getNuit());
//        u.setEstadoCivil(func.getEstadoCivil());
//        u.setSexo(func.getSexo());
//        u.setBairro(func.getBairro());
//        u.setRua(func.getRua());
//        u.setCidade(func.getCidade());
//        u.setDistrito(func.getDistrito());
//        u.setNumeroCasa(func.getNumeroCasa());
//        u.setQuarteirao(func.getQuarteirao());
//        u.setTelefone(func.getTelefone());
//        u.setCelular(func.getCelular());
//        u.setEmail(func.getEmail());
//        u.setCelEmergencia(func.getCelEmergencia());
//        u.setNomeEmergencia(func.getNomeEmergencia());
//        u.setNomeBanco(func.getNomeBanco());
//        u.setNrConta(func.getNrConta());
//        u.setEscolaridade(func.getEscolaridade());
//        u.setCurso(func.getCurso());
//        u.setInstituicao(func.getInstituicao());
//        u.setSupervisores(func.getSupervisores());
//        
//        return u;
//    }
//
//    /**
//     * Recebe um Usuário e retorna um Funcionário... Deverá ser usado em caso de
//     * um usuário ser desactivado
//     *
//     * @param u
//     * @return
//     */
//    public Funcionario paraFuncionario(Usu u) {
//        Funcionario func = new Funcionario();
//        func.setId(u.getId());
//        func.setNome(u.getNome());
//        func.setCaminhoFoto(u.getCaminhoFoto());
//        func.setEstado(u.getEstado());
//        func.setCodigo(u.getCodigo());
//        func.setCargos(u.getCargos());
//        func.setDepartamento(u.getDepartamento());
//        func.setDataAdmissao(u.getDataAdmissao());
//        func.setSubsidios(u.getSubsidios());
//        // func.setCategoria(u.getCategoria());
//        func.setAusencias(u.getAusencias());
//        func.setFerias(u.getFerias());
//        func.setSalario(u.getSalario());
//        func.setDataNascimento(u.getDataNascimento());
//        func.setNomePai(u.getNomePai());
//        func.setNomeMae(u.getNomeMae());
//        func.setNacionalidade(u.getNacionalidade());
//        func.setBi(u.getBi());
//        func.setNuit(u.getNuit());
//        func.setEstadoCivil(u.getEstadoCivil());
//        func.setSexo(u.getSexo());
//        func.setBairro(u.getBairro());
//        func.setRua(u.getRua());
//        func.setCidade(u.getCidade());
//        func.setDistrito(u.getDistrito());
//        func.setNumeroCasa(u.getNumeroCasa());
//        func.setQuarteirao(u.getQuarteirao());
//        func.setTelefone(u.getTelefone());
//        func.setCelular(u.getCelular());
//        func.setEmail(u.getEmail());
//        func.setCelEmergencia(u.getCelEmergencia());
//        func.setNomeEmergencia(u.getNomeEmergencia());
//        func.setNomeBanco(u.getNomeBanco());
//        func.setNrConta(u.getNrConta());
//        func.setEscolaridade(u.getEscolaridade());
//        func.setCurso(u.getCurso());
//        func.setInstituicao(u.getInstituicao());
//        func.setSupervisores(u.getSupervisores());
//        
//        return func;
//    }
}
