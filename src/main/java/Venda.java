import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class Venda {

    private final String id;
    private final Cliente cliente;
    private final List<ItemVenda> itensVenda;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.itensVenda = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItensVenda() {
        return Collections.unmodifiableList(itensVenda);
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void addItemVenda(Produto produto, int quantidade) {
        itensVenda.add(new ItemVenda(produto, quantidade));
    }

    public double getSubtotalItens() {
        double total = 0;
        for (ItemVenda item : itensVenda) {
            total += item.getSubTotal();
        }
        return total;
    }

    public double getValorTotal() {
        double subtotal = getSubtotalItens();
        double percentualDesconto = cliente.getAssinatura().getPercentualDesconto();
        return subtotal * (1 - percentualDesconto);
    }

    public void realizarPagamento(FormaPag formaPag) {
        if (itensVenda.isEmpty()) {
            throw new IllegalStateException("Não é possível pagar uma venda sem itens");
        }
        this.pagamento = new Pagamento(getValorTotal(), formaPag);
        this.pagamento.setStatus(Status.FINALIZADO);
    }
}
