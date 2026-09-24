import java.util.ArrayList;
import java.util.List;

public class Mercado {
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private List<Venda> vendas;

    public Mercado() {
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
        vendas = new ArrayList<>();
    }

    public void addProduto(int idProduto, String descricao, float valor) {
        produtos.add(new Produto(idProduto, descricao, valor));
    }

    public Produto getProduto(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                return produto;
            }
        }
        return null;
    }

    public void addCliente(int idCliente, String perfil) {
        clientes.add(new Cliente(idCliente, perfil));
    }

    public Cliente getCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public void attPerfil(int idCliente, String novoPerfil) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                cliente.setPerfil(novoPerfil);
            }
        }
    }

    public void addVenda(int idVenda, int idCliente) {
        vendas.add(new Venda(idVenda, getCliente(idCliente)));
    }

    public void addPagamentoVenda(int idVenda, String tipoPagamento) {
        for (Venda venda : vendas) {
            if (venda.getIdVenda() == idVenda) {
                venda.addPagamento(tipoPagamento);
            }
        }
    }

    public void addProdutoVenda(int idVenda, int idProduto, int quantidade) {
        for (Venda venda : vendas) {
            if (venda.getIdVenda() == idVenda) {
                venda.addItem(getProduto(idProduto), quantidade);
            }
        }
    }

    public float totalVenda(int idVenda) {
        for (Venda venda : vendas) {
            if (venda.getIdVenda() == idVenda) {
                return venda.total();
            }
        }
        return 0.0f;
    }

    public boolean fecharVenda(int idVenda) {
        for (Venda venda : vendas) {
            if (venda.getIdVenda() == idVenda) {
                return venda.fecharPagamento();
            }
        }
        return false;
    }

    public List<Venda> vendasAbertas() {
        List<Venda> vendasAbertas = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getPagamento() == null || !venda.getPagamento().isClosed()) {
                vendasAbertas.add(venda);
            }
        }
        return vendasAbertas;
    }

    public List<Venda> vendasFechadas() {
        List<Venda> vendasFechadas = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getPagamento() != null && venda.getPagamento().isClosed()) {
                vendasFechadas.add(venda);
            }
        }
        return vendasFechadas;
    }
}
