import java.util.Date;
import java.util.LinkedList;

public class Venda {
    private LinkedList<ItemVenda> itensVenda;
    private Cliente comprador;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.itensVenda = new LinkedList<ItemVenda>();
        this.comprador = cliente;
    }

    public float total() {
        float total = 0;
        for (ItemVenda item : itensVenda) {
            total += item.subTotal();
        }
        if (comprador.getPerfil() == Perfil.PREMIUM) {
            total = total * 0.95f;
        }
        return total;
    }

    public void criarPagamento() {
        this.pagamento = new Pagamento(total(), new Date());
    }

    public void cadastrarItemVenda(int qtd, Produto prod) {
        itensVenda.add(new ItemVenda(prod, qtd));
    }

}
