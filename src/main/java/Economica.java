public class Economica implements ModalidadeEntrega {

    private double valorReduzido;

    public Economica(double valorReduzido) {
        this.valorReduzido = valorReduzido;
    }

    @Override
    public double calcularCusto() {
        return valorReduzido;
    }
}
