public class Economica implements ModalidadeEntrega {
    private double valorPorKM;
    private int prazoDias;

    public Economica(double valorPorKM, int prazoDias) {
        this.valorPorKM = valorPorKM;
        this.prazoDias = prazoDias;
    }

    @Override
    public double calcularCusto(double dist) {
        return valorPorKM * dist;
    }

    @Override
    public int calcularPrazo() {
        return prazoDias;
    }
}
