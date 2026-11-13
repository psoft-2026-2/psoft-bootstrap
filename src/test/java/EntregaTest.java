public class EntregaTest {
    public static void main(String[] args) {
        CentralLogistica central = CentralLogistica.getInstancia();
        assert central == CentralLogistica.getInstancia();

        ModalidadeEntrega convencional = new Convencional(10, 2, 3);
        ModalidadeEntrega expressa = new Expressa(convencional, 8, 1);
        ModalidadeEntrega economica = new Economica(convencional, 0.25, 2);
        Pedido ana = new Pedido("Ana", "Campina Grande", "João Pessoa", 1.5, 100, convencional);
        Pedido bia = new Pedido("Bia", "Recife", "Natal", 2, 50, expressa);
        Pedido caio = new Pedido("Caio", "A", "B", 3, 20, economica);
        central.registrarPedido(ana);
        central.registrarPedido(bia);
        central.registrarPedido(caio);

        assert central.getPedidos().size() == 3;
        assert central.getPedidos().contains(ana);
        assert central.getPedidos().contains(bia);
        assert central.getPedidos().contains(caio);
        assert central.solicitarEntrega(ana) == ana.getEntrega();
        assert central.solicitarEntrega(bia) == bia.getEntrega();
        assert central.solicitarEntrega(caio) == caio.getEntrega();
        assert central.solicitarEntrega(ana).calcularCusto(ana) == 210;
        assert central.solicitarEntrega(ana).calcularPrazo(ana) == 3;
        assert central.solicitarEntrega(bia).calcularCusto(bia) == 118;
        assert central.solicitarEntrega(bia).calcularPrazo(bia) == 1;
        assert central.solicitarEntrega(caio).calcularCusto(caio) == 37.5;
        assert central.solicitarEntrega(caio).calcularPrazo(caio) == 5;

        central.alterarModalidade(ana, economica);
        assert central.solicitarEntrega(ana).calcularCusto(ana) == 157.5;
        assert central.solicitarEntrega(ana).calcularPrazo(ana) == 5;
        assert central.solicitarEntrega(bia).calcularCusto(bia) == 118;
        assert central.solicitarEntrega(caio).calcularCusto(caio) == 37.5;

        central.despachar(ana);
        assert central.solicitarEntrega(ana).isDespachada();
        assert !central.solicitarEntrega(bia).isDespachada();
        assert !central.solicitarEntrega(caio).isDespachada();
        try {
            central.alterarModalidade(ana, convencional);
            throw new AssertionError("Alteração após despacho permitida");
        } catch (IllegalStateException esperado) {
            // A modalidade fica bloqueada após o despacho.
        }
        central.alterarModalidade(bia, convencional);
        assert central.solicitarEntrega(bia).calcularCusto(bia) == 110;
        assert central.solicitarEntrega(bia).calcularPrazo(bia) == 3;
        assert central.solicitarEntrega(ana).calcularCusto(ana) == 157.5;

        Pedido naoRegistrado = new Pedido("Dani", "A", "B", 1, 2, convencional);
        try {
            central.despachar(naoRegistrado);
            throw new AssertionError("Pedido não registrado despachado");
        } catch (IllegalArgumentException esperado) {
            // Apenas pedidos registrados podem ser despachados pela central.
        }
        try {
            central.alterarModalidade(naoRegistrado, expressa);
            throw new AssertionError("Modalidade de pedido não registrado alterada");
        } catch (IllegalArgumentException esperado) {
            // Apenas pedidos registrados podem ser alterados pela central.
        }
        assert central.getPedidos().size() == 3;
    }
}
