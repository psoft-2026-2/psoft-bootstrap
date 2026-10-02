import java.util.Objects;

public class Funcionario {

    private String cpf;
    private String nome;
    private FuncionarioTipo tipo;

    public Funcionario(String cpf, String nome, FuncionarioTipo tipo) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser vazio.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de funcionário não pode ser nulo.");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public FuncionarioTipo getTipo() {
        return tipo;
    }

    public void setTipo(FuncionarioTipo tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de funcionário não pode ser nulo.");
        }
        this.tipo = tipo;
    }

    public void promoverParaGerente() {
        exigirTipo(Desenvolvedor.class, "Somente um desenvolvedor pode ser promovido a gerente.");
        this.tipo = new Gerente();
    }

    public void promoverParaProductOwner() {
        exigirTipo(Gerente.class, "Somente um gerente pode ser promovido a Product Owner.");
        this.tipo = new ProductOwner();
    }

    public boolean isDesenvolvedor() {
        return tipo instanceof Desenvolvedor;
    }

    public boolean isGerente() {
        return tipo instanceof Gerente;
    }

    public boolean isProductOwner() {
        return tipo instanceof ProductOwner;
    }

    private void exigirTipo(Class<? extends FuncionarioTipo> tipoEsperado, String mensagem) {
        if (!tipoEsperado.isInstance(tipo)) {
            throw new IllegalStateException(mensagem);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Funcionario other)) return false;
        return cpf.equals(other.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo.getNome() +
                '}';
    }
}
