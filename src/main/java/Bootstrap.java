public class Bootstrap {

    public static void main(String[] args) {
        Mercado mercado = new Mercado("Mercado Central");

        Produto arroz = new Produto("Arroz 5kg", 25.0);
        Produto feijao = new Produto("Feijão 1kg", 8.0);
        mercado.addProduto(arroz);
        mercado.addProduto(feijao);

        Cliente clientePremium = new Cliente("Ana Souza", "111.111.111-11", Ass.PREMIUM);
        Cliente clienteStandard = new Cliente("João Lima", "222.222.222-22", Ass.STANDARD);

        Venda venda1 = new Venda(clientePremium);
        venda1.addItemVenda(arroz, 20);
        mercado.addVenda(venda1);

        System.out.println("Venda 1 (premium, 20 unidades de arroz)");
        System.out.printf("Subtotal itens: %.2f%n", venda1.getSubtotalItens());
        System.out.printf("Valor total (com desconto premium): %.2f%n", venda1.getValorTotal());
        venda1.realizarPagamento(FormaPag.PIX);
        System.out.println("Status do pagamento: " + venda1.getPagamento().getStatus());

        Venda venda2 = new Venda(clienteStandard);
        venda2.addItemVenda(feijao, 3);
        mercado.addVenda(venda2);

        System.out.println();
        System.out.println("Venda 2 (standard, 3 unidades de feijão)");
        System.out.printf("Valor total (sem desconto): %.2f%n", venda2.getValorTotal());
        venda2.realizarPagamento(FormaPag.CARTAO_CREDITO);

        System.out.println();
        System.out.println("Total de vendas registradas no mercado: " + mercado.getVendas().size());
    }
}