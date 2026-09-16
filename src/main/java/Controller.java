import java.util.*;

public class Controller {
    private Map<String, Pessoa> pessoas;

    public Controller() {
        this.pessoas = new HashMap<>();
    }
    
    public boolean cadastraPessoa(String nome, int idade, String cpf, String telefone, String profissao, String papel) {
        Pessoa nova = new Pessoa(nome, idade, cpf, telefone, profissao, papel);
        if (pessoas.containsKey(cpf)) return false;

        pessoas.put(cpf, nova);
        return true;
    }

    public String buscaPessoa(String cpf) {
        return pessoas.get(cpf).toString();
    }

    public List<String> listaPessoas() {
        ArrayList<String> lista = new ArrayList<>();
        for (Pessoa p : pessoas.values()) {
            lista.add(p.toString());
        }

        return lista;
    }

    public boolean alteraIdade(String cpf, int idade) {
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).setIdade(idade);
        return true;
    }

    public boolean alteraProfissao(String cpf, String profissao) {
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).setProfissao(profissao);
        return true;
    }

    public boolean alteraTelefone(String cpf, String telefone) {
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).setTelefone(telefone);
        return true;
    }

    public boolean alteraPapel(String cpf, String papel) {
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).setPapel(papel);
        return true;
    }

    public boolean adicionaEndereco(String cpf, String endereco) {
        if (!pessoas.containsKey(cpf)) return false;
        pessoas.get(cpf).adicionaEndereco(endereco);
        return true;
    }

}
