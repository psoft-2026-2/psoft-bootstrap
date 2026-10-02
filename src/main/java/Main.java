
import java.time.LocalDate;

//main feito por llm para testar o código mais rápido
public class Main {

    public static void main(String[] args) {
        Empresa empresa = new Empresa("TechCorp");

        // Cria produto e time
        Produto app = new Produto("App de Vendas", "Aplicativo de vendas online");
        Time time = new Time("Time Alpha", app);
        empresa.adicionarTime(time);

        // Cria dois desenvolvedores
        Colaborador ana = new Colaborador("Ana");
        ana.adicionaPapel(new Desenvolvedor());
        Colaborador bruno = new Colaborador("Bruno");
        bruno.adicionaPapel(new Desenvolvedor());
        time.adicionarColaborador(ana);
        time.adicionarColaborador(bruno);

        System.out.println("== Equipe inicial do " + time.getNome()
                + " (produto: " + time.getProduto().getNome() + ") ==");
        System.out.println(ana);
        System.out.println(bruno);

        // --- Sprint: Ana assume TEMPORARIAMENTE o papel de lider, acumulando com o de dev ---
        Sprint s1 = time.iniciarSprint(LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 15));
        ana.adicionaPapel(new Lider());      // acumula: Desenvolvedor + Lider
        s1.definirLider(ana);
        System.out.println("\n== Sprint " + s1.getNumero() + " ("
                + s1.getInicio() + " a " + s1.getFim() + ") ==");
        System.out.println("Durante a sprint: " + ana);
        System.out.println("Lider definido: " + s1.getLider().getNome());

        // Fim da sprint: Ana deixa de ser lider e volta a ser so desenvolvedora
        ana.removePapel(Lider.class);
        System.out.println("Apos a sprint:    " + ana);

        // --- Promocao: Bruno (dev) e promovido a Gerente, assumindo EXCLUSIVAMENTE essa funcao ---
        bruno.promoveColab(new Gerente());
        time.definirGerente(bruno);
        System.out.println("\n== Promocoes ==");
        System.out.println("Gerente do time:  " + bruno);

        // --- Promocao: o Gerente e promovido a Product Owner ---
        bruno.promoveColab(new ProductOwner());
        empresa.definirProductOwner(bruno);
        System.out.println("Product Owner:    " + bruno);

        // --- Limitacoes: Ana (so desenvolvedora) nao pode ser gerente nem lider sem o papel ---
        System.out.println("\n== Validacao das limitacoes ==");
        try {
            time.definirGerente(ana);
        } catch (IllegalArgumentException e) {
            System.out.println("Bloqueado: " + e.getMessage());
        }

        Sprint s2 = time.iniciarSprint(LocalDate.of(2026, 10, 16), LocalDate.of(2026, 10, 31));
        try {
            s2.definirLider(ana);            // Ana nao tem mais o papel de Lider
        } catch (IllegalArgumentException e) {
            System.out.println("Bloqueado: " + e.getMessage());
        }
    }
}
