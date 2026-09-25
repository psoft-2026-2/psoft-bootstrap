public class Bootstrap {

    public static void main(String[] args) {

        Produto arroz = new Produto("Arroz", 10.00);
        Produto feijao = new Produto("Feijão", 8.00);

        Cliente cliente = new Cliente("Carlos", Assinatura.PREMIUM);

        Venda venda = cliente.realizarVenda();

        ItemVenda itemArroz = venda.criarItemVenda(arroz, 20);
        ItemVenda itemFeijao = venda.criarItemVenda(feijao, 5);

        venda.adicionarItemVenda(itemArroz);
        venda.adicionarItemVenda(itemFeijao);

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Assinatura: " + cliente.getAssinatura());

        System.out.println("Subtotal: R$ " + venda.calcularSubtotal());
        System.out.println("Total: R$ " + venda.calcularTotal());

        venda.atribuirDescontoVenda();

        System.out.println("Forma de pagamento: "
                + venda.getPagamento().getForma());
    }
}