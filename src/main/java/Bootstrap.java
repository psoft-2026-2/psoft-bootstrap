public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");

        PessoaService service = new PessoaService();

        Endereco end1 = new Endereco("Rua das Flores", "123", "Campina Grande", "PB");
        Pessoa pessoa1 = new Pessoa("Maria Silva", 30, "12345678900", "83999999999", "Engenheira", "cliente");
        pessoa1.adicionarEndereco(end1);
        service.criarPessoa(pessoa1);

        Pessoa pessoa2 = new Pessoa("João Souza", 25, "98765432100", "83988888888", "Professor", "funcionario");
        service.criarPessoa(pessoa2);

        System.out.println("\n=== Listando pessoas ===");
        for (Pessoa p : service.listarPessoas()) {
            System.out.println(p);
        }

        System.out.println("\n=== Buscando por CPF ===");
        System.out.println(service.buscarPorCpf("12345678900"));

        System.out.println("\n=== Atualizando pessoa ===");
        service.atualizarPessoa("12345678900", 31, "83977777777", "Engenheira Sênior", "funcionario");
        System.out.println(service.buscarPorCpf("12345678900"));

        Endereco end2 = new Endereco("Av. Central", "500", "Campina Grande", "PB");
        service.adicionarEnderecoAPessoa("12345678900", end2);
        System.out.println("Endereços de Maria: " + service.buscarPorCpf("12345678900").getEnderecos());

        System.out.println("\n=== Deletando pessoa ===");
        boolean deletou = service.deletarPessoa("98765432100");
        System.out.println("João foi deletado? " + deletou);

        System.out.println("\n=== Lista final ===");
        for (Pessoa p : service.listarPessoas()) {
            System.out.println(p);
        }
    }
}