package java;

public class Convencional implements Modalidade {
    private final double tarifaFixa;
    private final double valorPorQuilometro;
    private final int prazoBase;

    public Convencional(double tarifaFixa, double valorPorQuilometro, int prazoBase) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorQuilometro = valorPorQuilometro;
        this.prazoBase = prazoBase;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + pedido.getDistancia() * valorPorQuilometro;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazoBase;
    }
}
