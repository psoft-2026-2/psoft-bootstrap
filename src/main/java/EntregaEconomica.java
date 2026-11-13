public class EntregaEconomica implements Entrega {
    private double distanciakm;

    public EntregaEconomica(double distanciakm) {
        this.distanciakm = distanciakm;
    }

    @Override
    public double calculaCusto() {
        return this.distanciakm * 1.0;
    }

    @Override
    public String calculaPrazo() {
        double tempoHoras = this.distanciakm / 40.0;
        int horas = (int) tempoHoras;
        int minutos = (int) Math.round((tempoHoras - horas) * 60);

        if (minutos == 60) {
            horas++;
            minutos = 0;
        }

        return horas + "h e " + minutos + "min";
    }
}
    
