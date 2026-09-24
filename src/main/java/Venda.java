import java.util.Map;

public class Venda {
    public Cliente cliente;
    public Map<Produto, ItemVenda> itens;

    public Venda(Cliente cliente, Map<Produto, ItemVenda> itens) {
        this.cliente = cliente;
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map<Produto, ItemVenda> getItens() {
        return itens;
    }

    public void setItens(Map<Produto, ItemVenda> itens) {
        this.itens = itens;
    }

    public double getSubtotal() {
        double custoTotal = 0;
        
        for (ItemVenda item: itens.values()) {
            custoTotal += item.getSubtotal();
        }

        return custoTotal;
    }

    public double getTotal() {
        double subtotal = getSubtotal();

        if (cliente.getPerfil() == Perfil.PREMIUM) {
            return subtotal * 0.05;
        }
        
        return subtotal;
    }

}