import java.util.HashMap;

public class PessoaController {
    
    private HashMap<String, Pessoa> pessoas;

    public PessoaController(){
        this.pessoas = new HashMap<>();
    }

    public String criaCliente(String nome, String cpf, int idade){
        if(this.pessoas.containsKey(cpf)){
            return "CPF ja cadastrado";
        }
        this.pessoas.put(cpf, new Cliente(nome, cpf, idade));
        return "Cliente Cadastrado";
    }

    public String criaFuncionario(String nome, String cpf, int idade){
        if(this.pessoas.containsKey(cpf)){
            return "CPF ja cadastrado";
        }
        this.pessoas.put(cpf, new Funcionario(nome, cpf, idade));
        return "Funcionario Cadastrado";
    }

    public boolean removePessoa(String cpf){
        if(this.pessoas.containsKey(cpf)){
            this.pessoas.remove(cpf);
            return true;
        }
        return false;
    }

    public Pessoa getPessoa(String cpf){
        return this.pessoas.get(cpf);
    }

    public boolean atualizarDadosPessoa(String cpf, String novoTelefone, String novaProfissao) {
        Pessoa pessoa = this.pessoas.get(cpf);
        
        if (pessoa != null) {
            if (novoTelefone != null) pessoa.setTelefone(novoTelefone);
            if (novaProfissao != null) pessoa.setProfissao(novaProfissao);
            return true;
        }
        return false;
    }

    public String adicionarEnderecoPessoa(String cpf, String rua, int numero, String bairro, String cidade, String estado) {
        Pessoa pessoa = this.pessoas.get(cpf);
        
        if (pessoa != null) {
            pessoa.adicionarEndereco(rua, numero, bairro, cidade, estado);
            return "Endereço adicionado";
        }
        return "CPF não encontrado.";
    }

    public boolean removerEnderecoPessoa(String cpf, int id_endereco) {
        Pessoa pessoa = this.pessoas.get(cpf);
        if (pessoa != null) {
            return pessoa.removeEndereco(id_endereco);
        }
        return false;
    }

    public String listarPessoas() {
        if (this.pessoas.isEmpty()) return "Nenhuma pessoa cadastrada.";
        
        String out = "";
        for (Pessoa p : this.pessoas.values()) {
            out += p.toString() + "\n";
        }
        return out;
    }
}
