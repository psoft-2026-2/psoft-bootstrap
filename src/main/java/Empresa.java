import java.util.ArrayList;

public class Empresa {
    private String nome;
    private int cod;
    private Programador productOwner;
    private ArrayList<Produto> produtos;
    private ArrayList<Time> times;
    private ArrayList<Programador> programadores;

    public Empresa(String nome, int cod) {
        this.nome = nome;
        this.cod = cod;
        this.produtos = new ArrayList<>();
        this.times = new ArrayList<>();
        this.programadores = new ArrayList<>();
    }

    public String criarProduto(String nome, int cod) {
        produtos.add(new Produto(nome, cod));
        return "Produto " + nome + " criado.";
    }

    public String criarProgramador(String nome, String cpf) {
        programadores.add(new Programador(nome, cpf, new Desenvolvedor()));
        return "Programador " + nome + " criado.";
    }
    
    public void criarTime(String nome, int cod, String lider, String produto) {
        Programador l = buscarProgramador(lider);
        Produto p = buscarProduto(produto);
        if (l == null || p == null) {
            throw new IllegalArgumentException("Líder ou produto não encontrado.");
        }
        times.add(new Time(nome, cod, l, p, new Sprint("Sprint 1", 14)));
    }

    // extra: define o Product Owner (gerente promovido)
    public String definirProductOwner(String cpf) {
        Programador p = buscarProgramador(cpf);
        if (p == null) throw new IllegalArgumentException("Programador não encontrado.");
        String r = p.promover(new ProductOwner());
        this.productOwner = p;
        return r;
    }

    public Programador buscarProgramador(String cpf) {
        for (Programador p : programadores) if (p.getCpf().equals(cpf)) return p;
        return null;
    }

    public Produto buscarProduto(String nome) {
        for (Produto p : produtos) if (p.getNome().equals(nome)) return p;
        return null;
    }

    public Time buscarTime(String nome) {
        for (Time t : times) if (t.toString().startsWith("Time " + nome + " ")) return t;
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Empresa " + nome + " (cod: " + cod + ")\n");
        sb.append("Product Owner: " + (productOwner == null ? "-" : productOwner.getNome()) + "\n");
        for (Produto p : produtos) sb.append(p + "\n");
        for (Time t : times) sb.append(t);
        return sb.toString();
    }
}