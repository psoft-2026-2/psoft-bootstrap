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

    public ItemVenda criarItemVenda(Produto produto, int quantidade) {
        return new ItemVenda(produto, quantidade);
    }

    public void adicionarItemVenda(ItemVenda item) {
        itens.add(item);
    }

    public double calcularSubtotal() {
        double subtotal = 0;

        for (ItemVenda item : itens) {
            subtotal = subtotal + item.calcularSubtotal();
        }

        return subtotal;
    }

    public double calcularTotal() {
        double total = calcularSubtotal();

        if (cliente.getAssinatura() == Assinatura.PREMIUM) {
            total = total * 0.95;
        }

        return total;
    }

    public void atribuirDescontoVenda() {
        double total = calcularTotal();

        pagamento = new Pagamento(total, "Não informado");
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