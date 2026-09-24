package mercado;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private static final double PERCENTUAL_DESCONTO_PREMIUM = 0.05;

    private Cliente cliente;
    private List<ItemVenda> itens = new ArrayList<>();
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
    }

    // Creator: Venda contém os itens, então os cria.
    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemVenda(produto, quantidade));
    }

    // Information Expert: conhece itens e cliente. Low Coupling: só usa o total dos itens e o perfil do cliente.
    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.calcularTotal();
        }
        if (cliente.getPerfil() == Perfil.PREMIUM) {
            total -= total * PERCENTUAL_DESCONTO_PREMIUM;
        }
        return total;
    }

    // Creator: Venda usa o Pagamento, então o cria.
    public void realizarPagamento(double valor) {
        if (valor < calcularTotal()) {
            throw new IllegalArgumentException("Pagamento menor que o valor total da venda");
        }
        this.pagamento = new Pagamento(valor);
    }
}
