import java.util.LinkedList;

public class Mercado {
    private LinkedList<Produto> produtos;
    private LinkedList<Venda> vendas;
    private LinkedList<Cliente> clientes;

    public Mercado() {
        this.produtos = new LinkedList<>();
        this.vendas = new LinkedList<>();
        this.clientes = new LinkedList<>();
    }

    public void addProduto(Produto prod) {
        produtos.add(prod);
    }

    public void addClient(Cliente client) {
        clientes.add(client);
    }

    public void criarVenda(int qtd, Produto prod, Cliente client) {
        Venda venda = new Venda(client);
        vendas.add(venda);
        adicionarItemVenda(venda, qtd, prod);
    }

    public void adicionarItemVenda(Venda venda, int qtd, Produto prod) {
        venda.cadastrarItemVenda(qtd, prod);
    }
}
