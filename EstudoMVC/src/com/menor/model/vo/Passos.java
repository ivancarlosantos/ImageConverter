package com.menor.model.vo;

/**
 *
 * @author Gustavo Ferreira
 * @see Classe que armazenas os dados relativo a cada passo da ordenacao
 */
public class Passos {

    private String numeroAnterior;
    private String numeroResultante;
    private String descricao;

    /**
     * Construtor que preenche todos os atributos do objeto
     *
     * @param numeroAnterior
     * @param numeroResultante
     * @param descricao
     */
    public Passos(String numeroAnterior, String numeroResultante, String descricao) {
        this.numeroAnterior = numeroAnterior;
        this.numeroResultante = numeroResultante;
        this.descricao = descricao;
    }

    //Get and Set
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroAnterior() {
        return numeroAnterior;
    }

    public void setNumeroAnterior(String numeroAnterior) {
        this.numeroAnterior = numeroAnterior;
    }

    public String getNumeroResultante() {
        return numeroResultante;
    }

    public void setNumeroResultante(String numeroResultante) {
        this.numeroResultante = numeroResultante;
    }

    //Sobrescrevendo o toString do objeto
    @Override
    public String toString() {
        if (this.getNumeroAnterior() == null) {
            return "\nDescricao: ".concat(this.descricao);
        } else {
            return this.getNumeroAnterior().concat(" >> ").concat(this.getNumeroResultante()).concat("\nDescricao: ").concat(this.descricao).concat("\n\n");
        }
    }
}
