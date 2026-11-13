public class Cliente {

    private String cpf;
    private String nome;
    private String telefone;

    public Cliente(String cpf, String nome, String telefone){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + "]";
    }   
}
