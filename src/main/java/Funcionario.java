public class Funcionario {
    
    private String nome;
    private String cpf;
    private String telefone;
    private Papel papel;

    public Funcionario(String nome, String cpf, String telefone, Papel papel) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.papel = papel;
    }

    public String getNome() {
        return nome;
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

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    
}
