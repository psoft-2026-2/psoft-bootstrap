import java.util.HashSet;
import java.util.Set;

public class Loja {

    private Set<Produto> produtos;
    private Set<Cliente> clientes;
    private int proximoIdPedido;

    public Loja() {
        produtos = new HashSet<>();
        clientes = new HashSet<>();
        proximoIdPedido = 1;
    }

    public void cadastrarProduto(Produto produto) {
        if (!produtos.add(produto))
            throw new IllegalArgumentException("Produto já cadastrado: " + produto.getNome());
    }

    public void cadastrarCliente(Cliente cliente) {
        if (!clientes.add(cliente))
            throw new IllegalArgumentException("Cliente já cadastrado: " + cliente.getNome());
    }

    public Pedido criarPedido(Cliente cliente, Produto... itens) {
        if (!clientes.contains(cliente))
            throw new IllegalArgumentException("Cliente não cadastrado: " + cliente.getNome());

        Pedido pedido = new Pedido(proximoIdPedido++);
        for (Produto produto : itens) {
            if (!produtos.contains(produto))
                throw new IllegalArgumentException("Produto fora do catálogo: " + produto.getNome());
            pedido.addProduto(produto);
        }

        cliente.addPedido(pedido);
        return pedido;
    }

    public Set<Produto> getProdutos() {return produtos;}

    public Set<Cliente> getClientes() {return clientes;}

    public static void main(String[] args) {
        Loja loja = new Loja();

        Produto notebook = new Produto(1, "Notebook", 3500.00);
        Produto mouse = new Produto(2, "Mouse", 80.00);
        Produto teclado = new Produto(3, "Teclado", 150.00);
        loja.cadastrarProduto(notebook);
        loja.cadastrarProduto(mouse);
        loja.cadastrarProduto(teclado);

        Cliente ana = new Cliente("Ana", "111.111.111-11", 1);
        Cliente bruno = new Cliente("Bruno", "222.222.222-22", 2);
        bruno.setPremium(true);
        loja.cadastrarCliente(ana);
        loja.cadastrarCliente(bruno);

        System.out.println("=== Catálogo ===");
        loja.getProdutos().forEach(System.out::println);

        System.out.println("\n=== Clientes ===");
        loja.getClientes().forEach(System.out::println);

        Pedido pedidoAna = loja.criarPedido(ana, notebook, mouse);
        Pedido pedidoBruno = loja.criarPedido(bruno, notebook, teclado);

        System.out.println("\n=== Pedidos criados ===");
        System.out.println(ana.getNome() + ": " + pedidoAna);
        System.out.println(bruno.getNome() + ": " + pedidoBruno);

        System.out.println("\n=== Pagamentos ===");
        System.out.println(ana.pagarPedido(pedidoAna));
        System.out.println(bruno.pagarPedido(pedidoBruno) + " (premium: 10% de desconto)");

        System.out.println("\n=== Tentativas inválidas ===");
        try {
            ana.pagarPedido(pedidoAna);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            ana.pagarPedido(pedidoBruno);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\nPedidos após pagamento");
        System.out.println(pedidoAna);
        System.out.println(pedidoBruno);
    }
}
