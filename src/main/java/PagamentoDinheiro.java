public class PagamentoDinheiro implements Pagamento {

    public PagamentoDinheiro(){}

    public Boolean fazerPagamento(double valor){
        //qualquer logica de pagamento
        System.out.println("Pagamento feito no valor R$:" + valor + ", em dinheiro");
        return true;
    }
}

