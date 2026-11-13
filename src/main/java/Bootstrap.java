public class Bootstrap {

    public static void main(String[] args) {
        System.out.println("Projeto de Software");

        CentralLogistica central = CentralLogistica.getInstancia();

        Cliente maria = new Cliente("Maria Silva", "111.222.333-44", "maria@email.com");
        Cliente joao = new Cliente("Joao Souza", "555.666.777-88", "joao@email.com");

        Endereco deposito = new Endereco("Rua Aprigio Veloso", "882", "Campina Grande", "PB");
        Endereco casaMaria = new Endereco("Av. Epitacio Pessoa", "1000", "Joao Pessoa", "PB");
        Endereco casaJoao = new Endereco("Rua da Aurora", "50", "Recife", "PE");

        Pedido pedido1 = central.registrarPedido(maria, deposito, casaMaria, 2.0, 125, new EntregaConvencional());
        Pedido pedido2 = central.registrarPedido(joao, deposito, casaJoao, 5.0, 200, new EntregaExpressa());
        central.registrarPedido(maria, deposito, casaJoao, 1.5, 200, new EntregaEconomica());

        System.out.println("=== Pedidos registrados ===");
        for (Pedido pedido : central.listarPedidos()) {
            System.out.println(pedido);
        }

        System.out.println();
        System.out.println("=== Alterando a modalidade do pedido 1 para Expressa ===");
        central.alterarModalidade(pedido1.getId(), new EntregaExpressa());
        System.out.println(central.buscarPedido(pedido1.getId()));

        System.out.println();
        System.out.println("=== Despachando o pedido 2 ===");
        central.despacharPedido(pedido2.getId());
        System.out.println(central.buscarPedido(pedido2.getId()));

        System.out.println();
        System.out.println("=== Tentando alterar a modalidade do pedido 2 (ja despachado) ===");
        try {
            central.alterarModalidade(pedido2.getId(), new EntregaEconomica());
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Verificando se a central e unica ===");
        CentralLogistica outraReferencia = CentralLogistica.getInstancia();
        System.out.println("Mesma central? " + (central == outraReferencia));
        System.out.println("Total de pedidos: " + outraReferencia.listarPedidos().size());

        System.out.println();
        System.out.println("=== Pedidos aguardando despacho ===");
        for (Pedido pedido : central.listarPedidosNaoDespachados()) {
            System.out.println(pedido);
        }
    }
}
