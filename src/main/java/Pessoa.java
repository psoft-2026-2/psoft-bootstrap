import java.util.List;

public class Pessoa {

    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private Profissao profissao;
    private List<Endereco> enderecos;
    private Papel papel;

    public Pessoa(String nome, int idade, String cpf, String telefone, Profissao profissao, List<Endereco> enderecos, Papel papel) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.enderecos = enderecos;
        this.papel = papel;
    }

    public String get_nome() {
        return this.nome;
    }

    public int get_idade() {
        return this.idade;
    }

    public String get_cpf() {
        return this.cpf;
    }

    public String get_telefone() {
        return this.telefone;
    }

    public Profissao get_profissao() {
        return this.profissao;
    }

    public List<Endereco> get_enderecos() {
        return this.enderecos;
    }

    public Papel get_papel() {
        return this.papel;
    }

    public void set_papel(Papel novo_papel) {
        this.papel = novo_papel;
    }
        
    public void set_idade (int nova_idade) {
        this.idade = nova_idade;
    }

    public void set_telefone (String novo_telefone) {
        this.telefone = novo_telefone;
    }

    public void set_profissao (Profissao nova_profissao) {
        this.profissao = nova_profissao;
    }

    public void add_endereco (Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void exclui_endereco (Endereco endereco) {
        this.enderecos.remove(endereco);
    }
}
