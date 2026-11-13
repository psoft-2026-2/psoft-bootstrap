package logistica;

public class Convencional implements ModalidadeEntrega {

    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 0.50;
    private static final int PRAZO_BASE = 3;
    private static final int KM_POR_DIA = 500;

    @Override
    public String nome() {
        return "Convencional";
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistanciaKm();
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return PRAZO_BASE + (int) Math.ceil((double) pedido.getDistanciaKm() / KM_POR_DIA);
    }
}
