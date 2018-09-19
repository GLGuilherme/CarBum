package main.Endereco;

public class Endereco {
    private String Pais;
    private String Estado;
    private String Cidade;
    private String Rua;
    private String Numero;
    private String Bairro;
    private String CEP;
    private String Complemento;
    private String LinkGoogleMaps;

    public Endereco(String Pais, String Estado, String Cidade, String Rua, String Numero, String Bairro, String CEP, String Complemento){
        this.Pais = Pais;
        this.Estado = Estado;
        this.Cidade = Cidade;
        this.Rua = Rua;
        this.Numero = Numero;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Complemento = Complemento;
    }

    public String getPais() {
        return Pais;
    }

    public String getCidade() {
        return Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public String getNumero() {
        return Numero;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getBairro() {
        return Bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public String getRua() {
        return Rua;
    }

    public String getComplemento() {
        return Complemento;
    }

    public String getLinkGoogleMaps() {
        return LinkGoogleMaps;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public void setCEP(String CEP) {
        CEP = CEP;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public void setLinkGoogleMaps(String linkGoogleMaps) {
        LinkGoogleMaps = linkGoogleMaps;
    }

}


