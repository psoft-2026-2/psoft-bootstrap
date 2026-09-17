import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    private List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public Pessoa buscar(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
    
        return null;
    }

    public void atualizar(String cpf, String novaIdade, String novoTelefone,
                      List<String> novosEnderecos, String novaProfissao) {

    Pessoa pessoa = buscar(cpf);

    if (pessoa != null) {
        pessoa.setIdade(novaIdade);
        pessoa.setTelefone(novoTelefone);
        pessoa.setProfissao(novaProfissao);
        
        pessoa.getEnderecos().clear();
        pessoa.getEnderecos().addAll(novosEnderecos);
    }
}

    public void remover(String cpf) {
        Pessoa pessoa = buscar(cpf);

        if (pessoa != null) {
            pessoas.remove(pessoa);
        }
    }

    

}

