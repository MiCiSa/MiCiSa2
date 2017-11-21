package visao;

import controlo.ControloFuncionario;
import java.util.List;
import java.util.Stack;
import modelo.Funcionario;
import modelo.Usu;
import modelo.config.ConfigCategoria;
import org.hibernate.Session;

/**
 * Para fazer o controle de acessos no sistema, desde o usuário activo, controle
 * de datas de acesso e registro dos mesmos incluindo o histórico e a
 * persistência na base de dados
 *
 * @author 50enta
 */
public class ControleAcessos {
//Enumeração de telas
    //Funcionários = 0;
    //Ausencias  = 1;
    //Ferias = 2;
    //Salarios = 3;
    //Estatistica = 4;
    //Notificações = 5;
    //Configurações = 6;
    //cadastro = 7;
    //promover = 8;
    //editar = 9;
    //status = 10;
    //historico = 11

    public static Funcionario usuarioActual;/* = buscarUsuarios();*/
    public static final String CAMINHO_FOTO_PADRAO = "C:\\Users\\admin\\Desktop\\Pasta_Samira\\.......Apresentacao\\MiCiSa2\\src\\visao\\imagens\\fotoPadrao.png";
    public static Stack<Integer> historioPaineis = new Stack<Integer>();
    public static Integer painelActual;

//    public static Usu buscarUsuarios() {
//        Session sessao = ControloFuncionario.factory.openSession();
//        sessao.beginTransaction();
//
//        Usu u = null;
//        for (Usu a : (List<Usuario>) sessao.createCriteria(Usu.class).list()) {
//            u = a;
//        }
//        sessao.getTransaction().commit();
//        sessao.close();
//          try {
//            u.entrar();
//        } catch (Exception h) {
//
//        }
//        return u;
//    }
}
