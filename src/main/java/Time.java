import java.util.ArrayList;

public class Time {
    private String nome;
    private int cod;
    private Programador lider;
    private Produto produto;
    private Sprint sprint;
    private ArrayList<Programador> membros;

    public Time(String nome, int cod, Programador lider, Produto produto, Sprint sprint) {
        this.nome = nome;
        this.cod = cod;
        this.produto = produto;
        this.sprint = sprint;
        this.membros = new ArrayList<>();
        if (!(lider.getPapel() instanceof Desenvolvedor)) {
            throw new IllegalArgumentException("O líder deve ser um desenvolvedor.");
        }
        this.lider = lider;
        lider.setPapel(new Lider());
        this.membros.add(lider);
    }

    public String addMembro(Programador programador) {
        if (programador.getPapel() instanceof ProductOwner) {
            throw new IllegalArgumentException("Product Owner não faz parte de um time.");
        }
        if (membros.contains(programador)) {
            return programador.getNome() + " já está no time.";
        }
        membros.add(programador);
        return programador.getNome() + " adicionado(a) ao time " + nome;
    }

    public String mudaLider(Programador programador) {
        if (!membros.contains(programador)) {
            throw new IllegalArgumentException("O novo líder deve ser membro do time.");
        }
        if (!(programador.getPapel() instanceof Desenvolvedor)) {
            throw new IllegalArgumentException("Apenas um desenvolvedor pode virar líder.");
        }
        lider.setPapel(new Desenvolvedor());
        lider = programador;
        lider.setPapel(new Lider());
        return "Novo líder do time " + nome + ": " + lider.getNome();
    }

    public Programador getMembros(String cpf) {
        for (Programador p : membros) {
            if (p.getCpf().equals(cpf)) return p;
        }
        return null;
    }

    public Programador getLider() { return lider; }

    public String novaSprint(String nome, int duracao) {
        this.sprint = new Sprint(nome, duracao);
        return "Nova sprint criada: " + sprint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Time " + nome + " (cod: " + cod + ")\n");
        sb.append("  " + produto + "\n  " + sprint + "\n  Líder: " + lider.getNome() + "\n  Membros:\n");
        for (Programador p : membros) sb.append("    - " + p + "\n");
        return sb.toString();
    }
}