public class Sprint {
    private int numero;
    private Funcionario lider;
    private boolean encerrada;

    public Sprint(int num, Funcionario lider) {
        if (!lider.possuiPapel("Desenvolvedor")) {
            throw new IllegalArgumentException("O líder da sprint deve ser um desenvolvedor.");
        }
        this.numero = num;
        this.lider = lider;
        this.encerrada = false;
        lider.adicionarPapel(new Lider());
    }

    public int getNumero() {
        return numero;
    }

    public Funcionario getLider() {
        return lider;
    }

    public boolean isEncerrada() {
        return encerrada;
    }

    public void encerrar() {
        if (!encerrada) {
            lider.removerPapel(new Lider());
            encerrada = true;
        }
    }
}
