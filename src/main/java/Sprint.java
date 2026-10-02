import java.util.Objects;

public class Sprint {
    private Pessoa lider;
    private final int id;
    private final String duracao;

    public Sprint(Pessoa pessoa) {
        this(1, pessoa, "");
    }

    public Sprint(Pessoa pessoa, String duracao) {
        this(1, pessoa, duracao);
    }

    public Sprint(int id, Pessoa pessoa, String duracao) {
        if (id <= 0) {
            throw new IllegalArgumentException("O identificador deve ser positivo.");
        }
        this.id = id;
        this.duracao = Objects.requireNonNull(duracao, "A duracao deve ser informada.");
        updateLider(pessoa);
    }

    public Pessoa getLider() {
        return lider;
    }

    public int getId() {
        return id;
    }

    public String getDuracao() {
        return duracao;
    }

    public void updateLider(Pessoa pessoa) {
        Objects.requireNonNull(pessoa, "O lider deve ser informado.");
        if (!(pessoa.getFuncao() instanceof Desenvolvedor)) {
            throw new IllegalArgumentException("O lider deve ser um desenvolvedor.");
        }
        if (lider != null && lider != pessoa && lider.getPapel() instanceof Lider) {
            lider.updatePapel(null);
        }
        pessoa.updatePapel(new Lider());
        lider = pessoa;
    }
}