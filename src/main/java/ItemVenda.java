import java.util.Objects;

public class ItemVenda {
    private int quantidade;
    private Produto produto;
    private double subtotal;

    public ItemVenda(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
        calculaSubtotal();
    }

    private void calculaSubtotal() {
        double totalBruto = this.quantidade * this.produto.getPreco();
        if (this.quantidade >= 20) {
            this.subtotal = totalBruto * 0.90; // 10% de desconto
        } else {
            this.subtotal = totalBruto;
        }
    }

    public void aumentaQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
            calculaSubtotal();
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemVenda)) return false;
        ItemVenda itemVenda = (ItemVenda) o;
        return Objects.equals(produto, itemVenda.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto);
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "produto=" + produto.getNome() +
                ", quantidade=" + quantidade +
                ", subtotal=" + subtotal +
                '}';
    }
}
