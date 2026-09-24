import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int id;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.pagamento = new Pagamento();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(produto, quantidade);        
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.calcularSubtotal();
        }
        return total - calcularDesconto();
    }

    public double calcularDesconto() {
        double subtotal = 0;
        double desconto = 0;
        for (ItemVenda item : itens) {
            subtotal += item.calcularSubtotal();
            desconto += item.calcularDesconto();
        }

        if (cliente.isPremium()) {
            desconto += (subtotal - desconto) * 0.05;
        }
        return desconto;
    }

    public boolean efetuarVenda() {
        return pagamento.realizarPagamento();
    }
}
