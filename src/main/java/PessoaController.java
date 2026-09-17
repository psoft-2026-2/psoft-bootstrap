import java.util.Map;
import java.util.HashMap;

public class PessoaController {

    private Map<String, Pessoa> registroPessoas;

    public PessoaController() {
        this.registroPessoas = new HashMap<String, Pessoa>();
    }

    public void adicionaPessoa(String nome, String cpf, String profissao, int idade, String telefone) {
        if (this.registroPessoas.containsKey(cpf)) {
            throw new IllegalArgumentException("Pessoa ja cadastrada");
        }
    
        this.registroPessoas.put(cpf, new Pessoa(nome, cpf, profissao, idade, telefone));
    }

    public Pessoa getPessoa(String cpf) {
        return this.registroPessoas.get(cpf);
    }

    public void atualizaPessoa(String cpf, String profissao, int idade, String telefone) {
        Pessoa p = this.registroPessoas.get(cpf);

        if (p == null) {
            throw new IllegalArgumentException("Pessoa Invalida");
        }

        p.atualizaDados(profissao, idade, telefone);
    }

    public void deletePessoa(String cpf) {
        this.registroPessoas.remove(cpf);
    }

    public void adicionaEndereco(String cpf, String rua, String cidade, int numero, String cep, String bairro) {
        Pessoa p = this.registroPessoas.get(cpf);

        if (p == null) {
            throw new IllegalArgumentException("Pessoa Invalida");
        }

        p.adicionaEndereco(rua, cidade, numero, cep, bairro);
    }

    public void atualizaEndereco(String cpf, String rua, String cidade, int numero, String cep, String bairro, String cepAntigo, int numeroAntigo) {
        Pessoa p = this.registroPessoas.get(cpf);

        if (p == null) {
            throw new IllegalArgumentException("Pessoa Invalida");
        }

        p.atualizaEndereco(cepAntigo, numeroAntigo, rua, cidade, numero, cep, bairro);
    }

    public Endereco getEndereco(String cpf, String cep, int numero) {
        Pessoa p = this.registroPessoas.get(cpf);

        if (p == null) {
            throw new IllegalArgumentException("Pessoa Invalida");
        }

        return p.getEndereco(cep, numero);
    }

    public void deleteEndereco(String cpf, String cep, int numero) {
        Pessoa p = this.registroPessoas.get(cpf);

        if (p == null) {
            throw new IllegalArgumentException("Pessoa Invalida");
        }

        p.deleteEndereco(cep, numero);
    }
}