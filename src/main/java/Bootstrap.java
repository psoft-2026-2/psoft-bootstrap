import java.time.Instant;
import java.util.Date;

public class Bootstrap {
    public static void main(String[] args) {
        String[] atribuicoesProductOwner = new String[]{"Priorizar o backlog"};
        ProductOwner productOwner = new ProductOwner(atribuicoesProductOwner);
        Pessoa productManager = new Pessoa("Ana", "11111111111", productOwner, null);

        String[] atribuicoesGerente = new String[]{"Gerenciar o time"};
        Gerente funcaoGerente = new Gerente(atribuicoesGerente);
        Pessoa gerente = new Pessoa("Bruno", "22222222222", funcaoGerente, null);

        String[] atribuicoesDev = new String[]{"Desenvolver o produto"};
        Dev funcaoDev = new Dev(atribuicoesDev);
        String[] atribuicoesLider = new String[]{"Conduzir a sprint"};
        Lider lider = new Lider(atribuicoesLider);
        Pessoa dev = new Pessoa("Carla", "33333333333", funcaoDev, lider);

        Produto produto = new Produto("Portal acadêmico", "Sistema para acompanhar disciplinas");
        Instant instanteInicio = Instant.parse("2026-10-01T00:00:00Z");
        Instant instanteFim = Instant.parse("2026-10-15T00:00:00Z");
        Date inicio = Date.from(instanteInicio);
        Date fim = Date.from(instanteFim);
        String cpfLider = dev.getCpf();
        Sprint sprint = new Sprint("Implementar o cadastro de disciplinas", cpfLider, inicio, fim);

        Pessoa[] devs = new Pessoa[]{dev};
        Time time = new Time("Equipe acadêmica", gerente, devs, sprint, produto);
        Time[] times = new Time[0];
        Produto[] produtos = new Produto[0];
        Pessoa[] funcionarios = new Pessoa[]{productManager};
        Empresa empresa = new Empresa("Software UFCG", productManager, times, produtos, funcionarios);

        empresa.contratar(gerente);
        empresa.contratar(dev);
        empresa.cadastrarProduto(produto);
        empresa.adicionarTime(time);

        String[] atribuicoesNovoDev = new String[]{"Testar o cadastro de disciplinas"};
        Dev funcaoNovoDev = new Dev(atribuicoesNovoDev);
        Pessoa novoDev = new Pessoa("Diego", "44444444444", funcaoNovoDev, null);
        empresa.contratar(novoDev);
        time.adicionarDev(novoDev);

        Pessoa liderSprint = time.getLiderSprint();
        String[] atribuicoes = dev.getAtribuicoes();
        String[] atribuicoesLideranca = dev.getAtribuicoesLideranca();

        System.out.println("Empresa: " + empresa.getNome());
        System.out.println("Funcionários: " + empresa.getFuncionarios().length);
        System.out.println("Times: " + empresa.getTimes().length);
        System.out.println("Produtos: " + empresa.getProdutos().length);
        System.out.println("Produto do time: " + time.getProduto().getNome());
        System.out.println("Líder da sprint: " + liderSprint.getNome());
        System.out.println("Objetivo: " + sprint.getObjetivo());
        System.out.println("Duração da sprint: " + sprint.getDuracaoEmDias() + " dias");
        System.out.println("Sprint em andamento no início: " + sprint.estaEmAndamento(inicio));
        System.out.println("Atribuição de desenvolvimento: " + atribuicoes[0]);
        System.out.println("Atribuição de liderança: " + atribuicoesLideranca[0]);
    }
}
