public class Bootstrap {

    public static void main(String[] args) {
        CentralLogistica central = CentralLogistica.getInstance();

        Cliente cliente = new Cliente("Ana", "123.456.789-00");
        Pedido pedido = new Pedido(cliente, "Campina Grande", "Joao Pessoa", 2.5f, 130f);
        central.registrarPedido(pedido);

        central.setModalidadeEntrega(pedido, new EntregaConvencional(pedido.getDistancia(), pedido.getPeso()));
        System.out.println("Convencional: R$ " + pedido.getEntrega().calcularPreco() + " - " + pedido.getEntrega().calcularPrazo() + " dias");

        central.setModalidadeEntrega(pedido, new EntregaExpressa(pedido.getDistancia(), pedido.getPeso()));
        System.out.println("Expressa: R$ " + pedido.getEntrega().calcularPreco() + " - " + pedido.getEntrega().calcularPrazo() + " dias");

        central.setModalidadeEntrega(pedido, new EntregaEconomica(pedido.getDistancia(), pedido.getPeso()));
        System.out.println("Economica: R$ " + pedido.getEntrega().calcularPreco() + " - " + pedido.getEntrega().calcularPrazo() + " dias");

        pedido.despachar();
        try {
            central.setModalidadeEntrega(pedido, new EntregaExpressa(pedido.getDistancia(), pedido.getPeso()));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(central == CentralLogistica.getInstance());
    }
}
