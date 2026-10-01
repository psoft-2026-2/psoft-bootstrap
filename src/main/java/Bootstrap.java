import java.time.LocalDate;
import java.util.stream.Collectors;

public class Bootstrap {
    public static void main(String[] args) {
        Funcionario productOwner = new Funcionario("Carla", new PapelProductOwner());
        Empresa empresa = new Empresa("Empresa de Tecnologia", productOwner);
        Funcionario gerente = new Funcionario("Marcos", new PapelGerente());
        Produto produto = new Produto("Sistema de vendas", "Gestão de vendas e estoque.");
        Time time = new Time("Time Vendas", produto, gerente);
        empresa.adicionarProduto(produto);

        Funcionario ana = new Funcionario("Ana");
        Funcionario bruno = new Funcionario("Bruno");
        time.adicionarDesenvolvedor(ana);
        time.adicionarDesenvolvedor(bruno);

        Sprint primeira = time.iniciarSprint(1, LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 14), ana);
        System.out.println("Sprint " + primeira.getNumero() + " — líder: " + primeira.getLider().getNome());
        mostrarPapeis(ana);

        Sprint segunda = time.iniciarSprint(2, LocalDate.of(2026, 9, 15),
                LocalDate.of(2026, 9, 28), bruno);
        System.out.println("Sprint " + segunda.getNumero() + " — líder: " + segunda.getLider().getNome());
        mostrarPapeis(ana);
        mostrarPapeis(bruno);
        segunda.encerrar();

        ana.promover(new PromocaoGerente());
        gerente.promover(new PromocaoProductOwner());
        empresa.definirProductOwner(gerente);

        System.out.println("\nApós as promoções:");
        mostrarPapeis(ana);
        mostrarPapeis(gerente);
        System.out.println("Gerente do produto: " + produto.getGerente().getNome());
        System.out.println("Product Owner da empresa: " + empresa.getProductOwner().getNome());
        System.out.println("Produtos supervisionados: " + empresa.getProdutos().size());
        System.out.println("Líder registrado na primeira Sprint: " + primeira.getLider().getNome());
    }

    private static void mostrarPapeis(Funcionario funcionario) {
        String papeis = funcionario.getPapeis().stream().map(Papel::getNome)
                .collect(Collectors.joining(", "));
        System.out.println(funcionario.getNome() + ": " + papeis);
    }
}
