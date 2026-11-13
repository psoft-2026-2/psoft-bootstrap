public class Priority {
    private final String nome;
    private final double adicionalCusto;

    public Priority(String nome, double adicionalCusto) {
        this.nome = nome;
        this.adicionalCusto = adicionalCusto;
    }

    public String getNome() {
        return nome;
    }

    public double getAdicionalCusto() {
        return adicionalCusto;
    }

}
