import java.util.ArrayList;
import java.util.List;

public class Mercado {
    private List<Produto> produtos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    public Produto cadastrarProduto(String nome, double preco) {
        Produto produto = new Produto(nome, preco);
        produtos.add(produto);
        return produto;
    }

    public Cliente cadastrarCliente(String nome, PerfilAssinatura perfil) {
        Cliente cliente = new Cliente(nome, perfil);
        clientes.add(cliente);
        return cliente;
    }

    public Venda novaVenda(Cliente cliente) {
        Venda venda = new Venda(cliente);
        vendas.add(venda);
        return venda;
    }
}