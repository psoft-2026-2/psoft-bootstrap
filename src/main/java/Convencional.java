public class Convencional implements ModalidadeEntrega {

    private double fixo;
    private int valorPorKm;
    private int qtdKm;

    public Convencional(double fixo, int tarifa, int qtdKm) {
        this.fixo = fixo;
        this.valorPorKm = tarifa;
        this.qtdKm = qtdKm;
    }

    @Override
    public double calcularCusto() {
        double custoPelaDistancia = valorPorKm * qtdKm;
        return fixo + custoPelaDistancia;
    }
}
