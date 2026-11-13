public class EntregaExpressa implements Entrega {
    private int prioridade;
    private double distanciakm;

    public EntregaExpressa(int prioridade, double distanciakm) {
        this.prioridade = prioridade;
        this.distanciakm = distanciakm;
    }

    @Override
    public double calculaCusto() {
        double calculo = Math.pow(2, this.prioridade - 4);
        double taxa = this.distanciakm / calculo;
        return taxa * this.distanciakm;
    }

    @Override
    public String calculaPrazo() {
        double tempoHoras = this.distanciakm / velocidade();
        int horas = (int) tempoHoras;
        int minutos = (int) Math.round((tempoHoras - horas) * 60);

        if (minutos == 60) {
            horas++;
            minutos = 0;
        }

        return horas + "h e " + minutos + "min";
    }

    private double velocidade() {
        switch (prioridade) {
            case 1:
                return 100.0;
            case 2:
                return 80.0;
            case 3:
                return 60.0;
            default:
                throw new IllegalArgumentException("Prioridade Inválida");
        }
    }
    
}
