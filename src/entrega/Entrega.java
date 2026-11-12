package entrega;

import modelo.Pedido;

public interface Entrega {
    double calculaCusto(Pedido pedido);

    int calculaPrazo(Pedido pedido);
}