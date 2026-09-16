public class Cliente extends Pessoa {
    private String numCartao;

    public Cliente(String nome, int idade, String cpf, String numCartao){
        super(nome, idade, cpf);
        this.numCartao = numCartao;
    }
}
