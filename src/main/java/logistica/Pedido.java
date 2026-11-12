package logistica;

import java.util.Locale;

public class Pedido {

    private long id;
    private Cliente cliente;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private double pesoKg;
    private double distanciaKm;
    private Entrega modalidade;
    private String status;
    private Double custoFinal;
    private Integer prazoFinal;

    public Pedido(Cliente cliente, Endereco enderecoOrigem, Endereco enderecoDestino,
            double pesoKg, double distanciaKm, Entrega modalidade) {
        this.cliente = cliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
        this.modalidade = modalidade;
        this.status = "REGISTRADO";
    }

    void setId(long id) {
        this.id = id;
    }

    public void alterarModalidade(Entrega novaModalidade) {
        if ("DESPACHADO".equals(status)) {
            throw new IllegalStateException(
                    "O pedido #" + id + " já foi despachado; a modalidade não pode mais ser alterada");
        }
        this.modalidade = novaModalidade;
    }

    public void despachar() {
        this.custoFinal = modalidade.calcularCusto(pesoKg, distanciaKm);
        this.prazoFinal = modalidade.calcularPrazoEmDias(distanciaKm);
        this.status = "DESPACHADO";
    }

    public double getCusto() {
        return custoFinal != null ? custoFinal : modalidade.calcularCusto(pesoKg, distanciaKm);
    }

    public int getPrazoEmDias() {
        return prazoFinal != null ? prazoFinal : modalidade.calcularPrazoEmDias(distanciaKm);
    }

    public long getId() {
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

    public double getPesoKg() {
        return pesoKg;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public Entrega getModalidade() {
        return modalidade;
    }

    public String getStatus() {
        return status;
    }

    public boolean isDespachado() {
        return "DESPACHADO".equals(status);
    }

    @Override
    public String toString() {
        return "Pedido #" + id
                + " [" + status + "]"
                + " | cliente: " + cliente.getNome()
                + " | modalidade: " + modalidade.getNome()
                + " | " + String.format(Locale.ROOT, "%.1f kg", pesoKg)
                + " | " + String.format(Locale.ROOT, "%.1f km", distanciaKm)
                + " | custo: R$ " + String.format(Locale.ROOT, "%.2f", getCusto())
                + " | prazo: " + getPrazoEmDias() + " dia(s)";
    }
}
