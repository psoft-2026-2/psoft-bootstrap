import java.util.List;

public class Venda {  
    private String codigo;
    private List<ItemVenda> itens;
    private Double total;
    private Pagamento pagamento;
    private Cliente cliente;
    
    public Venda(String codigo, List<ItemVenda> itens, Double total, Pagamento pagamento, Cliente cliente) {
        this.codigo = codigo;
        this.itens = itens;
        this.total = total;
        this.pagamento = pagamento;
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double calculaTotal() {
        Double total = 0.0;

        for (ItemVenda item : itens)
            total += item.calculaDesconto();

        return total * cliente.getDesconto();
            
    }

    public double getTotal() {
        return total;
    }
}
