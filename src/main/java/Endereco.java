public class Endereco {
    private String cidade;
    private String cep;
    private String rua;
    private String bairro;
    private int numero;

    public Endereco(String cidade, String cep, String rua, String bairro, int numero) {
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString() {
        return "---ENDEREÇO--- \ncidade: " + this.cidade + "\ncep: " + this.cep + "\nrua: " + this.rua
        + "\nbairro: " + this.bairro + "\nnúmero: " + this.numero + "\n--------------";
    }
}
