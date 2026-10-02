public class ProdutoSoftware {

    private String nome, descricao;
    private Funcionario supervisor;

    public ProdutoSoftware(String nome, String descricao, Funcionario supervisor) {
        this.nome = nome;
        this.descricao = descricao;
        this.supervisor = supervisor;
    }

    public String getNome() {return nome;}

    public String getDescricao() {return descricao;}

    public Funcionario getSupervisor() {return supervisor;}

    public void setSupervisor(Funcionario supervisor) {this.supervisor = supervisor;}

    @Override
    public String toString() {
        return "ProdutoSoftware [nome=" + nome + ", descricao=" + descricao
                + ", supervisor=" + supervisor.getNome() + "]";
    }
}
