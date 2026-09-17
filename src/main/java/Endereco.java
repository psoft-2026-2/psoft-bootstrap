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


    public String getcidade() {
        return this.cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getCep() {
        return this.cep;
    }


    public void setCep(String cep) {
        this.cep = cep;
    }


    public String getRua() {
        return this.rua;
    }


    public void setRua(String rua) {
        this.rua = rua;
    }


    public String getBairro() {
        return this.bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public int getNumero() {
        return this.numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    @Override
    public String toString() {
        return "---ENDEREÇO--- \ncidade: " + this.cidade + "\ncep: " + this.cep + "\nrua: " + this.rua
        + "\nbairro: " + this.bairro + "\nnúmero: " + this.numero + "\n--------------";
    }
}

