public interface ModalidadeEntrega {
    float calcularCusto();

    int calcularPrazo();

    default float calcularCusto(float distancia) {
        return calcularCusto();
    }
}
