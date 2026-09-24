import java.util.Objects;
import java.util.UUID;

public class Cliente {

    private final String id;
    private final String nome;
    private final String cpf;
    private final Ass assinatura;

    public Cliente(String nome, String cpf, Ass assinatura) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }
        if (assinatura == null) {
            throw new IllegalArgumentException("Assinatura não pode ser nula");
        }
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cpf = cpf;
        this.assinatura = assinatura;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Ass getAssinatura() {
        return assinatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}