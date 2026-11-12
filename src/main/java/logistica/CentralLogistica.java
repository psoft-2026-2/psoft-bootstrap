package logistica;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

//Singleton
public class CentralLogistica {

    private static CentralLogistica instancia;

    private Map<Long, Pedido> pedidos = new LinkedHashMap<>();
    private Map<String, Cliente> clientes = new LinkedHashMap<>();
    private List<Operacao> operacoes = new ArrayList<>();
    private long proximoId = 1;

    private CentralLogistica() {
    }

    public static CentralLogistica getInstance() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public Cliente registrarCliente(String nome, String cpf, Endereco endereco) {
        Cliente cliente = new Cliente(nome, cpf, endereco);
        if (clientes.containsKey(cliente.getCpf())) {
            throw new IllegalArgumentException(
                    "Já existe um cliente com o CPF " + cliente.getCpf());
        }
        clientes.put(cliente.getCpf(), cliente);
        registrarOperacao("Cliente cadastrado: " + cliente);
        return cliente;
    }

    public Pedido registrarPedido(Cliente cliente, Endereco enderecoOrigem, Endereco enderecoDestino,
            double pesoKg, double distanciaKm, Entrega modalidade) {
        Pedido pedido = new Pedido(cliente, enderecoOrigem, enderecoDestino,
                pesoKg, distanciaKm, modalidade);
        pedido.setId(proximoId++);
        pedidos.put(pedido.getId(), pedido);
        registrarOperacao("Pedido #" + pedido.getId() + " registrado para " + cliente.getNome()
                + " com a modalidade " + modalidade.getNome());
        return pedido;
    }

    public void selecionarModalidade(long pedidoId, Entrega modalidade) {
        Pedido pedido = exigirPedido(pedidoId);
        pedido.alterarModalidade(modalidade);
        registrarOperacao("Pedido #" + pedidoId + " agora usa a modalidade "
                + modalidade.getNome());
    }

    public void despacharPedido(long pedidoId) {
        Pedido pedido = exigirPedido(pedidoId);
        pedido.despachar();
        registrarOperacao("Pedido #" + pedidoId + " despachado por R$ "
                + String.format(Locale.ROOT, "%.2f", pedido.getCusto())
                + " com prazo de " + pedido.getPrazoEmDias() + " dia(s)");
    }

    public Optional<Pedido> buscarPedido(long pedidoId) {
        return Optional.ofNullable(pedidos.get(pedidoId));
    }

    public Optional<Cliente> buscarCliente(String cpf) {
        return Optional.ofNullable(clientes.get(cpf));
    }

    public List<Pedido> listarPedidos() {
        return List.copyOf(pedidos.values());
    }

    public List<Cliente> listarClientes() {
        return List.copyOf(clientes.values());
    }

    public List<Pedido> listarPedidosPorStatus(String status) {
        return pedidos.values().stream()
                .filter(pedido -> pedido.getStatus().equals(status))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Operacao> listarOperacoes() {
        return List.copyOf(operacoes);
    }

    private Pedido exigirPedido(long pedidoId) {
        Pedido pedido = pedidos.get(pedidoId);
        if (pedido == null) {
            throw new NoSuchElementException("Pedido #" + pedidoId + " não encontrado");
        }
        return pedido;
    }

    private void registrarOperacao(String descricao) {
        operacoes.add(new Operacao(descricao));
    }
}
