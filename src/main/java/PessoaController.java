import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PessoaController {
    private Map<String, Pessoa> pessoas;

    public PessoaController(Map<String, Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void addPessoa(String nome, String cpf, String telefone, int idade, String profissao, List<Endereco> enderecos, String papel) {
        if (pessoas.containsKey(cpf)) {
            throw new IllegalArgumentException("Pessoa com CPF " + cpf + " já existe.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        if (cpf == null || cpf.isEmpty() || nome == null || nome.isEmpty() || papel == null || papel.isEmpty()) {
            throw new IllegalArgumentException("Dê informações válidas para nome, CPF e papel.");
        }
        switch (papel) {
            case "cliente":
                Pessoa cliente = new Cliente(nome, cpf, telefone, idade, profissao, enderecos);
                this.pessoas.put(cliente.getCpf(), cliente);
                break;
            case "funcionario":
                Pessoa funcionario = new Funcionario(nome, idade, cpf, telefone, enderecos, profissao);
                this.pessoas.put(funcionario.getCpf(), funcionario);
                break;
        }
    }

    public Pessoa getPessoaByCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("Dê informações válidas para CPF.");
        }
        return pessoas.get(cpf);
    }

    public void updatePessoa(String cpf, int idade, String telefone, String profissao) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("Dê informações válidas para CPF.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa com CPF " + cpf + " não encontrada.");
        }
        pessoa.setIdade(idade);
        pessoa.setTelefone(telefone);
        pessoa.setProfissao(profissao);
    }

    public void removePessoa(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("Dê informações válidas para CPF.");
        }
        if (!pessoas.containsKey(cpf)) {
            throw new IllegalArgumentException("Pessoa com CPF " + cpf + " não encontrada.");
        }
        pessoas.remove(cpf);
    }

    public List<Pessoa> getPessoas() {
        return new ArrayList<>(pessoas.values());
    }
}
