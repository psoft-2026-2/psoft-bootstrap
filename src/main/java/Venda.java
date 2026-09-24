import java.util.List;
import java.util.ArrayList;


public class Venda {
    private List<ItemVenda> itens;
    private Cliente cliente;
    private Pagamento pagamento;
    private boolean finalizado;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void addItem(Produto p, int quant) {
        itens.add(new ItemVenda(p, quant));
    }

    public float calculaTotal() {
        float total = 0;

        for (ItemVenda item : itens) {
            total += item.calculaSubTotal();
        }

        // confirmar se assim é bom mesmo
        return total - total * cliente.getDescontoPerfil();
    }

    public void finaliza() {
        if (this.pagamento == null) {
            throw new NullPointerException("pagamento nulo");
        }

        pagamento.paga(calculaTotal());
        this.finalizado = true;
    }

    public void definePagamento(String tipo) {
        this.pagamento = new Pagamento(tipo);
    }
}
