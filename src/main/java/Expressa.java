import java.util.Objects;

public class Expressa implements Entrega {
    private double custoBase;
    private double adicionalPrioridade;
    private int prazoEmDias;

    public Expressa() {
        this(Double.NaN, Double.NaN, -1);
    }

    public Expressa(double custoBase, double adicionalPrioridade, int prazoEmDias) {
        if (Double.isFinite(custoBase) && custoBase < 0
                || Double.isFinite(adicionalPrioridade) && adicionalPrioridade < 0
                || prazoEmDias < -1) {
            throw new IllegalArgumentException("Valores da entrega invalidos");
        }
        this.custoBase = custoBase;
        this.adicionalPrioridade = adicionalPrioridade;
        this.prazoEmDias = prazoEmDias;
    }

    @Override
    public double calcularCusto() {
        validarValoresConfigurados();
        return custoBase + adicionalPrioridade;
    }

    @Override
    public int prazoEstimado() {
        validarValoresConfigurados();
        return prazoEmDias;
    }

    private void validarValoresConfigurados() {
        if (!Double.isFinite(custoBase) || !Double.isFinite(adicionalPrioridade) || prazoEmDias < 0) {
            throw new IllegalStateException("Informe custo base, adicional de prioridade e prazo");
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Expressa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

    @Override
    public String toString() {
        return "Expressa";
    }
}
