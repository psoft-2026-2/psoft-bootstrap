public class Convencional implements ModalidadeEntrega {
    private static final float VALOR_POR_KM = 0.50f;
    private float tarifaFixa;

    public Convencional(float tarifaFixa) {
        setTarifaFixa(tarifaFixa);
    }

    @Override
    public float calcularCusto() {
        return tarifaFixa;
    }

    @Override
    public float calcularCusto(float distancia) {
        return calcularCusto() + distancia * VALOR_POR_KM;
    }

    @Override
    public int calcularPrazo() {
        return 5;
    }

    public void setTarifaFixa(float tarifaFixa) {
        this.tarifaFixa = tarifaFixa;
    }

    public float getTarifaFixa() {
        return tarifaFixa;
    }
}
