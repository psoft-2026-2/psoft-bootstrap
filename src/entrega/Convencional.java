package entrega;

import modelo.Pedido;

public class Convencional implements Entrega {
    private final double tarifa = 10.0; 
    private double km;                 

    public Convencional(double km) {
        this.km = km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getKm() {
        return km;
    }

    @Override
    public double calculaCusto(Pedido pedido) {
        return tarifa + (km * pedido.getDistancia());
    }

    @Override
    public int calculaPrazo(Pedido pedido) {
        final double kmPorDia = 50.0;
        return (int) Math.ceil(pedido.getDistancia() / kmPorDia);
    }
}