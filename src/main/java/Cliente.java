import java.util.ArrayList;

public class Cliente extends Pessoa {

    public Cliente(String nome, int idade, String cpf, ArrayList<Endereco> enderecos, String telefone, String profissao) {
        super(nome, idade, cpf, enderecos, telefone, profissao);
    }
}
