public class ModalidadeEconomica implements ModalidadeEntrega {
    private final double valorPorKm;
    private final int diasExtras;

    public ModalidadeEconomica(double valorPorKm, int diasExtras) {
        this.valorPorKm = valorPorKm;
        this.diasExtras = diasExtras;
    }

    @Override
    public double calcularCusto(Pedido p) { 
        return valorPorKm * p.getDistancia(); 
    }

    @Override
    public int calcularPrazo(Pedido p) { 
        return 5 + diasExtras; 
    }

    @Override
    public String getModalidade() { 
        return "Econômica"; 
    }
}
