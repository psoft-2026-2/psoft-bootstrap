public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, int idade, String cpf, String cargo){
        super(nome, idade, cpf);
        this.cargo = cargo;
    }
}
