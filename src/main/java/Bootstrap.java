public class Bootstrap {

    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz", 5.00);
        Produto feijao = new Produto("Feijão", 8.00);

        Cliente ana = new Cliente("Ana", "111.111.111-11", PerfilAssinatura.STANDARD);
        Cliente bruno = new Cliente("Bruno", "222.222.222-22", PerfilAssinatura.PREMIUM);

        System.out.println("1) Cliente standard, sem desconto por quantidade");
        Venda venda1 = new Venda(ana);
        venda1.addItem(arroz, 10);
        venda1.addItem(feijao, 2);
        venda1.pagar(FormaPagamento.DINHEIRO);
        imprimir(venda1);

        System.out.println("2) Cliente standard, item com 20 unidades (10% no item)");
        Venda venda2 = new Venda(ana);
        venda2.addItem(arroz, 20);
        venda2.addItem(feijao, 2);
        venda2.pagar(FormaPagamento.PIX);
        imprimir(venda2);

        System.out.println("3) Cliente premium, mesma compra (5% a mais no total)");
        Venda venda3 = new Venda(bruno);
        venda3.addItem(arroz, 20);
        venda3.addItem(feijao, 2);
        venda3.pagar(FormaPagamento.CARTAO);
        imprimir(venda3);

        System.out.println("4) Cliente muda de standard para premium");
        ana.setPerfil(PerfilAssinatura.PREMIUM);
        Venda venda4 = new Venda(ana);
        venda4.addItem(feijao, 5);
        venda4.pagar(FormaPagamento.PIX);
        imprimir(venda4);

        System.out.println("5) Regras de validação");
        testar("Produto com preço negativo", () -> new Produto("Leite", -1));
        testar("Item com quantidade zero", () -> new Venda(bruno).addItem(arroz, 0));
        testar("Pagar venda sem itens", () -> new Venda(bruno).pagar(FormaPagamento.PIX));
        testar("Pagar venda já paga", () -> venda1.pagar(FormaPagamento.PIX));
        testar("Adicionar item em venda paga", () -> venda1.addItem(arroz, 1));
    }

    private static void imprimir(Venda venda) {
        Cliente cliente = venda.getCliente();
        System.out.printf("   Cliente: %s (%s)%n", cliente.getNome(), cliente.getPerfil());
        for (ItemVenda item : venda.getItens()) {
            System.out.printf("   %-8s x%-3d R$ %7.2f%n",
                    item.getProduto().getNome(), item.getQuantidade(), item.getSubtotal());
        }
        System.out.printf("   Subtotal: R$ %.2f | Total: R$ %.2f%n", venda.getSubtotal(), venda.getTotal());
        Pagamento pagamento = venda.getPagamento();
        System.out.printf("   Pago: %s | R$ %.2f via %s%n%n", venda.isPago(), pagamento.getValor(), pagamento.getForma());
    }

    private static void testar(String descricao, Runnable acao) {
        try {
            acao.run();
            System.out.printf("   [FALHOU] %s: nenhuma exceção lançada%n", descricao);
        } catch (RuntimeException e) {
            System.out.printf("   [OK] %s: %s%n", descricao, e.getMessage());
        }
    }
}
