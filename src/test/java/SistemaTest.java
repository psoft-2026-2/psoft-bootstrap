import java.time.LocalDate;
import java.util.List;

public class SistemaTest {
    private static final LocalDate INICIO = LocalDate.of(2026, 10, 1);
    private static int testesExecutados;

    public static void main(String[] args) {
        executar("Liderança temporária acumula os papéis corretos", SistemaTest::liderancaTemporaria);
        executar("Liderança depende de uma Sprint aberta", SistemaTest::liderancaDependeDeSprint);
        executar("Papéis obrigatórios e exclusivos são preservados", SistemaTest::papeisObrigatoriosEExclusivos);
        executar("Liderança alterna entre Sprints consecutivas", SistemaTest::alternanciaEntreSprints);
        executar("Troca de líder valida a participação no time", SistemaTest::trocaDeLider);
        executar("Listas públicas não permitem alterar o domínio", SistemaTest::colecoesImutaveis);
        executar("Histórico da Sprint permanece após uma promoção", SistemaTest::historicoDepoisDaPromocao);
        executar("Promoção a gerente atualiza todas as associações", SistemaTest::promocaoAGerente);
        executar("Líder ativo não pode ser promovido ou removido", SistemaTest::protecaoDoLiderAtivo);
        executar("Promoção a Product Owner exige gerente substituto", SistemaTest::promocaoAProductOwner);
        executar("Empresa e times respeitam suas associações", SistemaTest::associacoesDaEmpresa);
        executar("Falhas ao iniciar Sprint preservam a Sprint atual", SistemaTest::falhasNaoAlteramSprintAtual);
        executar("Remoção libera desenvolvedor para outro time", SistemaTest::remocaoDeDesenvolvedor);
        System.out.println(testesExecutados + " testes passaram.");
    }

    private static void liderancaTemporaria() {
        Cenario cenario = new Cenario();
        Sprint sprint = primeiraSprint(cenario);

        check(cenario.ana.possuiPapel(PapelDesenvolvedor.class), "A líder continua desenvolvedora.");
        check(cenario.ana.possuiPapel(PapelLider.class), "A líder recebe seu papel temporário.");
        check(cenario.ana.getPapeis().size() == 2, "A líder acumula exatamente dois papéis.");
        sprint.definirLider(cenario.ana);
        check(cenario.ana.getPapeis().size() == 2, "Repetir a definição não duplica o papel.");

        sprint.encerrar();
        sprint.encerrar();
        check(sprint.isEncerrada(), "A Sprint deve estar encerrada.");
        check(cenario.time.getSprintAtual() == null, "O time não deve manter uma Sprint atual encerrada.");
        check(!cenario.ana.possuiPapel(PapelLider.class), "A liderança acaba com a Sprint.");
        check(cenario.ana.possuiPapel(PapelDesenvolvedor.class), "A função de desenvolvedora permanece.");
        check(sprint.getLider() == cenario.ana, "O registro de quem liderou deve permanecer.");
    }

    private static void liderancaDependeDeSprint() {
        Funcionario semTime = new Funcionario("Desenvolvedor sem time");
        esperarExcecao(IllegalStateException.class, () -> semTime.adicionarPapel(new PapelLider()));
        check(semTime.getPapeis().size() == 1 && semTime.possuiPapel(PapelDesenvolvedor.class),
                "A tentativa sem time deve preservar apenas o papel de desenvolvedor.");

        Cenario cenario = new Cenario();
        esperarExcecao(IllegalStateException.class, () -> cenario.ana.adicionarPapel(new PapelLider()));
        Sprint sprint = primeiraSprint(cenario);
        esperarExcecao(IllegalStateException.class, () -> cenario.bruno.adicionarPapel(new PapelLider()));
        verificarSprintIntacta(cenario, sprint);

        sprint.encerrar();
        esperarExcecao(IllegalStateException.class, () -> cenario.ana.adicionarPapel(new PapelLider()));
        check(!cenario.ana.possuiPapel(PapelLider.class) && sprint.getLider() == cenario.ana,
                "Uma Sprint encerrada não permite reativar a liderança nem perde seu histórico.");
    }

    private static void papeisObrigatoriosEExclusivos() {
        Funcionario desenvolvedor = new Funcionario("Ana");
        esperarExcecao(IllegalArgumentException.class,
                () -> desenvolvedor.removerPapel(new PapelDesenvolvedor()));
        esperarExcecao(IllegalArgumentException.class,
                () -> desenvolvedor.adicionarPapel(new PapelGerente()));
        check(desenvolvedor.getPapeis().size() == 1
                && desenvolvedor.possuiPapel(PapelDesenvolvedor.class),
                "Operações inválidas não podem remover ou acrescentar papéis.");

        Funcionario gerente = new Funcionario("Carla", new PapelGerente());
        esperarExcecao(IllegalArgumentException.class, () -> gerente.adicionarPapel(new PapelDesenvolvedor()));
        esperarExcecao(IllegalArgumentException.class, () -> gerente.adicionarPapel(new PapelLider()));
        esperarExcecao(IllegalArgumentException.class, () -> new Funcionario("Líder", new PapelLider()));
        check(gerente.getPapeis().size() == 1 && gerente.possuiPapel(PapelGerente.class),
                "A gerência deve continuar exclusiva.");
    }

    private static void alternanciaEntreSprints() {
        Cenario cenario = new Cenario();
        Sprint primeira = primeiraSprint(cenario);
        esperarExcecao(IllegalArgumentException.class,
                () -> cenario.time.iniciarSprint(2, INICIO.plusDays(7), INICIO.plusDays(13), cenario.ana));
        verificarSprintIntacta(cenario, primeira);

        Sprint segunda = cenario.time.iniciarSprint(2, INICIO.plusDays(7), INICIO.plusDays(13), cenario.bruno);
        check(primeira.isEncerrada(), "A nova Sprint encerra a anterior.");
        check(!cenario.ana.possuiPapel(PapelLider.class), "A antiga líder perde o papel temporário.");
        check(cenario.bruno.possuiPapel(PapelLider.class), "O novo líder recebe o papel temporário.");

        Sprint terceira = cenario.time.iniciarSprint(3, INICIO.plusDays(14), INICIO.plusDays(20), cenario.ana);
        check(segunda.isEncerrada() && terceira.getLider() == cenario.ana,
                "Ana pode liderar novamente depois de Bruno.");
        esperarExcecao(IllegalArgumentException.class, () -> terceira.definirLider(cenario.bruno));
        check(terceira.getLider() == cenario.ana && cenario.ana.possuiPapel(PapelLider.class),
                "Uma troca inválida não altera a liderança atual.");
        check(!cenario.bruno.possuiPapel(PapelLider.class), "Bruno não deve recuperar o papel após a falha.");
        check(cenario.time.getSprints().equals(List.of(primeira, segunda, terceira)),
                "O histórico deve preservar a ordem das três Sprints.");
    }

    private static void trocaDeLider() {
        Cenario cenario = new Cenario();
        Sprint sprint = primeiraSprint(cenario);
        Funcionario externo = new Funcionario("Desenvolvedor externo");
        esperarExcecao(IllegalArgumentException.class, () -> sprint.definirLider(externo));
        esperarExcecao(IllegalArgumentException.class, () -> sprint.definirLider(cenario.gerente));
        verificarSprintIntacta(cenario, sprint);
        check(!externo.possuiPapel(PapelLider.class), "O externo não pode receber o papel de líder.");

        sprint.definirLider(cenario.bruno);
        check(sprint.getLider() == cenario.bruno && cenario.bruno.possuiPapel(PapelLider.class),
                "A liderança pode passar a outro desenvolvedor do time.");
        check(!cenario.ana.possuiPapel(PapelLider.class)
                && cenario.ana.possuiPapel(PapelDesenvolvedor.class),
                "A antiga líder deve voltar a exercer apenas desenvolvimento.");
    }

    private static void colecoesImutaveis() {
        Cenario cenario = new Cenario();
        Empresa empresa = new Empresa("Empresa", novoProductOwner("PO"));
        empresa.adicionarProduto(cenario.produto);
        primeiraSprint(cenario);

        esperarExcecao(UnsupportedOperationException.class, () -> cenario.ana.getPapeis().clear());
        esperarExcecao(UnsupportedOperationException.class, () -> cenario.time.getDesenvolvedores().clear());
        esperarExcecao(UnsupportedOperationException.class, () -> cenario.time.getSprints().clear());
        esperarExcecao(UnsupportedOperationException.class, () -> empresa.getProdutos().clear());
        for (Papel papel : List.of(new PapelDesenvolvedor(), new PapelLider(),
                new PapelGerente(), new PapelProductOwner())) {
            esperarExcecao(UnsupportedOperationException.class, () -> papel.getResponsabilidades().clear());
        }
        check(cenario.ana.getPapeis().size() == 2 && cenario.time.getDesenvolvedores().size() == 2
                && cenario.time.getSprints().size() == 1 && empresa.getProdutos().size() == 1,
                "As tentativas de alterar as listas não podem modificar o domínio.");
    }

    private static void historicoDepoisDaPromocao() {
        Cenario cenario = new Cenario();
        Sprint sprint = primeiraSprint(cenario);
        sprint.encerrar();
        cenario.ana.promover(new PromocaoGerente());

        check(sprint.getLider() == cenario.ana && sprint.isEncerrada(),
                "O histórico mantém a mesma pessoa mesmo após mudar de função.");
        check(cenario.ana.possuiPapel(PapelGerente.class)
                && !cenario.ana.possuiPapel(PapelLider.class)
                && !cenario.ana.possuiPapel(PapelDesenvolvedor.class),
                "A promoção não deve reativar papéis históricos.");
        esperarExcecao(IllegalStateException.class, () -> sprint.definirLider(cenario.bruno));
        check(sprint.getLider() == cenario.ana, "Uma Sprint encerrada não pode ter sua liderança reescrita.");
    }

    private static void promocaoAGerente() {
        Cenario cenario = new Cenario();
        Sprint sprint = primeiraSprint(cenario);
        cenario.bruno.promover(new PromocaoGerente());

        check(cenario.time.getGerente() == cenario.bruno && cenario.produto.getGerente() == cenario.bruno,
                "Time e produto devem apontar para o novo gerente.");
        check(cenario.bruno.getTime() == cenario.time && cenario.gerente.getTime() == null,
                "O novo gerente permanece no time e o anterior fica desvinculado.");
        check(cenario.time.getDesenvolvedores().equals(List.of(cenario.ana)),
                "O promovido deve sair da equipe de desenvolvedores.");
        check(cenario.bruno.getPapeis().size() == 1 && cenario.bruno.possuiPapel(PapelGerente.class),
                "O promovido assume exclusivamente a gerência.");
        check(cenario.time.getSprintAtual() == sprint && sprint.getLider() == cenario.ana && !sprint.isEncerrada(),
                "A promoção de outro desenvolvedor não altera a Sprint ativa.");
    }

    private static void protecaoDoLiderAtivo() {
        Cenario cenario = new Cenario();
        Sprint sprint = primeiraSprint(cenario);
        esperarExcecao(IllegalStateException.class, () -> cenario.ana.promover(new PromocaoGerente()));
        esperarExcecao(IllegalStateException.class, () -> cenario.time.removerDesenvolvedor(cenario.ana));
        esperarExcecao(IllegalStateException.class, () -> cenario.ana.removerPapel(new PapelLider()));

        verificarSprintIntacta(cenario, sprint);
        check(cenario.time.getGerente() == cenario.gerente && cenario.produto.getGerente() == cenario.gerente,
                "A promoção recusada não pode substituir o gerente.");
        check(cenario.gerente.getTime() == cenario.time && cenario.ana.getTime() == cenario.time,
                "As associações devem permanecer após as tentativas inválidas.");
        check(cenario.time.getDesenvolvedores().contains(cenario.ana) && cenario.ana.getPapeis().size() == 2,
                "A líder ativa deve continuar na equipe com ambos os papéis.");
    }

    private static void promocaoAProductOwner() {
        Cenario cenario = new Cenario();
        Funcionario poAnterior = novoProductOwner("PO anterior");
        Empresa empresa = new Empresa("Empresa", poAnterior);
        empresa.adicionarProduto(cenario.produto);
        Promocao promocao = new PromocaoProductOwner();

        esperarExcecao(IllegalArgumentException.class, () -> cenario.ana.promover(promocao));
        esperarExcecao(IllegalStateException.class, () -> cenario.gerente.promover(promocao));
        check(cenario.gerente.possuiPapel(PapelGerente.class) && cenario.time.getGerente() == cenario.gerente,
                "Uma promoção recusada deve manter a gerência preenchida.");
        check(cenario.ana.possuiPapel(PapelDesenvolvedor.class), "Desenvolvedor não pode pular a gerência.");

        Funcionario substituto = new Funcionario("Nova gerente", new PapelGerente());
        cenario.time.definirGerente(substituto);
        cenario.gerente.promover(promocao);
        empresa.definirProductOwner(cenario.gerente);

        check(cenario.gerente.getPapeis().size() == 1 && cenario.gerente.possuiPapel(PapelProductOwner.class),
                "O gerente promovido deve exercer somente o papel de Product Owner.");
        check(empresa.getProductOwner() == cenario.gerente && cenario.time.getGerente() == substituto,
                "A empresa recebe o novo PO e o time mantém seu substituto.");
        check(cenario.produto.getGerente() == substituto && substituto.getTime() == cenario.time,
                "A substituição precisa manter os vínculos entre produto, time e gerente.");
        esperarExcecao(IllegalArgumentException.class, () -> empresa.definirProductOwner(cenario.ana));
        check(empresa.getProductOwner() == cenario.gerente, "Uma definição inválida não remove o PO atual.");
    }

    private static void associacoesDaEmpresa() {
        Cenario cenario = new Cenario();
        Funcionario po = novoProductOwner("PO");
        Empresa empresa = new Empresa("Empresa", po);
        Produto segundoProduto = new Produto("Aplicativo", "Aplicativo móvel");
        Funcionario outraGerente = new Funcionario("Outra gerente", new PapelGerente());
        Time outroTime = new Time("Time móvel", segundoProduto, outraGerente);
        empresa.adicionarProduto(cenario.produto);
        empresa.adicionarProduto(segundoProduto);
        empresa.adicionarProduto(cenario.produto);

        check(empresa.getProdutos().size() == 2 && empresa.getProductOwner() == po,
                "Uma empresa deve ter um único PO e aceitar vários produtos sem duplicatas.");
        check(cenario.produto.getEmpresa() == empresa && segundoProduto.getEmpresa() == empresa,
                "Os produtos devem conhecer sua empresa.");
        check(cenario.produto.getTime() == cenario.time && outroTime.getProduto() == segundoProduto,
                "Os vínculos entre cada produto e seu time devem ser recíprocos.");

        Funcionario gerenteLivre = new Funcionario("Gerente livre", new PapelGerente());
        esperarExcecao(IllegalArgumentException.class,
                () -> new Time("Time duplicado", cenario.produto, gerenteLivre));
        check(cenario.produto.getTime() == cenario.time && gerenteLivre.getTime() == null,
                "A tentativa de duplicar o time não pode modificar os vínculos existentes.");
        esperarExcecao(IllegalArgumentException.class, () -> outroTime.adicionarDesenvolvedor(cenario.ana));
        esperarExcecao(IllegalArgumentException.class, () -> outroTime.definirGerente(cenario.gerente));
        check(cenario.ana.getTime() == cenario.time && outroTime.getGerente() == outraGerente,
                "Funcionários não podem integrar dois times simultaneamente.");

        Empresa outraEmpresa = new Empresa("Outra empresa", novoProductOwner("Outro PO"));
        esperarExcecao(IllegalArgumentException.class, () -> outraEmpresa.adicionarProduto(cenario.produto));
        esperarExcecao(IllegalStateException.class,
                () -> empresa.adicionarProduto(new Produto("Sem time", "Ainda não possui responsável")));
        check(outraEmpresa.getProdutos().isEmpty() && cenario.produto.getEmpresa() == empresa
                && empresa.getProdutos().size() == 2,
                "Falhas de cadastro não podem transferir ou adicionar produtos.");
    }

    private static void falhasNaoAlteramSprintAtual() {
        Cenario cenario = new Cenario();
        Sprint atual = primeiraSprint(cenario);
        List<Runnable> tentativasInvalidas = List.of(
                () -> cenario.time.iniciarSprint(0, INICIO.plusDays(7), INICIO.plusDays(13), cenario.bruno),
                () -> cenario.time.iniciarSprint(1, INICIO.plusDays(7), INICIO.plusDays(13), cenario.bruno),
                () -> cenario.time.iniciarSprint(2, INICIO.plusDays(13), INICIO.plusDays(7), cenario.bruno),
                () -> cenario.time.iniciarSprint(2, INICIO.plusDays(6), INICIO.plusDays(13), cenario.bruno),
                () -> cenario.time.iniciarSprint(2, INICIO.plusDays(7), INICIO.plusDays(13), new Funcionario("Externo")),
                () -> cenario.time.iniciarSprint(2, INICIO.plusDays(7), INICIO.plusDays(13), cenario.gerente),
                () -> cenario.time.iniciarSprint(2, INICIO.plusDays(7), INICIO.plusDays(13), cenario.ana));

        for (Runnable tentativa : tentativasInvalidas) {
            esperarExcecao(IllegalArgumentException.class, tentativa);
            verificarSprintIntacta(cenario, atual);
        }
        Sprint proxima = cenario.time.iniciarSprint(2, INICIO.plusDays(7), INICIO.plusDays(13), cenario.bruno);
        check(cenario.time.getSprintAtual() == proxima && atual.isEncerrada(),
                "Depois das falhas, uma Sprint válida ainda deve iniciar normalmente.");
    }

    private static void remocaoDeDesenvolvedor() {
        Cenario cenario = new Cenario();
        primeiraSprint(cenario);
        cenario.time.removerDesenvolvedor(cenario.bruno);
        check(cenario.bruno.getTime() == null && !cenario.time.getDesenvolvedores().contains(cenario.bruno),
                "A remoção deve atualizar os dois lados da associação.");

        Produto produto = new Produto("Outro produto", "Descrição");
        Time outroTime = new Time("Outro time", produto, new Funcionario("Gerente", new PapelGerente()));
        outroTime.adicionarDesenvolvedor(cenario.bruno);
        outroTime.adicionarDesenvolvedor(cenario.bruno);
        check(cenario.bruno.getTime() == outroTime && outroTime.getDesenvolvedores().size() == 1,
                "O funcionário removido pode entrar em outro time, sem duplicar seu cadastro.");
        esperarExcecao(IllegalArgumentException.class, () -> cenario.time.getSprintAtual().definirLider(cenario.bruno));
    }

    private static Sprint primeiraSprint(Cenario cenario) {
        return cenario.time.iniciarSprint(1, INICIO, INICIO.plusDays(6), cenario.ana);
    }

    private static Funcionario novoProductOwner(String nome) {
        return new Funcionario(nome, new PapelProductOwner());
    }

    private static void verificarSprintIntacta(Cenario cenario, Sprint sprint) {
        check(cenario.time.getSprintAtual() == sprint && !sprint.isEncerrada(),
                "A Sprint atual deve permanecer aberta e inalterada.");
        check(cenario.time.getSprints().equals(List.of(sprint)),
                "Uma tentativa inválida não pode acrescentar itens ao histórico.");
        check(sprint.getLider() == cenario.ana && cenario.ana.possuiPapel(PapelLider.class)
                && cenario.ana.possuiPapel(PapelDesenvolvedor.class)
                && !cenario.bruno.possuiPapel(PapelLider.class),
                "A liderança e os papéis devem permanecer após uma falha.");
    }

    private static void executar(String descricao, Runnable teste) {
        teste.run();
        testesExecutados++;
        System.out.println("OK: " + descricao);
    }

    private static void check(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }

    private static void esperarExcecao(Class<? extends Throwable> tipo, Runnable acao) {
        try {
            acao.run();
        } catch (Throwable erro) {
            if (tipo.isInstance(erro)) {
                return;
            }
            throw new AssertionError("Esperada " + tipo.getSimpleName()
                    + ", recebida " + erro.getClass().getSimpleName() + ".", erro);
        }
        throw new AssertionError("Esperada " + tipo.getSimpleName() + ", mas nenhuma exceção foi lançada.");
    }

    private static final class Cenario {
        private final Produto produto = new Produto("Sistema", "Produto de software");
        private final Funcionario gerente = new Funcionario("Carla", new PapelGerente());
        private final Funcionario ana = new Funcionario("Ana");
        private final Funcionario bruno = new Funcionario("Bruno");
        private final Time time = new Time("Time principal", produto, gerente);

        private Cenario() {
            time.adicionarDesenvolvedor(ana);
            time.adicionarDesenvolvedor(bruno);
        }
    }
}
