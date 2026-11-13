import java.util.Date;
import java.util.Objects;

public class Pedido {

    private String cpfCliente;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private String destinatario;
    private double peso;
    private double distanciaEstimada;
    private Entrega entrega;

    public Pedido(String cpfCliente, Endereco enderecoOrigem,
                  Endereco enderecoDestino, String destinatario,
                  double peso, double distanciaEstimada, Entrega entrega) {

        this.cpfCliente = Objects.requireNonNull(cpfCliente);
        this.enderecoOrigem = Objects.requireNonNull(enderecoOrigem);
        this.enderecoDestino = Objects.requireNonNull(enderecoDestino);
        this.destinatario = Objects.requireNonNull(destinatario);
        this.entrega = Objects.requireNonNull(entrega);

        if (peso <= 0 || distanciaEstimada <= 0) {
            throw new IllegalArgumentException(
                "Peso e distância devem ser positivos."
            );
        }

        this.peso = peso;
        this.distanciaEstimada = distanciaEstimada;
    }

    public double calcularCustoEntrega() {
        return entrega.calculaCusto();
    }

    public Date calcularPrazoEntrega() {
        return entrega.calculaPrazo();
    }

    public void alterarEntrega(Entrega novaEntrega) {
        this.entrega = Objects.requireNonNull(novaEntrega);
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public Endereco getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public Endereco getEnderecoDestino() {
        return enderecoDestino;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistanciaEstimada() {
        return distanciaEstimada;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = Objects.requireNonNull(cpfCliente);
    }

    public void setEnderecoOrigem(Endereco enderecoOrigem) {
        this.enderecoOrigem = Objects.requireNonNull(enderecoOrigem);
    }

    public void setEnderecoDestino(Endereco enderecoDestino) {
        this.enderecoDestino = Objects.requireNonNull(enderecoDestino);
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = Objects.requireNonNull(destinatario);
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser positivo.");
        }
        this.peso = peso;
    }

    public void setDistanciaEstimada(double distanciaEstimada) {
        if (distanciaEstimada <= 0) {
            throw new IllegalArgumentException(
                "A distância deve ser positiva."
            );
        }
        this.distanciaEstimada = distanciaEstimada;
    }
}

