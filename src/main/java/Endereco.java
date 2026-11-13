import java.util.Objects;

public class Endereco {
    private final String logradouro;
    private final String numero;
    private final String cidade;
    private final String cep;

    public Endereco(String logradouro, String numero, String cidade, String cep) {
        this.logradouro = validarTexto(logradouro, "O logradouro");
        this.numero = validarTexto(numero, "O número");
        this.cidade = validarTexto(cidade, "A cidade");
        this.cep = validarTexto(cep, "O CEP");
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    private static String validarTexto(String valor, String nomeCampo) {
        String texto = Objects.requireNonNull(valor, nomeCampo + " é obrigatório").trim();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException(nomeCampo + " é obrigatório.");
        }
        return texto;
    }
}
