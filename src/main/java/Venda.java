import java.util.ArrayList;

public class Venda {
    private Cliente cliente;
    private ArrayList<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.pagamento = null;
    }

    public void addItem(Produto produto, int quantidade) {
        this.itens.add(new ItemVenda(produto, quantidade));
    }

    public float getValorAPagar() {
        float total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubTotal();
        }
        return cliente.aplicarDesconto(total);
    }

    public String realizarPagamento(String tipo) {
        float valorFinal = getValorAPagar();
        this.pagamento = new Pagamento(valorFinal, tipo);
        return pagamento.pagar();
    }
}