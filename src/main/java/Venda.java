import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens = new ArrayList<>();
    private Cliente cliente;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemVenda(produto, quantidade));
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.calcularSubtotal();
        }
        return total - total * cliente.getDesconto();
    }

    public Pagamento pagar(double valor) {
        if (valor < calcularTotal()) {
            throw new IllegalArgumentException("Valor insuficiente");
        }
        pagamento = new Pagamento(valor);
        return pagamento;
    }
}