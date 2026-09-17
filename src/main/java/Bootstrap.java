import java.util.ArrayList;
import java.util.List;

public class Bootstrap {

    private static List<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "Carlos",
                20,
                "12345678900",
                "99999-9999",
                new ArrayList<>(),
                "Programador"
        );

        criar(cliente);

        cliente.getEndereco().add("Rua A, 100");
        cliente.getEndereco().add("Rua B, 200");

        listar();

        atualizar(
                "12345678900",
                21,
                "88888-8888",
                cliente.getEndereco(),
                "Desenvolvedor"
        );

        listar();
        remover("12345678900");
        listar();
    }

    public static void criar(Pessoa pessoa) {

        if (buscar(pessoa.getCpf()) != null) {
            System.out.println("CPF já cadastrado.");
            return;
        }
        pessoas.add(pessoa);
        System.out.println("Pessoa cadastrada com sucesso.");
    }

    public static Pessoa buscar(String cpf) {

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        return null;
    }

    public static void listar() {

        for (Pessoa pessoa : pessoas) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println("CPF: " + pessoa.getCpf());
            System.out.println("Telefone: " + pessoa.getTelefone());
            System.out.println("Profissão: " + pessoa.getProfissao());

            System.out.println("Endereços:");

            for (String endereco : pessoa.getEndereco()) {
                System.out.println("- " + endereco);
            }

            System.out.println();
        }
    }

    public static void atualizar(String cpf, int idade, String telefone,
                                  List<String> endereco, String profissao) {

        Pessoa pessoa = buscar(cpf);

        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
            return;
        }

        pessoa.setIdade(idade);
        pessoa.setTelefone(telefone);
        pessoa.setEndereco(endereco);
        pessoa.setProfissao(profissao);

        System.out.println("Pessoa atualizada com sucesso.");
    }

    public static void remover(String cpf) {

        Pessoa pessoa = buscar(cpf);

        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
            return;
        }

        pessoas.remove(pessoa);
        System.out.println("Pessoa removida com sucesso.");
    }
}
