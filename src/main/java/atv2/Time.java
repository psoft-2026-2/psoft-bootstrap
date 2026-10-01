package atv2;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private Funcionario gerente;
    private List<Funcionario> desenvolvedores = new ArrayList<>();
    private Produto produto;
    private List<Sprint> sprints = new ArrayList<>();

    public Time(Produto produto) { this.produto = produto; }

    public void adicionarDesenvolvedor(Funcionario f) { desenvolvedores.add(f); }
    public void removerDesenvolvedor(Funcionario f) { desenvolvedores.remove(f); }
    public void setGerente(Funcionario g) { this.gerente = g; }
    public Funcionario getGerente() { return gerente; }
    public Produto getProduto() { return produto; }

    public Sprint iniciarSprint() {
        Funcionario lider = escolherNovoLider();
        Sprint s = new Sprint(sprints.size() + 1, lider, new PapelLider());
        s.iniciar();
        sprints.add(s);
        return s;
    }

    public void encerrarSprintAtual() {
        if (!sprints.isEmpty()) sprints.get(sprints.size() - 1).encerrar();
    }

    private Funcionario escolherNovoLider() {
        if (desenvolvedores.isEmpty())
            throw new IllegalStateException("O time não tem desenvolvedores");
        return desenvolvedores.get(sprints.size() % desenvolvedores.size());
    }
}