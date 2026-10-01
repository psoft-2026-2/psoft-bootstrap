import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Funcionario {
    private final String nome;
    private final List<Papel> papeis = new ArrayList<>();
    private Time time;

    public Funcionario(String nome) {
        this(nome, new PapelDesenvolvedor());
    }

    public Funcionario(String nome, Papel papelInicial) {
        if (Objects.requireNonNull(nome, "Nome obrigatório.").isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        this.nome = nome.trim();
        adicionarPapel(papelInicial);
    }

    public String getNome() {
        return nome;
    }

    public List<Papel> getPapeis() {
        return List.copyOf(papeis);
    }

    public Time getTime() {
        return time;
    }

    public void adicionarPapel(Papel papel) {
        Objects.requireNonNull(papel, "Papel obrigatório.");
        if (possuiPapel(papel.getClass())) {
            return;
        }
        List<Papel> novosPapeis = new ArrayList<>(papeis);
        novosPapeis.add(papel);
        validarPapeis(novosPapeis);
        if (papel instanceof PapelLider
                && (time == null || time.getSprintAtual() == null || time.getSprintAtual().getLider() != this)) {
            throw new IllegalStateException("Defina a liderança pela Sprint do time.");
        }
        papeis.add(papel);
    }

    public void removerPapel(Papel papel) {
        Objects.requireNonNull(papel, "Papel obrigatório.");
        if (!possuiPapel(papel.getClass())) {
            return;
        }
        if (papel instanceof PapelLider && time != null
                && time.getSprintAtual() != null && time.getSprintAtual().getLider() == this) {
            throw new IllegalStateException("Troque o líder ou encerre a Sprint antes de remover o papel.");
        }
        List<Papel> novosPapeis = new ArrayList<>(papeis);
        novosPapeis.removeIf(atual -> atual.getClass().equals(papel.getClass()));
        validarPapeis(novosPapeis);
        papeis.clear();
        papeis.addAll(novosPapeis);
    }

    public boolean possuiPapel(Class<? extends Papel> classe) {
        Objects.requireNonNull(classe, "Classe do papel obrigatória.");
        return papeis.stream().anyMatch(classe::isInstance);
    }

    public void promover(Promocao promocao) {
        Objects.requireNonNull(promocao, "Promoção obrigatória.").aplicar(this);
    }

    private void validarPapeis(List<Papel> novosPapeis) {
        if (novosPapeis.isEmpty()) {
            throw new IllegalArgumentException("Um funcionário deve possuir pelo menos um papel.");
        }
        boolean exclusivo = novosPapeis.stream()
                .anyMatch(p -> p instanceof PapelGerente || p instanceof PapelProductOwner);
        if (exclusivo && novosPapeis.size() != 1) {
            throw new IllegalArgumentException("Gerente e Product Owner exercem exclusivamente sua função.");
        }
        boolean lider = novosPapeis.stream().anyMatch(p -> p instanceof PapelLider);
        boolean desenvolvedor = novosPapeis.stream().anyMatch(p -> p instanceof PapelDesenvolvedor);
        if (lider && !desenvolvedor) {
            throw new IllegalArgumentException("O líder também precisa ser desenvolvedor.");
        }
    }

    void vincularTime(Time time) {
        this.time = time;
    }

    void substituirPapeis(Papel papel) {
        validarPapeis(List.of(papel));
        papeis.clear();
        papeis.add(papel);
    }

    void retirarLideranca() {
        papeis.removeIf(papel -> papel instanceof PapelLider);
    }
}
