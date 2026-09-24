public class Pagamento {
    private double valorTotal;
    private double valorPago;

    public Pagamento(double valorPago, double valorTotal){
        this.valorPago = valorPago;
        this.valorTotal = valorTotal;
    }

    public boolean processar(){
        return this.valorPago >= this.valorTotal;
    }

    public double calculaPagamento(){
        double valorTroco = 0.0;
        if(processar()){
            valorTroco = this.valorPago - this.valorTotal;
        }
        return valorTroco;
    }
}
