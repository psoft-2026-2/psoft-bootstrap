import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private Cargo cargo;
    private List<Funcao> funcoes = new ArrayList<>();

    public Funcionario(String nome) {
        this.nome = nome;
        this.cargo = new Desenvolvedor();
    }

    public void promover(Cargo novoCargo) {
        if (!cargo.podePromoverPara(novoCargo)) {
            throw new IllegalStateException(cargo.getNome() + " não pode virar " + novoCargo.getNome());
        }
        cargo = novoCargo;
    }

    public void adicionarFuncao(Funcao funcao) {
        funcoes.add(funcao);
    }

    public void removerFuncao(Funcao funcao) {
        funcoes.remove(funcao);
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }
}