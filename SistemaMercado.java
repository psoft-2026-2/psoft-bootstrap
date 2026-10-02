import java.util.ArrayList;

public class SistemaMercado {
  private ArrayList<Cliente> clientes;
  private ArrayList<Produto> produtos;
  private ArrayList<Venda> vendas;

  public SistemaMercado() {
    this.clientes = new ArrayList<Cliente>();
    this.produtos = new ArrayList<Produto>();
    this.vendas = new ArrayList<Venda>();
  }

  public void cadastrarCliente(Cliente cliente) {
    this.clientes.add(cliente);
  }

  public void cadastrarProduto(Produto produto) {
    this.produtos.add(produto);
  }

  public Venda iniciarVenda(Cliente cliente) {
    Venda venda = new Venda(cliente);
    this.vendas.add(venda);
    return venda;
  }

  public void listarClientes() {
    for (Cliente c : this.clientes) {
      System.out.println(c);
    }
  }

  public void listarProdutos() {
    for (Produto p : this.produtos) {
      System.out.println(p);
    }
  }

  public void listarVendas() {
    for (Venda v : this.vendas) {
      System.out.println(v);
    }
  }
}