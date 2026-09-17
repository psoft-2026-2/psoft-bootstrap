import java.util.ArrayList;
import java.util.List;

public class Pessoa{
    
    private String nome;
    private String idade;
    private String telefone;
    private String cpf;
    private List<String> enderecos;
    private String profissao;
    private Papel papel;

    public Pessoa (String nome, String idade, String cpf, String telefone, String endereco, String profissao){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = new ArrayList<>();
        this.enderecos.add(endereco);
        this.profissao = profissao;
        this.papel = null;
    }

    public String getNome(){
        return nome;
    }

    public String getIdade(){
        return idade;
    }

    public void setIdade( String novaIdade){
        this.idade = novaIdade;
    }

    public String getCpf(){
        return cpf;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone( String novoTelefone){
        this.telefone = novoTelefone;
    }

    public List<String> getEnderecos(){
        return enderecos;
    }

    public void adicionarEndereco( String novoEndereco){
        this.enderecos.add(novoEndereco);
    }

    public void removerEnderecos(String endereco){
        this.enderecos.remove(endereco);

    }

    public String getProfissao(){
        return profissao;
    }

    public void setProfissao (String novaProfissao){
        this.profissao = novaProfissao;
    }

    public Papel getPapel() {
        return papel;
    }
    
    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", enderecos='" + enderecos + '\'' +
                ", profissao='" + profissao + '\'' +
                ", papel=" + papel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;
        return cpf.equals(pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
}