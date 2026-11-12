package modelo;

public class Endereco {

    private final String logradouro;
    private final String cidade;
    private final String estado;

    public Endereco(String logradouro, String cidade, String estado) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return logradouro + ", " + cidade + " - " + estado;
    }
}