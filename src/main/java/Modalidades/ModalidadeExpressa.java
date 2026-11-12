package Modalidades;

import java.util.Date;

/**
 * ModalidadeExpressa
 */
public class ModalidadeExpressa implements Modalidade {

    private double custoAdicional;

    public void setCustoAdicional(double custoAdicional) {
        this.custoAdicional = custoAdicional;
    }

    @Override
    public double calculaCusto(Float distanciaEstimada) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date calculaPrazo(Float distanciaEstimada) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
