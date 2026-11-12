package modelo;

import entrega.Entrega;

public class Pedido {
    private String origem;
    private String destino;
    private double peso;
    private double distancia;
    private Cliente cliente;
    private Entrega entrega;
    private boolean despachado;

    public Pedido(String origem, String destino, double peso, double distancia,
                  Cliente cliente, Entrega entrega) {
        if (cliente == null || entrega == null) {
            throw new IllegalArgumentException("Cliente e modalidade de entrega são obrigatórios.");
        }
        if (peso < 0 || distancia < 0) {
            throw new IllegalArgumentException("Peso e distância não podem ser negativos.");
        }
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.cliente = cliente;
        this.entrega = entrega;
        this.despachado = false;
    }

    public double calculaCusto() {
        return entrega.calculaCusto(this);
    }

    public int calculaPrazo() {
        return entrega.calculaPrazo(this);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setEntrega(Entrega entrega) {
        if (despachado) {
            throw new IllegalStateException(
                    "Pedido já foi despachado, a modalidade não pode ser alterada.");
        }
        if (entrega == null) {
            throw new IllegalArgumentException("Modalidade de entrega não pode ser nula.");
        }
        this.entrega = entrega;
    }

    public void despachar() {
        if (despachado) {
            throw new IllegalStateException("Pedido já foi despachado.");
        }
        this.despachado = true;
    }

    public boolean isDespachado() {
        return despachado;
    }

    @Override
    public String toString() {
        return "Pedido [origem=" + origem + ", destino=" + destino + ", peso=" + peso + ", distancia=" + distancia
                + ", cliente=" + cliente + ", entrega=" + entrega + ", despachado=" + despachado + "]";
    }

    
}