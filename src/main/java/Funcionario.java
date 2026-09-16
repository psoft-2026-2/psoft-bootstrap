public class Funcionario extends Pessoa {

    private double salario;

    public Funcionario(
        String nome,
        int idade,
        String cpf,
        String telefone,
        String profissao,
        double salario
    ) {
        super(nome, idade, cpf, telefone, profissao);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}