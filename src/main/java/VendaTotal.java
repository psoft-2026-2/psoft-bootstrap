import java.util.ArrayList;
public class VendaTotal {
    private Cliente cliente;
    private ArrayList<VendaPar> itens;

    public VendaTotal(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        VendaPar item = new VendaPar(quantidade, produto);
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;

        for (VendaPar item : itens) {
            total += item.calcularTotal();
        }

        if (cliente.isPremium()) {
            total *= 0.95; // Desconto de 5% para clientes premium
        }

        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
}
