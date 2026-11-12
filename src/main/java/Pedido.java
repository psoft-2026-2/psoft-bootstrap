import java.math.BigDecimal;
import java.math.RoundingMode;

// Contexto do Strategy: guarda a modalidade escolhida e delega a ela o cálculo.
public class Pedido {

    private final int id;
    private final Cliente cliente;
    private final Endereco enderecoOrigem;
    private final Endereco enderecoDestino;
    private final double peso;         // kg
    private final double distanciaKm;  // distância estimada
    private ModalidadeEntrega modalidade; // pode estar ainda não selecionada
    private StatusPedido status;

    public Pedido(int id, Cliente cliente, Endereco origem, Endereco destino, double peso, double distanciaKm) {
        if (cliente == null) throw new IllegalArgumentException("Cliente não pode ser nulo.");
        if (origem == null) throw new IllegalArgumentException("Endereço de origem não pode ser nulo.");
        if (destino == null) throw new IllegalArgumentException("Endereço de destino não pode ser nulo.");
        if (peso <= 0) throw new IllegalArgumentException("Peso deve ser maior que zero.");
        if (distanciaKm <= 0) throw new IllegalArgumentException("Distância estimada deve ser maior que zero.");
        this.id = id;
        this.cliente = cliente;
        this.enderecoOrigem = origem;
        this.enderecoDestino = destino;
        this.peso = peso;
        this.distanciaKm = distanciaKm;
        this.status = StatusPedido.REGISTRADO;
    }

    // Seleciona ou ALTERA a modalidade, enquanto o pedido ainda não foi despachado.
    public void selecionarModalidade(ModalidadeEntrega modalidade) {
        if (modalidade == null) {
            throw new IllegalArgumentException("Modalidade não pode ser nula.");
        }
        if (status == StatusPedido.DESPACHADO) {
            throw new IllegalStateException("Pedido " + id + " já foi despachado: a modalidade não pode mais ser alterada.");
        }
        this.modalidade = modalidade;
    }

    public BigDecimal calcularCusto() {
        return exigirModalidade().calcularCusto(this).setScale(2, RoundingMode.HALF_UP);
    }

    public int calcularPrazo() {
        return exigirModalidade().calcularPrazo(this);
    }

    public void despachar() {
        exigirModalidade(); // não se despacha sem modalidade definida
        if (status == StatusPedido.DESPACHADO) {
            throw new IllegalStateException("Pedido " + id + " já foi despachado.");
        }
        this.status = StatusPedido.DESPACHADO;
    }

    private ModalidadeEntrega exigirModalidade() {
        if (modalidade == null) {
            throw new IllegalStateException("Pedido " + id + " ainda não tem modalidade de entrega selecionada.");
        }
        return modalidade;
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Endereco getEnderecoOrigem() { return enderecoOrigem; }
    public Endereco getEnderecoDestino() { return enderecoDestino; }
    public double getPeso() { return peso; }
    public double getDistanciaKm() { return distanciaKm; }
    public ModalidadeEntrega getModalidade() { return modalidade; }
    public StatusPedido getStatus() { return status; }

    @Override
    public String toString() {
        String mod = (modalidade == null) ? "(não selecionada)" : modalidade.getNome();
        return "Pedido #" + id + " | " + cliente.getNome() + " | " + enderecoOrigem.getCidade() + " -> "
                + enderecoDestino.getCidade() + " | " + distanciaKm + " km | " + peso + " kg | modalidade: "
                + mod + " | " + status;
    }
}
