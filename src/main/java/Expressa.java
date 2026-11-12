public class Expressa implements ModalidadeEntrega {
    private static final float TARIFA_FIXA = 10.0f;
    private static final float VALOR_POR_KM = 0.50f;
    private float custoAdicional;

    public Expressa(float custoAdicional) {
        setCustoAdicional(custoAdicional);
    }

    @Override
    public float calcularCusto() {
        return TARIFA_FIXA + custoAdicional;
    }

    @Override
    public float calcularCusto(float distancia) {
        return calcularCusto() + distancia * VALOR_POR_KM;
    }

    @Override
    public int calcularPrazo() {
        return 2;
    }

    public void setCustoAdicional(float custoAdicional) {
        this.custoAdicional = custoAdicional;
    }

    public float getCustoAdicional() {
        return custoAdicional;
    }
}
