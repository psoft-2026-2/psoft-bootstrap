public final class Convencional implements ModalidadeEntrega {
    private final double tarifaFixa;
    private final double valorPorQuilometro;
    private final int prazoDias;

    public Convencional(double tarifaFixa, double valorPorQuilometro, int prazoDias) {
        if (tarifaFixa < 0 || valorPorQuilometro < 0 || prazoDias < 0
                || !Double.isFinite(tarifaFixa) || !Double.isFinite(valorPorQuilometro)) {
            throw new IllegalArgumentException("Tarifas e prazo devem ser não negativos e finitos");
        }
        this.tarifaFixa = tarifaFixa;
        this.valorPorQuilometro = valorPorQuilometro;
        this.prazoDias = prazoDias;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + valorPorQuilometro * pedido.getDistanciaEstimada();
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazoDias;
    }
}
