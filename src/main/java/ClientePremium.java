public class ClientePremium implements Cliente {
    private String nome;
    private String cpf;

    public ClientePremium(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public double getDescontoAdicional() {
        return 0.05; 
    }
}