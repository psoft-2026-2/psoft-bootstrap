package entrega;

import modelo.Pedido;

public class Economica implements Entrega {

    public Economica() {
    }

    @Override
    public double calculaCusto(Pedido pedido) {
        final double valorPorKm = 1.0;
        return valorPorKm * pedido.getDistancia();
    }

    @Override
    public int calculaPrazo(Pedido pedido) {
        final double kmPorDia = 30.0; 
        return (int) Math.ceil(pedido.getDistancia() / kmPorDia);
    }
}