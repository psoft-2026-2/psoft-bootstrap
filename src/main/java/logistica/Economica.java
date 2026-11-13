package logistica;

public class Economica implements ModalidadeEntrega {

    private static final double TARIFA_FIXA = 5.0;
    private static final double VALOR_POR_KM = 0.30;
    private static final int PRAZO_BASE = 6;
    private static final int KM_POR_DIA = 300;

    @Override
    public String nome() {
        return "Econômica";
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
