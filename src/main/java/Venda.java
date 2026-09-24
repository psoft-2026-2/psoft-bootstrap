import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {

    private final Cliente cliente;
    private final List<ItemVenda> itens;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemVenda(produto, quantidade));
    }

    public double calcularTotalBruto() {
        double total = 0.0;
        for (ItemVenda item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public double calcularDescontoPremium() {
        if (cliente.elegivelDescontoPremium()) {
            return calcularTotalBruto() * cliente.getPercentualDescontoPremium();
        }
        return 0.0;
    }

    public double calcularTotalFinal() {
        return calcularTotalBruto() - calcularDescontoPremium();
    }
}
