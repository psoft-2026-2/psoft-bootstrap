import java.util.Objects;

public class Pessoa {
    private final String nome;
    private Funcao funcao;
    private Papel papel;

    public Pessoa(String nome, Funcao funcao, Papel papel) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome deve ser informado.");
        }
        this.nome = nome;
        this.funcao = Objects.requireNonNull(funcao, "A funcao deve ser informada.");
        updatePapel(papel);
    }

    public String getNome() {
        return nome;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public Papel getPapel() {
        return papel;
    }

    public void updateFuncao(Funcao funcao) {
        Objects.requireNonNull(funcao, "A funcao deve ser informada.");
        boolean mesmaFuncao = this.funcao.getClass().equals(funcao.getClass());
        boolean promocao = this.funcao instanceof Desenvolvedor && funcao instanceof Gerente
                || this.funcao instanceof Gerente && funcao instanceof ProductOwner;
        if (!mesmaFuncao && !promocao) {
            throw new IllegalArgumentException("Promocao permitida: desenvolvedor para gerente, gerente para Product Owner.");
        }
        this.funcao = funcao;
        if (!(funcao instanceof Desenvolvedor)) {
            this.papel = null;
        }
    }

    public void updatePapel(Papel papel) {
        if (papel != null && !(funcao instanceof Desenvolvedor)) {
            throw new IllegalArgumentException("Somente desenvolvedores podem assumir um papel temporario.");
        }
        this.papel = papel;
    }
}