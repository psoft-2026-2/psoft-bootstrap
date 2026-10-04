import java.util.Objects;

public class Cliente {
    private String nome;
    private String cpf;
    private PerfilCliente perfil;

    public Cliente(String nome, String cpf, PerfilCliente perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil != null ? perfil : PerfilCliente.STANDARD;
    }

    public Cliente(String nome, String cpf) {
        this(nome, cpf, PerfilCliente.STANDARD);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public PerfilCliente getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilCliente perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", perfil=" + perfil +
                '}';
    }
}