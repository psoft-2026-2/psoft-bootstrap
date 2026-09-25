public class ItensDaVenda {
    private int quantidadeProduto;
    private Produto produto;
    private double valorComDesconto = 0.9;
    private int quantidadeMinima = 20;

    public ItensDaVenda(int quantidade, Produto produto){
        this.quantidadeProduto = quantidade;
        this.produto = produto;
    }

    public double calculaValorItem(){
        double valorItens = quantidadeProduto * produto.getPreco();
        if (checaDescontoItens()) {
            return valorItens * valorComDesconto;
        } else return valorItens;
    }

    private boolean checaDescontoItens(){
        return (quantidadeProduto >= quantidadeMinima);
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "ItensDaVenda [quantidadeProduto=" + quantidadeProduto + ", produto=" + produto + "]";
    }


}