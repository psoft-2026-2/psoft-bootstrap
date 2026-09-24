import java.util.ArrayList;
import java.util.List;

public class Venda {
    private  Cliente cliente; 
    private List<ItemDeVenda> itens;
    private Pagamento pagamento;
   
    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>(); 
    }
    public void adicionarItem(Item item,int quantidade){
        ItemDeVenda produto = new ItemDeVenda(item, quantidade);
        this.itens.add(produto); 


    }
    public Double total(){
        Double out = 0.0; 
        
        for (ItemDeVenda i : this.itens){
            out += i.subTotal(); 
        } 
        if (this.cliente.getStatus() == Status.premium){
            out *= 0.95; 
        }
        return out; 
    }

    public String  mostraCliente(){
        return this.cliente.getNome(); 
    }
    public  String mostraItem(){
        StringBuilder out = new StringBuilder();  
        if (this.itens.size() != 0){
            for (ItemDeVenda i : this.itens){
                out.append(i.getItem().getNomeItem()); 
                out.append("\n"); 
            }
        }
        return  out.toString(); 
    }
    public void fazerPagamento(String formaDePagamento, Double valoraPagar){
        this.pagamento = new  Pagamento(valoraPagar, formaDePagamento); 
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }

    


    
    
    
}
