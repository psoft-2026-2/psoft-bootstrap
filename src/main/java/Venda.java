import java.util.ArrayList;

public class Venda {
	private Integer id;
	private Integer idCliente;
	private Cliente cliente;
	private ArrayList<ItemVenda> itensVenda;
	private double total;
	private boolean descontoCliente;
	private String pagamento;
	
	//Precisei fazer algumas melhorias nessa classe. Do jeito que projetei no diagrama o funcionamento não ficaria bom.
	Venda(Integer idCliente, String pagamento) {
		this.id = pagamento.hashCode() + (idCliente != null ? idCliente : 0);
		this.idCliente = idCliente;
		this.pagamento = pagamento;
		this.itensVenda = new ArrayList<>();
		this.total = 0.0;
		this.descontoCliente = false;
	}

	Venda(Cliente cliente, String pagamento) {
		this(cliente != null ? cliente.getId() : null, pagamento);
		setCliente(cliente);
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public Integer getId() {
		return id;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		if (cliente != null) {
			this.idCliente = cliente.getId();
			this.descontoCliente = (cliente.getCategoria() == Categoria.Premium);
		} else {
			this.descontoCliente = false;
		}
		recalcularTotal();
	}

	public double getTotal() {
		return total;
	}

	public boolean isDescontoCliente() {
		return descontoCliente;
	}

	public void setDescontoCliente(boolean descontoCliente) {
		this.descontoCliente = descontoCliente;
		recalcularTotal();
	}
	
	public ArrayList<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	private void recalcularTotal() {
		double soma = 0.0;
		for (ItemVenda item : itensVenda) {
			soma += item.getSubtotal();
		}
		if (this.descontoCliente) {
			soma = soma * 0.95;
		}
		this.total = soma;
	}

	public void addItemVenda(ItemVenda item) {
		if (item != null) {
			this.itensVenda.add(item);
			recalcularTotal();
		}
	}

	public void addItemVenda(Produto produto, Integer quantidade) {
		ItemVenda item = new ItemVenda(produto, quantidade);
		addItemVenda(item);
	}

	public void removeItemVenda(ItemVenda item) {
		if (item != null && this.itensVenda.remove(item)) {
			recalcularTotal();
		}
	}

	public void editItemVenda(ItemVenda item, Produto novoProduto, Integer novaQuantidade) {
		if (item != null) {
			if (novoProduto != null) {
				item.setProduto(novoProduto);
			}
			if (novaQuantidade != null) {
				item.setQuantidade(novaQuantidade);
			}
			recalcularTotal();
		}
	}

	public void editItemVenda(ItemVenda item, Integer novaQuantidade) {
		editItemVenda(item, null, novaQuantidade);
	}

	public void editItemVenda(ItemVenda item, Produto novoProduto) {
		editItemVenda(item, novoProduto, null);
	}
	
}
