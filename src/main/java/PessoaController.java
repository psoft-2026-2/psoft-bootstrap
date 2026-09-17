import java.util.*;

public class PessoaController {
    private List<Pessoa> pessoas;

    public PessoaController() {
        this.pessoas = new ArrayList<>();
    }

    public void addFuncionario(String nome, int idade, String cpf, String telefone, String profissao) {
        pessoas.add(new Funcionario(nome, idade, cpf, telefone, profissao));
    }

    public void addCliente(String nome, int idade, String cpf, String telefone, String profissao) {
        pessoas.add(new Cliente(nome, idade, cpf, telefone, profissao));
    }

    public void addEndereco(String cpf, String estado, String cidade, String bairro, String rua, int num) {
        Pessoa pessoa = getPessoa(cpf);
        if (pessoa != null) {
            pessoa.addEndereco(new Endereco(estado, cidade, bairro, rua, num));
        }
    }

    public Pessoa getPessoa(String cpf) {
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public List<Endereco> getEnderecosPessoa(String cpf) {
        Pessoa pessoa = getPessoa(cpf);
        if (pessoa == null) {
            return new ArrayList<>();
        }
        return pessoa.getEnderecos();
    }

    public void attIdade(String cpf, int idadeNova) {
        Pessoa pessoa = getPessoa(cpf);
        if (pessoa != null) {
            pessoa.setIdade(idadeNova);
        }
    }

    public void attTelefone(String cpf, String telefoneNovo) {
        Pessoa pessoa = getPessoa(cpf);
        if (pessoa != null) {
            pessoa.setTelefone(telefoneNovo);
        }
    }

    public void attProfissao(String cpf, String profissaoNova) {
        Pessoa pessoa = getPessoa(cpf);
        if (pessoa != null) {
            pessoa.setProfissao(profissaoNova);
        }
    }

    public Pessoa removePessoa(String cpf) {
        Pessoa pessoa = getPessoa(cpf);
        if (pessoa == null) {
            return null;
        }
        pessoas.remove(pessoa);
        return pessoa;
    }

    public Endereco removeEnderecoUnico(String cpf, String estado, String cidade, String bairro, String rua, int num) {
        Pessoa pessoa = getPessoa(cpf);
        if (pessoa == null) {
            return null;
        }
        Endereco achado = null;
        for (Endereco e : pessoa.getEnderecos()) {
            if (e.getEstado().equals(estado)
                    && e.getCidade().equals(cidade) && e.getBairro().equals(bairro)
                    && e.getRua().equals(rua) && e.getNum() == num) {
                achado = e;
                break;
            }
        }
        if (achado != null) {
            pessoa.removeEndereco(achado);
        }
        return achado;
    }

    public List<Endereco> removeEnderecos(String cpf) {
        Pessoa pessoa = getPessoa(cpf);
        if (pessoa == null) {
            return new ArrayList<>();
        }
        List<Endereco> removidos = new ArrayList<>(pessoa.getEnderecos());

        for (Endereco e : removidos) {
            pessoa.removeEndereco(e);
        }
        return removidos;
    }
}
