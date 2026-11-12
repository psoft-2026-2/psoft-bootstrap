import java.time.LocalDate;

public class Produto {
    private String id;
    private String cpfCliente;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private double peso;
    private double distanciaEstimada;
    private EstrategiaEntrega estrategiaEntrega;
    private boolean despachado;

    public Produto(
        String id, String cpfCliente, Endereco enderecoOrigem, Endereco enderecoDestino, double peso, double distanciaEstimada, EstrategiaEntrega estrategiaEntrega) {
        this.id = id;
        this.cpfCliente = cpfCliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.peso = peso;
        this.distanciaEstimada = distanciaEstimada;
        this.estrategiaEntrega = estrategiaEntrega;
        this.despachado = false;
    }

    public double calculaCustoEntrega() {
        validarEstrategia();
        return estrategiaEntrega.CalculaCusto(distanciaEstimada);
    }

    public LocalDate calculaPrazoEntrega(LocalDate dataDoPedido) {
        validarEstrategia();
        return estrategiaEntrega.CalculaPrazo(distanciaEstimada, dataDoPedido);
    }

    public String getId() {
        return id;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        validarNaoDespachado();
        this.cpfCliente = cpfCliente;
    }

    public Endereco getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(Endereco enderecoOrigem) {
        validarNaoDespachado();
        this.enderecoOrigem = enderecoOrigem;
    }

    public Endereco getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(Endereco enderecoDestino) {
        validarNaoDespachado();
        this.enderecoDestino = enderecoDestino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        validarNaoDespachado();
        this.peso = peso;
    }

    public double getDistanciaEstimada() {
        return distanciaEstimada;
    }

    public void setDistanciaEstimada(double distanciaEstimada) {
        validarNaoDespachado();
        this.distanciaEstimada = distanciaEstimada;
    }

    public EstrategiaEntrega getEstrategiaEntrega() {
        return estrategiaEntrega;
    }

    public void setEstrategiaEntrega(EstrategiaEntrega estrategiaEntrega) {
        validarNaoDespachado();
        this.estrategiaEntrega = estrategiaEntrega;
    }

    public boolean isDespachado() {
        return despachado;
    }

    public void despachar() {
        validarNaoDespachado();
        this.despachado = true;
    }

    private void validarNaoDespachado() {
        if (despachado) {
            throw new IllegalStateException("Produto já despachado não pode ser editado.");
        }
    }

    private void validarEstrategia() {
    if (estrategiaEntrega == null) {
       throw new IllegalStateException("A estratégia de entrega não foi definida.");}
    }
}