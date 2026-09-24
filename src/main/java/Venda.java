import java.util.ArrayList;

public class Venda {
    private String idVenda;
    private Cliente cliente;
    private ArrayList<ItemVenda> itens;

    public Venda(Cliente cliente, String idVenda) {
        this.cliente = cliente;
        this.idVenda = idVenda;
        this.itens = new ArrayList<>();
    }

    public void adicionarItemVenda(int quantidade, Produto produto) {
        ItemVenda item = new ItemVenda(produto, quantidade);
        itens.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total = total + item.subTotal();
        }
        if ("premium".equalsIgnoreCase(cliente.getTipo())) {
            total = total * 0.95;
        }
        return total;
    }

    public String getId() {
        return idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
