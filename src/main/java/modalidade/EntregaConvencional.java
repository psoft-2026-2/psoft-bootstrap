package modalidade;

import modelo.Cotacao;
import modelo.Pedido;

import java.math.BigDecimal;

public class EntregaConvencional implements ModalidadeEntrega {

    private static final BigDecimal TARIFA_FIXA = new BigDecimal("10.00");
    private static final BigDecimal VALOR_POR_KM = new BigDecimal("0.50");
    private static final int PRAZO_BASE_DIAS = 3;
    private static final double KM_POR_DIA_ADICIONAL = 500;

    @Override
    public String nome() {
        return "Convencional";
    }

    @Override
    public Cotacao calcular(Pedido pedido) {
        BigDecimal custo = TARIFA_FIXA.add(VALOR_POR_KM.multiply(BigDecimal.valueOf(pedido.getDistanciaKm())));
        int prazo = PRAZO_BASE_DIAS + (int) Math.ceil(pedido.getDistanciaKm() / KM_POR_DIA_ADICIONAL);
        return new Cotacao(custo, prazo);
    }
}
