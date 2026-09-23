package mercado;

import java.util.List;

public class Venda {

    private static final float PERCENTUAL_DESCONTO_PREMIUM = 0.05f;

    private String idVenda;
    private List<ItemDeVenda> itens;
    private float total;
    private Cliente cliente;
    private Pagamento pagamento;

    public Venda(String idVenda, List<ItemDeVenda> itens, Cliente cliente) {
        this.idVenda = idVenda;
        this.itens = itens;
        this.cliente = cliente;
        this.total = calculaTotal();
    }

    public float calculaTotal() {
        float soma = 0f;
        for (ItemDeVenda item : itens) {
            soma += item.calculaSubtotal();
        }
        if (recebeDescontoCliente()) {
            soma = aplicaDescontoCliente(soma);
        }
        this.total = soma;
        return soma;
    }

    public boolean recebeDescontoCliente() {
        return cliente != null && cliente.getTipo() == TipoCliente.PREMIUM;
    }

    public float aplicaDescontoCliente(float valor) {
        return valor * (1 - PERCENTUAL_DESCONTO_PREMIUM);
    }

    public void efetuarPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public List<ItemDeVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemDeVenda> itens) {
        this.itens = itens;
        calculaTotal();
    }

    public float getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        calculaTotal();
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}