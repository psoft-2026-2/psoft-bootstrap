import java.util.ArrayList;

public abstract class Pessoa {
    
    private final String nome;
    private final String cpf;
    private int idade;
    private String telefone;
    private String profissao;
    private ArrayList<Endereco> enderecos;
    
    public Pessoa(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.enderecos = new ArrayList<>();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public int getIdade(){
        return this.idade;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public String getProfissao(){
        return this.profissao;
    }
    
    public String listarEndercos(){
        String out = "";
        for(int i = 0; i < this.enderecos.size(); i++){
            out += "[" + i + "]: " + this.enderecos.get(i) + "\n";
        }
        return out;
    }
    
    public void adicionarEndereco(String rua, int numero, String bairro, String cidade, String estado){
        this.enderecos.add(new Endereco(rua, numero, bairro, cidade, estado));
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public void setProfissao(String profissao){
        this.profissao = profissao;
    }
    
    public boolean removeEndereco(int id_endereco){
    if(id_endereco >= 0 && id_endereco < this.enderecos.size()){
        this.enderecos.remove(id_endereco);
        return true;
    }
    return false;
}
    
    @Override
    public String toString(){
        return "Nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", idade=" + idade +
            ", telefone='" + telefone + '\'' +
            ", profissao='" + profissao + '\'';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
    
}
