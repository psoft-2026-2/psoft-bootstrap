import java.util.List;

public class Venda {

    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(Cliente cliente, List<ItemVenda> itens, Pagamento pagamento) {
        this.cliente = cliente;
        this.itens = itens;
        this.pagamento = pagamento;
    }

    public double calculaTotal(){
        double total = 0;
        for(ItemVenda item : itens)
            total += item.calculaPreco();

        total = (1 - cliente.calculaDesconto()) * total;
        return total;
    }

    public void realizarPagamento(){
        this.pagamento.setRealizou(true);
    }

    public void addItem(ItemVenda item){
        this.itens.add(item);
    }

    public void removeItem(ItemVenda item){
        this.itens.remove(item);
    }

    public List<ItemVenda> getItens(){
        return this.itens;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public Pagamento getPagamento(){
        return this.pagamento;
    }

    public void setCliente(Cliente novo){
        this.cliente = novo;
    }
}

