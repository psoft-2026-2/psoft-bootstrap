import java.util.ArrayList;

public class Venda {
    private ArrayList<ItemVenda> itens;
    private TipoPagamento tipoPagamento;
    private boolean pago;
    private Cliente cliente;

    public Venda(Cliente cliente, TipoPagamento tipoPagamento) {
        this.cliente = cliente;
        this.tipoPagamento = tipoPagamento;
        this.itens = new ArrayList<>();
        this.pago = false;
    }

    public boolean adicionarItem(Produto produto, int qtd) {
        if (produto == null || qtd <= 0 || pago) {
            return false;
        }
        itens.add(new ItemVenda(produto, qtd));
        return true;
    }

    public int total() {
        int valor = 0;
        for (ItemVenda item : itens) {
            valor += item.subtotal();
        }
        valor -= valor * cliente.getDesconto() / 100;
        return valor;
    }

    public boolean setPago() {
        if (pago) {
            return false;
        }
        this.pago = true;
        return true;
    }

    public String listarItens() {
        StringBuilder sb = new StringBuilder();
        for (ItemVenda item : itens) {
            sb.append(item.getProduto().getNome())
              .append(" - ").append(item.getQtd()).append(" un. - subtotal: ")
              .append(item.subtotal()).append(" centavos\n");
        }
        return sb.toString();
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public boolean getPago() {
        return pago;
    }

    public Cliente getCliente() {
        return cliente;
    }
}