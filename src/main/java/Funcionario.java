public class Funcionario {
    private String id;
    private String nome;
    private Funcao funcao;

    public Funcionario(String id, String nome, Funcao funcao) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id invalido");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome invalido");
        }
        if (funcao == null) {
            throw new IllegalArgumentException("funcao invalida");
        }
        this.id = id.trim();
        this.nome = nome.trim();
        this.funcao = funcao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void defineFuncao(Funcao funcao) {
        if (funcao == null) {
            throw new IllegalArgumentException("funcao invalida");
        }
        this.funcao = funcao;
    }
}
