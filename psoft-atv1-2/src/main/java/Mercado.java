import java.util.ArrayList;

public class Mercado {

    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<NotaFiscal> notasFiscais;

    public Mercado() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.notasFiscais = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void addNotaFiscal(NotaFiscal notaFiscal) {
        this.notasFiscais.add(notaFiscal);
    }

    public Cliente buscaCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Produto buscaProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}

