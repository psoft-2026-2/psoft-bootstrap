/**
 * Pagamento
 */
public class Pagamento {
    private  Double valorApagar; 
    private  String formaDePagamento;
    
    public Pagamento(Double valorApagar, String formaDePagamento) {
        this.valorApagar = valorApagar;
        this.formaDePagamento = formaDePagamento;
    }

    public Double getValorApagar() {
        return valorApagar;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    } 

    

    

}
