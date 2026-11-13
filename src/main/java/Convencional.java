import java.util.Objects;

public class Convencional implements Entrega {
    private double kmPercorrido;
    private double tarifaFixa;
    private double valorPorQuilometro;
    private int prazoEmDias;

    public Convencional(double kmPercorrido) {
        this(kmPercorrido, Double.NaN, Double.NaN, -1);
    }

    public Convencional(double kmPercorrido, double tarifaFixa,
                        double valorPorQuilometro, int prazoEmDias) {
        if (!Double.isFinite(kmPercorrido) || kmPercorrido < 0) {
            throw new IllegalArgumentException("A distancia nao pode ser negativa");
        }
        if (Double.isFinite(tarifaFixa) && tarifaFixa < 0
                || Double.isFinite(valorPorQuilometro) && valorPorQuilometro < 0
                || prazoEmDias < -1) {
            throw new IllegalArgumentException("Valores da entrega invalidos");
        }
        this.kmPercorrido = kmPercorrido;
        this.tarifaFixa = tarifaFixa;
        this.valorPorQuilometro = valorPorQuilometro;
        this.prazoEmDias = prazoEmDias;
    }

    public double getKmPercorrido() {
        return kmPercorrido;
    }

    @Override
    public double calcularCusto() {
        validarValoresConfigurados();
        return tarifaFixa + kmPercorrido * valorPorQuilometro;
    }

    @Override
    public int prazoEstimado() {
        validarValoresConfigurados();
        return prazoEmDias;
    }

    private void validarValoresConfigurados() {
        if (!Double.isFinite(tarifaFixa) || !Double.isFinite(valorPorQuilometro) || prazoEmDias < 0) {
            throw new IllegalStateException("Informe tarifa, valor por quilometro e prazo");
        }
    }

    public void iniciarPercurso() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Convencional)) return false;
        Convencional other = (Convencional) obj;
        return Double.compare(kmPercorrido, other.kmPercorrido) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kmPercorrido);
    }

    @Override
    public String toString() {
        return "Convencional [kmPercorrido=" + kmPercorrido + "]";
    }
}
