public class EntregaExpressa implements Frete {
    private double valorPorKm;
    private double Prioridade;
    private int prazoBaseDias;
    private int kmPorDia;

    public EntregaExpressa(double valorPorKm, double custoPrioridade,
                           int prazoBaseDias, int kmPorDia) {
        this.valorPorKm = valorPorKm;
        this.Prioridade = custoPrioridade;
        this.prazoBaseDias = prazoBaseDias;
        this.kmPorDia = kmPorDia;
    }

    @Override
    public double calcular(Pedido pedido) {
        return valorPorKm * pedido.getDistancia() + Prioridade;
    }

    @Override
    public String calcularPrazo(Pedido pedido) {
        int dias = prazoBaseDias + pedido.getDistancia() / kmPorDia;
        return dias + " dias úteis";
    }
}
