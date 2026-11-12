package modelo;

import modalidade.ModalidadeEntrega;

import java.util.Objects;

public class Pedido {

    private final int id;
    private final Cliente cliente;
    private final Endereco origem;
    private final Endereco destino;
    private final double pesoKg;
    private final double distanciaKm;
    private ModalidadeEntrega modalidade;
    private StatusPedido status;

    public Pedido(int id, Cliente cliente, Endereco origem, Endereco destino,
                  double pesoKg, double distanciaKm) {
        if (pesoKg <= 0 || distanciaKm <= 0) {
            throw new IllegalArgumentException("Peso e distância devem ser positivos.");
        }
        this.id = id;
        this.cliente = Objects.requireNonNull(cliente);
        this.origem = Objects.requireNonNull(origem);
        this.destino = Objects.requireNonNull(destino);
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
        this.status = StatusPedido.REGISTRADO;
    }

    public Cotacao calcularCotacao() {
        if (modalidade == null) {
            throw new IllegalStateException("Nenhuma modalidade de entrega selecionada.");
        }
        return modalidade.calcular(this);
    }

    public void definirModalidade(ModalidadeEntrega novaModalidade) {
        if (status == StatusPedido.DESPACHADO) {
            throw new IllegalStateException("Pedido já despachado: modalidade não pode ser alterada.");
        }
        this.modalidade = Objects.requireNonNull(novaModalidade);
    }

    public void despachar() {
        if (modalidade == null) {
            throw new IllegalStateException("Selecione uma modalidade antes de despachar.");
        }
        this.status = StatusPedido.DESPACHADO;
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Endereco getOrigem() { return origem; }
    public Endereco getDestino() { return destino; }
    public double getPesoKg() { return pesoKg; }
    public double getDistanciaKm() { return distanciaKm; }
    public ModalidadeEntrega getModalidade() { return modalidade; }
    public StatusPedido getStatus() { return status; }
}
