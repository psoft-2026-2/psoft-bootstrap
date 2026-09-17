import controller.PessoaController;
import model.Cliente;
import model.Funcionario;
import model.Pessoa;

public class Main {

    public static void main(String[] args) {
        PessoaController controller = new PessoaController();

        Cliente cliente = new Cliente("Maria Silva", "111.111.111-11", 28, "83999990000", "Advogada");
        cliente.adicionarEndereco("Rua das Flores, 123 - Centro, Campina Grande/PB - 58400-000");
        cliente.adicionarCartao("**** **** **** 1234");
        controller.criar(cliente);

        Funcionario funcionario = new Funcionario("João Souza", "222.222.222-22", 35, "83988887777",
                "Analista de Sistemas", "F001", "Analista Pleno", 4500.00);
        funcionario.adicionarEndereco("Av. Central, 45 - Catolé, Campina Grande/PB - 58410-000");
        controller.criar(funcionario);

        System.out.println("=== Todas as pessoas ===");
        for (Pessoa p : controller.listarTodos()) {
            System.out.println(p);
        }

        System.out.println("\n=== Buscando pelo CPF 111.111.111-11 ===");
        controller.buscarPorCpf("111.111.111-11").ifPresent(System.out::println);


        System.out.println("\n=== Atualizando telefone e profissão de Maria ===");
        controller.atualizar("111.111.111-11", 29, "83977776666", "Advogada Sênior");
        controller.buscarPorCpf("111.111.111-11").ifPresent(System.out::println);

        System.out.println("\n=== Removendo João ===");
        boolean removido = controller.deletar("222.222.222-22");
        System.out.println("Removido? " + removido);

        System.out.println("\n=== Lista final ===");
        for (Pessoa p : controller.listarTodos()) {
            System.out.println(p);
        }
    }
}
