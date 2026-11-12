package atv5;

public class Sistema {
    private Modalidade modalidade;
    private Central central;

    public Sistema(Modalidade modalidadeInicial) {
        this.modalidade = modalidadeInicial;
        this.central = Central.getCentral();
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }


    // Faltou na modelagem
    public Pedido solicitarEntrega(int idPedido, int idCliente, Endereco origem, Endereco destino,
                                   double peso, double distancia) {
        Pedido pedido = new Pedido(idPedido, idCliente, origem, destino, peso, distancia, this.modalidade);
        central.registrarPedido(pedido);
        return pedido;
    }

    public void setModalidade(int idPedido, Modalidade novaModalidade) {
        Pedido pedido = central.getPedido(idPedido);
        if (pedido != null) {
            pedido.setModalidade(novaModalidade);
        }
    }

    public double calcularCusto(Pedido pedido) {
        return pedido.calcularCustoEntrega();
    }

    public int estimarPrazo(Pedido pedido) {
        return pedido.estimarPrazoEntrega();
    }
}
