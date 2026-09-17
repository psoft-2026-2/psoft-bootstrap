import java.util.ArrayList;
import java.util.List;

public class PessoaCRUD {

    private List<Pessoa> pessoas = new ArrayList<>();

    // CREATE
    public void criar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    // READ - buscar pelo CPF
    public Pessoa buscar(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }

        return null;
    }

    // READ - listar todas
    public List<Pessoa> listar() {
        return pessoas;
    }

    // UPDATE
    public boolean atualizar(
        String cpf,
        int idade,
        String telefone,
        Profissao profissao,
        Papel papel
    ) {
        Pessoa pessoa = buscar(cpf);

        if (pessoa == null) {
            return false;
        }

        pessoa.setIdade(idade);
        pessoa.setTelefone(telefone);
        pessoa.setProfissao(profissao);
        pessoa.setPapel(papel);

        return true;
    }

    // DELETE
    public boolean remover(String cpf) {
        Pessoa pessoa = buscar(cpf);

        if (pessoa == null) {
            return false;
        }

        pessoas.remove(pessoa);
        return true;
    }
}