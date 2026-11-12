package modalidade;

import modelo.Cotacao;
import modelo.Pedido;

public interface ModalidadeEntrega {

    String nome();

    Cotacao calcular(Pedido pedido);
}
