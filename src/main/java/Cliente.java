public class Cliente {

    private final String nome;
    private final String email;

    public Cliente(String nome, String email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail do cliente não pode ser nulo ou vazio.");
        }
        this.nome = nome.trim();
        this.email = email.trim();
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return nome + " <" + email + ">";
    }
}
