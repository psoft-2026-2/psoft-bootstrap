import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Pessoa> pessoas = new HashMap<>();
        PessoaController controller = new PessoaController(pessoas);

        while (true) {
            System.out.println("\n=== CRUD de Pessoa ===");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Buscar pessoa por CPF");
            System.out.println("3 - Atualizar pessoa");
            System.out.println("4 - Remover pessoa");
            System.out.println("5 - Listar pessoas");
            System.out.println("6 - Adicionar endereço");
            System.out.println("7 - Ver endereços");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            try {
                switch (opcao) {
                    case "1":
                        cadastrarPessoa(scanner, controller);
                        break;
                    case "2":
                        buscarPessoa(scanner, controller);
                        break;
                    case "3":
                        atualizarPessoa(scanner, controller);
                        break;
                    case "4":
                        removerPessoa(scanner, controller);
                        break;
                    case "5":
                        listarPessoas(controller);
                        break;
                    case "6":
                        adicionarEndereco(scanner, controller);
                        break;
                    case "7":
                        verEnderecos(scanner, controller);
                        break;
                    case "0":
                        System.out.println("Encerrando...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void cadastrarPessoa(Scanner scanner, PessoaController controller) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Profissão: ");
        String profissao = scanner.nextLine();

        System.out.print("Papel (cliente/funcionario): ");
        String papel = scanner.nextLine();

        controller.addPessoa(nome, cpf, telefone, idade, profissao, new ArrayList<>(), papel);
        System.out.println("Pessoa cadastrada com sucesso.");
    }

    private static void buscarPessoa(Scanner scanner, PessoaController controller) {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Pessoa pessoa = controller.getPessoaByCpf(cpf);
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
        } else {
            System.out.println(pessoa);
        }
    }

    private static void atualizarPessoa(Scanner scanner, PessoaController controller) {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Nova idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Nova profissão: ");
        String profissao = scanner.nextLine();

        controller.updatePessoa(cpf, idade, telefone, profissao);
        System.out.println("Pessoa atualizada com sucesso.");
    }

    private static void removerPessoa(Scanner scanner, PessoaController controller) {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        controller.removePessoa(cpf);
        System.out.println("Pessoa removida com sucesso.");
    }

    private static void adicionarEndereco(Scanner scanner, PessoaController controller) {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Pessoa pessoa = controller.getPessoaByCpf(cpf);
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
            return;
        }

        System.out.print("Rua: ");
        String rua = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        pessoa.addEndereco(new Endereco(rua, cidade, estado, cep));
        System.out.println("Endereço adicionado com sucesso.");
    }

    private static void verEnderecos(Scanner scanner, PessoaController controller) {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Pessoa pessoa = controller.getPessoaByCpf(cpf);
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
            return;
        }

        List<Endereco> enderecos = pessoa.getEnderecos();
        if (enderecos.isEmpty()) {
            System.out.println("Nenhum endereço cadastrado.");
            return;
        }
        for (Endereco endereco : enderecos) {
            System.out.println(endereco);
        }
    }

    private static void listarPessoas(PessoaController controller) {
        List<Pessoa> pessoas = controller.getPessoas();
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + " - " + pessoa.getIdade());
        }
    }
}
