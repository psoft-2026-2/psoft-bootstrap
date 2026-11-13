public class Pedido {
    private int id;
    private String cliente;
    private String enderecoOrigem;
    private String enderecoDestino;
    private double peso;
    private double distancia;
    private EntregaStrategy modalidadeEntrega;
    private boolean despachado;

    public Pedido(int id, String cliente, String origem, String destino, double peso, double distancia) {
        if (id <= 0) throw new IllegalArgumentException("Id deve ser positivo");
        if (cliente == null || cliente.isBlank()) throw new IllegalArgumentException("Cliente nao pode ser nulo ou em branco");
        if (origem == null || origem.isBlank()) throw new IllegalArgumentException("Origem nao pode ser nula ou em branco");
        if (destino == null || destino.isBlank()) throw new IllegalArgumentException("Destino nao pode ser nulo ou em branco");
        if (!Double.isFinite(peso) || peso <= 0) throw new IllegalArgumentException("Peso deve ser positivo e finito");
        if (!Double.isFinite(distancia) || distancia < 0) throw new IllegalArgumentException("Distancia deve ser nao negativa e finita");
        
        this.id = id;
        this.cliente = cliente;
        this.enderecoOrigem = origem;
        this.enderecoDestino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.despachado = false;
    }

    public double calcularCusto() {
        if (modalidadeEntrega == null) {
            throw new IllegalStateException("Pedido sem modalidade de entrega");
        }
        return modalidadeEntrega.calcularCusto(this);
    }

    public int calcularPrazo() {
        if (modalidadeEntrega == null) {
            throw new IllegalStateException("Pedido sem modalidade de entrega");
        }
        return modalidadeEntrega.calcularPrazo(this);
    }

    public void setModalidadeEntrega(EntregaStrategy modalidade) {
        if (modalidade == null) {
            throw new IllegalArgumentException("Modalidade nao pode ser nula");
        }
        if (despachado) {
            throw new IllegalStateException("Pedido ja despachado, nao pode alterar a modalidade");
        }
        this.modalidadeEntrega = modalidade;
    }

    public void despachar() {
        if (modalidadeEntrega == null) {
            throw new IllegalStateException("Pedido sem modalidade de entrega");
        }
        this.despachado = true;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public EntregaStrategy getModalidadeEntrega() {
        return modalidadeEntrega;
    }

    public boolean isDespachado() {
        return despachado;
    }

    @Override
    public String toString() {
        String modalidade = modalidadeEntrega == null ? "nenhuma" : modalidadeEntrega.getNome();
        return "Pedido " + id + " - " + cliente + " (" + enderecoOrigem + " -> " + enderecoDestino + ")"
                + " | modalidade: " + modalidade
                + " | despachado: " + despachado;
    }
}
