import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bootstrap {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        PessoaService pessoaService = new PessoaService(pessoas);

        try {
            System.out.println("=== TESTANDO CREATE ===");
            pessoaService.createCliente("Davi", LocalDate.of(2002, 5, 27), "11122233344", "4005312367809900");
            pessoaService.createFuncionario("Maisa", LocalDate.of(2005, 1, 19), "55566677788", "Gerente");

            System.out.println("Total de pessoas cadastradas: " + pessoaService.getPessoas().size());

            System.out.println("\n=== TESTANDO READ ===");
            Pessoa pessoa1 = pessoaService.getPessoa(0);
            System.out.println("Pessoa no índice 0: " + pessoa1.getNome());
            System.out.println("Cartão do Cliente: " + ((Cliente) pessoa1).getCartao());

            Pessoa pessoa2 = pessoaService.getPessoa(1);
            System.out
                    .println("Pessoa no índice 1: " + pessoa2.getNome() + " (Idade: " + pessoa2.getIdade() + " anos)");
            System.out.println("Cargo: " + ((Funcionario) pessoa2).getCargo());

            System.out.println("\n=== TESTANDO UPDATE ===");
            System.out.println("Profissão de " + pessoa1.getNome() + " antes do update: " + pessoa1.getProfissao());
            System.out.println("Telefone de " + pessoa1.getNome() + " antes do update: "
                    + pessoa1.getTelefone());
            System.out.println("Idade de " + pessoa1.getNome() + " antes do update: " + pessoa1.getIdade());

            pessoaService.updateProfissaoPessoa(0, "Desenvolvedor Backend");
            pessoaService.updateIdadePessoa(0, LocalDate.of(2000, 5, 13));
            pessoaService.updateTelefonePessoa(0, "83977869033");

            Pessoa pessoaAtualizada = pessoaService.getPessoa(0);
            System.out.println("Idade após update: " + pessoaAtualizada.getIdade());
            System.out.println("Profissão após update: " + pessoaAtualizada.getProfissao());
            System.out.println("Telefone após update: " + pessoaAtualizada.getTelefone());

            System.out.println("\n=== TESTANDO DELETE ===");
            pessoaService.deletePessoa(1);

            System.out.println("Total de pessoas após delete: " + pessoaService.getPessoas().size());
            System.out.println("Única pessoa restante na lista: " + pessoaService.getPessoa(0).getNome());

        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante as operações do CRUD: " + e.getMessage());
        }
    }
}