import java.util.HashMap;

public class Bootstrap {
    private static HashMap<Cpf, Pessoa> pessoas = new HashMap<>();

    public static void main(String[] args) {
    }

    public static Pessoa createPessoa(String nome, String cpf, int idade, String telefone, String profissao, String papel) {
        return new Pessoa(nome, new Cpf(cpf), idade, new Telefone(telefone), profissao, Papel.valueOf(papel.toUpperCase()));
    }
    
    public static Endereco createEndereco(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        return new Endereco(estado, cidade, bairro, rua, numero, complemento);
    }

    public static Pessoa addPessoa(Pessoa pessoa, Endereco endereco) {
        if (endereco == null) throw new IllegalArgumentException("ENDEREÇO INVÁLIDO");
        if (pessoa == null) throw new IllegalArgumentException("USUÁRIO INVÁLIDO");
        if (pessoas.containsKey(pessoa.getCpf())) throw new IllegalArgumentException("USUÁRIO JÁ CADASTRADO");
        pessoa.addEndereco(endereco);
        pessoas.put(pessoa.getCpf(), pessoa);
        return pessoas.get(pessoa.getCpf());
    }

    public static void addEndereco(Pessoa pessoa, Endereco endereco) {
        getValidPessoa(pessoa).addEndereco(endereco);
    }

    public static void removeEndereco(Pessoa pessoa, Endereco endereco) {
        getValidPessoa(pessoa).removeEndereco(endereco);
    }

    public static void setTelefone(Pessoa pessoa, String numeroTelefone) {
        getValidPessoa(pessoa).setTelefone(new Telefone(numeroTelefone));
    }

    public static void setIdade(Pessoa pessoa, int idade) {
        getValidPessoa(pessoa).setIdade(idade);
    }

    public static void setProfissao(Pessoa pessoa, String profissao) {
        getValidPessoa(pessoa).setProfissao(profissao);
    }

    public static void changePapel(Pessoa pessoa) {
        getValidPessoa(pessoa).changePapel();
    }

    private static Pessoa getValidPessoa(Pessoa pessoa) {
        if (pessoa == null || !pessoas.containsKey(pessoa.getCpf())) {
            throw new IllegalArgumentException("USUÁRIO INVÁLIDO");
        }

        return pessoas.get(pessoa.getCpf());
    }

}
