public class Bootstrap {
    public static void main(String[] args) {
        CentralLogistica central = CentralLogistica.getInstancia();
        ModalidadeEntrega convencional = new Convencional(10, 2, 3);
        ModalidadeEntrega expressa = new Expressa(convencional, 8, 1);
        Pedido ana = new Pedido("Ana", "Campina Grande", "João Pessoa", 1.5, 100, convencional);
        Pedido bia = new Pedido("Bia", "Recife", "Natal", 2, 50, expressa);
        central.registrarPedido(ana);
        central.registrarPedido(bia);

        for (Pedido pedido : central.getPedidos()) {
            Entrega entrega = central.solicitarEntrega(pedido);
            System.out.println(pedido.getCliente() + ": R$ " + entrega.calcularCusto(pedido)
                    + ", " + entrega.calcularPrazo(pedido) + " dia(s)");
        }
    }
}
