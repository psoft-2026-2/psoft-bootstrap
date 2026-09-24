import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<ItemVenda> itensVenda;
    private Pagamento pagamento;

    public Venda(Cliente cliente){
        this.cliente = cliente;
        this.pagamento = null;
        this.itensVenda = new ArrayList<>();
    }

    public void cadastrarItemVenda(Produto p, int quantidade){
        ItemVenda newItem = new ItemVenda(p, quantidade);
        this.itensVenda.add(newItem);
    }

    public double calculaDesconto(Cliente cliente) { 
        return cliente.calculaDesconto(); 
    }

    public double getTotal() { 
        double somaSubtotais = 0.0; 
        for (ItemVenda item : itensVenda) { 
            somaSubtotais += item.getSubtotal(); 
        } 
        
        double fatorDescontoCliente = calculaDesconto(this.cliente); 
        return somaSubtotais * (1.0 - fatorDescontoCliente); 
    }

    public Pagamento realizarPagamento(double valor) { 
        double totalComDesconto = getTotal(); 
    
        if (valor < totalComDesconto) { 
            throw new IllegalArgumentException("Valor insuficiente para pagar"); 
        } 
        
        this.pagamento = new Pagamento(valor); 
        return this.pagamento; 
    }

    public Cliente getCliente() { 
        return cliente; 
    } 

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

}