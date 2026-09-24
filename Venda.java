import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens;
    private Cliente cliente;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda novoItem = new ItemVenda(produto, quantidade);
        this.itens.add(novoItem);
    }

    public double calcularValorSubtotal() {
        double subtotal = 0.0;
        for (ItemVenda item : itens) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    public double calcularValorTotal() {
        double subtotalItens = calcularValorSubtotal();
        double percentualDescontoCliente = cliente.getDescontoCliente();
        
        return subtotalItens * (1.0 - percentualDescontoCliente);
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
