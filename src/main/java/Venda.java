import java.util.ArrayList;
import java.util.List;

public class Venda {
    private final int idVenda;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(int idVenda, Cliente cliente) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public int getIdVenda() {
        return idVenda;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void addPagamento(String tipoPagamento) {
        pagamento = new Pagamento(tipoPagamento, 0.0f);
    }

    public void addItem(Produto item, int qtd) {
        itens.add(new ItemVenda(item, qtd));
    }

    public boolean temDesconto20Produtos() {
        int quantidadeTotal = 0;
        for (ItemVenda item : itens) {
            quantidadeTotal += item.getQuantidade();
        }
        return quantidadeTotal >= 20;
    }

    public boolean temDescontoPerfilCliente() {
        return this.cliente.getPerfil().equals("premium");
    }

    public float total() {
        float total = 0;
        for (ItemVenda item : itens) {
            total += item.subtotal();
        }
        if (temDesconto20Produtos()) {
            total *= 0.90f;
        }
        if (temDescontoPerfilCliente()) {
            total *= 0.95f;
        }
        return total;
    }

    public boolean fecharPagamento() {
        pagamento.fechar();
        return pagamento.isClosed();
    }
}
