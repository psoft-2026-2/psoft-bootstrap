public class Bootstrap {
    public static void main(String[] args) {
        Produto produto = new Produto("Arroz", 10.0);
        Cliente cliente = new Cliente("Cliente exemplo", Perfil.PREMIUM);
        Venda venda = new Venda(cliente);

        venda.adicionarItem(produto, 20);
        System.out.printf("Total com os descontos: R$ %.2f%n", venda.calcularTotal());

        venda.realizarPagamento(171.0);
        System.out.println("Pagamento realizado.");
    }
}
