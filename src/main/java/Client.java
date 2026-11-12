// SINGLETON

import Modalidades.Modalidade;
import Modalidades.ModalidadeFacade;

public class Client {
    
    private static Client client;
    private static ModalidadeFacade modalidade; 

    private Client() {
        modalidade = new ModalidadeFacade();
    }

    protected static Client getClient() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public Pedido registrarPedido(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        pedido.setCliente(pedidoDto.cliente());
        pedido.setEndOrigem(pedidoDto.endOrigem());
        pedido.setEndDestino(pedidoDto.endDestino());
        pedido.setPeso(pedidoDto.peso());
        pedido.setDistanciaEstimada(pedidoDto.distanciaEstimada());
        pedido.setModalidade(modalidade.getModalidade());
        return pedido;
    }

    public void setModalidadeConvencional() {
        modalidade.setModalidadeConvencional();
    }

    public void setModalidadeExpressa() {
        modalidade.setModalidadeExpressa();
    }

    public void setModalidadeEconomica() {
        modalidade.setModalidadeEconomica();
    }

    public Modalidade getModalidade() {
        return modalidade.getModalidade();
    }
}