public class Usuario {
    private String nome;
    private Assinatura assinatura;
    private int id;

    public Usuario(String nome, Assinatura assinatura, int id) {
        this.nome = nome;
        this.assinatura = assinatura;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public int getId() {
        return id;
    }
}