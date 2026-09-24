import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;
    private int idVenda;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void addItem(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(quantidade, produto);
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemVenda item : itens) {
            total += item.calcularSubtotal();
        }

        if (cliente.getPerfil() == Perfil.PREMIUM) {
            total *= 0.95;
        }

        return total;
    }

    public double calcularDesconto() {
        double totalSemDesconto = 0;

        for (ItemVenda item : itens) {
            totalSemDesconto += item.getQuantidade()
                    * item.getProduto().getPreco();
        }

        return totalSemDesconto - calcularTotal();
    }

    public void realizarPagamento() {
        pagamento = new Pagamento(calcularTotal());
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
