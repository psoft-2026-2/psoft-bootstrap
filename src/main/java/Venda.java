import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {

    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void addItem(Produto produto, int qtd) {
        if (isPago()) {
            throw new IllegalStateException("Venda já foi paga");
        }
        this.itens.add(new ItemVenda(produto, qtd));
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (ItemVenda item : this.itens) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    public double getTotal() {
        return this.cliente.aplicarDesconto(getSubtotal());
    }

    public void pagar(FormaPagamento forma) {
        if (this.itens.isEmpty()) {
            throw new IllegalStateException("Venda sem itens");
        }
        if (isPago()) {
            throw new IllegalStateException("Venda já foi paga");
        }
        this.pagamento = new Pagamento(getTotal(), forma);
    }

    public boolean isPago() {
        return this.pagamento != null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}
