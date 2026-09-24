public class ItemVenda {
    private int qtdDeProdutos;
    private Produto produto;
    private int minimoParaDesconto = 20;
    private int desconto = 10; // em %

    public ItemVenda(Produto produto, int qtdDeProdutos) {
        this.produto = produto;
        this.qtdDeProdutos = qtdDeProdutos;
    }

    public boolean temDesconto() {
        return qtdDeProdutos >= minimoParaDesconto;
    }

    public int subtotal() {
        int valor = qtdDeProdutos * produto.getPreco();
        if (temDesconto()) {
            valor -= valor * desconto / 100;
        }
        return valor;
    }

    public int getQtd() {
        return qtdDeProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getMinimo() {
        return minimoParaDesconto;
    }

    public int getDesconto() {
        return desconto;
    }

    public boolean setMinimo(int newMin) {
        if (newMin <= 0) {
            return false;
        }
        this.minimoParaDesconto = newMin;
        return true;
    }

    public boolean setDesconto(int newDiscount) {
        if (newDiscount < 0 || newDiscount > 100) {
            return false;
        }
        this.desconto = newDiscount;
        return true;
    }
}