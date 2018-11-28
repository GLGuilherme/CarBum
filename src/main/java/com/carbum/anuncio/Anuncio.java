package com.carbum.anuncio;

public class Anuncio {
    private String parteCarro;
    private String descricao;
    private String conservacao;
    private String nomeCarro;
    private String marcaCarro;
    private String ano;
    private String modelo;
    private String imagem1;
    private String imagem2;
    private String preco;
    private int idUsuario;
    private int anuncioVip;

    public Anuncio() {
    }

    public Anuncio(String parteCarro, String descricao, String conservacao, String nomeCarro,
                   String marcaCarro, String ano, String modelo, String imagem1, String imagem2, String preco, int idUsuario, int anuncioVip) {
        this.parteCarro = parteCarro;
        this.descricao = descricao;
        this.conservacao = conservacao;
        this.nomeCarro = nomeCarro;
        this.marcaCarro = marcaCarro;
        this.ano = ano;
        this.modelo = modelo;
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.preco = preco;
        this.idUsuario = idUsuario;
        this.anuncioVip = anuncioVip;
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

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getAnuncioVip() {
        return anuncioVip;
    }

    public void setAnuncioVip(int anuncioVip) {
        this.anuncioVip = anuncioVip;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
