package br.ufcg.psoft.atv5;

public class Pedido {
    private final Cliente cliente;
    private final Endereco origem;
    private final Endereco destino;
    private final double peso;
    private final double distancia;
    private boolean despachado;
    private ModalidadeEntrega modalidade;

    public Pedido(Cliente cliente, Endereco origem, Endereco destino,
                  double peso, double distancia, ModalidadeEntrega modalidade) {
        if (cliente == null || origem == null || destino == null) {
            throw new IllegalArgumentException("Cliente, origem e destino são obrigatórios.");
        }
        if (peso <= 0 || distancia <= 0) {
            throw new IllegalArgumentException("Peso e distância devem ser maiores que zero.");
        }
        if (modalidade == null) {
            throw new IllegalArgumentException("Modalidade de entrega é obrigatória.");
        }
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.modalidade = modalidade;
        this.despachado = false;
    }

    public double calcularCusto() {
        return modalidade.calcularCusto(this);
    }

    public double calcularPrazo() {
        return modalidade.calcularPrazo(this);
    }

    /** Só é possível alterar a modalidade antes de o pedido ser despachado. */
    public void alterarModalidade(ModalidadeEntrega novaModalidade) {
        if (despachado) {
            throw new IllegalStateException(
                    "Não é possível alterar a modalidade de um pedido já despachado.");
        }
        if (novaModalidade == null) {
            throw new IllegalArgumentException("Modalidade de entrega é obrigatória.");
        }
        this.modalidade = novaModalidade;
    }

    public void despachar() {
        if (despachado) {
            throw new IllegalStateException("Pedido já foi despachado.");
        }
        this.despachado = true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getOrigem() {
        return origem;
    }

    public Endereco getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public boolean isDespachado() {
        return despachado;
    }

    public ModalidadeEntrega getModalidade() {
        return modalidade;
    }
}
