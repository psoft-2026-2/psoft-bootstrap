public class Funcionario {
    private String cpf;
    private String nome;
    private Cargo cargo;

    public Funcionario(String cpf, String nome, Cargo cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
    }

    public void promover() {
        this.cargo = cargo.evoluiPara();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
