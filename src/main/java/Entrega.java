public interface Entrega {
    float calcularFrete(Pedido pedido);

    int calcularPrazo(Pedido pedido);
}
