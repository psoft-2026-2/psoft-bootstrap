import java.util.*;

public abstract class Pessoa {
    private final String nome;
    private int idade;
    private final String cpf;
    private String telefone;
    private Map<Integer, Endereco> enderecos;
    private String profissao;    
    // private String papelPessoa;    

    public Pessoa(String nome, int idade, String cpf, String telefone, String profissao){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        //this.papelPessoa = papelPessoa;

        this.enderecos = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    // public String getPapelPessoa() {
    //     return papelPessoa;
    // }

    // public void setPapelPessoa(String papelPessoa) {
    //     this.papelPessoa = papelPessoa;
    // }

    public void excluirEndereco(int id){
        this.enderecos.remove(id);
    }

    public String visualizarEnderecos(){
        return enderecos.toString();
    }

    public boolean cadastrarEndereco(int idEndereco, String rua, String cidade, int numero){
        if (this.enderecos.containsKey(idEndereco)) {
            return false;
        }
        
        Endereco novo = new Endereco(idEndereco, rua, cidade, numero);
        this.enderecos.put(idEndereco, novo);
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", telefone=" + telefone + ", profissao="
                + profissao + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
}
