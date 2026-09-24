public class Bootstrap {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("12345678900", Perfil.PREMIUM);
        Produto produto = new Produto(1, "Caderno", 12.50);
        Venda venda = new Venda(1, cliente);

        venda.adicionarItem(produto, 20);

        System.out.println("Desconto: " + venda.calcularDesconto());
        System.out.println("Total: " + venda.calcularTotal());
        System.out.println("Venda efetuada: " + venda.efetuarVenda());
    }
}
