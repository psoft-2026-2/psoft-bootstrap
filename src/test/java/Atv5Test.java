public class Atv5Test {

    private static int total;
    private static int falhas;

    public static void main(String[] args) {
        executar("troca de estrategia antes do despacho e bloqueio depois", Atv5Test::testTrocaDeEstrategia);
        executar("custo e prazo da entrega convencional", Atv5Test::testEntregaConvencional);
        executar("custo e prazo da entrega expressa", Atv5Test::testEntregaExpressa);
        executar("custo e prazo da entrega economica", Atv5Test::testEntregaEconomica);
        executar("singleton da CentralLogistica", Atv5Test::testSingleton);
        executar("contains e remove por identidade na CentralLogistica", Atv5Test::testIdentidadeNaCentral);
        executar("solicitacao de entrega despacha o pedido", Atv5Test::testSolicitarEntrega);
        executar("valores invalidos, NaN e infinito sao rejeitados", Atv5Test::testValoresInvalidos);

        System.out.println();
        System.out.println("Testes executados: " + total);
        System.out.println("Falhas: " + falhas);
        if (falhas > 0) {
            throw new AssertionError(falhas + " teste(s) falharam");
        }
        System.out.println("Todos os testes passaram.");
    }

    private static void executar(String nome, Runnable teste) {
        total++;
        try {
            teste.run();
            System.out.println("[OK] " + nome);
        } catch (Throwable t) {
            falhas++;
            System.out.println("[FALHA] " + nome + ": " + t);
        }
    }

    private static void testTrocaDeEstrategia() {
        Pedido pedido = pedido(1.0, 10.0);
        EstrategiaEntrega convencional = new EntregaConvencionalStrategy(2.0);

        pedido.setEstrategia(convencional);
        assertSame(convencional, pedido.getEstrategia(), "estrategia deve ser a mesma informada");
        assertTrue(!pedido.isDespachado(), "pedido nao deve iniciar despachado");

        assertThrows(IllegalArgumentException.class,
                () -> pedido.setEstrategia(null), "estrategia nula deve ser rejeitada");

        pedido.despachar();
        assertTrue(pedido.isDespachado(), "pedido deve estar despachado");
        assertThrows(IllegalStateException.class,
                () -> pedido.setEstrategia(new EntregaExpressaStrategy(5.0)),
                "troca apos despacho deve ser bloqueada");

        Pedido semEstrategia = pedido(1.0, 10.0);
        assertThrows(IllegalStateException.class,
                semEstrategia::despachar, "despacho sem estrategia deve ser bloqueado");
    }

    private static void testEntregaConvencional() {
        Pedido pedido = pedido(3.0, 100.0);
        EntregaConvencionalStrategy convencional = new EntregaConvencionalStrategy(2.0);

        assertEquals(2.0, convencional.getTarifa(), "tarifa deve ser a informada");
        assertEquals(200.0, convencional.calculaCusto(pedido), "custo deve usar a distancia do pedido");
        assertEquals(2, convencional.calculaPrazo(pedido), "prazo para 100 km deve ser 2 dias");
        assertEquals(1, convencional.calculaPrazo(pedido(1.0, 50.0)), "limite de 50 km deve ser 1 dia");
        assertEquals(2, convencional.calculaPrazo(pedido(1.0, 50.0001)), "acima de 50 km deve ser 2 dias");
        assertEquals(1, convencional.calculaPrazo(pedido(1.0, 0.1)), "prazo minimo deve ser 1 dia");
        assertEquals(0.0, new EntregaConvencionalStrategy(0.0).calculaCusto(pedido),
                "tarifa zero deve gerar custo zero");

        Pedido outro = pedido(1.0, 101.0);
        assertTrue(convencional.calculaCusto(outro) != convencional.calculaCusto(pedido),
                "custo deve variar com a distancia do pedido");
        assertTrue(convencional.estimaEntrega(pedido).contains("R$"),
                "estimaEntrega deve descrever o custo");
    }

    private static void testEntregaExpressa() {
        Pedido pedido = pedido(10.0, 999.0);
        EntregaExpressaStrategy expressa = new EntregaExpressaStrategy(15.0);

        assertEquals(15.0, expressa.getCustoAdic(), "custo adicional deve ser o informado");
        assertEquals(15.0, expressa.calculaCusto(pedido), "custo expresso deve ser o custo adicional");
        assertEquals(1, expressa.calculaPrazo(pedido), "prazo expresso deve ser 1 dia");
        assertEquals(0.0, new EntregaExpressaStrategy(0.0).calculaCusto(pedido),
                "custo adicional zero deve gerar custo zero");
        assertTrue(expressa.estimaEntrega(pedido).contains("R$"),
                "estimaEntrega deve descrever o custo");
    }

    private static void testEntregaEconomica() {
        Pedido pedido = pedido(1.0, 1.0);

        EntregaEconomicaStrategy economica = new EntregaEconomicaStrategy(0.25, 3);
        assertEquals(0.25, economica.getDesconto(), "desconto deve ser o informado");
        assertEquals(3, economica.getPrioridade(), "prioridade deve ser a informada");
        assertEquals(15.0, economica.calculaCusto(pedido), "custo deve aplicar o desconto");
        assertEquals(4, economica.calculaPrazo(pedido), "prioridade 3 deve gerar prazo 4");

        EntregaEconomicaStrategy semDesconto = new EntregaEconomicaStrategy(0.0, 1);
        assertEquals(20.0, semDesconto.calculaCusto(pedido), "limite inferior de desconto");
        assertEquals(6, semDesconto.calculaPrazo(pedido), "limite superior de prazo");

        EntregaEconomicaStrategy descontoTotal = new EntregaEconomicaStrategy(1.0, 7);
        assertEquals(0.0, descontoTotal.calculaCusto(pedido), "limite superior de desconto");
        assertEquals(1, descontoTotal.calculaPrazo(pedido), "limite inferior de prazo");

        EntregaEconomicaStrategy prioridadeAlta = new EntregaEconomicaStrategy(0.5, 100);
        assertEquals(1, prioridadeAlta.calculaPrazo(pedido), "prazo nunca deve ser menor que 1");
        assertTrue(prioridadeAlta.estimaEntrega(pedido).contains("R$"),
                "estimaEntrega deve descrever o custo");
    }

    private static void testSingleton() {
        CentralLogistica primeira = CentralLogistica.getInstancia();
        CentralLogistica segunda = CentralLogistica.getInstancia();
        assertSame(primeira, segunda, "getInstancia deve retornar sempre a mesma instancia");
    }

    private static void testIdentidadeNaCentral() {
        CentralLogistica central = CentralLogistica.getInstancia();
        Pedido pedido = pedido(1.0, 10.0);
        Pedido outro = pedido(1.0, 10.0);
        Pedido copia = pedido(1.0, 10.0);

        central.adicionar(pedido);
        central.adicionar(pedido);
        assertTrue(central.removerPedido(pedido), "remove deve encontrar a mesma referencia");
        assertTrue(!central.removerPedido(pedido), "a mesma referencia nao deve ter sido duplicada");
        assertTrue(!central.removerPedido(copia), "instancia diferente nao deve ser removida");

        central.adicionar(outro);
        assertTrue(!central.removerPedido(copia), "contains deve comparar por referencia");
        assertTrue(central.removerPedido(outro), "remove deve encontrar a referencia adicionada");
        assertTrue(!central.removerPedido(outro), "segunda remocao deve retornar false");
    }

    private static void testSolicitarEntrega() {
        CentralLogistica central = CentralLogistica.getInstancia();
        Pedido pedido = pedido(2.0, 10.0);
        EstrategiaEntrega estrategia = new EntregaConvencionalStrategy(1.5);

        central.solicitarEntrega(pedido, estrategia);
        assertSame(estrategia, pedido.getEstrategia(), "estrategia deve ser associada ao pedido");
        assertTrue(pedido.isDespachado(), "pedido deve ser despachado apos a solicitacao");
        assertThrows(IllegalStateException.class,
                () -> central.solicitarEntrega(pedido, new EntregaExpressaStrategy(3.0)),
                "segunda solicitacao deve ser bloqueada apos o despacho");

        assertTrue(central.removerPedido(pedido), "pedido despachado deve estar na central");
    }

    private static void testValoresInvalidos() {
        Pedido pedido = pedido(1.0, 1.0);

        assertThrows(IllegalArgumentException.class, () -> pedido.setPeso(null), "peso nulo");
        assertThrows(IllegalArgumentException.class, () -> pedido.setPeso(0.0), "peso zero");
        assertThrows(IllegalArgumentException.class, () -> pedido.setPeso(-1.0), "peso negativo");
        assertThrows(IllegalArgumentException.class, () -> pedido.setPeso(Double.NaN), "peso NaN");
        assertThrows(IllegalArgumentException.class, () -> pedido.setPeso(Double.POSITIVE_INFINITY), "peso infinito");
        assertThrows(IllegalArgumentException.class, () -> pedido.setPeso(Double.NEGATIVE_INFINITY), "peso -infinito");

        assertThrows(IllegalArgumentException.class, () -> pedido.setDistancia(null), "distancia nula");
        assertThrows(IllegalArgumentException.class, () -> pedido.setDistancia(0.0), "distancia zero");
        assertThrows(IllegalArgumentException.class, () -> pedido.setDistancia(-1.0), "distancia negativa");
        assertThrows(IllegalArgumentException.class, () -> pedido.setDistancia(Double.NaN), "distancia NaN");
        assertThrows(IllegalArgumentException.class, () -> pedido.setDistancia(Double.POSITIVE_INFINITY), "distancia infinita");
        assertThrows(IllegalArgumentException.class, () -> pedido.setDistancia(Double.NEGATIVE_INFINITY), "distancia -infinita");

        assertThrows(IllegalArgumentException.class, () -> pedido.setCliente(null), "cliente nulo");
        assertThrows(IllegalArgumentException.class, () -> pedido.setEnderecoOrigem(null), "origem nula");
        assertThrows(IllegalArgumentException.class, () -> pedido.setEnderecoDestino(null), "destino nulo");

        assertThrows(IllegalArgumentException.class, () -> new Pedido(null, endereco("A"), endereco("B"), 1.0, 1.0), "pedido com cliente nulo");
        assertThrows(IllegalArgumentException.class, () -> new Pedido(cliente(), null, endereco("B"), 1.0, 1.0), "pedido com origem nula");
        assertThrows(IllegalArgumentException.class, () -> new Pedido(cliente(), endereco("A"), null, 1.0, 1.0), "pedido com destino nulo");

        assertThrows(IllegalArgumentException.class, () -> new EntregaConvencionalStrategy(-1.0), "tarifa negativa");
        assertThrows(IllegalArgumentException.class, () -> new EntregaConvencionalStrategy(Double.NaN), "tarifa NaN");
        assertThrows(IllegalArgumentException.class, () -> new EntregaConvencionalStrategy(Double.POSITIVE_INFINITY), "tarifa infinita");
        assertThrows(IllegalArgumentException.class, () -> new EntregaConvencionalStrategy(Double.NEGATIVE_INFINITY), "tarifa -infinita");
        assertEquals(0.0, new EntregaConvencionalStrategy(0.0).getTarifa(), "tarifa zero valida");

        assertThrows(IllegalArgumentException.class, () -> new EntregaExpressaStrategy(-1.0), "custo adicional negativo");
        assertThrows(IllegalArgumentException.class, () -> new EntregaExpressaStrategy(Double.NaN), "custo adicional NaN");
        assertThrows(IllegalArgumentException.class, () -> new EntregaExpressaStrategy(Double.POSITIVE_INFINITY), "custo adicional infinito");
        assertThrows(IllegalArgumentException.class, () -> new EntregaExpressaStrategy(Double.NEGATIVE_INFINITY), "custo adicional -infinito");
        assertEquals(0.0, new EntregaExpressaStrategy(0.0).getCustoAdic(), "custo adicional zero valido");

        assertThrows(IllegalArgumentException.class, () -> new EntregaEconomicaStrategy(-0.1, 1), "desconto negativo");
        assertThrows(IllegalArgumentException.class, () -> new EntregaEconomicaStrategy(1.1, 1), "desconto acima de 1");
        assertThrows(IllegalArgumentException.class, () -> new EntregaEconomicaStrategy(Double.NaN, 1), "desconto NaN");
        assertThrows(IllegalArgumentException.class, () -> new EntregaEconomicaStrategy(Double.POSITIVE_INFINITY, 1), "desconto infinito");
        assertThrows(IllegalArgumentException.class, () -> new EntregaEconomicaStrategy(Double.NEGATIVE_INFINITY, 1), "desconto -infinito");
        assertThrows(IllegalArgumentException.class, () -> new EntregaEconomicaStrategy(0.5, 0), "prioridade zero");
        assertThrows(IllegalArgumentException.class, () -> new EntregaEconomicaStrategy(0.5, -1), "prioridade negativa");

        assertThrows(IllegalArgumentException.class,
                () -> new EntregaConvencionalStrategy(1.0).calculaCusto(null), "pedido nulo no custo");
        assertThrows(IllegalArgumentException.class,
                () -> new EntregaExpressaStrategy(1.0).calculaPrazo(null), "pedido nulo no prazo");
        assertThrows(IllegalArgumentException.class,
                () -> new EntregaEconomicaStrategy(0.5, 1).estimaEntrega(null), "pedido nulo na estimativa");

        assertThrows(IllegalArgumentException.class, () -> new Cliente(null, "123", "999"), "nome nulo");
        assertThrows(IllegalArgumentException.class, () -> new Cliente(" ", "123", "999"), "nome vazio");
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Ana", null, "999"), "cpf nulo");
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Ana", "123", " "), "telefone vazio");

        assertThrows(IllegalArgumentException.class, () -> new Endereco(null, "1", "Centro", "00000-000"), "rua nula");
        assertThrows(IllegalArgumentException.class, () -> new Endereco("Rua", " ", "Centro", "00000-000"), "numero vazio");
        assertThrows(IllegalArgumentException.class, () -> new Endereco("Rua", "1", null, "00000-000"), "bairro nulo");
        assertThrows(IllegalArgumentException.class, () -> new Endereco("Rua", "1", "Centro", " "), "cep vazio");

        Cliente cliente = cliente();
        Endereco endereco = endereco("A");
        assertThrows(IllegalArgumentException.class, () -> cliente.setNome(null), "setNome nulo");
        assertThrows(IllegalArgumentException.class, () -> cliente.setCpf(null), "setCpf nulo");
        assertThrows(IllegalArgumentException.class, () -> cliente.setTelefone(null), "setTelefone nulo");
        assertThrows(IllegalArgumentException.class, () -> endereco.setRua(null), "setRua nulo");
        assertThrows(IllegalArgumentException.class, () -> endereco.setNumero(null), "setNumero nulo");
        assertThrows(IllegalArgumentException.class, () -> endereco.setBairro(null), "setBairro nulo");
        assertThrows(IllegalArgumentException.class, () -> endereco.setCep(null), "setCep nulo");
    }

    private static Pedido pedido(double peso, double distancia) {
        return new Pedido(cliente(), endereco("Origem"), endereco("Destino"), peso, distancia);
    }

    private static Cliente cliente() {
        return new Cliente("Ana", "12345678900", "999999999");
    }

    private static Endereco endereco(String rua) {
        return new Endereco(rua, "1", "Centro", "00000-000");
    }

    private static void assertSame(Object esperado, Object obtido, String mensagem) {
        if (esperado != obtido) {
            throw new AssertionError(mensagem + ": esperado mesma referencia, obtido " + obtido);
        }
    }

    private static void assertTrue(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }

    private static void assertEquals(double esperado, double obtido, String mensagem) {
        if (Math.abs(esperado - obtido) > 1e-9) {
            throw new AssertionError(mensagem + ": esperado " + esperado + ", obtido " + obtido);
        }
    }

    private static void assertEquals(int esperado, int obtido, String mensagem) {
        if (esperado != obtido) {
            throw new AssertionError(mensagem + ": esperado " + esperado + ", obtido " + obtido);
        }
    }

    private static void assertThrows(Class<? extends Throwable> tipo, Runnable acao, String mensagem) {
        try {
            acao.run();
        } catch (Throwable t) {
            if (tipo.isInstance(t)) {
                return;
            }
            throw new AssertionError(mensagem + ": lancou " + t.getClass().getSimpleName()
                    + " em vez de " + tipo.getSimpleName());
        }
        throw new AssertionError(mensagem + ": nenhuma excecao foi lancada");
    }
}
