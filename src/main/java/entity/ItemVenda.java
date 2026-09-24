package entity;

public class ItemVenda {
	
	private Produto produto;
	private int quantidade;
	private double desconto;

	public ItemVenda(Produto produto, int quantidade, double desconto) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.aplicarDesconto(desconto);
	}
	
	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	private void aplicarDesconto(double desconto) {
		if(quantidade > 20) {
			this.desconto = 0.10;
		} else {
			this.desconto = 0.0;
		}
	}
	
	public double calculaSubTotal() {
		double precoItem = this.quantidade * this.produto.getPreco();
		double desconto = precoItem * this.desconto;
		double subTotal = precoItem - desconto;
		return subTotal;
	}

}
