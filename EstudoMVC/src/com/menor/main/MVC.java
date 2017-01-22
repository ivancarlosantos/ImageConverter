package com.menor.main;

import com.menor.model.bo.OrdenacaoBO;
import com.menor.model.vo.Ordenacao;
import com.menor.view.FramePrincipal;

/**
 *
 * @author Gustavo Ferreira
 */
public class MVC {

    public static void main(String[] args) {
        Ordenacao ordenacao = new OrdenacaoBO().bubbleSort(532135);
        System.out.println(ordenacao); //Invoco o toString() da classe Ordenacao
        FramePrincipal p =new FramePrincipal();
        p.setVisible(true);
    }
}
