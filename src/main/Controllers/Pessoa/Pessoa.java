package main.Controllers.Pessoa;

public class Pessoa {
    private String Nome;
    private String EmailLogin;
    private String Senha;
    private float Avaliacao;

    public Pessoa(){}

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

    public void setAvaliacao(float avaliacao) {
        Avaliacao = avaliacao;
    }

    public void setEmailLogin(String emailLogin) {
        EmailLogin = emailLogin;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

}
