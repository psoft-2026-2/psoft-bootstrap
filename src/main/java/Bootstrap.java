public class Bootstrap {
    public static void main(String[] args) {
        Item detergente = new Item("Detergente", "I01", 2.99);
        Item leite = new Item("Leite", "I02", 5.49);
        Item frango = new Item("Frango", "I03", 20.99);

        Customer c1 = new Customer("João");

        Customer c2 = new Customer("Maria");
        c2.upgradeSubscription();

        Sale venda1 = new Sale(c1);
        venda1.addItem(new ItemSale(leite, 4));
        venda1.addItem(new ItemSale(frango, 1));
        System.out.println("Total da venda de João: " + venda1.getFinalPrice());
        System.out.println("Status: " + venda1.getStatus());
        System.out.println();

        Sale venda2 = new Sale(c2);
        venda2.addItem(new ItemSale(detergente, 2));
        venda2.addItem(new ItemSale(frango, 3));
        System.out.println("Total da venda de Maria: " + venda2.getFinalPrice());
        System.out.println("Status: " + venda2.getStatus());
        System.out.println();

        venda1.pay();
        venda2.cancel();
        System.out.println("Status compra de João: " + venda1.getStatus());
        System.out.println("Status compra de Maria: " + venda2.getStatus());
    }
}