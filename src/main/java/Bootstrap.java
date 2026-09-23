public class Bootstrap {

    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz", 5.00);
        Produto feijao = new Produto("Feijão", 8.00);

        Cliente ana = new Cliente("Ana", "111.111.111-11", PerfilAssinatura.STANDARD);
        Cliente bruno = new Cliente("Bruno", "222.222.222-22", PerfilAssinatura.PREMIUM);

        // Cliente standard: 20 arroz (com 10% de desconto no item) + 2 feijão
        Venda venda1 = new Venda(ana);
        venda1.addItem(arroz, 20);  // 100,00 -> 90,00
        venda1.addItem(feijao, 2);  // 16,00
        venda1.pagar(FormaPagamento.PIX); // total 106,00
        imprimir(venda1);

        // Cliente premium: mesma compra com 5% adicional no total
        Venda venda2 = new Venda(bruno);
        venda2.addItem(arroz, 20);
        venda2.addItem(feijao, 2);
        venda2.pagar(FormaPagamento.CARTAO); // 106,00 * 0,95 = 100,70
        imprimir(venda2);
    }

    private static void imprimir(Venda venda) {
        System.out.printf("Cliente: %s (%s)%n", venda.getCliente().getNome(), venda.getCliente().getPerfil());
        for (ItemVenda item : venda.getItens()) {
            System.out.printf("  %-8s x%-3d R$ %8.2f%n",
                    item.getProduto().getNome(), item.getQuantidade(), item.getSubtotal());
        }
        System.out.printf("  Subtotal: R$ %.2f | Total: R$ %.2f%n", venda.getSubtotal(), venda.getTotal());
        Pagamento pagamento = venda.getPagamento();
        System.out.printf("  Pagamento de R$ %.2f realizado via %s%n", pagamento.getValor(), pagamento.getForma());
        System.out.println();
    }
}
