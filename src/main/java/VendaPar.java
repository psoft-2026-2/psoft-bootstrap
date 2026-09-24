public class VendaPar {
    private int quantidade;
    private Produto prouto;

    public VendaPar(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.prouto = produto;
    }

    public double calcularTotal() {
        double total = quantidade * prouto.getPreco();

        if (quantidade > 20){
            total *= 0.90;
        }
        return total;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return prouto;
    }
}