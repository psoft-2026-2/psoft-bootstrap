public class Endereco {
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;

    public Endereco(String cidade, String bairro, String rua, int numero) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String novaCidade) {
        this.cidade = novaCidade;
    }

    public String getBairro() {
        return this.bairro;
    }
    public void setBairro(String novoBairro) {
        this.bairro = novoBairro;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String novaRua) {
        this.rua = novaRua;
    }

    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int novoNumero) {
        this.numero = novoNumero;
    }
}