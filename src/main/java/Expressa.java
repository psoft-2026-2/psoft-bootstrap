public class Expressa implements Entrega {

    private double valorKM;
    private double tarifa;
    private int prazo;
    private int prioridade;
    private double custoPrioridade;

    public Expressa(int prazo, double tarifa, double valorKM, int prioridade, double custoPrioridade) {
        this.prazo = prazo;
        this.tarifa = tarifa;
        this.valorKM = valorKM;
        this.prioridade = prioridade;
        this.custoPrioridade = custoPrioridade;
    }

    @Override
    public Double getPreco(Long distanciaEstimada) {
        return tarifa + (distanciaEstimada * valorKM) + (prioridade * custoPrioridade);
    }

    @Override
    public int getPrazo() {
        return prazo;
    }
}
