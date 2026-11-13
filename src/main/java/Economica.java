import java.util.Objects;

public class Economica implements Entrega {
    private double tarifaBase;
    private double desconto;
    private int prazoEmDias;

    public Economica() {
        this(Double.NaN, Double.NaN, -1);
    }

    public Economica(double tarifaBase, double desconto, int prazoEmDias) {
        if (Double.isFinite(tarifaBase) && tarifaBase < 0
                || Double.isFinite(desconto) && desconto < 0
                || prazoEmDias < -1) {
            throw new IllegalArgumentException("Valores da entrega invalidos");
        }
        this.tarifaBase = tarifaBase;
        this.desconto = desconto;
        this.prazoEmDias = prazoEmDias;
    }

    @Override
    public double calcularCusto() {
        validarValoresConfigurados();
        validarValoresConfigurados();
        return tarifaBase - desconto;
    }

    @Override
    public int prazoEstimado() {
        validarValoresConfigurados();
        return prazoEmDias;
    }

    private void validarValoresConfigurados() {
        if (!Double.isFinite(tarifaBase) || !Double.isFinite(desconto) || prazoEmDias < 0
                || desconto > tarifaBase) {
            throw new IllegalStateException("Informe tarifa base, desconto valido e prazo");
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Economica;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

    @Override
    public String toString() {
        return "Economica";
    }
}
