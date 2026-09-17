import java.util.Arrays;
public class Bootstrap {

    public static void main(String[] args) {

        PessoaRepository repository = new PessoaRepository();

        Pessoa pessoa = new Pessoa(
                "Camila",
                "23",
                "123456789",
                "999999999",
                "Rua Joao da Silva",
                "Estudante"
        );

        pessoa.adicionarEndereco("Rua Joao da Silva");

        repository.cadastrar(pessoa);

        System.out.println("Pessoa cadastrada:");
        System.out.println(pessoa);

        Pessoa encontrada = repository.buscar("123456789");

        System.out.println("\nPessoa encontrada:");
        System.out.println(encontrada);

        repository.atualizar(
                "123456789",
                "24",
                "888888888",
                Arrays.asList("Rua Maria Rita", "Rua Maria Helena"),
                "Programadora"
        );

        System.out.println("\nPessoa após atualização:");
        System.out.println(repository.buscar("123456789"));

        repository.remover("123456789");

        System.out.println("\nPessoa após remoção:");
        System.out.println(repository.buscar("123456789"));

        pessoa.setPapel(Papel.CLIENTE);

        System.out.println("Papel atual: " + pessoa.getPapel());

        pessoa.setPapel(Papel.FUNCIONARIO);

        System.out.println("Novo papel: " + pessoa.getPapel());
    }
}
