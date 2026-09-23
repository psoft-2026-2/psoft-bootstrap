package mercado;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Mercado {

    private Map<String, Venda> vendas;
    private Map<String, Cliente> clientes;
    private Map<String, Produto> produtos;

    public Mercado() {
        this.vendas = new HashMap<>();
        this.clientes = new HashMap<>();
        this.produtos = new HashMap<>();
    }

    public Venda consultarVenda(String idVenda) {
        return vendas.get(idVenda);
    }

    public Venda criarVenda(List<ItemDeVenda> itens, Cliente cliente, Pagamento pagamento) {
        String idVenda = UUID.randomUUID().toString();
        Venda venda = new Venda(idVenda, itens, cliente);
        venda.efetuarPagamento(pagamento);
        vendas.put(idVenda, venda);
        return venda;
    }

    public Venda editarVenda(String idVenda, List<ItemDeVenda> itens, Cliente cliente, Pagamento pagamento) {
        Venda venda = vendas.get(idVenda);
        if (venda == null) {
            return null;
        }
        venda.setItens(itens);
        venda.setCliente(cliente);
        venda.efetuarPagamento(pagamento);
        return venda;
    }

    public void cancelarVenda(String idVenda) {
        vendas.remove(idVenda);
    }

    public Cliente adicionarCliente(String nome, String cpf, String telefone, TipoCliente tipo) {
        Cliente cliente = new Cliente(nome, cpf, telefone, tipo);
        clientes.put(cpf, cliente);
        return cliente;
    }

    public Cliente editarCliente(String cpf, String nome, String telefone, TipoCliente tipo) {
        Cliente cliente = clientes.get(cpf);
        if (cliente == null) {
            return null;
        }
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setTipo(tipo);
        return cliente;
    }

    public void removerCliente(String cpf) {
        clientes.remove(cpf);
    }

    public Cliente consultarCliente(String cpf) {
        return clientes.get(cpf);
    }

    public Produto adicionarProduto(String codigo, float preco) {
        Produto produto = new Produto(codigo, preco);
        produtos.put(codigo, produto);
        return produto;
    }

    public Produto editarProduto(String codigo, float preco) {
        Produto produto = produtos.get(codigo);
        if (produto == null) {
            return null;
        }
        produto.setPreco(preco);
        return produto;
    }

    public void removerProduto(String codigo) {
        produtos.remove(codigo);
    }

    public Produto consultarProduto(String codigo) {
        return produtos.get(codigo);
    }
}