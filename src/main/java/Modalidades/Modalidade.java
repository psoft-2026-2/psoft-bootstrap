package Modalidades;

import java.util.Date;

/**
 * Modalidade
 */
public interface Modalidade {

    double calculaCusto(Float distanciaEstimada);

    Date calculaPrazo(Float distanciaEstimada);
}
