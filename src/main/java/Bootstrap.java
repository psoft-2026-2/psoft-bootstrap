public class Bootstrap {
    public static void main(String[] args) {
        Mercado mercado = new Mercado();
        
        mercado.cadastrarCliente("111", Perfil.PREMIUM);
        int idVenda = mercado.criarVenda("111");
        
        mercado.adicionarItem(idVenda, new Produto("Arroz", 20.0f), 25); 
        mercado.adicionarItem(idVenda, new Produto("Feijão", 8.0f), 5);
        
        System.out.println(mercado.processarPagamento(idVenda, "PIX"));
    }
}