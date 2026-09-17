public class Funcionario extends Pessoa {

    private float salario;

    public Funcionario(String cpf, String telefone, String nome, Profissao profissao,float salario) {
        super(cpf, telefone, nome, profissao);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}