import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mercado {

    private Map<String, Cliente> clientes;
    private Map<Integer, Produto> produtos;
    private Map<String,Venda> vendas;

    public Mercado() {
        this.clientes = new HashMap<>();
        this.produtos = new HashMap<>();
        this.vendas = new HashMap<>();
    }

    public Cliente cadastrarCliente(String nome, String cpf, String email, Perfil assinatura) {

        Cliente cliente = new Cliente(nome, cpf, email, assinatura);

        clientes.put(cpf, cliente);

        return cliente;
    }

    public Produto cadastrarProduto(String nome, String descricao, double preco) {

        Produto produto = new Produto(nome, descricao,preco);

        produtos.put(produto.getId(), produto);

        return produto;
    }

    public Venda cadastrarVenda(String cpf) {

        Venda venda = new Venda(this.clientes.get(cpf));

        vendas.put(cpf, venda);

        return venda;
    }

}