package com.carbum.carro;

public class Carro {
    private String nomeCarro;
    private String marca;
    private String ano;
    private String modelo;

    public Carro() {
    }

    public Carro(String nomeCarro, String marca, String ano, String modelo) {
        this.nomeCarro = nomeCarro;
        this.marca = marca;
        this.ano = ano;
        this.modelo = modelo;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
}
