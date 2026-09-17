import java.util.List;

public class Cliente extends Pessoa {

    public Cliente() {
        super();
    }

    public Cliente(String nome, int idade, String cpf, String telefone,
                   List<String> endereco, String profissao) {
        super(nome, idade, cpf, telefone, endereco, profissao);
    }
}