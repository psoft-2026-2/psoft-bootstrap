import java.util.List;
import java.util.ArrayList;

public class Mercado {
    private List<Cliente> clientes;
    private List<Produto> produtos;

    public Mercado(){
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public void AdicionarCliente(Cliente novoCliente){
        this.clientes.add(novoCliente);
    }

    public void AdicionaProduto(Produto novoProduto){
        this.produtos.add(novoProduto);
    }

    public Cliente buscarCliente(String id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Produto buscarProduto(String id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Venda novaVenda(Cliente cliente) {
        return new Venda(cliente);
    }

}
