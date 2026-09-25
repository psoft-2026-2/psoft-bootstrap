public class Produto {
	private Integer id;
	private String nome;
	private double valor;
	
	Produto(String nome, double valor) {
		this.id = nome.hashCode();
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}
	
}
