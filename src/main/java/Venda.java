import java.util.ArrayList;
import java.util.List;

public class Venda {
    private String id;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    //Padrão Creator: Venda cria ItemVenda
    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(produto, quantidade);
        this.itens.add(item);
    }

    //Padrão Information Expert: Soma os subtotais de cada item
    public double getValorSubtotal() {
        double subtotal = 0.0;
        for (ItemVenda item : itens) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    //Padrão Information Expert: Aplica o desconto do perfil do cliente sobre o subtotal
    public double getValorTotal() {
        double subtotal = getValorSubtotal();
        double percentualDescontoCliente = cliente.getPercentualDescontoAssinatura();
        
        return subtotal * (1.0 - percentualDescontoCliente);
    }

    //Padrão Creator/Information Expert: Gera o Pagamento associado
    public Pagamento gerarPagamento(String idPagamento) {
        double valorFinal = getValorTotal();
        this.pagamento = new Pagamento(idPagamento, valorFinal);
        return this.pagamento;
    }

    public String getId() {
        return id;
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