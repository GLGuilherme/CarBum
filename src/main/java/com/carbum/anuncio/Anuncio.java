package com.carbum.anuncio;

public class Anuncio {
    private String titulo;
    private String parteCarro;
    private String descricao;
    private String conservacao;
    private String nomeCarro;
    private String marcaCarro;
    private String ano;
    private String modelo;
    private String imagem1;

    public Anuncio() {
    }

    public Anuncio(String titulo, String parteCarro, String descricao, String conservacao, String nomeCarro, String marcaCarro, String ano, String modelo, String imagem1) {
        this.titulo = titulo;
        this.parteCarro = parteCarro;
        this.descricao = descricao;
        this.conservacao = conservacao;
        this.nomeCarro = nomeCarro;
        this.marcaCarro = marcaCarro;
        this.ano = ano;
        this.modelo = modelo;
        this.imagem1 = imagem1;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
