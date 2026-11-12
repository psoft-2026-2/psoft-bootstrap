package Modalidades;

import java.util.Date;

/**
 * ModalidadeEconomica
 */
public class ModalidadeEconomica implements Modalidade {

    private Date prazoAdicional;

    public void setPrazoAdicional(Date prazoAdicional) {
        this.prazoAdicional = prazoAdicional;
    }

    @Override
    public double calculaCusto(Float distanciaEstimada) {
        return 0; // TODO 
    }

    @Override
    public Date calculaPrazo(Float distanciaEstimada) {
        return new Date(); // TODO
    }

}
