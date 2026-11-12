public class Economica implements Entrega {

    private double valorKM;
    private double tarifa;
    private int prazo;
    private double desconto;
    private int acrescimoPrazo;

    public Economica(int prazo, double tarifa, double valorKM, double desconto, int acrescimoPrazo) {
        this.prazo = prazo;
        this.tarifa = tarifa;
        this.valorKM = valorKM;
        this.desconto = desconto;
        this.acrescimoPrazo = acrescimoPrazo;
    }

    @Override
    public Double getPreco(Long distanciaEstimada) {
        return (tarifa + distanciaEstimada * valorKM) - desconto;
    }

    @Override
    public int getPrazo() {
        return prazo + acrescimoPrazo;
    }
}
