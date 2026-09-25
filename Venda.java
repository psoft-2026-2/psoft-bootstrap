import java.util.ArrayList;

public class Venda {
  private Cliente cliente;
  private ArrayList<ItensdeVenda> itens;
  private float valor;
  private Pagamento pagamento;

  public Venda(Cliente cliente) {
    this.cliente = cliente;
    this.valor = 0;
    this.itens = new ArrayList<ItensdeVenda>();
  }

  public void addItem(int qtd, Produto produto) {
    ItensdeVenda item = new ItensdeVenda(qtd, produto);
    this.itens.add(item);
    this.valor += item.getValor();
  }

  public void addPagamento(String pagamentoTipo, float valorPagamento) {
    this.pagamento = new Pagamento(pagamentoTipo, valorPagamento);
  }

  public float valorTotal() {
    float desconto = this.cliente.getDesconto();
    return this.valor * (1 - desconto);
  }

  @Override
  public String toString() {
    return "Venda: " + this.cliente.getNome() + " - R$ " + this.valorTotal();
  }
}