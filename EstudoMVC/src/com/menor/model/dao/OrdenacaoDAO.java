package com.menor.model.dao;

import com.menor.model.vo.Ordenacao;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Gustavo Ferreira
 * @see Classe que executa as operacoes de IO (entrada e saida) do sistema com
 * relacao aos dados resultantes da ordenacao
 */
public class OrdenacaoDAO {

    /**
     * Metodo que salva em um arquivo de texto os dados do objeto de ordenacao
     *
     * @param ordenacao
     * @throws FileNotFoundException
     */
    public void salvar(Ordenacao ordenacao) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter("ordenacao.txt")) {
            pw.print(ordenacao);
            pw.flush();
        }
    }
}
