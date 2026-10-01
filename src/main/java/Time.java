import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time {
    private String id;
    private String nome;
    private ProdutoSoftware produto;
    private Pessoa gerente;
    private List desenvolvedores;
    private List sprints; 

    public Time(String id, String nome, ProdutoSoftware produto, Pessoa gerente) {
        if (!gerente.temPapel("Gerente")) {
            throw new IllegalArgumentException("A pessoa indicada precisa ter o papel de Gerente!");
        }
        this.id = id;
        this.nome = nome;
        this.produto = produto;
        this.gerente = gerente;
        this.desenvolvedores = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public void alocarDesenvolvedor(Pessoa p) {
        if (!p.temPapel("Desenvolvedor")) {
            throw new IllegalArgumentException("A pessoa alocada precisa ter o papel de Desenvolvedor!");
        }
        if (!desenvolvedores.contains(p)) {
            desenvolvedores.add(p);
        }
    }

    public Sprint criarNovaSprint(int numero, Date inicio, Date fim, Pessoa liderSprint) {
        if (!desenvolvedores.contains(liderSprint)) {
            throw new IllegalArgumentException("O líder da Sprint deve ser um desenvolvedor do time!");
        }
        Sprint novaSprint = new Sprint(numero, inicio, fim, liderSprint);
        this.sprints.add(novaSprint);
        return novaSprint;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public ProdutoSoftware getProduto() { return produto; }
    public Pessoa getGerente() { return gerente; }
    public List getDesenvolvedores() { return desenvolvedores; }
    public List getSprints() { return sprints; }
}