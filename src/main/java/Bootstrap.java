public class Bootstrap {

    public static void main(String[] args) {
        Mercado mercado = new Mercado();

        mercado.addProduto(1, "Café", 10.0f);
        mercado.addProduto(2, "Açúcar", 5.0f);
        mercado.addProduto(3, "Leite", 2.5f);

        mercado.addCliente(1, "premium");
        mercado.addVenda(1, 1);

        mercado.addProdutoVenda(1, 1, 8);
        mercado.addProdutoVenda(1, 2, 6);
        mercado.addProdutoVenda(1, 3, 6);

        mercado.addPagamentoVenda(1, "cartao");
        boolean vendaFechada = mercado.fecharVenda(1);
        float total = mercado.totalVenda(1);

        System.out.println("Venda fechada: " + vendaFechada);
        System.out.printf("Total da venda: R$ %.2f%n", total);
    }
}
