import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Time {
    private Pessoa gerente;
    private final List<Pessoa> pessoas;

    public Time(Pessoa gerente) {
        Objects.requireNonNull(gerente, "O gerente deve ser informado.");
        if (!(gerente.getFuncao() instanceof Gerente)) {
            throw new IllegalArgumentException("O responsavel pelo time deve exercer a funcao de gerente.");
        }
        this.gerente = gerente;
        this.pessoas = new ArrayList<>();
    }

    public Pessoa getGerente() {
        return gerente != null && gerente.getFuncao() instanceof Gerente ? gerente : null;
    }

    public List<Pessoa> getPessoas() {
        List<Pessoa> desenvolvedores = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getFuncao() instanceof Desenvolvedor) {
                desenvolvedores.add(pessoa);
            }
        }
        return Collections.unmodifiableList(desenvolvedores);
    }

    public void updateGerente(Pessoa pessoa) {
        Objects.requireNonNull(pessoa, "O gerente deve ser informado.");
        if (pessoa.getFuncao() instanceof Desenvolvedor) {
            if (!pessoas.contains(pessoa)) {
                throw new IllegalArgumentException("O desenvolvedor deve pertencer ao time.");
            }
            pessoa.updateFuncao(new Gerente());
        } else if (!(pessoa.getFuncao() instanceof Gerente)) {
            throw new IllegalArgumentException("A pessoa deve ser um gerente ou desenvolvedor do time.");
        }
        pessoas.remove(pessoa);
        gerente = pessoa;
    }

    public void adicionaPessoa(Pessoa pessoa) {
        Objects.requireNonNull(pessoa, "A pessoa deve ser informada.");
        if (!(pessoa.getFuncao() instanceof Desenvolvedor)) {
            throw new IllegalArgumentException("Somente desenvolvedores podem ser adicionados ao time.");
        }
        if (pessoas.contains(pessoa)) {
            throw new IllegalArgumentException("A pessoa ja pertence ao time.");
        }
        pessoas.add(pessoa);
    }
}