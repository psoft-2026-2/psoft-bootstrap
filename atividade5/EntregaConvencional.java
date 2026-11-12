public class EntregaConvencional implements Frete {
    private double tarifaFixa;
    private double valorPorKm;
    private int prazoBaseDias;
    private int kmPorDia;

    public EntregaConvencional(double tarifaFixa, double valorPorKm,
                               int prazoBaseDias, int kmPorDia) {
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.prazoBaseDias = prazoBaseDias;
        this.kmPorDia = kmPorDia;
    }

    @Override
    public double calcular(Pedido pedido) {
        return tarifaFixa + valorPorKm * pedido.getDistancia();
    }

    @Override
    public String calcularPrazo(Pedido pedido) {
        int dias = prazoBaseDias + pedido.getDistancia() / kmPorDia;
        return dias + " dias úteis";
    }

}
