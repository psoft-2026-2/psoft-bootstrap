/** Testes executáveis sem dependências externas. */
public class Atividade5Test {
    public static void main(String[] args) {
        testaSingletonERegistro();
        testaCalculosETrocaDeEstrategia();
        testaFluxoDeStatusEProtecaoAposDespacho();
        System.out.println("Todos os testes da Atividade 5 passaram.");
    }

    private static void testaSingletonERegistro() {
        CentralDeLogistica central = CentralDeLogistica.getInstance();
        assertSame(central, CentralDeLogistica.getInstance(), "A central deve ser singleton");

        Pedido pedido = criarPedido(501, 50.0);
        central.registrarPedido(pedido);
        assertSame(pedido, central.acompanharPedido(501), "A central deve acompanhar o pedido registrado");
        assertEquals(1, central.listarPedidos().size(), "A lista deve conter o pedido registrado");
        assertThrows(IllegalArgumentException.class, () -> central.registrarPedido(criarPedido(501, 5.0)));
        assertThrows(UnsupportedOperationException.class, () -> central.listarPedidos().add(criarPedido(502, 1.0)));
    }

    private static void testaCalculosETrocaDeEstrategia() {
        CentralDeLogistica central = CentralDeLogistica.getInstance();
        Pedido pedido = central.acompanharPedido(501);

        central.selecionarModalidade(pedido, new EntregaConvencional(5.0, 2.0));
        assertEquals(105.0, pedido.getCusto(), "Custo convencional deve incluir taxa fixa e distância");
        assertEquals(72, pedido.getPrazoEstimado(), "Prazo convencional deve ser calculado em horas");

        central.selecionarModalidade(pedido, new EntregaEconomica(2.0, 0.25));
        assertEquals(75.0, pedido.getCusto(), "Custo econômico deve aplicar o desconto");
        assertEquals(480, pedido.getPrazoEstimado(), "Prazo econômico deve ser maior");

        central.selecionarModalidade(pedido, new EntregaExpressa(1.5, 10.0));
        assertEquals(85.0, pedido.getCusto(), "Custo expresso deve incluir a taxa de prioridade");
        assertEquals(24, pedido.getPrazoEstimado(), "Prazo expresso deve ser menor que o econômico");
    }

    private static void testaFluxoDeStatusEProtecaoAposDespacho() {
        CentralDeLogistica central = CentralDeLogistica.getInstance();
        Pedido pedido = central.acompanharPedido(501);

        assertEquals(StatusPedido.REGISTRADO, pedido.getStatus(), "Status inicial incorreto");
        central.despacharPedido(501);
        assertEquals(StatusPedido.DESPACHADO, pedido.getStatus(), "O despacho deve atualizar o status");
        assertThrows(IllegalStateException.class,
                () -> central.selecionarModalidade(pedido, new EntregaEconomica()));

        central.iniciarTransporte(501);
        assertEquals(StatusPedido.EM_TRANSPORTE, pedido.getStatus(), "Status de transporte incorreto");
        central.registrarEntrega(501);
        assertEquals(StatusPedido.ENTREGUE, pedido.getStatus(), "Status final incorreto");
    }

    private static Pedido criarPedido(int numero, double distanciaKm) {
        Cliente cliente = new Cliente("Cliente de teste", "teste@example.com", "83999990000");
        Endereco origem = new Endereco("Rua A", "1", "Campina Grande", "58400-000");
        Endereco destino = new Endereco("Rua B", "2", "João Pessoa", "58000-000");
        return new Pedido(numero, cliente, origem, destino, 2.0, distanciaKm);
    }

    private static void assertEquals(double esperado, double obtido, String mensagem) {
        if (Math.abs(esperado - obtido) > 0.000001) {
            throw new AssertionError(mensagem + ": esperado " + esperado + ", obtido " + obtido);
        }
    }

    private static void assertEquals(int esperado, int obtido, String mensagem) {
        if (esperado != obtido) {
            throw new AssertionError(mensagem + ": esperado " + esperado + ", obtido " + obtido);
        }
    }

    private static void assertEquals(Object esperado, Object obtido, String mensagem) {
        if (!esperado.equals(obtido)) {
            throw new AssertionError(mensagem + ": esperado " + esperado + ", obtido " + obtido);
        }
    }

    private static void assertSame(Object esperado, Object obtido, String mensagem) {
        if (esperado != obtido) {
            throw new AssertionError(mensagem);
        }
    }

    private static void assertThrows(Class<? extends Throwable> tipo, Runnable acao) {
        try {
            acao.run();
        } catch (Throwable excecao) {
            if (tipo.isInstance(excecao)) {
                return;
            }
            throw new AssertionError("Esperada " + tipo.getSimpleName() + ", recebida "
                    + excecao.getClass().getSimpleName(), excecao);
        }
        throw new AssertionError("Era esperada uma exceção do tipo " + tipo.getSimpleName());
    }
}
