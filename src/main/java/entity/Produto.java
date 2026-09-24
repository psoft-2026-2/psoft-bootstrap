package entity;
import java.util.Objects;

public class Produto {
	
	private int idProduto;
	private String descricao;
	private double preco;
	
	public Produto(int idProduto, String descricao, double preco) {
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(idProduto));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return idProduto == other.idProduto;
	}

}
