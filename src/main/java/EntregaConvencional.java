import java.util.Objects;

public class EntregaConvencional implements EstrategiaEntrega {
    private final double taxaFixa;
    private final double valorPorKm;

    public EntregaConvencional() {
        this(10.0, 1.5);
    }

    public EntregaConvencional(double taxaFixa, double valorPorKm) {
        this.taxaFixa = validarNaoNegativo(taxaFixa, "A taxa fixa");
        this.valorPorKm = validarNaoNegativo(valorPorKm, "O valor por quilômetro");
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return taxaFixa + valorPorKm * distanciaDe(pedido);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        double distancia = distanciaDe(pedido);
        if (distancia <= 10.0) return 24;
        if (distancia <= 100.0) return 72;
        return 168;
    }

    public double getTaxaFixa() {
        return taxaFixa;
    }

    public double getValorPorKm() {
        return valorPorKm;
    }

    private static double distanciaDe(Pedido pedido) {
        return Objects.requireNonNull(pedido, "O pedido é obrigatório").getDistanciaKm();
    }

    private static double validarNaoNegativo(double valor, String nome) {
        if (!Double.isFinite(valor) || valor < 0.0) {
            throw new IllegalArgumentException(nome + " deve ser um número não negativo.");
        }
        return valor;
    }
}
