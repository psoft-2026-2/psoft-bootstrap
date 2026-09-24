import java.util.List;
import java.util.ArrayList;

public class Venda {
    private double totalVenda;
    private Cliente cliente;
    private List<ItemVenda> itensVenda;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itensVenda = new ArrayList<>();
    }

    public void adicionaItemVenda(Produto produto, int qtdProduto) {
        ItemVenda itemVenda = new ItemVenda(produto, qtdProduto);

        for (ItemVenda item : this.itensVenda) {
            if (item.equals(itemVenda)) {
                item.aumentaQtdProduto(qtdProduto);
                return;
            }
        }

        this.itensVenda.add(itemVenda);
    }

    public void removeItemVenda(Produto produto) {
        ItemVenda itemVenda = null;

        for (ItemVenda item : this.itensVenda) {
            if (item.getProduto().equals(produto)) {
                itemVenda = item;
                break;
            }
        }

        this.itensVenda.remove(itemVenda);
    }

    public void calculaTotalVenda() {
        double totalVendaTemp = 0.0;

        for (ItemVenda item : this.itensVenda) {
            totalVendaTemp += item.getSubTotal();
        }

        if (this.cliente.isPremium()) {
            this.totalVenda = totalVendaTemp - (totalVendaTemp * 0.05);
        } else {
            this.totalVenda = totalVendaTemp;
        }
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    @Override
    public String toString() {
        return "Venda [totalVenda=" + totalVenda + ", cliente=" + cliente + ", itensVenda=" + itensVenda + "]";
    }
}
