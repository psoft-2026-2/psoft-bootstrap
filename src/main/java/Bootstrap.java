import model.Endereco;
import model.Papel;
import model.Pessoa;
import repository.PessoaRepository;

public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");

        PessoaRepository repository = new PessoaRepository();

        // create
        Pessoa pessoa = new Pessoa("Maria Silva", "12345678900", 30, "11999999999", "Engenheira", Papel.CLIENTE);
        pessoa.addEndereco(new Endereco("Rua A", "100", "Sao Paulo", "SP"));
        repository.create(pessoa);

        // read
        System.out.println("Todas as pessoas: " + repository.readAll());
        repository.readByCpf("12345678900").ifPresent(p -> System.out.println("Encontrada: " + p));

        // update (nome e cpf sao imutaveis)
        repository.readByCpf("12345678900").ifPresent(p -> {
            p.setTelefone("11888888888");
            p.setProfissao("Gerente de Projetos");
            p.setPapel(Papel.FUNCIONARIO);
            p.addEndereco(new Endereco("Rua B", "200", "Rio de Janeiro", "RJ"));
        });
        System.out.println("Apos atualizacao: " + repository.readByCpf("12345678900").get());

        // delete
        repository.delete("12345678900");
        System.out.println("Apos exclusao: " + repository.readAll());
    }
}
