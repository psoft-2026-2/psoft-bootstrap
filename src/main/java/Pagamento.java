public class Pagamento {
    private final String id;
    private final Venda venda;
    private final String formaPagamento;

    public Pagamento(String id, Venda venda, String formaPagamento) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("objeto invalido");
        }
        if (venda == null) {
            throw new IllegalArgumentException("objeto invalido");
        }
        if (formaPagamento == null || formaPagamento.trim().isEmpty()) {
            throw new IllegalArgumentException("objeto invalido");
        }

        this.id = id.trim();
        this.venda = venda;
        this.formaPagamento = formaPagamento.trim();
    }

    public String getId() {
        return id;
    }

    public Venda getVenda() {
        return venda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
