package modelo;

public class Endereco {
    private String rua; 
    private int  numero;
    private String Bairro; 
    private String cidade;
    
    
    public Endereco(String rua, int numero, String bairro, String cidade) {
        this.rua = rua;
        this.numero = numero;
        Bairro = bairro;
        this.cidade = cidade;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return Bairro;
    }
    public void setBairro(String bairro) {
        Bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }   

}
