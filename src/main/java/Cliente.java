import java.util.Objects;

public class Cliente {
    private final String nome;
    private final String email;
    private final String telefone;

    public Cliente(String nome, String email, String telefone) {
        this.nome = validarTexto(nome, "O nome");
        this.email = validarTexto(email, "O e-mail");
        this.telefone = validarTexto(telefone, "O telefone");
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    private static String validarTexto(String valor, String nomeCampo) {
        String texto = Objects.requireNonNull(valor, nomeCampo + " é obrigatório").trim();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException(nomeCampo + " é obrigatório.");
        }
        return texto;
    }
}
