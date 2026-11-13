package logistica;

public class App {

    public static void main(String[] args) {
        CentralLogistica central = CentralLogistica.getInstance();

        Pedido pedido = new Pedido("Maria", "Campina Grande", "Recife", 2.5, 190);
        central.registrarPedido(pedido);
        System.out.println(central.acompanharPedido(pedido));

        mostrarCotacao(central, pedido, new Convencional());
        mostrarCotacao(central, pedido, new Expressa());
        mostrarCotacao(central, pedido, new Economica());

        central.despachar(pedido);
        System.out.println(central.acompanharPedido(pedido));

        try {
            central.selecionarModalidade(pedido, new Convencional());
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void mostrarCotacao(CentralLogistica central, Pedido pedido, ModalidadeEntrega modalidade) {
        central.selecionarModalidade(pedido, modalidade);
        Cotacao cotacao = central.solicitarEntrega(pedido);
        System.out.printf("%s: R$ %.2f em %d dia(s)%n", modalidade.nome(), cotacao.custo(), cotacao.prazoDias());
    }
}
