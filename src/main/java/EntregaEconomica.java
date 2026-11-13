public class EntregaEconomica implements EntregaStrategy {
    private double tarifaFixa;
    private double valorPorKm;
    private double desconto;
    private int prazo;

    // Configurar as tarifas e o desconto para que esta modalidade seja mais barata que a convencional!!
    public EntregaEconomica(double tarifaFixa, double valorPorKm, double desconto, int prazo) {
        if (!Double.isFinite(tarifaFixa) || tarifaFixa < 0) throw new IllegalArgumentException("Tarifa fixa deve ser nao negativa e finita");
        if (!Double.isFinite(valorPorKm) || valorPorKm < 0) throw new IllegalArgumentException("Valor por km deve ser nao negativo e finito");
        if (!Double.isFinite(desconto) || desconto < 0 || desconto > 1) throw new IllegalArgumentException("Desconto deve ser finito e estar entre 0 e 1");
        if (prazo <= 0) throw new IllegalArgumentException("Prazo deve ser positivo");
        
        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.desconto = desconto;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        double custoBase = tarifaFixa + valorPorKm * pedido.getDistancia();
        return custoBase - (custoBase * desconto);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazo;
    }

    @Override
    public String getNome() {
        return "Economica";
    }
}
