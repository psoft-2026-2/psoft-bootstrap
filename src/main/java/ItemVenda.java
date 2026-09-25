public class ItemVenda {
	private Integer id;
	private Integer idProduto;
	private Produto produto;
	private Integer quantidade;
	private double subtotal;
	private double desconto;
	
	//Precisei fazer algumas melhorias nessa classe. Do jeito que projetei no diagrama o funcionamento não ficaria bom.
	ItemVenda(Produto produto, Integer quantidade) {
		this.produto = produto;
		if (produto != null) {
			this.idProduto = produto.getId();
		}
		this.quantidade = quantidade;
		this.id = (this.idProduto != null ? this.idProduto : 0) + (quantidade != null ? quantidade : 0);
		
		atualizarDesconto();
		recalcularSubtotal();
	}

	private void atualizarDesconto() {
		if (this.quantidade != null && this.quantidade >= 20) {
			this.desconto = 10.0;
		} else {
			this.desconto = 0.0;
		}
	}

	private void recalcularSubtotal() {
		if (this.produto != null) {
			this.subtotal = calcularSubtotal(this.produto.getValor());
		}
	}

	private double calcularSubtotal(double valorProduto) {
		if (this.quantidade == null) return 0.0;
		return (valorProduto * this.quantidade) * (1.0 - (this.desconto / 100.0));
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		if (produto != null) {
			this.idProduto = produto.getId();
		}
		recalcularSubtotal();
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		atualizarDesconto();
		recalcularSubtotal();
	}

	public Integer getId() {
		return id;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getDesconto() {
		return desconto;
	}
}
