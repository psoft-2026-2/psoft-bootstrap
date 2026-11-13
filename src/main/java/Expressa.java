public class Expressa implements ModalidadeEntrega {

    private double fixo;
    private double adicional;

    public Expressa(double fixo, double adicional) {
        this.fixo = fixo;
        this.adicional = adicional;
    }

    @Override
    public double calcularCusto() {
        return fixo + adicional;
    }
}
