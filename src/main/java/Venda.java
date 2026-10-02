import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItensDaVenda> itensDaVenda = new ArrayList<>();
    private Boolean foiPaga = false;
    private Cliente cliente;

    public Venda(Cliente cliente){
        this.cliente = cliente;
    }

    public void adicionaItem(int quantidade, Produto p){
        itensDaVenda.add(new ItensDaVenda(quantidade, p));
    }

    public double calculaTotal(){
        double total = 0;
        double desconto = cliente.getPerfil().getDesconto();

        for (ItensDaVenda item : itensDaVenda) {
            total += item.calculaValorItem();
        }

        return total - (total * desconto);
    }

    public Boolean fazerPagamento(Pagamento forma){
        foiPaga = forma.fazerPagamento(calculaTotal());
        return this.foiPaga;
    }

    @Override
    public String toString() {
        return "Vendas " + itensDaVenda + ", foiPaga=" + foiPaga + "]";
    }

}
