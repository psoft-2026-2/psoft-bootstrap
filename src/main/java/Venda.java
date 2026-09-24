package main.java;
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

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public double calcularTotal() {

        double total = 0;

        for (ItemVenda item : itens) {
            total += item.calcularPrecoComDesconto();
        }

        if (cliente.ehPremium()) {
            total = total * 0.95;
        }

        return total;
    }

    public void registrarPagamento(Pagamento pagamento) {
        if (pagamento.getValor() == calcularTotal()) {
            this.pagamento = pagamento;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}