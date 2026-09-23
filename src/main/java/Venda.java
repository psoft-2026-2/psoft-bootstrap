import java.util.*;

public class Venda {
    private Cliente cliente;
    private Pagamento pagamento;
    private List<ItemVenda> itensVenda;

    public Venda(Cliente cliente, Pagamento pagamento) {
        this.cliente = cliente;
        this.pagamento = pagamento;

        this.itensVenda = new ArrayList<>();
    }

    public double getSubTotal(){
        double total = 0;

        for (ItemVenda i : itensVenda){
            total += i.getSubTotal();
        }

        return total;
    }

    public double getTotal(){
        double subTotal = getSubTotal();

        return subTotal - subTotal * cliente.temDesconto();
    }

    public void addItemVenda(ItemVenda itemVenda){
        this.itensVenda.add(itemVenda);
    }

    @Override
    public String toString() {
        return "Venda [cliente=" + cliente + ", itensVenda=" + itensVenda + "]";
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean statusPago, double valorPago) {
        this.pagamento.setStatusPago(statusPago);
        this.pagamento.setValorPago(valorPago);
    }

    public boolean isPago(){
        return  this.pagamento.isStatusPago();
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
}