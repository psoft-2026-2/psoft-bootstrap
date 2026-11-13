import java.util.Objects;

public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String telefone, String endereco) {
        this.nome = exigirTexto(nome, "nome");
        this.telefone = exigirTexto(telefone, "telefone");
        this.endereco = exigirTexto(endereco, "endereco");
    }

    private static String exigirTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " nao pode ser vazio");
        }
        return valor;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente)) return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(nome, other.nome)
                && Objects.equals(telefone, other.telefone)
                && Objects.equals(endereco, other.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, endereco);
    }

    @Override
    public String toString() {
        return "Cliente{nome='" + nome + "', telefone='" + telefone + "', endereco='" + endereco + "'}";
    }
}
