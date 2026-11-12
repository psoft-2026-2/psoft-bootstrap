package Modalidades;

import java.util.Date;

/**
 * ModalidadeConvencionl
 */
public class ModalidadeConvencional implements Modalidade {

    private double custoPorKm; 

    public void setCustoPorKm(double custoPorKm) {
        this.custoPorKm = custoPorKm;
    }
   
    @Override 
    public double calculaCusto(Float distanciaEstimada) {
        return custoPorKm * distanciaEstimada;
    }

    @Override
    public Date calculaPrazo(Float distanciaEstimada) {
        // Implementação do cálculo do prazo para a modalidade convencional
        return new Date(); // Retorna a data atual como exemplo
    }

}
