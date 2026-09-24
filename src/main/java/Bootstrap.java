public class Bootstrap {

   public static void main(String[] args) {
        Item arroz = new Item("Arroz 5kg", 30.00);
        Item leite = new Item("Leite 1L", 5.00);


        Cliente cliente = new Cliente("Maria Silva","07854545215", Status.premium);

        Venda venda = new Venda(cliente);

        venda.adicionarItem(leite, 25); 
        venda.adicionarItem(arroz, 2);   

        Double valorTotal = venda.total();

        venda.fazerPagamento("Cartão de Crédito", valorTotal);

        System.out.println("=== COMPROVATIVO DE VENDA ===");
        System.out.println("Cliente: " + venda.mostraCliente());
        System.out.println("\nItens comprados:\n" + venda.mostraItem());
        System.out.printf("Valor Total: R$ %.2f\n", valorTotal);
        System.out.println("------------------------------");
        System.out.println("Pagamento efetuado via " + venda.getPagamento().getFormaDePagamento() + 
                           " no valor de R$ " + String.format("%.2f", venda.getPagamento().getValorApagar()));
    }

}
