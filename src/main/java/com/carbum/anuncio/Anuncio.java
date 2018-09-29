package com.carbum.anuncio;

public class Anuncio {
    private String nomePeca;
    private String parteCarro;
    private String descricao;
    private String conservacao;
    private String nomeCarro;
    private String marcaCarro;
    private String ano;
    private String modelo;

    public Anuncio() {
    }

    public Anuncio(String nomePeca, String parteCarro, String descricao, String conservacao, String nomeCarro, String marcaCarro, String ano, String modelo) {
        this.nomePeca = nomePeca;
        this.parteCarro = parteCarro;
        this.descricao = descricao;
        this.conservacao = conservacao;
        this.nomeCarro = nomeCarro;
        this.marcaCarro = marcaCarro;
        this.ano = ano;
        this.modelo = modelo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
