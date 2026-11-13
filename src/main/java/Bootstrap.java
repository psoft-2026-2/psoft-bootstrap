public class Bootstrap {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana Silva", "ana@example.com", "83999990000");
        Endereco origem = new Endereco("Rua das Flores", "10", "Campina Grande", "58400-000");
        Endereco destino = new Endereco("Av. Central", "200", "João Pessoa", "58000-000");
        Pedido pedido = new Pedido(1, cliente, origem, destino, 2.5, 120.0);

        CentralDeLogistica central = CentralDeLogistica.getInstance();
        central.registrarPedido(pedido);

        central.selecionarModalidade(pedido, new EntregaConvencional(8.0, 1.5));
        imprimirEstimativa("Convencional", pedido);

        central.selecionarModalidade(pedido, new EntregaEconomica(1.0, 0.20));
        imprimirEstimativa("Econômica", pedido);

        central.selecionarModalidade(pedido, new EntregaExpressa(2.5, 15.0));
        imprimirEstimativa("Expressa", pedido);

        central.despacharPedido(pedido.getNumero());
        System.out.println("Status após despacho: " + central.acompanharPedido(pedido.getNumero()).getStatus());
    }

    private static void imprimirEstimativa(String modalidade, Pedido pedido) {
        System.out.printf("%s: custo R$ %.2f, prazo %d horas%n",
                modalidade, pedido.getCusto(), pedido.getPrazoEstimado());
    }
}
