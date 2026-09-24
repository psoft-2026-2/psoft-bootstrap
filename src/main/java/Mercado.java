import java.util.ArrayList;
import java.util.List;

public class Mercado {
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Venda> vendas;

    public Mercado() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public boolean addCliente(Cliente cliente) {
        if (cliente == null || cliente.getCpf() == null) {
            return false;
        }
        if (buscaCliente(cliente.getCpf()) != null) {
            return false;
        }
        clientes.add(cliente);
        return true;
    }

    public Cliente removerCliente(String cpf) {
        if (cpf == null) {
            return null;
        }
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf() != null && clientes.get(i).getCpf().equals(cpf)) {
                return clientes.remove(i);
            }
        }
        return null;
    }

    public Cliente buscaCliente(String cpf) {
        if (cpf == null) {
            return null;
        }
        for (Cliente c : clientes) {
            if (c.getCpf() != null && c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public boolean addProduto(Produto produto) {
        if (produto == null || produto.getIdProduto() == null) {
            return false;
        }
        if (buscaProduto(produto.getIdProduto()) != null) {
            return false;
        }
        produtos.add(produto);
        return true;
    }

    public Produto removeProduto(String idProduto) {
        if (idProduto == null) {
            return null;
        }
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getIdProduto() != null && produtos.get(i).getIdProduto().equals(idProduto)) {
                return produtos.remove(i);
            }
        }
        return null;
    }

    public Produto buscaProduto(String idProduto) {
        if (idProduto == null) {
            return null;
        }
        for (Produto p : produtos) {
            if (p.getIdProduto() != null && p.getIdProduto().equals(idProduto)) {
                return p;
            }
        }
        return null;
    }

    public boolean addVenda(Venda venda) {
        if (venda == null) {
            return false;
        }
        vendas.add(venda);
        return true;
    }

    public List<Venda> buscaVendaCliente(String cpfCliente) {
        List<Venda> res = new ArrayList<>();
        if (cpfCliente == null) {
            return res;
        }
        for (Venda v : vendas) {
            Cliente c = v.getCliente();
            if (c != null && cpfCliente.equals(c.getCpf())) {
                res.add(v);
            }
        }
        return res;
    }
}
