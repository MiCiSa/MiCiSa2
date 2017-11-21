/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.componentes;

import java.awt.Dimension;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

/**
 *
 * @author 50enta
 */
public class EscolhaValor extends JSpinner {

    String nrs[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    SpinnerModel a = new SpinnerListModel(nrs);

    //construtor
    public EscolhaValor() {
        this.setModel(a);
        this.setPreferredSize(new Dimension(40, 25));

    }
}
