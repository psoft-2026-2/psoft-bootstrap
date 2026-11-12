package java;
public class Pedido {
    private final String id;
    private final String nomeCliente;
    private final String enderecoOrigem;
    private final String enderecoDestino;
    private final double peso;
    private final double distancia;
    private final EntregaModalidade entrega;

    public Pedido(String id, String nomeCliente, String enderecoOrigem, String enderecoDestino,
                  double peso, double distancia, Modalidade modalidade) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O id do pedido e obrigatorio.");
        }
        if (peso < 0 || distancia < 0) {
            throw new IllegalArgumentException("Peso e distancia nao podem ser negativos.");
        }
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.peso = peso;
        this.distancia = distancia;
        this.entrega = new EntregaModalidade(modalidade);
    }

    public String getId() {
        return id;
    }

    public double getDistancia() {
        return distancia;
    }

    public void alterarModalidade(Modalidade modalidade) {
        entrega.setModalidade(modalidade);
    }

    public double calcularCusto() {
        return entrega.calcularCusto(this);
    }

    public int calcularPrazo() {
        return entrega.calcularPrazo(this);
    }
}
