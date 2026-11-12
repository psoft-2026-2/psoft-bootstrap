package logistica;

public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(String logradouro, String numero, String cidade, String uf) {
        this(logradouro, numero, "", cidade, uf);
    }

    public Endereco(String logradouro, String numero, String complemento, String cidade, String uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return logradouro + ", " + numero + ", " + cidade + "/" + uf;
    }
}
