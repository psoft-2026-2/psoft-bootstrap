import java.util.*;

public class PessoaController {
    private Map<String, Pessoa> pessoas;

    public PessoaController() {
        this.pessoas = new HashMap<>();
    }

    public void cadastrarCliente(String nome, int idade, Cpf cpf, String telefone) {
        if (pessoas.containsKey(cpf.getCpf())) {
            throw new IllegalStateException("CPF já cadastrado");
        }
        Cliente cliente = new Cliente(nome, idade, cpf, telefone);
        pessoas.put(cpf.getCpf(), cliente);
    }

    public void cadastrarFuncionario(String nome, int idade, Cpf cpf, String telefone) {
        if (pessoas.containsKey(cpf.getCpf())) {
            throw new IllegalStateException("CPF já cadastrado");
        }
        Funcionario funcionario = new Funcionario(nome, idade, cpf, telefone);
        pessoas.put(cpf.getCpf(), funcionario);
    }

    public void deletarPessoa(String cpf) {
        pessoas.remove(cpf);
    }

    public void cadastrarEndereco(String cpf, String cidade, String bairro, String rua, int numero) {
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new NoSuchElementException("Pessoa não encontrada");
        }
        Endereco endereco = new Endereco(cidade, bairro, rua, numero);
        pessoa.adicionaEndereco(endereco);
    }

    public void removerEndereco(String cpf, Endereco endereco) {
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new NoSuchElementException("Pessoa não encontrada");
        }
        pessoa.removeEndereco(endereco);
    }

    public Pessoa buscarPessoa(String cpf) {
        return pessoas.get(cpf);
    }
}