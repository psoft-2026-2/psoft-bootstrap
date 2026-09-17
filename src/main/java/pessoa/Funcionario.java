package pessoa;

public class Funcionario extends Pessoa {

    private int idFuncionario;

    public Funcionario(String nome, String cpf, int idade, String telefone, String profissao, int id) {
        super(nome, cpf, idade, telefone, profissao);
        this.idFuncionario = id;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
    
}