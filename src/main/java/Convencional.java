public class Convencional implements Entrega {

    private double valorKM;
    private double tarifa;
    private int prazo;

    public Convencional(int prazo, double tarifa, double valorKM) {
        this.prazo = prazo;
        this.tarifa = tarifa;
        this.valorKM = valorKM;
    }

    @Override
    public Double getPreco(Long distanciaEstimada) {
        return tarifa + distanciaEstimada * valorKM;
    }

    @Override
    public int getPrazo() {
        return prazo;
    }
}
