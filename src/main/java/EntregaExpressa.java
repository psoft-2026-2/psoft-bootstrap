import java.util.Objects;

public class EntregaExpressa implements EstrategiaEntrega {
    private final double taxaBase;
    private final double taxaPrioridade;

    public EntregaExpressa() {
        this(2.5, 15.0);
    }

    public EntregaExpressa(double taxaBase, double taxaPrioridade) {
        this.taxaBase = validarNaoNegativo(taxaBase, "A taxa base");
        this.taxaPrioridade = validarNaoNegativo(taxaPrioridade, "A taxa de prioridade");
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return taxaBase * distanciaDe(pedido) + taxaPrioridade;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        double distancia = distanciaDe(pedido);
        if (distancia <= 10.0) return 12;
        if (distancia <= 100.0) return 24;
        return 48;
    }

    public double getTaxaBase() {
        return taxaBase;
    }

    public double getTaxaPrioridade() {
        return taxaPrioridade;
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
