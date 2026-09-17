public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");
        
        Profissao dev = new Profissao("dev");
        dev.adicionarResponsabilidade("Desenvolver Api's");
        dev.adicionarResponsabilidade("apertar botoes");

        Funcionario funcionario = new Funcionario(
                "123.456.789-00",
                "83999999999",
                "Davi",
                dev,
                3500.00f
        );

        Endereco endereco = new Endereco(
                "Rua nao sei o que",
                "Bairro nao sei o que",
                100
        );

        funcionario.adicionarEndereco(endereco);

        System.out.println(funcionario.getNome());
        System.out.println(funcionario.getProfissao().getCargo());
        System.out.println(funcionario.getSalario());
        
    }
}
