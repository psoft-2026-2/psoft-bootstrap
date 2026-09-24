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
        ItemVenda item = new ItemVenda(produto, quantidade);
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        
        for (ItemVenda item : itens) {
            total += item.calcularSubtotal();
        }

        if (cliente != null && cliente.getPerfil() == PerfilAssinatura.PREMIUM) {
            total = total * 0.95;
        }

        return total;
    }

    public void realizarPagamento(double valorInformado) {
        double totalDevido = calcularTotal();
        
        if (valorInformado >= totalDevido) {
            this.pagamento = new Pagamento(valorInformado);
        } else {
            throw new IllegalArgumentException("O valor é insuficiente para finalizar o pagamento.");
        }
    }
}