package br.ufcg.psoft.atv5;

public class Endereco {
    private final String rua;
    private final String cidade;
    private final String cep;

    public Endereco(String rua, String cidade, String cep) {
        if (rua == null || rua.isBlank() || cidade == null || cidade.isBlank()
                || cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("Rua, cidade e CEP são obrigatórios.");
        }
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return rua + ", " + cidade + " - " + cep;
    }
}
