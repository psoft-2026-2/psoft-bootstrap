import java.util.Scanner;

public class Bootstrap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MERCADO");

        System.out.println("\nCadastro do Cliente");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Tipo de cliente (1 para Standard, 2 para Premium): ");
        int tipoCliente = scanner.nextInt();
        
        Cliente cliente;
        if (tipoCliente == 2) {
            cliente = new ClientePremium(nome, cpf);
            System.out.println("Cadastrado como cliente premium");
        } else {
            cliente = new ClienteStandard(nome, cpf);
            System.out.println("Cadastrado como cliente standard");
        }

        Venda venda = new Venda(cliente);
        System.out.println("\nAdicionando Produtos");
        boolean continuarComprando = true;
        
        while (continuarComprando) {
            scanner.nextLine();
            System.out.print("Nome do Produto: ");
            String descProduto = scanner.nextLine();
            System.out.print("Preço:");
            double precoProduto = scanner.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            
            Produto produto = new Produto(precoProduto, descProduto);
            venda.adicionarItem(produto, quantidade);
            
            System.out.print("Continuar adicionando (1 sim e 0 não):");
            int opcao = scanner.nextInt();
            if (opcao == 0) {
                continuarComprando = false;
            }
        }

        double totalDaVenda = venda.calcularTotal();
        System.out.printf("TOTAL A PAGAR: R$ %.2f\n", totalDaVenda);
        boolean pagamentoConcluido = false;
        while (!pagamentoConcluido) {
            System.out.print("Valor para pagar: ");
            double valorPago = scanner.nextDouble();
            
            try {
                venda.realizarPagamento(valorPago);
                pagamentoConcluido = true;
                
                double troco = valorPago - totalDaVenda;
                System.out.printf("Pagamento feito, troco: R$ %.2f\n", troco);
                
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: " + e.getMessage());
                System.out.println("Por favor, insira um valor válido.");
            } catch (IllegalStateException e) {
                System.out.println("ERRO: " + e.getMessage());
                break;
            }
        }
        
        System.out.println("\nObrigado pela compra");
        scanner.close();
    }
}