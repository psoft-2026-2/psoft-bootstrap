public class PagamentoCartao implements Pagamento {
    private int numeroCartao;

    public PagamentoCartao(int numCartao){
        this.numeroCartao = numCartao;
    }

    public Boolean fazerPagamento(double valor){
        //qualquer logica de pagamento
        System.out.println("Pagamento feito no valor R$:" + valor + ", no cartao de numero:" + numeroCartao);
        return true;
    }
}
