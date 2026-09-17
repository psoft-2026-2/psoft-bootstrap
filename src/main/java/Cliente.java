import java.util.*;

public class Cliente extends Pessoa{

    public Cliente (String nome, String cpf, String telefone, int idade, String profissao, List<Endereco> enderecos) {
        super(nome, idade, cpf, telefone, enderecos, profissao);
    }

    @Override
    public String toString() {
        return "Cliente: " + getNome() + "\nCPF: " + getCpf() + "\nTelefone: " + getTelefone() + "\nIdade: " + getIdade() + "\nProfissão: " + getProfissao() + "\nEndereços: " + getEnderecos();
    }
}
