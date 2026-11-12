package modelo;

public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;

    public Cliente(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTel() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(String tel) {
        this.telefone = tel;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + "]";
    }
}