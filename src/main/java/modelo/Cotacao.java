package modelo;

import java.math.BigDecimal;

public class Cotacao {

    private final BigDecimal custo;
    private final int prazoEmDias;

    public Cotacao(BigDecimal custo, int prazoEmDias) {
        this.custo = custo;
        this.prazoEmDias = prazoEmDias;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public int getPrazoEmDias() {
        return prazoEmDias;
    }

    @Override
    public String toString() {
        return "R$ " + custo + " em " + prazoEmDias + " dia(s)";
    }
}