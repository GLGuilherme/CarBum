package com.carbum.peca;

public class Peca {
    private String nomePeca;
    private String parteCarro;
    private String consevacao;
    private String descricao;

    public Peca() {
    }

    public Peca(String titulo, String descricao) {
        this.nomePeca = titulo;
        this.descricao = descricao;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public String getParteCarro() {
        return parteCarro;
    }

    public void setParteCarro(String parteCarro) {
        this.parteCarro = parteCarro;
    }

    public String getConsevacao() {
        return consevacao;
    }

    public void setConsevacao(String consevacao) {
        this.consevacao = consevacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
