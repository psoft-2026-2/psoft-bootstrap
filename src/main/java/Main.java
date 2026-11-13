public class Main {

//OBS.: Gerei o main com LLM para testes
    public static void main(String[] args) {

        // Singleton: qualquer parte da aplicação obtém a mesma central
        CentralLogistica central = CentralLogistica.getInstancia();
        CentralLogistica outraReferencia = CentralLogistica.getInstancia();
        System.out.println("Mesma instância da central? " + (central == outraReferencia));
        System.out.println();

        // Strategy: modalidades disponíveis
        ModalidadeEntrega convencional = new ModConvencional(10.0, 1.5);
        ModalidadeEntrega expressa = new ModExpressa(10.0, 2.0, 25.0);
        ModalidadeEntrega economica = new ModEconomica(10.0, 1.5, 0.3, 5);

        Cliente ana = new Cliente("Ana", "111.111.111-11");
        Cliente bruno = new Cliente("Bruno", "222.222.222-22");

        central.registrarPedido(new Pedido(1, ana, "Campina Grande", "João Pessoa", 2.0, 130, convencional));
        central.registrarPedido(new Pedido(2, bruno, "Campina Grande", "Recife", 5.5, 190, expressa));
        central.registrarPedido(new Pedido(3, ana, "Campina Grande", "São Paulo", 1.2, 2600, economica));

        System.out.println("== Pedidos registrados ==");
        for (Pedido p : central.getPedidos()) {
            System.out.println(p);
        }
        System.out.println();

        // Comparando as modalidades para o mesmo pedido
        Pedido pedido1 = central.acompanharPedido(1);
        System.out.println("== Simulação do pedido #1 em cada modalidade ==");
        for (ModalidadeEntrega m : new ModalidadeEntrega[]{convencional, expressa, economica}) {
            System.out.printf("%-12s R$ %7.2f  |  %d dia(s)%n",
                    m.getNome(), m.calcularCusto(pedido1), m.calcularPrazo(pedido1));
        }
        System.out.println();

        // Alterar modalidade antes do despacho
        System.out.println("== Alterando o pedido #1 para Expressa ==");
        System.out.println("Alterou? " + central.alterarModalidade(1, expressa));
        System.out.println(central.acompanharPedido(1));
        System.out.println();

        // Após o despacho, a alteração não é mais permitida
        System.out.println("== Despachando o pedido #1 e tentando voltar para Convencional ==");
        System.out.println("Despachou? " + central.despacharPedido(1));
        System.out.println("Alterou? " + central.alterarModalidade(1, convencional));
        System.out.println(central.acompanharPedido(1));
        System.out.println();

        // Pedido inexistente
        System.out.println("== Acompanhando pedido inexistente (#99) ==");
        System.out.println(central.acompanharPedido(99));
    }
}
