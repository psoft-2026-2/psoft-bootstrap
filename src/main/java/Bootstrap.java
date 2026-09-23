import mercado.Cliente;
import mercado.ItemDeVenda;
import mercado.Mercado;
import mercado.Pagamento;
import mercado.Produto;
import mercado.TipoCliente;
import mercado.Venda;

import java.util.Arrays;
import java.util.List;

public class Bootstrap {

    private static int total = 0;
    private static int falhas = 0;

    public static void main(String[] args) {
        System.out.println("Projeto de Software - testes do modulo mercado\n");

        testeSemDescontoQuantidadeSemDescontoPerfil();
        testeComDescontoQuantidadeClienteStandard();
        testeSemDescontoQuantidadeClientePremium();
        testeComDescontoQuantidadeEComDescontoPremium();
        testeCrudDeMercado();

        System.out.println("\n----------------------------------------");
        System.out.println(total + " teste(s) executado(s), " + falhas + " falha(s).");
        if (falhas == 0) {
            System.out.println("Tudo certo!");
        }
    }

    // menos de 20 unidades, cliente standard -> sem desconto
    private static void testeSemDescontoQuantidadeSemDescontoPerfil() {
        Produto produto = new Produto("P1", 10.0f);
        ItemDeVenda item = new ItemDeVenda(5, produto); // 5 * 10 = 50, sem desconto
        Cliente cliente = new Cliente("Joao", "111.111.111-11", "83999990000", TipoCliente.STANDARD);

        Venda venda = new Venda("V1", Arrays.asList(item), cliente);

        checar("Item sem desconto de quantidade", !item.recebeDesconto());
        checar("Subtotal do item (5 x 10, sem desconto) = 50.0", proximo(item.getSubtotal(), 50.0f));
        checar("Cliente standard nao recebe desconto de perfil", !venda.recebeDescontoCliente());
        checar("Total da venda (sem nenhum desconto) = 50.0", proximo(venda.getTotal(), 50.0f));
    }

    // 20+ unidades (desconto de 10%), cliente standard
    private static void testeComDescontoQuantidadeClienteStandard() {
        Produto produto = new Produto("P2", 10.0f);
        ItemDeVenda item = new ItemDeVenda(20, produto); // 20 * 10 = 200, com 10% -> 180
        Cliente cliente = new Cliente("Maria", "222.222.222-22", "83988880000", TipoCliente.STANDARD);

        Venda venda = new Venda("V2", Arrays.asList(item), cliente);

        checar("Item com 20 unidades recebe desconto de quantidade", item.recebeDesconto());
        checar("Subtotal do item (20 x 10, com 10%) = 180.0", proximo(item.getSubtotal(), 180.0f));
        checar("Total da venda (so desconto de quantidade) = 180.0", proximo(venda.getTotal(), 180.0f));
    }

    // menos de 20 unidades, cliente premium -> desconto de perfil
    private static void testeSemDescontoQuantidadeClientePremium() {
        Produto produto = new Produto("P3", 100.0f);
        ItemDeVenda item = new ItemDeVenda(2, produto); // 2 * 100 = 200, sem desconto de qtd
        Cliente cliente = new Cliente("Ana", "333.333.333-33", "83977770000", TipoCliente.PREMIUM);

        Venda venda = new Venda("V3", Arrays.asList(item), cliente);

        checar("Cliente premium recebe desconto de perfil", venda.recebeDescontoCliente());
        checar("Total da venda (200 com 5% de desconto) = 190.0", proximo(venda.getTotal(), 190.0f));
    }

    // 20+ unidades e cliente premium -> os dois descontos se acumulam
    private static void testeComDescontoQuantidadeEComDescontoPremium() {
        Produto produto = new Produto("P4", 10.0f);
        ItemDeVenda item = new ItemDeVenda(20, produto); // 200 -> 10% -> 180
        Cliente cliente = new Cliente("Pedro", "444.444.444-44", "83966660000", TipoCliente.PREMIUM);

        Venda venda = new Venda("V4", Arrays.asList(item), cliente);
        venda.efetuarPagamento(new Pagamento(venda.getTotal(), "PIX"));

        // 180 com mais 5% de desconto = 171.0
        checar("Total da venda (10% + 5% acumulados) = 171.0", proximo(venda.getTotal(), 171.0f));
        checar("Pagamento foi registrado", venda.getPagamento() != null);
        checar("Valor do pagamento bate com o total", proximo(venda.getPagamento().getValor(), venda.getTotal()));
    }

    // operacoes de CRUD do Mercado (produto, cliente, venda)
    private static void testeCrudDeMercado() {
        Mercado mercado = new Mercado();

        Produto produto = mercado.adicionarProduto("COD1", 25.0f);
        checar("Produto foi adicionado e pode ser consultado", mercado.consultarProduto("COD1") == produto);

        mercado.editarProduto("COD1", 30.0f);
        checar("Produto foi editado (novo preco = 30.0)", proximo(mercado.consultarProduto("COD1").getPreco(), 30.0f));

        Cliente cliente = mercado.adicionarCliente("Carla", "555.555.555-55", "83955550000", TipoCliente.STANDARD);
        checar("Cliente foi adicionado e pode ser consultado", mercado.consultarCliente("555.555.555-55") == cliente);

        mercado.editarCliente("555.555.555-55", "Carla Souza", "83955551111", TipoCliente.PREMIUM);
        checar("Cliente foi editado (agora premium)",
                mercado.consultarCliente("555.555.555-55").getTipo() == TipoCliente.PREMIUM);

        List<ItemDeVenda> itens = Arrays.asList(new ItemDeVenda(3, produto)); // 3 * 30 = 90, sem desc qtd
        Venda venda = mercado.criarVenda(itens, cliente, new Pagamento(0f, "CARTAO"));
        checar("Venda foi criada e pode ser consultada", mercado.consultarVenda(venda.getIdVenda()) == venda);
        // 90 com 5% (cliente agora premium) = 85.5
        checar("Total da venda criada via Mercado = 85.5", proximo(venda.getTotal(), 85.5f));

        mercado.cancelarVenda(venda.getIdVenda());
        checar("Venda cancelada nao aparece mais na consulta", mercado.consultarVenda(venda.getIdVenda()) == null);

        mercado.removerCliente("555.555.555-55");
        checar("Cliente removido nao aparece mais na consulta", mercado.consultarCliente("555.555.555-55") == null);

        mercado.removerProduto("COD1");
        checar("Produto removido nao aparece mais na consulta", mercado.consultarProduto("COD1") == null);
    }


    private static boolean proximo(float a, float b) {
        return Math.abs(a - b) < 0.001f;
    }

    private static void checar(String descricao, boolean condicao) {
        total++;
        if (condicao) {
            System.out.println("[PASSOU] " + descricao);
        } else {
            falhas++;
            System.out.println("[FALHOU] " + descricao);
        }
    }
}