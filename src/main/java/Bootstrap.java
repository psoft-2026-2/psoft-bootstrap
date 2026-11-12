
public class Bootstrap {

    public static void main(String[] args) {

        CentralLogistica central = CentralLogistica.getInstance();

        Pedido pedido = new Pedido(
            "Gabriel",
            "Campina Grande",
            "Joao Pessoa",
            2.5,
            130.0,
            new EntregaConvencional()
        );

        central.registrarPedido(pedido);

        System.out.println("Entrega convencional:");
        System.out.println("Custo: R$ " + pedido.calcularCusto());
        System.out.println("Prazo: " + pedido.calcularPrazo() + " dias");

        central.alterarModalidade(pedido, new EntregaExpressa());

        System.out.println("\nEntrega expressa:");
        System.out.println("Custo: R$ " + pedido.calcularCusto());
        System.out.println("Prazo: " + pedido.calcularPrazo() + " dias");

        central.despacharPedido(pedido);

        System.out.println("\nPedido despachado: "
                + pedido.isDespachado());

        System.out.println("Total de pedidos: "
                + central.getPedidos().size());
                CentralLogistica outraCentral = CentralLogistica.getInstance();

        System.out.println(
         "Mesma central: " + (central == outraCentral)
        );

        try {
        central.alterarModalidade(pedido, new EntregaEconomica());
        System.out.println("ERRO: alteracao permitida!");
        } catch (IllegalStateException e) {
        System.out.println("Alteracao bloqueada: " + e.getMessage());
        }
    }
}
