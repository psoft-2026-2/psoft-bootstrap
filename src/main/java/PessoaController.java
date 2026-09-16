import java.util.HashMap;

public class PessoaController {
    private HashMap<String, Pessoa> pessoas ;

    public PessoaController() {
        this.pessoas = new HashMap<String, Pessoa>();
    }

    public boolean addPessoa(String cpf, String nome, int idade, String telefone, Papel papel) {
        if (pessoas.containsKey(cpf)) return false;

        if (papel == Papel.Cliente) {
            Cliente cliente = new Cliente(cpf,  nome, idade, telefone);
            pessoas.put(cpf, cliente);
            return true;
        } else {
            Funcionario funcionario = new Funcionario(cpf,  nome, idade, telefone);
            pessoas.put(cpf, funcionario);
            return true;
        }
    }

    public boolean deletarPessoa(String cpf) {
        if (!pessoas.containsKey(cpf)) return false;

        pessoas.remove(cpf);
        return true;
    }

    public boolean atualizarEndereco(String cpf, int idEndereco, String rua, String num, String cep, String cidade, String estado) {
        if (!pessoas.containsKey(cpf)) return false;

        Pessoa pessoa = pessoas.get(cpf);

        return pessoa.atualizarEndereco(idEndereco, rua, num, cep, cidade, estado);
    }

    public boolean atualizarTelefone(String cpf, String telefone) {
        if (!pessoas.containsKey(cpf)) return false;

        Pessoa pessoa = pessoas.get(cpf);
        pessoa.atualizarTelefone(telefone);
        return true;
    }

    public boolean atualizarIdade(String cpf, int idade) {
        if (!pessoas.containsKey(cpf)) return false;

        Pessoa pessoa = pessoas.get(cpf);
        pessoa.atualizarIdade(idade);
        return true;
    }

    public boolean setCliente(String cpf) {
        if (!pessoas.containsKey(cpf)) return false;

        Pessoa pessoa = pessoas.get(cpf);

        Cliente cliente = new Cliente(
                cpf,
                pessoa.getNome(),
                pessoa.getIdade(),
                pessoa.getTelefone()
        );

        pessoas.put(cpf, cliente);

        return true;
    }

    public boolean setFuncionario(String cpf) {
        if (!pessoas.containsKey(cpf)) return false;

        Pessoa pessoa = pessoas.get(cpf);

        Funcionario funcionario = new Funcionario(
                cpf,
                pessoa.getNome(),
                pessoa.getIdade(),
                pessoa.getTelefone()
        );

        pessoas.put(cpf, funcionario);

        return true;
    }
}
