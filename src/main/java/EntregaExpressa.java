import java.math.BigDecimal;

// Mesma lógica de custo da convencional, mais um adicional pela prioridade de atendimento. Prazo curto.
public class EntregaExpressa implements ModalidadeEntrega {

    private static final BigDecimal TARIFA_FIXA = new BigDecimal("10.00");
    private static final BigDecimal VALOR_POR_KM = new BigDecimal("1.50");
    private static final BigDecimal ADICIONAL_PRIORIDADE = new BigDecimal("25.00");
    private static final double KM_POR_DIA = 800.0;

    @Override
    public String getNome() { return "Expressa"; }

    @Override
    public BigDecimal calcularCusto(Pedido pedido) {
        return TARIFA_FIXA
                .add(VALOR_POR_KM.multiply(BigDecimal.valueOf(pedido.getDistanciaKm())))
                .add(ADICIONAL_PRIORIDADE);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return Math.max(1, (int) Math.ceil(pedido.getDistanciaKm() / KM_POR_DIA));
    }
}
