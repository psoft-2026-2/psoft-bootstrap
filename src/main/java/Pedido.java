import java.util.HashSet;
import java.util.Set;

public class Pedido {

    private int id;
    private Set<Produto> produtos;
    private double valorTotal;
    private boolean statusPagamento;

    public Pedido(int id) {
        this.id = id;
        produtos = new HashSet<>();
        valorTotal = 0;
        statusPagamento = false;
    }

    public void addProduto(Produto produto) {
        if (statusPagamento)
            throw new IllegalStateException("Pedido já pago não pode ser alterado");
        if (produtos.add(produto))
            valorTotal += produto.getPreco();
    }

    public void pagarPedido() {
        if (statusPagamento)
            throw new IllegalStateException("Pedido " + id + " já foi pago");
        statusPagamento = true;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Set<Produto> getProdutos() {return produtos;}

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
        valorTotal = produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    public double getValorTotal() {return valorTotal;}

    public boolean isStatusPagamento() {return statusPagamento;}

    public void setStatusPagamento(boolean statusPagamento) {this.statusPagamento = statusPagamento;}

    @Override
    public String toString() {
        return String.format("Pedido [id=%d, produtos=%d, valorTotal=R$ %.2f, pago=%s]",
                id, produtos.size(), valorTotal, statusPagamento ? "sim" : "não");
    }

    @Override
    public int hashCode() {return Integer.hashCode(id);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        return id == other.id;
    }
}
