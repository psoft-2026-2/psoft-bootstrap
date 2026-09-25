public class Cliente {

    private String nome;
    private final String cpf;
    private String assinatura;

    public Cliente(String nome, String cpf, String assinatura) {
        this.nome = nome;
        this.cpf = cpf;
        this.assinatura = assinatura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }
}