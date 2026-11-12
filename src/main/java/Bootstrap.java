public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");

        CentralLogistica central1 = CentralLogistica.getInstance();
        CentralLogistica central2 = CentralLogistica.getInstance();
        System.out.println("Singleton (mesma instancia): " + (central1 == central2));

        central1.addPedido("111.222.333-44", "Rua A, 100", "Rua B, 200", 5.0f, 10.0f);
        central1.addPedido("555.666.777-88", "Rua C, 300", "Rua D, 400", 2.5f, 20.0f);

        Pedido p0 = central1.getPedido(0);
        Pedido p1 = central1.getPedido(1);

        System.out.println("Modalidade padrao: EntregaConvencional");
        System.out.println("Pedido 0 (dist=" + p0.getDist() + "): " + central1.calcularEntrega(p0));
        System.out.println("Pedido 1 (dist=" + p1.getDist() + "): " + central1.calcularEntrega(p1));

        central1.setModalidade(new EntregaExpressa());
        System.out.println("Modalidade: EntregaExpressa");
        System.out.println("Pedido 0 (dist=" + p0.getDist() + "): " + central1.calcularEntrega(p0));
        System.out.println("Pedido 1 (dist=" + p1.getDist() + "): " + central1.calcularEntrega(p1));

        central1.setModalidade(new EntregaEconomica());
        System.out.println("Modalidade: EntregaEconomica");
        System.out.println("Pedido 0 (dist=" + p0.getDist() + "): " + central1.calcularEntrega(p0));
        System.out.println("Pedido 1 (dist=" + p1.getDist() + "): " + central1.calcularEntrega(p1));
    }
}
