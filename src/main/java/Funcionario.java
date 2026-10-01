import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private String cpf;
    private String admissao;
    private List<Funcao> funcoes;

    public Funcionario(String nome, String cpf, String admissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.admissao = admissao;
        this.funcoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAdmissao() {
        return admissao;
    }

    public List<Funcao> getFuncoes() {
        return new ArrayList<>(funcoes);
    }

    public void adicionarFuncao(Funcao funcao) {
        if (funcao == null) {
            throw new IllegalArgumentException("Função inválida");
        }

        if (!temFuncao(funcao.getClass())) {
            funcoes.add(funcao);
        }
    }

    public void removerFuncao(Class<? extends Funcao> tipo) {
        funcoes.removeIf(tipo::isInstance);
    }

    public boolean temFuncao(Class<? extends Funcao> tipo) {
        return funcoes.stream().anyMatch(tipo::isInstance);
    }

    public void assumirLideranca() {
        if (!temFuncao(Desenvolvedor.class)) {
            throw new IllegalStateException(
                "Somente um desenvolvedor pode liderar a Sprint"
            );
        }

        adicionarFuncao(new Lider());
    }

    public void promoverParaGerente() {
        removerFuncao(Desenvolvedor.class);
        removerFuncao(Lider.class);
        adicionarFuncao(new Gerente());
    }

    public void promoverParaProductOwner() {
        removerFuncao(Gerente.class);
        adicionarFuncao(new ProductOwner());
    }
}