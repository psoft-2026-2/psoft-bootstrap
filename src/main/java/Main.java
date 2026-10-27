public class Main {
    public static void main(String[] args) {
        Produto bolo = new Produto("Bolo", 10.0f, 1);
        Produto cha = new Produto("Chá", 20.0f, 2);
        Produto cafe = new Produto("Café", 5.0f, 3);
        Usuario usuario = new Usuario("Remilia", Assinatura.PREMIUN, 1);
        Carrinho carrinho = new Carrinho(1, usuario);

        // bolo 3 unidades
        for (int i = 0; i < 3; i++) {
            carrinho.Add_Item(bolo.getId());
        }

        // cha 22 unidades
        for (int i = 0; i < 22; i++) {
            carrinho.Add_Item(cha.getId());
        }

        // cafe 20 unidades
        for (int i = 0; i < 20; i++) {
            carrinho.Add_Item(cafe.getId());
        }
    
        float valorBruto = carrinho.Calc_Total();
        float valorFinal = carrinho.Calc_Desconto();
        System.out.println("===== CARRINHO =====");
        System.out.println("Valor bruto: R$ " + valorBruto);
        System.out.println("Valor com desconto: R$ " + valorFinal);
        System.out.println("Economia: R$ " + (valorBruto - valorFinal));

        // Gera a compra
        Compra compra = carrinho.Gera_Compra();
        System.out.println("\n===== COMPRA =====");
        System.out.println("Valor: R$ " + compra.getValor());
        System.out.println("Desconto: R$ " + compra.getDesconto());

        // Gera o pagamento
        Pagamento pagamento = compra.Gera_Pagamento();
        System.out.println("\n===== PAGAMENTO =====");
        System.out.println("Valor a pagar: R$ " + pagamento.getValor());
        System.out.println("Status: " + pagamento.getStatus());
    }
}