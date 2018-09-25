package com.carbum.pessoa;

public class Pessoa {
    private String nome;
    private String emailLogin;
    private String senha;
    private String CPF;
    private float avaliacao;

    public Pessoa() {
    }

    public Pessoa(String nome, String emailLogin, String senha) {
        this.nome = nome;
        this.emailLogin = emailLogin;
        this.senha = senha;
        this.avaliacao = 0;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
