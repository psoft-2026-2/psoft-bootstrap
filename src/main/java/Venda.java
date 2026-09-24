import java.util.ArrayList;
import java.util.List;

public class Venda {

    private double valorTotal;
    private final Pagamento pagamento;
    private final List<ItemVenda> itens;
    private final Cliente cliente;

    public Venda(Cliente cliente, Pagamento pagamento) {
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.itens = new ArrayList<>();
    }

    public double calculaValorTotal() {
        valorTotal = 0;

        for (ItemVenda item : itens) {
            valorTotal += item.calculaSubtotal();
        }

        if (cliente.temDesconto()) {
            valorTotal = valorTotal * (1 - cliente.getPerfil().getDesconto());
        }

        return valorTotal;
    }

    public boolean addItem(ItemVenda item) {
        return itens.add(item);
    }

    public void pagar() {
        double total = calculaValorTotal();

        if (pagamento.getValor() < total) {
            throw new IllegalArgumentException("Valor pago insuficiente para pagar toda a venda.");
        }

        pagamento.taPago();
    }

    public boolean isAprovada() {
        return pagamento != null && pagamento.taPago();
    }

    public boolean aplicaDescontoCliente() {
        return cliente.temDesconto();
    }
}
