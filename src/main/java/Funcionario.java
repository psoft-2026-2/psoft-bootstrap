import java.util.List;

public class Funcionario extends Pessoa {

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, int idade, String cpf, String telefone,
                       List<String> endereco, String profissao) {
        super(nome, idade, cpf, telefone, endereco, profissao);
    }
}