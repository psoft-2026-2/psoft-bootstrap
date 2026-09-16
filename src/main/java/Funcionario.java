import java.util.HashMap;

public class Funcionario extends Pessoa {

	private double salario, vendas;
	
	public Funcionario(String nome, String cpf, String telefone, String profissao, int idade, double salario) {
		super(nome, cpf, telefone, profissao, idade);
		this.salario = salario;
		this.vendas = 0;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getVendas() {
		return vendas;
	}

	public void setVendas(double vendas) {
		this.vendas = vendas;
	}
	
	public void incrementaVendas(double valor) {
		this.vendas += valor;
	}
}
