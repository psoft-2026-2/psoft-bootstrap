package atividade05;

public class Main {
    public static void main(String[] args) {
        Central central = new Central();

        // Criando as estratégias de entrega[cite: 4]
        EstrategiaEntrega convencional = new EntregaConvencional(10.0);
        EstrategiaEntrega expressa = new EntregaExpressa(25.0);
        EstrategiaEntrega economica = new EntregaEconomica(15);

        // Criando pedidos[cite: 4]
        Pedido p1 = new Pedido("Lucas Ricardo", "Campina Grande", "João Pessoa", 4.0, 120.0, convencional);
        Pedido p2 = new Pedido("Maria Silva", "Recife", "Natal", 2.5, 290.0, economica);

        // Registrando na central[cite: 4]
        central.adicionarPedido(p1);
        central.adicionarPedido(p2);

        // Alterando a modalidade antes de despachar[cite: 4]
        p1.setModalidade(expressa);

        // Processando todas as operações
        central.processarEntregas();

        // Consultando todos os logs acumulados no Singleton
        Logger.getInstancia().exibirHistorico();
    }
    
}
