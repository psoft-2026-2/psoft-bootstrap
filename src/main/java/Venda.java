import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens;
    private Cliente cliente;
    private Pagamento pagamento;

    public Venda() {
        this.itens = new ArrayList<>();
    }

    Cliente getCliente() {
        return cliente;
    }

    void setCliente(Cliente cliente) {
        if (this.cliente != null) {
            this.cliente.removerCompra(this);
        }
        this.cliente = cliente;
        if (cliente != null) {
            cliente.adicionarCompra(this);
        }
    }

    List<ItemVenda> getItens() {
        return itens;
    }

    void adicionarItem(ItemVenda item) {
        if (item != null) {
            itens.add(item);
        }
    }

    Pagamento getPagamento() {
        return pagamento;
    }

    void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public float valorDesconto() {
        float d = 0;
        for (ItemVenda iv : itens) {
            d += iv.descontoInterno();
        }
        if (cliente != null && "premium".equalsIgnoreCase(cliente.getPerfil())) {
            d += (totalItens() - d) * 0.05f;
        }
        return d;
    }

    public float total() {
        return totalItens() - valorDesconto();
    }

    private float totalItens() {
        float total = 0;
        for (ItemVenda iv : itens) {
            total += iv.subtotal();
        }
        return total;
    }

    public float totalPago() {
        if (pagamento == null) {
            return 0;
        }
        return pagamento.pagamentoLiquido();
    }

    public void gerarPagamento() {
        float bruto = total();
        Pagamento p = new Pagamento("dinheiro", 0);
        p.setValorBruto(bruto);
        this.pagamento = p;
    }

    public String toString() {
        return "Venda{cliente=" + cliente + ", itens=" + itens + ", total=" + total() + ", desconto=" + valorDesconto() + ", totalPago=" + totalPago() + ", pagamento=" + pagamento + "}";
    }
}
