import java.math.BigDecimal;

// Tarifa fixa + valor por quilômetro percorrido.
public class EntregaConvencional implements ModalidadeEntrega {

    private static final BigDecimal TARIFA_FIXA = new BigDecimal("10.00");
    private static final BigDecimal VALOR_POR_KM = new BigDecimal("1.50");
    private static final int PRAZO_BASE_DIAS = 5;
    private static final double KM_POR_DIA_ADICIONAL = 500.0;

    @Override
    public String getNome() { return "Convencional"; }

    @Override
    public BigDecimal calcularCusto(Pedido pedido) {
        return TARIFA_FIXA.add(VALOR_POR_KM.multiply(BigDecimal.valueOf(pedido.getDistanciaKm())));
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return PRAZO_BASE_DIAS + (int) Math.ceil(pedido.getDistanciaKm() / KM_POR_DIA_ADICIONAL);
    }
}
