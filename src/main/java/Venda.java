import java.util.ArrayList;
import java.util.List;

public class Venda {
    private final Cliente cliente;
    private final List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente e obrigatorio.");
        }
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (pagamento != null) {
            throw new IllegalStateException("Venda ja paga.");
        }
        itens.add(new ItemVenda(produto, quantidade));
    }

    public double calcularTotal() {
        double subtotal = 0;
        for (ItemVenda item : itens) {
            subtotal += item.calcularSubtotal();
        }
        return subtotal * (1 - cliente.getDesconto());
    }

    public void realizarPagamento(double valor) {
        if (pagamento != null) {
            throw new IllegalStateException("Venda ja paga.");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Adicione itens antes de pagar.");
        }
        if (!Double.isFinite(valor) || valor < 0
                || Math.round(valor * 100) < Math.round(calcularTotal() * 100)) {
            throw new IllegalArgumentException("Valor invalido ou insuficiente.");
        }
        pagamento = new Pagamento(valor);
    }
}
