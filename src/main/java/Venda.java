import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {

    private Cliente cliente;
    private List<ItemProduto> itens;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {

        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.pagamento = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void registrarItem(Produto produto, int qtd) {

        ItemVenda item = new ItemVenda(produto, qtd);

        itens.add(item);
    }

    public double getPrecoTotal() {

        double subtotal = 0.0;

        for (ItemProduto item : itens) {
            subtotal += item.getPreco();
        }

        double descontoCliente = subtotal * cliente.getDescontoPerfil();

        return subtotal - descontoCliente;
    }

    public void registrarPagamento(double valor, String tipo, String descricao) {

        double valorVenda = getPrecoTotal();

        if (valor < valorVenda) {
            throw new IllegalArgumentException(
                    "Valor do pagamento insuficiente."
            );
        }

        this.pagamento = new Pagamento(valor, tipo, descricao);
    }
}