package modalidade;

import modelo.Cotacao;
import modelo.Pedido;

import java.math.BigDecimal;

public class EntregaEconomica implements ModalidadeEntrega {

    private static final BigDecimal TARIFA_FIXA = new BigDecimal("5.00");
    private static final BigDecimal VALOR_POR_KM = new BigDecimal("0.30");
    private static final int PRAZO_BASE_DIAS = 7;
    private static final double KM_POR_DIA_ADICIONAL = 300;

    @Override
    public String nome() {
        return "Econômica";
    }

    @Override
    public Cotacao calcular(Pedido pedido) {
        BigDecimal custo = TARIFA_FIXA.add(VALOR_POR_KM.multiply(BigDecimal.valueOf(pedido.getDistanciaKm())));
        int prazo = PRAZO_BASE_DIAS + (int) Math.ceil(pedido.getDistanciaKm() / KM_POR_DIA_ADICIONAL);
        return new Cotacao(custo, prazo);
    }
}
