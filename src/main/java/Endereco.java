import java.util.Objects;

public class Endereco{
    private static int idCount =1;
    private int id;
    private String rua;
    private String bairro;
    private int numero;
    private String cep;
    private String cidade;

    public Endereco(String rua, String bairro, int numero, String cep, String cidade){
        this.id = idCount++;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }

    public boolean enderecoGemeo(String rua, String bairro, int numero, String cep, String cidade) {
        return this.rua.equals(rua) && 
               this.bairro.equals(bairro) && 
               this.numero == numero && 
               this.cep.equals(cep) && 
               this.cidade.equals(cidade);
    }

    public int getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return id == endereco.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", rua=" + rua + ", bairro=" + bairro + 
               ", numero=" + numero + ", cep=" + cep + ", cidade=" + cidade + "]";
    }
}
