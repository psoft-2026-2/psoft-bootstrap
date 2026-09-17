import java.time.LocalDate;
import java.util.List;

public class PessoaService {
    List<Pessoa> pessoas;

    public PessoaService(List<Pessoa> lista) {
        pessoas = lista;
    }

    void createPessoa(String nome, LocalDate dataNascimento, String cpf) throws Exception {
        try {
            Pessoa newPessoa = new Pessoa(nome, dataNascimento, cpf);
            pessoas.add(newPessoa);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    void createCliente(String nome, LocalDate dataNascimento, String cpf, String numCartao) throws Exception {
        try {
            Pessoa newPessoa = new Cliente(nome, dataNascimento, cpf, numCartao);
            pessoas.add(newPessoa);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    void createFuncionario(String nome, LocalDate dataNascimento, String cpf, String cargo) throws Exception {
        try {
            Pessoa newPessoa = new Funcionario(nome, dataNascimento, cpf, cargo);
            pessoas.add(newPessoa);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    List<Pessoa> getPessoas() {
        return pessoas;
    }

    Pessoa getPessoa(int index) {
        return pessoas.get(index);
    }

    void updateIdadePessoa(int index, LocalDate newDate) {
        Pessoa p = pessoas.get(index);
        p.setdataNascimento(newDate);
        pessoas.set(index, p);
    }

    void updateProfissaoPessoa(int index, String newProfissao) {
        Pessoa p = pessoas.get(index);
        p.setProfissao(newProfissao);
        pessoas.set(index, p);
    }

    void updateTelefonePessoa(int index, String newTelefone) throws Exception {
        try {
            Pessoa p = pessoas.get(index);
            p.setTelefone(newTelefone);
            pessoas.set(index, p);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    void addEnderecoPessoa(int index, Address newAddress) {
        Pessoa p = pessoas.get(index);
        p.addEndereco(newAddress);
        pessoas.set(index, p);
    }

    void updateEnderecoPessoa(int indexPessoa, int indexEndereco, Address newAddress) {
        Pessoa p = pessoas.get(indexPessoa);
        p.setEndereco(indexEndereco, newAddress);
        pessoas.set(indexPessoa, p);
    }

    void removeEnderecoPessoa(int indexPessoa, int indexEndereco) {
        Pessoa p = pessoas.get(indexPessoa);
        p.removeEndereco(indexEndereco);
        pessoas.set(indexPessoa, p);
    }

    void deletePessoa(int index) {
        pessoas.remove(index);
    }
}