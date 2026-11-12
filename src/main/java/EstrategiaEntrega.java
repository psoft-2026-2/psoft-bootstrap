public interface EstrategiaEntrega {

    double calculaCusto(Pedido pedido);

    int calculaPrazo(Pedido pedido);

    String estimaEntrega(Pedido pedido);
}
