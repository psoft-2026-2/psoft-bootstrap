public class Cliente extends Pessoa {
    private String credencial;

    public Cliente(String nome, String cpf, int idade, String tel, Profissao profissao, String[] enderecos, String credencial) {
        super(nome, cpf, idade, tel, profissao, enderecos);
        this.credencial = credencial;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }
}