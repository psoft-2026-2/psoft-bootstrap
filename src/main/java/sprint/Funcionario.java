package sprint;

public class Funcionario {
    private String id;
    private String nome;
    private Papel papel;
    private Papel papelOriginal;

    public Funcionario(String id, String nome, Papel papelInicial) {
        this.id = id;
        this.nome = nome;
        this.papel = papelInicial;
    }

    public void promover(Papel novoPapel) {
        this.papel = novoPapel;
        this.papelOriginal = null;
    }

    public void assumirLiderancaSprint() {
        if (!(this.papel instanceof LiderTime)) {
            this.papelOriginal = this.papel;
            this.papel = new LiderTime(this.papel);
        }
    }

    public void encerrarLiderancaSprint() {
        if (this.papel instanceof LiderTime && this.papelOriginal != null) {
            this.papel = this.papelOriginal;
            this.papelOriginal = null;
        }
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public Papel getPapel() { return papel; }

    public void executarFuncao() {
        System.out.println(nome + " [" + papel.getDescricao() + "]");
        papel.executarFuncao();
    }

    @Override
    public String toString() {
        return nome + " (" + papel.getDescricao() + ")";
    }
}
