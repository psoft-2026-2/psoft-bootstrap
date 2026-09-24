import java.util.ArrayList;
import java.util.List;

public class Venda {
    
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Float valorTotal;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0f;
        this.pagamento = null;
    }

    public void adicionarItem(ItemVenda item) {
        this.itens.add(item);
        this.valorTotal += item.getSubTotal();
    }

    public Float calcularValorTotal() {
        Float total = 0f;

        for (ItemVenda item : itens) {
            total += item.getSubTotal();
        }

        this.valorTotal = calcularDesconto(total);
        return this.valorTotal;
    }

    private Float calcularDesconto(Float total) {
        if (cliente.getPerfil() == Perfil.PREMIUM) {
            total = total * 0.95f;
        }

        return total;
    }

    public void realizarPagamento() {
        this.pagamento = new Pagamento(valorTotal);
    }

    public String listarItens() {
        StringBuilder sb = new StringBuilder();

        for (ItemVenda item : itens) {
            sb.append(item.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override 
    public String toString() {
        return "Cliente: " + cliente.getNome() +
               "\nItens:\n" + listarItens() +
               "\nValor Total: " + valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Float getValorTotal() {
        return valorTotal;
    }
}
