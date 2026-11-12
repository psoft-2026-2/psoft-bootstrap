package modalidade;

import modelo.Cotacao;
import modelo.Pedido;

import java.math.BigDecimal;

public class EntregaExpressa implements ModalidadeEntrega {

    private static final BigDecimal TARIFA_FIXA = new BigDecimal("15.00");
    private static final BigDecimal VALOR_POR_KM = new BigDecimal("0.80");
    private static final BigDecimal ADICIONAL_PRIORIDADE = new BigDecimal("20.00");
    private static final int PRAZO_BASE_DIAS = 1;
    private static final double KM_POR_DIA_ADICIONAL = 1000;

    @Override
    public String nome() {
        return "Expressa";
    }

    @Override
    public Cotacao calcular(Pedido pedido) {
        BigDecimal custo = TARIFA_FIXA
                .add(VALOR_POR_KM.multiply(BigDecimal.valueOf(pedido.getDistanciaKm())))
                .add(ADICIONAL_PRIORIDADE);
        int prazo = PRAZO_BASE_DIAS + (int) Math.floor(pedido.getDistanciaKm() / KM_POR_DIA_ADICIONAL);
        return new Cotacao(custo, prazo);
    }
}
