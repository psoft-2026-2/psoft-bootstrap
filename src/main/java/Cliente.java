public class Cliente {

    private String nome;
    private Assinatura assinatura;

    public Cliente(String nome, Assinatura assinatura) {
        this.nome = nome;
        this.assinatura = assinatura;
    }

    public Venda realizarVenda() {
        return new Venda(this);
    }

    public String getNome() {
        return nome;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }
}