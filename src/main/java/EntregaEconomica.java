import java.math.BigDecimal;

// Preços reduzidos, mas prazo maior.
public class EntregaEconomica implements ModalidadeEntrega {

    private static final BigDecimal TARIFA_FIXA = new BigDecimal("6.00");
    private static final BigDecimal VALOR_POR_KM = new BigDecimal("0.90");
    private static final int PRAZO_BASE_DIAS = 10;
    private static final double KM_POR_DIA_ADICIONAL = 400.0;

    @Override
    public String getNome() { return "Econômica"; }

    @Override
    public BigDecimal calcularCusto(Pedido pedido) {
        return TARIFA_FIXA.add(VALOR_POR_KM.multiply(BigDecimal.valueOf(pedido.getDistanciaKm())));
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return PRAZO_BASE_DIAS + (int) Math.ceil(pedido.getDistanciaKm() / KM_POR_DIA_ADICIONAL);
    }
}
