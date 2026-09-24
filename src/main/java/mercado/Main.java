package mercado;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria", Perfil.PREMIUM);

        Produto arroz = new Produto("001", "Arroz 5kg", 25.0);
        Produto feijao = new Produto("002", "Feijão 1kg", 8.0);

        Venda venda = new Venda(cliente);
        venda.adicionarItem(arroz, 25);
        venda.adicionarItem(feijao, 5);

        double total = venda.calcularTotal();
        System.out.printf("Valor total da venda: R$ %.2f%n", total);

        venda.realizarPagamento(total);
        System.out.println("Pagamento realizado.");
    }
}
