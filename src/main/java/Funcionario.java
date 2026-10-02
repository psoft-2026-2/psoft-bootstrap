import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private static int proximoId = 1;

    private String nome;
    private int id;
    private List<Funcao> funcoes;

    public Funcionario(String nome) {
        this.nome = nome;
        this.id = proximoId++;
        this.funcoes = new ArrayList<>();
    }

    public boolean addFuncao(Funcao f) {
        for (Funcao funcao : funcoes) {
            if (funcao.getClass().equals(f.getClass())) {
                return false;
            }
        }

        funcoes.add(f);
        return true;
    }

    public boolean removeFuncao(Funcao f) {
        return funcoes.removeIf(funcao -> funcao.getClass().equals(f.getClass()));
    }

    public boolean promove() {
        if (possuiFuncao(Gerente.class)) {
            funcoes.clear();
            funcoes.add(new ProductOwner());
            return true;
        }

        if (possuiFuncao(Desenvolvedor.class)) {
            funcoes.clear();
            funcoes.add(new Gerente());
            return true;
        }

        return false;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public boolean possuiFuncao(Class<? extends Funcao> tipo) {
        for (Funcao funcao : funcoes) {
            if (tipo.isInstance(funcao)) {
                return true;
            }
        }

        return false;
    }
}
