package br.ufcg.psoft.atv5;

public class Main {
    public static void main(String[] args) {
        CentralLogistica central = CentralLogistica.getInstancia();

        Cliente cliente = new Cliente("Maria Silva", "123.456.789-00");
        Endereco origem = new Endereco("Rua das Flores, 100", "Campina Grande", "58400-000");
        Endereco destino = new Endereco("Av. Brasil, 500", "João Pessoa", "58000-000");

        Pedido pedido = new Pedido(cliente, origem, destino, 2.5, 130, new EntregaConvencional());
        central.registrarPedido(pedido);

        System.out.println("== Pedido registrado (convencional) ==");
        central.acompanharPedido();

        // Troca de modalidade antes do despacho
        pedido.alterarModalidade(new EntregaExpressa());
        System.out.println("\n== Modalidade alterada para expressa ==");
        central.acompanharPedido();

        // Despacho
        pedido.despachar();
        System.out.println("\n== Pedido despachado ==");
        central.acompanharPedido();

        // Tentativa inválida: alterar após despacho
        try {
            pedido.alterarModalidade(new EntregaEconomica());
        } catch (IllegalStateException e) {
            System.out.println("\nErro esperado: " + e.getMessage());
        }

        // Singleton: mesma instância em qualquer parte da aplicação
        System.out.println("Mesma instância? " + (central == CentralLogistica.getInstancia()));
    }
}
