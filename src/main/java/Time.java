import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Time {

    private String nome;
    private Funcionario gerente;
    private List<Funcionario> desenvolvedores;
    private List<Sprint> sprints;
    private ProdutoSoftware produto;

    public Time(
            String nome,
            ProdutoSoftware produto,
            Funcionario gerente) {

        if (produto == null) {
            throw new IllegalArgumentException(
                    "O time deve possuir um produto."
            );
        }

        if (gerente == null) {
            throw new IllegalArgumentException(
                    "O time deve possuir um gerente."
            );
        }

        if (!gerente.temCargo(new Gerente())) {
            throw new IllegalArgumentException(
                    "O funcionário informado não possui o cargo de gerente."
            );
        }

        this.nome = nome;
        this.produto = produto;
        this.gerente = gerente;
        this.desenvolvedores = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public void adicionarDesenvolvedor(Funcionario desenvolvedor) {

        if (desenvolvedor == null) {
            throw new IllegalArgumentException(
                    "Funcionário inválido."
            );
        }

        if (!desenvolvedor.temCargo(new Desenvolvedor())) {
            throw new IllegalArgumentException(
                    "O funcionário não possui o cargo de desenvolvedor."
            );
        }

        if (!desenvolvedores.contains(desenvolvedor)) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Sprint iniciarSprint(Funcionario lider) {

        if (!desenvolvedores.contains(lider)) {
            throw new IllegalArgumentException(
                    "O líder deve ser desenvolvedor deste time."
            );
        }

        if (!lider.temCargo(new Desenvolvedor())) {
            throw new IllegalArgumentException(
                    "O líder deve possuir o cargo de desenvolvedor."
            );
        }

        if (!sprints.isEmpty()) {

            Sprint ultimaSprint =
                    sprints.get(sprints.size() - 1);

            Funcionario liderAnterior =
                    ultimaSprint.getLider();

            if (liderAnterior.equals(lider)) {
                throw new IllegalArgumentException(
                        "O líder da nova Sprint deve ser diferente do líder da Sprint anterior."
                );
            }

            liderAnterior.removerCargo(new Lider());
        }

        lider.adicionarCargo(new Lider());

        Sprint sprint = new Sprint(lider);

        sprints.add(sprint);

        return sprint;
    }

    public void removerDesenvolvedor(
            Funcionario desenvolvedor) {

        if (desenvolvedor == null) {
            return;
        }

        desenvolvedores.remove(desenvolvedor);

        desenvolvedor.removerCargo(new Lider());
    }

    public void setGerente(Funcionario funcionario) {

        boolean jaGerente =
                funcionario.temCargo(new Gerente());

        boolean desenvolvedor =
                funcionario.temCargo(new Desenvolvedor());

        if (!jaGerente && !desenvolvedor) {
            throw new IllegalArgumentException(
                    "Somente um gerente ou desenvolvedor pode assumir a gerência."
            );
        }

        if (desenvolvedor) {

            desenvolvedores.remove(funcionario);

            funcionario.removerCargo(new Lider());
            funcionario.removerCargo(new Desenvolvedor());

            funcionario.adicionarCargo(new Gerente());
        }

        this.gerente = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public ProdutoSoftware getProduto() {
        return produto;
    }

    public List<Funcionario> getDesenvolvedores() {
        return Collections.unmodifiableList(desenvolvedores);
    }

    public List<Sprint> getSprints() {
        return Collections.unmodifiableList(sprints);
    }
}