import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Time {
    private final String nome;
    private final Produto produto;
    private final List<Funcionario> desenvolvedores = new ArrayList<>();
    private final List<Sprint> sprints = new ArrayList<>();

    public Time(String nome, Produto produto, Funcionario gerente) {
        if (Objects.requireNonNull(nome, "Nome obrigatório.").isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        this.nome = nome.trim();
        this.produto = Objects.requireNonNull(produto, "Produto obrigatório.");
        if (produto.getTime() != null) {
            throw new IllegalArgumentException("O produto já possui um time responsável.");
        }
        definirGerente(gerente);
        produto.vincularTime(this);
    }

    public String getNome() {
        return nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public Funcionario getGerente() {
        return produto.getGerente();
    }

    public List<Funcionario> getDesenvolvedores() {
        return List.copyOf(desenvolvedores);
    }

    public List<Sprint> getSprints() {
        return List.copyOf(sprints);
    }

    public Sprint getSprintAtual() {
        if (sprints.isEmpty()) {
            return null;
        }
        Sprint ultima = sprints.get(sprints.size() - 1);
        return ultima.isEncerrada() ? null : ultima;
    }

    public void adicionarDesenvolvedor(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Desenvolvedor obrigatório.");
        if (!funcionario.possuiPapel(PapelDesenvolvedor.class)) {
            throw new IllegalArgumentException("O funcionário deve ser desenvolvedor.");
        }
        validarVinculo(funcionario);
        if (!desenvolvedores.contains(funcionario)) {
            if (funcionario.possuiPapel(PapelLider.class)) {
                throw new IllegalArgumentException("A liderança deve ser definida pela Sprint do time.");
            }
            desenvolvedores.add(funcionario);
            funcionario.vincularTime(this);
        }
    }

    public void removerDesenvolvedor(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Desenvolvedor obrigatório.");
        validarSaidaDoDesenvolvedor(funcionario);
        if (desenvolvedores.remove(funcionario)) {
            funcionario.vincularTime(null);
        }
    }

    public void definirGerente(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Gerente obrigatório.");
        if (!funcionario.possuiPapel(PapelGerente.class)) {
            throw new IllegalArgumentException("O funcionário deve exercer exclusivamente o papel de gerente.");
        }
        validarVinculo(funcionario);
        Funcionario anterior = getGerente();
        if (anterior != null && anterior != funcionario) {
            anterior.vincularTime(null);
        }
        produto.definirGerente(funcionario);
        funcionario.vincularTime(this);
    }

    public Sprint iniciarSprint(int numero, LocalDate inicio, LocalDate fim, Funcionario lider) {
        return new Sprint(numero, inicio, fim, this, lider);
    }

    private void validarVinculo(Funcionario funcionario) {
        if (funcionario.getTime() != null && funcionario.getTime() != this) {
            throw new IllegalArgumentException("O funcionário já pertence a outro time.");
        }
    }

    private void validarSaidaDoDesenvolvedor(Funcionario funcionario) {
        Sprint atual = getSprintAtual();
        if (atual != null && atual.getLider() == funcionario) {
            throw new IllegalStateException("Defina outro líder ou encerre a Sprint antes de retirar o desenvolvedor.");
        }
    }

    void promoverAGerente(Funcionario funcionario) {
        if (!desenvolvedores.contains(funcionario)) {
            throw new IllegalArgumentException("O desenvolvedor deve pertencer ao time.");
        }
        validarSaidaDoDesenvolvedor(funcionario);
        getGerente().vincularTime(null);
        desenvolvedores.remove(funcionario);
        funcionario.substituirPapeis(new PapelGerente());
        produto.definirGerente(funcionario);
    }

    void registrarSprint(Sprint sprint, Funcionario lider) {
        validarLider(sprint, lider);
        if (!sprints.isEmpty()) {
            Sprint anterior = sprints.get(sprints.size() - 1);
            if (sprint.getNumero() <= anterior.getNumero()) {
                throw new IllegalArgumentException("O número da Sprint deve ser maior que o da anterior.");
            }
            if (!sprint.getInicio().isAfter(anterior.getFim())) {
                throw new IllegalArgumentException("As Sprints do time não podem ter datas sobrepostas.");
            }
            anterior.encerrar();
        }
        sprints.add(sprint);
        sprint.definirLider(lider);
    }

    void validarLider(Sprint sprint, Funcionario lider) {
        Objects.requireNonNull(lider, "Líder obrigatório.");
        if (!desenvolvedores.contains(lider) || !lider.possuiPapel(PapelDesenvolvedor.class)) {
            throw new IllegalArgumentException("O líder deve ser um desenvolvedor do próprio time.");
        }
        int indice = sprints.indexOf(sprint);
        int indiceAnterior = indice < 0 ? sprints.size() - 1 : indice - 1;
        if (indiceAnterior >= 0 && sprints.get(indiceAnterior).getLider() == lider) {
            throw new IllegalArgumentException("O líder deve ser diferente do líder da Sprint anterior.");
        }
    }
}
