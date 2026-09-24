public class ClienteStandard implements Cliente {
    private String nome;
    private String cpf;

    public ClienteStandard(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public double getDescontoAdicional() {
        return 0.0; 
    }
}