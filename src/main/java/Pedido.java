public class Pedido {
    private Cliente cliente;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private Double peso;
    private Double distancia;
    private EstrategiaEntrega estrategia;
    private boolean despachado;

    public Pedido(Cliente cliente, Endereco enderecoOrigem, Endereco enderecoDestino,
            Double peso, Double distancia) {
        setCliente(cliente);
        setEnderecoOrigem(enderecoOrigem);
        setEnderecoDestino(enderecoDestino);
        setPeso(peso);
        setDistancia(distancia);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente do pedido nao pode ser nulo");
        }
        this.cliente = cliente;
    }

    public Endereco getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(Endereco enderecoOrigem) {
        if (enderecoOrigem == null) {
            throw new IllegalArgumentException("Endereco de origem nao pode ser nulo");
        }
        this.enderecoOrigem = enderecoOrigem;
    }

    public Endereco getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(Endereco enderecoDestino) {
        if (enderecoDestino == null) {
            throw new IllegalArgumentException("Endereco de destino nao pode ser nulo");
        }
        this.enderecoDestino = enderecoDestino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        if (peso == null || !Double.isFinite(peso) || peso <= 0) {
            throw new IllegalArgumentException("Peso do pedido deve ser finito e maior que zero");
        }
        this.peso = peso;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        if (distancia == null || !Double.isFinite(distancia) || distancia <= 0) {
            throw new IllegalArgumentException("Distancia do pedido deve ser finita e maior que zero");
        }
        this.distancia = distancia;
    }

    public EstrategiaEntrega getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaEntrega estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("Estrategia de entrega nao pode ser nula");
        }
        if (despachado) {
            throw new IllegalStateException("Pedido ja despachado, estrategia nao pode ser alterada");
        }
        this.estrategia = estrategia;
    }

    public boolean isDespachado() {
        return despachado;
    }

    public void despachar() {
        if (estrategia == null) {
            throw new IllegalStateException("Pedido sem estrategia de entrega nao pode ser despachado");
        }
        despachado = true;
    }

    public String toString() {
        return "Pedido{cliente=" + cliente
                + ", enderecoOrigem=" + enderecoOrigem
                + ", enderecoDestino=" + enderecoDestino
                + ", peso=" + peso
                + ", distancia=" + distancia
                + ", estrategia=" + estrategia
                + ", despachado=" + despachado + "}";
    }
}
