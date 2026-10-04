import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private Date dataVenda;
    private Cliente cliente;
    private List itens;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.dataVenda = new Date();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(produto, quantidade);
        this.itens.add(item);
    }

    public double total() {
        double subtotalGeral = 0.0;
        for (ItemVenda item : itens) {
            subtotalGeral += item.getSubTotal();
        }

        double percentualDescontoCliente = cliente.getPerfil().getPercentualDesconto();
        return subtotalGeral * (1.0 - percentualDescontoCliente);
    }

    public void realizarPagamento() {
        if (this.pagamento != null) {
            throw new IllegalStateException("Esta venda já foi paga.");
        }
        double valorTotal = total();
        this.pagamento = new Pagamento(valorTotal);
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List getItens() {
        return itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}