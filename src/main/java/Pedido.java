public class Pedido {

    private int id;
    private Cliente cliente;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private double peso;
    private double distancia;
    private ModalidadeEntrega modalidade;
    private boolean despachado;

    public Pedido(int id, Cliente cliente, Endereco enderecoOrigem, Endereco enderecoDestino,
                  double peso, double distancia, ModalidadeEntrega modalidade) {
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }
        if (distancia <= 0) {
            throw new IllegalArgumentException("A distancia deve ser maior que zero.");
        }
        if (modalidade == null) {
            throw new IllegalArgumentException("A modalidade de entrega e obrigatoria.");
        }
        this.id = id;
        this.cliente = cliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.peso = peso;
        this.distancia = distancia;
        this.modalidade = modalidade;
        this.despachado = false;
    }

    public double calcularCusto() {
        return modalidade.calcularCusto(this);
    }

    public int calcularPrazo() {
        return modalidade.calcularPrazo(this);
    }

    public void alterarModalidade(ModalidadeEntrega novaModalidade) {
        if (despachado) {
            throw new IllegalStateException("Nao e possivel alterar a modalidade de um pedido ja despachado.");
        }
        if (novaModalidade == null) {
            throw new IllegalArgumentException("A modalidade de entrega e obrigatoria.");
        }
        this.modalidade = novaModalidade;
    }

    public void despachar() {
        if (despachado) {
            throw new IllegalStateException("O pedido ja foi despachado.");
        }
        this.despachado = true;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public Endereco getEnderecoDestino() {
        return enderecoDestino;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public ModalidadeEntrega getModalidade() {
        return modalidade;
    }

    public boolean isDespachado() {
        return despachado;
    }

    @Override
    public String toString() {
        String status = despachado ? "Despachado" : "Aguardando despacho";
        return "Pedido #" + id
                + " | Cliente: " + cliente.getNome()
                + " | Origem: " + enderecoOrigem
                + " | Destino: " + enderecoDestino
                + " | Peso: " + peso + " kg"
                + " | Distancia: " + distancia + " km"
                + " | Modalidade: " + modalidade.getNome()
                + " | Custo: R$ " + String.format("%.2f", calcularCusto())
                + " | Prazo: " + calcularPrazo() + " dia(s)"
                + " | Status: " + status;
    }
}
