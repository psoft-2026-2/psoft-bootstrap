import java.util.*;

public class Venda {
    private Cliente cliente;
    private List itens; 
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int qtd) {
        this.itens.add(new ItemDeVenda(produto, qtd));
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemDeVenda item : itens) {
            total += item.getSubTotal();
        }
        double descontoCliente = cliente.getDescontoAdicional();
        total = total - (total * descontoCliente);
        return total;
    }

    public void realizarPagamento(double valorPagoCliente) {
        double totalDaVenda = calcularTotal();
        if (this.pagamento != null) {
            throw new IllegalStateException("O pagamento desta venda já foi realizado.");
        }
        if (valorPagoCliente < totalDaVenda) {
            throw new IllegalArgumentException("Valor pago insuficiente. Faltam: " + (totalDaVenda - valorPagoCliente));
        }
        this.pagamento = new Pagamento(valorPagoCliente);
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}