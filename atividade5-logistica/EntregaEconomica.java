public class EntregaEconomica implements Frete {
    private double valorPorKm;
    private int prazoBaseDias;
    private int kmPorDia;

    public EntregaEconomica(double valorPorKm, int prazoBaseDias, int kmPorDia) {
        this.valorPorKm = valorPorKm;
        this.prazoBaseDias = prazoBaseDias;
        this.kmPorDia = kmPorDia;
    }

    @Override
    public double calcular(Pedido pedido) {
        return valorPorKm * pedido.getDistancia();
    }

    @Override
    public String calcularPrazo(Pedido pedido) {
        int dias = prazoBaseDias + pedido.getDistancia() / kmPorDia;
        return dias + " dias úteis";
    }

}
