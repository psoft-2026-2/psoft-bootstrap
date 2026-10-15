public class Cliente {
    private int idCliente;
    private String nome;
    private Assinatura assinatura;

    public Cliente(int idCliente, String nome, Assinatura assinatura) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.assinatura = assinatura;
    }

    public int getId() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
}
