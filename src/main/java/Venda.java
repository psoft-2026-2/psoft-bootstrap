import java.util.ArrayList;
import java.util.List;

public class Venda {
    private String idVenda;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(String idVenda, Cliente cliente) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.pagamento = null;
        this.itens = new ArrayList<>();
   }

    public String getIdVenda() {
        return this.idVenda;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void adicionaItem(Produto produto, int qtd) {
        ItemVenda iv = new ItemVenda(produto, qtd);
        this.itens.add(iv);
    }
    
    public List<ItemVenda> getItens() {
        return this.itens;
    }

    public float calculaTotal() {
        float total = 0;
        for (ItemVenda item: this.itens) {
            total += item.valorTotal();
        }

        if (this.cliente.getPerfil().equals(Perfil.PREMIUM)) {
            total = total * 0.95f;
        }

        return total;
    }

    public void registrarPagamento(FormaPag forma) {
        Pagamento p = new Pagamento(this.calculaTotal(), forma);
        this.pagamento = p;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }
}
