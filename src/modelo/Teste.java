/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author user
 */
public class Teste {

    public static void main(String[] args) throws ParseException, CloneNotSupportedException {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session sessao = factory.openSession();
        sessao.beginTransaction();

        Funcionario func = (Funcionario) sessao.get(Funcionario.class, 45);

//        System.out.println(func.marcarHorasExtras(12));
////Para férias
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy");
        Date dat1 = sdf1.parse("01/02/2017");
        Date dat2 = sdf1.parse("3/03/2017");
        System.out.println(func.marcarFerias(dat1, dat2));
//      System.out.println(func.cancelarFerias());
//        System.out.println(func.marcarFaltas(19));

        Funcionario us = (Funcionario) sessao.get(Funcionario.class, 6);
        Usu h = new Usu();
        h.setActivo(true);
        h.setTipo("Normal");

        us.setUsuario(h);
        sessao.saveOrUpdate(us);

//        for (Funcionario a : (List<Funcionario>) sessao.createCriteria(Funcionario.class).list()) {
//            System.out.println(a);
//
//        }
        sessao.getTransaction().commit();
        sessao.close();

        System.exit(0);
    }
}
