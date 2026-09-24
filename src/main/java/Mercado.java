import java.util.List;
import java.util.Map;

public class Mercado {
    private Map<String, Cliente> clientes;
    private Map<String, Venda> vendas;
    private Map<String, Produto> produtos;

    public Mercado(Map<String, Cliente> clientes, Map<String, Venda> vendas, Map<String, Produto> produtos) {
        this.clientes = clientes;
        this.vendas = vendas;
        this.produtos = produtos;
    }

    public Cliente cadastrarCliente(String nome, String CPF, String email, Perfil perfil) {
        Cliente cliente = new Cliente(nome, CPF, email, perfil);
        clientes.put(email, cliente);
        
        return cliente;
    }

    public Venda cadastraVenda(String codigo, List<ItemVenda> itens, double total, Pagamento pagamento, Cliente cliente) {
        Venda venda = new Venda(codigo, itens, total, pagamento, cliente);
        vendas.put(codigo, venda);
        
        return venda;
    }
    
    public Produto cadastraProduto(String nome, Double preco, String lote) {
        Produto produto = new Produto(nome, preco, lote);
        produtos.put(nome, produto);

        return produto;
    }

    public String listarProdutos() {
        String resultado = "";

        for (Produto produto : produtos.values())
            resultado += produto.toString() + " ";

        return resultado;
    }

    public String listarVendas() {
        String resultado = "";

        for (Venda venda : vendas.values())
            resultado += venda.toString() + " ";

        return resultado;
    }

    public String listarClientes() {
        String resultado = "";

        for (Cliente cliente : clientes.values())
            resultado += cliente.toString() + " ";

        return resultado;
    }
}
