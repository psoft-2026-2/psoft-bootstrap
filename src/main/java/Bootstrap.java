public class Bootstrap {

    public static void main(String[] args) {
        Mercado mercado = new Mercado();

        Produto arroz = new Produto("P1", "Arroz 5kg", 25.00);
        mercado.cadastrarProduto(arroz);

        Cliente ana = new Cliente("C1", "Ana", PerfilAssinatura.PREMIUM);
        mercado.cadastrarCliente(ana);

        Venda venda = mercado.novaVenda(ana);
        venda.adicionarItem(arroz, 25); // 25 >= 20 -> 10% de desconto no item

        double totalBruto = venda.calcularTotalBruto();
        double desconto = venda.calcularDescontoPremium();
        double totalFinal = venda.calcularTotalFinal();

        System.out.printf("Total bruto: R$ %.2f%n", totalBruto);
        System.out.printf("Desconto premium: R$ %.2f%n", desconto);
        System.out.printf("Total final: R$ %.2f%n", totalFinal);

        Pagamento pagamento = new Pagamento(totalFinal, 600.00);
        System.out.printf("Pagamento aprovado? %b | Troco: R$ %.2f%n",
                pagamento.processar(), pagamento.calcularTroco());
    }
}