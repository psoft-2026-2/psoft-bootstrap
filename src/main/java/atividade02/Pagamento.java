package atividade02;

public class Pagamento {

    private String metodoPagamento;

    public Pagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public boolean validaPagamento() {
        return metodoPagamento != null && !metodoPagamento.isBlank();
    }
}