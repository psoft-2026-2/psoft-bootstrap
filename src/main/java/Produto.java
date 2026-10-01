import java.util.Objects;

public final class Produto {
    private final String nome;
    private final String descricao;
    private Funcionario gerente;
    private Time time;
    private Empresa empresa;

    public Produto(String nome, String descricao) {
        if (Objects.requireNonNull(nome, "Nome obrigatório.").isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        this.nome = nome.trim();
        this.descricao = Objects.requireNonNull(descricao, "Descrição obrigatória.");
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public Time getTime() {
        return time;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    void vincularTime(Time time) {
        this.time = time;
    }

    void definirGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    void vincularEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
