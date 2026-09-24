package mercado;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<ItemVenda> itensVendas;
    private Cliente cliente;
    private double precoTotal;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.itensVendas = new ArrayList<ItemVenda>();
        this.cliente = cliente;
        this.precoTotal = 0;
        this.pagamento = null;
    }

    public void addItem(Produto produto, int quant) throws IllegalArgumentException {
        if (produto == null && quant == 0) {
            throw new IllegalArgumentException();
        }
        ItemVenda newItem = new ItemVenda(produto, quant);
        itensVendas.add(newItem);
    }

    public double calculaTotal() {
        double totalFinal = 0;
        for (ItemVenda item : itensVendas) {
            totalFinal += item.calcTotalItem();
        }
        if (this.cliente.getTipo() == TipoCliente.PREMIUM) {
            totalFinal -= totalFinal * 0.05;
        }
        this.precoTotal = totalFinal;
        return totalFinal;
    }

    public boolean efetuarPagamento(double valor, String tipoPagamento) throws IllegalArgumentException {
        if (tipoPagamento == null) {
            throw new IllegalArgumentException();
        }
        if (valor < calculaTotal()) {
            return false;
        }
        Pagamento newpagamento = new Pagamento(calculaTotal(), valor, tipoPagamento);
        this.pagamento = newpagamento;
        return true;
    }

    public String getCliente() {
        return cliente.getNome() + ": " + cliente.getCpf();
    }

    public String getPagamento() {
        return pagamento.getExtrato();
    }
}
