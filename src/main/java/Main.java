public class Main {
    public static void main(String[] args) {
        CentralLogistica central = CentralLogistica.getInstance();

        Cliente cliente = new Cliente("Mikael", "mikael@email.com");
        Endereco origem = new Endereco("Rua A, 10", "Campina Grande", "58400-000");
        Endereco destino = new Endereco("Rua B, 20", "Joao Pessoa", "58000-000");

        Pedido pedido = new Pedido(cliente, origem, destino, 2.5, 130);
        central.registrarPedido(pedido);

        central.selecionarModalidade(pedido, new EntregaConvencional());
        central.solicitarEntrega(pedido);

        central.selecionarModalidade(pedido, new EntregaExpressa());
        central.solicitarEntrega(pedido);

        central.selecionarModalidade(pedido, new EntregaEconomica());
        central.solicitarEntrega(pedido);

        central.despachar(pedido);

        try {
            central.selecionarModalidade(pedido, new EntregaExpressa());
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("Mesma central? " + (central == CentralLogistica.getInstance()));
    }
}
