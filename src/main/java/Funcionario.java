package atv2;

public class Funcionario {
    private String id;
    private String nome;
    private Cargo cargo;

    public Funcionario(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.cargo = new Desenvolvedor();
    }

    public void assumirLideranca() {
        if (!(cargo instanceof Desenvolvedor)) {
            throw new IllegalStateException("Só desenvolvedor pode ser líder.");
        }
        cargo = new Lider();
    }

    public void deixarLideranca() {
        if (cargo instanceof Lider) {
            cargo = new Desenvolvedor();
        }
    }

    public void promoverAGerente() {
        if (!(cargo instanceof Desenvolvedor)) {
            throw new IllegalStateException("Só desenvolvedor pode virar gerente.");
        }
        cargo = new Gerente();
    }

    public void promoverAProductOwner() {
        if (!(cargo instanceof Gerente)) {
            throw new IllegalStateException("Só gerente pode virar Product Owner.");
        }
        cargo = new ProductOwner();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return nome + " (" + cargo + ")";
    }
}
