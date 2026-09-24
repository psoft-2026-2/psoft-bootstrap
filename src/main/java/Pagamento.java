public class Pagamento {
    private float valorFinal;
    private ItensVenda itens;
    private String formaPagamento;
    private boolean finalizado;

    public Pagamento() {
        this.valorFinal = 0;
        this.itens = new ItensVenda();
        this.formaPagamento = "";
        this.finalizado = false;
    }

    public void addItem(ProdutoModel produto) {
        if (!finalizado) {
            this.itens.addProduto(produto);
        }
    }

    public void removeItem(String id) {
        if (!finalizado) {
            this.itens.removeProduto(id);
        }
    }

    public void finalizar(String formaPagamento, boolean ePremium) {
        if (finalizado) return;

        this.formaPagamento = formaPagamento;
        float total = this.itens.getSubTotal();

        // Aplicando regra de desconto por quantidade de itens
        if (this.itens.getQuantidade() >= 20) {
            total -= total * 0.10f;
        }

        // Aplicando regra de desconto de cliente Premium
        if (ePremium) {
            total -= total * 0.05f;
        }

        this.valorFinal = total;
        this.finalizado = true;
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
}