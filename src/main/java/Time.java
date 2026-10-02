import java.util.ArrayList;
import java.util.List;

public class Time {

    private Produto produto;
    private List<Funcionario> equipe = new ArrayList<>();
    private Funcionario gerente;
    private Funcionario lider;
    private List<Sprint> sprints = new ArrayList<>();

    public Time(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Todo time é responsável por um produto.");
        }
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public Funcionario getLider() {
        return lider;
    }

    public List<Funcionario> getDesenvolvedores() {
        return equipe;
    }

    public void adicionarDesenvolvedor(Funcionario pessoa) {
        if (equipe.contains(pessoa) || pessoa.equals(gerente)) {
            throw new IllegalStateException(pessoa.getNome() + " já faz parte do time.");
        }
        
        pessoa.assumirPapel(new Desenvolvedor());
        equipe.add(pessoa);
    }

    public void definirGerente(Funcionario func) {
        if (gerente != null) {
            throw new IllegalStateException("O time já possui gerente.");
        }
        
        if (!func.possuiPapel("Gerente")) {
            throw new IllegalArgumentException(func.getNome() + " não é Gerente.");
        }
        
        this.gerente = func;
    }

    public void removerGerente() {
        this.gerente = null;
    }

    public void removerDesenvolvedor(Funcionario func) {
        if (!equipe.remove(func)) {
            throw new IllegalArgumentException(func.getNome() + " não está neste time.");
        }
        
        if (func.equals(lider)) {
            lider = null;
        }
    }

    public Funcionario rotacionarLider() {
        if (equipe.isEmpty()) {
            throw new IllegalStateException("O time não possui desenvolvedores.");
        }
        
        int proximo = (lider == null) ? 0 : (equipe.indexOf(lider) + 1) % equipe.size();
        
        if (lider != null) {
            lider.abandonarPapel(Lider.class);
        }

        lider = equipe.get(proximo);
        lider.assumirPapel(new Lider());
        
        return lider;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public Sprint iniciarSprint(Time time) {
        Funcionario lider = time.rotacionarLider();
        Sprint sprint = new Sprint(numeroDaProximaSprint(time), time, lider);
        sprints.add(sprint);
        return sprint;
    }

    private int numeroDaProximaSprint(Time time) {
        return (int) sprints.stream().filter(s -> s.getTime() == time).count() + 1;
    }
}