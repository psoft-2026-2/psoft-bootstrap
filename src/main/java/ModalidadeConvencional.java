public class ModalidadeConvencional implements ModalidadeEntrega {
    private static final double TARIFA_FIXA = 10.0;
    private final double valorPorKm;

    public ModalidadeConvencional(double valorPorKm) { 
        this.valorPorKm = valorPorKm; 
    }

    @Override
    public double calcularCusto(Pedido p) { 
        return TARIFA_FIXA + valorPorKm * p.getDistancia(); 
    }

    @Override
    public int calcularPrazo(Pedido p) {
         return 5; 
    }

    @Override
    public String getModalidade() { 
        return "Convencional"; 
    }
}
