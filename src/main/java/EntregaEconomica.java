import java.util.Objects;

public class EntregaEconomica implements EstrategiaEntrega {
    private final double taxaBase;
    private final double desconto;

    public EntregaEconomica() {
        this(1.0, 0.20);
    }

    public EntregaEconomica(double taxaBase, double desconto) {
        this.taxaBase = validarNaoNegativo(taxaBase, "A taxa base");
        if (!Double.isFinite(desconto) || desconto < 0.0 || desconto > 1.0) {
            throw new IllegalArgumentException("O desconto deve estar entre 0 e 1.");
        }
        this.desconto = desconto;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return taxaBase * distanciaDe(pedido) * (1.0 - desconto);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        double distancia = distanciaDe(pedido);
        if (distancia <= 10.0) return 12 * 24;
        if (distancia <= 100.0) return 20 * 24;
        return 30 * 24;
    }

    public double getTaxaBase() {
        return taxaBase;
    }

    public double getDesconto() {
        return desconto;
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
