public class Endereco {

    private String rua;
    private int numero;
    private String bairro;
    private String cidade;

    public Endereco(String rua, int num, String bairro, String cidade){
        this.rua = rua;
        this.numero = num;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua(){
        return this.rua;
    }

    public void setRua(String novaRua){
        this.rua = novaRua;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int novoNum){
        this.numero = novoNum;
    }

    public String getBairro(){
        return this.bairro;
    }

    public void setBairro(String novoBairro){
        this.bairro = novoBairro;
    }

    public String getCidade(){
        return this.cidade;
    }

    public void setCidade(String novaCidade){
        this.cidade = novaCidade;
    }

}