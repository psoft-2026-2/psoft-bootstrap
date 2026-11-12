package java;

public class Expressa implements Modalidade {
    private final double tarifaFixa;
    private final double valorPorQuilometro;
    private final double adicionalExpressa;
    private final int prazo;

    public Expressa(double tarifaFixa, double valorPorQuilometro, double adicionalExpressa, int prazo) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorQuilometro = valorPorQuilometro;
        this.adicionalExpressa = adicionalExpressa;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + pedido.getDistancia() * valorPorQuilometro + adicionalExpressa;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazo;
    }
}
