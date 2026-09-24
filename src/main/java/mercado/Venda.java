package mercado;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda novoItem = new ItemVenda(produto, quantidade);
        this.itens.add(novoItem);
    }

    public double calcularTotal() {
        double totalItens = 0.0;
        for (ItemVenda item : itens) {
            totalItens += item.calcularSubtotal();
        }

        if (cliente.isPremium()) {
            totalItens *= 0.95;
        }

        return totalItens;
    }


    public boolean efetuarPagamento() {
        double valorTotal = calcularTotal();
        this.pagamento = new Pagamento(valorTotal);
        return this.pagamento.isConfirmado();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}