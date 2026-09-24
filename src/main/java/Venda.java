import java.util.List;
import java.util.ArrayList;

public class Venda {

    private List<Item> itensVenda;
    private Cliente cliente;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itensVenda = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto != null && quantidade > 0) {
            Item novoItem = new Item(produto, quantidade);
            itensVenda.add(novoItem);
        }
    }

    public double calcularValorSemDesconto() {
        double valor = 0;
        for (Item i : itensVenda) {
            valor += i.calcularValor();
        }
        return valor;
    }
    
    public double calcularValorFinal() {
        double valorNormal = calcularValorSemDesconto();
        
        return valorNormal * (1.00 - cliente.desconto());
    }

    public void adicionarPagamento(String metodo) {
        double valor = calcularValorFinal();
        pagamento.setMetodo(metodo);
        pagamento.setValorPago(valor);
    }

    public List<Item> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<Item> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}