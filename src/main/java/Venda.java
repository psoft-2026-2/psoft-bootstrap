import java.util.HashSet;

public class Venda {
    
    private Cliente cliente;
    private HashSet<ItemVenda> itens;
    private Pagamento pagamento;
    private boolean finalizada;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new HashSet<>();
        this.finalizada = false;
    }

    public void adicionarItem(Produto produto, int quantidade){
        this.itens.add(new ItemVenda(produto, quantidade));
    }

    public double calcularSubTotal(){
        double somador = 0;
        for(ItemVenda item: itens){
                somador += item.calcularSubtotal();
        }
        return somador;
    }

    public double calcularValorFinal(){
        return this.calcularSubTotal() * (1 - this.cliente.getDesconto());
    }

    public void adicionarPagamento(double valorPago, String metodo){
        this.pagamento = new Pagamento(valorPago, metodo);
        this.finalizada = true;
    }

    public boolean isFinalizado(){
        return this.finalizada;
    }

    public int countItens(){
        int contador = 0;
        for(ItemVenda item: this.itens){
            contador += item.getQuantidade();
        }
        return contador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public HashSet<ItemVenda> getItens() {
        return itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    @Override
    public String toString() {
        return "Venda [cliente=" + cliente + ", itens=" + itens + ", finalizada=" + finalizada
                + ", Valor Final= " + calcularValorFinal() + "]";
    }

}
