public class Sprint {

    private String nome;
    private Funcionario lider;
    private boolean encerrada;

    public Sprint(String nome, Funcionario lider) {
        this.nome = nome;
        this.lider = lider;
        this.encerrada = false;
        lider.adicionarPapel(new Lider(this));
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getLider() {
        return lider;
    }

    public boolean encerrada() {
        return encerrada;
    }

    /** Encerra a sprint e devolve o líder ao papel exclusivo de desenvolvedor. */
    public void encerrar() {
        if (encerrada) {
            return;
        }
        encerrada = true;
        lider.removerPapel(lider.getPapel(Lider.class, this));
    }
}
