package entity;
import java.util.List;

public class Venda {
	
	private List<ItemVenda> itens;
	private Pagamento pagamento;
	private Cliente cliente;
	
	public Venda(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getCliente() {
		return cliente.getCpf();
	}
	
	public void addItemVenda(ItemVenda item) {
		if(item != null) {
			itens.add(item);
		}
	}
	
	private double aplicarDescontoCliente(double total) {
		double novoTotal = total;
		if(cliente.getPerfil() == Perfil.PREMIUM) {
			novoTotal = total - (total * 0.05);
		}
		return novoTotal;
	}
	
	public double calcularTotal() {
		double totalAcumulado = 0;
		for(ItemVenda item: itens) {
			totalAcumulado += item.calculaSubTotal();
		}
		double total = aplicarDescontoCliente(totalAcumulado);
		return total;
	}
	
	public void pagar() {
		double totalVenda = calcularTotal();
		pagamento.realizarPagamento(totalVenda);
	}
}
