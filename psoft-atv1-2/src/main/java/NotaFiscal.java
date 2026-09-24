import java.util.ArrayList;

public class NotaFiscal {

    private Cliente cliente;
    private ArrayList<ItemVenda> itensVenda;
    private Pagamento pagamento;

    public NotaFiscal(Cliente cliente) {
        this.cliente = cliente;
        this.itensVenda = new ArrayList<>();
    }

    public void addItemVenda(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(produto, quantidade);
        this.itensVenda.add(item);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public double getValorTotal() {
        double valorTotal = 0.0;
        for (ItemVenda item : itensVenda) {
            valorTotal += item.getValorTotal();
        }
        
        if (temDescontoAssinatura()) {
            valorTotal = valorTotal - (valorTotal * 0.05); // Aplica os 5% de desconto
        }
        return valorTotal;
    }

    public boolean temDescontoAssinatura() {
        if (cliente.getPerfilAssinatura() == Assinatura.PREMIUM) {
            return true;
        }
        return false;
    }

    public boolean efetuarPagamento(String tipoPagamento, double valorPago) {
        if (valorPago == getValorTotal()) {
            this.pagamento = new Pagamento(tipoPagamento, valorPago, StatusPagamento.APROVADO);
            return true;
        }
        return false;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}
