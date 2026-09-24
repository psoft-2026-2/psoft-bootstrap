import java.util.ArrayList;
import java.util.List;

public class Venda {

    private static long proximoId = 1;
    private final long idVenda;
    private Cliente cliente;
    private Pagamento pagamento;
    private List<ItemVenda> itensDaVenda;

    public Venda(Cliente cliente) {
        this.idVenda = proximoId++;
        this.cliente = cliente;
        this.itensDaVenda = new ArrayList<>();
        this.pagamento = null;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public String getPagamento() {
        if(pagamento == null){
            return "Pagamento não registrado";
        }
        return pagamento.toString();
    }

    public List<ItemVenda> getItensDaVenda() {
        return itensDaVenda;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemVenda item : itensDaVenda) {
            total += item.calcularSubtotal();
        }
        return cliente.ativaDesconto(total);
    }

    public void registrarPagamento(Pagamento pagamento) {
        if(pagamento == null){
            throw new IllegalArgumentException("Pagamento não pode ser nulo");
        }
        this.pagamento = pagamento;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(produto, quantidade);
        itensDaVenda.add(item);
    }

    

     @Override
    public String toString() {
        return "Venda : " + "\n" +
        "cliente=" + cliente.toString() + "\n" +
        "pagamento=" + getPagamento() + "\n" +
        "itensDaVenda=" + itensDaVenda.toString();
    }

     @Override
     public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idVenda ^ (idVenda >>> 32));
        return result;
     }

     @Override
     public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Venda other = (Venda) obj;
        if (idVenda != other.idVenda)
            return false;
        return true;
     }
       
    
}
