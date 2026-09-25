import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {
    private Pagamento formaPagamento;
    private final List<ItemVenda> itens;
    private Cliente cliente;

    public Venda() {
        this.itens = new ArrayList<>();
    }

    public Pagamento getFormaPagamento() {
        return formaPagamento;
    }

    public List<ItemVenda> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void adicionarItem(ItemVenda item) {
        if (item == null)
            throw new IllegalArgumentException("O item não pode ser nulo.");
        itens.add(item);
    }

    public void removerItem(ItemVenda item) {
        itens.remove(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemVenda item : itens)
            total += item.calculaTotal();
        total *= descontoCliente();
        return total;
    }

    public void realizarVenda(Pagamento fp) {
        if (itens.isEmpty())
            throw new IllegalStateException("Não é possível realizar uma venda sem itens.");
        if (fp == null)
            throw new IllegalArgumentException("A forma de pagamento não pode ser nula.");
        if (cliente == null)
            throw new IllegalStateException("A venda precisa de um cliente.");

        this.formaPagamento = fp;

        if (!fp.pagar())
            throw new IllegalStateException("O pagamento não foi aprovado.");
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private double descontoCliente() {
        return 0.05;
    }

    @Override
    public String toString() {
        return "Venda{formaPagamento=" + formaPagamento +
                ", itens=" + itens + ", cliente=" + cliente +
                ", total=" + calcularTotal() + "}";
    }
}
