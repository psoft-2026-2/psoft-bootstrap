import java.util.ArrayList;
import java.util.List;

public class Venda {
  
    private Cliente cliente;
    private List<Itemvenda> itens;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        this.itens.add(new Itemvenda(produto, quantidade));
    }

    public double calcularTotalBruto() {
        double total = 0.0;
        for (Itemvenda item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public double calcularDescontoPremium() {
        if (cliente != null && cliente.perfilPremium()) {
            return calcularTotalBruto() * 0.05; 
        }
        return 0.0;
    }

    public double calcularTotalFinal() {
        return calcularTotalBruto() - calcularDescontoPremium();
    }

    public Cliente getCliente() { 
        return cliente;
    }

    public List<Itemvenda> getItens() { 
        return itens;
    }
}

