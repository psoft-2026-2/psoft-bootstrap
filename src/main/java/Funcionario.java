public class Funcionario extends Pessoa {

    private int idFuncionario;

    public Funcionario(String nome, int idade, String cpf,
                       String telefone, String profissao,
                       int idFuncionario) {

        super(nome, idade, cpf, telefone, profissao);

        this.idFuncionario = idFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
}