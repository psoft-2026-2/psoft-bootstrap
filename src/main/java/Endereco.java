public class Endereco {

    private final String logradouro;
    private final String cidade;
    private final String cep;

    public Endereco(String logradouro, String cidade, String cep) {
        if (logradouro == null || logradouro.isBlank()) {
            throw new IllegalArgumentException("Logradouro não pode ser nulo ou vazio.");
        }
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("Cidade não pode ser nula ou vazia.");
        }
        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("CEP não pode ser nulo ou vazio.");
        }
        this.logradouro = logradouro.trim();
        this.cidade = cidade.trim();
        this.cep = cep.trim();
    }

    public String getLogradouro() { return logradouro; }
    public String getCidade() { return cidade; }
    public String getCep() { return cep; }

    @Override
    public String toString() {
        return logradouro + ", " + cidade + " - " + cep;
    }
}
