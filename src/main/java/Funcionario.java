import java.util.List;

public class Funcionario extends Pessoa {

    public Funcionario(String nome, int idade, String cpf, String telefone, List<Endereco> enderecos, String profissao) {
        super(nome, idade, cpf, telefone, enderecos, profissao);
    }

    @Override
    public String toString() {
        return "Funcionario: " + getNome() + "\nCPF: " + getCpf()
                + "\nTelefone: " + getTelefone() + "\nIdade: " + getIdade() + "\nProfissão: " + getProfissao()
                + "\nEndereços: " + getEnderecos();
    }
}
