public class EntregaConvencional implements Entrega {
    private double tarifa;
    private double distanciakm;

    public EntregaConvencional(double tarifa, double distanciakm) {
        this.tarifa = tarifa;
        this.distanciakm = distanciakm;
    }

    @Override
    public double calculaCusto() {
        return this.tarifa * this.distanciakm;
    }

    @Override
    public String calculaPrazo() {
        double tempoHoras = this.distanciakm / 60.0;
        int horas = (int) tempoHoras;
        int minutos = (int) Math.round((tempoHoras - horas) * 60);

        if (minutos == 60) {
            horas++;
            minutos = 0;
        }

        return horas + "h e " + minutos + "min";
    }

}
