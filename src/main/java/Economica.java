import java.util.Objects;

public final class Economica implements ModalidadeEntrega {
    private final ModalidadeEntrega referencia;
    private final double desconto;
    private final int diasAdicionais;

    public Economica(ModalidadeEntrega referencia, double desconto, int diasAdicionais) {
        this.referencia = Objects.requireNonNull(referencia);
        if (desconto < 0 || desconto > 1 || !Double.isFinite(desconto) || diasAdicionais < 0) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e 1; dias adicionais não podem ser negativos");
        }
        this.desconto = desconto;
        this.diasAdicionais = diasAdicionais;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return referencia.calcularCusto(pedido) * (1 - desconto);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return Math.addExact(referencia.calcularPrazo(pedido), diasAdicionais);
    }
}
