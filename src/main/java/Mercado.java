import java.util.HashMap;
import java.util.Map;

public class Mercado {
    private Map<Integer, Venda> historico;
    private Map<String, Cliente> clientes;
    private int proxId;

    public Mercado() {
        this.historico = new HashMap<>();
        this.clientes = new HashMap<>();
        this.proxId = 0;
    }

    public void cadastrarCliente(String cpf, Perfil perfil) {
        if (buscarCliente(cpf) == null) {
            clientes.put(cpf, new Cliente(cpf, perfil));
        }
    }

    public Cliente buscarCliente(String cpf) {
        return clientes.get(cpf);
    }

    public int criarVenda(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não cadastrado");
        }
        Venda venda = new Venda(cliente);
        proxId++;
        historico.put(proxId, venda);
        return proxId;
    }

    public void adicionarItem(int idVenda, Produto produto, int quantidade) {
        Venda venda = historico.get(idVenda);
        if (venda != null) {
            venda.addItem(produto, quantidade);
        }
    }

    public String processarPagamento(int idVenda, String tipo) {
        Venda venda = historico.get(idVenda);
        if (venda == null) {
            return "Venda não encontrada";
        }
        return venda.realizarPagamento(tipo);
    }
}