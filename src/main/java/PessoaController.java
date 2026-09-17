import java.util.ArrayList;
import java.util.List;

public class PessoaController {
    private List<Pessoa> pessoas;

    public PessoaController() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return new ArrayList<>(pessoas);
    }

    public Pessoa pesquisarPessoa(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("cpf nao pode ser nulo ou vazio");
        }
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public void cadastrarCliente(String nome, int idade, String cpf, ArrayList<Endereco> enderecos, String telefone, String profissao) {
        validarCpfUnico(cpf);
        Cliente cliente = new Cliente(nome, idade, cpf, enderecos, telefone, profissao);
        pessoas.add(cliente);
    }

    public void cadastrarCliente(String nome, int idade, String cpf, String telefone, ArrayList<Endereco> enderecos, String profissao) {
        cadastrarCliente(nome, idade, cpf, enderecos, telefone, profissao);
    }

    public void cadastrarFuncionario(String nome, int idade, String cpf, ArrayList<Endereco> enderecos, String telefone, String profissao, String cargo) {
        validarCpfUnico(cpf);
        Funcionario funcionario = new Funcionario(nome, idade, cpf, enderecos, telefone, profissao, cargo);
        pessoas.add(funcionario);
    }

    public void cadastrarFuncionario(String nome, int idade, String cpf, String telefone, ArrayList<Endereco> enderecos, String profissao, String cargo) {
        cadastrarFuncionario(nome, idade, cpf, enderecos, telefone, profissao, cargo);
    }

    private void validarCpfUnico(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("cpf nao pode ser nulo ou vazio");
        }
        if (pesquisarPessoa(cpf) != null) {
            throw new IllegalArgumentException("CPF ja cadastrado: " + cpf);
        }
    }

    public Pessoa atualizarPessoa(String cpf, Integer novaIdade, String novoTelefone, String novaProfissao) {
        Pessoa p = pesquisarPessoa(cpf);
        if (p == null) {
            return null;
        }
        if (novaIdade != null) {
            p.setIdade(novaIdade);
        }
        if (novoTelefone != null && !novoTelefone.trim().isEmpty()) {
            p.setTelefone(novoTelefone);
        }
        if (novaProfissao != null && !novaProfissao.trim().isEmpty()) {
            p.setProfissao(novaProfissao);
        }
        return p;
    }

    public Pessoa atualizarPessoa(String cpf, Integer novaIdade, String novoTelefone, String novaProfissao, String novoCargo) {
        Pessoa p = atualizarPessoa(cpf, novaIdade, novoTelefone, novaProfissao);
        if (p == null) {
            return null;
        }
        if (novoCargo != null && !novoCargo.trim().isEmpty()) {
            if (p instanceof Funcionario) {
                ((Funcionario) p).setCargo(novoCargo);
            } else {
                throw new IllegalArgumentException("Pessoa nao e funcionario, nao possui cargo");
            }
        }
        return p;
    }

    public Pessoa removerPessoa(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("cpf nao pode ser nulo ou vazio");
        }
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getCpf().equals(cpf)) {
                return pessoas.remove(i);
            }
        }
        return null;
    }

    public boolean removePessoa(String cpf) {
        return removerPessoa(cpf) != null;
    }

    public int quantidadePessoas() {
        return pessoas.size();
    }
}
