public class Endereco {
    private final String rua;
    private final String cidade;
    private final String cep;

    public Endereco(String rua, String cidade, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
    }

    @Override
    public String toString() { return rua + ", " + cidade + " - " + cep; }
}
