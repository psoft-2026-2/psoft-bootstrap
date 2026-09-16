public class Pessoa {
    private String nome;
    private Cpf cpf;
    private int idade;
    private String telefone;
    private ArrayList<Endereco> enderecos = new ArrayList<>();
    private String profissao;
    private Papel papel;


    public Pessoa(String nome, Cpf cpf, int idade, String telefone, ArrayList<Endereco> enderecos, String profissao, Papel papel) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.enderecos = enderecos;
        this.profissao = profissao;
        this.papel = papel;
    }

    public void addEndereco(String rua, String bairro, int numero, String cidade) {
        Endereco end = new Endereco(rua, numero, bairro, cidade);
        this.enderecos.add(end);
    }

    public void removeEndereco(int index) {
        this.enderecos.remove(index);
    }

    public String getNome() {
        return nome;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEnderecos() {
        return enderecos.toString();
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}