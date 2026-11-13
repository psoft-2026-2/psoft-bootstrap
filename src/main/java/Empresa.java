import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private CentralLogistica central;
    private List<Cliente> clientes;

    public Empresa() {
        this.central = CentralLogistica.getInstance();
        this.clientes = new ArrayList<>();
    }

    public void criarCliente(String nome, String cpf) {
        Cliente novoCliente = new Cliente(nome, cpf);
        clientes.add(novoCliente);
    }

    public void criaPedido(String nomeItem, String cpf, String saida, String destino) {
        central.cadastrarPedido(cpf, nomeItem, saida, destino);
    }

    public void despacharPedido(int idPedido) {
        central.despacharPedido(idPedido);
    }
}
