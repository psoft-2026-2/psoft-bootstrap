import java.util.Objects;

public final class Expressa implements ModalidadeEntrega {
    private final ModalidadeEntrega referencia;
    private final double custoAdicional;
    private final int prazoDias;

    public Expressa(ModalidadeEntrega referencia, double custoAdicional, int prazoDias) {
        this.referencia = Objects.requireNonNull(referencia);
        if (custoAdicional < 0 || !Double.isFinite(custoAdicional) || prazoDias < 0) {
            throw new IllegalArgumentException("Adicional e prazo devem ser não negativos e finitos");
        }
        this.custoAdicional = custoAdicional;
        this.prazoDias = prazoDias;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return referencia.calcularCusto(pedido) + custoAdicional;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazoDias;
    }
}
