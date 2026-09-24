import java.util.*;

public class Venda {
    private Cliente cliente;
    private Pagamento pagamento;    
    private List<ItemVenda> itens;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void addItem(Produto produto, int qtd) {
        this.itens.add(new ItemVenda(produto, qtd));
    }

    public double calculoTotal() {
        double valorFinal = 0;
        for (ItemVenda it : itens) {
            valorFinal += it.valorComDesc();
        }

        if (cliente.isPremium()) {
            valorFinal = valorFinal - (valorFinal * 0.05);
        }
        return valorFinal;
    }

    public boolean registraPagamento(double valorPago) {
        double total = calculoTotal();
        this.pagamento = new Pagamento(valorPago);
        this.pagamento.mudaStatus(total);
        return this.pagamento.isStatus();
    }

    public String listaItens() {
        StringBuilder sb = new StringBuilder();
        for (ItemVenda it : itens) {
            sb.append(it).append("\n");
        }
        return sb.toString();
    }
}
