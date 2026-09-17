public class Funcionario extends Pessoa {
    private String departamento;
    private float salario;
    private Cargo cargo;

    public Funcionario(String nome, int idade, String cpf, String telefone, String profissao, String departamento, float salario, Cargo cargo) {
        super(nome, idade, cpf, telefone, profissao);
        this.departamento = departamento;
        this.salario = salario;
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public float getSalario() {
        return salario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    
}