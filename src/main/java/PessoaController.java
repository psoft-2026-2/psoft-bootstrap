import java.util.*;

public class PessoaController {
    private Map<String, Pessoa> pessoas;

    public PessoaController(){
        this.pessoas = new HashMap<>();
    }

    public String verPessoa(String cpf) {
        return  pessoas.get(cpf).toString();
    }

    public List<String> exibirPessoas(){
        List<String> listaPessoas = new ArrayList<>();

        for(Pessoa p: pessoas.values()) {
            listaPessoas.add(p.toString());
        }

        return  listaPessoas;
    }

    public boolean atualizarTelefone(String cpf, String tel){
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).setTelefone(tel);
        return true;
    }

    public boolean atualizarIdade(String cpf, int idade){
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).setIdade(idade);
        return true;
    }

    public boolean atualizarProfissao(String cpf, String prof){
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).setProfissao(prof);
        return true;
    }

    public boolean cadastrarEndereco(String cpf, int id, String rua, String cidade, int numero) {
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).cadastrarEndereco(id, rua, cidade, numero);
        return true;
    }
    
    public boolean removerEndereco(String cpf, int id) {
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).excluirEndereco(id);
        return true;
    }   

    public String visualizarEnderecosPessoa(String cpf){
        if (!pessoas.containsKey(cpf)) return "Sem endereços cadastrados";
        return  pessoas.get(cpf).visualizarEnderecos();
    }
}
