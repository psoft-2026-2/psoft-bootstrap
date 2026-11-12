public class Main {
    public static void main(String[] args) {
        CentralLogistica central = CentralLogistica.getInstancia();

        Cliente cliente = new Cliente("Bruna", "bruna@email.com");
        Pedido pedido = new Pedido(cliente, "Campina Grande", "Joao Pessoa",
                2.5, 120, new EntregaConvencional());

        central.registrarPedido(pedido);
        System.out.println(central.acompanhar(pedido));

        pedido.alterarModalidade(new EntregaExpressa());
        System.out.println(central.acompanhar(pedido));

        central.despachar(pedido);
        System.out.println(central.acompanhar(pedido));

        try {
            pedido.alterarModalidade(new EntregaEconomica());
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}
