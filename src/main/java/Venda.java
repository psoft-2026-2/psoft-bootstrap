import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {
    private int idVenda;
    private Cliente cliente;
    private List<ItemVenda> itensVenda;
    private float precoTotal;
    private Pagamento pagamento;

    public Venda(int idVenda, Cliente cliente) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.itensVenda = new ArrayList<>();
        this.precoTotal = 0f;
        this.pagamento = null;
    }

    public void addItem(ItemVenda item) {
        itensVenda.add(item);
        calculaPrecoTotal();
    }

    public float calculaPrecoTotal() {
        if (pagamento != null) {
            return precoTotal;
        }
        float soma = 0f;
        int quantidadeTotal = 0;
        for (ItemVenda item : itensVenda) {
            soma += item.calculaTotal();
            quantidadeTotal += item.getQtd();
        }
        if (quantidadeTotal >= 20) {
            soma *= 0.90f;
        }
        if (cliente.getAssinatura() == Assinatura.PREMIUM) {
            soma *= 0.95f;
        }
        precoTotal = soma;
        return precoTotal;
    }

    public void setPagamento(int idPag, TipoPag tipo) {
        float total = calculaPrecoTotal();
        pagamento = new Pagamento(idPag, total, tipo);
    }

    public void removeItem(ItemVenda item) {
        itensVenda.remove(item);
        calculaPrecoTotal();
    }

    public int getId() {
        return idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return Collections.unmodifiableList(itensVenda);
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}
