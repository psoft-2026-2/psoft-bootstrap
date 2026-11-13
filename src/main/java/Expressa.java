public class Expressa implements ModalidadeEntrega {
    private Priority prioridadeAtendimento;
    private double valorPorKM;
    private int prazoDias;

    public Expressa(Priority p, double valorPorKM, int prazoDias) {
        this.prioridadeAtendimento = p;
        this.valorPorKM = valorPorKM;
        this.prazoDias = prazoDias;
    }

    @Override
    public double calcularCusto(double dist) {
        return valorPorKM * dist + prioridadeAtendimento.getAdicionalCusto();
    }

    @Override
    public int calcularPrazo() {
        return prazoDias;
    }
}