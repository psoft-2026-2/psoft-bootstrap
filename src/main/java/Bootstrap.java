public class Bootstrap {
    public static void main(String[] args) {
        Central central = Central.getInstancia();
        Pedido pedido = new Pedido("Maria", "Campina Grande", "João Pessoa", 2, 120, 1);
        central.addPedido(pedido);
        central.criarEntrega(pedido, new Convencional());
        Entrega entrega = central.getEntregas().get(0);
        exibir(entrega);
        entrega.alterarModalidade(new Economica());
        exibir(entrega);
        entrega.alterarModalidade(new Expresso());
        exibir(entrega);
        entrega.despachar();
        System.out.println("Entrega despachada: " + entrega.isDespachada());
    }

    private static void exibir(Entrega entrega) {
        System.out.printf("%s: R$ %.2f, prazo de %d dias.%n",
                entrega.getModalidade().getClass().getSimpleName(), entrega.getCusto() / 100.0, entrega.getPrazo());
    }
}
