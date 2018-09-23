package com.carbum.pessoa;

public class Pessoa {
    private String Nome;
    private String EmailLogin;
    private String Senha;
    private String CPF;
    private float Avaliacao;

    public Pessoa(){}

    /*public Pessoa(String Nome, String EmailLogin, String Senha) throws SQLException {
        this.Nome = Nome;
        this.EmailLogin = EmailLogin;
        this.Senha = Senha;
        Avaliacao = 0.0;
        DAOPessoa PessoaNova = new DAOPessoa();
        PessoaNova.inserirPessoaNova(this);
    }*/

    public String getEmailLogin() {
        return EmailLogin;
    }

    public float getAvaliacao() {
        return Avaliacao;
    }

    public String getNome() {
        return Nome;
    }

    public String getSenha() {
        return Senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setAvaliacao(float avaliacao) {
        this.Avaliacao = avaliacao;
    }

    public void setEmailLogin(String emailLogin) {
        this.EmailLogin = emailLogin;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
