import java.util.Date;
import java.util.Calendar;

public class EntregaConvencional implements Entrega {

    private double distancia;
    private double tarifaFixa;
    private double custoPorKm;

    public EntregaConvencional(double distancia, double tarifaFixa,
                               double custoPorKm) {
        this.distancia = distancia;
        this.tarifaFixa = tarifaFixa;
        this.custoPorKm = custoPorKm;
    }

    @Override
    public double calculaCusto() {
        return tarifaFixa + (distancia * custoPorKm);
    }

    @Override
    public Date calculaPrazo() {
        int dias = Math.max(1, (int) Math.ceil(distancia / 100.0));
        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.DAY_OF_MONTH, dias);
        return calendario.getTime();
    }
}
