import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private final List<Produto> produtos;
    private final List<Cliente> clientes;

    public Mercado() {
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Venda novaVenda(Cliente cliente) {
        return new Venda(cliente);
    }
}