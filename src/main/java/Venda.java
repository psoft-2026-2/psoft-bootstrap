import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private final Cliente cliente;
    private final List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(Cliente cliente, int id) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        this.itens.add(new ItemVenda(produto, quantidade));
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.calcularSubtotal();
        }
        if (cliente.getAssinatura() == Assinatura.PREMIUM) {
            total *= 0.95; // 5% de desconto para clientes premium
        }
        return total;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void realizarPagamento(double valor) {
        this.pagamento = new Pagamento(valor, LocalDate.now());
    }
}
