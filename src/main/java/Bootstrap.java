import java.util.Scanner;

public class Bootstrap {

    public static SistemaCrudPessoa sistema = new SistemaCrudPessoa();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            exibeOpcoes();
            String input = scanner.nextLine();

            switch (input) {

                case "1":
                    cadastraPessoa();
                    break;
                case "2":
                    adicionaEndereco();
                    break;
                case "3":
                    removeEndereco();
                    break;
                case "4":
                    removeUsuario();
                    break;
                case "5":
                    System.out.println(sistema.listaUsuarios());
                    break;
                case "6":
                    buscaUsuario();
                    break;
                case "7":
                    adicionaCompra();
                    break;
                case "8":
                    buscaCompra();
                    break;
                case "9":
                    incrementaVendas();
                    break;
                case "10":
                    definirSalario();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida! Tenta denovo ai");

            }

            System.out.print("Pressione Enter para continuar...");
            scanner.nextLine();
            limpaTela();

        }

    }

    public static void cadastraPessoa() {
        System.out.print("Tipo (cliente/funcionario): ");
        String tipo = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Profissao: ");
        String profissao = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        boolean sucesso;

        if (tipo.equals("funcionario")) {
            System.out.print("Salario: ");
            double salario = Double.parseDouble(scanner.nextLine());
            sucesso = sistema.addFuncionario(nome, cpf, telefone, profissao, idade, salario);
        } else {
            sucesso = sistema.addCliente(nome, cpf, telefone, profissao, idade);
        }

        mostraResultado(sucesso, "Cadastrado com sucesso", "Falha ao cadastrar");
    }

    public static void adicionaEndereco() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        mostraResultado(sistema.addEndereco(cpf, endereco), "Endereco adicionado", "Falha ao adicionar endereco");
    }

    public static void removeEndereco() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        mostraResultado(sistema.removeEndereco(cpf, endereco), "Endereco removido", "Falha ao remover endereco");
    }

    public static void removeUsuario() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        mostraResultado(sistema.removeUsuario(cpf), "Usuario removido", "Falha ao remover usuario");
    }

    public static void buscaUsuario() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        String usuario = sistema.listaUsuario(cpf);
        System.out.println(usuario != null ? usuario : "Usuario nao encontrado");
    }

    public static void adicionaCompra() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Id da compra: ");
        String id = scanner.nextLine();

        System.out.print("Compra: ");
        String compra = scanner.nextLine();

        mostraResultado(sistema.addCompra(cpf, id, compra), "Compra adicionada", "Falha ao adicionar compra");
    }

    public static void buscaCompra() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Id da compra: ");
        String id = scanner.nextLine();

        String compra = sistema.getCompra(cpf, id);
        System.out.println(compra != null ? compra : "Compra nao encontrada");
    }

    public static void incrementaVendas() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = Double.parseDouble(scanner.nextLine());

        mostraResultado(sistema.incrementaVendas(cpf, valor), "Vendas incrementadas", "Falha ao incrementar vendas");
    }

    public static void definirSalario() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = Double.parseDouble(scanner.nextLine());

        mostraResultado(sistema.setSalario(cpf, salario), "Salario atualizado", "Falha ao atualizar salario");
    }

    public static void exibeOpcoes() {
        System.out.println("1 - Cadastrar pessoa");
        System.out.println("2 - Adicionar endereco");
        System.out.println("3 - Remover endereco");
        System.out.println("4 - Remover usuario");
        System.out.println("5 - Listar usuarios");
        System.out.println("6 - Buscar usuario");
        System.out.println("7 - Adicionar compra (cliente)");
        System.out.println("8 - Buscar compra (cliente)");
        System.out.println("9 - Incrementar vendas (funcionario)");
        System.out.println("10 - Definir salario (funcionario)");
        System.out.println("0 - Sair");
    }

    public static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mostraResultado(boolean sucesso, String msgSucesso, String msgFalha) {
        System.out.println(sucesso ? msgSucesso : msgFalha);
    }
}
