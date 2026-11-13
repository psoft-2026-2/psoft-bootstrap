public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");

        CentralLogistica central = CentralLogistica.getInstancia();
        central.criarModalidade(new ModalidadeConvencional());
        central.criarModalidade(new ModalidadeExpressa());
        central.criarModalidade(new ModalidadeEconomica());

        Pedido pedido = new Pedido("Maria", "123.456.789-00", "Campina Grande", "João Pessoa",
                130, 2.5, new ModalidadeConvencional());
        central.registrarPedido(pedido);

        // Alterar a modalidade antes do despacho
        central.selecionarModalidadeEntrega(new ModalidadeExpressa(), pedido);
        central.solicitarEntrega(pedido);

        // Após o despacho, a modalidade não pode mais ser alterada
        try {
            central.selecionarModalidadeEntrega(new ModalidadeEconomica(), pedido);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Diferentes partes da aplicação acessam a mesma central
        System.out.println("Mesma central? " + (central == CentralLogistica.getInstancia()));
        for (Pedido p : CentralLogistica.getInstancia().listarPedidos()) {
            System.out.println(p);
        }
    }
}
