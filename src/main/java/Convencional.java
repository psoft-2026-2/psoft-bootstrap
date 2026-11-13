public class Convencional implements ModalidadeEntrega {
    private double valorPorKM;
    private double tarifaFixa;
    private int prazoDias;
 
    public Convencional(double valorPorKM, double tarifaFixa, int prazoDias) {
        this.valorPorKM = valorPorKM;
        this.tarifaFixa = tarifaFixa;
        this.prazoDias = prazoDias;
    }
 
    @Override
    public double calcularCusto(double dist) {
        return tarifaFixa + valorPorKM * dist;
    }
 
    @Override
    public int calcularPrazo() {
        return prazoDias;
    }
}

